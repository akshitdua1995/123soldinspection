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
import android.widget.RelativeLayout;

import com.a123sold.a123soldinspection.Adapters.PendingRequestAdapter;
import com.a123sold.a123soldinspection.Helpers.ViewsVisibility;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.NewRequestDataModal;

import java.util.ArrayList;

/**
 * Created by akshit on 23/7/16.
 */
public class PendingRequests extends Fragment{
    private PendingRequestAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<NewRequestDataModal> data;
    private static Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pendingrequests, container, false);
        initialize(rootView);
        return rootView;
    }

    void initialize(View view){

        recyclerView = (RecyclerView) view.findViewById(R.id.pendingrequest_recycler_view);
        recyclerView.setHasFixedSize(true);
        activity=getActivity();
        ViewsVisibility.PendingrelativeLayout= (RelativeLayout) view.findViewById(R.id.nopendingview);
        layoutManager = new LinearLayoutManager(activity);
        ViewsVisibility.conextActivity=activity;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<NewRequestDataModal> data=new ArrayList<NewRequestDataModal>();
        ViewsVisibility.pendingRequestAdapter=new PendingRequestAdapter(data);
        recyclerView.setAdapter(ViewsVisibility.pendingRequestAdapter);
        RelativeLayout relativeLayout= (RelativeLayout) view.findViewById(R.id.nopendingview);
    }
}