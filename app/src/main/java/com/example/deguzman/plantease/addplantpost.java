package com.example.deguzman.plantease;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class addplantpost extends AsyncTask<Void, Void, String> {
    String data="";
    String result = "";

    String plant, specplant, distance, width, size;

    @Override
    protected String doInBackground(Void... voids) {

        try {
            URL url = new URL("http://172.20.10.2:8000/Plant_Lists/?format=json");

            plant = AddPlantInforActivity.plant.getText().toString();
            specplant = AddPlantInforActivity.specificplant.getText().toString();
            distance = AddPlantInforActivity.plantdistance.getText().toString();
            width = AddPlantInforActivity.plotwidth.getText().toString();
            size = AddPlantInforActivity.plotsize.getText().toString();

            String urlParameters = "plant_name="+ plant + "&specific_plant=" + specplant + "&plant_width="+ width +"&plot_size="+ size + "&plant_distance=" + distance ;
            System.out.println(urlParameters);

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

        } catch (MalformedURLException e) {
            e.printStackTrace();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);


    }
}


