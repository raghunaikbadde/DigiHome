package pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class FourModularSwitchBoard extends SwitchBoard{
    private int FSMBid;

    @Embedded(prefix = "switches")
    private ArrayList<Switch> switches= new ArrayList<>();

    public ArrayList<Switch> getSwitches() {
        return switches;
    }

    public void setSwitches(ArrayList<Switch> switches) {
        this.switches = switches;
    }

    public int getFSMBid() {
        return FSMBid;
    }

    public void setFSMBid(int FSMBid) {
        this.FSMBid = FSMBid;
    }
}
