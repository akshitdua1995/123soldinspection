package com.a123sold.a123soldinspection.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a123sold.a123soldinspection.R;

/**
 * Created by akshit on 24/7/16.
 */
public class DiagnosticsFragment extends android.app.Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diagnostics_form,container, false);
        return rootView;
    }
}
