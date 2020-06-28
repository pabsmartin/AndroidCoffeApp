package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoffeeSize extends AppCompatActivity {

    private Button largeCoffeeBtn, mediumCoffeeBtn, smallCoffeeBtn, backSizeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_size);

        largeCoffeeBtn = findViewById(R.id.btn_large_size);
        mediumCoffeeBtn = findViewById(R.id.btn_medium_size);
        smallCoffeeBtn = findViewById(R.id.btn_small_size);
        backSizeBtn = findViewById(R.id.btn_back_from_size);

        smallCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("SMALL COFFEE");

                Intent moodActivityIntent = new Intent(getApplicationContext(), Productivity.class);
                startActivity(moodActivityIntent);
            }
        });

        mediumCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("MEDIUM COFFEE");

                Intent moodActivityIntent = new Intent(getApplicationContext(), Productivity.class);
                startActivity(moodActivityIntent);
            }
        });

        largeCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("LARGE COFFEE");

                Intent moodActivityIntent = new Intent(getApplicationContext(), Productivity.class);
                startActivity(moodActivityIntent);
            }
        });

        backSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("LARGE COFFEE");

                Intent startActivityIntent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(startActivityIntent);
            }
        });
    }
}