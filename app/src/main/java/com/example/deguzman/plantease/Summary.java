package com.example.deguzman.plantease;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;

public class Summary extends AppCompatActivity {
    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }
    private static final String URL_DATA = "http://172.20.10.2:8000/Scans/?format=json";

    private RecyclerView recyclerView, recyclerViewh;
    private RecyclerView.Adapter adapter;
    private List<DevelopersList> developersLists;
    private ArrayList<DevelopersList> mSectionList;
    Button click;
    public static TextView data, outputPost, loc, plant_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //  GridLayoutManager gridLayoutManager = new GridLayoutManager(Summary.this, 2);
        /*recyclerView.setLayoutManager(gridLayoutManager);
*/
        developersLists = new ArrayList<>();
        mSectionList = new ArrayList<>();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.8));

        WindowManager.LayoutParams params = getWindow().getAttributes();

        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        loadUrlData();
    }

    private void loadUrlData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);


                    JSONArray array = jsonObject.getJSONArray("results");

                    JSONObject jo = array.getJSONObject(array.length()-1);

/*
                    for (int i = 0; i < array.length(); i++) {

                        JSONObject jo1 = array.getJSONObject(i);

             */           /*
                        JSONArray ar = jo.getJSONArray("scan_details");*/

/*


                        JSONArray ar = jo.getJSONArray("id");

                        JSONObject tot_obj = ar.getJSONObject(array.length()-1);*/

                    JSONArray a = jo.getJSONArray("scan_details");

                    for (int l = 0; l < a.length(); l++) {
                        JSONObject rec = a.getJSONObject(l);

                        System.out.println(rec.optString("condition"));
                      //  if(rec.optString("condition").equals("unhealthy")){
                      //      System.out.println(rec.optString("plant_no"));
                            DevelopersList developers = new DevelopersList(
                                    rec.getString("condition"),
                                    jo.getBoolean("status"),
                                    jo.getString("id"),
                                    rec.getString("plant_no"),
                                    rec.getString("disease"),
                                    rec.getString("diagnosis"),
                                    rec.getString("model_pic"));


                        developersLists.add(developers);

                        if(rec.optString("condition").equals("unhealthy")){
                            System.out.println(rec.optString("condition"));
                        }
                        if(rec.optString("condition").equals("unhealthy")){
                            System.out.println(rec.optString("condition"));
                        }


                        }




                   /* }*/


                    /*}*/



                    adapter = new SummaryAdapter(developersLists, getApplicationContext());

                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Summary.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
