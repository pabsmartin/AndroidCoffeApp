package es.deusto.coffe_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.util.ArrayList;

import es.deusto.coffe_app.R;
import es.deusto.coffe_app.SQLiteCoffeeHelper;
import es.deusto.coffe_app.SQLiteTicketHelper;
import es.deusto.coffe_app.TicketAdapter;
import es.deusto.coffe_app.objects.Coffee;
import es.deusto.coffe_app.objects.Ticket;

public class OverallViewActivity extends AppCompatActivity {

    private static final String TAG = OverallViewActivity.class.getName();

    private ArrayList<Ticket> ticketsSql;
    private ArrayList<Coffee> coffeesSql;

    private RecyclerView recyclerView;
    private TicketAdapter adapter;

    private Context context;

    private Button addTicketBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_view);

        context = getApplicationContext();

        addTicketBtn = findViewById(R.id.btn_add_ticket);

        try {
            ticketsSql = new SQLiteTicketHelper(context).getTickets();
        } catch (ParseException e) {
            ticketsSql = new ArrayList<>();
            ticketsSql.add(new Ticket());
        }

        SQLiteCoffeeHelper coffeeHelper = new SQLiteCoffeeHelper(context);

        for (Ticket t : ticketsSql) {
            try {
                coffeesSql = coffeeHelper.getCofeesForTicket(t.getId());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        initRecyclerView();

        addTicketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent coffeeSizeActivityIntent = new Intent(getApplicationContext(), CoffeeSizeActivity.class);
                startActivity(coffeeSizeActivityIntent);
            }
        });
    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.rv_overall);
        Log.d(TAG, "initRecyclerView: ticketsSQL -> " + ticketsSql);
        Log.d(TAG, "initRecyclerView: coffeesSQL -> " + coffeesSql);
        adapter = new TicketAdapter(ticketsSql, coffeesSql, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}