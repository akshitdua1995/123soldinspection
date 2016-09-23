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
import com.a123sold.a123soldinspection.modals.RoadtestModal;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by akshit on 24/7/16.
 */
public class RoadtestFragment extends android.app.Fragment implements View.OnClickListener {
    static SQLiteDatabase db;
    HelperFormsFunctions helperFormsFunctions;
    private CheckBox checkBoxenginestart;
    private CheckBox checkBoxengineidle;
    private CheckBox checkBoxremortstartsystem;
    private CheckBox checkBoxengineAccelerates;
    private CheckBox checkBoxenginenoisenormal;
    private CheckBox checkBoxcoldhotshiftquality;
    private CheckBox checkBoxaxlenoise;
    private CheckBox checkBoxshiftinterlockoperates;
    private CheckBox checkBoxdriveaxleopernoisenormal;
    private CheckBox checkBoxclutchoperates;
    private CheckBox checkBoxsteersnormally;
    private CheckBox checkBoxbodysuspension;
    private CheckBox checkBoxstrutsshocks;
    private CheckBox checkBoxbrakesoperation;
    private CheckBox checkBoxcruisecontrol;
    private CheckBox checkBoxgaugework;
    private CheckBox checkBoxmemoryprofile;
    private CheckBox checkBoxnoabnormalwindnoise;
    private EditText editTextreplacementcost;
    private EditText editTextreplacement;
    private Button saveroadtest;

    String id;
    Integer ENGINESTARTPROPERLY ;
    Integer ENGINEIDLESPROPERLY ;
    Integer REMOTESTARTSYSTEM ;
    Integer ENGINEACCELERATES ;
    Integer ENGINENOISE ;
    Integer TRANSAXLEOPERATION ;
    Integer TRANSAXLENOISENORMAL ;
    Integer SHIFTINTERLOCK ;
    Integer DRIVEAXLE ;
    Integer CLUTCHOPERATE ;
    Integer STEERSNORMALLY ;
    Integer BODYSQUEAKS ;
    Integer SHOCKESOPERATES ;
    Integer BRAKESOPERATES ;
    Integer CRUISECONTROL ;
    Integer GAUGESOPERATEPROPERLY ;
    Integer MEMORYPROFILESYSTEM ;
    Integer NOWINDNOISE ;
    Float REPAIRINGCOSTROADTEST ;
    String COMMENTROADTEST ;
    Float OLDCOST;

