package es.deusto.coffe_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class Ticket implements Parcelable {

    private ArrayList<Coffee> coffees;
    private int mood, productivity, id;
    private Date registryDate;

    public Ticket() {
        coffees = new ArrayList<Coffee>();
        mood = -1;
        productivity = -1;
        registryDate = new Date();
        id = -1;
    }

    public Ticket(ArrayList<Coffee> coffees, int mood, int productivity, Date registryDate, int id ){
        this.coffees = coffees;
        this.mood = mood;
        this.productivity = productivity;
        this.registryDate = registryDate;
        this.id = id;

    }

    protected Ticket(Parcel in) {
        mood = in.readInt();
        productivity = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mood);
        dest.writeInt(productivity);
//        dest.writeParcelableArray((Parcelable[]) coffees.toArray(), 2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    public ArrayList<Coffee> getCoffees() {
        return coffees;
    }
    public void setCoffees(ArrayList<Coffee> coffees) {
        this.coffees = coffees;
    }

    public int getMood() {
        return mood;
    }
    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getProductivity() {
        return productivity;
    }
    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public Date getRegistryDate() {
        return registryDate;
    }
    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

    public int getId(){ return id; }
    public void setId (int id ) { this.id = id; }

    @Override
    public String toString() {
        return "Ticket{" +
                "coffees=" + coffees +
                ", mood=" + mood +
                ", productivity=" + productivity +
                ", registryDate=" + registryDate +
                ", id=" + id +
                '}';
    }
}
