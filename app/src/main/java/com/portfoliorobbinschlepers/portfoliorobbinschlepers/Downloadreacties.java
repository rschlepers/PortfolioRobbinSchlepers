package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rschlepers on 20-2-2017.
 */

public class Downloadreacties extends AsyncTask<Void,Integer,String> {

    Context context;
    String adres;
    ListView lv;
    ProgressDialog pd;

    public Downloadreacties(Context context, String adres, ListView lv){
        this.context = context;
        this.adres = adres;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(context);
        pd.setTitle("haal data");
        pd.setMessage("Data ophalen...");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        String data=downloadData();
        return data;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        if(s != null){
            Parserreacties p=new Parserreacties(context,s,lv);
            p.execute();
        }
        else{
            Toast.makeText(context, "Reacties ophalen niet gelukt",Toast.LENGTH_SHORT).show();
        }
    }

    private String downloadData() {
        InputStream is = null;
        String line = null;

        try {
            URL url = new URL(adres);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb=new StringBuffer();

            if(br != null)
            {
                while((line=br.readLine()) != null){
                    sb.append(line+"\n");
                }
            }
            else {
                return null;
            }
            return sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
