package es.deusto.coffe_app.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Coffee implements Parcelable{

    private int size, amount, ticketId;

    public Coffee() {
        this.size = -1;
        this.amount = -1;
        this.ticketId = -1;
    }

    public Coffee(int size, int amount, int ticketId){
        this.size = size;
        this.amount = amount;
        this.ticketId = ticketId;
    }

    protected Coffee(Parcel in) {
        size = in.readInt();
        amount = in.readInt();
    }

    public static final Creator<Coffee> CREATOR = new Creator<Coffee>() {
        @Override
        public Coffee createFromParcel(Parcel in) {
            return new Coffee(in);
        }

        @Override
        public Coffee[] newArray(int size) {
            return new Coffee[size];
        }
    };

    public int getSize(){
        return size;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){ this.amount = amount;}
    public void setSize(int size){ this.size= size;}
    public int getTicketId() {
        return ticketId;
    }
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(size);
        parcel.writeInt(amount);
    }

    public String toString(){
        return "coffee :: size:"+ size +", amount:"+ amount+", ticketId:"+ ticketId;
    }
}
