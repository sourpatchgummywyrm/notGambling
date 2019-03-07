package com.example.a2021999.notgambling;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by 2021999 on 3/3/19.
 */

public class PagerViewAdapter extends FragmentPagerAdapter {

    public PagerViewAdapter(FragmentManager fm) {
        super( fm );
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case 0:
                fragment = new Profile();
                break;
            case 1:
                fragment = new Shop();
                break;
            case 2:
                fragment = new Game();
            break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
//    @Override
//    public int getItemPosition(Object object) {
////        Profile f = (Profile ) object;
////        if (f != null) {
////            f.update();
////        }
////        return super.getItemPosition(object);
//        return POSITION_NONE;
//    }
}
