package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import static android.R.attr.key;

public class Opleiding extends AppCompatActivity {

    TextView tv_Opleiding;
    String gebruikersnaam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opleiding);

        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            gebruikersnaam = bundle.getString("key");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tv_Opleiding = (TextView) findViewById(R.id.tv_Opleiding);

        String text1 = "";
        try{
            InputStream is = getAssets().open("Opleidingdeel.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text1 = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_Opleiding.setText(text1);
    }

    public void OnTerug (View view) {
        startActivity(new Intent(Opleiding.this, Welkomspagina.class));
    }

    public void OnC1 (View view) {
        String welkepagina;
        welkepagina = "C1";

        Intent activity = new Intent(Opleiding.this, Competentie.class);
        activity.putExtra("key", welkepagina);
        activity.putExtra("naam", gebruikersnaam);
        startActivity(activity);
    }

    public void OnC2 (View view) {
        String welkepagina;
        welkepagina = "C2";

        Intent activity = new Intent(Opleiding.this, Competentie.class);
        activity.putExtra("key", welkepagina);
        activity.putExtra("naam", gebruikersnaam);
        startActivity(activity);
    }

    public void OnC3 (View view) {
        String welkepagina;
        welkepagina = "C3";

        Intent activity = new Intent(Opleiding.this, Competentie.class);
        activity.putExtra("key", welkepagina);
        activity.putExtra("naam", gebruikersnaam);
        startActivity(activity);
    }

    public void OnC4 (View view) {
        String welkepagina;
        welkepagina = "C4";

        Intent activity = new Intent(Opleiding.this, Competentie.class);
        activity.putExtra("key", welkepagina);
        activity.putExtra("naam", gebruikersnaam);
        startActivity(activity);
    }

    public void OnC5 (View view) {
        String welkepagina;
        welkepagina = "C5";

        Intent activity = new Intent(Opleiding.this, Competentie.class);
        activity.putExtra("key", welkepagina);
        activity.putExtra("naam", gebruikersnaam);
        startActivity(activity);
    }

    public void OnC6 (View view) {
        String welkepagina;
        welkepagina = "C6";

        Intent activity = new Intent(Opleiding.this, Competentie.class);
        activity.putExtra("key", welkepagina);
        activity.putExtra("naam", gebruikersnaam);
        startActivity(activity);
    }

    public void OnC7 (View view) {
        String welkepagina;
        welkepagina = "C7";

        Intent activity = new Intent(Opleiding.this, Competentie.class);
        activity.putExtra("key", welkepagina);
        activity.putExtra("naam", gebruikersnaam);
        startActivity(activity);
    }


}
