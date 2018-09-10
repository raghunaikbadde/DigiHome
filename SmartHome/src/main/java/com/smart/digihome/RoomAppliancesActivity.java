package com.smart.digihome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import adapter.MyGridAdapter;

public class RoomAppliancesActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_appliances);
        imageView = findViewById(R.id.detailsImageRoom);
        textView = findViewById(R.id.roomName);
        int imageId = getIntent().getExtras().getInt(MyGridAdapter.KEY_ROOM_IMAGE_ID);
        String roomName = getIntent().getExtras().getString(MyGridAdapter.KEY_ROOM_NAME);
        imageView.setImageResource(imageId);
        textView.setText(roomName);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
