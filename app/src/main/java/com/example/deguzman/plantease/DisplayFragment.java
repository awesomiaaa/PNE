package com.example.deguzman.plantease;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    public static String condition, disease, diagnosis, plant;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        Intent intent = getActivity().getIntent();
        //    final String plant_type = intent.getStringExtra(DevelopersAdapter.KEY_PLANT_TYPE);
        condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);
        disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        diagnosis = intent.getStringExtra(DevelopersAdapter.KEY_DIAGNOSIS);
        final String pic = intent.getStringExtra(DevelopersAdapter.KEY_IMAGE);
        plant = intent.getStringExtra(DevelopersAdapter.KEY_PLANT_NO);



        TextView conditionView = (TextView) view.findViewById(R.id.con);
     /*   TextView diseaseView = (TextView) findViewById(R.id.textView);
        final TextView diagnosisView = (TextView) findViewById(R.id.textView2);
    */    TextView plantnoView = (TextView) view.findViewById(R.id.pn);
        ImageView picView = (ImageView) view.findViewById(R.id.imageView1);

        conditionView.setText(condition);
        plantnoView.setText(plant);
        Picasso.with(getActivity())
                .load(pic)
                .into(picView);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        if(condition.equalsIgnoreCase("unhealthy")) {


            tabLayout.addTab(tabLayout.newTab().setText("Disease"));
            tabLayout.addTab(tabLayout.newTab().setText("Diagnosis"));
            tabLayout.addTab(tabLayout.newTab().setText("Preventive Measures"));
            tabLayout.addTab(tabLayout.newTab().setText("Ways to Control"));


            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);

            final com.example.deguzman.plantease.PagerAdapter adapter = new com.example.deguzman.plantease.PagerAdapter
                    (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }

            });


        }
        else{

            tabLayout.addTab(tabLayout.newTab().setText("Result"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);

            final com.example.deguzman.plantease.PagerAdapter adapter = new com.example.deguzman.plantease.PagerAdapter
                    (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }

            });
        }

        // plantn.setText();
        conditionView.setText(condition);
        //       diseaseView.setText(disease);
        plantnoView.setText(plant);
        //       diagnosisView.setText(diagnosis);


        Picasso.with(getActivity())
                .load(pic)
                .into(picView);

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
