package com.a123sold.a123soldinspection.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akshit on 29/7/16.
 */
public class InteriorModal {
    @Expose(deserialize = false)
    String id;
    @SerializedName("Airbags Available")
    String AIRBAGS;
    @SerializedName("Safety Belts")
    String SAFTEYBELTS ;
    @SerializedName("Stereo and Speakers")
    String STEREOANDSPEAKERS ;
    @SerializedName("Antenna")
    String ANTENNA ;
    @SerializedName("Alarm/Theft-Deferrent System")
    String ALARMSYSTEM ;
    @SerializedName("Navigation System(Available)")
    String NAVIGATIONSYSTEM ;
    @SerializedName("Air Conditioning System-(Scale 1-5)")
    String AIRCONDITIONINGSYSTEM ;
    @SerializedName("Heating System-(Scale 1-5)")
    String HEATINGSYSTEM ;
    @SerializedName("Defog/Defrost (Available)")
    String DEFOG ;
    @SerializedName("Clock(Available)")
    String CLOCK ;
    @SerializedName("Tilt/Telescopic Steering Wheel(Available)")
    String TILTSTEERINGWHEEL ;
    @SerializedName("Steering Column Lock(Available)")
    String STEERINGCOLUMNLOCK ;
    @SerializedName("Steering Wheel Controls")
    String STEERINGWHEELCONTROLS;
    @SerializedName("Horn")
    String HORN ;
    @SerializedName("Warning Chimes")
    String WARNINGCHIMES ;
    @SerializedName("Instrument Panel and Warning Lights")
    String INSTRUMENTPANELANDWARNINGLIGHT ;
    @SerializedName("Winshield Wipers(Working)")
    String WINDSHEILDWIPERS;
    @SerializedName("Rear Window Wiper(Working)")
    String REARWINDOWWIPER ;
    @SerializedName("Washers(Working)")
    String WASHERS ;
    @SerializedName("Interior Courtesy,Dorne and Map Lights")
    String MAPLIGHTS ;
    @SerializedName("Outside Rear View Mirrors")
    String OUTSIDEREARVIEWMIRRORS ;
    @SerializedName("Auto-Dimming Rear View Mirror(Premium cars -Available)")
    String AUTODIMMINGREARVIEW ;
    @SerializedName("BindSpot Information System (BLIS) (Premium cars - Available)")
    String BLINDSPOT;
    @SerializedName("Rear View Camera System (Available)")
    String REARCAMERA;
    @SerializedName("Active Park Assist")
    String ACTIVEPARKASSIST ;
    @SerializedName("Rear Entertainment System(Premium cars)")
    String REARENTERTAINMENTSYSTEM;
    @SerializedName("Power Outlets")
    String POWEROUTLETS ;
    @SerializedName("Lighter")
    String LIGHTER ;
    @SerializedName("Ashtrays")
    String ASHTRAYS ;
    @SerializedName("Glove Box")
    String GLOVEBOX ;
    @SerializedName("Center Armrest/Console Front")
    String CENTERCONSOLEFRONT;
    @SerializedName("Center Armrest/Console Rear")
    String CENTERCONSOLEFREAR;
    @SerializedName("Sun Visors,Vanity Mirror and Light")
    String SUNVISORS ;
    @SerializedName("Adjustable Pedals(if equipped)")
    String ADJUSTABLEPEDALS ;
    @SerializedName("Interior Odor Free")
    String INTERIORODOR ;
    @SerializedName("Carpet(Torn)")
    String CARPET ;
    @SerializedName("Floor Mats")
    String FLOODMATS;
    @SerializedName("Door Trim and Door Panels (Damage)")
    String DOORTRIM ;
    @SerializedName("Headliner")
    String HEADLINER ;
    @SerializedName("Seat Upholstery")
    String SEATUPHOLDSTERY ;
    @SerializedName("Seat and Head Restraint Adjustment")
    String SEATANDHEAD ;
    @SerializedName("Folding Seats(SUV)")
    String FOLDINGSEATS;
    @SerializedName("Heated Seats(Premium Cars)")
    String HEATEDSEATS ;
    @SerializedName("Cooled Seats(Premium Cars)")
    String COOLEDSEATS ;
    @SerializedName("SUNROOF/MOONROOF/CONVERTIBLE TOP")
    String CONVERTIBLETOP;
    @SerializedName("Sunroof Moon roof(Available)")
    String SUNROOF;
    @SerializedName("Door Handles and Release Mechanisms")
    String DOORHANDLES;
    @SerializedName("Remote Entry System(Available)")
    String REMOTEENTRY;
    @SerializedName("Push-Button Start System(Available)")
    String PUSHBUTTONSTART ;
    @SerializedName("Door Locks")
    String DOORLOCKS;
    @SerializedName("Child Saftey Locks")
    String CHILDSAFTEYLOCKS ;
    @SerializedName("Window Controls")
    String WINDOWCONTROLS ;
    @SerializedName("Remote Deck lid Release")
    String REMOTEDECKLID ;
    @SerializedName("Fuel Filler Door Release")
    String FUELFILLERDOOR ;
    @SerializedName("Luggage Compartment Carpet")
    String CARPETLUGGAGE ;
    @SerializedName("Luggage Compartment Trim and Cargo net(Available)")
    String CARGONET;
    @SerializedName("Luggage Compartment/Cargo Area Light(Available)")
    String CARGOAREALIGHT ;
    @SerializedName("Vehicle Jack and Tool Kit (Available)")
    String JACKTOOLKIT ;
    @SerializedName("Spare Tire Size/Type and Sidewall Inspection")
    String SIDEWALLINS ;
    @SerializedName("Spate Tire Thread Depth/Air Pressure Inspection")
    String PRESSUREINS ;
    @SerializedName("Tire Inflator Kit (Available)")
    String TIREKIT;
    @SerializedName("Emergency Trunk-Lid(Available)")
    String LIDRELEASE ;
    @SerializedName("Repairing Cost")
    Float REPAIRINGCOSTINTERIOR ;
    @SerializedName("Comment")
    String COMMENTINTERIOR ;

