package com.example.gabewright.decathlon;

import io.realm.RealmObject;

/**
 * Created by GabeWright on 5/2/15.
 */
public class RealmScore extends RealmObject {
    private String score;
    private String date;

    public RealmScore(){

    }
    public RealmScore(String score, String date){
        this.score = score;
        this.date = date;
    }

    public String getScore(){return score;}
    public void setScore(String score){this.score = score;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
}
