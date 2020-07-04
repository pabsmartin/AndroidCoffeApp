package es.deusto.coffe_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TicketManager implements Parcelable {

    private ArrayList<Ticket> tickets;

    public TicketManager()
    {
        tickets = new ArrayList<>();
    }

    protected TicketManager(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(tickets);
    }

    private void readFromParcel(Parcel in) {
        tickets = in.readArrayList(TicketManager.class.getClassLoader());
    }

    public ArrayList<Ticket> getTickets(){
        return tickets;
    }
    public void setTickets(ArrayList<Ticket> tickets){ this.tickets = tickets;}

    public static final Creator<TicketManager> CREATOR = new Creator<TicketManager>() {
        @Override
        public TicketManager createFromParcel(Parcel in) {
            return new TicketManager(in);
        }

        @Override
        public TicketManager[] newArray(int size) {
            return new TicketManager[size];
        }
    };
}
