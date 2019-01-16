package database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import pojo.Room;

@Dao
public interface Roomdao {

    @Query("SELECT *FROM Room WHERE roomName LIKE  :roomName1")
    public Room getRoom(String roomName1);

    @Insert
    public void insertRoom(Room room);

    @Insert
    public void insertAllRooms(Room... rooms);

}
