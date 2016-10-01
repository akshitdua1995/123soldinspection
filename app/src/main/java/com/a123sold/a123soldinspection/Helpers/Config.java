package com.a123sold.a123soldinspection.Helpers;

/**
 * Created by akshit on 31/7/16.
 */
public final class Config {
    public static final String BASE_URL = "http://sylvestertech.com:3000";
    public static final String localUserDB="localUserDatabase";
    public static final int progress_per_category = 12;
    public static final String configimg="ConfigImage";
    public static final String exteriorimg="ExteriorImage";
    public static final String historyimg="HistoryImage";
    public static final String underhoodimg="UnderhoodImage";
    public static final String interiorimg="InteriorImage";

    public static String getAnswer(int value){
        if(value==1)
            return "yes";
        else if(value==0)
            return  "no";
        else
            return "empty";
    }
}