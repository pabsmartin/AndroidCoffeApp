package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.prefs.BackingStoreException;

public class Mood extends AppCompatActivity {

    Button happyMoodBtn, neutralMoodBtn, sadMoodBtn, backFromMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        happyMoodBtn = findViewById(R.id.btn_happy_mood);
        neutralMoodBtn = findViewById(R.id.btn_neutral_mood);
        sadMoodBtn = findViewById(R.id.btn_sad_mood);
        backFromMood = findViewById(R.id.btn_back_from_mood);

        happyMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("HAPPY!!");

                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDeny.class);
                startActivity(confirmDenyActivityIntent);
            }
        });

        neutralMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("NEUTRAL!!");

                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDeny.class);
                startActivity(confirmDenyActivityIntent);
            }
        });

        sadMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("SAD!!");

                Intent confirmDenyActivityIntent = new Intent(getApplicationContext(), ConfirmDeny.class);
                startActivity(confirmDenyActivityIntent);
            }
        });

        backFromMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent productivityActivityIntent = new Intent(getApplicationContext(), Productivity.class);
                startActivity(productivityActivityIntent);
            }
        });
    }
}