package es.deusto.coffe_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


public class ConfirmDeny extends Activity {

    private static final String TAG = ConfirmDeny.class.getName();
//
    private static final String ACTION_UPDATE_NOTIFICATION = "es.deusto.coffe_app.ACTION_UPDATE_NOTIFICATION";
    private static final String PRIMARY_CHANNEL = "primary_notification_channel";
//    private static int NOTIFICATION_ID = 0;

    private NotificationManager notificationManager;

    private Button confirmBtn, denyBtn, backBtn;

    private Ticket ticket;
    private ArrayList<Coffee> coffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_deny);

        confirmBtn = findViewById(R.id.btn_accept);
        denyBtn = findViewById(R.id.btn_deny);
        backBtn = findViewById(R.id.btn_back_from_confirm_deny);

        Intent intent = getIntent();

        ticket = intent.getExtras().getParcelable("ticket");
        Log.d(TAG, "ticket -- "+ticket.toString());

        coffees = intent.getExtras().getParcelableArrayList("coffees");
        Log.d(TAG, "coffees -- "+coffees);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*      GESTIÓN DE BASE DE DATOS        */
                SQLiteTicketHelper ticketHelper = new SQLiteTicketHelper(getApplicationContext());
                SQLiteCoffeeHelper coffeeHelper = new SQLiteCoffeeHelper(getApplicationContext());


                try {
                    ticket.setRegistryDate(new Date());
                    ticketHelper.putTicket(ticket);

                    int id = ticketHelper.getTickets().get(ticketHelper.getTickets().size()-1).getId();

                    for(Coffee c : coffees)
                    {
                        c.setTicketId(id);
                        coffeeHelper.putCoffee(c);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                createNotificationChannel();
//                sendNotification();

                Intent intent = new Intent(getApplicationContext(), OverallView.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(ConfirmDeny.this, 0, intent, 0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(ConfirmDeny.this, "0")
                        .setSmallIcon(R.drawable.ic_baseline_emoji_food_beverage_24)
                        .setContentTitle(getString(R.string.notification_title))
                        .setContentText(getString(R.string.notification_greeting_msg))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(ConfirmDeny.this);

                // notificationId is a unique int for each notification that you must define
                notificationManager.notify(0, builder.build());

                // no es necesario añadir extras porque se recuperan en la siguiente actividad a través del acceso a bd
                Intent overallActivityIntent = new Intent(getApplicationContext(), OverallView.class);
                startActivity(overallActivityIntent);

            }
        });

        denyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "DENIED");

                new AlertDialog.Builder(ConfirmDeny.this)
                        .setTitle("Are you sure?")
                        .setMessage("Are you sure you want to cancel this registry?")

                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                            // CANCELA GUARDAR
                            public void onClick(DialogInterface dialog, int which) {
                                new AlertDialog.Builder(ConfirmDeny.this)
                                        .setTitle("Now what?")
                                        .setMessage("What do you want to do next?")

                                        // a landing
                                        .setPositiveButton(R.string.go_to_landing_activity, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent landingActivityIntent = new Intent(getApplicationContext(), LandingActivity.class);
                                                startActivity(landingActivityIntent);
                                            }
                                        })
                                        // a overall view
                                        .setNegativeButton(R.string.go_to_overall_view, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent overallActivityIntent = new Intent(getApplicationContext(), OverallView.class);

                                                overallActivityIntent.putExtra("ticket", ticket);
                                                overallActivityIntent.putExtra("coffees", coffees);

                                                startActivity(overallActivityIntent);
                                            }
                                        })
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();

                            }
                        })

                        // ACEPTA GUARDAR.
                        .setNegativeButton(R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), AnotherOne.class);
                startActivity(moodActivityIntent);

            }
        });
    }


    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = PRIMARY_CHANNEL;

            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("0", name, importance);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

//    public NotificationCompat.Builder getNotificationBuilder() {
//        Intent notificationIntent = new Intent(ConfirmDeny.this, OverallView.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(ConfirmDeny.this, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat
//                .Builder(this, PRIMARY_CHANNEL)
//                .setContentTitle("New notification!")
//                .setSmallIcon(R.drawable.ic_launcher_foreground)
//                .setAutoCancel(true)
//                .setContentIntent(pendingIntent)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setDefaults(NotificationCompat.DEFAULT_ALL);
//        return notificationBuilder;
//    }
//
//    public void sendNotification(){
//
//        NotificationCompat.Builder notBuilder = getNotificationBuilder();
//
//        notBuilder.notify();
//
//    }
}