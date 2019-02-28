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
                if (model1.getTitle().equals("Downy Mildew")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Downy mildew (Bremia lactucae) is a common disease of lettuce in cooler growing environments, where temperatures are low and there are long periods of leaf wetness caused by overnight dew. These conditions are common in late-fall and in cool season greenhouses, and this fall we have seen downy mildew in field lettuce and in a heated winter greenhouse. Symptoms can include white sporulation on leaf surfaces and growers may see the white growth on leaves and assume they have powdery mildew. Importantly, downy mildew requires cool weather and leaf wetness while powdery mildew occurs during warm weather and under dry conditions. Downy mildew is caused by an oomycete like late blight and powdery mildew is caused by a fungus, so fungicides used to control one may not control the other. Be sure to properly identify the pathogen or submit a sample to the diagnostic lab." );
                    intent.putExtra(KEY_DIAGNOSIS,       "The disease causes leaf yellowing in angular patches, as the spots are vein-limited. On red varieties the initial spots may appear more grayish and water-soaked. Under humid conditions, white crusty sporulation forms when sporangiophores emerge from stomata and produce sporangia in distinct white projections, as with brassica downy mildew. Sporulation usually forms on the underside of the leaf but may also be seen on the upper leaf surface. Later, lesions turn tan or brown and papery as the tissue is killed. Older leaves close to the ground usually are the first to show symptoms." +
                            " However, very susceptible vegetables such as cucurbits (cucumber, melons, squash, and pumpkins) may require fungicide treatment. Several least-toxic fungicides are available but must be applied no later than the first sign of disease.");
                    intent.putExtra(KEY_PREVMES, " Planting resistant vegetable varieties when available, or avoiding the most susceptible varieties, planting in the full sun, and following good cultural practices will adequately control powdery mildew in many cases.");
                    intent.putExtra(KEY_WAYS, " Apply protectant fungicides, such as wettable sulfur, to susceptible plants before or in the earliest stages of disease development. The protectant fungicides are only effective on contact, so applications must provide thorough coverage of all susceptible plant parts. As plants grow and produce new tissue, additional applications may be necessary at 7- to 10-day intervals as long as conditions are conducive to disease growth.\n" +
                            "\n" +
                            "If mild to moderate powdery mildew symptoms are present, the horticultural oils and plant-based oils such as neem oil and jojoba oil can be used to reduce or eliminate the infection. ");
                    intent.putExtra("iconTv", R.drawable.downey_mildew);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Late Blight")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle",  model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Late blight has been referred to as a ‘community disease’, due to its ability to spread rapidly from field to field under the right weather conditions.  Asexual spores travel easily on the wind when the weather is cool and moist, and can rapidly infect neighboring fields.  As such, understanding the symptoms of the disease and what to do when it is detected are essential to preventing an outbreak from rapidly turning into an epidemic.");
                    intent.putExtra(KEY_DIAGNOSIS, "Treatment\n" +
                            "\n" +
                            "    1. Plant resistant cultivars when available.\n" +
                            "    2. Remove volunteers from the garden prior to planting and space plants far enough apart to allow for plenty of air circulation.\n" +
                            "    3. Water in the early morning hours, or use soaker hoses, to give plants time to dry out during the day — avoid overhead irrigation.\n" +
                            "    4. Destroy all tomato and potato debris after harvest (see Fall Garden Cleanup).\n");
                    intent.putExtra(KEY_PREVMES, " The two easiest routes to preventing late blight are:\n" +
                            "\n" +
                            "    Plant resistant varieties. Keep in mind that a handful of varieties are resistant to late blight, but not totally immune. They may be slower to get and spread the disease, but they're not fail safe.\n" +
                            "    Potatoes: Resistant potato varieties include 'Defender' and \"Elba'. 'Kennebec', 'Sebago', 'Allegany', and' Rosa' also show some resistance.\n" +
                            "    Tomatoes: There is a lot of breeding work being done, but I haven't had a lot of luck with the varieties  being introduced. 'Mountain Magic', was the first to show resistance. It is a cherry tomato and while it did grow well for me, the flavor was not terrific. 'Iron Lady' struggled all season in my garden, during a wet summer. They could do better in your garden or in drier years.\n" +
                            "    Some heirloom tomatoes that show some resistance include: 'Pruden's Purple', 'Mr. Stripey', and 'Matt's Wild Cherry'.\n" +
                            "    Keep the disease out of your garden. This may sound like double-talk, but the spores can over winter in potatoes that were infected. So if you saved some tubers to use as seed potatoes, you could be reintroducing the problem in your garden.\n" +
                            "    Late blight of potatoes is the same late blight that affects tomatoes - it will spread from one to the other. When late blight has been a problem in your area during the growing season, you should not save potatoes to replant. However they're fine to eat. Late blight does not affect humans or the flavor of the potatoes. But the spores will over winter on potatoes, so do not save them to replant and do not dispose of them in the compost pile. Plant only certified seed and seed potatoes.\n" +
                            "\n");
                    intent.putExtra(KEY_WAYS, "Before disease occurs, apply fungicides at 7-10 day intervals. After disease is detected in your area, apply fungicides at 5-7 day intervals. Alternate products and tank mix mancozeb or chlorothalonil to avoid generating fungicide-resistant strains.");
                    intent.putExtra("iconTv", R.drawable.late_blight);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Viral Diseases")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Viruses are intracellular (inside cells) pathogenic particles that infect other living organisms. Human diseases caused by viruses include chickenpox, herpes, influenza, rabies, small pox and AIDS (acquired immunodeficiency syndrome). Although these are the viruses most of us are familiar with, the first virus ever described and from which the term was eventually derived was tobacco mosaic virus or TMV (the term virus was derived from the original description of the causal agent of TMV—“contagium vivum fluidum” or contagious living fluid). TMV was discovered by Martinus W. Beijerinck, a Dutch microbiologist, in 1898. Virus particles are extremely small and can be seen only with an electron microscope. Most plant viruses are either rod-shaped or isometric (polyhedral). TMV, potato virus Y (PVY), and cucumber mosaic virus (CMV) are examples of a short rigid rod-shaped, a long flexuous rod-shaped, and an isometric virus, respectively. Viruses consist of an inner core of nucleic acid (either ribonucleic acid [RNA] or deoxyribonucleic acid [DNA]) surrounded by an outer sheath or coat of protein (referred to as the capsid). The capsid is further enclosed by a membrane in most human and animal viruses that helps the virus pass through the cell membrane in these types of cells. Since the cell membrane in plants is surrounded by a rigid cell wall, plant viruses require a wound for their initial entrance into a plant cell. Wounds in plants can occur naturally, such as in the branching of lateral roots. They may also be the result of agronomic or horticultural practices, or other mechanical means; fungal, nematode, or parasitic plant infections; or by insects.");
                    intent.putExtra(KEY_DIAGNOSIS, "Diagnostic techniques for viruses fall into two broad categories: biological properties related to the interaction of the virus with its host and/or vector (e.g., symptomatology and transmission tests) and intrinsic properties of the virus itself (coat protein and nucleic acid). Detection methods based on coat protein include precipitation/agglutination tests, enzyme-linked immunosorbent assays, and immunoblotting. Viral nucleic acid-based techniques like dot-blot hybridization assays and polymerase chain reaction are more sensitive than other methods.");
                    intent.putExtra(KEY_PREVMES, "Treatment\n" +
                            "\n" +
                            "There are no cures for viral diseases such as mosaic once a plant is infected. As a result, every effort should be made to prevent the disease from entering your garden.\n" +
                            "\n" +
                            "    1. Fungicides will NOT treat this viral disease.\n" +
                            "    2. Plant resistant varieties when available or purchase transplants from a reputable source.\n" +
                            "    3. Do NOT save seed from infected crops.\n" +
                            "    4. Spot treat with least-toxic, natural pest control products, such as Safer Soap, Bon-Neem and diatomaceous earth, to reduce the number of disease carrying insects.\n" +
                            "    5. Harvest-Guard® row cover will help keep insect pests off vulnerable crops/ transplants and should be installed until bloom.\n" +
                            "    6. Remove all perennial weeds, using least-toxic herbicides, within 100 yards of your garden plot.\n" +
                            "    7. The virus can be spread through human activity, tools and equipment. Frequently wash your hands and disinfect garden tools, stakes, ties, pots, greenhouse benches, etc. (one part bleach to 4 parts water) to reduce the risk of contamination.\n" +
                            "    8. Avoid working in the garden during damp conditions (viruses are easily spread when plants are wet).\n" +
                            "    9. Avoid using tobacco around susceptible plants. Cigarettes and other tobacco products may be infected and can spread the virus.\n" +
                            "    10. Remove and destroy all infected plants (see Fall Garden Cleanup). Do NOT compost.\n");
                    intent.putExtra(KEY_WAYS, "So here we have added some simple suggestions to manage the plant viruses at farmer level.\n" +
                            "\n" +
                            "    1.\tThe best way is to avoid the disease. If the plant viruses are prevailing in an area continuously; farmers just need to apply crop rotation to avoid the availability of same host.\n" +
                            "    2.\tSelection of seed should be done from credible sources ensuring virus free tags. This may include Cuttings, bulls, rhizomes, tubers and seeds.\n" +
                            "    3.\tEradicate the diseased plant from the field which will eliminate the inoculum from the field.\n" +
                            "    4.\tInsect vectors are the active transmitters of the viruses from weeds and other plant sources. These must be efficiently managed though eradication of weeds which harbor them and via sowing of trap crops. e.g. Cotton reddening for white flies in bhendi. Similarly soil fumigation can be applied against nematode transmitted viruses to control nematodes. Furthermore insecticides can also be applied for reducing their population.\n" +
                            "    5.\tUnderstanding the non crop plants which are active hosts and harbors of plant viruses is also important as they are the virus factories which must be terminated through cleaning of farm sides.\n" +
                            "    6.\tSelection of virus tolerant verities can be very effective. e.g. Parbhani Kranti against yellow vein mosaic of the bhendi.\n" +
                            "    7.\tHot water treatment can be effective against some viruses. e.g. Sugarcane mosaic can be reduced by such treatment at 520 C for 30 minutes.\n" +
                            "    8.\tLastly and most importantly; the education. All the above mentioned suggestions can only be applied if farmer is able to identify the virus diseases. So farmers should take trainings and contact the active extension service departments for learning.\n" );
                    intent.putExtra("iconTv", R.drawable.yellow_leaf);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bacterial spots")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Bacterial leaf spots are caused by the Xanthomonas and Pseudomonas families of bacteria. These bacteria overwinter in plant debris, but cannot survive for long in soil or water alone. Bacteria infect foliage, fruit, and stems, but require openings such as lesions to get inside the plant because they are relatively weak pathogens. Commonly, insects create lesions from feeding on plants, which the bacteria take advantage of. The pathogen itself is seedborne, which can then spread to other nearby plants after the seedling begins to grow through splashing water and overhead irrigation. Spread of the disease is moderately fast if water splashing is highly prevalent. However, this pathogen is highly dependent on cool and wet conditions, so if these conditions are not met, the pathogen’s distribution will be highly deterred.");
                    intent.putExtra(KEY_DIAGNOSIS, "Bacterial leaf spot on plants may manifest in several different ways. Symptoms of bacterial leaf spot may include black edged lesions, brown spots with yellow halos or just light and dark areas on the foliage. Spots are irregular and measure between 3/16 and ½ inch wide. They can occur on the top or bottom of a leaf and kill sections of the tissue when they cluster together.");
                    intent.putExtra(KEY_PREVMES, "You can use a copper fungicide on crops. This has limited management use unless it is applied early in the disease cycle. On ornamental plants, remove the affected leaves at the first sign to prevent the bacteria from jumping onto adjacent leaves. Some of the most common hosts are lettuce, beets, eggplant, peppers and large leaved ornamental plants, such as philodendrons. Remove old vegetable debris in the garden and do not plant new crops where host plants were once growing. There are no recognized chemical treatments for bacterial leaf spot disease. Your best bet is prevention and mechanical control at the first sign of symptoms of bacterial leaf spot.\n");
                    intent.putExtra(KEY_WAYS, "Control\n" +
                            "\n" +
                            "    1. When selecting fruit trees, choose resistant varieties if possible.\n" +
                            "    2. Keep the soil under the tree clean and rake up fallen fruit.\n" +
                            "    3. Use a thick layer of mulch to cover the soil after you have raked and cleaned it well. Mulch will reduce weeds and prevent the disease pathogen from splashing back up onto the leaves.\n" +
                            "    4. Prune or stake plants to improve air circulation. Make sure to disinfect your pruning equipment (one part bleach to 4 parts water) after each cut.\n" +
                            "    5. Leaf spot among vegetables is most often introduced through infected seed or transplants. Make sure your seeds and transplants are from leaf spot-free stock.\n");
                    intent.putExtra("iconTv", R.drawable.bacterial_spots);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Gray Mold")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "A fungus that is pathogenic on many plants. This organism can survive on many hosts or on plant debris. It is an opportunistic pathogen and its spores (conidia) easily invade weak, damaged, or senescing tissue when wet. Conidia are produced throughout the growing season under a wide range of temperatures and humidity but cool temperatures, high humidity, and free water on plant surfaces favor the disease, as do close plant spacing and irrigation practices that keep plants wet for a long time. Downy mildew infection of leaves or Pythium infection of lower leaves or stems will make tissues susceptible to gray mold.");
                    intent.putExtra(KEY_DIAGNOSIS, "    1. The symptoms of gray mold depend on the type of plant and environmental conditions, but generally spots that appear water-soaked will form on the leaves. These might appear white at first.\n" +
                            "    2. These spots will then change color from gray to brown, eventually covering most of the leaf and causing it to wilt. The brown coloration is what often causes people to confuse gray mold with brown mold.\n" +
                            "    3. Under really humid conditions, grayish webbing may appear on the leaves. In this webbing are structures that contain fuzzy spores. Spores become active and are released with any activity at all.\n" +
                            "    4. Petals, stems, and buds can also be infected.\n" +
                            "    5. Eventually, all of the infected parts of the plant will be covered by a fuzzy gray growth, causing you to seemingly have gray flowers.\n");
                    intent.putExtra(KEY_PREVMES, "    1. Handle your plants carefully when transplanting and pruning. Gray mold usually attacks wounded plants, so avoid harming your plants.\n" +
                            "    2. Keep your plants dry. Avoid overhead watering and watering late in the day. Give your plants time to dry off after watering them during the day.\n" +
                            "    3. Space your plants properly to encourage good air circulation.\n" +
                            "    4. Remember to clean between your plants. Remove any debris, including cuttings and dead leaves.\n");
                    intent.putExtra(KEY_WAYS, "    1. Remove the infected plants and destroy them.\n" +
                            "    2. Clean thoroughly between your plants so that the disease cannot infect your other plants.\n" +
                            "    3. You can try using sprays with cultural controls on your plants to prevent further infections.\n");
                    intent.putExtra("iconTv", R.drawable.gray_mold);
                    view.getContext().startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Soft Rot")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(view.getContext(), LibraryView.class);
                    intent.putExtra("actionBarTitle", model1.getTitle());
                    intent.putExtra(KEY_DISEASE, "Bacterial soft rots are caused by several types of bacteria, but most commonly by species of gram-negative bacteria, Erwinia, Pectobacterium, and Pseudomonas. It is a destructive disease of fruits, vegetables, and ornamentals found worldwide, and effects genera from nearly all the plant families. The bacteria mainly attack the fleshy storage organs of their hosts (tubers, corms, bulbs, and rhizomes), but they also affect succulent buds, stems, and petiole tissues. With the aid of special enzymes, the plant is turned into a liquidy mush in order for the bacteria to consume the plant cell's nutrients. Disease spread can be caused by simple physical interaction between infected and healthy tissues during storage or transit. The disease can also be spread by insects. Control of the disease is not always very effective, but sanitary practices in production, storing, and processing are something that can be done in order to slow the spread of the disease and protect yields. ");
                    intent.putExtra(KEY_DIAGNOSIS, " Initially, bacterial soft rots cause water-soaked spots. These spots enlarge over time and become sunken and soft. Interior tissues beneath the spots become mushy and discolored, with the discoloration ranging anywhere from cream to black. Seepage from affected areas is common. Soft rots are known for a strong, disagreeable odor that accompanies the breakdown of plant tissue.");
                    intent.putExtra(KEY_PREVMES, "Avoiding wet conditions is key for managing soft rot. Plant vegetables in well- drained soils and control watering times and amounts, making sure plants are watered adequately (but not excessively) and uniformly. DO NOT crowd plants; wider spacing will promote more rapid drying of plants and soil. Make sure that soil fertility (particularly soil calcium) is optimal for the vegetables that you are growing based on a soil nutrient test. Add calcium (e.g., bone meal) at planting as needed. Use soft rot-resistant vegetables in rotation with susceptible vegetables.");
                    intent.putExtra(KEY_WAYS, "Once soft rot bacteria have infected plants in the garden, there is no effective treatment. You will need to remove and dispose of infected plants as soon as possible to avoid further damage to other plants.\n" +
                            "\n" +
                            "Prevention is key in controlling soft rot bacteria. The following steps can be taken to help avoid this problem in the garden:\n" +
                            "\n" +
                            "    1. Avoid wet conditions. Make sure plants are in well-draining soil and properly spaced. Keep track of watering to prevent too much moisture.\n" +
                            "    2. Rotate crops with rot-resistant vegetables. Crop rotation goes a long way in managing or preventing problems in the garden. When rotating crops, select varieties that are less susceptible to soft rot like corn, snap beans and beets. If you have had previous issues with soft rot disease in the past, wait at least three years before growing susceptible crops in that area.\n" +
                            "    3. Use caution during garden maintenance. As you go about normal weeding tasks, or even harvesting, take care not to damage plants or veggies. Harvest only when conditions are dry and closely examine vegetables for any signs of problems that may affect storage, which should be in a cool, dry and well ventilated location.\n" +
                            "    4. Keep the garden and tools clean. Be sure to clean garden tools thoroughly before and after use to avoid spreading any potential disease and always remove any infected/damaged plant debris remaining in your garden once the season is over.\n");
                    intent.putExtra("iconTv", R.drawable.soft_rot);
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