package pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class SwitchBoard {

    @PrimaryKey(autoGenerate = true)
    private int SBid;

    @ColumnInfo(name = "switchBoardName")
    private String switchBoardName;

    public String getSwitchBoardName() {
        return switchBoardName;
    }

    public void setSwitchBoardName(String switchBoardName) {
        this.switchBoardName = switchBoardName;
    }


    public int getSBid() {
        return SBid;
    }

    public void setSBid(int SBid) {
        this.SBid = SBid;
    }
}
