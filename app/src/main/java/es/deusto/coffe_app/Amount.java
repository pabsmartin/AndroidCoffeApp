package es.deusto.coffe_app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.ArrayList;

public class Amount extends Activity implements NumberPicker.OnValueChangeListener {

    private static final String TAG = Amount.class.getName();

    private NumberPicker numberPicker;
    private Button pickBtn, backBtn;

    private Ticket ticket;
    private ArrayList<Coffee> coffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        numberPicker = findViewById(R.id.np_amount);
        pickBtn = findViewById(R.id.btn_pick_amount);
        backBtn = findViewById(R.id.btn_back_from_amount);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);

        Intent intent = getIntent();
        ticket = intent.getExtras().getParcelable("ticket");

        Log.d(TAG,"amount -- "+ticket.toString());

        coffees = intent.getExtras().getParcelableArrayList("coffees");
//        coffees = ticket.getCoffees();

        Log.d(TAG,"amount -- "+coffees);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sizeActivityIntent = new Intent(getApplicationContext(), CoffeeSize.class);

                startActivity(sizeActivityIntent);
            }
        });

        pickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anotherOneActivityIntent = new Intent(getApplicationContext(), AnotherOne.class);

                coffees.get(coffees.size()-1).setAmount(numberPicker.getValue());

                anotherOneActivityIntent.putExtra("ticket", ticket);
                anotherOneActivityIntent.putExtra("coffees", coffees);

                startActivity(anotherOneActivityIntent);
            }
        });
    }

    //unused
    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        //nada
    }

}