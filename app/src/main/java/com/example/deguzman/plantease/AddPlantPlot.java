package com.example.deguzman.plantease;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddPlantPlot extends AppCompatActivity {

    final Context context = this;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant_plot);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        TextView plant_name = (TextView) findViewById(R.id.plant_name);
        a = AddPlantInforActivity.plant.getText().toString();
        plant_name.setText(a);

        final Button a1 = (Button) findViewById(R.id.a1);
        a1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog);

                TextView title = (TextView) dialog.findViewById(R.id.title);
                title.setText("A1");

                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.input_name);
                text.setText("Lettuce");

                dialog.show();
            }
        });

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddPlantPlot.this, AddPlantActivity.class);
                startActivity(i);
            }
        });

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddPlantPlot.this, AddPlantActivity.class);
                startActivity(i);
            }
        });
    }
}
