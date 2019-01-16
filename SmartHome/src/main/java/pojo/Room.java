package pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.smart.digihome.HomeActivity;

import java.util.ArrayList;

@Entity
public class Room {

    @PrimaryKey(autoGenerate = true)
    private int roomid;

    @Embedded(prefix = "sixModularSwitchBoardArrayList")
    private ArrayList<SixModularSwitchBoard> sixModularSwitchBoardArrayList = new ArrayList<>();
    @Embedded(prefix = "fourModularSwitchBoardArrayList")
    private ArrayList<FourModularSwitchBoard> fourModularSwitchBoardArrayList = new ArrayList<>();
    @Embedded(prefix = "twoModularSwitchBoardArrayList")
    private ArrayList<TwoModularSwitchBoard> twoModularSwitchBoardArrayList = new ArrayList<>();

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
        for(int i = 0; i<HomeActivity.ROOMS.length; i++){
            if(roomName.equalsIgnoreCase(HomeActivity.ROOMS[i])){
              imageId= HomeActivity.roomImages[i];
            }
        }
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageType() {
        return imageType;

    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @ColumnInfo(name = "roomName")
    String roomName;
    @ColumnInfo(name = "imageType")
    String imageType;
    @ColumnInfo(name = "imageId")
    int imageId=0;

    public ArrayList<SixModularSwitchBoard> getSixModularSwitchBoardArrayList() {
        return sixModularSwitchBoardArrayList;
    }

    public void setSixModularSwitchBoardArrayList(ArrayList<SixModularSwitchBoard> sixModularSwitchBoardArrayList) {
        this.sixModularSwitchBoardArrayList = sixModularSwitchBoardArrayList;
    }

    public ArrayList<FourModularSwitchBoard> getFourModularSwitchBoardArrayList() {
        return fourModularSwitchBoardArrayList;
    }

    public void setFourModularSwitchBoardArrayList(ArrayList<FourModularSwitchBoard> fourModularSwitchBoardArrayList) {
        this.fourModularSwitchBoardArrayList = fourModularSwitchBoardArrayList;
    }

    public ArrayList<TwoModularSwitchBoard> getTwoModularSwitchBoardArrayList() {
        return twoModularSwitchBoardArrayList;
    }

    public void setTwoModularSwitchBoardArrayList(ArrayList<TwoModularSwitchBoard> twoModularSwitchBoardArrayList) {
        this.twoModularSwitchBoardArrayList = twoModularSwitchBoardArrayList;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }
}
