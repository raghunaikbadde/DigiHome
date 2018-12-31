package pojo;

import com.smart.digihome.HomeActivity;

public class Room {
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

    String roomName;
    String imageType;
    int imageId=0;

}
