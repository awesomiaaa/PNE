package com.example.deguzman.plantease;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    public static final String result = "result";

    public static final String postition = "";

    public static final String KEY_DISEASE = "disease";

    public static final String KEY_DIAGNOSIS = "diagnosis";

    public static final String KEY_PREVMES = "preventive measures";

    public static final String KEY_WAYS = "ways to control";


    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                Model model1 = modellist.get(postition);
                if (model1.getTitle().equals("Mildew")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Mildew (Bremia lactucae) is a common disease of lettuce in cooler growing environments, where temperatures are low and there are long periods of leaf wetness caused by overnight dew. These conditions are common in late-fall and in cool season greenhouses, and this fall we have seen downy mildew in field lettuce and in a heated winter greenhouse. Symptoms can include white sporulation on leaf surfaces and growers may see the white growth on leaves and assume they have powdery mildew. Importantly, downy mildew requires cool weather and leaf wetness while powdery mildew occurs during warm weather and under dry conditions. Downy mildew is caused by an oomycete like late blight and powdery mildew is caused by a fungus, so fungicides used to control one may not control the other. Be sure to properly identify the pathogen or submit a sample to the diagnostic lab." );
                    intent.putExtra(KEY_DIAGNOSIS,       "The disease causes leaf yellowing in angular patches, as the spots are vein-limited. On red varieties the initial spots may appear more grayish and water-soaked. Under humid conditions, white crusty sporulation forms when sporangiophores emerge from stomata and produce sporangia in distinct white projections, as with brassica downy mildew. Sporulation usually forms on the underside of the leaf but may also be seen on the upper leaf surface. Later, lesions turn tan or brown and papery as the tissue is killed. Older leaves close to the ground usually are the first to show symptoms." +
                            " However, very susceptible vegetables such as cucurbits (cucumber, melons, squash, and pumpkins) may require fungicide treatment. Several least-toxic fungicides are available but must be applied no later than the first sign of disease.");
                    intent.putExtra(KEY_PREVMES, " Planting resistant vegetable varieties when available, or avoiding the most susceptible varieties, planting in the full sun, and following good cultural practices will adequately control powdery mildew in many cases.");
                    intent.putExtra(KEY_WAYS, " Apply protectant fungicides, such as wettable sulfur, to susceptible plants before or in the earliest stages of disease development. The protectant fungicides are only effective on contact, so applications must provide thorough coverage of all susceptible plant parts. As plants grow and produce new tissue, additional applications may be necessary at 7- to 10-day intervals as long as conditions are conducive to disease growth.\n" +
                            "\n" +
                            "If mild to moderate mildew symptoms are present, the horticultural oils and plant-based oils such as neem oil and jojoba oil can be used to reduce or eliminate the infection. ");
                    intent.putExtra("iconTv", R.drawable.downey_mildew);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Blight")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle",  model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Blight has been referred to as a ‘community disease’, due to its ability to spread rapidly from field to field under the right weather conditions.  Asexual spores travel easily on the wind when the weather is cool and moist, and can rapidly infect neighboring fields.  As such, understanding the symptoms of the disease and what to do when it is detected are essential to preventing an outbreak from rapidly turning into an epidemic.");
                    intent.putExtra(KEY_DIAGNOSIS,
                            "    1. Plant resistant cultivars when available.<br>\n" +
                            "    2. Remove volunteers from the garden prior to planting and space plants far enough apart to allow for plenty of air circulation.<br>\n" +
                            "    3. Water in the early morning hours, or use soaker hoses, to give plants time to dry out during the day — avoid overhead irrigation.<br>\n" +
                            "    4. Destroy all tomato and potato debris after harvest (see Fall Garden Cleanup).<br>\n");
                    intent.putExtra(KEY_PREVMES, " The two easiest routes to preventing late blight are:<br>\n" +
                            "\n" +
                            "<br>    Plant resistant varieties. Keep in mind that a handful of varieties are resistant to late blight, but not totally immune. They may be slower to get and spread the disease, but they're not fail safe.\n" +
                            "<br>    Potatoes: Resistant potato varieties include 'Defender' and \"Elba'. 'Kennebec', 'Sebago', 'Allegany', and' Rosa' also show some resistance.\n" +
                            "<br>    Tomatoes: There is a lot of breeding work being done, but I haven't had a lot of luck with the varieties  being introduced. 'Mountain Magic', was the first to show resistance. It is a cherry tomato and while it did grow well for me, the flavor was not terrific. 'Iron Lady' struggled all season in my garden, during a wet summer. They could do better in your garden or in drier years.\n" +
                              "\n");
                    intent.putExtra(KEY_WAYS, "Before disease occurs, apply fungicides at 7-10 day intervals. After disease is detected in your area, apply fungicides at 5-7 day intervals. Alternate products and tank mix mancozeb or chlorothalonil to avoid generating fungicide-resistant strains.");
                    intent.putExtra("iconTv", R.drawable.late_blight);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Mosaic Virus")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Viruses are intracellular (inside cells) pathogenic particles that infect other living organisms. Human diseases caused by viruses include chickenpox, herpes, influenza, rabies, small pox and AIDS (acquired immunodeficiency syndrome). Although these are the viruses most of us are familiar with, the first virus ever described and from which the term was eventually derived was tobacco mosaic virus or TMV (the term virus was derived from the original description of the causal agent of TMV—“contagium vivum fluidum” or contagious living fluid). TMV was discovered by Martinus W. Beijerinck, a Dutch microbiologist, in 1898. Virus particles are extremely small and can be seen only with an electron microscope. Most plant viruses are either rod-shaped or isometric (polyhedral). TMV, potato virus Y (PVY), and cucumber mosaic virus (CMV) are examples of a short rigid rod-shaped, a long flexuous rod-shaped, and an isometric virus, respectively. Viruses consist of an inner core of nucleic acid (either ribonucleic acid [RNA] or deoxyribonucleic acid [DNA]) surrounded by an outer sheath or coat of protein (referred to as the capsid). The capsid is further enclosed by a membrane in most human and animal viruses that helps the virus pass through the cell membrane in these types of cells. Since the cell membrane in plants is surrounded by a rigid cell wall, plant viruses require a wound for their initial entrance into a plant cell. Wounds in plants can occur naturally, such as in the branching of lateral roots. They may also be the result of agronomic or horticultural practices, or other mechanical means; fungal, nematode, or parasitic plant infections; or by insects.");
                    intent.putExtra(KEY_DIAGNOSIS, "Diagnostic techniques for viruses fall into two broad categories: biological properties related to the interaction of the virus with its host and/or vector (e.g., symptomatology and transmission tests) and intrinsic properties of the virus itself (coat protein and nucleic acid). Detection methods based on coat protein include precipitation/agglutination tests, enzyme-linked immunosorbent assays, and immunoblotting. Viral nucleic acid-based techniques like dot-blot hybridization assays and polymerase chain reaction are more sensitive than other methods.");
                    intent.putExtra(KEY_PREVMES, "Treatment\n" +
                            "\n" +
                            "There are no cures for viral diseases such as mosaic once a plant is infected. As a result, every effort should be made to prevent the disease from entering your garden.\n" +
                            "\n" +
                            "<br>    1. Fungicides will NOT treat this viral disease.\n" +
                            "<br>    2. Plant resistant varieties when available or purchase transplants from a reputable source.\n" +
                            "<br>    3. Do NOT save seed from infected crops.\n" +
                            "<br>    4. Spot treat with least-toxic, natural pest control products, such as Safer Soap, Bon-Neem and diatomaceous earth, to reduce the number of disease carrying insects.\n" +
                            "<br>    5. Harvest-Guard® row cover will help keep insect pests off vulnerable crops/ transplants and should be installed until bloom.\n" +
                    intent.putExtra(KEY_WAYS, "So here we have added some simple suggestions to manage the plant viruses at farmer level.\n" +
                            "\n" +
                            "<br>    1.\tThe best way is to avoid the disease. If the plant viruses are prevailing in an area continuously; farmers just need to apply crop rotation to avoid the availability of same host.\n" +
                            "<br>    2.\tSelection of seed should be done from credible sources ensuring virus free tags. This may include Cuttings, bulls, rhizomes, tubers and seeds.\n" +
                            "<br>    3.\tEradicate the diseased plant from the field which will eliminate the inoculum from the field.\n" +
                            "<br>    4.\tInsect vectors are the active transmitters of the viruses from weeds and other plant sources. These must be efficiently managed though eradication of weeds which harbor them and via sowing of trap crops. e.g. Cotton reddening for white flies in bhendi. Similarly soil fumigation can be applied against nematode transmitted viruses to control nematodes. Furthermore insecticides can also be applied for reducing their population.\n" +
                            "<br>    5.\tUnderstanding the non crop plants which are active hosts and harbors of plant viruses is also important as they are the virus factories which must be terminated through cleaning of farm sides.\n" +
                            "<br>    6.\tSelection of virus tolerant verities can be very effective. e.g. Parbhani Kranti against yellow vein mosaic of the bhendi.\n"));
                    intent.putExtra("iconTv", R.drawable.yellow_leaf);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Anthracnose")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Anthracnose is a general term for a variety of diseases that affect plants in similar ways. Anthracnose is especially known for the damage that it can cause to trees. Anthracnose is caused by a fungus, and among vegetables, it attacks cucurbits.\n" +
                            "\n" +
                            "Anthracnose can survive on infected plant debris and is very easily spread. Like rust, it thrives under moist and warm conditions and is often spread by watering.");
                    intent.putExtra(KEY_DIAGNOSIS, "    On leaves, anthracnose generally appears first as small, irregular yellow or brown spots. These spots darken as they age and may also expand, covering the leaves.\n" +
                            "<br>    On vegetables, it can affect any part of the plant.\n" +
                            "<br>    On fruits, it produces small, dark, sunken spots, which may spread. In moist weather, pinkish spore masses form in the center of these spots. Eventually, the fruits will rot.\n" +
                            "<br>   On trees, it can kill the tips of young twigs. It also attacks the young leaves, which develop brown spots and patches. It can also cause defoliation of the tree.\n");
                    intent.putExtra(KEY_PREVMES, "    Plant resistant plants, or buy healthy transplants.\n" +
                            "<br>    Plant your plants in well-drained soil. You can also enrich the soil with compost in order to help plants resist diseases.\n" +
                            "<br>    Water your plants with a drip sprinkler, as opposed to an overhead sprinkler. Don’t touch the plants when they are wet.\n" +
                            "<br>    Keep ripening fruits from touching the soil.\n" +
                            " <br>   Remember to rotate your plants every 2 to 3 years.\n");
                    intent.putExtra(KEY_WAYS, 
                            "<br>    Remove and destroy any infected plants in your garden. For trees, prune out the dead wood and destroy the infected leaves.\n" +
                            "<br>    You can try spraying your plants with a copper-based fungicide, though be careful because copper can build up to toxic levels in the soil for earthworms and microbes. For trees, try a dormant spray of bordeaux mix.\n");
                    intent.putExtra("iconTv", R.drawable.bacterial_spots);
                    view.getContext().startActivity(intent);
                }

            }

        });



        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}