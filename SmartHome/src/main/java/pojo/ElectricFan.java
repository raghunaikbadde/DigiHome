package pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.smart.digihome.R;

import Constants.Constants;

@Entity
public class ElectricFan extends Appliance{
    private int EFid;

    public static final String DEVICE_TYPE = Constants.DEVICE_TYPE_ELECTRIC_FAN;

    public static final String DEVICE_NAME = "Electric Fan";//Resources.getSystem().getString(R.string.title_elect_fan);
   // public static final Drawable DEVICE_IMAGE = Resources.getSystem().getDrawable(R.drawable.device_electric_fan);

    public static final int DEVICE_IMG_RES = R.drawable.device_electric_fan;

    @ColumnInfo(name = "progressStep")
    private int progressStep;


    public int getProgressStep() {
        return progressStep;
    }

    public void setProgressStep(int progressStep) {
        this.progressStep = progressStep;
    }

    public int getEFid() {
        return EFid;
    }

    public void setEFid(int EFid) {
        this.EFid = EFid;
    }
}
