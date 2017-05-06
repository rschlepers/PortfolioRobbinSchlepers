package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class registreerpagina extends AppCompatActivity {
    EditText voornaam, achternaam, gebruikersnaam, wachtwoord;
    String str_voornaam, str_achternaam, str_gebruikersnaam, str_wachtwoord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registreerpagina);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        voornaam = (EditText)findViewById(R.id.etRegvoornaam);
        achternaam = (EditText)findViewById(R.id.etRegachternaam);
        gebruikersnaam = (EditText)findViewById(R.id.etReggebruikersnaam);
        wachtwoord = (EditText)findViewById(R.id.etRegwachtwoord);

    }

    public  void OnReg(View view) {
        String str_voornaam = voornaam.getText().toString();
        String str_achternaam = achternaam.getText().toString();
        String str_gebruikersnaam = gebruikersnaam.getText().toString();
        String str_wachtwoord = wachtwoord.getText().toString();
        String type = "registreer";

        AchtergrondCheck achtergrondCheck = new AchtergrondCheck(this);
        achtergrondCheck.execute(type, str_voornaam, str_achternaam, str_gebruikersnaam, str_wachtwoord);

    }
}
