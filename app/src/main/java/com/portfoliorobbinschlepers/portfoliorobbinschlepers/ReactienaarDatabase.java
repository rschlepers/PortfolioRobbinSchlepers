package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ReactienaarDatabase extends AsyncTask<String, String, String> {
    Context context;
    AlertDialog alertDialog;
    public ReactienaarDatabase(Context ctx) {
        context = ctx;
    }
    String gebruikersnaam;
    String reactie;
    String id;

    @Override
    protected String doInBackground(String... params) {

        String plaatsreactie_url = "http://10.0.2.2/plaatsreactie.php";
        String verwijderreactie_url = "http://10.0.2.2/verwijderreactie.php";
        String updatereactie_url = "http://10.0.2.2/updatereactie.php";
        String type = params[2];

        if (type.equals("nieuw")) {
            try {
                gebruikersnaam = params[0];
                reactie = params[1];
                URL url = new URL(plaatsreactie_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("gebruiker", "UTF-8") + "=" + URLEncoder.encode(gebruikersnaam, "UTF-8") + "&"
                        + URLEncoder.encode("reactie", "UTF-8") + "=" + URLEncoder.encode(reactie, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String resultaat = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    resultaat += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return resultaat;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(type.equals("verwijder")) {
            try {
                gebruikersnaam = params[0];
                id = params[1];
                URL url = new URL(verwijderreactie_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String resultaat = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    resultaat += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return resultaat;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(type.equals("update")) {
            try {
                reactie = params[0];
                id = params[1];
                URL url = new URL(updatereactie_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&"
                        + URLEncoder.encode("reactie", "UTF-8") + "=" + URLEncoder.encode(reactie, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String resultaat = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    resultaat += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return resultaat;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
       alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Reactie status");
    }

    @Override
    protected void onPostExecute(String resultaat) {
        if(resultaat.contains("gelukt")) {
            Toast.makeText(context,resultaat,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,resultaat,Toast.LENGTH_SHORT).show();

        }
    }


}
