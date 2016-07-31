package com.a123sold.a123soldinspection.modals;

/**
 * Created by akshit on 29/7/16.
 */
public class ConvienceModal {
    Integer CARID;
    Integer OWNERSGUIDE ;
    Integer KEYREMOTECONTROLS ;
    Integer UNIVERSALTRANSMITTER ;
    Integer RC ;
    Integer POLLUTIONCERTI ;
    Integer COMPANY ;
    String INSAURANCEVALIDITY ;
    Integer LIFETAXPAID ;
    Integer LEASE ;
    String NAMEFINANCIALCORPORATION ;
    Float REPAIRINGCOSTCONVIENCE ;
    String COMMENTCONVIENCE ;

    public ConvienceModal(Integer CARID, Integer OWNERSGUIDE, Integer KEYREMOTECONTROLS, Integer UNIVERSALTRANSMITTER, Integer RC, Integer POLLUTIONCERTI, Integer COMPANY, String INSAURANCEVALIDITY, Integer LIFETAXPAID, Integer LEASE, String NAMEFINANCIALCORPORATION, Float REPAIRINGCOSTCONVIENCE, String COMMENTCONVIENCE) {
        this.CARID = CARID;
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
    }

    public ConvienceModal(){

    }

    public Integer getCARID() {
        return CARID;
    }

    public Integer getOWNERSGUIDE() {
        return OWNERSGUIDE;
    }

    public Integer getKEYREMOTECONTROLS() {
        return KEYREMOTECONTROLS;
    }

    public Integer getUNIVERSALTRANSMITTER() {
        return UNIVERSALTRANSMITTER;
    }

    public Integer getRC() {
        return RC;
    }

    public Integer getPOLLUTIONCERTI() {
        return POLLUTIONCERTI;
    }

    public Integer getCOMPANY() {
        return COMPANY;
    }

    public String getINSAURANCEVALIDITY() {
        return INSAURANCEVALIDITY;
    }

    public Integer getLIFETAXPAID() {
        return LIFETAXPAID;
    }

    public Integer getLEASE() {
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
}
