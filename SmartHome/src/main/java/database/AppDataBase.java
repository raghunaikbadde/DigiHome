package database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import database.dao.ApplianceDao;
import database.dao.ElectricFanDao;
import database.dao.ElectricLightDao;
import database.dao.FourModularSwitchBoardDao;
import database.dao.Roomdao;
import database.dao.SixModularSwitchBoardDao;
import database.dao.SwitchBoardDao;
import database.dao.SwitchDao;
import database.dao.TwoModularSwitchBoardDao;
import pojo.Appliance;
import pojo.ElectricFan;
import pojo.ElectricLight;
import pojo.FourModularSwitchBoard;
import pojo.Room;
import pojo.SixModularSwitchBoard;
import pojo.Switch;
import pojo.SwitchBoard;
import pojo.TwoModularSwitchBoard;

@Database(entities = {Appliance.class, ElectricFan.class, ElectricLight.class, FourModularSwitchBoard.class, Room.class, SixModularSwitchBoard.class, Switch.class, SwitchBoard.class, TwoModularSwitchBoard.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ApplianceDao ApplianceDao();
    public abstract ElectricFanDao ElectricFanDAo();
    public abstract ElectricLightDao ElectricLightDao();
    public abstract FourModularSwitchBoardDao FourModularSwitchBoardDao();
    public abstract Roomdao Roomdao();
    public abstract SixModularSwitchBoardDao SixModularSwitchBoardDao();
    public abstract SwitchBoardDao SwitchBoardDao();
    public abstract SwitchDao SwitchDao();
    public abstract TwoModularSwitchBoardDao TwoModularSwitchBoardDao();


    private static AppDataBase INSTANCE;

    public static AppDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                  android.arch.persistence.room.Room.databaseBuilder(context,
                          AppDataBase.class, "digihome").
                          allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
