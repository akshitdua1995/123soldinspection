package com.a123sold.a123soldinspection.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akshit on 29/7/16.
 */

public class HistoryModal {
    @Expose(deserialize = false)
    String id;
    @SerializedName("VIN Inspection(or chasis number)")
    String VIN;
    @SerializedName("Service Recalls (OASIS) Performed")
    String SERVICERECALL;
    @SerializedName("Vehicle History Report Obtained(customer given)")
    String VEHICLEHISTORYREPORT;
    @SerializedName("Scheduled Maintenance Performed(customer given)")
    String SCHEDULEDMAINTENANCE;
    @SerializedName("Vehicle Emissions Sticker (ApplicableStates)")
    String VEHICLEEMISSIONS;
    @SerializedName("Repairing Cost")
    Float REPAIRINGCOSTHISTORY ;
    @SerializedName("Comment")
    String COMMENTHISTORY ;

    public HistoryModal(){}

    public HistoryModal(String id, String VIN, String SERVICERECALL, String VEHICLEHISTORYREPORT, String SCHEDULEDMAINTENANCE, String VEHICLEEMISSIONS, Float REPAIRINGCOSTHISTORY, String COMMENTHISTORY) {
        this.id = id;
        this.VIN = VIN;
        this.SERVICERECALL = SERVICERECALL;
        this.VEHICLEHISTORYREPORT = VEHICLEHISTORYREPORT;
        this.SCHEDULEDMAINTENANCE = SCHEDULEDMAINTENANCE;
        this.VEHICLEEMISSIONS = VEHICLEEMISSIONS;
        this.REPAIRINGCOSTHISTORY = REPAIRINGCOSTHISTORY;
        this.COMMENTHISTORY = COMMENTHISTORY;
    }

    public String getid() {
        return id;
    }

    public String getVIN() {
        return VIN;
    }

    public String getSERVICERECALL() {
        return SERVICERECALL;
    }

    public String getVEHICLEHISTORYREPORT() {
        return VEHICLEHISTORYREPORT;
    }

    public String getSCHEDULEDMAINTENANCE() {
        return SCHEDULEDMAINTENANCE;
    }

    public String getVEHICLEEMISSIONS() {
        return VEHICLEEMISSIONS;
    }

    public Float getREPAIRINGCOSTHISTORY() {
        return REPAIRINGCOSTHISTORY;
    }

    public String getCOMMENTHISTORY() {
        return COMMENTHISTORY;
    }
}
