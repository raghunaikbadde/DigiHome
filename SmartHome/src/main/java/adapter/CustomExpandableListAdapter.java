package adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.smart.digihome.R;
import com.triggertrap.seekarc.SeekArc;

import java.util.ArrayList;

import Log.Logger;
import pojo.ElectricFan;
import pojo.ElectricLight;
import pojo.FourModularSwitchBoard;
import pojo.Room;
import pojo.SixModularSwitchBoard;
import pojo.Switch;
import pojo.SwitchBoard;
import pojo.TwoModularSwitchBoard;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter{
    private Context mContext;
    private Room room;
    private int groupCount;

    private int sixModularSwitchesCount;
    private int fourModularSwitchesCount;
    private int twoModularSwitchesCount;

    ArrayList<SixModularSwitchBoard> sixModularSwitchBoardArrayList = new ArrayList<>();
    ArrayList<FourModularSwitchBoard> fourModularSwitchBoardArrayList = new ArrayList<>();
    ArrayList<TwoModularSwitchBoard> twoModularSwitchBoardArrayList = new ArrayList<>();

    public CustomExpandableListAdapter(Context context, Room room){
        this.mContext = context;
        this.room = room;
        sixModularSwitchBoardArrayList = room.getSixModularSwitchBoardArrayList();
        fourModularSwitchBoardArrayList = room.getFourModularSwitchBoardArrayList();
        twoModularSwitchBoardArrayList = room.getTwoModularSwitchBoardArrayList();
        sixModularSwitchesCount = sixModularSwitchBoardArrayList.size();
        fourModularSwitchesCount = fourModularSwitchBoardArrayList.size();
        twoModularSwitchesCount = twoModularSwitchBoardArrayList.size();
        groupCount = sixModularSwitchesCount+fourModularSwitchesCount+twoModularSwitchesCount;
    }

    @Override
    public int getGroupCount() {
        return groupCount;
    }

    @Override
    public int getChildrenCount(int position) {
        if(position > sixModularSwitchesCount+fourModularSwitchesCount){
            return twoModularSwitchBoardArrayList.get(position).getSwitches().size();
        } else if(position > sixModularSwitchesCount){
            return fourModularSwitchBoardArrayList.get(position).getSwitches().size();
        } else {
            return sixModularSwitchBoardArrayList.get(position).getSwitches().size();
        }
    }

    @Override
    public Object getGroup(int position) {
        if(position > sixModularSwitchesCount+fourModularSwitchesCount){
            return twoModularSwitchBoardArrayList.get(position);
        } else if(position > sixModularSwitchesCount){
            return fourModularSwitchBoardArrayList.get(position);
        } else {
            return sixModularSwitchBoardArrayList.get(position);
        }
    }

    @Override
    public Object getChild(int position, int childPosition) {
        if(position > sixModularSwitchesCount+fourModularSwitchesCount){
            return twoModularSwitchBoardArrayList.get(position).getSwitches().get(childPosition);
        } else if(position > sixModularSwitchesCount){
            return fourModularSwitchBoardArrayList.get(position).getSwitches().get(childPosition);
        } else {
            return sixModularSwitchBoardArrayList.get(position).getSwitches().get(childPosition);
        }
    }

    @Override
    public long getGroupId(int i) {
        Logger.Companion.LogMessage("group id "+i);
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        Logger.Companion.LogMessage("child group id"+i+"child id "+i1);
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        SwitchBoard switchBoard = (SwitchBoard) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(switchBoard.getSwitchBoardName());
        return convertView;
    }

    @Override
    public View getChildView(int listPosition, int expandedListPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Switch expandedListSwitch = (Switch) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(expandedListSwitch.getAppliance().getTypeOfAppliance().equals(ElectricLight.DEVICE_TYPE)) {
                convertView = layoutInflater.inflate(R.layout.light_appliance_layout, null);
                SwitchCompat switchCompat = convertView.findViewById(R.id.lightswitcher);
                switchCompat.setChecked(expandedListSwitch.getAppliance().isPowerOn());
            }
            else {
                convertView = layoutInflater.inflate(R.layout.fan_appliance_layout, null);
                SwitchCompat switchCompat = convertView.findViewById(R.id.fanswitcher);
                switchCompat.setChecked(expandedListSwitch.getAppliance().isPowerOn());
                SeekArc seekArc = convertView.findViewById(R.id.seekArc);
                seekArc.setProgress(((ElectricFan)expandedListSwitch.getAppliance()).getProgressStep());
                final TextView textView = convertView.findViewById(R.id.label);
                textView.setText(((ElectricFan)expandedListSwitch.getAppliance()).getProgressStep()+"%");
                seekArc.setOnSeekArcChangeListener(new SeekArc.OnSeekArcChangeListener() {
                    @Override
                    public void onProgressChanged(SeekArc seekArc, int progress, boolean fromUser) {
                        textView.setText((int)(((double)progress/100)*100)+"%");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekArc seekArc) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekArc seekArc) {

                    }
                });
            }
        } else {
            LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(expandedListSwitch.getAppliance().getTypeOfAppliance().equals(ElectricLight.DEVICE_TYPE)) {
                convertView = layoutInflater.inflate(R.layout.light_appliance_layout, null);
                SwitchCompat switchCompat = convertView.findViewById(R.id.lightswitcher);
                switchCompat.setChecked(expandedListSwitch.getAppliance().isPowerOn());
            }
            else {
                convertView = layoutInflater.inflate(R.layout.fan_appliance_layout, null);
                SwitchCompat switchCompat = convertView.findViewById(R.id.fanswitcher);
                switchCompat.setChecked(expandedListSwitch.getAppliance().isPowerOn());
                SeekArc seekArc = convertView.findViewById(R.id.seekArc);
                seekArc.setProgress(((ElectricFan)expandedListSwitch.getAppliance()).getProgressStep());
                final TextView textView = convertView.findViewById(R.id.label);
                textView.setText(((ElectricFan)expandedListSwitch.getAppliance()).getProgressStep()+"%");
                seekArc.setOnSeekArcChangeListener(new SeekArc.OnSeekArcChangeListener() {
                    @Override
                    public void onProgressChanged(SeekArc seekArc, int progress, boolean fromUser) {
                        textView.setText((int)(((double)progress/100)*100)+"%");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekArc seekArc) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekArc seekArc) {

                    }
                });
            }
        }

        return convertView;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {

        return false;
    }
}
