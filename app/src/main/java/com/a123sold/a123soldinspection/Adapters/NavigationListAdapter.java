package com.a123sold.a123soldinspection.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a123sold.a123soldinspection.R;


public class NavigationListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private int mSelectedItem;

    public NavigationListAdapter(Activity context, String[] itemname,Integer[]imgid) {
        super(context, R.layout.navlist, itemname);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.navlist, null,true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.navtext);
        ImageView imgIcon=(ImageView) rowView.findViewById(R.id.navicon);
        txtTitle.setText(itemname[position]);
        imgIcon.setImageResource(imgid[position]);
        return rowView;

    };
}
