package com.a123sold.a123soldinspection.modals;

import java.util.ArrayList;

/**
 * Created by akshit on 20/9/16.
 */
public class RequestList {
    private ArrayList<NewRequestDataModal> auctionsData;
    private String status;
    public ArrayList getAuctionsData() {
        return auctionsData;
    }

    public void setData(ArrayList<NewRequestDataModal> auctionsData) {
        this.auctionsData = auctionsData;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }
}
