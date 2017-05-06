package com.portfoliorobbinschlepers.portfoliorobbinschlepers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

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

public class AchtergrondCheck extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    AchtergrondCheck (Context ctx) {
        context = ctx;
    }
    String gebruikersnaam;

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://10.0.2.2/login.php";
        String registreer_url = "http://10.0.2.2/registreer.php";
        if(type.equals("login")) {
            try {
                gebruikersnaam = params[1];
                String wachtwoord = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("gebruikersnaam", "UTF-8")+"="+URLEncoder.encode(gebruikersnaam, "UTF-8")+"&"
                +URLEncoder.encode("wachtwoord", "UTF-8")+"="+URLEncoder.encode(wachtwoord, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String resultaat="";
                String line="";
                while ((line = bufferedReader.readLine())!= null) {
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
        else if(type.equals("registreer")) {
            try {
                String voornaam = params[1];
                String achternaam = params[2];
                String gebruikersnaam = params[3];
                String wachtwoord = params[4];
                URL url = new URL(registreer_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("voornaam", "UTF-8")+"="+URLEncoder.encode(voornaam, "UTF-8")+"&"
                + URLEncoder.encode("achternaam", "UTF-8")+"="+URLEncoder.encode(achternaam, "UTF-8")+"&"
                + URLEncoder.encode("gebruikersnaam", "UTF-8")+"="+URLEncoder.encode(gebruikersnaam, "UTF-8")+"&"
                        + URLEncoder.encode("wachtwoord", "UTF-8")+"="+URLEncoder.encode(wachtwoord, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String resultaat="";
                String line="";
                while ((line = bufferedReader.readLine())!= null) {
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
        alertDialog.setTitle("Login status");
        }

    @Override
    protected void onPostExecute(String resultaat) {
        if(resultaat.contains("Gelukt")) {

            Intent activity = new Intent(context, Welkomspagina.class);
            activity.putExtra("key", gebruikersnaam);
            context.startActivity(activity);


        }
        else {
            alertDialog.setMessage(resultaat);
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
