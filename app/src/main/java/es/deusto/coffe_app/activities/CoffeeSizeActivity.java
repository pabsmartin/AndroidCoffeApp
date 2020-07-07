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

public class CoffeeSizeActivity extends Activity {

    public static final String TAG = CoffeeSizeActivity.class.getName();

    private final int smallCoffee = 0;
    private final int mediumCoffee = 1;
    private final int largeCoffee = 2;

    private Button largeCoffeeBtn, mediumCoffeeBtn, smallCoffeeBtn, backSizeBtn;
    private Intent startActivityIntent, amountActivityIntent, intent;

    private ArrayList<Coffee> coffees;
    private Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_size);

        largeCoffeeBtn = findViewById(R.id.btn_large_size);
        mediumCoffeeBtn = findViewById(R.id.btn_medium_size);
        smallCoffeeBtn = findViewById(R.id.btn_small_size);
        backSizeBtn = findViewById(R.id.btn_back_from_size);

        Intent i = getIntent();

        Coffee auxCoffee = i.getParcelableExtra("coffee");
        if(auxCoffee != null)
            coffee = auxCoffee;
        else
            coffee = new Coffee();

        Log.d(TAG, "coffee -> "+coffee);

        ArrayList<Coffee> auxCoffees = i.getParcelableArrayListExtra("coffees");
        Log.d(TAG, "AUXILIAR COFFEES -> "+auxCoffees);
        if(auxCoffees != null)
            coffees = auxCoffees;
        else
            coffees = new ArrayList<>();

        Log.d(TAG, "coffees --> "+coffees);

        smallCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountActivityIntent = new Intent(getApplicationContext(), AmountActivity.class);

                coffee.setSize(smallCoffee);

                coffees.add(coffee);
                amountActivityIntent.putExtra("coffees", coffees);
                Log.d(TAG, "coffees after size pick -- "+coffees);

                startActivity(amountActivityIntent);
            }
        });

        mediumCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountActivityIntent = new Intent(getApplicationContext(), AmountActivity.class);

                coffee.setSize(mediumCoffee);

                coffees.add(coffee);
                amountActivityIntent.putExtra("coffees", coffees);
                Log.d(TAG, "coffees after size pick -- "+coffees);

                startActivity(amountActivityIntent);
            }
        });

        largeCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountActivityIntent = new Intent(getApplicationContext(), AmountActivity.class);

                coffee.setSize(largeCoffee);

                coffees.add(coffee);
                amountActivityIntent.putExtra("coffees", coffees);
                Log.d(TAG, "coffees after size pick -- "+coffees);

                startActivity(amountActivityIntent);
            }
        });

        backSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"SIZE --> LANDING");

                startActivityIntent = new Intent(getApplicationContext(), LandingActivity.class);

                startActivity(startActivityIntent);
            }
        });
    }
}