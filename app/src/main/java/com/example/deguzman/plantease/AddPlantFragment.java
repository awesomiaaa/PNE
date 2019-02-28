package com.example.deguzman.plantease;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
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
import com.daimajia.swipe.SwipeLayout;
import com.github.clans.fab.FloatingActionMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPlantFragment extends Fragment {

    private static final String URL_DATA = "http://172.20.10.2:8000/Plant_Lists/?format=json";

    private PlayersDataAdapter mAdapter;
    SwipeController swipeController = null;
    final Context context = getContext();

    private SwipeLayout sample1, sample2, sample3;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<AddPlantList> addPlantLists;

    private FloatingActionMenu fam;
    private com.github.clans.fab.FloatingActionButton fabmulticrop, fabunicrop;
    WebView webView;
    WebSettings webSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_plant, container, false);

        webView= (WebView) view.findViewById(R.id.webView);
        webSettings=webView.getSettings();
        webSettings.setDefaultFontSize(18);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);
        String htmlText = " %s ";
        String myData = "<html><body style=\"text-align:justify; color: #FFF\"> <br>1. The page is inteded to display all information before the scanning procedure. <br>" +
                "2. The user has the opportunity to scan the field and indicate whether it is a Monocrop or a Multicrop type of farming.<br>" +
                "3. To add necessary inforamtion for the plot size, plant distance and specific plant. Click on the red (+) icon on the lower right of the page. <br>" +
                "4. After providing all information, the system will now be directed to the scan process.</body></Html>";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        addPlantLists = new ArrayList<>();

        System.out.println(recyclerView);
        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                addPlantLists.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, adapter.getItemCount());

            }
            @Override
            public void onLeftClicked(int position) {
                Toast.makeText(getActivity(), "Scan", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), AddPlantInforActivity.class);
                startActivity(i);

            }

        });
        recyclerView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Scan",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), ScanActivity.class);
                startActivity(i);
            }
        });
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });

        loadUrlData();

        fabmulticrop = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.fab2);
        fabunicrop = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.fab1);
        fam = (FloatingActionMenu) view.findViewById(R.id.fab_menu);

        //handling menu status (open or close)
        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {
                    //  showToast("Menu is opened");
                } else {
                    //   showToast("Menu is closed");
                }
            }
        });

        //handling each floating action button clicked
        fabmulticrop.setOnClickListener(onButtonClick());
        fabunicrop.setOnClickListener(onButtonClick());

        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fam.isOpened()) {
                    fam.close(true);
                }
            }
        });
        return view;
    }

    private View.OnClickListener onButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == fabmulticrop) {
                    showToast("Test Movements Button clicked");
//                    Intent i = new Intent(getActivity(), AddPlantPlot.class);
                    Intent i = new Intent(getActivity(), TestMovements.class);
                    startActivity(i);
                } else if (view == fabunicrop) {
                    showToast("Monocrop Button clicked");
                    Intent i = new Intent(getActivity(), AddPlantInforActivity.class);
                    startActivity(i);
                }
                fam.close(true);
            }
        };
    }

    private void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    private void loadUrlData() {

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
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

                  //  for (int i = 0; i < array.length(); i++) {

                   //     JSONObject jo = array.getJSONObject(array);
                  //      JSONArray ar = jo.getJSONArray("scan_details");
                        for (int l = 0; l < array.length(); l++) {
                            JSONObject rec = array.getJSONObject(l);
                            AddPlantList addplantlist = new AddPlantList(
                                    rec.getString("id"),
                                    rec.getString("plant_name"),
                                    rec.getString("specific_plant"),
                                    rec.getString("plant_width"),
                                    rec.getString("plot_size"),
                                    rec.getString("plant_distance"));
                            addPlantLists.add(addplantlist);
                            System.out.println(rec.optString("plant_name"));


                       // }
                    }



                    adapter = new AddPlantListAdapter(addPlantLists, getContext().getApplicationContext());
                 //   mAdapter = new PlayersDataAdapter(addPlantLists, getApplicationContext());
                    recyclerView.setAdapter(adapter);

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