    private void findViews(View rootView) {
        id=getActivity().getIntent().getExtras().getString("id");
        Log.d("id",id);
        checkBoxenginestart = (CheckBox)rootView.findViewById( R.id.checkBoxenginestart );
        checkBoxengineidle = (CheckBox)rootView.findViewById( R.id.checkBoxengineidle );
        checkBoxremortstartsystem = (CheckBox)rootView.findViewById( R.id.checkBoxremortstartsystem );
        checkBoxengineAccelerates = (CheckBox)rootView.findViewById( R.id.checkBoxengineAccelerates );
        checkBoxenginenoisenormal = (CheckBox)rootView.findViewById( R.id.checkBoxenginenoisenormal );
        checkBoxcoldhotshiftquality = (CheckBox)rootView.findViewById( R.id.checkBoxcoldhotshiftquality );
        checkBoxaxlenoise = (CheckBox)rootView.findViewById( R.id.checkBoxaxlenoise );
        checkBoxshiftinterlockoperates = (CheckBox)rootView.findViewById( R.id.checkBoxshiftinterlockoperates );
        checkBoxdriveaxleopernoisenormal = (CheckBox)rootView.findViewById( R.id.checkBoxdriveaxleopernoisenormal );
        checkBoxclutchoperates = (CheckBox)rootView.findViewById( R.id.checkBoxclutchoperates );
        checkBoxsteersnormally = (CheckBox)rootView.findViewById( R.id.checkBoxsteersnormally );
        checkBoxbodysuspension = (CheckBox)rootView.findViewById( R.id.checkBoxbodysuspension );
        checkBoxstrutsshocks = (CheckBox)rootView.findViewById( R.id.checkBoxstrutsshocks );
        checkBoxbrakesoperation = (CheckBox)rootView.findViewById( R.id.checkBoxbrakesoperation );
        checkBoxcruisecontrol = (CheckBox)rootView.findViewById( R.id.checkBoxcruisecontrol );
        checkBoxgaugework = (CheckBox)rootView.findViewById( R.id.checkBoxgaugework );
        checkBoxmemoryprofile = (CheckBox)rootView.findViewById( R.id.checkBoxmemoryprofile );
        checkBoxnoabnormalwindnoise = (CheckBox)rootView.findViewById( R.id.checkBoxnoabnormalwindnoise );
        editTextreplacementcost = (EditText)rootView.findViewById( R.id.editTextreplacementcost );
        editTextreplacement = (EditText)rootView.findViewById( R.id.editTextreplacement );
        saveroadtest = (Button)rootView.findViewById(R.id.saveroadtest);
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        db = dbHelper.getWritableDatabase();
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
        saveroadtest.setOnClickListener(this);
        HelperFormsFunctions.setButton(saveroadtest);
    }

    
    @Override
    public void onClick(View v) {
        if ( v == saveroadtest ) {
            mapvalues();
            mapcarprogressvalues();
            RoadtestModal roadtestModal=new    
            RoadtestModal(id,ENGINESTARTPROPERLY,ENGINEIDLESPROPERLY,REMOTESTARTSYSTEM,ENGINEACCELERATES,ENGINENOISE
                ,TRANSAXLEOPERATION,TRANSAXLENOISENORMAL,SHIFTINTERLOCK,DRIVEAXLE,CLUTCHOPERATE,STEERSNORMALLY,BODYSQUEAKS
                ,SHOCKESOPERATES,BRAKESOPERATES,CRUISECONTROL,GAUGESOPERATEPROPERLY,MEMORYPROFILESYSTEM,NOWINDNOISE,REPAIRINGCOSTROADTEST,COMMENTROADTEST);
            RoadtestModal roadtestModalold = cupboard().withDatabase(db).query(RoadtestModal.class).withSelection( "id = ?", id).get();
            if(roadtestModalold==null) {
                Toast.makeText(getActivity(),"Save Successfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(roadtestModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Successfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(RoadtestModal.class, "id = ?", id);
                cupboard().withDatabase(db).put(roadtestModal);
            }
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            db.close();
            getActivity().finish();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.roadtest_form,container, false);
        findViews(rootView);
        returnchanges();
        return rootView;
    }
    void returnchanges(){
        RoadtestModal roadtestModal = cupboard().withDatabase(db).query(RoadtestModal.class).withSelection("id=?",id).get();
        if(roadtestModal!=null){
            checkBoxenginestart.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getENGINESTARTPROPERLY()));
            checkBoxengineidle.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getENGINEIDLESPROPERLY()));
            checkBoxremortstartsystem.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getREMOTESTARTSYSTEM()));
            checkBoxengineAccelerates.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getENGINEACCELERATES()));
            checkBoxenginenoisenormal.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getENGINENOISE()));
            checkBoxcoldhotshiftquality.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getTRANSAXLEOPERATION()));
            checkBoxaxlenoise.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getTRANSAXLENOISENORMAL()));
            checkBoxshiftinterlockoperates.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getSHIFTINTERLOCK()));
            checkBoxdriveaxleopernoisenormal.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getDRIVEAXLE()));
            checkBoxclutchoperates.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getCLUTCHOPERATE()));
            checkBoxsteersnormally.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getSTEERSNORMALLY()));
            checkBoxbodysuspension.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getBODYSQUEAKS()));
            checkBoxstrutsshocks.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getSHOCKESOPERATES()));
            checkBoxbrakesoperation.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getBRAKESOPERATES()));
            checkBoxcruisecontrol.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getCRUISECONTROL()));
            checkBoxgaugework.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getGAUGESOPERATEPROPERLY()));
            checkBoxmemoryprofile.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getMEMORYPROFILESYSTEM()));
            checkBoxnoabnormalwindnoise.setChecked(helperFormsFunctions.returnCheckboxValue(roadtestModal.getNOWINDNOISE()));
            if(roadtestModal.getREPAIRINGCOSTROADTEST()!=null) {
                editTextreplacementcost.setText(String.valueOf(roadtestModal.getREPAIRINGCOSTROADTEST()));
                OLDCOST=roadtestModal.getREPAIRINGCOSTROADTEST();
            }else{
                OLDCOST=0f;
            }
            editTextreplacement.setText(roadtestModal.getCOMMENTROADTEST());
        }else
        {
            OLDCOST=0f;
        }
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("id=?",id).get();
        if(carprogressModal.getROADTESTCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("ROADTESTCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTROADTEST=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTROADTEST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
    }
    void mapvalues(){
        ENGINESTARTPROPERLY = helperFormsFunctions.returnCheckboxValue(checkBoxenginestart);
        ENGINEIDLESPROPERLY = helperFormsFunctions.returnCheckboxValue(checkBoxengineidle);
        REMOTESTARTSYSTEM = helperFormsFunctions.returnCheckboxValue(checkBoxremortstartsystem);
        ENGINEACCELERATES = helperFormsFunctions.returnCheckboxValue(checkBoxengineAccelerates);
        ENGINENOISE = helperFormsFunctions.returnCheckboxValue(checkBoxenginenoisenormal);
        TRANSAXLEOPERATION = helperFormsFunctions.returnCheckboxValue(checkBoxcoldhotshiftquality);
        TRANSAXLENOISENORMAL = helperFormsFunctions.returnCheckboxValue(checkBoxaxlenoise);
        SHIFTINTERLOCK = helperFormsFunctions.returnCheckboxValue(checkBoxshiftinterlockoperates);
        DRIVEAXLE = helperFormsFunctions.returnCheckboxValue(checkBoxdriveaxleopernoisenormal);
        CLUTCHOPERATE = helperFormsFunctions.returnCheckboxValue(checkBoxclutchoperates);
        STEERSNORMALLY = helperFormsFunctions.returnCheckboxValue(checkBoxsteersnormally);
        BODYSQUEAKS = helperFormsFunctions.returnCheckboxValue(checkBoxbodysuspension);
        SHOCKESOPERATES = helperFormsFunctions.returnCheckboxValue(checkBoxstrutsshocks);
        BRAKESOPERATES = helperFormsFunctions.returnCheckboxValue(checkBoxbrakesoperation);
        CRUISECONTROL = helperFormsFunctions.returnCheckboxValue(checkBoxcruisecontrol);
        GAUGESOPERATEPROPERLY = helperFormsFunctions.returnCheckboxValue(checkBoxgaugework);
        MEMORYPROFILESYSTEM = helperFormsFunctions.returnCheckboxValue(checkBoxmemoryprofile);
        NOWINDNOISE = helperFormsFunctions.returnCheckboxValue(checkBoxnoabnormalwindnoise);
        try {
            REPAIRINGCOSTROADTEST=Float.valueOf(editTextreplacementcost.getText().toString());
        }catch (Exception e){}
        COMMENTROADTEST=editTextreplacement.getText().toString();
    }
}
