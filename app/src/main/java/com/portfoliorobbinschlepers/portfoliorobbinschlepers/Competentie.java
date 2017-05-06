package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import static android.R.attr.key;

public class Competentie extends AppCompatActivity {

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
    private String welkepagina;
    String gebruikersnaam;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competentie);


        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            welkepagina = bundle.getString("key");
            gebruikersnaam = bundle.getString("naam");
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

            TextView tv_competentie;
            TextView tv_pop;
            TextView tv_resultaat;
            TextView tv_reflectie;
            TextView tv_competentietitel;
            TextView tv_bewijs;


            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                View rootView = inflater.inflate(R.layout.fragment_competentie, container, false);

                tv_competentie = (TextView) rootView.findViewById(R.id.tv_competentie);
                tv_competentietitel = (TextView) rootView.findViewById(R.id.tv_competentietitel);
                String text1 = "";
                String C1 = "Interpersoonlijk";
                String C2 = "Pedagogisch";
                String C3 = "Vakinhoudelijk en didactisch";
                String C4 = "Organisatorisch";
                String C5 = "Samenwerken met collega’s";
                String C6 = "Samenwerken met de omgeving";
                String C7 = "Reflectie en ontwikkeling";
                String welkepagina = ((Competentie) getActivity()).welkepagina;

                try {
                    InputStream is = getActivity().getAssets().open(welkepagina + "_competentie.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text1 = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_competentie.setText(text1);

                if (welkepagina.equals("C1")) {

                    tv_competentietitel.setText(C1);
                } else if (welkepagina.equals("C2")) {

                    tv_competentietitel.setText(C2);
                } else if (welkepagina.equals("C3")) {

                    tv_competentietitel.setText(C3);
                } else if (welkepagina.equals("C4")) {

                    tv_competentietitel.setText(C4);
                } else if (welkepagina.equals("C5")) {

                    tv_competentietitel.setText(C5);
                } else if (welkepagina.equals("C6")) {

                    tv_competentietitel.setText(C6);
                } else if (welkepagina.equals("C7")) {

                    tv_competentietitel.setText(C7);
                }


                return rootView;


            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                View rootView = inflater.inflate(R.layout.fragment_competentie1, container, false);

                tv_pop = (TextView) rootView.findViewById(R.id.tv_pop);
                String text1 = "";

                try {
                    InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_pop.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text1 = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_pop.setText(text1);


                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                View rootView = inflater.inflate(R.layout.fragment_competentie2, container, false);

                tv_resultaat = (TextView) rootView.findViewById(R.id.tv_resultaat);
                String text1 = "Resultaat";

                try {
                    InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_resultaat.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text1 = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_resultaat.setText(text1);

                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
                String welkepagina = ((Competentie) getActivity()).welkepagina;

                if (welkepagina.equals("C1")) {

                    View rootView = inflater.inflate(R.layout.fragment_c1_bewijs, container, false);

                    tv_bewijs = (TextView) rootView.findViewById(R.id.tv_bewijs);
                    String text1 = "";

                    try {
                        InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_bewijs.txt");
                        int size = is.available();
                        byte[] buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        text1 = new String(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tv_bewijs.setText(text1);

                    return rootView;
                } else if (welkepagina.equals("C2")) {

                    View rootView = inflater.inflate(R.layout.fragment_c2_bewijs, container, false);
                    tv_bewijs = (TextView) rootView.findViewById(R.id.tv_bewijs);
                    String text1 = "";

                    try {
                        InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_bewijs.txt");
                        int size = is.available();
                        byte[] buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        text1 = new String(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tv_bewijs.setText(text1);
                    return rootView;
                } else if (welkepagina.equals("C3")) {

                    View rootView = inflater.inflate(R.layout.fragment_c3_bewijs, container, false);
                    tv_bewijs = (TextView) rootView.findViewById(R.id.tv_bewijs);
                    String text1 = "";

                    try {
                        InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_bewijs.txt");
                        int size = is.available();
                        byte[] buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        text1 = new String(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tv_bewijs.setText(text1);
                    return rootView;
                } else if (welkepagina.equals("C4")) {

                    View rootView = inflater.inflate(R.layout.fragment_c4_bewijs, container, false);
                    tv_bewijs = (TextView) rootView.findViewById(R.id.tv_bewijs);
                    String text1 = "";

                    try {
                        InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_bewijs.txt");
                        int size = is.available();
                        byte[] buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        text1 = new String(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tv_bewijs.setText(text1);
                    return rootView;
                } else if (welkepagina.equals("C5")) {

                    View rootView = inflater.inflate(R.layout.fragment_c5_bewijs, container, false);
                    tv_bewijs = (TextView) rootView.findViewById(R.id.tv_bewijs);
                    String text1 = "";

                    try {
                        InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_bewijs.txt");
                        int size = is.available();
                        byte[] buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        text1 = new String(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tv_bewijs.setText(text1);
                    return rootView;
                } else if (welkepagina.equals("C6")) {

                    View rootView = inflater.inflate(R.layout.fragment_c6_bewijs, container, false);
                    tv_bewijs = (TextView) rootView.findViewById(R.id.tv_bewijs);
                    String text1 = "";

                    try {
                        InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_bewijs.txt");
                        int size = is.available();
                        byte[] buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        text1 = new String(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tv_bewijs.setText(text1);
                    return rootView;
                } else  {

                    View rootView = inflater.inflate(R.layout.fragment_c7_bewijs, container, false);
                    tv_bewijs = (TextView) rootView.findViewById(R.id.tv_bewijs);
                    String text1 = "";

                    try {
                        InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_bewijs.txt");
                        int size = is.available();
                        byte[] buffer = new byte[size];
                        is.read(buffer);
                        is.close();
                        text1 = new String(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    tv_bewijs.setText(text1);
                    return rootView;
                }


            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 5) {
                View rootView = inflater.inflate(R.layout.fragment_competentie4, container, false);

                tv_reflectie = (TextView) rootView.findViewById(R.id.tv_reflectie);
                String text1 = "reflectie";

                try {
                    InputStream is = getActivity().getAssets().open(((Competentie) getActivity()).welkepagina + "_reflectie.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text1 = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv_reflectie.setText(text1);

                return rootView;
            } else {
                View rootView = inflater.inflate(R.layout.fragment_competentie, container, false);
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
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "De competentie";
                case 1:
                    return "POP";
                case 2:
                    return "Resultaat";
                case 3:
                    return "Bewijs";
                case 4:
                    return "Reflectie";

            }
            return null;
        }
    }

    public void OnButton1 (View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://1drv.ms/b/s!ArZrOlFfU_3bhLUNrDWNO_-lXvcEQQ")));
    }
    public void OnButton2 (View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Z98hXV9GmzY")));
    }

}
