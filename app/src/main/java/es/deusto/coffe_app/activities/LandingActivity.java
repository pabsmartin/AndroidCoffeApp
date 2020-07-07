package es.deusto.coffe_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.deusto.coffe_app.R;

public class LandingActivity extends AppCompatActivity {

    private Button startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        startBtn = findViewById(R.id.btn_start);

        startBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                Intent coffeeActivityIntent = new Intent(getApplicationContext(), CoffeeSizeActivity.class);
                startActivity(coffeeActivityIntent);
                }
            }
        );
    }
}