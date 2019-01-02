package dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;
import java.util.HashMap;

import Constants.Constants;

import adapter.DeviceListAdapter;
import pojo.Appliance;
import pojo.ElectricFan;
import pojo.ElectricLight;

public class DevicesListDialog extends DialogFragment implements DialogInterface.OnClickListener,Constants{
    private HashMap<String,Integer> mDeviceList=new HashMap<>();
    private String[] mDeviceNames;
    ArrayList<Appliance> appliances;
    public MenuClickListener menuClickListener;
    public void setMenuClickListener(MenuClickListener menuClickListener){
        this.menuClickListener = menuClickListener;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        ArrayList<Appliance> appliances = new ArrayList<>();

        ElectricLight electricLight = new ElectricLight();
        electricLight.setPowerOn(false);
        electricLight.setAppImageRes(ElectricLight.DEVICE_IMG_RES);
        electricLight.setDeviceName(ElectricLight.DEVICE_NAME);
        appliances.add(electricLight);

        ElectricFan electricFan = new ElectricFan();
        electricFan.setProgressStep(0);
        electricFan.setAppImageRes(ElectricFan.DEVICE_IMG_RES);
        electricFan.setDeviceName(ElectricFan.DEVICE_NAME);
        appliances.add(electricFan);

        builder.setAdapter(new DeviceListAdapter(appliances,getActivity()),this);
        return builder.create();
    }



    @Override
    public void onClick(DialogInterface dialogInterface, int position) {
//        Logger.Companion.LogMessage("Dialog position "+position+" DEVICE_NAME "+mDeviceNames[position]);
        if(position == 0) {
            ElectricLight electricLight = new ElectricLight();
            electricLight.setTypeOfAppliance(Constants.DEVICE_TYPE_ELECTRIC_LIGHT);
            electricLight.setPowerOn(false);
//            appliances.add(electricLight);
            menuClickListener.onMenuClicked(electricLight);

        } else if(position ==1){
            ElectricFan electricFan = new ElectricFan();
            electricFan.setTypeOfAppliance(Constants.DEVICE_TYPE_ELECTRIC_FAN);
            electricFan.setPowerOn(false);
            electricFan.setProgressStep(0);
            menuClickListener.onMenuClicked(electricFan);
//            appliances.add(electricFan);
        }
        dismiss();

    }
    public interface MenuClickListener{
        public void onMenuClicked(Appliance appliance);
    }

}
