package adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smart.digihome.R;

import fragments.RoomAppliancesFragment;

import static adapter.MyGridAdapter.KEY_ROOM_IMAGE_ID;
import static adapter.MyGridAdapter.KEY_ROOM_NAME;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };

    public static final String[] ROOMS = new String[] {
            "Bed Room", "Wash Room", "Kitchen", "Hall", "Master Bed Room"
    };
    public static final int[] roomImages = new int[] {
            R.drawable.bed_room, R.drawable.wash_room,R.drawable.kitchen_room, R.drawable.hall_room, R.drawable.master_bed_room
    };

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return ROOMS.length;
    }

    @Override
    public Fragment getItem(int position) {
        RoomAppliancesFragment roomAppliancesFragment = RoomAppliancesFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ROOM_IMAGE_ID,roomImages[position]);
        bundle.putString(KEY_ROOM_NAME,ROOMS[position]);

        roomAppliancesFragment.setArguments(bundle);
        return roomAppliancesFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return ROOMS[position];
    }
}
