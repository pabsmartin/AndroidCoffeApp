package es.deusto.coffe_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketHolder> {

    private static final String TAG = TicketAdapter.class.getName();

    private ArrayList<Ticket> mTickets;
    private Context context;

    public TicketAdapter(ArrayList<Ticket> mTickets, Context context) {
        this.mTickets = mTickets;
        this.context = context;
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
//        holder.ticketTitle.setText(mTickets.get(position).getRegistryDate().toString());
        int mood= -1;

        holder.ticketTitle.setText(mTickets.get(position).getRegistryDate().toString());

        mood = mTickets.get(position).getMood();
        switch(mood){
            case 0:
                holder.itemView.setBackgroundResource(R.drawable.sad_mood_btn_style);
                break;
            case 1:
                holder.itemView.setBackgroundResource(R.drawable.neutral_mood_btn_style);
                break;
            case 2:
                holder.itemView.setBackgroundResource(R.drawable.happy_mood_btn_style);
                break;
            default:
                holder.itemView.setBackgroundResource(R.drawable.welcome_text_style);
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
        return mTickets.size();
    }

    public class TicketHolder extends RecyclerView.ViewHolder{

        TextView ticketTitle;
        RelativeLayout parentLayout;
        public TicketHolder(@NonNull View itemView) {
            super(itemView);

            ticketTitle = itemView.findViewById(R.id.ticket_title);
            parentLayout = itemView.findViewById(R.id.item_layout);
        }
    }
}
