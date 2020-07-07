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

public class ProductivityActivity extends Activity {

    private static final String TAG = ProductivityActivity.class.getName();

    private Button veryBtn, normalBtn, littleBtn, backBtn;

    private Ticket ticket;
    private ArrayList<Coffee> coffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productivity);

        veryBtn = findViewById(R.id.btn_very_prod);
        normalBtn = findViewById(R.id.btn_normal_prod);
        littleBtn = findViewById(R.id.btn_not_prod);
        backBtn = findViewById(R.id.btn_back_from_prod);

        Intent intent = getIntent();

        Ticket auxTicket = intent.getExtras().getParcelable("ticket");
        if(auxTicket != null )
            ticket = auxTicket;
        else
            ticket = new Ticket();

        Log.d(TAG,"ticket -- "+ticket.toString());

        coffees = intent.getExtras().getParcelableArrayList("coffees");
        Log.d(TAG,"coffees -- "+coffees);


        veryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), MoodActivity.class);

                ticket.setProductivity(2);

                moodActivityIntent.putExtra("ticket", ticket);
                moodActivityIntent.putExtra("coffees", coffees);

                startActivity(moodActivityIntent);
            }
        });

        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), MoodActivity.class);

                ticket.setProductivity(1);

                moodActivityIntent.putExtra("ticket", ticket);
                moodActivityIntent.putExtra("coffees", coffees);

                startActivity(moodActivityIntent);
            }
        });

        littleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), MoodActivity.class);

                ticket.setProductivity(0);

                moodActivityIntent.putExtra("ticket", ticket);
                moodActivityIntent.putExtra("coffees", coffees);

                startActivity(moodActivityIntent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anotherOneActivityIntent = new Intent(getApplicationContext(), AnotherOneActivity.class);

                anotherOneActivityIntent.putExtra("coffees", coffees);

                startActivity(anotherOneActivityIntent);
            }
        });
    }
}