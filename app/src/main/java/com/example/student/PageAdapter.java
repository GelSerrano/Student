package com.example.student;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(@NonNull FragmentManager fm,int not) {
        super(fm);
        this.numOfTabs = not;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return new Frag_prelim();
            case 1:
                return new Frag_midterm();
            case 2:
                return new Frag_finals();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs ;
    }
}
