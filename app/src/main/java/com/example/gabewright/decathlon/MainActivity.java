package com.example.gabewright.decathlon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FragmentPagerAdapter adapterViewPager;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getFragmentManager().beginTransaction().replace(R.id.fragment_container, new RecyclerViewFragmentEvents())
          //     .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(android.support.v4.app.FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return RecyclerViewFragmentEvents.newInstance(0, "Events");
                case 1:
                    return CalculatorFragment.newInstance(1, "Calculator");

                default:
                    return null;
                }

        }

        @Override
        public CharSequence getPageTitle(int position) {

            String events = "Events";
            String calc = "Calculator";
            String results = "Results";

            switch (position) {
                case 0:
                    return events;
                case 1:
                    return calc;
                default:
                    return null;
            }
        }
    }
}
