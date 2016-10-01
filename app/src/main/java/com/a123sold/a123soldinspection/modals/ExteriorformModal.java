package com.a123sold.a123soldinspection.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akshit on 29/7/16.
 */
public class ExteriorformModal {
    @Expose(deserialize = false)
    String id;
    @SerializedName("Grill Inspection (Damage)")
    String GRILLINSPECTION;
    @SerializedName("Trim Inspection (Damage)")
    String TRIMINSPECTION;
    @SerializedName("Roof Rack Inspection (Damage)")
    String ROOFRACKINSPECTION;
    @SerializedName("Deployable Running Boards (For SUV)")
    String DEPLOYABLERUNNINGBOARDS;
    @SerializedName("Windshield Glass Inspection (Crack)")
    String WINDSHIELDGLASSINSPECTION;
    @SerializedName("Side Glass Inspection (Damage)")
    String SIDEGLASSINSPECTION;
    @SerializedName("Rear Window/Tailgate Glass Inspection (Damage)")
    String REARWINDOWGLASSINSPECTION;
    @SerializedName("Wiper Blade (Damage)")
    String WIPERBLADE;
    @SerializedName("Outside Mirror Inspection (Damage)")
    String OUTSIDEMIRRORINSPECTION;
    @SerializedName("Outside Folding Mirror Inspection")
    String OUTSIDEFOLDINGMIRRORINSPECTION;
    @SerializedName("Front-End Exterior Lights (Damage)")
    String FRONTEXTLIGHTS;
    @SerializedName("Back-End Exterior Lights (Damage)")
    String BACKEXTLIGHTS;
    @SerializedName("Side Exterior Lights (Damage)")
    String SIDEEXTLIGHTS;
    @SerializedName("Hazards Light (Damage)")
    String HAZARDLIGHTS;
    @SerializedName("Trailer Lamp Connector Operation (Damage)")
    String TRAILERLAMPCONNECTOR;
    @SerializedName("Auto On/Off Lighting")
    String ONOFFLIGHTING;
    @SerializedName("Evidence of Flood Damage")
    String FLOODDAMAGE;
    @SerializedName("Evidence of Fire Damage")
    String FIREDAMAGE;
    @SerializedName("Evidence of Major Damage")
    String MAJORDAMAGE;
    @SerializedName("Evidence of Hail Damage")
    String HAILDAMAGE;
    @SerializedName("Body Panel Inspection")
    String BODYPANEL;
    @SerializedName("Bumper/Fascia Inspection")
    String BUMPER;
    @SerializedName("Door Inspection/Alignment")
    String DOORS;
    @SerializedName("Hood Inspection/Alignment")
    String HOOD;
    @SerializedName("Deck lid Inspection/Alignment(Available)")
    String DECKLID;
    @SerializedName("Tailgate Inspection/Alignment")
    String TAILGATE;
    @SerializedName("Roof Inspection")
    String ROOF;
    @SerializedName("Hood Release Mechanisms Operate Properly")
    String HOODRELEASE;
    @SerializedName("Hood Hinges, Prop Rod/Gas Struts Operate Properly")
    String HOODHINGES;
    @SerializedName("Door Hinges Operate Properly")
    String DOORHINGES;
    @SerializedName("Trunk/Tailgate Hinges/Gas Struts Operate Properly")
    String TRUNKSTRUTS;
    @SerializedName("Power Liftgate Operation")
    String POWERLIFTGATE;
    @SerializedName("Paint Gauge tool (RE-PAINT)")
    String PAINTGAUGE;
    @SerializedName("Repairing Cost")
    Float REPAIRINGCOSTEXTERIOR;
    @SerializedName("Comment")
    String COMMENTEXTERIOR;
    public ExteriorformModal(){}
    public ExteriorformModal(String id, String GRILLINSPECTION, String TRIMINSPECTION, String ROOFRACKINSPECTION, String DEPLOYABLERUNNINGBOARDS, String WINDSHIELDGLASSINSPECTION, String SIDEGLASSINSPECTION, String REARWINDOWGLASSINSPECTION, String WIPERBLADE, String OUTSIDEMIRRORINSPECTION, String OUTSIDEFOLDINGMIRRORINSPECTION, String FRONTEXTLIGHTS, String BACKEXTLIGHTS, String SIDEEXTLIGHTS, String HAZARDLIGHTS, String TRAILERLAMPCONNECTOR, String ONOFFLIGHTING, String FLOODDAMAGE, String FIREDAMAGE, String MAJORDAMAGE, String HAILDAMAGE, String BODYPANEL, String BUMPER, String DOORS, String HOOD, String DECKLID, String TAILGATE, String ROOF, String HOODRELEASE, String HOODHINGES, String DOORHINGES, String TRUNKSTRUTS, String POWERLIFTGATE, String PAINTGAUGE, Float REPAIRINGCOSTEXTERIOR, String COMMENTEXTERIOR) {
        this.id = id;
        this.GRILLINSPECTION = GRILLINSPECTION;
        this.TRIMINSPECTION = TRIMINSPECTION;
        this.ROOFRACKINSPECTION = ROOFRACKINSPECTION;
        this.DEPLOYABLERUNNINGBOARDS = DEPLOYABLERUNNINGBOARDS;
        this.WINDSHIELDGLASSINSPECTION = WINDSHIELDGLASSINSPECTION;
        this.SIDEGLASSINSPECTION = SIDEGLASSINSPECTION;
        this.REARWINDOWGLASSINSPECTION = REARWINDOWGLASSINSPECTION;
        this.WIPERBLADE = WIPERBLADE;
        this.OUTSIDEMIRRORINSPECTION = OUTSIDEMIRRORINSPECTION;
        this.OUTSIDEFOLDINGMIRRORINSPECTION = OUTSIDEFOLDINGMIRRORINSPECTION;
        this.FRONTEXTLIGHTS = FRONTEXTLIGHTS;
        this.BACKEXTLIGHTS = BACKEXTLIGHTS;
        this.SIDEEXTLIGHTS = SIDEEXTLIGHTS;
        this.HAZARDLIGHTS = HAZARDLIGHTS;
        this.TRAILERLAMPCONNECTOR = TRAILERLAMPCONNECTOR;
        this.ONOFFLIGHTING = ONOFFLIGHTING;
        this.FLOODDAMAGE = FLOODDAMAGE;
        this.FIREDAMAGE = FIREDAMAGE;
        this.MAJORDAMAGE = MAJORDAMAGE;
        this.HAILDAMAGE = HAILDAMAGE;
        this.BODYPANEL = BODYPANEL;
        this.BUMPER = BUMPER;
        this.DOORS = DOORS;
        this.HOOD = HOOD;
        this.DECKLID = DECKLID;
        this.TAILGATE = TAILGATE;
        this.ROOF = ROOF;
        this.HOODRELEASE = HOODRELEASE;
        this.HOODHINGES = HOODHINGES;
        this.DOORHINGES = DOORHINGES;
        this.TRUNKSTRUTS = TRUNKSTRUTS;
        this.POWERLIFTGATE = POWERLIFTGATE;
        this.PAINTGAUGE = PAINTGAUGE;
        this.REPAIRINGCOSTEXTERIOR = REPAIRINGCOSTEXTERIOR;
        this.COMMENTEXTERIOR = COMMENTEXTERIOR;
    }

