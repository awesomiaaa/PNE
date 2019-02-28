package com.example.deguzman.plantease;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deguzman.plantease.ListViewAdapter;
import com.example.deguzman.plantease.R;

import java.util.List;

public class Main2Activity extends Fragment {
    TextView tab;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
//    private List<HistoryList> historyLists;
    WebView webView;
    WebSettings webSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment1, container, false);

        Intent intent = getActivity().getIntent();
        String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);

        String libdisease = intent.getStringExtra(ListViewAdapter.KEY_DISEASE);

        webView= (WebView) view.findViewById(R.id.textView2);
        webSettings=webView.getSettings();
        webSettings.setDefaultFontSize(20);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);
        String htmlText = " %s ";

        String myData = "<html><body style=\"text-align:justify\"> " + libdisease + "</body></Html>";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

//        tab = (TextView) view.findViewById(R.id.textView2);


//        tab.setText(libdisease);
     /*   if(condition.equalsIgnoreCase("unhealthy")) {
            if (disease.equalsIgnoreCase("Leaf Spot")) {
                tab.setText("Leaf Spot");
            } else if (disease.equalsIgnoreCase("Powdery Mildew")) {
                tab.setText("Powdery Mildew");
            } else if (disease.equalsIgnoreCase("Anthracnose")) {
                tab.setText("Anthracnose");
            } else if (disease.equalsIgnoreCase("Late Blight")) {
                tab.setText("Late Blight");
            } else if (disease.equalsIgnoreCase("not a plant")) {
                tab.setText("Not a Plant");
            }
        }
        else if(condition.equalsIgnoreCase("healthy")){
            tab.setText("No Disease Detected");
        }
*/



        return view;
    }

}
