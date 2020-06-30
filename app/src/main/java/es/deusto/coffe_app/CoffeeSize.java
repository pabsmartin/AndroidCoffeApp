package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CoffeeSize extends AppCompatActivity {

    private Button largeCoffeeBtn, mediumCoffeeBtn, smallCoffeeBtn, backSizeBtn;
    private Intent startActivityIntent, amountActivityIntent;

    private Ticket newTicket;
    private int coffeeSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_size);

        largeCoffeeBtn = findViewById(R.id.btn_large_size);
        mediumCoffeeBtn = findViewById(R.id.btn_medium_size);
        smallCoffeeBtn = findViewById(R.id.btn_small_size);
        backSizeBtn = findViewById(R.id.btn_back_from_size);

        newTicket = new Ticket();
        final ArrayList<Ticket> ticketManager = (ArrayList<Ticket>) getIntent().getSerializableExtra("RegisteredCoffees");

        smallCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amountActivityIntent = new Intent(getApplicationContext(), Amount.class);

//                coffeeSize = 0;
//                newTicket.setSize(coffeeSize);
//
//                ticketManager.add(newTicket);
//                moodActivityIntent.putExtra("RegisteredCoffees", ticketManager);

                System.out.println("SMALL CLICKED");
                startActivity(amountActivityIntent);


            }
        });

        mediumCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amountActivityIntent = new Intent(getApplicationContext(), Amount.class);

//                coffeeSize = 1;
//                newTicket.setSize(coffeeSize);
//
//                ticketManager.add(newTicket);
//                amountActivityIntent.putExtra("RegisteredCoffees", ticketManager);

                startActivity(amountActivityIntent);
            }
        });

        largeCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amountActivityIntent = new Intent(getApplicationContext(), Amount.class);

//                coffeeSize = 2;
//
//                newTicket.setSize(coffeeSize);
//
//                ticketManager.add(newTicket);
//                amountActivityIntent.putExtra("RegisteredCoffees", ticketManager);

                startActivity(amountActivityIntent);
            }
        });

        backSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityIntent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(startActivityIntent);
            }
        });
    }


//    @Override
//    protected void onStart()
//    {
//        super.onStart();
//        setContentView(R.layout.activity_coffee_size);
//    }
}