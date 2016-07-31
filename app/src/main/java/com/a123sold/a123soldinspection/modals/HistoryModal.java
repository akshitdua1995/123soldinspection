package com.a123sold.a123soldinspection.modals;

/**
 * Created by akshit on 29/7/16.
 */
public class HistoryModal {
    Integer CARID;
    Integer VIN ;
    Integer SERVICERECALL ;
    Integer VEHICLEHISTORYREPORT ;
    Integer SCHEDULEDMAINTENANCE ;
    Integer VEHICLEEMISSIONS ;
    Float REPAIRINGCOSTHISTORY ;
    String COMMENTHISTORY ;

    public HistoryModal(){}

    public HistoryModal(Integer CARID, Integer VIN, Integer SERVICERECALL, Integer VEHICLEHISTORYREPORT, Integer SCHEDULEDMAINTENANCE, Integer VEHICLEEMISSIONS, Float REPAIRINGCOSTHISTORY, String COMMENTHISTORY) {
        this.CARID = CARID;
        this.VIN = VIN;
        this.SERVICERECALL = SERVICERECALL;
        this.VEHICLEHISTORYREPORT = VEHICLEHISTORYREPORT;
        this.SCHEDULEDMAINTENANCE = SCHEDULEDMAINTENANCE;
        this.VEHICLEEMISSIONS = VEHICLEEMISSIONS;
        this.REPAIRINGCOSTHISTORY = REPAIRINGCOSTHISTORY;
        this.COMMENTHISTORY = COMMENTHISTORY;
    }

    public Integer getCARID() {
        return CARID;
    }

    public Integer getVIN() {
        return VIN;
    }

    public Integer getSERVICERECALL() {
        return SERVICERECALL;
    }

    public Integer getVEHICLEHISTORYREPORT() {
        return VEHICLEHISTORYREPORT;
    }

    public Integer getSCHEDULEDMAINTENANCE() {
        return SCHEDULEDMAINTENANCE;
    }

    public Integer getVEHICLEEMISSIONS() {
        return VEHICLEEMISSIONS;
    }

    public Float getREPAIRINGCOSTHISTORY() {
        return REPAIRINGCOSTHISTORY;
    }

    public String getCOMMENTHISTORY() {
        return COMMENTHISTORY;
    }
}
