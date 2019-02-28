package com.example.deguzman.plantease;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Main3Activity extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public Main3Activity(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Main2Activity tab1 = new Main2Activity();
                return tab1;
            case 1:
                Main4Activity tab2 = new Main4Activity();
                return tab2;
            case 2:
                Main5Activity tab3 = new Main5Activity();
                return tab3;
            case 3:
                Main6Activity tab4 = new Main6Activity();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}