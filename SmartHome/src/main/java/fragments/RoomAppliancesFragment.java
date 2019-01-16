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

import com.smart.digihome.DigiHomeApp;
import com.smart.digihome.R;
import com.smart.digihome.SelectModularActivity;

import java.util.ArrayList;

import Constants.Constants;
import Log.Logger;
import adapter.CustomExpandableListAdapter;
import adapter.RoomAppliancesAdapter;
import database.AppDataBase;
import database.dao.Roomdao;
import dialogs.DevicesListDialog;
import pojo.Appliance;
import pojo.ElectricFan;
import pojo.ElectricLight;
import pojo.Room;
import pojo.SixModularSwitchBoard;
import pojo.Switch;

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
    AppDataBase appDatabase;
    Room hallRoom = new Room();
    Roomdao roomdao ;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
        applianceArrayList = new ArrayList<>();
    }
    DigiHomeApp digiHomeApp = DigiHomeApp.getInstance();

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
        appDatabase = digiHomeApp.getAppDatabase();
        roomdao = appDatabase.Roomdao();
        prepareDummyList(expandableListView);


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

    private void prepareDummyList(ExpandableListView expandableListView) {
        ElectricLight electricLight = new ElectricLight();
        electricLight.setPowerOn(true);
        electricLight.setDeviceName(getResources().getString(R.string.title_elect_light));
        electricLight.setTypeOfAppliance(Constants.DEVICE_TYPE_ELECTRIC_LIGHT);

        ElectricFan electricFan = new ElectricFan();
        electricFan.setPowerOn(true);
        electricFan.setDeviceName(getResources().getString(R.string.title_elect_fan));
        electricFan.setTypeOfAppliance(Constants.DEVICE_TYPE_ELECTRIC_FAN);
        electricFan.setProgressStep(50);

        Switch electricSwitch = new Switch();
        electricSwitch.setAppliance(electricLight);
        electricSwitch.setName(getResources().getString(R.string.title_elect_light));

        Switch electricFannSwitch = new Switch();
        electricFannSwitch.setAppliance(electricFan);
        electricFannSwitch.setName(getResources().getString(R.string.title_elect_fan));


        ArrayList<Switch> switches = new ArrayList<>();
        switches.add(electricSwitch);
        switches.add(electricSwitch);
        switches.add(electricSwitch);
        switches.add(electricFannSwitch);

        ArrayList<SixModularSwitchBoard> sixModularSwitchBoards = new ArrayList<>();

        SixModularSwitchBoard sixModularSwitchBoard = new SixModularSwitchBoard();
        sixModularSwitchBoard.setSwitchBoardName("Six Modular Switch Board");
        sixModularSwitchBoard.setSwitches(switches);

        sixModularSwitchBoards.add(sixModularSwitchBoard);
        sixModularSwitchBoards.add(sixModularSwitchBoard);


        hallRoom.setRoomName("Hall");
        hallRoom.setSixModularSwitchBoardArrayList(sixModularSwitchBoards);

     //   new Thread(new Runnable() {
       //     @Override
         //   public void run() {
             //   insertandread(hallRoom);
           // }
        //}).start();


        CustomExpandableListAdapter customExpandableListAdapter = new CustomExpandableListAdapter(mContext,hallRoom);
        expandableListView.setAdapter(customExpandableListAdapter);
    }

    private void insertandread(Room hallRoom) {

        roomdao.insertRoom(hallRoom);

        Room room = appDatabase.Roomdao().getRoom(hallRoom.getRoomName());

        Logger.Companion.LogMessage("room "+room.getRoomName() + "room six modular boards size"+room.getSixModularSwitchBoardArrayList().size());
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
