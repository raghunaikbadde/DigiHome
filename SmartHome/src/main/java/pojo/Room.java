package pojo;

import com.smart.digihome.HomeActivity;
import com.smart.digihome.R;

public class Room {
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
        for(int i = 0; i<HomeActivity.COUNTRIES.length;i++){
            if(roomName.equalsIgnoreCase(HomeActivity.COUNTRIES[i])){
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

    String roomName;
    String imageType;
    int imageId=0;

}
