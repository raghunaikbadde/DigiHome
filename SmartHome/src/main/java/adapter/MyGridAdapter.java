package adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart.digihome.HomeActivity;
import com.smart.digihome.R;
import com.smart.digihome.RoomAppliancesActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import pojo.Room;

public class MyGridAdapter extends ListAdapter<Room,MyGridAdapter.ViewHolder> {

    private ArrayList<Room> mRoomArrayList;
    private clickEvents clickEvents;
    public static final String KEY_ROOM_IMAGE_ID= "KEY_ROOM_IMAGE_ID";
    public static final String KEY_ROOM_NAME= "KEY_ROOM_NAME";
    public  MyGridAdapter(@NonNull DiffUtil.ItemCallback<Room> diffCallback,clickEvents clickEvents) {
        super(diffCallback);
        this.clickEvents = clickEvents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.roundedrectanglecard, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Room room = getItem(i);
        viewHolder.roomName.setText(room.getRoomName());
        if(room.getImageId()!=0)
        viewHolder.roomImageView.setImageResource(room.getImageId());

    }

    @Override
    public void submitList(@Nullable List<Room> list) {
        super.submitList(list);
        mRoomArrayList = (ArrayList<Room>) list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView roomName;
        FloatingActionButton editName;
        FloatingActionButton deleteRoom;
        ImageView roomImageView;
        CardView cardView;
        ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            cardView.setClickable(true);
            cardView.setOnClickListener(this);
            cardView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View view) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    //builder.setTitle(R.string.update_room_name);

// I'm using fragment here so I'm using getView() to provide ViewGroup
// but you can provide here any other instance of ViewGroup from your Fragment / Activity
                    View viewInflated = LayoutInflater.from(view.getContext()).inflate(R.layout.updateroomname, null, false);
// Set up the input
                    // final EditText input = (EditText) viewInflated.findViewById(R.id.input);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                            android.R.layout.simple_dropdown_item_1line, HomeActivity.COUNTRIES);
                    final AutoCompleteTextView textView = (AutoCompleteTextView)
                            viewInflated.findViewById(R.id.input);
                    textView.setText(getItem(getAdapterPosition()).getRoomName());
                    textView.setHint(R.string.update_room_name);
                    textView.setAdapter(adapter);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                    builder.setView(viewInflated);


// Set up the buttons
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            String newRoomName = textView.getText().toString();
                            getItem(getAdapterPosition()).setRoomName(newRoomName);
                            notifyItemChanged(getAdapterPosition());

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
                    return false;
                }
            });
            editName = itemView.findViewById(R.id.editRoomButton);
            roomName = itemView.findViewById(R.id.roomName);
            deleteRoom = itemView.findViewById(R.id.deleteRoomButton);
            roomImageView = itemView.findViewById(R.id.ivImage);
            editName.setOnClickListener(this);
            deleteRoom.setOnClickListener(this);
        }

        @Override
        public void onClick(final View view) {
            final Room room = getItem(getAdapterPosition());
            switch (view.getId()){
                case R.id.cardview:
                    Intent intent = new Intent(view.getContext(), RoomAppliancesActivity.class);
                    intent.putExtra(KEY_ROOM_IMAGE_ID,room.getImageId());
                    intent.putExtra(KEY_ROOM_NAME,room.getRoomName());
                    view.getContext().startActivity(intent);
                    break;
                case R.id.editRoomButton:
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle(R.string.update_room_name);

// I'm using fragment here so I'm using getView() to provide ViewGroup
// but you can provide here any other instance of ViewGroup from your Fragment / Activity
                    View viewInflated = LayoutInflater.from(view.getContext()).inflate(R.layout.updateroomname, null, false);
// Set up the input
                    // final EditText input = (EditText) viewInflated.findViewById(R.id.input);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                            android.R.layout.simple_dropdown_item_1line, HomeActivity.COUNTRIES);
                    final AutoCompleteTextView textView = (AutoCompleteTextView)
                            viewInflated.findViewById(R.id.input);
                    textView.setText(room.getRoomName());
                    textView.setHint(R.string.update_room_name);
                    textView.setAdapter(adapter);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                    builder.setView(viewInflated);


// Set up the buttons
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            String newRoomName = textView.getText().toString();
                            room.setRoomName(newRoomName);
                            notifyItemChanged(getAdapterPosition());

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
                    break;
                case R.id.deleteRoomButton:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(view.getContext());
                    builder2.setTitle("Delete Room?");
                    builder2.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //mRoomArrayList.remove(getAdapterPosition());
                            mRoomArrayList.remove(getAdapterPosition());
                            submitList(mRoomArrayList);
                            notifyItemRemoved(getAdapterPosition());
                            if(mRoomArrayList.size()==0){
                                clickEvents.onDeleteClick(view);
                            }


                            //enteredRoom = textView.getText().toString();
                            //Snackbar.make(textView.getRootView(), enteredRoom, Snackbar.LENGTH_LONG)
                            //      .setAction("Action", null).show();
                        }
                    });
                    builder2.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder2.show();
                    break;
            }


            }

    }

    public interface clickEvents{
        public void onDeleteClick(View view);
    }


}
