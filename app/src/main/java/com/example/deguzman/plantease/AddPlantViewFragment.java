package com.example.deguzman.plantease;


import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
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
import org.w3c.dom.Text;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;
import static com.example.deguzman.plantease.ScanFragment.jo;
import static com.example.deguzman.plantease.ScanFragment.progressDialog;

/**
 * A simple {@link Fragment} subclass.
 */


public class AddPlantViewFragment extends Fragment {

    private static final String URL_DATA = "http://172.20.10.2:8080/capture/?format=json";

    public static JSONObject stats;

    final Context context = getActivity();
    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }

    public static TextView plantname, spec_plant, plant_distance, plot_size, plot_width;
//
//    public static ProgressDialog progressDialog1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_plant_view, container, false);

        plantname = (TextView) view.findViewById(R.id.plant_name);
        spec_plant = (TextView) view.findViewById(R.id.spec_plant);
        plant_distance = (TextView) view.findViewById(R.id.plant_distance);
        plot_size = (TextView) view.findViewById(R.id.plot_size);
        plot_width = (TextView) view.findViewById(R.id.plot_width);

        Intent intent = getActivity().getIntent();
        //    final String plant_type = intent.getStringExtra(DevelopersAdapter.KEY_PLANT_TYPE);
        final String plantn = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_NAME);
        final String specp = intent.getStringExtra(AddPlantListAdapter.KEY_SPEC_PLANT);
        final String plantd = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_DIST);
        final String plots = intent.getStringExtra(AddPlantListAdapter.KEY_PLOT_SIZE);
        final String plotw = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_WIDTH);
        final String id = intent.getStringExtra(AddPlantListAdapter.KEY_ID);

        plantname.setText(plantn);
        spec_plant.setText(specp);
        plant_distance.setText(plantd);
        plot_size.setText(plots);
        plot_width.setText(plotw);

        System.out.println(id);

        Button start = (Button) view.findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //  Toast.makeText(AddPlantView.this,"Sign In Button Clicked",Toast.LENGTH_LONG).show();
                plantactivate plantlister = new plantactivate();
                plantlister.execute();
                activate process = new activate();
                process.execute();
                capture cap = new capture();
                cap.execute();
                System.out.println("f");
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


                });/*
                System.out.println("done");*/

                Intent i = new Intent(getActivity(), Loading.class);
                startActivity(i);
//loadUrlData();


//
//


//

//                AsyncHttpClient client1 = new AsyncHttpClient();
//                client1.setTimeout(70000);
//                client1.get("http://172.20.10.2:8000/start/", new AsyncHttpResponseHandler() {
//
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
///*
//                        onDisplay process = new onDisplay();
//                        process.execute();
//*/
//                        /*deactivate deact = new deactivate();
//                        deact.execute();*/
//                  /*      System.out.println("s");
//                        Intent i = new Intent(AddPlantView.this, ScanActivity.class);
//                        startActivity(i);*/
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//                    }
//
//
//                });
//
//                startActivity(new Intent(AddPlantView.this, ScanActivity.class));
//
//                TextView s = (TextView) view.findViewById(R.id.status);
//



            }
        });



        return view;
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

                    stats = array.getJSONObject(array.length()-1);

                    stats.getBoolean("status");

                    System.out.println(stats.optString("status"));

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {

                                if(stats.optString("status").equals("false")) {
                                    System.out.println(stats.optString("status"));
                                    progressDialog.dismiss();
                                    Intent i = new Intent(getActivity(), ScanActivity.class);
                                    startActivity(i);

                                }else {

                                    System.out.println(stats.optString("status"));
//
                                    Intent intent = getActivity().getIntent();
                                    getActivity().finish();
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);

                                }
                        }
                    }, 5000);


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
}
