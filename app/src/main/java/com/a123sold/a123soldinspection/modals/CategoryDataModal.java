package com.a123sold.a123soldinspection.modals;

/**
 * Created by akshit on 24/7/16.
 */
public class CategoryDataModal {
    int image;
    String catname;
    public CategoryDataModal(String catname,int image) {
        this.catname = catname;
        this.image=image;
    }

    public String getCatname() {
        return catname;
    }
    public int getImage() {
        return image;
    }

}
