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

import java.util.HashMap;

public class DeviceListAdapter extends BaseAdapter{
    private HashMap<String,Integer> mListOfDevices;
    private String[] mDeviceNames;
    private Context mContext;
    public DeviceListAdapter(HashMap<String,Integer> mListOfDevice,String[] devices, Context context){
        this.mListOfDevices = mListOfDevice;
        this.mContext = context;
        this.mDeviceNames = devices;
    }
    @Override
    public int getCount() {
        return mListOfDevices.size();
    }

    @Override
    public Object getItem(int position) {
        return mListOfDevices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mListOfDevices.get(mDeviceNames[position]);
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
        deviceImageView.setImageResource(mListOfDevices.get(mDeviceNames[position]));
        deviceName.setText(mDeviceNames[position]);

        // returns the view for the current row
        return convertView;
    }
}
