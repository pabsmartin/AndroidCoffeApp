package es.deusto.coffe_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import es.deusto.coffe_app.objects.Coffee;
import es.deusto.coffe_app.objects.Ticket;

public class SQLiteTicketHelper extends SQLiteOpenHelper{

    // Database name and version
    private static final String DATABASE_NAME = "tickets.db";
    private static final int DATABASE_VERSION = 1;

    // Table and columns names (_id is required as primary key)
    public static final String TABLE_TICKETS = "tickets";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_MOOD = "mood";
    private static final String COLUMN_PRODUCTIVITY = "productivity";

    private final SimpleDateFormat dateFormat;

    // SQL sentence to create the tables
    private static final String DATABASE_CREATE = "create table "
            + TABLE_TICKETS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_DATE
            + " date not null, " + COLUMN_MOOD
            + " integer not null, " + COLUMN_PRODUCTIVITY
            + " integer not null );";

    private static final String DATABASE_CLEAR = "DROP TABLE "+TABLE_TICKETS+";";

    public SQLiteTicketHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.dateFormat = new SimpleDateFormat("dd MMMM yyyy");
    }


    // Executed when creating the DB for first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    // Executed when upgrading to a new version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("StudentDatabase", "Upgrading database from version " + oldVersion + " to " + newVersion + ", deleting old data, creating empty table.");
        onCreate(db);
    }

    // Convenience method to store a student in the database
    public void putTicket(Ticket ticket) throws ParseException {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_DATE, dateFormat.format(ticket.getRegistryDate()));
        values.put(COLUMN_MOOD, ticket.getMood());
        values.put(COLUMN_PRODUCTIVITY, ticket.getProductivity());

        db.insert(TABLE_TICKETS, null, values);
        db.close();
    }

    // Convenience method to retrieve all the students from the database
    public ArrayList<Ticket> getTickets() throws ParseException {
        ArrayList<Ticket> as = new ArrayList<Ticket>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID,COLUMN_MOOD, COLUMN_PRODUCTIVITY, COLUMN_DATE};

        Cursor cursor = db.query(
                TABLE_TICKETS, columns,
                null, null, null, null, COLUMN_DATE+" DESC");

        cursor.moveToNext();
        while(!cursor.isAfterLast()){
            int idCol = cursor.getColumnIndex(COLUMN_ID);
            int moodCol = cursor.getColumnIndex(COLUMN_MOOD);
            int prodCol = cursor.getColumnIndex(COLUMN_PRODUCTIVITY);
            int dateCol = cursor.getColumnIndex(COLUMN_DATE);

            int id = cursor.getInt(idCol);
            int mood = cursor.getInt(moodCol);
            int prod = cursor.getInt(prodCol);
            String date = cursor.getString(dateCol);

            as.add(new Ticket(new ArrayList<Coffee>(), mood, prod, dateFormat.parse(date), id));
            cursor.moveToNext();
        }
        return as;
    }
}