package pojo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.smart.digihome.R;

import Constants.Constants;

public class ElectricFan extends Appliance{

    public static final String DEVICE_TYPE = Constants.DEVICE_TYPE_ELECTRIC_FAN;

    public static final String DEVICE_NAME = "Electric Fan";//Resources.getSystem().getString(R.string.title_elect_fan);
   // public static final Drawable DEVICE_IMAGE = Resources.getSystem().getDrawable(R.drawable.device_electric_fan);

    public static final int DEVICE_IMG_RES = R.drawable.device_electric_fan;
    private int progressStep;


    public int getProgressStep() {
        return progressStep;
    }

    public void setProgressStep(int progressStep) {
        this.progressStep = progressStep;
    }
}
