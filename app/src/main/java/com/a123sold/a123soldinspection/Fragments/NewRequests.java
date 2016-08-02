package com.a123sold.a123soldinspection.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a123sold.a123soldinspection.Adapters.NewRequestAdapter;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.TempData;
import com.a123sold.a123soldinspection.modals.NewRequestDataModal;

import java.util.ArrayList;

/**
 * Created by akshit on 23/7/16.
 */
public class NewRequests extends Fragment {
    private NewRequestAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<NewRequestDataModal> data;
    private static Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.newrequests, container, false);
        initialize(rootView);
        return rootView;
    }

    void initialize(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.newrequest_recycler_view);
        recyclerView.setHasFixedSize(true);
        activity=getActivity();
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data=new ArrayList<NewRequestDataModal>();
        for (int i = 0; i < TempData.modalArray.length; i++) {
            data.add(new NewRequestDataModal(1,
                    TempData.makeArray[i],
            TempData.modalArray[i],
            TempData.versionArray[i],
            TempData.yearArray[i],
            TempData.kmsArray[i],
            TempData.fueltypeArray[i],
            TempData.transmissionArray[i],
            TempData.ownerArray[i],
            TempData.localtionArray[i],
            TempData.customernameArray[i],
            TempData.customernumberArray[i],
            TempData.carimageArray[i],0,0,0
            ));
        }
        adapter = new NewRequestAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
