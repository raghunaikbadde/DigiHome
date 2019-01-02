package pojo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.smart.digihome.R;

import Constants.Constants;

public class ElectricLight extends Appliance{
    public static final String DEVICE_TYPE = Constants.DEVICE_TYPE_ELECTRIC_LIGHT;
    public static final String DEVICE_NAME =  "Electric Light";//Resources.getSystem().getString(R.string.title_elect_fan);
   // public static final Drawable DEVICE_IMAGE = Resources.getSystem().getDrawable(R.drawable.device_electric_fan);
    public static final int DEVICE_IMG_RES = R.drawable.device_electric_light;


}
