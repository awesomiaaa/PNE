package com.example.deguzman.plantease;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class plantactivate extends AsyncTask<Void, Void, String> {
    String data="";
    String result = "";
    public static String urlParameters, urlParameters1, id, plant_name, specific_plant, plant_width, plot_size, plant_distance;
    String a, b, c, d, e;

    @Override
    protected String doInBackground(Void... voids) {

        try {
//            URL url = new URL("http://172.20.10.3:8000/Plant_Listers/?format=json");
            URL url = new URL("http://192.168.1.15:8000/Plant_Listers/?format=json");

            plant_name = AddPlantViewFragment.plantname.getText().toString();
            specific_plant = AddPlantViewFragment.spec_plant.getText().toString();
            plant_width = AddPlantViewFragment.plot_width.getText().toString();
            plot_size = AddPlantViewFragment.plot_size.getText().toString();
            plant_distance = AddPlantViewFragment.plant_distance.getText().toString();

            a=plant_name;
            b=specific_plant;
            c=plant_width;
            d=plot_size;
            e=plant_distance;

            String urlParameters = "plant_name="+ a + "&specific_plant=" + b + "&plant_width="+ c +"&plot_size="+ d + "&plant_distance=" + e ;
//            String urlParameters = "plant_name="+ plant_name + "&specific_plant=" + specific_plant + "&plant_width="+ plant_width +"&plot_size="+ plot_size + "&plant_distance=" + plant_distance ;

//            String urlParameters="plant_name="+plant_name+"&specific_plant="+specific_plant+"&plant_width="+"asdasd"+"&plot_size=asdasda&plant_distance=sadasda" ;
            System.out.println(a+b+c+d+e);
//            urlParameters = "plant_name=asd";


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

      /*  System.out.println("asdasdasd");
        if(urlParameters.equals("false")){
            System.out.println("1");
            ScanActivity.progressDialog.dismiss();
        }else{
            System.out.println("2");
            ScanActivity.progressDialog.show();
            try{
                WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, timeout);
                urlParameters.until()
            }catch{

            }*/


    }

}


