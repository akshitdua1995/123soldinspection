package com.a123sold.a123soldinspection.modals;

import android.os.Parcel;
import android.os.Parcelable;


public class NewRequestDataModal implements Parcelable {
    String make,model,version,fuelType,transmission,address,ownerName;
    int year,numberOfOwners,kmDriven;
    int assigned,pending,completed;
    String id;

    public NewRequestDataModal(String make, String model, String version, int kmDriven, String fuelType, String transmission, String address, String ownerName, int year, int numberOfOwners, int assigned, int pending, int completed, String id) {
        //this.image = image;
        this.make = make;
        this.model = model;
        this.version = version;
        this.kmDriven = kmDriven;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.address = address;
        this.ownerName = ownerName;
        this.year = year;
        this.numberOfOwners = numberOfOwners;
        this.assigned = assigned;
        this.pending = pending;
        this.completed = completed;
        this.id = id;
    }

    protected NewRequestDataModal(Parcel in) {
        //image = in.readInt();
        make = in.readString();
        model = in.readString();
        version = in.readString();
        fuelType = in.readString();
        transmission = in.readString();
        address = in.readString();
        ownerName = in.readString();
        year = in.readInt();
        numberOfOwners = in.readInt();
        kmDriven = in.readInt();
        assigned = in.readInt();
        pending = in.readInt();
        completed = in.readInt();
        id = in.readString();
    }

    public static final Creator<NewRequestDataModal> CREATOR = new Creator<NewRequestDataModal>() {
        @Override
        public NewRequestDataModal createFromParcel(Parcel in) {
            return new NewRequestDataModal(in);
        }

        @Override
        public NewRequestDataModal[] newArray(int size) {
            return new NewRequestDataModal[size];
        }
    };

    //public int getImage() {
   //     return image;
   // }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getAddress() {
        return address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfOwners() {
        return numberOfOwners;
    }

    public int getKmDriven() {
        return kmDriven;
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

    public String getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

  //  public void setImage(int image) {
//        this.image = image;
   // }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumberOfOwners(int numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public void setAssigned(int assigned) {
        this.assigned = assigned;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(image);
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(version);
        dest.writeString(fuelType);
        dest.writeString(transmission);
        dest.writeString(address);
        dest.writeString(ownerName);
        dest.writeInt(year);
        dest.writeInt(numberOfOwners);
        dest.writeInt(kmDriven);
        dest.writeInt(assigned);
        dest.writeInt(pending);
        dest.writeInt(completed);
        dest.writeString(id);
    }
}
