package com.smart.digihome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import Constants.Constants;

import static adapter.MyGridAdapter.KEY_ROOM_IMAGE_ID;
import static adapter.MyGridAdapter.KEY_ROOM_NAME;

public class SelectModularActivity extends AppCompatActivity implements Constants,View.OnClickListener {

    TextView roomNameTxt;
    LinearLayout sixModularLL,fourModularLL, twoModularLL;
    String roomName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_module);
        sixModularLL = (LinearLayout) findViewById(R.id.sixmodular);
        fourModularLL = (LinearLayout) findViewById(R.id.fourmodular);
        twoModularLL = (LinearLayout) findViewById(R.id.twomodular);
        roomNameTxt = (TextView) findViewById(R.id.roomName);
        sixModularLL.setOnClickListener(this);
        fourModularLL.setOnClickListener(this);
        twoModularLL.setOnClickListener(this);
        roomName = getIntent().getExtras().getString(KEY_ROOM_NAME);
        roomNameTxt.setText(roomName);
    }

    public void showSelectedModular(View view){
        Intent intent = new Intent(this, RoomAppliancesActivity.class);
        intent.putExtra(KEY_ROOM_IMAGE_ID,"");//room.getImageId());
        intent.putExtra(KEY_ROOM_NAME,"");//room.getRoomName());
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), RoomAppliancesActivity.class);
        intent.putExtra(KEY_ROOM_IMAGE_ID,"");//room.getImageId());
        intent.putExtra(KEY_ROOM_NAME,"");//room.getRoomName());
        startActivity(intent);
    }
}
