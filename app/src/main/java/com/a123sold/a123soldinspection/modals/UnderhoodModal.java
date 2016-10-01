package com.a123sold.a123soldinspection.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akshit on 29/7/16.
 */
public class UnderhoodModal {
    @Expose(deserialize = false)
    String id;
    @SerializedName("Engine Oil/Filter Change")
    String ENGINEOIL ;
    @SerializedName("Chassis Tube")
    String CHASISTUBE ;
    @SerializedName("Coolant")
    String COOLANT ;
    @SerializedName("Brake Fluid")
    String BRAKEFLUID ;
    @SerializedName("EAutomatic Trans axle/Transmission Fluid")
    String TRANSAXLEFLUID ;
    @SerializedName("Transfer Case Fluid")
    String TRANSFERCASEFUID ;
    @SerializedName("Drive Axle Fluid")
    String DRIVEAXLEFLUID ;
    @SerializedName("Power Sheering Fluid")
    String POWERSTEERINGFLUID ;
    @SerializedName("Manual Trans axle/Transmission Hydraulic Clutch Fluid")
    String MANUALTRANSFLUID ;
    @SerializedName("Washer Fluid")
    String WASHERFLUID ;
    @SerializedName("Air Conditioning System Charge")
    String AIRCONDITIONINGSYSTEMCHARGE ;
    @SerializedName("Fluid Leaks")
    String FLUIDLEAKS ;
    @SerializedName("Hoses,Lines and Fittings")
    String HOSESLINESFITTINGS ;
    @SerializedName("Belts")
    String BELTS ;
    @SerializedName("Wiring")
    String WIRING ;
    @SerializedName("Oil in Air Cleanser Housing")
    String OILINAIRCLEANSER ;
    @SerializedName("Water Sludge or Engine Coolant in Oil")
    String WATERSLUDGEOIL ;
    @SerializedName("Oil Pressure")
    String OILPRESSURE ;
    @SerializedName("Relative Cylinder Compression Test/Power Balance Readings(check if necessary)")
    String RELATIVECYLENDIRCOMPRESSION ;
    @SerializedName("Timing Belt")
    String TIMINGBELT ;
    @SerializedName("Engine Mounts")
    String ENGINEMOUNTS ;
    @SerializedName("Inspect Turbo charger Air Cooler")
    String TURBOCHARGERAIRCOOLER ;
    @SerializedName("Radiator")
    String RADIATOR ;
    @SerializedName("Pressure-Test Radiator Cap")
    String RADIATORCAP ;
    @SerializedName("Cooling Fans , Clutches and Motors")
    String COOLINGFANS ;
    @SerializedName("Water Pump")
    String WATERPUMP ;
    @SerializedName("Coolant Recovery Tank")
    String COOLANTRECOVERYTANK;
    @SerializedName("Cabin Air Filter")
    String CABINAIRFILTER ;
    @SerializedName("Fuel Pump Noise Normal")
    String FUELPUMPNOISENORMAL ;
    @SerializedName("Fuel Pump Pressure")
    String FUELPUMPPRESSURE ;
    @SerializedName("Fuel Filter")
    String FUELFILTER ;
    @SerializedName("Engine Air Filter")
    String ENGINEAIRFILTER ;
    @SerializedName("Starter Operation")
    String STARTEROPERATION ;
    @SerializedName("Ignition System")
    String IGNITIONSYSTEM ;
    @SerializedName("Battery")
    String BATTERY ;
    @SerializedName("Alternator Output")
    String ALTERNATOROUTPUT ;
    @SerializedName("Diesel Glow Plug System")
    String DIESELGLOWPLUGSYSTEM ;
    @SerializedName("Repairing Cost")
    Float REPAIRINGCOSTUNDERHOOD ;
    @SerializedName("Comment")
    String COMMENTUNDERHOOD ;


