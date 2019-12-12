package net.ticket.loca.locabus.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import net.ticket.loca.locabus.fragments.home_fragments.InterCityBusFragment;
import net.ticket.loca.locabus.fragments.home_fragments.LocalStationFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new InterCityBusFragment(); //ChildFragment1 at position 0
            case 1:
                return new LocalStationFragment(); //ChildFragment2 at position 1

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2; //three fragments
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Intercity Bus";
        }
        else if (position == 1)
        {
            title = "Local Bus Service";
        }

        return title;
    }
}