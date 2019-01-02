package com.smart.digihome;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import Constants.Constants;
import adapter.MyGridAdapter;
import adapter.RoomAppliancesAdapter;
import dialogs.DevicesListDialog;
import pojo.Appliance;
import pojo.ElectricFan;
import pojo.ElectricLight;

public class RoomAppliancesActivity extends AppCompatActivity implements DevicesListDialog.MenuClickListener{

    ImageView imageView;
    TextView textView,applicanceaddguide;
    RecyclerView recyclerView;
    ArrayList<Appliance> appliancesList;
    DevicesListDialog.MenuClickListener menuClickListener;
    RoomAppliancesAdapter roomAppliancesAdapter;
    FloatingActionButton fab;
    String boardType;
    int maxNumeberOfSwitches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_appliances);
        imageView = findViewById(R.id.detailsImageRoom);
        textView = findViewById(R.id.roomName);
        recyclerView = findViewById(R.id.appliancesRecyclerView);
        applicanceaddguide = findViewById(R.id.add_appliance);

        boardType = getIntent().getExtras().getString(Constants.SWITCH_BOARD_TYPE);

        if(boardType.equals(Constants.SWITCH_BOARD_SIX_MODULAR_TYPE)){
            maxNumeberOfSwitches = Constants.NUMBER_SWITCHES_SIX_MODULAR;
        } else if(boardType.equals(Constants.SWITCH_BOARD_FOUR_MODULAR_TYPE)){
            maxNumeberOfSwitches = Constants.NUMBER_SWITCHES_FOUR_MODULAR;
        } else {
            maxNumeberOfSwitches = Constants.NUMBER_SWITCHES_TWO_MODULAR;
        }

        menuClickListener = this;
      //  int imageId = getIntent().getExtras().getInt(MyGridAdapter.KEY_ROOM_IMAGE_ID);
       // String roomName = getIntent().getExtras().getString(MyGridAdapter.KEY_ROOM_NAME);
        //imageView.setImageResource(imageId);
        //textView.setText(roomName);
        fab = (FloatingActionButton) findViewById(R.id.fab);


        appliancesList = new ArrayList<>();



        if(appliancesList.size()!=0){
            applicanceaddguide.setVisibility(View.GONE);
        }
         roomAppliancesAdapter = new RoomAppliancesAdapter(appliancesList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(roomAppliancesAdapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DevicesListDialog devicesListDialog = new DevicesListDialog();
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.APPLIANCE_LIST,appliancesList);
                devicesListDialog.setMenuClickListener(menuClickListener);
               // bundle.putSerializable(Constants.MENU_CLICK_LISTENER,menuClickListener);
                devicesListDialog.show(getSupportFragmentManager(),"RoomAppliancesActivity");
            }
        });
    }


    @Override
    public void onMenuClicked(Appliance appliance) {
        appliancesList.add(appliance);
        if(appliancesList.size()==maxNumeberOfSwitches){
            fab.setVisibility(View.GONE);
        }
        if(appliancesList.size()!=0){
            applicanceaddguide.setVisibility(View.GONE);
        }
        roomAppliancesAdapter.notifyDataSetChanged();
    }
}
