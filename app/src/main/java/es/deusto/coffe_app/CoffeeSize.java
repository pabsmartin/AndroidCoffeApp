package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CoffeeSize extends Activity {

    public static final String TAG = CoffeeSize.class.getName();

    private final int smallCoffee = 0;
    private final int mediumCoffee = 1;
    private final int largeCoffee = 2;

    private Button largeCoffeeBtn, mediumCoffeeBtn, smallCoffeeBtn, backSizeBtn;
    private Intent startActivityIntent, amountActivityIntent, intent;

    private Coffee coffee;
    private Ticket ticket;

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
                amountActivityIntent = new Intent(getApplicationContext(), Amount.class);

                /*                    TAMANYO DEL CAFE                 */
                coffee.setSize(smallCoffee);
                Log.d(TAG, "ON CLICK: "+coffee.toString());

                /*                    METER EL TICKET                 */
                ticket.getCoffees().add(coffee);
                Log.d(TAG, "ON CLICK: "+ticket.toString());

                amountActivityIntent.putExtra("ticket", ticket);
                amountActivityIntent.putExtra("coffees", ticket.getCoffees());

                startActivity(amountActivityIntent);
            }
        });

        mediumCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountActivityIntent = new Intent(getApplicationContext(), Amount.class);

                /*                    TAMANYO DEL CAFE                 */
                coffee.setSize(mediumCoffee);
                Log.d(TAG, "ON CLICK: "+coffee.toString());

                /*                    METER EL TICKET                 */
                ticket.getCoffees().add(coffee);
                Log.d(TAG, "ON CLICK: "+ticket.toString());

                amountActivityIntent.putExtra("ticket", ticket);
                amountActivityIntent.putExtra("coffees", ticket.getCoffees());

                startActivity(amountActivityIntent);
            }
        });

        largeCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountActivityIntent = new Intent(getApplicationContext(), Amount.class);

                /*                    TAMANYO DEL CAFE                 */
                coffee.setSize(largeCoffee);
                Log.d(TAG,"ON CLICK: "+coffee.toString());

                /*                    METER EL TICKET                 */
                ticket.getCoffees().add(coffee);
                Log.d(TAG,"ON CLICK: "+ticket.toString());

                amountActivityIntent.putExtra("ticket", ticket);
                amountActivityIntent.putExtra("coffees", ticket.getCoffees());

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


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"ON START");

        intent = getIntent();
        Ticket intentTicket = intent.getParcelableExtra("ticket");
        if(intentTicket != null)
            ticket = intentTicket;
        else
            ticket = new Ticket();

        Log.d(TAG,"size -- "+ticket.toString());

        ArrayList<Coffee> intentCoffees = intent.getParcelableArrayListExtra("coffees");
        if(intentCoffees != null)
            ticket.setCoffees(intentCoffees);
        else
            ticket.setCoffees(new ArrayList<Coffee>()) ;

        Log.d(TAG,"size -- "+ticket.getCoffees());

        coffee = new Coffee();
        Log.d(TAG,"size -- "+coffee.toString());

    }
}