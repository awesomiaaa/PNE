package com.example.deguzman.plantease;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class signpost extends AsyncTask<Void, Void, String> {
    String data="";
    String result = "";

    String uname, email, password;

    @Override
    protected String doInBackground(Void... voids) {

        try {
            URL url = new URL("http://172.20.10.2:8000/Users/?format=json");

            uname = SignUpActivity.name.getText().toString();
            email = SignUpActivity.email.getText().toString();
            password = SignUpActivity.password.getText().toString();

            String urlParameters = "name="+ uname +"&email="+ email +"&password="+ password +"" ;



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


