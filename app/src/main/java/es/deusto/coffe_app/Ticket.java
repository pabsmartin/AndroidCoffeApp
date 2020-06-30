package es.deusto.coffe_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Ticket {

    private int mood;
    private int prodLevel;
    private int size;
    private int amount;

    public Ticket() {
        this.size = size;
        this.amount = amount;
        this.prodLevel = prodLevel;
        this.mood = mood;
    }

    public int getMood(){
        return mood;
    }
    public int getProdLevel(){
        return prodLevel;
    }
    public int getSize(){
        return size;
    }
    public int getAmount(){
        return amount;
    }
    public void setMood(int mood){ this.mood = mood;}
    public void setAmount(int amount){ this.amount = amount;}
    public void setSize(int size){ this.size= size;}
    public void setProdLevel(int prodLevel){ this.prodLevel = prodLevel;}

}
