package es.deusto.coffe_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.ParseException;
import java.util.ArrayList;

public class SQLiteCoffeeHelper extends SQLiteOpenHelper{

    // Database name and version
    private static final String DATABASE_NAME = "tickets.db";
    private static final int DATABASE_VERSION = 1;

    // Table and columns names (_id is required as primary key)
    private static final String TABLE_COFFEES = "coffees";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SIZE = "size";
    private static final String COLUMN_AMOUNT = "amount";
    private static final String COLUMN_TICKET_ID = "ticket";


    // SQL sentence to create the tables
    public static final String DATABASE_CREATE = "create table "
            + TABLE_COFFEES + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_SIZE
            + " int not null, " + COLUMN_AMOUNT
            + " integer not null," + COLUMN_TICKET_ID
            + " integer not null);";

    public SQLiteCoffeeHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        super.onDowngrade(db, oldVersion, newVersion);
        db.setVersion(oldVersion);
    }


    // Convenience method to store a student in the database
    public void putCoffee(Coffee coffee) throws ParseException {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_AMOUNT, coffee.getAmount());
        values.put(COLUMN_SIZE, coffee.getSize());
        values.put(COLUMN_TICKET_ID, coffee.getTicketId());

        db.insert(TABLE_COFFEES, null, values);
    }

    // Convenience method to retrieve all the students from the database
    public ArrayList<Coffee> getCoffee() throws ParseException {
        ArrayList<Coffee> as = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_COFFEES,
                new String[]{COLUMN_AMOUNT, COLUMN_SIZE, COLUMN_TICKET_ID},
                null,
                null,
                null,
                null,
                null);

        cursor.moveToNext();
        while(!cursor.isAfterLast()){
            int sizeCol = cursor.getColumnIndex(COLUMN_SIZE);
            int amountCol = cursor.getColumnIndex(COLUMN_AMOUNT);
            int ticketIdCol = cursor.getColumnIndex(COLUMN_TICKET_ID);

            int size = cursor.getInt(sizeCol);
            int amount = cursor.getInt(amountCol);
            int tId = cursor.getInt(ticketIdCol);

            as.add(new Coffee(size, amount, tId));

            cursor.moveToNext();
        }
        return as;
    }

    public ArrayList<Coffee> getCofeesForTicket(int ticketId) throws ParseException {
        ArrayList<Coffee> as = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_COFFEES,
                new String[]{COLUMN_AMOUNT, COLUMN_SIZE, COLUMN_TICKET_ID},
                COLUMN_TICKET_ID + "= ?",
                new String[]{ String.valueOf(ticketId) },
                null,
                null,
                null);

        cursor.moveToNext();
        while(!cursor.isAfterLast()){
            int sizeCol = cursor.getColumnIndex(COLUMN_SIZE);
            int amountCol = cursor.getColumnIndex(COLUMN_AMOUNT);
            int ticketIdCol = cursor.getColumnIndex(COLUMN_TICKET_ID);

            int size = cursor.getInt(sizeCol);
            int amount = cursor.getInt(amountCol);
            int tId = cursor.getInt(ticketIdCol);

            as.add(new Coffee(size, amount, tId));

            cursor.moveToNext();
        }
        return as;
    }
}