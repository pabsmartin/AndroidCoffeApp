package es.deusto.coffe_app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import es.deusto.coffe_app.R;
import es.deusto.coffe_app.objects.Coffee;
import es.deusto.coffe_app.objects.Ticket;

public class MoodActivity extends Activity {

    private static final String TAG = MoodActivity.class.getName();

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
        Log.d(TAG,"ticket -- "+ticket.toString());

        coffees = intent.getExtras().getParcelableArrayList("coffees");
        Log.d(TAG,"coffees -- "+coffees);

        happyMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDenyActivity.class);

                ticket.setMood(2);

                confirmDenyActivityIntent.putExtra("ticket", ticket);
                confirmDenyActivityIntent.putExtra("coffees", coffees);

                startActivity(confirmDenyActivityIntent);
            }
        });

        neutralMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDenyActivity.class);

                ticket.setMood(1);

                confirmDenyActivityIntent.putExtra("ticket", ticket);
                confirmDenyActivityIntent.putExtra("coffees", coffees);

                startActivity(confirmDenyActivityIntent);
            }
        });

        sadMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDenyActivity.class);

                ticket.setMood(0);

                confirmDenyActivityIntent.putExtra("ticket", ticket);
                confirmDenyActivityIntent.putExtra("coffees", coffees);

                startActivity(confirmDenyActivityIntent);
            }
        });

        backFromMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productivityActivityIntent = new Intent(getApplicationContext(), ProductivityActivity.class);

                ticket.setMood(2);

                productivityActivityIntent.putExtra("ticket", ticket);
                productivityActivityIntent.putExtra("coffees", coffees);

                startActivity(productivityActivityIntent);
            }
        });
    }
}