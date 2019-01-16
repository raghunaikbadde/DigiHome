package pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Switch {
    @PrimaryKey(autoGenerate = true)
    private int switchid;

    @ColumnInfo(name = "name")
    private String name;

    @Embedded(prefix = "appliance")
    private Appliance appliance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }


    public int getSwitchid() {
        return switchid;
    }

    public void setSwitchid(int switchid) {
        this.switchid = switchid;
    }
}
