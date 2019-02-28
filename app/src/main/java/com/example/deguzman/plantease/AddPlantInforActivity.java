package com.example.deguzman.plantease;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class AddPlantInforActivity extends AppCompatActivity {
    private static final String URL_DATA = "http://172.20.10.2:8000/Plant_Lists/?format=json";

    public static EditText plant;

    public static MaterialBetterSpinner specificplant, plantdistance, plotwidth, plotsize;

    String[] SPINNERLIST = {"Lettuce", "Pechay", "Tomato"};

    String[] SPINNERLIST1 = {"0.5m", "0.6m", "0.7m"};

    String[] SPINNERLIST2 = {"0.5m", "0.8m", "1m", "1.5m"};

    String[] SPINNERLIST3 = {"5m", "10m", "15m"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant_infor);
      
/*
        ImageButton next = (ImageButton) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddPlantInforActivity.this, AddPlantPlot.class);
                startActivity(i);
            }
        });
*/

        plant = (EditText) findViewById(R.id.input_name);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        specificplant = (MaterialBetterSpinner)
                findViewById(R.id.spinner1);
        specificplant.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST1);
        plantdistance = (MaterialBetterSpinner)
                findViewById(R.id.spinner2);
        plantdistance.setAdapter(arrayAdapter1);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST2);
        plotwidth = (MaterialBetterSpinner)
                findViewById(R.id.spinner3);
        plotwidth.setAdapter(arrayAdapter2);

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST3);
       plotsize = (MaterialBetterSpinner)
                findViewById(R.id.spinner4);
        plotsize.setAdapter(arrayAdapter3);

        Button add = (Button) findViewById(R.id.submit);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   System.out.println(z);
                if(plant.getText().toString().isEmpty() || specificplant.getText().toString().isEmpty() || plantdistance.getText().toString().isEmpty() || plotwidth.getText().toString().isEmpty() || plotsize.getText().toString().isEmpty()){
                    Toast.makeText(AddPlantInforActivity.this, "Please input a text.", Toast.LENGTH_SHORT).show();
                }
                else {
                    System.out.println(plant.getText().toString());
                    System.out.println(plantdistance.getText().toString());
                    System.out.println(specificplant.getText().toString());
                    System.out.println(plotwidth.getText().toString());
                    System.out.println(plotsize.getText().toString());

                    addplantpost add = new addplantpost();
                    add.execute();

                    startActivity(new Intent(AddPlantInforActivity.this, AddPlantActivity.class));

                }
            }

            //        }
        });

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    startActivity(new Intent(AddPlantInforActivity.this, AddPlantActivity.class));


            }

            //        }
        });

    }
}
