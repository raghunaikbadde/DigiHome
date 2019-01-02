package adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart.digihome.R;

import java.util.ArrayList;
import java.util.HashMap;

import pojo.Appliance;

public class DeviceListAdapter extends BaseAdapter{
    private ArrayList<Appliance> appliances;
    private Context mContext;
    public DeviceListAdapter(ArrayList<Appliance> appliances, Context context){
        this.appliances = appliances;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return appliances.size();
    }

    @Override
    public Object getItem(int position) {
        return appliances.get(position);
    }

    @Override
    public long getItemId(int position) {
        return appliances.get(0).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.menu_device_item, parent, false);
        }


        // get the TextView for item name and item description
        ImageView deviceImageView = (ImageView)
                convertView.findViewById(R.id.deviceIcon);
        TextView deviceName = (TextView)
                convertView.findViewById(R.id.deviceName);

        //sets the text for item name and item description from the current item object
//        if(mDeviceNames[0])
        deviceImageView.setImageResource(appliances.get(0).getAppImageRes());
        deviceName.setText(appliances.get(position).getDeviceName());

        // returns the view for the current row
        return convertView;
    }
}
