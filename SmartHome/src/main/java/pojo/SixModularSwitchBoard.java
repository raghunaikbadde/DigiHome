package pojo;

import java.util.ArrayList;

public class SixModularSwitchBoard extends SwitchBoard{
    private ArrayList<Switch> switches = new ArrayList<>();

    public ArrayList<Switch> getSwitches() {
        return switches;
    }

    public void setSwitches(ArrayList<Switch> switches) {
        this.switches = switches;
    }
}
