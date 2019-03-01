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

public class TabFragment4 extends Fragment {
    TextView tab;
    WebView webView;
    WebSettings webSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment4, container, false);

        Intent intent = getActivity().getIntent();
        final String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);
        final String diagnosis = intent.getStringExtra(DevelopersAdapter.KEY_DIAGNOSIS);

        webView= (WebView) view.findViewById(R.id.textView4);
        webSettings=webView.getSettings();
        webSettings.setDefaultFontSize(20);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);
        String htmlText = " %s ";

//        tab = (TextView) view.findViewById(R.id.textView4);
//        tab.setText(diagnosis);
//        //   tab.setText(diagnosis);
        if(condition.equalsIgnoreCase("unhealthy")) {
            if (disease.equalsIgnoreCase("Leaf Spot") || disease.equalsIgnoreCase("spot")) {
               /* tab.setText("> Controlling and getting rid of leaf spot is easiest if you start to treat it as soon as you see signs of it.\n" +
                        "\n" +
                        "> Choose a product labeled for control of turf leaf spot fungal disease.\n" +
                        "Apply to affected areas, keeping in mind that you could apply to surrounding areas to try to prevent spread of the disease.\n" +
                        "\n" +
                        "> If the leaf spot has progressed in the disease cycle (where grass leaves are close to being overtaken by the spots) or if melting out has begun, it might very difficult to control.\n" +
                        "\n" +
                        ">If melting out has begun, this means the disease has progressed very far. If the melting out is at the very beginning stages, a fungicide formulated for this disease may offer some improvement. However, if it is advanced, there is little a fungicide can do in the way of correcting the disease, although it will help to limit further spreading of the disease in your lawn. The disease will run its course, leaving you with thinned grass in the affected areas, but will allow you to then re-seed your grass.\n" +
                        "\n" +
                        "> Keep in mind that if your fungicide applications don't seem to be effective, you can perform a preventative application in the spring to prevent leaf spot from returning.\n" +
                        "\n" +
                        "> Make sure to rotate the fungicide products you are using to ensure the fungus in your turf does not become resistant to the products, leaving you with an incurable turf disease.\n" +
                        "\n" +
                        "> You will likely have to re-treat throughout the growing season, so follow label directions carefully for application guidelines and timing.");
*/
                String myData = "<html><body style=\"text-align:justify\"> " +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>Choose a product labeled for control of turf leaf spot fungal disease.</li>" +
                        "<li>Apply to affected areas, keeping in mind that you could apply to surrounding areas to try to prevent spread of the disease.</li>" +
                        "<li>If the leaf spot has progressed in the disease cycle (where grass leaves are close to being overtaken by the spots) or if melting out has begun, it might very difficult to control.</li>" +
                        "<li>If melting out has begun, this means the disease has progressed very far. If the melting out is at the very beginning stages, a fungicide formulated for this disease may offer some improvement. However, if it is advanced, there is little a fungicide can do in the way of correcting the disease, although it will help to limit further spreading of the disease in your lawn. The disease will run its course, leaving you with thinned grass in the affected areas, but will allow you to then re-seed your grass.</li>" +
                        "</ul>" +
                        " </body></Html>";

                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("Powdery Mildew") || disease.equalsIgnoreCase("mildew")) {
        /*        tab.setText("> Remove all the infected plant parts and destroy them. Remember, do not compost any infected plant, as the disease can still be spread by the wind and persist in the composted materials.\n" +
                        "\n" +
                        "> Spray infected plants with fungicides. Effective organic fungicides for treating powdery mildew include sulfur, lime-sulfur, neem oil, and potassium bicarbonate.");
   */
                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>Remove all the infected plant parts and destroy them. Remember, do not compost any infected plant, as the disease can still be spread by the wind and persist in the composted materials.</li>" +
                        "<li>Spray infected plants with fungicides. Effective organic fungicides for treating powdery mildew include sulfur, lime-sulfur, neem oil, and potassium bicarbonate.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("Anthracnose") || disease.equalsIgnoreCase("antracnose' ")) {
           /*     tab.setText("Remove and destroy any infected plants in your garden. For trees, prune out the dead wood and destroy the infected leaves.\n" +
                        "You can try spraying your plants with a copper-based fungicide, though be careful because copper can build up to toxic levels in the soil for earthworms and microbes. For trees, try a dormant spray of bordeaux mix.");
      */
                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>Remove and destroy any infected plants in your garden. For trees, prune out the dead wood and destroy the infected leaves.</li>" +
                        "<li>You can try spraying your plants with a copper-based fungicide, though be careful because copper can build up to toxic levels in the soil for earthworms and microbes. For trees, try a dormant spray of bordeaux mix.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("Late Blight ") || disease.equalsIgnoreCase("lateblight")) {
            /*    tab.setText("Spray Bodeaux mixture on the trees and cuttings after pruning affected parts. \n" +
                        "Apply a concoction of garlic or horsetail on the leaves and fruits. \n" +
                        "Always consider an integrated pest management with preventive measures and biological treatments if available. \n" +
                        "Treatment against the disease should begin in the early summer before ripening of fruits. \n");
*/
                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>Spray Bodeaux mixture on the trees and cuttings after pruning affected parts.</li>" +
                        "<li>Apply a concoction of garlic or horsetail on the leaves and fruits.</li>" +
                        "<li>Always consider an integrated pest management with preventive measures and biological treatments if available.</li>" +
                        "<li>Treatment against the disease should begin in the early summer before ripening of fruits.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("not a plant") || disease.equalsIgnoreCase("object")) {
//                tab.setText("None");
                String myData = "<html><body style=\"text-align:justify\">Not a Plant</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
            }
        }
        else if(condition.equalsIgnoreCase("object")) {
//            tab.setText("Not a Plant");

            String myData = "<html><body style=\"text-align:justify\">Not a Plant</body></Html>";
            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
        }
        else if(condition.equalsIgnoreCase("healthy")){
//            tab.setText("No Disease Detected");

            String myData = "<html><body style=\"text-align:justify\">No Disease Detected</body></Html>";
            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
        }
        return view;
    }
}
