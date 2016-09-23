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

import com.a123sold.a123soldinspection.Adapters.NewRequestAdapter;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.JsonRequest;
import com.a123sold.a123soldinspection.Helpers.ViewsVisibility;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.NewRequestDataModal;

import org.json.JSONException;

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
        ViewsVisibility.NewrelativeLayout= (RelativeLayout) view.findViewById(R.id.nonewview);
        layoutManager = new LinearLayoutManager(activity);
        ViewsVisibility.conextActivity=activity;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RelativeLayout relativeLayout= (RelativeLayout) view.findViewById(R.id.nonewview);
        JsonRequest request=new JsonRequest(this.getActivity().getApplicationContext(),this.getActivity());
        try {
            request.LoadNewRequests(Config.BASE_URL+"/api/123sold/inspectionInfo/waitingForInspection",recyclerView,relativeLayout);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
