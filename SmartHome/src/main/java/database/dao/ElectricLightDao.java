package database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import pojo.ElectricFan;
import pojo.ElectricLight;

@Dao
public interface ElectricLightDao {
    @Query("SELECT *FROM ElectricLight")
    public List<ElectricLight> getElectricLight();
}
