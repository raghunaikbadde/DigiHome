package database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import pojo.ElectricFan;

@Dao
public interface ElectricFanDao {
    @Query("SELECT *FROM ElectricFan")
    public List<ElectricFan> getElectricFans();
}
