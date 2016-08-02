package com.a123sold.a123soldinspection.modals;

/**
 * Created by akshit on 28/6/16.
 */

public class NewRequestDataModal {
    int image;
    String make,model,version,year,kms,fueltype,transmission,owner,location,customername,customermobilenumber;
    int assigned,pending,completed;
    int CARID;


    public NewRequestDataModal(int CARID, String make, String model, String version, String year,
                               String kms, String fueltype, String transmission, String owner,
                               String location, String customername, String customermobilenumber, int image, int assigned, int pending, int completed) {
        this.CARID=CARID;
        this.make = make;
        this.model=model;
        this.version=version;
        this.year=year;
        this.kms=kms;
        this.fueltype=fueltype;
        this.transmission=transmission;
        this.owner=owner;
        this.location=location;
        this.customername=customername;
        this.customermobilenumber=customermobilenumber;
        this.image=image;
        this.assigned=assigned;
        this.pending=pending;
        this.completed=completed;
    }

    public int getAssigned() {
        return assigned;
    }

    public int getPending() {
        return pending;
    }

    public int getCompleted() {
        return completed;
    }

    public int getCARID() {
        return CARID;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {return model;}
    public String getversion() {
        return version;
    }
    public String getYear() {
        return year;
    }
    public String getFueltype() {
        return fueltype;
    }
    public String getTransmission() {
        return transmission;
    }
    public String getKms() {
        return kms;
    }
    public String getOwner() {
        return owner;
    }
    public String getLocation() {
        return location;
    }
    public String getCustomername() {
        return customername;
    }
    public String getCustomermobilenumber() {
        return customermobilenumber;
    }
    public int getImage() {
        return image;
    }

}
