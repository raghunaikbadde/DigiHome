package fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.smart.digihome.R;
import com.smart.digihome.SelectModularActivity;

import java.util.ArrayList;

import Constants.Constants;
import adapter.RoomAppliancesAdapter;
import dialogs.DevicesListDialog;
import pojo.Appliance;
import pojo.Room;

import static adapter.MyGridAdapter.KEY_ROOM_IMAGE_ID;
import static adapter.MyGridAdapter.KEY_ROOM_NAME;

public class RoomAppliancesFragment extends Fragment implements Constants, DevicesListDialog.MenuClickListener {

    private Button mAddDeviceButton;
    private String mRoomName;
    private ArrayList<Appliance> applianceArrayList;
    Context mContext;
    RoomAppliancesAdapter roomAppliancesAdapter;
    DevicesListDialog.MenuClickListener menuClickListener;
    private int maxNumberOfSwitches;
    ImageView imageView;
    Room room;
    ExpandableListView expandableListView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
        applianceArrayList = new ArrayList<>();
    }

    public RoomAppliancesFragment() {

    }

    public static RoomAppliancesFragment newInstance() {

        RoomAppliancesFragment roomAppliancesFragment = new RoomAppliancesFragment();

        return roomAppliancesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pager_home_fragment, container, false);

        init(view);
        return view;
    }

    private void init(View view) {

        expandableListView = view.findViewById(R.id.expandableListView);
        mAddDeviceButton = view.findViewById(R.id.add_new_device);
        Bundle arguments = this.getArguments();
        room = new Room();
        room.setRoomName(arguments.getString(KEY_ROOM_NAME));
        room.setImageId(arguments.getInt(KEY_ROOM_IMAGE_ID));

        imageView = view.findViewById(R.id.roomImage);
        imageView.setImageResource(room.getImageId());

        menuClickListener = this;
        mAddDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SelectModularActivity.class);
                intent.putExtra(KEY_ROOM_IMAGE_ID, room.getImageId());
                intent.putExtra(KEY_ROOM_NAME, room.getRoomName());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onMenuClicked(Appliance appliance) {
        applianceArrayList.add(appliance);
        roomAppliancesAdapter.notifyDataSetChanged();

    }
}
