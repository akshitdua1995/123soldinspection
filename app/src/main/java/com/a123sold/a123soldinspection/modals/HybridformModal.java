package com.a123sold.a123soldinspection.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akshit on 29/7/16.
 */
public class HybridformModal {
    @Expose(deserialize = false)
    String id;
    @SerializedName("Hybrid Cooling System")
    String HYBRIDCOOLINGSYSTEM;
    @SerializedName("Switchable Power Train Mount")
    String SWITCHABLEPOWERTRAINMOUNT;
    @SerializedName("Hybrid Entertainment and Information Delay")
    String HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY;
    @SerializedName("110 V Power Outlet")
    String POWEROUTLET;
    @SerializedName("Repairing Cost")
    Float REPAIRINGCOSTHYBRID;
    @SerializedName("Comment")
    String COMMENTHYBRID;




    public HybridformModal(String id, String HYBRIDCOOLINGSYSTEM, String SWITCHABLEPOWERTRAINMOUNT, String HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY, String POWEROUTLET, Float REPAIRINGCOSTHYBRID, String COMMENTHYBRID) {
        this.id = id;
        this.HYBRIDCOOLINGSYSTEM = HYBRIDCOOLINGSYSTEM;
        this.SWITCHABLEPOWERTRAINMOUNT = SWITCHABLEPOWERTRAINMOUNT;
        this.HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY = HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY;
        this.POWEROUTLET = POWEROUTLET;
        this.REPAIRINGCOSTHYBRID = REPAIRINGCOSTHYBRID;
        this.COMMENTHYBRID = COMMENTHYBRID;
    }
    public HybridformModal(){}


    public String getHYBRIDCOOLINGSYSTEM() {
        return HYBRIDCOOLINGSYSTEM;
    }

    public String getSWITCHABLEPOWERTRAINMOUNT() {
        return SWITCHABLEPOWERTRAINMOUNT;
    }

    public String getHYBRIDENTERTAINMENTANDINFORMATIONDISPLAY() {
        return HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY;
    }

    public String getPOWEROUTLET() {
        return POWEROUTLET;
    }

    public Float getREPAIRINGCOSTHYBRID() {
        return REPAIRINGCOSTHYBRID;
    }

    public String getCOMMENTHYBRID() {
        return COMMENTHYBRID;
    }


}
