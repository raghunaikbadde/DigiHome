package database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import pojo.FourModularSwitchBoard;

@Dao
public interface FourModularSwitchBoardDao {
    @Query("SELECT *FROM FourModularSwitchBoard")
    public List<FourModularSwitchBoard> getFourModularSwitchBoard();
}
