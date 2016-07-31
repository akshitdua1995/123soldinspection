package com.a123sold.a123soldinspection.Fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
    Integer CARID;
    Integer VIN ;
    Integer SERVICERECALL ;
    Integer VEHICLEHISTORYREPORT ;
    Integer SCHEDULEDMAINTENANCE ;
    Integer VEHICLEEMISSIONS ;
    Float REPAIRINGCOSTHISTORY ;
    String COMMENTHISTORY ;

    private void findViews(View rootView) {
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
    }


    @Override
    public void onClick(View v) {
        if ( v == savehistory ) {
            mapvalues();
            mapcarprogressvalues();
            HistoryModal historyModal=new HistoryModal(CARID,VIN,SERVICERECALL,VEHICLEHISTORYREPORT,SCHEDULEDMAINTENANCE,VEHICLEEMISSIONS,REPAIRINGCOSTHISTORY,COMMENTHISTORY);
            HistoryModal historyModalold = cupboard().withDatabase(db).query(HistoryModal.class).withSelection( "CARID = ?", "1").get();
            if(historyModalold==null) {
                Toast.makeText(getActivity(),"Save Successfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(historyModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Successfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(HistoryModal.class, "CARID = ?", "1");
                cupboard().withDatabase(db).put(historyModal);
            }
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
            db.close();
            getActivity().finish();
        }
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("CARID=1").get();
        if(carprogressModal.getHISTORYCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("HISTORYCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTHISTORY=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTHISTORY);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }
    }

    void mapvalues(){
        CARID=1;
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
        HistoryModal historyModal = cupboard().withDatabase(db).query(HistoryModal.class).withSelection("CARID=1").get();
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
        }else{
            OLDCOST=0f;
        }
    }


}