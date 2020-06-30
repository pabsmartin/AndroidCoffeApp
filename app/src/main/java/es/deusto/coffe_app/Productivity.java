package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.Button;

public class Productivity extends AppCompatActivity {

    Button veryBtn, normalBtn, littleBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productivity);

        veryBtn = findViewById(R.id.btn_very_prod);
        normalBtn = findViewById(R.id.btn_normal_prod);
        littleBtn = findViewById(R.id.btn_not_prod);
        backBtn = findViewById(R.id.btn_back_from_prod);

        veryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), Mood.class);
                startActivity(moodActivityIntent);
            }
        });

        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), Mood.class);
                startActivity(moodActivityIntent);
            }
        });

        littleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moodActivityIntent = new Intent(getApplicationContext(), Mood.class);
                startActivity(moodActivityIntent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sizeActivityIntent = new Intent(getApplicationContext(), CoffeeSize.class);
                startActivity(sizeActivityIntent);
            }
        });
    }
}