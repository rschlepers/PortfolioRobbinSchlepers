package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Persoonlijk extends AppCompatActivity {

    TextView tv_Persoonlijk;
    String gebruikersnaam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persoonlijk);

        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            gebruikersnaam = bundle.getString("key");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_Persoonlijk = (TextView) findViewById(R.id.tv_Persoonlijk);

        String text1 = "";
        try{
            InputStream is = getAssets().open("Persoonlijkdeel.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text1 = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_Persoonlijk.setText(text1);
    }

    public void OnBeroepsprofiel (View view) {
        Intent activity = new Intent(Persoonlijk.this, Beroepsprofiel.class);
        activity.putExtra("key", gebruikersnaam);
        startActivity(activity);
    }

    public void OnCijferlijst (View view) {
        Intent activity = new Intent(Persoonlijk.this, Cijferlijst.class);
        activity.putExtra("key", gebruikersnaam);
        startActivity(activity);
    }

    public void OnCV (View view) {
        Intent activity = new Intent(Persoonlijk.this, Curriculumvitae.class);
        activity.putExtra("key", gebruikersnaam);
        startActivity(activity);
    }
}
