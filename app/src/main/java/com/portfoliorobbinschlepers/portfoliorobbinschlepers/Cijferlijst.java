package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Cijferlijst extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    String gebruikersnaam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cijferlijst);

        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            gebruikersnaam = bundle.getString("key");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
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
            TextView tv_Cijferlijst1;
            TextView tv_Cijferlijst2;
            TextView tv_Cijferlijst3;
            TextView tv_Cijferlijst4;
            TextView tv_reactie;


            if(getArguments().getInt(ARG_SECTION_NUMBER)==1) {

                View rootView = inflater.inflate(R.layout.fragment_cijferlijst, container, false);

                tv_Cijferlijst1 = (TextView) rootView.findViewById(R.id.tv_Cijferlijst1);
                String text1 = "";

                try{
                    InputStream is = getActivity().getAssets().open("Cijferlijst_leerjaar1.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text1 = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_Cijferlijst1.setText(text1);

                return rootView;

            }

            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                View rootView = inflater.inflate(R.layout.fragment_cijferlijst1, container, false);

                tv_Cijferlijst2 = (TextView) rootView.findViewById(R.id.tv_Cijferlijst2);
                String text1 = "";

                try{
                    InputStream is = getActivity().getAssets().open("Cijferlijst_leerjaar2.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text1 = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_Cijferlijst2.setText(text1);

                return rootView;

            }

            else if(getArguments().getInt(ARG_SECTION_NUMBER)==3) {
                View rootView = inflater.inflate(R.layout.fragment_cijferlijst2, container, false);

                tv_Cijferlijst3 = (TextView) rootView.findViewById(R.id.tv_Cijferlijst3);
                String text1 = "";

                try{
                    InputStream is = getActivity().getAssets().open("Cijferlijst_leerjaar3.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text1 = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_Cijferlijst3.setText(text1);

                return rootView;
            }

            else if(getArguments().getInt(ARG_SECTION_NUMBER)==4) {
                View rootView = inflater.inflate(R.layout.fragment_cijferlijst3, container, false);

                tv_Cijferlijst4 = (TextView) rootView.findViewById(R.id.tv_Cijferlijst4);
                String text1 = "";

                try{
                    InputStream is = getActivity().getAssets().open("Cijferlijst_leerjaar4.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text1 = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_Cijferlijst4.setText(text1);

                return rootView;
            }

           else {
                View rootView = inflater.inflate(R.layout.fragment_cijferlijst, container, false);
                return rootView;
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Leerjaar 1";
                case 1:
                    return "Leerjaar 2";
                case 2:
                    return "Leerjaar 3";
                case 3:
                    return "Leerjaar 4";

            }
            return null;
        }
    }
}