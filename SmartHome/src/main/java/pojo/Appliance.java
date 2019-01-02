package pojo;

import android.graphics.drawable.Drawable;

public class Appliance {

    private boolean powerOn;
    private String typeOfAppliance;
    private String deviceName;
    private Drawable deviceIcon;
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
}
