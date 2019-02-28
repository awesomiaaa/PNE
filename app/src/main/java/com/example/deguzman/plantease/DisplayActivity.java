package com.example.deguzman.plantease;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {

    public static String condition, disease, diagnosis, plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_display);

        Intent intent = getIntent();
        //    final String plant_type = intent.getStringExtra(DevelopersAdapter.KEY_PLANT_TYPE);
        condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);
        disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        diagnosis = intent.getStringExtra(DevelopersAdapter.KEY_DIAGNOSIS);
        final String pic = intent.getStringExtra(DevelopersAdapter.KEY_IMAGE);
        plant = intent.getStringExtra(DevelopersAdapter.KEY_PLANT_NO);



        TextView conditionView = (TextView) findViewById(R.id.con);
     /*   TextView diseaseView = (TextView) findViewById(R.id.textView);
        final TextView diagnosisView = (TextView) findViewById(R.id.textView2);
    */    TextView plantnoView = (TextView) findViewById(R.id.pn);
        ImageView picView = (ImageView) findViewById(R.id.imageView1);

        conditionView.setText(condition);
        plantnoView.setText(plant);
        Picasso.with(this)
                .load(pic)
                .into(picView);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        if(condition.equalsIgnoreCase("unhealthy")) {


            tabLayout.addTab(tabLayout.newTab().setText("Disease"));
            tabLayout.addTab(tabLayout.newTab().setText("Diagnosis"));
            tabLayout.addTab(tabLayout.newTab().setText("Preventive Measures"));
            tabLayout.addTab(tabLayout.newTab().setText("Ways to Control"));


            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

            final PagerAdapter adapter = new PagerAdapter
                    (getSupportFragmentManager(), tabLayout.getTabCount());
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
            final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

            final PagerAdapter adapter = new PagerAdapter
                    (getSupportFragmentManager(), tabLayout.getTabCount());
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

      /*  TextView diagnosisTxt = (TextView) findViewById(R.id.diagnosistxt);
        TextView diseaseTxt = (TextView) findViewById(R.id.Disease);

        TextView desc = (TextView) findViewById(R.id.diseasedescptxt);

      */
     /*   if (condition.equalsIgnoreCase("healthy")){
            diseaseTxt.setText("Plant Name");
            diseaseView.setText("Lettuce");
            diagnosisTxt.setText("The plant looks healthy!");
            conditionView.setText(condition);
            plantnoView.setText(plant);
            CardView des = (CardView) findViewById(R.id.Description);
            des.setVisibility(View.GONE);
        }else{
            if(disease.equalsIgnoreCase("Leaf Spot")){
                desc.setText("Is a common descriptive term applied to a number of diseases affecting the foliage of ornamentals and shade trees.");
                diagnosisTxt.setText("The chief symptom of a leaf spot disease is spots on foliage. The spots will vary in size and color depending on the plant affected, the specific organism involved, and the stage of development. Spots are most often brownish, but may be tan or black. Concentric rings or dark margins are often present. Fungal bodies may appear as black dots in the spots, either in rings or in a central cluster. Over time, the spots may combine or enlarge to form blotches. Spots or blotches that are angular are generally referred to as anthracnose (see entry on “Anthracnose of Trees”) Leaves may yellow and drop prematurely.");
            }
            if(disease.equalsIgnoreCase("Late Blight")){
                desc.setText("A disease of solanaceous plants (such as the potato and tomato) that is caused by a fungus (Phytophthora infestans) and is characterized by decay of stems, and leaves.");
                diagnosisTxt.setText("Irregularly shaped watersoaked lesions can be observed on young leaves at the top part of the plant.  Under humid conditions, lesions become brown and pathogen sporulation can be seen.  Eventually the leaves shrivel and become necrotic and die.  Brown lesions can occur on stems and leaf pedicels. The pathogen can also infect tomato fruit and causes circular greasy lesions.  The fruit remain firm but spots eventually become leathery and chocolate brown and can enlarge to cover the entire fruit.");
            }
            if(disease.equalsIgnoreCase("Mosaic virus")){
                desc.setText("This virus infects more than 150 types of plants, including many fruits, vegetables, and flowers. It is characterized by leaves mottled with yellow, white, and light and dark green spots or streaks. ");
                diagnosisTxt.setText("Mosaic virus overwinters on perennial weeds and is spread by insects that feed on them. Aphids, leafhoppers, whiteflies and cucumber beetles are common garden pests that can transmit this disease. Soil, seed, starter pots and containers can be infected and pass the virus to the plant. Cuttings or divisions from infected plants will also carry the virus.");
            }
            if(disease.equalsIgnoreCase("Early Blight")){
                desc.setText(" Any of several blights of plants in which symptoms appear early in the season");
                diagnosisTxt.setText("Early blight overwinters on infected plant tissue and is spread by splashing rain, irrigation, insects and garden tools. The disease is also carried on tomato seeds and in potato tubers. In spite of its name, early blight can occur any time throughout the growing season. High temperatures (80-85˚F.) and wet, humid conditions promote its rapid spread. In many cases, poorly nourished or stressed plants are attacked.");
            }
            if(disease.equalsIgnoreCase("Powdery Mildew")){
                desc.setText("Powdery mildew, plant disease of worldwide occurrence that causes a powdery growth on the surface of leaves, buds, young shoots, fruits, and flowers.");
                diagnosisTxt.setText("Powdery mildew is caused by many specialized races of fungal species in the genera Erysiphe, Microsphaera, Phyllactinia, Podosphaera, Sphaerotheca, and Uncinula. Hundreds of species of trees, shrubs, vines, flowers, vegetables, fruits, grasses, field crops, and weeds can be affected by powdery mildew.");
            }
            else{

            }*/
        //        diagnosisView.setText(diagnosis);


        //final String name = intent.getStringExtra(AddPlantListAdapter.KEY_PLANT_NAME);

        //  TextView plantn = (TextView) findViewById(R.id.name);

        // plantn.setText();
        conditionView.setText(condition);
        //       diseaseView.setText(disease);
        plantnoView.setText(plant);
        //       diagnosisView.setText(diagnosis);

        // }


        //  picView.setText(pic);

     /*   String image = intent.getStringExtra(DevelopersAdapter.KEY_IMAGE);
        final String profileUrl = intent.getStringExtra(DevelopersAdapter.KEY_URL);
*/
/*
             Glide.with(this)
                .load(pic)
                .asBitmap()
                .error(R.drawable.ic_cloud_off_red)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(picView);*/
        Picasso.with(this)
                .load(pic)
                .into(picView);
     /*   userNameTextView.setText(userName);
        developerUrl.setText(profileUrl);

        developerUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = profileUrl;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
*/

    /*    shareProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer " + userName +
                        ", " + profileUrl);
                Intent chooser = Intent.createChooser(shareIntent, "Share via");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });
*/

    }
}

