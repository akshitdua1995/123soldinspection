package com.a123sold.a123soldinspection.Fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.HistoryModal;

import java.io.IOException;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by akshit on 24/7/16.
 */
public class HistoryFragment extends android.app.Fragment implements View.OnClickListener {
    static SQLiteDatabase db;
    HelperFormsFunctions helperFormsFunctions;
    private ImageView plusImage;
    private ImageView chasisImage;
    private CheckBox checkBoxvininspection;
    private CheckBox checkBoxservicerecall;
    private CheckBox checkBoxhistoryreport;
    private CheckBox checkBoxschedulemantainence;
    private CheckBox checkBoxvehicleemissions;
    private EditText editTextreplacementcost;
    private EditText editTextreplacement;
    private Button savehistory;

    Float OLDCOST;
    String id;
    Integer VIN ;
    Integer SERVICERECALL ;
    Integer VEHICLEHISTORYREPORT ;
    Integer SCHEDULEDMAINTENANCE ;
    Integer VEHICLEEMISSIONS ;
    Float REPAIRINGCOSTHISTORY ;
    String COMMENTHISTORY ;

    private void findViews(View rootView) {
        id=getActivity().getIntent().getExtras().getString("id");
        Log.d("id",id);
        plusImage = (ImageView)rootView.findViewById( R.id.plusImage );
        chasisImage = (ImageView)rootView.findViewById( R.id.chasisImage );
        checkBoxvininspection = (CheckBox)rootView.findViewById( R.id.checkBoxvininspection );
        checkBoxservicerecall = (CheckBox)rootView.findViewById( R.id.checkBoxservicerecall );
        checkBoxhistoryreport = (CheckBox)rootView.findViewById( R.id.checkBoxhistoryreport );
        checkBoxschedulemantainence = (CheckBox)rootView.findViewById( R.id.checkBoxschedulemantainence );
        checkBoxvehicleemissions = (CheckBox)rootView.findViewById( R.id.checkBoxvehicleemissions );
        editTextreplacementcost = (EditText)rootView.findViewById( R.id.editTextreplacementcost );
        editTextreplacement = (EditText)rootView.findViewById( R.id.editTextreplacement );
        savehistory = (Button)rootView.findViewById( R.id.savehistory );
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        db = dbHelper.getWritableDatabase();
        savehistory.setOnClickListener(this);
        plusImage.setOnClickListener(this);
        chasisImage.setOnClickListener(this);
        HelperFormsFunctions.setButton(savehistory);
    }
    private void captureimage(int code) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,"data");
        startActivityForResult(cameraIntent, code);
    }

    @Override
    public void onClick(View v) {
        if ( v == savehistory ) {
            mapvalues();
            mapcarprogressvalues();
            HistoryModal historyModal=new HistoryModal(id,VIN,SERVICERECALL,VEHICLEHISTORYREPORT,SCHEDULEDMAINTENANCE,VEHICLEEMISSIONS,REPAIRINGCOSTHISTORY,COMMENTHISTORY);
            HistoryModal historyModalold = cupboard().withDatabase(db).query(HistoryModal.class).withSelection( "id = ?",id).get();
            if(historyModalold==null) {
                Toast.makeText(getActivity(),"Save Successfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(historyModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Successfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(HistoryModal.class, "id = ?",id);
                cupboard().withDatabase(db).put(historyModal);
            }
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
            db.close();
            getActivity().finish();
        }else{
            captureimage(1);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {;
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            switch (requestCode){
                case 1:
                    chasisImage.setImageBitmap(photo);
                    try {
                        helperFormsFunctions.saveToInternalStorage(photo,1,id,Config.historyimg+"chasis");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("id=?",id).get();
        if(carprogressModal.getHISTORYCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("HISTORYCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTHISTORY=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTHISTORY);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
    }

    void mapvalues(){
        VIN=helperFormsFunctions.returnCheckboxValue(checkBoxvininspection);
        SERVICERECALL=helperFormsFunctions.returnCheckboxValue(checkBoxservicerecall);
        VEHICLEHISTORYREPORT=helperFormsFunctions.returnCheckboxValue(checkBoxhistoryreport);
        SCHEDULEDMAINTENANCE=helperFormsFunctions.returnCheckboxValue(checkBoxschedulemantainence);
        VEHICLEEMISSIONS=helperFormsFunctions.returnCheckboxValue(checkBoxvehicleemissions);
        try {
            REPAIRINGCOSTHISTORY = Float.parseFloat(editTextreplacementcost.getText().toString());
        }catch (Exception e){
        }
        COMMENTHISTORY=editTextreplacement.getText().toString();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.history_form,container, false);
        findViews(rootView);
        returnchanges();
        return rootView;
    }


    private void returnchanges() {
        HistoryModal historyModal = cupboard().withDatabase(db).query(HistoryModal.class).withSelection("id=?",id).get();
        if(historyModal!=null){
            checkBoxvininspection.setChecked(helperFormsFunctions.returnCheckboxValue(historyModal.getVIN()));;
            checkBoxservicerecall.setChecked(helperFormsFunctions.returnCheckboxValue(historyModal.getSERVICERECALL()));;
            checkBoxhistoryreport.setChecked(helperFormsFunctions.returnCheckboxValue(historyModal.getVEHICLEHISTORYREPORT()));;
            checkBoxschedulemantainence.setChecked(helperFormsFunctions.returnCheckboxValue(historyModal.getSCHEDULEDMAINTENANCE()));;
            checkBoxvehicleemissions.setChecked(helperFormsFunctions.returnCheckboxValue(historyModal.getVEHICLEEMISSIONS()));;
            editTextreplacement.setText(historyModal.getCOMMENTHISTORY());
            if(historyModal.getREPAIRINGCOSTHISTORY()!=null) {
                editTextreplacementcost.setText(String.valueOf(historyModal.getREPAIRINGCOSTHISTORY()));
                OLDCOST=historyModal.getREPAIRINGCOSTHISTORY();
            }else{
                OLDCOST=0f;
            }
            helperFormsFunctions.loadImageFromStorage(chasisImage,1,id,Config.historyimg+"chasis");
        }else{
            OLDCOST=0f;
        }
    }


}