    public InteriorModal(){}
    public InteriorModal(String id, String AIRBAGS, String SAFTEYBELTS, String STEREOANDSPEAKERS,
                         String ANTENNA, String ALARMSYSTEM, String NAVIGATIONSYSTEM, String AIRCONDITIONINGSYSTEM,
                         String HEATINGSYSTEM, String DEFOG, String CLOCK, String TILTSTEERINGWHEEL,
                         String STEERINGCOLUMNLOCK, String STEERINGWHEELCONTROLS, String HORN, String WARNINGCHIMES,
                         String INSTRUMENTPANELANDWARNINGLIGHT, String WINDSHEILDWIPERS, String REARWINDOWWIPER,
                         String WASHERS, String MAPLIGHTS, String OUTSIDEREARVIEWMIRRORS, String AUTODIMMINGREARVIEW,
                         String BLINDSPOT, String REARCAMERA, String ACTIVEPARKASSIST, String REARENTERTAINMENTSYSTEM,
                         String POWEROUTLETS, String LIGHTER, String ASHTRAYS, String GLOVEBOX, String CENTERCONSOLEFRONT,
                         String CENTERCONSOLEFREAR, String SUNVISORS, String ADJUSTABLEPEDALS, String INTERIORODOR,
                         String CARPET, String FLOODMATS, String DOORTRIM, String HEADLINER, String SEATUPHOLDSTERY,
                         String SEATANDHEAD, String FOLDINGSEATS, String HEATEDSEATS, String COOLEDSEATS,
                         String CONVERTIBLETOP, String SUNROOF, String DOORHANDLES, String REMOTEENTRY,
                         String PUSHBUTTONSTART, String DOORLOCKS, String CHILDSAFTEYLOCKS, String WINDOWCONTROLS,
                         String REMOTEDECKLID, String FUELFILLERDOOR, String CARPETLUGGAGE, String CARGONET,
                         String CARGOAREALIGHT, String JACKTOOLKIT, String SIDEWALLINS, String PRESSUREINS,
                         String TIREKIT, String LIDRELEASE, Float REPAIRINGCOSTINTERIOR, String COMMENTINTERIOR) {
        this.id = id;
        this.AIRBAGS = AIRBAGS;
        this.SAFTEYBELTS = SAFTEYBELTS;
        this.STEREOANDSPEAKERS = STEREOANDSPEAKERS;
        this.ANTENNA = ANTENNA;
        this.ALARMSYSTEM = ALARMSYSTEM;
        this.NAVIGATIONSYSTEM = NAVIGATIONSYSTEM;
        this.AIRCONDITIONINGSYSTEM = AIRCONDITIONINGSYSTEM;
        this.HEATINGSYSTEM = HEATINGSYSTEM;
        this.DEFOG = DEFOG;
        this.CLOCK = CLOCK;
        this.TILTSTEERINGWHEEL = TILTSTEERINGWHEEL;
        this.STEERINGCOLUMNLOCK = STEERINGCOLUMNLOCK;
        this.STEERINGWHEELCONTROLS = STEERINGWHEELCONTROLS;
        this.HORN = HORN;
        this.WARNINGCHIMES = WARNINGCHIMES;
        this.INSTRUMENTPANELANDWARNINGLIGHT = INSTRUMENTPANELANDWARNINGLIGHT;
        this.WINDSHEILDWIPERS = WINDSHEILDWIPERS;
        this.REARWINDOWWIPER = REARWINDOWWIPER;
        this.WASHERS = WASHERS;
        this.MAPLIGHTS = MAPLIGHTS;
        this.OUTSIDEREARVIEWMIRRORS = OUTSIDEREARVIEWMIRRORS;
        this.AUTODIMMINGREARVIEW = AUTODIMMINGREARVIEW;
        this.BLINDSPOT = BLINDSPOT;
        this.REARCAMERA = REARCAMERA;
        this.ACTIVEPARKASSIST = ACTIVEPARKASSIST;
        this.REARENTERTAINMENTSYSTEM = REARENTERTAINMENTSYSTEM;
        this.POWEROUTLETS = POWEROUTLETS;
        this.LIGHTER = LIGHTER;
        this.ASHTRAYS = ASHTRAYS;
        this.GLOVEBOX = GLOVEBOX;
        this.CENTERCONSOLEFRONT = CENTERCONSOLEFRONT;
        this.CENTERCONSOLEFREAR = CENTERCONSOLEFREAR;
        this.SUNVISORS = SUNVISORS;
        this.ADJUSTABLEPEDALS = ADJUSTABLEPEDALS;
        this.INTERIORODOR = INTERIORODOR;
        this.CARPET = CARPET;
        this.FLOODMATS = FLOODMATS;
        this.DOORTRIM = DOORTRIM;
        this.HEADLINER = HEADLINER;
        this.SEATUPHOLDSTERY = SEATUPHOLDSTERY;
        this.SEATANDHEAD = SEATANDHEAD;
        this.FOLDINGSEATS = FOLDINGSEATS;
        this.HEATEDSEATS = HEATEDSEATS;
        this.COOLEDSEATS = COOLEDSEATS;
        this.CONVERTIBLETOP = CONVERTIBLETOP;
        this.SUNROOF = SUNROOF;
        this.DOORHANDLES = DOORHANDLES;
        this.REMOTEENTRY = REMOTEENTRY;
        this.PUSHBUTTONSTART = PUSHBUTTONSTART;
        this.DOORLOCKS = DOORLOCKS;
        this.CHILDSAFTEYLOCKS = CHILDSAFTEYLOCKS;
        this.WINDOWCONTROLS = WINDOWCONTROLS;
        this.REMOTEDECKLID = REMOTEDECKLID;
        this.FUELFILLERDOOR = FUELFILLERDOOR;
        this.CARPETLUGGAGE = CARPETLUGGAGE;
        this.CARGONET = CARGONET;
        this.CARGOAREALIGHT = CARGOAREALIGHT;
        this.JACKTOOLKIT = JACKTOOLKIT;
        this.SIDEWALLINS = SIDEWALLINS;
        this.PRESSUREINS = PRESSUREINS;
        this.TIREKIT = TIREKIT;
        this.LIDRELEASE = LIDRELEASE;
        this.REPAIRINGCOSTINTERIOR = REPAIRINGCOSTINTERIOR;
        this.COMMENTINTERIOR = COMMENTINTERIOR;
    }

