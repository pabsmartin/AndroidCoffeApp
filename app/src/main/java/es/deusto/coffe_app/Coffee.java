package es.deusto.coffe_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Coffee implements Parcelable{

    private int size;
    private int amount;

    public Coffee() {
        this.size = size;
        this.amount = amount;

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
        return "-- Coffee:: size:"+ size +", amount:"+ amount;
    }
}
