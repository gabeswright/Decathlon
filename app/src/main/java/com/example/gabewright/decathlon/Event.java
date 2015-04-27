package com.example.gabewright.decathlon;

import android.graphics.drawable.Drawable;

/**
 * Created by GabeWright on 4/21/15.
 */
public class Event {
    private String name;
    private Drawable pic;
    private int picint;
    private String tip1;
    private String tip2;
    private String tip3;
    private String tip4;
    private String tip5;

    public Event(String name, Drawable pic, int picint, String tip1, String tip2, String tip3, String tip4, String tip5){
        this.name = name;
        this.pic = pic;
        this.picint = picint;
        this.tip1 = tip1;
        this.tip2 = tip2;
        this.tip3 = tip3;
        this.tip4 = tip4;
        this.tip5 = tip5;

    }

    public String getName(){return name;}

    public Drawable getPic(){return pic;}

    public int getPicint(){return picint;}

    public String getTip1(){return tip1;}

    public String getTip2(){return tip2;}

    public String getTip3(){return tip3;}

    public String getTip4(){return tip4;}

    public String getTip5(){return tip5;}

}