    public String getid() {
        return id;
    }

    public String getAIRBAGS() {
        return AIRBAGS;
    }

    public String getSAFTEYBELTS() {
        return SAFTEYBELTS;
    }

    public String getSTEREOANDSPEAKERS() {
        return STEREOANDSPEAKERS;
    }

    public String getANTENNA() {
        return ANTENNA;
    }

    public String getALARMSYSTEM() {
        return ALARMSYSTEM;
    }

    public String getNAVIGATIONSYSTEM() {
        return NAVIGATIONSYSTEM;
    }

    public String getAIRCONDITIONINGSYSTEM() {
        return AIRCONDITIONINGSYSTEM;
    }

    public String getHEATINGSYSTEM() {
        return HEATINGSYSTEM;
    }

    public String getDEFOG() {
        return DEFOG;
    }

    public String getCLOCK() {
        return CLOCK;
    }

    public String getTILTSTEERINGWHEEL() {
        return TILTSTEERINGWHEEL;
    }

    public String getSTEERINGCOLUMNLOCK() {
        return STEERINGCOLUMNLOCK;
    }

    public String getSTEERINGWHEELCONTROLS() {
        return STEERINGWHEELCONTROLS;
    }

    public String getHORN() {
        return HORN;
    }

    public String getWARNINGCHIMES() {
        return WARNINGCHIMES;
    }

