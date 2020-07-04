package es.deusto.coffe_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class OverallView extends AppCompatActivity {

    private static final String TAG = OverallView.class.getName();

    private TicketManager ticketManager;

    private RecyclerView recyclerView;
    private TicketAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_view);

        ticketManager = new TicketManager();
        ticketManager.setTickets(new ArrayList<Ticket>());
        ticketManager.getTickets().add(new Ticket());
        ticketManager.getTickets().get(0).setCoffees(getIntent().getExtras().<Coffee>getParcelableArrayList("coffees"));

        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.rv_overall);
        adapter = new TicketAdapter(ticketManager.getTickets(), this );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}