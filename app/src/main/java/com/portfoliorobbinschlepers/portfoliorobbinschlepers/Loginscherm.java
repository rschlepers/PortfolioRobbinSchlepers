package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Loginscherm extends AppCompatActivity {
    EditText GebruikersnaamEt, WachtwoordET;
    String gebruikersnaam;
    String wachtwoord;
    String type;
    TextView tv_Naam;
    TextView tv_Locatie;
    TextView tv_Opleiding;
    TextView tv_Jaar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscherm);
        GebruikersnaamEt = (EditText)findViewById(R.id.etGebruikersnaam);
        WachtwoordET = (EditText)findViewById(R.id.etWachtwoord);


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

    public void OnLogin (View view) {
        gebruikersnaam = GebruikersnaamEt.getText().toString();
        wachtwoord = WachtwoordET.getText().toString();
        type = "login";

        AchtergrondCheck achtergrondCheck = new AchtergrondCheck(this);
        achtergrondCheck.execute(type, gebruikersnaam, wachtwoord);

       }

    public void OpenReg(View view) {
        startActivity(new Intent(this, registreerpagina.class));
    }
}
