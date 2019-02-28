package com.example.deguzman.plantease;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class deactivate extends AsyncTask<Void,Void,Void> {
    String result="";
    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL("http://172.20.10.5:8080/Scans/?format=json");

            String urlParameters = "status=False";

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
            connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US, en; 0.5");

            connection.setDoOutput(true);

            DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());
            dStream.writeBytes(urlParameters);
            dStream.flush();
            dStream.close();

            int responseCode = connection.getResponseCode();

            final StringBuilder output = new StringBuilder("Request URL" + url);
            output.append(System.getProperty("line.separator") + "Response Code" + responseCode);
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));

            String line = "";
            StringBuilder responseOutput = new StringBuilder();
            System.out.println("output========="+br);
            while((line = br.readLine()) != null){
                responseOutput.append(line);
            }
            br.close();

            output.append(System.getProperty("line.separator") + "Response"+
                    System.getProperty("line.separator") + System.getProperty("line.separator")
                    + responseOutput.toString());

            result = ""+output;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;


    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

//        ScanActivity.outputPost.setText((this.result));
    }
}