    public String getid() {
        return id;
    }

    public String getGRILLINSPECTION() {
        return GRILLINSPECTION;
    }

    public String getTRIMINSPECTION() {
        return TRIMINSPECTION;
    }

    public String getROOFRACKINSPECTION() {
        return ROOFRACKINSPECTION;
    }

    public String getDEPLOYABLERUNNINGBOARDS() {
        return DEPLOYABLERUNNINGBOARDS;
    }

    public String getWINDSHIELDGLASSINSPECTION() {
        return WINDSHIELDGLASSINSPECTION;
    }

    public String getSIDEGLASSINSPECTION() {
        return SIDEGLASSINSPECTION;
    }

    public String getREARWINDOWGLASSINSPECTION() {
        return REARWINDOWGLASSINSPECTION;
    }

    public String getWIPERBLADE() {
        return WIPERBLADE;
    }

    public String getOUTSIDEMIRRORINSPECTION() {
        return OUTSIDEMIRRORINSPECTION;
    }

    public String getOUTSIDEFOLDINGMIRRORINSPECTION() {
        return OUTSIDEFOLDINGMIRRORINSPECTION;
    }

    public String getFRONTEXTLIGHTS() {
        return FRONTEXTLIGHTS;
    }

    public String getBACKEXTLIGHTS() {
        return BACKEXTLIGHTS;
    }

    public String getSIDEEXTLIGHTS() {
        return SIDEEXTLIGHTS;
    }

    public String getHAZARDLIGHTS() {
        return HAZARDLIGHTS;
    }

    public String getTRAILERLAMPCONNECTOR() {
        return TRAILERLAMPCONNECTOR;
    }

    public String getONOFFLIGHTING() {
        return ONOFFLIGHTING;
    }

    public String getFLOODDAMAGE() {
        return FLOODDAMAGE;
    }

    public String getFIREDAMAGE() {
        return FIREDAMAGE;
    }

    public String getMAJORDAMAGE() {
        return MAJORDAMAGE;
    }

    public String getHAILDAMAGE() {
        return HAILDAMAGE;
    }

    public String getBODYPANEL() {
        return BODYPANEL;
    }

    public String getBUMPER() {
        return BUMPER;
    }

    public String getDOORS() {
        return DOORS;
    }

    public String getHOOD() {
        return HOOD;
    }

    public String getDECKLID() {
        return DECKLID;
    }

    public String getTAILGATE() {
        return TAILGATE;
    }

    public String getROOF() {
        return ROOF;
    }

    public String getHOODRELEASE() {
        return HOODRELEASE;
    }

    public String getHOODHINGES() {
        return HOODHINGES;
    }

    public String getDOORHINGES() {
        return DOORHINGES;
    }

    public String getTRUNKSTRUTS() {
        return TRUNKSTRUTS;
    }

    public String getPOWERLIFTGATE() {
        return POWERLIFTGATE;
    }

    public String getPAINTGAUGE() {
        return PAINTGAUGE;
    }

    public Float getREPAIRINGCOSTEXTERIOR() {
        return REPAIRINGCOSTEXTERIOR;
    }

    public String getCOMMENTEXTERIOR() {
        return COMMENTEXTERIOR;
    }
}
