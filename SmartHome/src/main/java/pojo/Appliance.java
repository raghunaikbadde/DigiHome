package pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.drawable.Drawable;

@Entity
public class Appliance {
    @PrimaryKey(autoGenerate = true)
    private int appid;

    @ColumnInfo(name = "powerOn")
    private boolean powerOn;
    @ColumnInfo(name = "typeOfAppliance")
    private String typeOfAppliance;
    @ColumnInfo(name = "deviceName")
    private String deviceName;
    @Embedded(prefix = "deviceIcon")
    private Drawable deviceIcon;
    @ColumnInfo(name = "appImageRes")
    private int appImageRes;

    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public String getTypeOfAppliance() {
        return typeOfAppliance;
    }

    public void setTypeOfAppliance(String typeOfAppliance) {
        this.typeOfAppliance = typeOfAppliance;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Drawable getDeviceIcon() {
        return deviceIcon;
    }

    public void setDeviceIcon(Drawable deviceIcon) {
        this.deviceIcon = deviceIcon;
    }

    public int getAppImageRes() {
        return appImageRes;
    }

    public void setAppImageRes(int appImageRes) {
        this.appImageRes = appImageRes;
    }


    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }
}
