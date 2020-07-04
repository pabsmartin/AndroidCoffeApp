package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;

public class Mood extends Activity {

    private static final String TAG = Mood.class.getName();

    private Button happyMoodBtn, neutralMoodBtn, sadMoodBtn, backFromMood;

    private Ticket ticket;
    private ArrayList<Coffee> coffees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        happyMoodBtn = findViewById(R.id.btn_happy_mood);
        neutralMoodBtn = findViewById(R.id.btn_neutral_mood);
        sadMoodBtn = findViewById(R.id.btn_sad_mood);
        backFromMood = findViewById(R.id.btn_back_from_mood);

        Intent intent = getIntent();
        ticket = intent.getExtras().getParcelable("ticket");

        Log.d(TAG,"amount -- "+ticket.toString());

        coffees = intent.getExtras().getParcelableArrayList("coffees");

        Log.d(TAG,"amount -- "+coffees);

        happyMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDeny.class);

                ticket.setMood(2);

                confirmDenyActivityIntent.putExtra("ticket", ticket);
                confirmDenyActivityIntent.putExtra("coffees", coffees);

                startActivity(confirmDenyActivityIntent);
            }
        });

        neutralMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDeny.class);

                ticket.setMood(1);

                confirmDenyActivityIntent.putExtra("ticket", ticket);
                confirmDenyActivityIntent.putExtra("coffees", coffees);

                startActivity(confirmDenyActivityIntent);
            }
        });

        sadMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDeny.class);

                ticket.setMood(0);

                confirmDenyActivityIntent.putExtra("ticket", ticket);
                confirmDenyActivityIntent.putExtra("coffees", coffees);

                startActivity(confirmDenyActivityIntent);
            }
        });

        backFromMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productivityActivityIntent = new Intent(getApplicationContext(), Productivity.class);

                ticket.setMood(2);

                productivityActivityIntent.putExtra("ticket", ticket);
                productivityActivityIntent.putExtra("coffees", coffees);

                startActivity(productivityActivityIntent);
            }
        });
    }
}