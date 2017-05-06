package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Reacties extends AppCompatActivity {

    private static String gebruikersnaam;
    String reactie;
    String type;
    String welkeid;
    EditText et_Plaatsreatie;
    TextView tv_reactie;
    Button bt_updatereactie;
    Button bt_verwijderreactie;
    String url="http://10.0.2.2/reactiesophalen.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reacties);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bt_updatereactie = (Button) findViewById(R.id.bt_updatereactie);
        bt_verwijderreactie = (Button) findViewById(R.id.bt_verwijderreactie);
        bt_updatereactie.setVisibility(View.INVISIBLE);
        bt_verwijderreactie.setVisibility(View.INVISIBLE);

        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            gebruikersnaam = bundle.getString("key");
        }

        et_Plaatsreatie = (EditText)findViewById(R.id.et_Plaatsreatie);
        tv_reactie = (TextView) findViewById(R.id.tv_reactie);

        String text1 = "";
        try{
            InputStream is = getAssets().open("Reactie.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text1 = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv_reactie.setText(text1);

        final ListView lv= (ListView) findViewById(R.id.lv);
        final Downloadreacties d = new Downloadreacties(this, url,lv);
        d.execute();
    }


    public void OnPlaatsreactie (View view) {
        reactie = et_Plaatsreatie.getText().toString();
        type = "nieuw";
        ReactienaarDatabase reactienaardatabase = new ReactienaarDatabase(this);
        reactienaardatabase.execute(gebruikersnaam, reactie, type);
        ListView lv= (ListView) findViewById(R.id.lv);
        Downloadreacties d = new Downloadreacties(this, url,lv);
        d.execute();
        et_Plaatsreatie.setText("");

    }

    public void OnVerwijderreactie (View view) {
        welkeid = Parserreacties.getwelkeid();
        type = "verwijder";
        ReactienaarDatabase reactienaardatabase = new ReactienaarDatabase(this);
        reactienaardatabase.execute(gebruikersnaam, welkeid, type);
        ListView lv= (ListView) findViewById(R.id.lv);
        Downloadreacties d = new Downloadreacties(this, url,lv);
        d.execute();
        et_Plaatsreatie.setText("");
        bt_updatereactie.setVisibility(View.INVISIBLE);
        bt_verwijderreactie.setVisibility(View.INVISIBLE);
    }

    public void OnUpdatereactie (View view) {
      welkeid = Parserreacties.getwelkeid();
        reactie = et_Plaatsreatie.getText().toString();
      type = "update";
        ReactienaarDatabase reactienaardatabase = new ReactienaarDatabase(this);
        reactienaardatabase.execute(reactie, welkeid, type);
        ListView lv= (ListView) findViewById(R.id.lv);
        Downloadreacties d = new Downloadreacties(this, url,lv);
        d.execute();
        et_Plaatsreatie.setText("");
        bt_updatereactie.setVisibility(View.INVISIBLE);
        bt_verwijderreactie.setVisibility(View.INVISIBLE);

    }

    public static String getGebruiksnaam() {
        return gebruikersnaam;
    }


}
