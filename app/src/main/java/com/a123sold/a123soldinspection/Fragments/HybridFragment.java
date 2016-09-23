package com.a123sold.a123soldinspection.Fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.HybridformModal;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by akshit on 24/7/16.
 */
public class HybridFragment extends android.app.Fragment implements View.OnClickListener {
    static SQLiteDatabase db;
    private CheckBox checkBoxhybridcoolingsystem;
    private CheckBox checkBoxswitchableport;
    private CheckBox checkBoxhybridentertainment;
    private CheckBox checkBoxpoweroutlet;
    private EditText editTextreplacementcost;
    private EditText editTextreplacement;
    private Button savehybrid;
    HelperFormsFunctions helperFormsFunctions;

    String id;
    Integer HYBRIDCOOLINGSYSTEM;
    Integer SWITCHABLEPOWERTRAINMOUNT;
    Integer HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY;
    Integer POWEROUTLET;
    Float REPAIRINGCOSTHYBRID;
    String COMMENTHYBRID;
    Float OLDCOST;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hybrid_form,container, false);
        findViews(rootView);
        returnchanges();
        return rootView;
    }

    private void findViews(View rootview) {
        id=getActivity().getIntent().getExtras().getString("id");
        Log.d("id",id);
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
        checkBoxhybridcoolingsystem = (CheckBox)rootview.findViewById( R.id.checkBoxhybridcoolingsystem );
        checkBoxswitchableport = (CheckBox)rootview.findViewById( R.id.checkBoxswitchableport );
        checkBoxhybridentertainment = (CheckBox)rootview.findViewById( R.id.checkBoxhybridentertainment );
        checkBoxpoweroutlet = (CheckBox)rootview.findViewById( R.id.checkBoxpoweroutlet );
        editTextreplacementcost = (EditText)rootview.findViewById( R.id.editTextreplacementcost );
        editTextreplacement = (EditText)rootview.findViewById( R.id.editTextreplacement );
        savehybrid = (Button)rootview.findViewById( R.id.savehybrid );
        savehybrid.setOnClickListener( this );
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        db = dbHelper.getWritableDatabase();
        HelperFormsFunctions.setButton(savehybrid);
    }

    void returnchanges(){
        HybridformModal hybridformModal = cupboard().withDatabase(db).query(HybridformModal.class).withSelection("id=?",id).get();
        if(hybridformModal!=null){
            checkBoxhybridcoolingsystem.setChecked(helperFormsFunctions.returnCheckboxValue(hybridformModal.getHYBRIDCOOLINGSYSTEM()));
            checkBoxswitchableport.setChecked(helperFormsFunctions.returnCheckboxValue(hybridformModal.getSWITCHABLEPOWERTRAINMOUNT()));
            checkBoxhybridentertainment.setChecked(helperFormsFunctions.returnCheckboxValue(hybridformModal.getHYBRIDENTERTAINMENTANDINFORMATIONDISPLAY()));
            checkBoxpoweroutlet.setChecked(helperFormsFunctions.returnCheckboxValue(hybridformModal.getPOWEROUTLET()));
            editTextreplacement.setText(hybridformModal.getCOMMENTHYBRID());
            if(hybridformModal.getREPAIRINGCOSTHYBRID()!=null) {
                editTextreplacementcost.setText(String.valueOf(hybridformModal.getREPAIRINGCOSTHYBRID()));
                OLDCOST=hybridformModal.getREPAIRINGCOSTHYBRID();
            }else{
                OLDCOST=0f;
            }
        }else{
            OLDCOST=0f;
        }

    }
    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("id=?",id).get();
        if(carprogressModal.getHYBRIDCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("HYBRIDCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTHYBRID=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTHYBRID);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
    }
    @Override
    public void onClick(View v) {
        if ( v == savehybrid ) {
            mapvalues();
            HybridformModal hybridformModal=new HybridformModal(id, HYBRIDCOOLINGSYSTEM,
            SWITCHABLEPOWERTRAINMOUNT,
            HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY,
            POWEROUTLET,
            REPAIRINGCOSTHYBRID,
            COMMENTHYBRID);
            HybridformModal hybridModalold = cupboard().withDatabase(db).query(HybridformModal.class).withSelection( "id = ?", id).get();
            if(hybridModalold==null) {
                Toast.makeText(getActivity(),"Save Successfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(hybridformModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Successfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(HybridformModal.class, "id = ?", id);
                cupboard().withDatabase(db).put(hybridformModal);
            }
            mapcarprogressvalues();
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            db.close();
            getActivity().finish();
        }
    }

    void mapvalues(){
        HYBRIDCOOLINGSYSTEM=helperFormsFunctions.returnCheckboxValue(checkBoxhybridcoolingsystem);
        SWITCHABLEPOWERTRAINMOUNT=helperFormsFunctions.returnCheckboxValue(checkBoxswitchableport);
        HYBRIDENTERTAINMENTANDINFORMATIONDISPLAY=helperFormsFunctions.returnCheckboxValue(checkBoxhybridentertainment);
        POWEROUTLET=helperFormsFunctions.returnCheckboxValue(checkBoxpoweroutlet);
        try {
            REPAIRINGCOSTHYBRID = Float.parseFloat(editTextreplacementcost.getText().toString());
        }catch (Exception e){
        }
            COMMENTHYBRID=editTextreplacement.getText().toString();
    }


}
