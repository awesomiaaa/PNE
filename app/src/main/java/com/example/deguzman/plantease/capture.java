package com.example.deguzman.plantease;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class capture extends AsyncTask<Void, Void, String> {
    String data="";
    String result = "";
    public static String urlParameters, urlParameters1, plant_name, specific_plant, plant_width, plot_size, plant_distance;



    @Override
    protected String doInBackground(Void... voids) {

        try {
            URL url = new URL("http://172.20.10.3:8080/capture/?format=json");
//            URL url = new URL("http://192.168.1.10:8080/Scans/?format=json");

            urlParameters = "status=true";

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

   /*         HttpURLConnection connection1 = (HttpURLConnection) url.openConnection();
            connection1.setRequestMethod("POST");
            connection1.setRequestProperty("USER-AGENT", "Mozilla/5.0");
            connection1.setRequestProperty("ACCEPT-LANGUAGE", "en-US, en; 0.5");

            connection1.setDoOutput(true);

            DataOutputStream dStream1 = new DataOutputStream(connection1.getOutputStream());
            dStream1.writeBytes(urlParameters1);
            dStream1.flush();
            dStream1.close();

            int responseCode1 = connection1.getResponseCode();

            final StringBuilder output1 = new StringBuilder("Request URL" + url1);
            output1.append(System.getProperty("line.separator") + "Response Code" + responseCode1);
*//*

            /*            BufferedReader br = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));

            String line = "";
            while(line != null){
                line = br.readLine();
                data = data + line;
            }
            JSONArray arr = new JSONArray();
            for(int i=0; i<arr.length();i++){
                JSONObject object = (JSONObject) arr.get(i);
                if(object.getString("id").equals("1")){
                    ((JSONObject) arr.get(i)).put("status", "False");

                }
                result = arr.toString();


            }
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
*/
//        } catch (MalformedURLException e) {
//            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No Scanned Image";

    }

    @Override
    protected void onPostExecute(String aVoid) {


    }


}


