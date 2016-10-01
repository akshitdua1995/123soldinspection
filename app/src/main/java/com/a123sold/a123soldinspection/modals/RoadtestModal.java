package com.a123sold.a123soldinspection.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akshit on 29/7/16.
 */
public class RoadtestModal {
    @Expose(deserialize = false)
    String id;
    @SerializedName("Engines Starts Properly")
    String ENGINESTARTPROPERLY ;
    @SerializedName("Engine Idles Properly")
    String ENGINEIDLESPROPERLY ;
    @SerializedName("Remote Start System Operation")
    String REMOTESTARTSYSTEM ;
    @SerializedName("Engine Accelerates and Cruises Properly/Smoothly")
    String ENGINEACCELERATES ;
    @SerializedName("Engine Noise Normal(Cold/Hot and High/Low Speeds)")
    String ENGINENOISE ;
    @SerializedName("Auto/Manual Transmission/Transaxle Operation Cold and Hot Shift Quality")
    String TRANSAXLEOPERATION ;
    @SerializedName("Auto/Manual Transmission/Transaxle Operation Noise Normal - Hot and Cold")
    String TRANSAXLENOISENORMAL ;
    @SerializedName("Shift Interlock Operates Properly (for automatic)")
    String SHIFTINTERLOCK ;
    @SerializedName("Drive Axle/Transfer Case Operation Noise Normal")
    String DRIVEAXLE ;
    @SerializedName("Clutch Operates Properly")
    String CLUTCHOPERATE ;
    @SerializedName("Steers Normally(Response,Centering and Free Play)")
    String STEERSNORMALLY ;
    @SerializedName("Body and Suspension Squeaks and Rattles")
    String BODYSQUEAKS ;
    @SerializedName("Struts/Shocks Operate Properly")
    String SHOCKESOPERATES ;
    @SerializedName("Brakes/ABS Operate Properly")
    String BRAKESOPERATES ;
    @SerializedName("Cruise Control")
    String CRUISECONTROL ;
    @SerializedName("Gauge Operate Properly")
    String GAUGESOPERATEPROPERLY ;
    @SerializedName("Driver Select/Memory Profile Systems")
    String MEMORYPROFILESYSTEM ;
    @SerializedName("No Abnormal Wind Noise")
    String NOWINDNOISE ;
    @SerializedName("Repairing Cost")
    Float REPAIRINGCOSTROADTEST ;
    @SerializedName("Comment")
    String COMMENTROADTEST ;

    public RoadtestModal(){}
    public RoadtestModal(String id, String ENGINESTARTPROPERLY, String ENGINEIDLESPROPERLY, String REMOTESTARTSYSTEM, String ENGINEACCELERATES, String ENGINENOISE, String TRANSAXLEOPERATION, String TRANSAXLENOISENORMAL, String SHIFTINTERLOCK, String DRIVEAXLE, String CLUTCHOPERATE, String STEERSNORMALLY, String BODYSQUEAKS, String SHOCKESOPERATES, String BRAKESOPERATES, String CRUISECONTROL, String GAUGESOPERATEPROPERLY, String MEMORYPROFILESYSTEM, String NOWINDNOISE, Float REPAIRINGCOSTROADTEST, String COMMENTROADTEST) {
        this.id = id;
        this.ENGINESTARTPROPERLY = ENGINESTARTPROPERLY;
        this.ENGINEIDLESPROPERLY = ENGINEIDLESPROPERLY;
        this.REMOTESTARTSYSTEM = REMOTESTARTSYSTEM;
        this.ENGINEACCELERATES = ENGINEACCELERATES;
        this.ENGINENOISE = ENGINENOISE;
        this.TRANSAXLEOPERATION = TRANSAXLEOPERATION;
        this.TRANSAXLENOISENORMAL = TRANSAXLENOISENORMAL;
        this.SHIFTINTERLOCK = SHIFTINTERLOCK;
        this.DRIVEAXLE = DRIVEAXLE;
        this.CLUTCHOPERATE = CLUTCHOPERATE;
        this.STEERSNORMALLY = STEERSNORMALLY;
        this.BODYSQUEAKS = BODYSQUEAKS;
        this.SHOCKESOPERATES = SHOCKESOPERATES;
        this.BRAKESOPERATES = BRAKESOPERATES;
        this.CRUISECONTROL = CRUISECONTROL;
        this.GAUGESOPERATEPROPERLY = GAUGESOPERATEPROPERLY;
        this.MEMORYPROFILESYSTEM = MEMORYPROFILESYSTEM;
        this.NOWINDNOISE = NOWINDNOISE;
        this.REPAIRINGCOSTROADTEST = REPAIRINGCOSTROADTEST;
        this.COMMENTROADTEST = COMMENTROADTEST;
    }

    public String getid() {
        return id;
    }

    public String getENGINESTARTPROPERLY() {
        return ENGINESTARTPROPERLY;
    }

    public String getENGINEIDLESPROPERLY() {
        return ENGINEIDLESPROPERLY;
    }

    public String getREMOTESTARTSYSTEM() {
        return REMOTESTARTSYSTEM;
    }

    public String getENGINEACCELERATES() {
        return ENGINEACCELERATES;
    }

    public String getENGINENOISE() {
        return ENGINENOISE;
    }

    public String getTRANSAXLEOPERATION() {
        return TRANSAXLEOPERATION;
    }

    public String getTRANSAXLENOISENORMAL() {
        return TRANSAXLENOISENORMAL;
    }

    public String getSHIFTINTERLOCK() {
        return SHIFTINTERLOCK;
    }

    public String getDRIVEAXLE() {
        return DRIVEAXLE;
    }

    public String getCLUTCHOPERATE() {
        return CLUTCHOPERATE;
    }

    public String getSTEERSNORMALLY() {
        return STEERSNORMALLY;
    }

    public String getBODYSQUEAKS() {
        return BODYSQUEAKS;
    }

    public String getSHOCKESOPERATES() {
        return SHOCKESOPERATES;
    }

    public String getBRAKESOPERATES() {
        return BRAKESOPERATES;
    }

    public String getCRUISECONTROL() {
        return CRUISECONTROL;
    }

    public String getGAUGESOPERATEPROPERLY() {
        return GAUGESOPERATEPROPERLY;
    }

    public String getMEMORYPROFILESYSTEM() {
        return MEMORYPROFILESYSTEM;
    }

    public String getNOWINDNOISE() {
        return NOWINDNOISE;
    }

    public Float getREPAIRINGCOSTROADTEST() {
        return REPAIRINGCOSTROADTEST;
    }

    public String getCOMMENTROADTEST() {
        return COMMENTROADTEST;
    }
}
