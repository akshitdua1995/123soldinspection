package com.a123sold.a123soldinspection.modals;

import com.google.gson.annotations.SerializedName;


public class ConvienceModal {
    String id;
    @SerializedName("Owner's Guide(Available)")
    String OWNERSGUIDE;
    @SerializedName("Keys and Remote Controls(Available)")
    String KEYREMOTECONTROLS;
    @SerializedName("Universal Transmitter(garage reate opener|Available)")
    String UNIVERSALTRANSMITTER;
    @SerializedName("RC")
    String RC;
    @SerializedName("Pollution Certificate")
    String POLLUTIONCERTI;
    @SerializedName("Company/3rd Party")
    String COMPANY;
    @SerializedName("Insurance validity")
    String INSAURANCEVALIDITY;
    @SerializedName("Life tax paid")
    String LIFETAXPAID;
    @SerializedName("HP/lease if any")
    String LEASE;
    @SerializedName("Name of Finance Co")
    String NAMEFINANCIALCORPORATION;
    @SerializedName("Repairing Cost")
    Float REPAIRINGCOSTCONVIENCE;
    @SerializedName("Comment")
    String COMMENTCONVIENCE;
    @SerializedName("Cubic Capacity")
    String CUBICCAPACITY;
    @SerializedName("Vehicle Used As")
    String VEHICLEUSEDAS;
    @SerializedName("Financer name")
    String FINANCERNAME;
    @SerializedName("VIP License Plate")
    String VIPLICENSEPLATE;
    @SerializedName("Dublicate key")
    String DUPLICATEKEY;
    @SerializedName("Under Hypothecation")
    String UNDERHYPOTHECATION;

    public ConvienceModal(String id, String OWNERSGUIDE, String KEYREMOTECONTROLS, String UNIVERSALTRANSMITTER, String RC, String POLLUTIONCERTI, String COMPANY, String INSAURANCEVALIDITY, String LIFETAXPAID, String LEASE, String NAMEFINANCIALCORPORATION, Float REPAIRINGCOSTCONVIENCE, String COMMENTCONVIENCE, String CUBICCAPACITY, String VEHICLEUSEDAS, String FINANCERNAME, String VIPLICENSEPLATE, String DUPLICATEKEY, String UNDERHYPOTHECATION) {
        this.id = id;
        this.OWNERSGUIDE = OWNERSGUIDE;
        this.KEYREMOTECONTROLS = KEYREMOTECONTROLS;
        this.UNIVERSALTRANSMITTER = UNIVERSALTRANSMITTER;
        this.RC = RC;
        this.POLLUTIONCERTI = POLLUTIONCERTI;
        this.COMPANY = COMPANY;
        this.INSAURANCEVALIDITY = INSAURANCEVALIDITY;
        this.LIFETAXPAID = LIFETAXPAID;
        this.LEASE = LEASE;
        this.NAMEFINANCIALCORPORATION = NAMEFINANCIALCORPORATION;
        this.REPAIRINGCOSTCONVIENCE = REPAIRINGCOSTCONVIENCE;
        this.COMMENTCONVIENCE = COMMENTCONVIENCE;
        this.CUBICCAPACITY = CUBICCAPACITY;
        this.VEHICLEUSEDAS = VEHICLEUSEDAS;
        this.FINANCERNAME = FINANCERNAME;
        this.VIPLICENSEPLATE = VIPLICENSEPLATE;
        this.DUPLICATEKEY = DUPLICATEKEY;
        this.UNDERHYPOTHECATION = UNDERHYPOTHECATION;
    }

    public ConvienceModal(){

    }

    public String getid() {
        return id;
    }

    public String getOWNERSGUIDE() {
        return OWNERSGUIDE;
    }

    public String getKEYREMOTECONTROLS() {
        return KEYREMOTECONTROLS;
    }

    public String getUNIVERSALTRANSMITTER() {
        return UNIVERSALTRANSMITTER;
    }

    public String getRC() {
        return RC;
    }

    public String getPOLLUTIONCERTI() {
        return POLLUTIONCERTI;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public String getINSAURANCEVALIDITY() {
        return INSAURANCEVALIDITY;
    }

    public String getLIFETAXPAID() {
        return LIFETAXPAID;
    }

    public String getLEASE() {
        return LEASE;
    }

    public String getNAMEFINANCIALCORPORATION() {
        return NAMEFINANCIALCORPORATION;
    }

    public Float getREPAIRINGCOSTCONVIENCE() {
        return REPAIRINGCOSTCONVIENCE;
    }

    public String getCOMMENTCONVIENCE() {
        return COMMENTCONVIENCE;
    }

    public String getCUBICCAPACITY() {
        return CUBICCAPACITY;
    }

    public String getVEHICLEUSEDAS() {
        return VEHICLEUSEDAS;
    }

    public String getFINANCERNAME() {
        return FINANCERNAME;
    }

    public String getVIPLICENSEPLATE() {
        return VIPLICENSEPLATE;
    }

    public String getDUPLICATEKEY() {
        return DUPLICATEKEY;
    }

    public String getUNDERHYPOTHECATION() {
        return UNDERHYPOTHECATION;
    }
}
