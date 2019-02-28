package com.example.deguzman.plantease;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;

/**
 * Created by EKENE on 7/23/2017.
 */

public class AddPlantListAdapter extends RecyclerView.Adapter<AddPlantListAdapter.ViewHolder> {
    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }

    public static final String KEY_ID = "id";
    public static final String KEY_PLANT_NAME = "plant_name";
    public static final String KEY_SPEC_PLANT = "specific_plant";
    public static final String KEY_PLANT_DIST = "plant_distance";
    public static final String KEY_PLOT_SIZE = "plot_size";
    public static final String KEY_PLANT_WIDTH = "plant_width";

    public static TextView loc;
    public static TextView id;

    private List<AddPlantList> addPLantLists;
    private Context context;

    public AddPlantListAdapter(List<AddPlantList> addPLantLists, Context context) {

        // generate constructors to initialise the List and Context objects

        this.addPLantLists = addPLantLists;
        this.context = context;
/*
        Collections.reverse(addPLantLists);*/

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method will be called whenever our ViewHolder is created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_row, parent, false);

        return new ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // this method will bind the data to the ViewHolder from whence it'll be shown to other Views

        final AddPlantList addplantlist = addPLantLists.get(position);
        holder.plant_name.setText("Name: " + addplantlist.getPlant_name());
        holder.spec_plant.setText("Specific Plant: " + addplantlist.getSpecific_plant());
        /*
        holder.spec_plant.setText(addplantlist.getSpecific_plant());
        holder.plant_width.setText(addplantlist.getPlant_width());
        holder.plot_size.setText(addplantlist.getPlot_s

/*
        holder.model_pic.setImageIcon(developersList.getModel_pic());*/
 /*       Glide.with(context)
                .load(developersList.getModel_pic())
                .asBitmap()
                .error(R.drawable.ic_cloud_off_red)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.model_pic);*/

/*        Picasso.with(context)
                .load(developersList.getModel_pic())
                .into(holder.model_pic);*/

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPlantList addPlant = addPLantLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), AddPlantView.class);
                //          skipIntent.putExtra(KEY_PLANT_TYPE, developersList1.getPlant_type());
                skipIntent.putExtra(KEY_ID, addPlant.getId());
                skipIntent.putExtra(KEY_PLANT_NAME, addPlant.getPlant_name());
                //    skipIntent.putExtra(KEY_DATE, historyList1.getDate());
                skipIntent.putExtra(KEY_SPEC_PLANT, addPlant.getSpecific_plant());
                skipIntent.putExtra(KEY_PLANT_DIST, addPlant.getPlant_distance());
                skipIntent.putExtra(KEY_PLANT_WIDTH, addPlant.getPlant_width());
                /*             skipIntent.putExtra(KEY_URL, developersList1.getHtml_url());*/
                skipIntent.putExtra(KEY_PLOT_SIZE, addPlant.getPlot_size());
                v.getContext().startActivity(skipIntent);



            }
        });



    }

    @Override

    //return the size of the listItems (developersList)

    public int getItemCount() {
        return addPLantLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        // define the View objects
        public TextView plant_name;
        public TextView spec_plant;
        public TextView plant_width;
        public TextView plant_distance;
        public TextView plot_size;
        public CardView card;
        /*public TextView html_url;
         */        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            // initialize the View object

         //   card = (CardView) itemView.findViewById(R.id.card);
            plant_name = (TextView) itemView.findViewById(R.id.plant_name);
            spec_plant = (TextView) itemView.findViewById(R.id.spec_plant);
         //   plant_width = (TextView) itemView.findViewById(R.id.conditiontxt);
            //   model_pic = (ImageView) itemView.findViewById(R.id.imageView);
            /*html_url = (TextView) itemView.findViewById(R.id.htmUrl);*/
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

            /*if(KEY_PLANT_NO.equals("")){
                loc.setText("A1");
                loc.append("A1");
                loc.getResources().getColor(R.color.colorAccent);
            }*/




        }

    }
}
