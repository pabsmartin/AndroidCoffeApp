package es.deusto.coffe_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import static android.util.Log.*;

public class ConfirmDeny extends Activity {

    private static final String TAG = ConfirmDeny.class.getName();

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

        Log.d(TAG, "confirm -- "+ticket.toString());

        coffees = intent.getExtras().getParcelableArrayList("coffees");

        Log.d(TAG, "confirm -- "+coffees);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*      GESTIÓN DE BASE DE DATOS        */

            // no es necesario añadir extras porque se recuperan en la siguiente actividad a través del acceso a bd
            Intent anotherOneActivityIntent = new Intent(getApplicationContext(), OverallView.class);

            anotherOneActivityIntent.putExtra("coffees", coffees);

            startActivity(anotherOneActivityIntent);
            }
        });

        denyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "DENIED");

                new AlertDialog.Builder(ConfirmDeny.this)
                        .setTitle("Are you sure?")
                        .setMessage("Are you sure you want to cancel this registry?")

                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

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

                                                overallActivityIntent.putExtra("coffees", coffees);

                                                startActivity(overallActivityIntent);
                                            }
                                        })
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();

                            }
                        })

                        // ACEPTA GUARDAR.
                        .setNegativeButton(android.R.string.no, null)
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
}