package es.deusto.coffe_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TicketManager implements Parcelable {

    private ArrayList<Ticket> coffeesRegistered;

    public TicketManager()
    {
        coffeesRegistered = new ArrayList<Ticket>();
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
        parcel.writeList(coffeesRegistered);
    }

    private void readFromParcel(Parcel in) {
        coffeesRegistered = in.readArrayList(TicketManager.class.getClassLoader());
    }

    public ArrayList<Ticket> getCoffeesRegistered(){
        return coffeesRegistered;
    }
    public void setCoffeesRegistered(ArrayList<Ticket> coffeesRegistered){ this.coffeesRegistered = coffeesRegistered;}

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
