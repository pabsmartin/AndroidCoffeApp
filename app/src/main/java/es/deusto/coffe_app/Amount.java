package es.deusto.coffe_app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.Objects;

public class Amount extends Activity implements NumberPicker.OnValueChangeListener {

    private static final String TAG = Amount.class.getName();

    private NumberPicker numberPicker;
    private Button pickBtn, backBtn;

    private ArrayList<Coffee> coffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        numberPicker = findViewById(R.id.np_amount);
        pickBtn = findViewById(R.id.btn_pick_amount);
        backBtn = findViewById(R.id.btn_back_from_amount);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        Intent intent = getIntent();

        coffees = intent.getParcelableArrayListExtra("coffees");
        Log.d(TAG,"coffees --> "+coffees);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sizeActivityIntent = new Intent(getApplicationContext(), CoffeeSize.class);

                sizeActivityIntent.putExtra("coffees", coffees);
                Log.d(TAG, "sending back coffees --> "+coffees);

                startActivity(sizeActivityIntent);
            }
        });

        pickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anotherOneActivityIntent = new Intent(getApplicationContext(), AnotherOne.class);

                coffees.get(coffees.size()-1).setAmount(numberPicker.getValue());
                anotherOneActivityIntent.putExtra("coffees", coffees);

                Log.d(TAG, "coffees --> "+coffees);

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