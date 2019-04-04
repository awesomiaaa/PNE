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
import android.widget.TextView;

import java.util.List;

public class TabFragment1 extends Fragment {
    TextView tab;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<HistoryList> historyLists;

    WebView webView;
    WebSettings webSettings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.diseaseoutput, container, false);

        Intent intent = getActivity().getIntent();
        String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);

        String libdisease = intent.getStringExtra(ListViewAdapter.KEY_DISEASE);


        tab = (TextView) view.findViewById(R.id.textView2);

//        webView= (WebView) view.findViewById(R.id.textView2);
//        webSettings=webView.getSettings();
//        webSettings.setDefaultFontSize(20);
//        webView.setBackgroundColor(Color.TRANSPARENT);
//        webSettings.setJavaScriptEnabled(true);
//        String htmlText = " %s ";


      //  tab.setText(libdisease);
    if(condition.equalsIgnoreCase("unhealthy")) {
        if (disease.equalsIgnoreCase("tomatoant")) {
//            String myData = "<html><body style=\"text-align:center\"> Anthracnose in Tomato </body></Html>";
//
//            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
            tab.setText(" Anthracnose in Tomato");
        } else if (disease.equalsIgnoreCase("tomatobli")) {
//            String myData = "<html><body style=\"text-align:center\"> Blight in Tomato </body></Html>";
//
//            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
            tab.setText(" Blight in Tomato");
        } else if (disease.equalsIgnoreCase("lettucemos") ) {
//            String myData = "<html><body style=\"text-align:center\"> Moscaic Virus in Lettuce  </body></Html>";
//
//            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
            tab.setText("Moscaic Virus in Lettuce");
        } else if (disease.equalsIgnoreCase("pechayant")) {
//            String myData = "<html><body style=\"text-align:center\"sudo> Anthracnose in Pechay </body></Html>";
//
//            webView.Anthracnose(String.format(htmlText,myData),"text/html","utf-8");
            tab.setText("Mildew in Pechayo");
        }else if (disease.equalsIgnoreCase("pechaymil") ) {
//            String myData = "<html><body style=\"text-align:center\"> Mildew in Pechay </body></Html>";
//
//            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
            tab.setText("Mildew in Pechay");
        }
    }
    else if(condition.equalsIgnoreCase("object")) {
//            String myData = "<html><body style=\"text-align:center\"> Not a Plant </body></Html>";
//
//            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
        tab.setText("Not a Plant");
        }
    else if(condition.equalsIgnoreCase("healthy")){
//        if (disease.equals("pechayhea")) {
            tab.setText("No Disease Detected");
//        }
//        else if (disease.equals("lettucehea")) {
//            tab.setText("Lettuce has no disease.");
//        }
//        else if (disease.equals("tomatohea")) {
//            tab.setText("Tomato has no disease.");
//        }

    }




        return view;
    }

}
