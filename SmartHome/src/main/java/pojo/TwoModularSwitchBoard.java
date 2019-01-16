package pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class TwoModularSwitchBoard extends SwitchBoard{

    private int TMSBid;

    @Embedded(prefix = "switches")
    private ArrayList<Switch> switches = new ArrayList<>();

    public ArrayList<Switch> getSwitches() {
        return switches;
    }

    public void setSwitches(ArrayList<Switch> switches) {
        this.switches = switches;
    }


    public int getTMSBid() {
        return TMSBid;
    }

    public void setTMSBid(int TMSBid) {
        this.TMSBid = TMSBid;
    }
}
