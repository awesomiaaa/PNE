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

public class TabFragment2 extends Fragment {
    TextView tab;
    WebView webView;
    WebSettings webSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment2, container, false);

        Intent intent = getActivity().getIntent();
        final String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);
        final String diagnosis = intent.getStringExtra(DevelopersAdapter.KEY_DIAGNOSIS);
        webView= (WebView) view.findViewById(R.id.textView);
        webSettings=webView.getSettings();
        webSettings.setDefaultFontSize(20);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);
        String htmlText = " %s ";




//        tab = (TextView) view.findViewById(R.id.textView);
//        tab.setText(diagnosis);
//        //   tab.setText(diagnosis);

        if(condition.equalsIgnoreCase("unhealthy")) {
            if (disease.equalsIgnoreCase("tomatoant")) {
                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>The disease detected is Anthracnose, which is caused by a fungus, and among vegetables, it attacks cucurbits. This disease affects many plants, including vegetables and fruit. It causes dark, sunken lesions on leaves, stems, flowers and fruit.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("tomatobli")) {
                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>The disease detected is a blight or late blight, which is caused by the oomycete pathogen Phytophthora infestans. This is referred to as community disease due to its ability to spread rapidly from field to field under the right weather conditions.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("lettucemos") ) {
                String myData = "<html><body style=\"text-align:justify\"> Diagnostic techniques for viruses fall into two broad categories: biological properties related to the interaction of the virus with its host and/or vector (e.g., symptomatology and transmission tests) and intrinsic properties of the virus itself (coat protein and nucleic acid). Detection methods based on coat protein include precipitation/agglutination tests, enzyme-linked immunosorbent assays, and immunoblotting. Viral nucleic acid-based techniques like dot-blot hybridization assays and polymerase chain reaction are more sensitive than other methods. </body></Html>";

                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("pechayant")) {
                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>The disease detected is Anthracnose, which is caused by a fungus, and among vegetables, it attacks cucurbits. This disease affects many plants, including vegetables and fruit. It causes dark, sunken lesions on leaves, stems, flowers and fruit.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            }else if (disease.equalsIgnoreCase("pechaymil") ) {
                String myData = "<html><body style=\"text-align:justify\"> " +
                        "<ul style=\"list-style-type:disc;\"> " +
                        "<li>Plants infected with powdery mildew look as if they have been dusted with flour.</li>" +
                        "<li>Powdery mildew usually starts off as circular, powdery white spots, which can appear on leaves, stems, and sometimes fruit.</li>" +
                        "<li>Powdery mildew usually covers the upper part of the leaves, but may grow on the undersides as well.</li>" +
                        "<li>Young foliage is most susceptible to damage. Leaves turn yellow and dry out.</li>" +
                        "<li>The fungus might cause some leaves to twist, break, or become disfigured.</li>" +
                        "<li>The white spots of powdery mildew will spread to cover most of the leaves or affected areas.</li>" +
                        "<li>The leaves, buds, and growing tips will become disfigured as well. These symptoms usually appear late in the growing season.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            }
        }
        else if(condition.equalsIgnoreCase("object")) {
            String myData = "<html><body style=\"text-align:center\"> Not a Plant </body></Html>";

            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

        }

//        if (condition.equalsIgnoreCase("unhealthy")) {
//            if (disease.equalsIgnoreCase("Leaf Spot") || disease.equalsIgnoreCase("spot")) {
//             /*   tab.setText("Infected plants have brown or black water-soaked spots on the foliage, sometimes with a yellow halo, usually uniform in size. The spots enlarge and will run together under wet conditions. Under dry conditions the spots have a speckled appearance. As spots become more numerous, entire leaves may yellow, wither and drop.\n" +
//                        "\n" +
//                        "Both types of leaf spot are most active when there is plenty of moisture and warm temperatures. During the summer months, especially if plants are watered by overhead sprinklers, sufficient moisture may be present for infection when the bacteria are splashed or blown on to leaves. Wind and rain transmit the bacteria to plants.");
//      */
//                String myData = "<html><body style=\"text-align:justify\"> " +
//                        "<ul style=\"list-style-type:disc;\">" +
//                        "<li>Infected plants have brown or black water-soaked spots on the foliage, sometimes with a yellow halo, usually uniform in size. The spots enlarge and will run together under wet conditions. Under dry conditions the spots have a speckled appearance. As spots become more numerous, entire leaves may yellow, wither and drop.</li>" +
//                        "<li>Both types of leaf spot are most active when there is plenty of moisture and warm temperatures. During the summer months, especially if plants are watered by overhead sprinklers, sufficient moisture may be present for infection when the bacteria are splashed or blown on to leaves. Wind and rain transmit the bacteria to plants.</li>" +
//                        "</ul>" +
//                        "</body></Html>";
//                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
//
//            } else if (disease.equalsIgnoreCase("Powdery Mildew") || disease.equalsIgnoreCase("mildew")) {
//              /*  tab.setText("> Plants infected with powdery mildew look as if they have been dusted with flour.\n" +
//                        "> Powdery mildew usually starts off as circular, powdery white spots, which can appear on leaves, stems, and sometimes fruit.\n" +
//                        "> Powdery mildew usually covers the upper part of the leaves, but may grow on the undersides as well.\n" +
//                        "> Young foliage is most susceptible to damage. Leaves turn yellow and dry out.\n" +
//                        "\n" +
//                        "> The fungus might cause some leaves to twist, break, or become disfigured.\n" +
//                        "\n" +
//                        "> The white spots of powdery mildew will spread to cover most of the leaves or affected areas.\n" +
//                        "\n" +
//                        "> The leaves, buds, and growing tips will become disfigured as well. These symptoms usually appear late in the growing season. ");
//  */              String myData = "<html><body style=\"text-align:justify\"> " +
//                        "<ul style=\"list-style-type:disc;\"> " +
//                        "<li>Plants infected with powdery mildew look as if they have been dusted with flour.</li>" +
//                        "<li>Powdery mildew usually starts off as circular, powdery white spots, which can appear on leaves, stems, and sometimes fruit.</li>" +
//                        "<li>Powdery mildew usually covers the upper part of the leaves, but may grow on the undersides as well.</li>" +
//                        "<li>Young foliage is most susceptible to damage. Leaves turn yellow and dry out.</li>" +
//                        "<li>The fungus might cause some leaves to twist, break, or become disfigured.</li>" +
//                        "<li>The white spots of powdery mildew will spread to cover most of the leaves or affected areas.</li>" +
//                        "<li>The leaves, buds, and growing tips will become disfigured as well. These symptoms usually appear late in the growing season.</li>" +
//                        "</ul>" +
//                        "</body></Html>";
//                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
//
//            }
//            else if (disease.equalsIgnoreCase("Anthracnose") || disease.equals("antracnose' ")) {
////                tab.setText("The disease detected is Anthracnose, which is caused by a fungus, and among vegetables, it attacks cucurbits. This disease affects many plants, including vegetables and fruit. It causes dark, sunken lesions on leaves, stems, flowers and fruit. ");
//                String myData = "<html><body style=\"text-align:justify\">" +
//                        "<ul style=\"list-style-type:disc;\">" +
//                        "<li>The disease detected is Anthracnose, which is caused by a fungus, and among vegetables, it attacks cucurbits. This disease affects many plants, including vegetables and fruit. It causes dark, sunken lesions on leaves, stems, flowers and fruit.</li>" +
//                        "</ul>" +
//                        "</body></Html>";
//                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
//
//            } else if (disease.equalsIgnoreCase("Late Blight ") || disease.equalsIgnoreCase("late blight")) {
////                tab.setText("The disease detected is a blight or late blight, which is caused by the oomycete pathogen Phytophthora infestans. This is referred to as community disease due to its ability to spread rapidly from field to field under the right weather conditions. ");
//
//                String myData = "<html><body style=\"text-align:justify\">" +
//                        "<ul style=\"list-style-type:disc;\">" +
//                        "<li>The disease detected is a blight or late blight, which is caused by the oomycete pathogen Phytophthora infestans. This is referred to as community disease due to its ability to spread rapidly from field to field under the right weather conditions.</li>" +
//                        "</ul>" +
//                        "</body></Html>";
//                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
//
//            } else if (disease.equalsIgnoreCase("not a plant") || disease.equalsIgnoreCase("object") || disease.equalsIgnoreCase("Not a Plant")) {
////                tab.setText("Not a Plant");
//
//                String myData = "<html><body style=\"text-align:justify\">Not a Plant</body></Html>";
//                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
//
//            }
//        } else if (condition.equalsIgnoreCase("healthy")) {
////            tab.setText("No Disease Detected");
//
//            String myData = "<html><body style=\"text-align:justify\">No Disease Detected</body></Html>";
//            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
//
//        }
//        else if(condition.equalsIgnoreCase("object")) {
////            if(disease.equalsIgnoreCase("not a plant")) {
////                tab.setText("Not a Plant");
////            }
//            String myData = "<html><body style=\"text-align:justify\">Not a Plant</body></Html>";
//            webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
//
//        }

        return view;
    }
}
