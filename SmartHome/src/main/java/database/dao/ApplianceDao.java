package database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import pojo.Appliance;

@Dao
public interface ApplianceDao {
    @Query("SELECT *FROM Appliance")
    public Appliance getAppliance();

    @Insert
    void insertApplicance(Appliance appliance);

    @Delete
    void deleteAppliance(Appliance appliance);
}
