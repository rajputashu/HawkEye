package com.aad.ar.as.hawkeye.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aad.ar.as.hawkeye.MyFragment;

/**
 * Created by cirmac3 on 7/11/16.
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {


        MyFragment myFragment=new MyFragment().newInstance(position);

//        myFragment = HomeScreen.MyFragment.newInstance(position);
        return myFragment;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab " + (position + 1);
    }
}
