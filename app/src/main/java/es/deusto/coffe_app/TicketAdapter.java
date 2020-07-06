package es.deusto.coffe_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassifierEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketHolder> {

    private static final String TAG = TicketAdapter.class.getName();

    private ArrayList<Ticket> mTickets;
    private ArrayList<Coffee> mCoffees;

    private Context context;
    private DateFormat dateFormat;

    private int smallCoffees, mediumCoffees, largeCoffees;

    public TicketAdapter(ArrayList<Ticket> mTickets, ArrayList<Coffee> mCoffees, Context context) {
        Log.d(TAG, "TicketAdapter: tickets ->"+mTickets);
        this.mTickets = mTickets;
        this.mCoffees = mCoffees;
        this.context = context;
        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.FRANCE);
    }

    @NonNull
    @Override
    public TicketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_layout, parent, false);
        TicketHolder holder = new TicketHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketHolder holder, final int position) {
        Ticket ticket = mTickets.get(position);

        try {

            holder.ticketTitle.setText(dateFormat.format(ticket.getRegistryDate()));
        } catch (Exception e) {
            holder.ticketTitle.setText("null");
        }

        int mood = ticket.getMood();
        int tId = ticket.getId();

        smallCoffees = 0;
        mediumCoffees = smallCoffees;
        largeCoffees = smallCoffees;

        for(Coffee c : mCoffees){
            if(c.getTicketId() == tId){
                int size = c.getSize();
                if(size == 0)
                    smallCoffees += c.getAmount();
                else if(size == 1)
                    mediumCoffees += c.getAmount();
                else if(size == 2){
                    largeCoffees += c.getAmount();
                }
            }
        }

        holder.numberOfCoffees.setText("S: "+smallCoffees+" M: "+mediumCoffees+" L: "+largeCoffees);

        switch(mood){
            case 0:
                holder.imageView.setBackgroundResource(R.drawable.sad_mood_btn_style);
                break;
            case 1:
                holder.imageView.setBackgroundResource(R.drawable.neutral_mood_btn_style);
                break;
            case 2:
                holder.imageView.setBackgroundResource(R.drawable.happy_mood_btn_style);
                break;
            default:
                holder.imageView.setBackgroundResource(R.drawable.welcome_text_style);
                break;
        }

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: "+mTickets.get(position).getRegistryDate());

                Toast.makeText(context, mTickets.get(position).getRegistryDate().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: mTickets -> "+mTickets);
        return mTickets.size();
//        return 0;
    }

    public class TicketHolder extends RecyclerView.ViewHolder{

        TextView ticketTitle;
        TextView numberOfCoffees;
        ImageView imageView;
        RelativeLayout parentLayout;
        public TicketHolder(@NonNull View itemView) {
            super(itemView);

            numberOfCoffees = itemView.findViewById(R.id.coffee_number);
            ticketTitle = itemView.findViewById(R.id.ticket_title);
            imageView = itemView.findViewById(R.id.mood_image);
            parentLayout = itemView.findViewById(R.id.item_layout);
        }
    }
}
