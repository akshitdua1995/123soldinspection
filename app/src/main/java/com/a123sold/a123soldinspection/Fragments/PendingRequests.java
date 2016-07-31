package com.a123sold.a123soldinspection.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a123sold.a123soldinspection.R;

/**
 * Created by akshit on 23/7/16.
 */
public class PendingRequests extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.pendingrequests, container, false);
        return rootView;
    }
}