    public UnderhoodModal(){}
    public UnderhoodModal(String id, String ENGINEOIL, String CHASISTUBE, String COOLANT, String BRAKEFLUID, String TRANSAXLEFLUID, String TRANSFERCASEFUID, String DRIVEAXLEFLUID, String POWERSTEERINGFLUID, String MANUALTRANSFLUID, String WASHERFLUID, String AIRCONDITIONINGSYSTEMCHARGE, String FLUIDLEAKS, String HOSESLINESFITTINGS, String BELTS, String WIRING, String OILINAIRCLEANSER, String WATERSLUDGEOIL, String OILPRESSURE, String RELATIVECYLENDIRCOMPRESSION, String TIMINGBELT, String ENGINEMOUNTS, String TURBOCHARGERAIRCOOLER, String RADIATOR, String RADIATORCAP, String COOLINGFANS, String WATERPUMP, String COOLANTRECOVERYTANK, String CABINAIRFILTER, String FUELPUMPNOISENORMAL, String FUELPUMPPRESSURE, String FUELFILTER, String ENGINEAIRFILTER, String STARTEROPERATION, String IGNITIONSYSTEM, String BATTERY, String ALTERNATOROUTPUT, String DIESELGLOWPLUGSYSTEM, Float REPAIRINGCOSTUNDERHOOD, String COMMENTUNDERHOOD) {
        this.id = id;
        this.ENGINEOIL = ENGINEOIL;
        this.CHASISTUBE = CHASISTUBE;
        this.COOLANT = COOLANT;
        this.BRAKEFLUID = BRAKEFLUID;
        this.TRANSAXLEFLUID = TRANSAXLEFLUID;
        this.TRANSFERCASEFUID = TRANSFERCASEFUID;
        this.DRIVEAXLEFLUID = DRIVEAXLEFLUID;
        this.POWERSTEERINGFLUID = POWERSTEERINGFLUID;
        this.MANUALTRANSFLUID = MANUALTRANSFLUID;
        this.WASHERFLUID = WASHERFLUID;
        this.AIRCONDITIONINGSYSTEMCHARGE = AIRCONDITIONINGSYSTEMCHARGE;
        this.FLUIDLEAKS = FLUIDLEAKS;
        this.HOSESLINESFITTINGS = HOSESLINESFITTINGS;
        this.BELTS = BELTS;
        this.WIRING = WIRING;
        this.OILINAIRCLEANSER = OILINAIRCLEANSER;
        this.WATERSLUDGEOIL = WATERSLUDGEOIL;
        this.OILPRESSURE = OILPRESSURE;
        this.RELATIVECYLENDIRCOMPRESSION = RELATIVECYLENDIRCOMPRESSION;
        this.TIMINGBELT = TIMINGBELT;
        this.ENGINEMOUNTS = ENGINEMOUNTS;
        this.TURBOCHARGERAIRCOOLER = TURBOCHARGERAIRCOOLER;
        this.RADIATOR = RADIATOR;
        this.RADIATORCAP = RADIATORCAP;
        this.COOLINGFANS = COOLINGFANS;
        this.WATERPUMP = WATERPUMP;
        this.COOLANTRECOVERYTANK = COOLANTRECOVERYTANK;
        this.CABINAIRFILTER = CABINAIRFILTER;
        this.FUELPUMPNOISENORMAL = FUELPUMPNOISENORMAL;
        this.FUELPUMPPRESSURE = FUELPUMPPRESSURE;
        this.FUELFILTER = FUELFILTER;
        this.ENGINEAIRFILTER = ENGINEAIRFILTER;
        this.STARTEROPERATION = STARTEROPERATION;
        this.IGNITIONSYSTEM = IGNITIONSYSTEM;
        this.BATTERY = BATTERY;
        this.ALTERNATOROUTPUT = ALTERNATOROUTPUT;
        this.DIESELGLOWPLUGSYSTEM = DIESELGLOWPLUGSYSTEM;
        this.REPAIRINGCOSTUNDERHOOD = REPAIRINGCOSTUNDERHOOD;
        this.COMMENTUNDERHOOD = COMMENTUNDERHOOD;
    }

    public String getid() {
        return id;
    }

    public String getENGINEOIL() {
        return ENGINEOIL;
    }

    public String getCHASISTUBE() {
        return CHASISTUBE;
    }

    public String getCOOLANT() {
        return COOLANT;
    }

    public String getBRAKEFLUID() {
        return BRAKEFLUID;
    }

    public String getTRANSAXLEFLUID() {
        return TRANSAXLEFLUID;
    }

    public String getTRANSFERCASEFUID() {
        return TRANSFERCASEFUID;
    }

    public String getDRIVEAXLEFLUID() {
        return DRIVEAXLEFLUID;
    }

    public String getPOWERSTEERINGFLUID() {
        return POWERSTEERINGFLUID;
    }

    public String getMANUALTRANSFLUID() {
        return MANUALTRANSFLUID;
    }

    public String getWASHERFLUID() {
        return WASHERFLUID;
    }

    public String getAIRCONDITIONINGSYSTEMCHARGE() {
        return AIRCONDITIONINGSYSTEMCHARGE;
    }

    public String getFLUIDLEAKS() {
        return FLUIDLEAKS;
    }

    public String getHOSESLINESFITTINGS() {
        return HOSESLINESFITTINGS;
    }

    public String getBELTS() {
        return BELTS;
    }

    public String getWIRING() {
        return WIRING;
    }

    public String getOILINAIRCLEANSER() {
        return OILINAIRCLEANSER;
    }

    public String getWATERSLUDGEOIL() {
        return WATERSLUDGEOIL;
    }

    public String getOILPRESSURE() {
        return OILPRESSURE;
    }

    public String getRELATIVECYLENDIRCOMPRESSION() {
        return RELATIVECYLENDIRCOMPRESSION;
    }

    public String getTIMINGBELT() {
        return TIMINGBELT;
    }

    public String getENGINEMOUNTS() {
        return ENGINEMOUNTS;
    }

    public String getTURBOCHARGERAIRCOOLER() {
        return TURBOCHARGERAIRCOOLER;
    }

    public String getRADIATOR() {
        return RADIATOR;
    }

    public String getRADIATORCAP() {
        return RADIATORCAP;
    }

    public String getCOOLINGFANS() {
        return COOLINGFANS;
    }

    public String getWATERPUMP() {
        return WATERPUMP;
    }

    public String getCOOLANTRECOVERYTANK() {
        return COOLANTRECOVERYTANK;
    }

    public String getCABINAIRFILTER() {
        return CABINAIRFILTER;
    }

    public String getFUELPUMPNOISENORMAL() {
        return FUELPUMPNOISENORMAL;
    }

    public String getFUELPUMPPRESSURE() {
        return FUELPUMPPRESSURE;
    }

    public String getFUELFILTER() {
        return FUELFILTER;
    }

    public String getENGINEAIRFILTER() {
        return ENGINEAIRFILTER;
    }

    public String getSTARTEROPERATION() {
        return STARTEROPERATION;
    }

    public String getIGNITIONSYSTEM() {
        return IGNITIONSYSTEM;
    }

    public String getBATTERY() {
        return BATTERY;
    }

    public String getALTERNATOROUTPUT() {
        return ALTERNATOROUTPUT;
    }

    public String getDIESELGLOWPLUGSYSTEM() {
        return DIESELGLOWPLUGSYSTEM;
    }

    public Float getREPAIRINGCOSTUNDERHOOD() {
        return REPAIRINGCOSTUNDERHOOD;
    }

    public String getCOMMENTUNDERHOOD() {
        return COMMENTUNDERHOOD;
    }
}
