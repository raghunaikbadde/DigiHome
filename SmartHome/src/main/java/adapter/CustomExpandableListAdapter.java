package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;

import pojo.FourModularSwitchBoard;
import pojo.Room;
import pojo.SixModularSwitchBoard;
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
            twoModularSwitchBoardArrayList.get(position).getSwitches().size();
        } else if(position > sixModularSwitchesCount){
            fourModularSwitchBoardArrayList.get(position).getSwitches().size();
        } else {
            sixModularSwitchBoardArrayList.get(position).getSwitches().size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int position) {
        if(position > sixModularSwitchesCount+fourModularSwitchesCount){
            twoModularSwitchBoardArrayList.get(position).getSwitches();
        } else if(position > sixModularSwitchesCount){
            fourModularSwitchBoardArrayList.get(position).getSwitches();
        } else {
            sixModularSwitchBoardArrayList.get(position).getSwitches();
        }
        return null;
    }

    @Override
    public Object getChild(int position, int childPosition) {
        if(position > sixModularSwitchesCount+fourModularSwitchesCount){
            twoModularSwitchBoardArrayList.get(position).getSwitches().get(childPosition);
        } else if(position > sixModularSwitchesCount){
            fourModularSwitchBoardArrayList.get(position).getSwitches().get(childPosition);
        } else {
            sixModularSwitchBoardArrayList.get(position).getSwitches().get(childPosition);
        }
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i+i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
