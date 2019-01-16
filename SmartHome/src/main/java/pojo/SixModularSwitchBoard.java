package pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
@Entity
public class SixModularSwitchBoard extends SwitchBoard{
    private int SMSBid;

    @Embedded(prefix = "switches")
    private ArrayList<Switch> switches = new ArrayList<>();

    public ArrayList<Switch> getSwitches() {
        return switches;
    }

    public void setSwitches(ArrayList<Switch> switches) {
        this.switches = switches;
    }

    public int getSMSBid() {
        return SMSBid;
    }

    public void setSMSBid(int SMSBid) {
        this.SMSBid = SMSBid;
    }
}
