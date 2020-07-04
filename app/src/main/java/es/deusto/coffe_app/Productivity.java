package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Productivity extends Activity {

    private static final String TAG = Productivity.class.getName();

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
        ticket = intent.getExtras().getParcelable("ticket");

        Log.d(TAG,"productivity -- "+ticket.toString());

        coffees = intent.getExtras().getParcelableArrayList("coffees");

        Log.d(TAG,"productivity -- "+coffees);


        veryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), Mood.class);

                ticket.setProductivity(2);

                moodActivityIntent.putExtra("ticket", ticket);
                moodActivityIntent.putExtra("coffees", coffees);

                startActivity(moodActivityIntent);
            }
        });

        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), Mood.class);

                ticket.setProductivity(1);

                moodActivityIntent.putExtra("ticket", ticket);
                moodActivityIntent.putExtra("coffees", coffees);

                startActivity(moodActivityIntent);
            }
        });

        littleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), Mood.class);

                ticket.setProductivity(0);

                moodActivityIntent.putExtra("ticket", ticket);
                moodActivityIntent.putExtra("coffees", coffees);

                startActivity(moodActivityIntent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anotherOneActivityIntent = new Intent(getApplicationContext(), AnotherOne.class);

                anotherOneActivityIntent.putExtra("ticket", ticket);
                anotherOneActivityIntent.putExtra("coffees", coffees);

                startActivity(anotherOneActivityIntent);
            }
        });
    }
}