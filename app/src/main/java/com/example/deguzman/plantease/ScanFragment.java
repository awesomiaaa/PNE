package com.example.deguzman.plantease;


import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFragment extends Fragment {

    final Context context = getActivity();
    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }
    private static final String URL_DATA = "http://172.20.10.2:8000/Scans/?format=json";
    //    private static final String URL_DATA = "http://192.168.1.10:8080/Scans/?format=json";
    public static ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<DevelopersList> developersLists;

    private SwipeRefreshLayout mySwipeRefreshLayout;

    public static JSONObject jo;

    Button click;
    public static TextView data, outputPost, loc, plant_no;

    SwipeRefreshLayout mSwipeRefreshLayout;
    WebView webView;
    WebSettings webSettings;

    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(70000);
        client.get("http://172.20.10.2:8080/start/", new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
/*
                        onDisplay process = new onDisplay();
                        process.execute();
*/
                        /*deactivate deact = new deactivate();
                        deact.execute();*/
                  /*      System.out.println("s");
                        Intent i = new Intent(AddPlantView.this, ScanActivity.class);
                        startActivity(i);*/
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }


        });

            View view = inflater.inflate(R.layout.fragment_scan, container, false);

        webView= (WebView) view.findViewById(R.id.webView);
        webSettings=webView.getSettings();
        webSettings.setDefaultFontSize(18);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);
        String htmlText = " %s ";
        String myData = "<html><body style=\"text-align:justify; color: #FFF\"> " +
                "<br>1. The page is intended to display the result based on the location of all the captured image (A1, A2, B1, B2, ....)." +
                "<br>2. The image has two major card color changes. <br>" +
                "<ul style=\"list-style-type:disc;\">" +
                "<li>RED - Signifies that the location contains disease.</li>" +
                "<li>GREEN - Signifies that the location is healthy or free of disease. </li>" +
                "<li>GRAY - Signifies that the location is an object or not a plant</li>"+
                "</ul>" +
                "3. To display the specific result of the scanning process, click on the card and read all important information.</body></Html>";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        FloatingActionButton sum = (FloatingActionButton) view.findViewById(R.id.summary);
        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_scan);
                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                *//*recyclerView.setLayoutManager(new LinearLayoutManager(this));*//*
                GridLayoutManager gridLayoutManager = new GridLayoutManager(ScanActivity.this, 1);
                recyclerView.setLayoutManager(gridLayoutManager);
                developersLists = new ArrayList<>();
//                TextView title = (TextView) dialog.findViewById(R.id.title);
//                title.setText("A1");
//
//                // set the custom dialog components - text, image and button
//                TextView text = (TextView) dialog.findViewById(R.id.input_name);
//                text.setText("Lettuce");
                loadUrlData();
                dialog.show();*/

                startActivity(new Intent(getActivity(), Summary.class));
            }

        });


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        developersLists = new ArrayList<>();



        loadUrlData();

        return view;
    }

    private void loadUrlData() {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.setCancelable(false);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                try {

                    JSONObject jsonObject = new JSONObject(response);


                    JSONArray array = jsonObject.getJSONArray("results");

                    jo = array.getJSONObject(array.length()-1);

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

                        DevelopersList developers = new DevelopersList(
                                rec.getString("condition"),
                                jo.getBoolean("status"),
                                jo.getString("id"),
                                rec.getString("plant_no"),
                                rec.getString("disease"),
                                rec.getString("diagnosis"),
                                rec.getString("model_pic"));



                        developersLists.add(developers);
                        System.out.println( rec.getString("condition"));

                        if(jo.optString("status").equals("false")){
                            System.out.println("Unhealthy");


                        }
                        if(rec.optString("condition").equalsIgnoreCase("healthy")){
                            System.out.println("Healthy");
                            System.out.println(rec.optString("plant_no"));
                        }
                    }


                    /*}*/



                    adapter = new DevelopersAdapter(developersLists, getActivity().getApplicationContext());

                    recyclerView.setAdapter(adapter);

//                    if(jo.optString("status").equals("false")) {
//                        progressDialog.dismiss();
//                    }else {
//                        System.out.println(jo.optString("status"));
//
//                        Intent intent = getIntent();
//                        finish();
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                        startActivity(intent);
//                        finish();
//                        startActivity(getIntent());

//                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(jo.optString("status").equals("false")) {
                                progressDialog.dismiss();
                            }else {
                                System.out.println(jo.optString("status"));

                                Intent intent = getActivity().getIntent();
                                getActivity().finish();
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intent);


                            }
                        }
                    }, 30000);


                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private class PagerAdapter extends android.support.v4.view.PagerAdapter {

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            // Create some layout params
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

            // Create some text
            TextView textView = getTextView(container.getContext());
            textView.setText(String.valueOf(position));
            textView.setLayoutParams(layoutParams);

            RelativeLayout layout = new RelativeLayout(container.getContext());
            layout.setBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.colorPrimary));
            layout.setLayoutParams(layoutParams);

            layout.addView(textView);
            container.addView(layout);

            return layout;
        }

        private TextView getTextView(Context context) {
            TextView textView = new TextView(context);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(30);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }
}

