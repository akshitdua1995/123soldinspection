package com.a123sold.a123soldinspection.modals;

/**
 * Created by akshit on 31/7/16.
 */
public class CarprogressModal {

    Integer CARID;
    Float TOTAL_REPAIRING_COST;
    Integer PROGRESS;
    Boolean UNDERBODYCOMPLETED;
    Boolean UNDERHOODCOMPLETED;
    Boolean INTERIORCOMPLETED;
    Boolean EXTERIORCOMPLETED;
    Boolean HYBRIDCOMPLETED;
    Boolean CONVIENCECOMPLETED;
    Boolean ROADTESTCOMPLETED;
    Boolean HISTORYCOMPLETED;

    public CarprogressModal(){}
    public CarprogressModal(Integer CARID, Float TOTAL_REPAIRING_COST, Integer PROGRESS, Boolean UNDERBODYCOMPLETED, Boolean UNDERHOODCOMPLETED, Boolean INTERIORCOMPLETED, Boolean EXTERIORCOMPLETED, Boolean HYBRIDCOMPLETED, Boolean CONVIENCECOMPLETED, Boolean ROADTESTCOMPLETED, Boolean HISTORYCOMPLETED) {
        this.CARID = CARID;
        this.TOTAL_REPAIRING_COST = TOTAL_REPAIRING_COST;
        this.PROGRESS = PROGRESS;
        this.UNDERBODYCOMPLETED = UNDERBODYCOMPLETED;
        this.UNDERHOODCOMPLETED = UNDERHOODCOMPLETED;
        this.INTERIORCOMPLETED = INTERIORCOMPLETED;
        this.EXTERIORCOMPLETED = EXTERIORCOMPLETED;
        this.HYBRIDCOMPLETED = HYBRIDCOMPLETED;
        this.CONVIENCECOMPLETED = CONVIENCECOMPLETED;
        this.ROADTESTCOMPLETED = ROADTESTCOMPLETED;
        this.HISTORYCOMPLETED = HISTORYCOMPLETED;
    }

    public Integer getCARID() {
        return CARID;
    }

    public Float getTOTAL_REPAIRING_COST() {
        return TOTAL_REPAIRING_COST;
    }

    public Integer getPROGRESS() {
        return PROGRESS;
    }

    public Boolean getUNDERBODYCOMPLETED() {
        return UNDERBODYCOMPLETED;
    }

    public Boolean getUNDERHOODCOMPLETED() {
        return UNDERHOODCOMPLETED;
    }

    public Boolean getINTERIORCOMPLETED() {
        return INTERIORCOMPLETED;
    }

    public Boolean getEXTERIORCOMPLETED() {
        return EXTERIORCOMPLETED;
    }

    public Boolean getHYBRIDCOMPLETED() {
        return HYBRIDCOMPLETED;
    }

    public Boolean getCONVIENCECOMPLETED() {
        return CONVIENCECOMPLETED;
    }

    public Boolean getROADTESTCOMPLETED() {
        return ROADTESTCOMPLETED;
    }

    public Boolean getHISTORYCOMPLETED() {
        return HISTORYCOMPLETED;
    }
}
