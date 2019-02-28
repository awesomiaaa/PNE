package com.example.deguzman.plantease;

/**
 * Created by EKENE on 7/23/2017.
 */

public class HistoryList {

    private String date;
    private String plant_no;
    private String condition;
    private String disease;
    private String diagnosis;
    private String model_pic;

    public String getDate() {
        return date;
    }
    public String getPlant_no() { return plant_no; }
    public String getCondition() {
        return condition;
    }
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

    public HistoryList(String date, String plant_no, String condition, String disease, String diagnosis, String model_pic) {
        this.date = date;
        this.plant_no = plant_no;
        this.condition = condition;
        this.disease = disease;
        this.diagnosis = diagnosis;
        this.model_pic = model_pic;
        /* this.html_url = gitUrl;*/


    }
}
