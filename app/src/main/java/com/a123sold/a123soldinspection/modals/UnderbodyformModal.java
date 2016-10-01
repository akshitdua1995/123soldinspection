package com.a123sold.a123soldinspection.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akshit on 29/7/16.
 */
public class UnderbodyformModal {
    @Expose(deserialize = false)
    String id;
    @SerializedName("Frame Damage")
    String FRAMEDAMAGE ;
    @SerializedName("Fuel Supply System")
    String FUELSUPPLYSYSTEM ;
    @SerializedName("Exhaust System Condition")
    String EXHAUSTSYSTEMCONDITION ;
    @SerializedName("Emissions Control Test")
    String EMISSIONSCONTROLTEST ;
    @SerializedName("Automatic Transmission/Transaxle")
    String AUTOMATICTRANSMISSION ;
    @SerializedName("Manual Transmission/Transaxle,Differential and Transfer Case")
    String MANUALTRANSMISSION;
    @SerializedName("4x4 Hub Operation")
    String HUBOPERATION ;
    @SerializedName("Universal Joints,CV Joints and CV Joint Boots")
    String UNIVERSALJOINTS ;
    @SerializedName("Transmission Mounts(not cracked,broken or oil-soaked)")
    String TRANSMISSIONMOUNTS ;
    @SerializedName("Differential/Drive Axle")
    String DIFFERNTIALDRIVEAXLE ;
    @SerializedName("Tires Match and Are Correct Size")
    String TIRESMATCH ;
    @SerializedName("Wheels Match and Are Correct Size")
    String WHEELSMATCH ;
    @SerializedName("Tire Thread Depth - Front Tires(L/R)")
    String TIREDEPTHFRONT ;
    @SerializedName("Tire Thread Depth - Rear Tires(L/R)")
    String TIREDEPTHREAR ;
    @SerializedName("Normal Tire Wear")
    String NORMALTIREWEAR ;
    @SerializedName("Tire Pressure - Front Tires(L/R)-(Scale 1-5)")
    String TIREPRESSUREFRONT ;
    @SerializedName("Tire Pressure - Rear Tires(L/R)-(Scale 1-5)")
    String TIREPRESSUREBACK ;
    @SerializedName("Tire Pressure Monitoring System")
    String TIREPRESSUREMONITOR ;
    @SerializedName("Wheels")
    String WHEELS ;
    @SerializedName("Wheel Covers and Center Caps")
    String WHEELCOVERANDCENTERCAPS;
    @SerializedName("Rack-and-Pinion, Linkage and Boots")
    String RACKPINION;
    @SerializedName("Control Arms, Bushings and Ball Joints")
    String CONTROLARMS ;
    @SerializedName("Tie Rods and Ider Arm")
    String TIERODS ;
    @SerializedName("Sway Bars,Links and Bushings")
    String SWAYBARS ;
    @SerializedName("Springs")
    String SPRINGS ;
    @SerializedName("Struts and Shocks")
    String STRUTSANDSHOCKS ;
    @SerializedName("Wheel Alignment(check if necessary)")
    String WHEELALIGNMENT ;
    @SerializedName("Power Steering Pump")
    String POWERSTEERINGPUMP ;
    @SerializedName("Capilers and Wheel Cylinders")
    String WHEELSCYLENDIRS ;
    @SerializedName("Brake Pads And Shoes - Front Brakes(L/R)")
    String BRAKEPADFRONT ;
    @SerializedName("Brake Pads And Shoes - Rear Brakes(L/R)")
    String BRAKEPADREAR ;
    @SerializedName("Rotors and Drums")
    String ROTORSANDDRUMS;
    @SerializedName("Brake Lines,Hoses and Fittings")
    String BRAKELINES ;
    @SerializedName("Parking Brake")
    String PARKINGBRAKE ;
    @SerializedName("Master Cylinder and Booster")
    String MASTERCYLENDIRBOOSTER ;
    @SerializedName("Repairing Cost")
    Float REPAIRINGCOSTUNDERBODY;
    @SerializedName("Comment")
    String COMMENTUNDERBODY;

