package com.smart.digihome;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

import CustomViews.GridRecyclerView;
import adapter.MyGridAdapter;
import pojo.Room;

public class HomeActivity extends AppCompatActivity implements MyGridAdapter.clickEvents {

    GridRecyclerView gridRecyclerView;
    MyGridAdapter myGridAdapter;
    TextView mTitleAddNewRoom;
    String enteredRoom;
    public static final String[] ROOMS = new String[] {
            "Bed Room", "Wash Room", "Kitchen", "Hall", "Master Bed Room"
    };
    public static final int[] roomImages = new int[] {
            R.drawable.bed_room, R.drawable.wash_room,R.drawable.kitchen_room, R.drawable.hall_room, R.drawable.master_bed_room
    };
    ArrayList<Room> roomArrayList = new ArrayList<>();
    TextView mAddRoomTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // prepareDummyRooms();
        gridRecyclerView = findViewById(R.id.recyclerView);
        mTitleAddNewRoom= findViewById(R.id.titleAddNewRoom);
        gridRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mAddRoomTextView = (TextView)findViewById(R.id.add_room);
        myGridAdapter = new MyGridAdapter(diff_util,this);

        if(roomArrayList.size()==0){
            mAddRoomTextView.setVisibility(View.VISIBLE);
            gridRecyclerView.setVisibility(View.GONE);
            mTitleAddNewRoom.setVisibility(View.GONE);
        } else {
            mAddRoomTextView.setVisibility(View.GONE);
            gridRecyclerView.setVisibility(View.VISIBLE);
            gridRecyclerView.setAdapter(myGridAdapter);
            myGridAdapter.submitList(roomArrayList);
        }
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                /*Snackbar.make(view, "Add Room", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    //builder.setTitle(R.string.enter_room_name);

// I'm using fragment here so I'm using getView() to provide ViewGroup
// but you can provide here any other instance of ViewGroup from your Fragment / Activity
                    View viewInflated = LayoutInflater.from(view.getContext()).inflate(R.layout.enterroom, null, false);
// Set up the input
                    // final EditText input = (EditText) viewInflated.findViewById(R.id.input);
                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                            android.R.layout.simple_dropdown_item_1line, ROOMS);
                    final AutoCompleteTextView textView = (AutoCompleteTextView)
                            viewInflated.findViewById(R.id.input);
                    textView.setAdapter(adapter);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                    builder.setView(viewInflated);


// Set up the buttons
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            String enteredRoom = textView.getText().toString();
                            Room room = new Room();
                            room.setRoomName(enteredRoom);
                            roomArrayList.add(room);
                            gridRecyclerView.setVisibility(View.VISIBLE);
                            mTitleAddNewRoom.setVisibility(View.VISIBLE);
                            mAddRoomTextView.setVisibility(View.GONE);
                            myGridAdapter.submitList(roomArrayList);
                            gridRecyclerView.setAdapter(myGridAdapter);
                            //adapter.notifyDataSetChanged();
                            //Snackbar.make(textView.getRootView(), enteredRoom, Snackbar.LENGTH_LONG)
                            //      .setAction("Action", null).show();
                        }
                    });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();
                }
            });

    }

    private void prepareDummyRooms() {
        Room room = new Room();
        room.setRoomName("Master Bed Room");
        roomArrayList.add(room);

        Room room_two = new Room();
        room_two.setRoomName("Bed Room");
        roomArrayList.add(room_two);

        Room room_three = new Room();
        room_three.setRoomName("Wash Room");
        roomArrayList.add(room_three);


        Room room_four = new Room();
        room_four.setRoomName("Kitchen");
        roomArrayList.add(room_four);

        Room room_five = new Room();
        room_five.setRoomName("Hall");
        roomArrayList.add(room_five);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();

    }

    DiffUtil.ItemCallback diff_util =  new DiffUtil.ItemCallback<Room>() {
        @Override
        public boolean areItemsTheSame(@NonNull Room o, @NonNull Room t1) {
            return o.equals(t1);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Room o, @NonNull Room t1) {
            return ((Room)o).getRoomName().equals(((Room)t1).getRoomName());
        }
    };

    @Override
    public void onDeleteClick(View view) {
        mTitleAddNewRoom.setVisibility(View.GONE);

        mAddRoomTextView.setVisibility(View.VISIBLE);
        gridRecyclerView.setVisibility(View.GONE);
    }
}
