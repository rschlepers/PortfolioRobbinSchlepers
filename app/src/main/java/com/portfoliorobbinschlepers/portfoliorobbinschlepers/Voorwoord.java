package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Voorwoord extends AppCompatActivity {

TextView tv_Voorwoord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voorwoord);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_Voorwoord = (TextView) findViewById(R.id.tv_Voorwoord);

        String text1 = "";
        try{
            InputStream is = getAssets().open("Voorwoord.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text1 = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_Voorwoord.setText(text1);

    }

    public void OnTerug (View view) {
        startActivity(new Intent(Voorwoord.this, Welkomspagina.class));
    }

}
