package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AnotherOne extends Activity {

    private static final String TAG = AnotherOne.class.getName();

    private Button yesBtn, noBtn, backBtn;

    private Ticket ticket;
    private ArrayList<Coffee> coffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_one);

        yesBtn = findViewById(R.id.btn_another_yes);
        noBtn = findViewById(R.id.btn_another_no);
        backBtn = findViewById(R.id.btn_back_from_another_no);

        Intent intent = getIntent();
        ticket = intent.getExtras().getParcelable("ticket");

        Log.d(TAG,"amount -- "+ticket.toString());

        coffees = intent.getExtras().getParcelableArrayList("coffees");

        Log.d(TAG,"amount -- "+coffees);


        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sizeActivityIntent = new Intent(getApplicationContext(), CoffeeSize.class);

                sizeActivityIntent.putExtra("ticket", ticket);
                sizeActivityIntent.putExtra("coffees", coffees);

                startActivity(sizeActivityIntent);
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent productivityActivityIntent = new Intent(getApplicationContext(), Productivity.class);

                productivityActivityIntent.putExtra("ticket", ticket);
                productivityActivityIntent.putExtra("coffees", coffees);


                startActivity(productivityActivityIntent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent amountActivityIntent = new Intent(getApplicationContext(), Amount.class);

               amountActivityIntent.putExtra("ticket", ticket);
               amountActivityIntent.putExtra("coffees", coffees);

               startActivity(amountActivityIntent);
           }
        });
    }

}