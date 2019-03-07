package com.example.a2021999.notgambling;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    //private SectionsPagerAdapter mSectionsPagerAdapter;
    PagerViewAdapter pagerViewAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    TextView inventory;
    View.OnClickListener listener;
    private static final String INFO_FILE = "info.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pagerViewAdapter = new PagerViewAdapter( getSupportFragmentManager() );
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(pagerViewAdapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        inventory = (TextView)findViewById( R.id.inventory );
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        mViewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               // mViewPager.getAdapter().notifyDataSetChanged();
//                if(position == 0) {
//                    int lootBoxNum = 0;
//                    int money = 1000;
//                    SharedPreferences prefs = getSharedPreferences("nom", MODE_PRIVATE);
//                        lootBoxNum = prefs.getInt("boxes", 0); // will return 0 if no  value is saved
//                        money = prefs.getInt("money", 100);
//                        inventory.setText("Lootboxes: "+lootBoxNum+"\nCash: "+money);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        } );
        setTitle("Not Gambling");
        //load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    @SuppressLint("ValidFragment")
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_profile, container, false);;
//            switch(getArguments().getInt(ARG_SECTION_NUMBER)) {
//                case 1:
//                    //something
//                    rootView = inflater.inflate(R.layout.fragment_profile, container, false);
//                    load(getActivity(), rootView);
//                    break;
//                case 2:
//                    //something
//                    rootView = inflater.inflate(R.layout.fragment_shop, container, false);
//                    Button boxBuy = rootView.findViewById(R.id.buyBox);
//                    boxBuy.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            lootBoxNum += 1;
//                            money -= 100;
//                            Toast.makeText(getActivity(), "Bought a box!", Toast.LENGTH_LONG).show();
//                            save(getContext());
//                        }
//                    });
//                    Button restart = rootView.findViewById(R.id.restart);
//                    restart.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Toast.makeText(getView().getContext(), "Restarted values", Toast.LENGTH_SHORT).show();
//                            lootBoxNum = 0;
//                            money = 1000;
//                            save(getContext());
//                        }
//                    });
//                    break;
//                case 3:
//                    rootView = inflater.inflate(R.layout.fragment_game, container, false);
//                    break;
//                default:
//                    rootView = inflater.inflate(R.layout.fragment_profile, container, false);;
//                    break;
//            }

            return rootView;

        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
//    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//        @Override
//        public int getItemPosition(Object object) {
//            return POSITION_NONE;
//        }
//        @Override
//        public Fragment getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);
////            switch (position) {
////                case 0:
////                    return new Profile();
////                    break;
////
////            }
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            return 3;
//        }
//    }

//    public static void save(Context c) {
//        SharedPreferences.Editor editor = c.getSharedPreferences("nom", MODE_PRIVATE).edit();
//        editor.putInt("boxes", lootBoxNum);
//        editor.putInt("money", money);
//        editor.commit();
//
//    }
//
//    public static void load(Activity a, View v) {
//        TextView inventory = v.findViewById(R.id.inventory);
//        SharedPreferences prefs = a.getSharedPreferences("nom", MODE_PRIVATE);
//        try {
//            lootBoxNum = prefs.getInt("boxes", 0); // will return 0 if no  value is saved
//            money = prefs.getInt("money", 100);
//        } catch(NullPointerException e){
//            Log.i("Null", "Error");
//        }
//        inventory.setText("Lootboxes: "+lootBoxNum+"\nCash: "+money);
//    }
}
