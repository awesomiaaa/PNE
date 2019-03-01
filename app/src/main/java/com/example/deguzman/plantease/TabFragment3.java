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
import android.widget.LinearLayout;
import android.widget.TextView;

public class TabFragment3 extends Fragment {
    TextView tab;
    WebView webView;
    WebSettings webSettings;
    WebView.LayoutParams layoutParams;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tab_fragment3, container, false);

        Intent intent = getActivity().getIntent();
        final String disease = intent.getStringExtra(DevelopersAdapter.KEY_DISEASE);
        final String condition = intent.getStringExtra(DevelopersAdapter.KEY_CONDITION);
        final String diagnosis = intent.getStringExtra(DevelopersAdapter.KEY_DIAGNOSIS);
        webView= (WebView) view.findViewById(R.id.textView3);
        webSettings=webView.getSettings();
        webSettings.setDefaultFontSize(20);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webSettings.setJavaScriptEnabled(true);
        WebView.LayoutParams layoutParams = (WebView.LayoutParams) webView.getLayoutParams();
        String htmlText = " %s ";



//        tab = (TextView) view.findViewById(R.id.textView3);
//        tab.setText(diagnosis);
//        //   tab.setText(diagnosis);
        if(condition.equalsIgnoreCase("unhealthy")) {
            if (disease.equalsIgnoreCase("Leaf Spot") || disease.equalsIgnoreCase("spot")) {
//                tab.setText("> When selecting fruit trees, choose resistant varieties if possible.\n" +
//                        "\n" +
//                        "> Keep the soil under the tree clean and rake up fallen fruit.\n" +
//                        "\n" +
//                        "> Use a thick layer of mulch to cover the soil after you have raked and cleaned it well. Mulch will reduce weeds and prevent the disease pathogen from splashing back up onto the leaves.\n" +
//                        "\n" +
//                        "> Prune or stake plants to improve air circulation. Make sure to disinfect your pruning equipment (one part bleach to 4 parts water) after each cut.\n" +
//                        "\n" +
//                        "> Leaf spot among vegetables is most often introduced through infected seed or transplants. Make sure your seeds and transplants are from leaf spot-free stock.");

                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>When selecting fruit trees, choose resistant varieties if possible.</li>" +
                        "<li>Keep the soil under the tree clean and rake up fallen fruit.</li>" +
                        "<li>Use a thick layer of mulch to cover the soil after you have raked and cleaned it well. Mulch will reduce weeds and prevent the disease pathogen from splashing back up onto the leaves.</li>" +
                        "<li>Prune or stake plants to improve air circulation. Make sure to disinfect your pruning equipment (one part bleach to 4 parts water) after each cut.</li>" +
                        "<li>Leaf spot among vegetables is most often introduced through infected seed or transplants. Make sure your seeds and transplants are from leaf spot-free stock.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("Powdery Mildew") || disease.equalsIgnoreCase("mildew")) {
              /*  tab.setText("> Choose plants that are resistant or tolerant to powdery mildew. Many mildew-resistant varieties of cucurbits (melons, cucumbers, squash, etc.) have been developed and can be bought from major seed suppliers.\n" +
                        "\n" +
                        "> Avoid watering plants from overhead in order to reduce relative humidity.\n" +
                        "\n" +
                        "> Selectively prune overcrowded areas to increase air circulation; this also helps to reduce humidity around your plants.\n" +
                        "\n" +
                        "> Spray your plants with the fungicides mentioned above according to the directions included with the products.\n" +
                        "\n" +
                        "If you don't want to use fungicides, try spraying your plants with a bicarbonate solution:\n" +
                        "Mix 1 teaspoon baking soda in 1 quart of water. Spray plants thoroughly, as the solution will only kill fungus that it comes into contact with.\n");
     */         String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>Choose plants that are resistant or tolerant to powdery mildew. Many mildew-resistant varieties of cucurbits (melons, cucumbers, squash, etc.) have been developed and can be bought from major seed suppliers.</li>" +
                        "<li>Avoid watering plants from overhead in order to reduce relative humidity.</li>" +
                        "<li>Selectively prune overcrowded areas to increase air circulation; this also helps to reduce humidity around your plants.</li>" +
                        "<li>Spray your plants with the fungicides mentioned above according to the directions included with the products.</li>" +
                        "<li>If you don't want to use fungicides, try spraying your plants with a bicarbonate solution:</li>" +
                        "<li>Mix 1 teaspoon baking soda in 1 quart of water. Spray plants thoroughly, as the solution will only kill fungus that it comes into contact with.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");

            } else if (disease.equalsIgnoreCase("Anthracnose") || disease.equalsIgnoreCase("antracnose' ")) {
               /* tab.setText("Plant resistant plants, or buy healthy transplants.\n" +
                        "Plant your plants in well-drained soil. You can also enrich the soil with compost in order to help plants resist diseases.\n" +
                        "Water your plants with a drip sprinkler, as opposed to an overhead sprinkler. Don’t touch the plants when they are wet.\n" +
                        "Keep ripening fruits from touching the soil.\n" +
                        "Remember to rotate your plants every 2 to 3 years.");
    */

                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>Plant resistant plants, or buy healthy transplants.</li>" +
                        "<li>Plant your plants in well-drained soil. You can also enrich the soil with compost in order to help plants resist diseases.</li>" +
                        "<li>Water your plants with a drip sprinkler, as opposed to an overhead sprinkler. Don’t touch the plants when they are wet.</li>" +
                        "<li>Keep ripening fruits from touching the soil.</li>" +
                        "<li>Remember to rotate your plants every 2 to 3 years.</li>" +
                        "</ul>" +
                        "</body></Html>";
                webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
            } else if (disease.equalsIgnoreCase("Late Blight ") || disease.equalsIgnoreCase("lateblight")) {
          /*      tab.setText("Use less susceptible varieties as well as healthy seeds from certified source. \n" +
                        "Avoid tight plantings to promote aeration of canopy. \n" +
                        "Inspect the orchard regularly to detect the first signs of the diseases. \n" +
                        "Manage weeds on the orchard floor. \n" +
                        "Cut and burn the affected parts as soon as the first symptoms are visible. \n" +
                        "Avoid irrigation by sprinkling especially during fruit ripening. \n" +
                        "Above all, do now compost these plant parts as they will carry over the disease to another season. ");
*/
                String myData = "<html><body style=\"text-align:justify\">" +
                        "<ul style=\"list-style-type:disc;\">" +
                        "<li>Use less susceptible varieties as well as healthy seeds from certified source. </li>" +
                        "<li>Avoid tight plantings to promote aeration of canopy. </li>" +
                        "<li>Inspect the orchard regularly to detect the first signs of the diseases. </li>" +
                        "<li>Manage weeds on the orchard floor. </li>" +
                        "<li>Cut and burn the affected parts as soon as the first symptoms are visible.</li>" +
                        "<li>Avoid irrigation by sprinkling especially during fruit ripening.</li>" +
                        "<li>Above all, do now compost these plant parts as they will carry over the disease to another season.</li>" +
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
