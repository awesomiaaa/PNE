package com.example.deguzman.plantease;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;

/**
 * Created by EKENE on 7/23/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }
    public static final String KEY_DATE = "date";
    public static final String KEY_PLANT_NO = "plant_no";
    public static final String KEY_CONDITION = "condition";
    public static final String KEY_DISEASE = "disease";
    public static final String KEY_DIAGNOSIS = "diagnosis";
    public static final String KEY_IMAGE = "model_pic";
    public static final String A1 = "A1";

    public static TextView loc;
    public static TextView id;

    // we define a list from the DevelopersList java class

    private List<HistoryList> historyLists;
    private Context context;

    public HistoryAdapter(List<HistoryList> historyLists, Context context) {

        // generate constructors to initialise the List and Context objects

        this.historyLists = historyLists;
        this.context = context;

        Collections.reverse(historyLists);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this method will be called whenever our ViewHolder is created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_history_list, parent, false);

        return new ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // this method will bind the data to the ViewHolder from whence it'll be shown to other Views

        final HistoryList historyList = historyLists.get(position);
        holder.condition.setText(historyList.getCondition());
        holder.plant_no.setText(historyList.getPlant_no());
/*
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timestamp);
        String date1 = DateFormat.format("dd-MM-yyyy hh:mm:ss", cal).toString();
        */

        holder.date.setText(historyList.getDate());

        if(historyList.getPlant_no().equals("1")) {

            holder.loc.setText("A1");

            if (historyList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (historyList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
            else{
                holder.card.setBackgroundResource(R.drawable.whitebg);
            }
        }
        if(historyList.getPlant_no().equals("2")) {

            holder.loc.setText("A2");
            if (historyList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (historyList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
            else{
                holder.card.setBackgroundResource(R.drawable.whitebg);
            }
        }
        if(historyList.getPlant_no().equals("3")) {

            holder.loc.setText("B1");
            if (historyList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (historyList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
            else{
                holder.card.setBackgroundResource(R.drawable.whitebg);
            }
        }
        if(historyList.getPlant_no().equals("4")) {

            holder.loc.setText("B2");
            if (historyList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (historyList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
            else{
                holder.card.setBackgroundResource(R.drawable.whitebg);
            }
        }
        if(historyList.getPlant_no().equals("5")) {

            holder.loc.setText("C1");
            if (historyList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (historyList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
            else{
                holder.card.setBackgroundResource(R.drawable.whitebg);
            }
        }
        if(historyList.getPlant_no().equals("6")) {

            holder.loc.setText("C2");
            if (historyList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (historyList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
            else{
                holder.card.setBackgroundResource(R.drawable.whitebg);
            }
        }
        if(historyList.getPlant_no().equals("7")) {

            holder.loc.setText("D1");
            if (historyList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (historyList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
            else{
                holder.card.setBackgroundResource(R.drawable.whitebg);
            }
        }
        if(historyList.getPlant_no().equals("8")) {

            holder.loc.setText("D2");
            if (historyList.getCondition().equalsIgnoreCase("unhealthy")) {
                holder.card.setBackgroundResource(R.drawable.redbg);
            }
            else if (historyList.getCondition().equalsIgnoreCase("healthy")) {
                //   holder.card.setCardBackgroundColor(Color.parseColor("Green"));
                holder.card.setBackgroundResource(R.drawable.background);
            }
            else{
                holder.card.setBackgroundResource(R.drawable.whitebg);
            }
        }

        //   holder.id.setText(developersList.getId());

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
                HistoryList historyList1 = historyLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), DisplayActivity.class);
                //          skipIntent.putExtra(KEY_PLANT_TYPE, developersList1.getPlant_type());
                skipIntent.putExtra(KEY_PLANT_NO, historyList1.getPlant_no());
                //    skipIntent.putExtra(KEY_DATE, historyList1.getDate());
                skipIntent.putExtra(KEY_CONDITION, historyList1.getCondition());
                skipIntent.putExtra(KEY_DISEASE, historyList1.getDisease());
                skipIntent.putExtra(KEY_DIAGNOSIS, historyList1.getDiagnosis());
                /*             skipIntent.putExtra(KEY_URL, developersList1.getHtml_url());*/
                skipIntent.putExtra(KEY_IMAGE, historyList1.getModel_pic());
                v.getContext().startActivity(skipIntent);



            }
        });



    }

    @Override

    //return the size of the listItems (developersList)

    public int getItemCount() {
        return historyLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        // define the View objects
        public TextView date;
        public TextView plant_no;
        public TextView plant_type;
        public TextView condition;
        public TextView disease;
        public TextView diagnosis;
        public ImageView model_pic;
        public TextView loc;
        public CardView card;
        /*public TextView html_url;
         */        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            // initialize the View object



            card = (CardView) itemView.findViewById(R.id.card);
            loc = (TextView) itemView.findViewById(R.id.loc);
            date = (TextView) itemView.findViewById(R.id.date);
            plant_no = (TextView) itemView.findViewById(R.id.plant_no);
            condition = (TextView) itemView.findViewById(R.id.conditiontxt);
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