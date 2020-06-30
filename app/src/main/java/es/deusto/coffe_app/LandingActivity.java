package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class LandingActivity extends AppCompatActivity {

    private Button startBtn;
    private ArrayList<Ticket> registeredCoffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        startBtn = findViewById(R.id.btn_start);

        startBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println("STARTING APP");

                        Intent coffeeActivityIntent = new Intent(getApplicationContext(), CoffeeSize.class);

                        registeredCoffees = new ArrayList<Ticket>();
                        coffeeActivityIntent.putExtra("RegisteredCoffees", registeredCoffees);

                        startActivity(coffeeActivityIntent);
                    }
                }
        );
    }
}