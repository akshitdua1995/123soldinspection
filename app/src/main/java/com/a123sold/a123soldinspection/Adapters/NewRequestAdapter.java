package com.a123sold.a123soldinspection.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.NewRequestDataModal;

import java.util.ArrayList;

public class NewRequestAdapter extends RecyclerView.Adapter<NewRequestAdapter.MyViewHolder> {
    private ArrayList<NewRequestDataModal> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView requestid,make,model,version,year,kms,fueltype,transmission,owner,location,customername,customermobilenumber;
        ImageView imagecar;
        Button startbutton;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.requestid=(TextView)itemView.findViewById(R.id.requestid);
            this.make=(TextView)itemView.findViewById(R.id.carmaker);
            this.model=(TextView)itemView.findViewById(R.id.carmodel);
            this.version=(TextView)itemView.findViewById(R.id.carversion);
            this.year=(TextView)itemView.findViewById(R.id.buyyear);
            this.kms=(TextView)itemView.findViewById(R.id.kilometers);
            this.fueltype=(TextView)itemView.findViewById(R.id.fueltype);
            this.transmission=(TextView)itemView.findViewById(R.id.transmission);
            this.owner=(TextView)itemView.findViewById(R.id.carowner);
            this.location=(TextView)itemView.findViewById(R.id.carlocation);
            this.customername=(TextView)itemView.findViewById(R.id.customername);
            this.customermobilenumber=(TextView)itemView.findViewById(R.id.customernumber);
            this.imagecar=(ImageView)itemView.findViewById(R.id.carimage);
            this.startbutton=(Button)itemView.findViewById(R.id.acceptbutton);
            this.startbutton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v==this.startbutton){
                int itemposition=getAdapterPosition();
                Log.d("name",this.customername.getText().toString());
            }
        }
    }
    public NewRequestAdapter(ArrayList<NewRequestDataModal> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inspection_card, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView requestid,make,model,version,year,kms,fueltype,transmission,owner,location,customername,customermobilenumber;
        ImageView imagecar;
        Button startbutton;
        requestid=holder.requestid;
        make=holder.make;
        model=holder.model;
        version=holder.version;
        year=holder.year;
        kms=holder.kms;
        fueltype=holder.fueltype;
        transmission=holder.transmission;
        owner=holder.owner;
        location=holder.location;
        customername=holder.customername;
        customermobilenumber=holder.customermobilenumber;
        imagecar=holder.imagecar;
        requestid.setText("#"+"1");
        make.setText(dataSet.get(listPosition).getMake());
        model.setText(dataSet.get(listPosition).getModel());
        version.setText(dataSet.get(listPosition).getversion());
        year.setText(dataSet.get(listPosition).getYear());
        kms.setText(dataSet.get(listPosition).getKms());
        fueltype.setText(dataSet.get(listPosition).getFueltype());
        transmission.setText(dataSet.get(listPosition).getTransmission());
        owner.setText(dataSet.get(listPosition).getOwner());
        location.setText(dataSet.get(listPosition).getLocation());
        customername.setText(dataSet.get(listPosition).getCustomername());
        customermobilenumber.setText(dataSet.get(listPosition).getCustomermobilenumber());
        imagecar.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