    public UnderbodyformModal(){};

    public UnderbodyformModal(String id, String FRAMEDAMAGE, String FUELSUPPLYSYSTEM, String EXHAUSTSYSTEMCONDITION, String EMISSIONSCONTROLTEST, String AUTOMATICTRANSMISSION, String MANUALTRANSMISSION, String HUBOPERATION, String UNIVERSALJOINTS, String TRANSMISSIONMOUNTS, String DIFFERNTIALDRIVEAXLE, String TIRESMATCH, String WHEELSMATCH, String TIREDEPTHFRONT, String TIREDEPTHREAR, String NORMALTIREWEAR, String TIREPRESSUREFRONT, String TIREPRESSUREBACK, String TIREPRESSUREMONITOR, String WHEELS, String WHEELCOVERANDCENTERCAPS, String RACKPINION, String CONTROLARMS, String TIERODS, String SWAYBARS, String SPRINGS, String STRUTSANDSHOCKS, String WHEELALIGNMENT, String POWERSTEERINGPUMP, String WHEELSCYLENDIRS, String BRAKEPADFRONT, String BRAKEPADREAR, String ROTORSANDDRUMS, String BRAKELINES, String PARKINGBRAKE, String MASTERCYLENDIRBOOSTER, Float REPAIRINGCOSTUNDERBODY, String COMMENTUNDERBODY) {
        this.id = id;
        this.FRAMEDAMAGE = FRAMEDAMAGE;
        this.FUELSUPPLYSYSTEM = FUELSUPPLYSYSTEM;
        this.EXHAUSTSYSTEMCONDITION = EXHAUSTSYSTEMCONDITION;
        this.EMISSIONSCONTROLTEST = EMISSIONSCONTROLTEST;
        this.AUTOMATICTRANSMISSION = AUTOMATICTRANSMISSION;
        this.MANUALTRANSMISSION = MANUALTRANSMISSION;
        this.HUBOPERATION = HUBOPERATION;
        this.UNIVERSALJOINTS = UNIVERSALJOINTS;
        this.TRANSMISSIONMOUNTS = TRANSMISSIONMOUNTS;
        this.DIFFERNTIALDRIVEAXLE = DIFFERNTIALDRIVEAXLE;
        this.TIRESMATCH = TIRESMATCH;
        this.WHEELSMATCH = WHEELSMATCH;
        this.TIREDEPTHFRONT = TIREDEPTHFRONT;
        this.TIREDEPTHREAR = TIREDEPTHREAR;
        this.NORMALTIREWEAR = NORMALTIREWEAR;
        this.TIREPRESSUREFRONT = TIREPRESSUREFRONT;
        this.TIREPRESSUREBACK = TIREPRESSUREBACK;
        this.TIREPRESSUREMONITOR = TIREPRESSUREMONITOR;
        this.WHEELS = WHEELS;
        this.WHEELCOVERANDCENTERCAPS = WHEELCOVERANDCENTERCAPS;
        this.RACKPINION = RACKPINION;
        this.CONTROLARMS = CONTROLARMS;
        this.TIERODS = TIERODS;
        this.SWAYBARS = SWAYBARS;
        this.SPRINGS = SPRINGS;
        this.STRUTSANDSHOCKS = STRUTSANDSHOCKS;
        this.WHEELALIGNMENT = WHEELALIGNMENT;
        this.POWERSTEERINGPUMP = POWERSTEERINGPUMP;
        this.WHEELSCYLENDIRS = WHEELSCYLENDIRS;
        this.BRAKEPADFRONT = BRAKEPADFRONT;
        this.BRAKEPADREAR = BRAKEPADREAR;
        this.ROTORSANDDRUMS = ROTORSANDDRUMS;
        this.BRAKELINES = BRAKELINES;
        this.PARKINGBRAKE = PARKINGBRAKE;
        this.MASTERCYLENDIRBOOSTER = MASTERCYLENDIRBOOSTER;
        this.REPAIRINGCOSTUNDERBODY = REPAIRINGCOSTUNDERBODY;
        this.COMMENTUNDERBODY = COMMENTUNDERBODY;
    }

