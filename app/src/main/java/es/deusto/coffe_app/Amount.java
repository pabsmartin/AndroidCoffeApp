package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class Amount extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    NumberPicker numberPicker;
    Button pickBtn, backBtn;

    TicketManager ticketManager;
    Ticket ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        numberPicker.findViewById(R.id.np_amount);
        pickBtn.findViewById(R.id.btn_pick_amount);
        backBtn.findViewById(R.id.btn_back_from_amount);

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
                Intent prodActivityIntent = new Intent(getApplicationContext(), Productivity.class);
                startActivity(prodActivityIntent);
            }
        });
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

    }
}