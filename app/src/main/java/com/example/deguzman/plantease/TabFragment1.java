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

        View view = inflater.inflate(R.layout.activity_tab_fragment1, container, false);

        Intent intent = getActivity().getIntent();
        String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);

        String libdisease = intent.getStringExtra(ListViewAdapter.KEY_DISEASE);


//        tab = (TextView) view.findViewById(R.id.textView2);

        webView= (WebView) view.findViewById(R.id.textView2);
        webSettings=webView.getSettings();
        webSettings.setDefaultFontSize(20);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);
        String htmlText = " %s ";


      //  tab.setText(libdisease);
    if(condition.equalsIgnoreCase("unhealthy")) {
        if (disease.equalsIgnoreCase("Leaf Spot") || disease.equalsIgnoreCase("spot")) {
            String myData = "<html><body style=\"text-align:center\"> Leaf Spot </body></Html>";

            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        } else if (disease.equalsIgnoreCase("Powdery Mildew") || disease.equalsIgnoreCase("mildew")) {
            String myData = "<html><body style=\"text-align:center\"> Powdery Mildew </body></Html>";

            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        } else if (disease.equalsIgnoreCase("Anthracnose") || disease.equalsIgnoreCase("antracnose' ")) {
            String myData = "<html><body style=\"text-align:center\"> Anthracnose </body></Html>";

            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        } else if (disease.equalsIgnoreCase("Late Blight ") || disease.equalsIgnoreCase("lateblight")) {
            String myData = "<html><body style=\"text-align:center\"> Late Blight </body></Html>";

            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        } else if (disease.equalsIgnoreCase("not a plant") || disease.equalsIgnoreCase("object")) {
            String myData = "<html><body style=\"text-align:center\"> Not a Plant </body></Html>";

            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        }
    }
    else if(condition.equalsIgnoreCase("object")) {
            String myData = "<html><body style=\"text-align:center\"> Not a Plant </body></Html>";

            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        }
    else if(condition.equalsIgnoreCase("healthy")){
        String myData = "<html><body style=\"text-align:center\"> No Disease Detected </body></Html>";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

    }




        return view;
    }

}
