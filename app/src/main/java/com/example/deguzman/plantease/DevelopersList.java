package com.example.deguzman.plantease;

/**
 * Created by EKENE on 7/23/2017.
 */

public class DevelopersList {

    private String condition;
    private boolean status;
    private String id;
    private String plant_no;
    private String disease;
    private String diagnosis;
    private String model_pic;

    public String getCondition() { return condition; }
    public boolean getStatus() { return status; }
    public String getId() {
        return id;
    }
    public String getPlant_no() { return plant_no; }
    public String getDisease() {
        return disease;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public String getModel_pic() {
        return model_pic;
    }


/*
    public String getHtml_url() {
        return html_url;
    }
*/

    public DevelopersList(String condition, boolean status, String id, String plant_no, String disease, String diagnosis, String model_pic) {
        this.condition = condition;
        this.status = status;
        this.id = id;
        this.plant_no = plant_no;
        this.disease = disease;
        this.diagnosis = diagnosis;
        this.model_pic = model_pic;

       /* this.html_url = gitUrl;*/


    }
}