    public String getINSTRUMENTPANELANDWARNINGLIGHT() {
        return INSTRUMENTPANELANDWARNINGLIGHT;
    }

    public String getWINDSHEILDWIPERS() {
        return WINDSHEILDWIPERS;
    }

    public String getREARWINDOWWIPER() {
        return REARWINDOWWIPER;
    }

    public String getWASHERS() {
        return WASHERS;
    }

    public String getMAPLIGHTS() {
        return MAPLIGHTS;
    }

    public String getOUTSIDEREARVIEWMIRRORS() {
        return OUTSIDEREARVIEWMIRRORS;
    }

    public String getAUTODIMMINGREARVIEW() {
        return AUTODIMMINGREARVIEW;
    }

    public String getBLINDSPOT() {
        return BLINDSPOT;
    }

    public String getREARCAMERA() {
        return REARCAMERA;
    }

    public String getACTIVEPARKASSIST() {
        return ACTIVEPARKASSIST;
    }

    public String getREARENTERTAINMENTSYSTEM() {
        return REARENTERTAINMENTSYSTEM;
    }

    public String getPOWEROUTLETS() {
        return POWEROUTLETS;
    }

    public String getLIGHTER() {
        return LIGHTER;
    }

    public String getASHTRAYS() {
        return ASHTRAYS;
    }

    public String getGLOVEBOX() {
        return GLOVEBOX;
    }

    public String getCENTERCONSOLEFRONT() {
        return CENTERCONSOLEFRONT;
    }

    public String getCENTERCONSOLEFREAR() {
        return CENTERCONSOLEFREAR;
    }

    public String getSUNVISORS() {
        return SUNVISORS;
    }

    public String getADJUSTABLEPEDALS() {
        return ADJUSTABLEPEDALS;
    }

    public String getINTERIORODOR() {
        return INTERIORODOR;
    }

    public String getCARPET() {
        return CARPET;
    }

    public String getFLOODMATS() {
        return FLOODMATS;
    }

    public String getDOORTRIM() {
        return DOORTRIM;
    }

    public String getHEADLINER() {
        return HEADLINER;
    }

    public String getSEATUPHOLDSTERY() {
        return SEATUPHOLDSTERY;
    }

    public String getSEATANDHEAD() {
        return SEATANDHEAD;
    }

    public String getFOLDINGSEATS() {
        return FOLDINGSEATS;
    }

    public String getHEATEDSEATS() {
        return HEATEDSEATS;
    }

    public String getCOOLEDSEATS() {
        return COOLEDSEATS;
    }

    public String getCONVERTIBLETOP() {
        return CONVERTIBLETOP;
    }

    public String getSUNROOF() {
        return SUNROOF;
    }

    public String getDOORHANDLES() {
        return DOORHANDLES;
    }

    public String getREMOTEENTRY() {
        return REMOTEENTRY;
    }

    public String getPUSHBUTTONSTART() {
        return PUSHBUTTONSTART;
    }

    public String getDOORLOCKS() {
        return DOORLOCKS;
    }

    public String getCHILDSAFTEYLOCKS() {
        return CHILDSAFTEYLOCKS;
    }

    public String getWINDOWCONTROLS() {
        return WINDOWCONTROLS;
    }

    public String getREMOTEDECKLID() {
        return REMOTEDECKLID;
    }

    public String getFUELFILLERDOOR() {
        return FUELFILLERDOOR;
    }

    public String getCARPETLUGGAGE() {
        return CARPETLUGGAGE;
    }

    public String getCARGONET() {
        return CARGONET;
    }

    public String getCARGOAREALIGHT() {
        return CARGOAREALIGHT;
    }

    public String getJACKTOOLKIT() {
        return JACKTOOLKIT;
    }

    public String getSIDEWALLINS() {
        return SIDEWALLINS;
    }

    public String getPRESSUREINS() {
        return PRESSUREINS;
    }

    public String getTIREKIT() {
        return TIREKIT;
    }

    public String getLIDRELEASE() {
        return LIDRELEASE;
    }

    public Float getREPAIRINGCOSTINTERIOR() {
        return REPAIRINGCOSTINTERIOR;
    }

    public String getCOMMENTINTERIOR() {
        return COMMENTINTERIOR;
    }
}