    public String getid() {
        return id;
    }

    public String getFRAMEDAMAGE() {
        return FRAMEDAMAGE;
    }

    public String getFUELSUPPLYSYSTEM() {
        return FUELSUPPLYSYSTEM;
    }

    public String getEXHAUSTSYSTEMCONDITION() {
        return EXHAUSTSYSTEMCONDITION;
    }

    public String getEMISSIONSCONTROLTEST() {
        return EMISSIONSCONTROLTEST;
    }

    public String getAUTOMATICTRANSMISSION() {
        return AUTOMATICTRANSMISSION;
    }

    public String getMANUALTRANSMISSION() {
        return MANUALTRANSMISSION;
    }

    public String getHUBOPERATION() {
        return HUBOPERATION;
    }

    public String getUNIVERSALJOINTS() {
        return UNIVERSALJOINTS;
    }

    public String getTRANSMISSIONMOUNTS() {
        return TRANSMISSIONMOUNTS;
    }

    public String getDIFFERNTIALDRIVEAXLE() {
        return DIFFERNTIALDRIVEAXLE;
    }

    public String getTIRESMATCH() {
        return TIRESMATCH;
    }

    public String getWHEELSMATCH() {
        return WHEELSMATCH;
    }

    public String getTIREDEPTHFRONT() {
        return TIREDEPTHFRONT;
    }

    public String getTIREDEPTHREAR() {
        return TIREDEPTHREAR;
    }

    public String getNORMALTIREWEAR() {
        return NORMALTIREWEAR;
    }

    public String getTIREPRESSUREFRONT() {
        return TIREPRESSUREFRONT;
    }

    public String getTIREPRESSUREBACK() {
        return TIREPRESSUREBACK;
    }

    public String getTIREPRESSUREMONITOR() {
        return TIREPRESSUREMONITOR;
    }

    public String getWHEELS() {
        return WHEELS;
    }

    public String getWHEELCOVERANDCENTERCAPS() {
        return WHEELCOVERANDCENTERCAPS;
    }

    public String getRACKPINION() {
        return RACKPINION;
    }

    public String getCONTROLARMS() {
        return CONTROLARMS;
    }

    public String getTIERODS() {
        return TIERODS;
    }

    public String getSWAYBARS() {
        return SWAYBARS;
    }

    public String getSPRINGS() {
        return SPRINGS;
    }

    public String getSTRUTSANDSHOCKS() {
        return STRUTSANDSHOCKS;
    }

    public String getWHEELALIGNMENT() {
        return WHEELALIGNMENT;
    }

    public String getPOWERSTEERINGPUMP() {
        return POWERSTEERINGPUMP;
    }

    public String getWHEELSCYLENDIRS() {
        return WHEELSCYLENDIRS;
    }

    public String getBRAKEPADFRONT() {
        return BRAKEPADFRONT;
    }

    public String getBRAKEPADREAR() {
        return BRAKEPADREAR;
    }

    public String getROTORSANDDRUMS() {
        return ROTORSANDDRUMS;
    }

    public String getBRAKELINES() {
        return BRAKELINES;
    }

    public String getPARKINGBRAKE() {
        return PARKINGBRAKE;
    }

    public String getMASTERCYLENDIRBOOSTER() {
        return MASTERCYLENDIRBOOSTER;
    }

    public Float getREPAIRINGCOSTUNDERBODY() {
        return REPAIRINGCOSTUNDERBODY;
    }

    public String getCOMMENTUNDERBODY() {
        return COMMENTUNDERBODY;
    }
}
