package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by rschlepers on 20-2-2017.
 */

public class Parserreacties extends AsyncTask<Void, Integer, Integer>{


    ListView lv;
    String data;
    String gebruikersnaam;
    static String welkeid;
    ArrayList<String> ids=new ArrayList<>();
    ArrayList<String> gebruikers=new ArrayList<>();
    ArrayList<String> reacties=new ArrayList<>();
    ArrayList<String> inhoud=new ArrayList<>();
    ProgressDialog pd;
    EditText textview;
    Context context;

    public Parserreacties(Context context, String data, ListView lv){
        this.context = context;
        this.data = data;
        this.lv = lv;
        this.context=context;
          }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();

        pd=new ProgressDialog(context);
        pd.setTitle("Parser");
        pd.setMessage("Parsing....");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        if(integer == 1){
           ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,reacties);
            lv.setAdapter(adapter);
            gebruikersnaam = Reacties.getGebruiksnaam();


           lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

               @RequiresApi(api = Build.VERSION_CODES.KITKAT)
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   if(Objects.equals(gebruikers.get(position), gebruikersnaam)) {
                       EditText edittext = (EditText) ((Reacties)context).findViewById(R.id.et_Plaatsreatie);
                       Button bt_updatereactie = (Button) ((Reacties)context).findViewById(R.id.bt_updatereactie);
                       Button bt_verwijderreactie = (Button) ((Reacties)context).findViewById(R.id.bt_verwijderreactie);
                       bt_updatereactie.setVisibility(View.VISIBLE);
                       bt_verwijderreactie.setVisibility(View.VISIBLE);
                       edittext.setText(inhoud.get(position));
                       welkeid = ids.get(position);
                       Snackbar.make(view, "Je kunt nu je reactie bewerken of verwijderen.", Snackbar.LENGTH_SHORT).show();
                   }
                   else {
                       Snackbar.make(view, "Geen rechten om reactie te bewerken", Snackbar.LENGTH_SHORT).show();
                   }
               }
            });

        }else {
            Toast.makeText(context,"Niet in staat om dat om te vormen",Toast.LENGTH_SHORT).show();
        }
        pd.dismiss();
    }

    private int parse(){
        try {
            JSONArray ja=new JSONArray(data);
            JSONObject jo=null;

            reacties.clear();

            for (int i=0;i<ja.length();i++){
                jo=ja.getJSONObject(i);
                String tekst=jo.getString("reactie");
                String naam=jo.getString("gebruiker");
                String id=jo.getString("id");
                String reactie= naam + ": " + tekst;

                inhoud.add(tekst);
                ids.add(id);
                gebruikers.add(naam);
                reacties.add(reactie);
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static String getwelkeid() {
        return welkeid;
    }

    }
