package com.a123sold.a123soldinspection.modals;

/**
 * Created by akshit on 29/7/16.
 */
public class RoadtestModal {
    String id;
    Integer ENGINESTARTPROPERLY ;
    Integer ENGINEIDLESPROPERLY ;
    Integer REMOTESTARTSYSTEM ;
    Integer ENGINEACCELERATES ;
    Integer ENGINENOISE ;
    Integer TRANSAXLEOPERATION ;
    Integer TRANSAXLENOISENORMAL ;
    Integer SHIFTINTERLOCK ;
    Integer DRIVEAXLE ;
    Integer CLUTCHOPERATE ;
    Integer STEERSNORMALLY ;
    Integer BODYSQUEAKS ;
    Integer SHOCKESOPERATES ;
    Integer BRAKESOPERATES ;
    Integer CRUISECONTROL ;
    Integer GAUGESOPERATEPROPERLY ;
    Integer MEMORYPROFILESYSTEM ;
    Integer NOWINDNOISE ;
    Float REPAIRINGCOSTROADTEST ;
    String COMMENTROADTEST ;

    public RoadtestModal(){}
    public RoadtestModal(String id, Integer ENGINESTARTPROPERLY, Integer ENGINEIDLESPROPERLY, Integer REMOTESTARTSYSTEM, Integer ENGINEACCELERATES, Integer ENGINENOISE, Integer TRANSAXLEOPERATION, Integer TRANSAXLENOISENORMAL, Integer SHIFTINTERLOCK, Integer DRIVEAXLE, Integer CLUTCHOPERATE, Integer STEERSNORMALLY, Integer BODYSQUEAKS, Integer SHOCKESOPERATES, Integer BRAKESOPERATES, Integer CRUISECONTROL, Integer GAUGESOPERATEPROPERLY, Integer MEMORYPROFILESYSTEM, Integer NOWINDNOISE, Float REPAIRINGCOSTROADTEST, String COMMENTROADTEST) {
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

    public Integer getENGINESTARTPROPERLY() {
        return ENGINESTARTPROPERLY;
    }

    public Integer getENGINEIDLESPROPERLY() {
        return ENGINEIDLESPROPERLY;
    }

    public Integer getREMOTESTARTSYSTEM() {
        return REMOTESTARTSYSTEM;
    }

    public Integer getENGINEACCELERATES() {
        return ENGINEACCELERATES;
    }

    public Integer getENGINENOISE() {
        return ENGINENOISE;
    }

    public Integer getTRANSAXLEOPERATION() {
        return TRANSAXLEOPERATION;
    }

    public Integer getTRANSAXLENOISENORMAL() {
        return TRANSAXLENOISENORMAL;
    }

    public Integer getSHIFTINTERLOCK() {
        return SHIFTINTERLOCK;
    }

    public Integer getDRIVEAXLE() {
        return DRIVEAXLE;
    }

    public Integer getCLUTCHOPERATE() {
        return CLUTCHOPERATE;
    }

    public Integer getSTEERSNORMALLY() {
        return STEERSNORMALLY;
    }

    public Integer getBODYSQUEAKS() {
        return BODYSQUEAKS;
    }

    public Integer getSHOCKESOPERATES() {
        return SHOCKESOPERATES;
    }

    public Integer getBRAKESOPERATES() {
        return BRAKESOPERATES;
    }

    public Integer getCRUISECONTROL() {
        return CRUISECONTROL;
    }

    public Integer getGAUGESOPERATEPROPERLY() {
        return GAUGESOPERATEPROPERLY;
    }

    public Integer getMEMORYPROFILESYSTEM() {
        return MEMORYPROFILESYSTEM;
    }

    public Integer getNOWINDNOISE() {
        return NOWINDNOISE;
    }

    public Float getREPAIRINGCOSTROADTEST() {
        return REPAIRINGCOSTROADTEST;
    }

    public String getCOMMENTROADTEST() {
        return COMMENTROADTEST;
    }
}
