package com.example.deguzman.plantease;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class Main4Activity extends Fragment {
    TextView tab;
    WebView webView;
    WebSettings webSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment2, container, false);

        Intent intent = getActivity().getIntent();
        final String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);
        final String diagnosis = intent.getStringExtra(ListViewAdapter.KEY_DIAGNOSIS);

        webView= (WebView) view.findViewById(R.id.textView);
        webSettings=webView.getSettings();
        webSettings.setDefaultFontSize(20);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);
        String htmlText = " %s ";

        String myData = "<html><body style=\"text-align:justify\"> " + diagnosis + "</body></Html>";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");


//        tab = (TextView) view.findViewById(R.id.textView);
//        tab.setText(diagnosis);
//        //   tab.setText(diagnosis);

        return view;
    }
}
