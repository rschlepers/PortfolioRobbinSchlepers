package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Introductie extends AppCompatActivity {

    TextView tv_Naam;
    TextView tv_Studentnummer;
    TextView tv_Opleiding;
    TextView tv_Jaar;
    TextView tv_Introductie;
    TextView tv_Navigatie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_Naam = (TextView) findViewById(R.id.tv_Naam);
        tv_Studentnummer = (TextView) findViewById(R.id.tv_Studentnummer);
        tv_Opleiding = (TextView) findViewById(R.id.tv_Opleiding);
        tv_Jaar = (TextView) findViewById(R.id.tv_Jaar);
        tv_Introductie = (TextView) findViewById(R.id.tv_Introductie);
        tv_Navigatie = (TextView) findViewById(R.id.tv_Navigatie);

        String text1 = "";
        String text2 = "";
        String text3 = "";
        String text4 = "";
        String text5 = "";
        String text6 = "";

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
            InputStream is = getAssets().open("Studentnummer.txt");
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

        try{
            InputStream is = getAssets().open("Introductie_introductie.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text5 = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            InputStream is = getAssets().open("Introductie_navigatie.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text6 = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }


        tv_Naam.setText(text1);
        tv_Studentnummer.setText(text2);
        tv_Opleiding.setText(text3);
        tv_Jaar.setText(text4);
        tv_Introductie.setText(text5);
        tv_Navigatie.setText(text6);

    }


    public void OnTerug (View view) {
        startActivity(new Intent(Introductie.this, Welkomspagina.class));
    }
}
