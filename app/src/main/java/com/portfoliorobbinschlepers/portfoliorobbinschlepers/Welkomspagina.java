package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Welkomspagina extends AppCompatActivity {


    TextView tv_Naam;
    TextView tv_Locatie;
    TextView tv_Opleiding;
    TextView tv_Jaar;
    String gebruikersnaam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welkomspagina);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            gebruikersnaam = bundle.getString("key");
        }



        tv_Naam = (TextView) findViewById(R.id.tv_Naam);
        tv_Locatie = (TextView) findViewById(R.id.tv_Locatie);
        tv_Opleiding = (TextView) findViewById(R.id.tv_Opleiding);
        tv_Jaar = (TextView) findViewById(R.id.tv_Jaar);

        String text1 = "";
        String text2 = "";
        String text3 = "";
        String text4 = "";

        try{
            InputStream is = getAssets().open("Naam.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text1 = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            InputStream is = getAssets().open("Locatie.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text2 = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            InputStream is = getAssets().open("Opleiding.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text3 = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            InputStream is = getAssets().open("Jaar.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text4 = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        tv_Naam.setText(text1);
        tv_Locatie.setText(text2);
        tv_Opleiding.setText(text3);
        tv_Jaar.setText(text4);

    }

    public void OnIntroductie (View view) {

        startActivity(new Intent(Welkomspagina.this, Introductie.class));

    }

    public void OnVoorwoord (View view) {
        startActivity(new Intent(Welkomspagina.this, Voorwoord.class));
    }

    public void OnPersoonlijk (View view) {
        Intent activity = new Intent(Welkomspagina.this, Persoonlijk.class);
        activity.putExtra("key", gebruikersnaam);
        startActivity(activity); }

    public void OnOpleiding (View view) {
        Intent activity = new Intent(Welkomspagina.this, Opleiding.class);
        activity.putExtra("key", gebruikersnaam);
        startActivity(activity);
    }

    public void OnReacties (View view) {
        Intent activity = new Intent(Welkomspagina.this, Reacties.class);
        activity.putExtra("key", gebruikersnaam);
        startActivity(activity);
    }




}
