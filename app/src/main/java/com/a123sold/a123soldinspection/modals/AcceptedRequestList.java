package com.a123sold.a123soldinspection.modals;

import java.util.ArrayList;

public class AcceptedRequestList {
    private ArrayList<NewRequestDataModal> auctions;
    public ArrayList getAuctionsData() {
        return auctions;
    }

    public void setData(ArrayList<NewRequestDataModal> auctionsData) {
        this.auctions = auctionsData;
    }

}
