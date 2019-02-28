package com.example.deguzman.plantease;

/**
 * Created by EKENE on 7/23/2017.
 */

public class AddPlantList {

    private String id;
    private String plant_name;
    private String specific_plant;
    private String plant_width;
    private String plot_size;
    private String plant_distance;

    public String getId() { return id; }
    public String getPlant_name() { return plant_name; }
    public String getSpecific_plant() { return specific_plant; }
    public String getPlant_width() { return plant_width; }
    public String getPlot_size() { return plot_size; }
    public String getPlant_distance() { return plant_distance; }


    public AddPlantList(String id, String plant_name, String specific_plant, String plant_width, String plot_size, String plant_distance) {
        this.id = id;
        this.plant_name = plant_name;
        this.specific_plant = specific_plant;
        this.plant_width = plant_width;
        this.plot_size = plot_size;
        this.plant_distance = plant_distance;


    }
}

