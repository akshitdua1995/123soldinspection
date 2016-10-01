package com.a123sold.a123soldinspection.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a123sold.a123soldinspection.Helpers.JsonRequest;
import com.a123sold.a123soldinspection.Helpers.ViewsVisibility;
import com.a123sold.a123soldinspection.InspectionCategories;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.NewRequestDataModal;

import java.util.ArrayList;

public class AssignedRequestAdapter extends RecyclerView.Adapter<AssignedRequestAdapter.MyViewHolder> {
    private static ArrayList<NewRequestDataModal> dataSet;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
                NewRequestDataModal data=dataSet.get(getAdapterPosition());
                removeAt(getAdapterPosition());
                if(dataSet.size()==0){
                    ViewsVisibility.PendingrelativeLayout.setVisibility(View.VISIBLE);
                }
                ViewsVisibility.pendingRequestAdapter.addData(data);
                Intent i=new Intent(ViewsVisibility.conextActivity, InspectionCategories.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("id", data.getId());
                i.putExtra("name",data.getUserName());
                i.putExtra("make",data.getMake());
                i.putExtra("model",data.getModel());
                i.putExtra("version",data.getVersion());
                i.putExtra("number",data.getMobileNumber());
                ViewsVisibility.conextActivity.startActivity(i);
            }
        }

    }
    public AssignedRequestAdapter(ArrayList<NewRequestDataModal> data) {
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
        startbutton=holder.startbutton;
        customermobilenumber=holder.customermobilenumber;
        imagecar=holder.imagecar;
        startbutton.setText("Start");
        requestid.setText(dataSet.get(listPosition).getId());
        requestid.setVisibility(View.GONE);
        make.setText(dataSet.get(listPosition).getMake());
        model.setText(dataSet.get(listPosition).getModel());
        version.setText(dataSet.get(listPosition).getVersion());
        year.setText(String.valueOf(dataSet.get(listPosition).getYear()));
        kms.setText(String.valueOf(dataSet.get(listPosition).getKmDriven())+"Kms");
        fueltype.setText(dataSet.get(listPosition).getFuelType());
        transmission.setText(dataSet.get(listPosition).getTransmission());
        owner.setText("Owners : "+String.valueOf(dataSet.get(listPosition).getNumberOfOwners()));
        location.setText(dataSet.get(listPosition).getAddress());
        customername.setText(dataSet.get(listPosition).getUserName());
        customermobilenumber.setText(dataSet.get(listPosition).getMobileNumber());
        JsonRequest jsonRequest=new JsonRequest(ViewsVisibility.conextActivity.getApplicationContext(),ViewsVisibility.conextActivity);
        jsonRequest.LoadImage(dataSet.get(listPosition).getImageUrl(),imagecar);
        //imagecar.setImageResource(dataSet.get(listPosition).getImage());
    }
    public void addData(NewRequestDataModal data){
        Log.d("beforeSize",String.valueOf((dataSet.size())));
        dataSet.add(data);
        notifyDataSetChanged();
        notifyItemInserted(0);
        notifyItemRangeChanged(0,dataSet.size());
        ViewsVisibility.AssignedrelativeLayout.setVisibility(View.GONE);
        Log.d("Size",String.valueOf((dataSet.size())));
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void removeAt(int position) {
        dataSet.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, dataSet.size());
    }
}

