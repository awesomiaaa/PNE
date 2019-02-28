package com.example.deguzman.plantease;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPlantViewFragment extends Fragment {

    public static TextView plantname, spec_plant, plant_distance, plot_size, plot_width;


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

        plantname.setText("Name: " + plantn);
        spec_plant.setText("Specific Plant: " + specp);
        plant_distance.setText("Plant Distance: " + plantd);
        plot_size.setText("Plot Size: " + plots);
        plot_width.setText("Plot Width: " + plotw);

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
                System.out.println("f");
                AsyncHttpClient client = new AsyncHttpClient();
                client.setTimeout(70000);
                client.get("http://172.20.10.3:8080/start/", new AsyncHttpResponseHandler() {

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

//
//
                Intent i = new Intent(getActivity(), Loading.class);
                startActivity(i);
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
}
