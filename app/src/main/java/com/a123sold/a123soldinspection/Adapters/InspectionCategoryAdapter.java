package com.a123sold.a123soldinspection.Adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a123sold.a123soldinspection.InspectionCategories;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CategoryDataModal;

import java.util.ArrayList;

/**
 * Created by akshit on 24/7/16.
 */
public class InspectionCategoryAdapter extends RecyclerView.Adapter<InspectionCategoryAdapter.MyViewHolder> {
private ArrayList<CategoryDataModal> dataSet;
private ArrayList<Boolean> checks;
private Activity activity;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

    TextView catname;
    ImageView imagecat;
    ImageView imagetick;
    CardView cardView;
    RelativeLayout relativeLayout;
    public MyViewHolder(View itemView) {
        super(itemView);
        this.relativeLayout=(RelativeLayout) itemView.findViewById(R.id.rlcard);
        this.catname=(TextView)itemView.findViewById(R.id.categorytext);
        this.imagecat=(ImageView)itemView.findViewById(R.id.cateoryimage);
        this.imagetick=(ImageView)itemView.findViewById(R.id.tickimage);
        this.cardView=(CardView)itemView.findViewById(R.id.cateorycard);
    }
}
    public InspectionCategoryAdapter(ArrayList<CategoryDataModal> data,ArrayList<Boolean> checks,Activity context) {
        this.checks=checks;
        this.dataSet = data;
        this.activity=activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_inspectioncard, parent, false);

        view.setOnClickListener(InspectionCategories.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView catname;
        ImageView imagecat;
        ImageView imagetick;
        CardView cardView;
        RelativeLayout relativeLayout;
        catname=holder.catname;
        imagecat=holder.imagecat;
        imagetick=holder.imagetick;
        cardView=holder.cardView;
        relativeLayout=holder.relativeLayout;
        catname.setText(dataSet.get(listPosition).getCatname());
        imagecat.setImageResource(dataSet.get(listPosition).getImage());
        if(checks.get(listPosition)==true) {
            imagetick.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

