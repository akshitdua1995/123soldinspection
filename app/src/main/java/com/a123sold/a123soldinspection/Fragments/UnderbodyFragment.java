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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.UnderbodyformModal;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;



public class UnderbodyFragment extends android.app.Fragment implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private SeekBar seekBarAirpressureFrontTires;
    private SeekBar seekBarAirpressureBackTires;
    TextView progress1,progress2;
    TextView feedbackprogress1,feedbackprogress2;
    HelperFormsFunctions helperFormsFunctions;
    private RadioGroup radioButtonframedamage;
    static SQLiteDatabase db;
    private RadioButton radioButtonframedamageyes;
    private RadioButton radioButtonframedamageno;
    private CheckBox checkBoxFuelSupply;
    private CheckBox checkBoxexhaustsystemcondition;
    private CheckBox checkBoxexhaustcontroltest;
    private CheckBox checkBoxautomatictransmission;
    private CheckBox checkBoxmanualtransmission;
    private CheckBox checkBoxhuboperation;
    private CheckBox checkBoxuniversaljoints;
    private CheckBox checkBoxtransmissionmounts;
    private CheckBox checkBoxdriveaxle;
    private CheckBox checkBoxtiresmatch;
    private CheckBox checkBoxwheelsmatch;
    private EditText editTexttirethreaddepthfront;
    private EditText editTexttirethreaddepthrear;
    private EditText editTextnormaltierwear;
    private EditText editTexttirePressureMonitoring;
    private CheckBox checkBoxWheels;
    private CheckBox checkBoxwheelcovers;
    private CheckBox checkBoxrackandpinion;
    private CheckBox checkBoxcontrolarms;
    private CheckBox checkBoxtierods;
    private CheckBox checkBoxswaybars;
    private CheckBox checkBoxsprings;
    private CheckBox checkBoxstrutsshocks;
    private CheckBox checkBoxwheelalignment;
    private CheckBox checkBoxpowersteeringpump;
    private CheckBox checkBoxcalipersandwheel;
    private CheckBox checkBoxfrontbrakes;
    private CheckBox checkBoxrearbrakes;
    private CheckBox checkBoxrotordrums;
    private CheckBox checkBoxbrakelines;
    private CheckBox checkBoxtransfercasefluid;
    private CheckBox checkBoxmastercylendir;
    private EditText editTextreplacementcost;
    private EditText editTextreplacement;
    private Button saveunderbody;

    String id;
    Integer FRAMEDAMAGE ;
    Integer FUELSUPPLYSYSTEM ;
    Integer EXHAUSTSYSTEMCONDITION ;
    Integer EMISSIONSCONTROLTEST ;
    Integer AUTOMATICTRANSMISSION ;
    Integer MANUALTRANSMISSION;
    Integer HUBOPERATION ;
    Integer UNIVERSALJOINTS ;
    Integer TRANSMISSIONMOUNTS ;
    Integer DIFFERNTIALDRIVEAXLE ;
    Integer TIRESMATCH ;
    Integer WHEELSMATCH ;
    String TIREDEPTHFRONT ;
    String TIREDEPTHREAR ;
    String NORMALTIREWEAR ;
    Integer TIREPRESSUREFRONT ;
    Integer TIREPRESSUREBACK ;
    String TIREPRESSUREMONITOR ;
    Integer WHEELS ;
    Integer WHEELCOVERANDCENTERCAPS ;
    Integer RACKPINION ;
    Integer CONTROLARMS ;
    Integer TIERODS ;
    Integer SWAYBARS ;
    Integer SPRINGS ;
    Integer STRUTSANDSHOCKS ;
    Integer WHEELALIGNMENT ;
    Integer POWERSTEERINGPUMP ;
    Integer WHEELSCYLENDIRS ;
    Integer BRAKEPADFRONT ;
    Integer BRAKEPADREAR ;
    Integer ROTORSANDDRUMS;
    Integer BRAKELINES ;
    Integer PARKINGBRAKE ;
    Integer MASTERCYLENDIRBOOSTER ;
    Float REPAIRINGCOSTUNDERBODY ;
    String COMMENTUNDERBODY ;
    Float OLDCOST;

    private void findViews(View view) {
        id=getActivity().getIntent().getExtras().getString("id");
        Log.d("id",id);
        radioButtonframedamage = (RadioGroup)view.findViewById( R.id.radioButtonframedamage );
        radioButtonframedamageyes = (RadioButton)view.findViewById( R.id.radioButtonframedamageyes );
        radioButtonframedamageno = (RadioButton)view.findViewById( R.id.radioButtonframedamageno );
        checkBoxFuelSupply = (CheckBox)view.findViewById( R.id.checkBoxFuelSupply );
        checkBoxexhaustsystemcondition = (CheckBox)view.findViewById( R.id.checkBoxexhaustsystemcondition );
        checkBoxexhaustcontroltest = (CheckBox)view.findViewById( R.id.checkBoxexhaustcontroltest );
        checkBoxautomatictransmission = (CheckBox)view.findViewById( R.id.checkBoxautomatictransmission );
        checkBoxmanualtransmission = (CheckBox)view.findViewById( R.id.checkBoxmanualtransmission );
        checkBoxhuboperation = (CheckBox)view.findViewById( R.id.checkBoxhuboperation );
        checkBoxuniversaljoints = (CheckBox)view.findViewById( R.id.checkBoxuniversaljoints );
        checkBoxtransmissionmounts = (CheckBox)view.findViewById( R.id.checkBoxtransmissionmounts );
        checkBoxdriveaxle = (CheckBox)view.findViewById( R.id.checkBoxdriveaxle );
        checkBoxtiresmatch = (CheckBox)view.findViewById( R.id.checkBoxtiresmatch );
        checkBoxwheelsmatch = (CheckBox)view.findViewById( R.id.checkBoxwheelsmatch );
        editTexttirethreaddepthfront = (EditText)view.findViewById( R.id.editTexttirethreaddepthfront );
        editTexttirethreaddepthrear = (EditText)view.findViewById( R.id.editTexttirethreaddepthrear );
        editTextnormaltierwear = (EditText)view.findViewById( R.id.editTextnormaltierwear );
        editTexttirePressureMonitoring = (EditText)view.findViewById( R.id.editTexttirePressureMonitoring );
        checkBoxWheels = (CheckBox)view.findViewById( R.id.checkBoxWheels );
        checkBoxwheelcovers = (CheckBox)view.findViewById( R.id.checkBoxwheelcovers );
        checkBoxrackandpinion = (CheckBox)view.findViewById( R.id.checkBoxrackandpinion );
        checkBoxcontrolarms = (CheckBox)view.findViewById( R.id.checkBoxcontrolarms );
        checkBoxtierods = (CheckBox)view.findViewById( R.id.checkBoxtierods );
        checkBoxswaybars = (CheckBox)view.findViewById( R.id.checkBoxswaybars );
        checkBoxsprings = (CheckBox)view.findViewById( R.id.checkBoxsprings );
        checkBoxstrutsshocks = (CheckBox)view.findViewById( R.id.checkBoxstrutsshocks );
        checkBoxwheelalignment = (CheckBox)view.findViewById( R.id.checkBoxwheelalignment );
        checkBoxpowersteeringpump = (CheckBox)view.findViewById( R.id.checkBoxpowersteeringpump );
        checkBoxcalipersandwheel = (CheckBox)view.findViewById( R.id.checkBoxcalipersandwheel );
        checkBoxfrontbrakes = (CheckBox)view.findViewById( R.id.checkBoxfrontbrakes );
        checkBoxrearbrakes = (CheckBox)view.findViewById( R.id.checkBoxrearbrakes );
        checkBoxrotordrums = (CheckBox)view.findViewById( R.id.checkBoxrotordrums );
        checkBoxbrakelines = (CheckBox)view.findViewById( R.id.checkBoxbrakelines );
        checkBoxtransfercasefluid = (CheckBox)view.findViewById( R.id.checkBoxtransfercasefluid );
        checkBoxmastercylendir = (CheckBox)view.findViewById( R.id.checkBoxmastercylendir );
        editTextreplacementcost = (EditText)view.findViewById( R.id.editTextreplacementcost );
        editTextreplacement = (EditText)view.findViewById( R.id.editTextreplacement );
        saveunderbody = (Button)view.findViewById( R.id.saveunderbody );
        seekBarAirpressureFrontTires= (SeekBar) view.findViewById(R.id.seekBartirepressureFront);
        seekBarAirpressureBackTires= (SeekBar) view.findViewById(R.id.seekBartirepressureBack);
        seekBarAirpressureFrontTires.setOnSeekBarChangeListener(this);
        seekBarAirpressureBackTires.setOnSeekBarChangeListener(this);
        progress1=(TextView)view.findViewById(R.id.seekbarvalue1);
        progress2=(TextView)view.findViewById(R.id.seekbarvalue2);
        feedbackprogress1=(TextView)view.findViewById(R.id.seekbarvaluefeedback1);
        feedbackprogress2=(TextView)view.findViewById(R.id.seekbarvaluefeedback2);
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        db = dbHelper.getWritableDatabase();
        saveunderbody.setOnClickListener(this);
        HelperFormsFunctions.setButton(saveunderbody);
    }


    @Override
    public void onClick(View v) {
        if ( v == saveunderbody ) {
            mapvalues(v.getRootView());
            mapcarprogressvalues();
            UnderbodyformModal underbodyformModal=new UnderbodyformModal(id,FRAMEDAMAGE,FUELSUPPLYSYSTEM,EXHAUSTSYSTEMCONDITION
            ,EMISSIONSCONTROLTEST,AUTOMATICTRANSMISSION,MANUALTRANSMISSION,HUBOPERATION,UNIVERSALJOINTS,TRANSMISSIONMOUNTS,DIFFERNTIALDRIVEAXLE
            ,TIRESMATCH,WHEELSMATCH,TIREDEPTHFRONT,TIREDEPTHREAR,NORMALTIREWEAR,TIREPRESSUREFRONT,TIREPRESSUREBACK,TIREPRESSUREMONITOR,WHEELS,WHEELCOVERANDCENTERCAPS
            ,RACKPINION,CONTROLARMS,TIERODS,SWAYBARS,SPRINGS,STRUTSANDSHOCKS,WHEELALIGNMENT,POWERSTEERINGPUMP,WHEELSCYLENDIRS
            ,BRAKEPADFRONT,BRAKEPADREAR,ROTORSANDDRUMS,BRAKELINES,PARKINGBRAKE,MASTERCYLENDIRBOOSTER,REPAIRINGCOSTUNDERBODY,COMMENTUNDERBODY);
            UnderbodyformModal underbodyformModalold = cupboard().withDatabase(db).query(UnderbodyformModal.class).withSelection( "id = ?", id).get();
            if(underbodyformModalold==null) {
                Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(underbodyformModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Sucessfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(UnderbodyformModal.class, "id = ?", id);
                cupboard().withDatabase(db).put(underbodyformModal);
            }
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            db.close();
            getActivity().finish();
        }
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("id=?",id).get();
        if(carprogressModal.getUNDERBODYCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("UNDERBODYCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTUNDERBODY=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTUNDERBODY);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
    }
    
    void mapvalues(View view){
        FRAMEDAMAGE= helperFormsFunctions.returnRadioGroup(radioButtonframedamage,view);
        FUELSUPPLYSYSTEM=helperFormsFunctions.returnCheckboxValue(checkBoxFuelSupply); 
        EXHAUSTSYSTEMCONDITION=helperFormsFunctions.returnCheckboxValue(checkBoxexhaustsystemcondition);
        EMISSIONSCONTROLTEST=helperFormsFunctions.returnCheckboxValue(checkBoxexhaustcontroltest);
        AUTOMATICTRANSMISSION=helperFormsFunctions.returnCheckboxValue(checkBoxautomatictransmission);
        MANUALTRANSMISSION=helperFormsFunctions.returnCheckboxValue(checkBoxmanualtransmission);
        HUBOPERATION=helperFormsFunctions.returnCheckboxValue(checkBoxhuboperation);
        UNIVERSALJOINTS=helperFormsFunctions.returnCheckboxValue(checkBoxuniversaljoints);
        TRANSMISSIONMOUNTS=helperFormsFunctions.returnCheckboxValue(checkBoxtransmissionmounts);
        DIFFERNTIALDRIVEAXLE=helperFormsFunctions.returnCheckboxValue(checkBoxdriveaxle);
        TIRESMATCH=helperFormsFunctions.returnCheckboxValue(checkBoxtiresmatch);
        WHEELSMATCH=helperFormsFunctions.returnCheckboxValue(checkBoxwheelsmatch);
        TIREDEPTHFRONT=editTexttirethreaddepthfront.getText().toString();
        TIREDEPTHREAR=editTexttirethreaddepthrear.getText().toString();
        NORMALTIREWEAR=editTextnormaltierwear.getText().toString();
        TIREPRESSUREFRONT=seekBarAirpressureFrontTires.getProgress();
        TIREPRESSUREBACK=seekBarAirpressureBackTires.getProgress();
        TIREPRESSUREMONITOR=editTexttirePressureMonitoring.getText().toString();
        WHEELS=helperFormsFunctions.returnCheckboxValue(checkBoxWheels);
        WHEELCOVERANDCENTERCAPS=helperFormsFunctions.returnCheckboxValue(checkBoxwheelcovers);
        RACKPINION=helperFormsFunctions.returnCheckboxValue(checkBoxrackandpinion);
        CONTROLARMS=helperFormsFunctions.returnCheckboxValue(checkBoxcontrolarms);
        TIERODS=helperFormsFunctions.returnCheckboxValue(checkBoxtierods);
        SWAYBARS=helperFormsFunctions.returnCheckboxValue(checkBoxswaybars);
        SPRINGS=helperFormsFunctions.returnCheckboxValue(checkBoxsprings);
        STRUTSANDSHOCKS=helperFormsFunctions.returnCheckboxValue(checkBoxstrutsshocks);
        WHEELALIGNMENT=helperFormsFunctions.returnCheckboxValue(checkBoxwheelalignment);
        POWERSTEERINGPUMP=helperFormsFunctions.returnCheckboxValue(checkBoxpowersteeringpump);
        WHEELSCYLENDIRS=helperFormsFunctions.returnCheckboxValue(checkBoxcalipersandwheel);
        BRAKEPADFRONT=helperFormsFunctions.returnCheckboxValue(checkBoxfrontbrakes);
        BRAKEPADREAR=helperFormsFunctions.returnCheckboxValue(checkBoxrearbrakes);
        ROTORSANDDRUMS=helperFormsFunctions.returnCheckboxValue(checkBoxrotordrums);
        BRAKELINES=helperFormsFunctions.returnCheckboxValue(checkBoxbrakelines);
        PARKINGBRAKE=helperFormsFunctions.returnCheckboxValue(checkBoxtransfercasefluid);
        MASTERCYLENDIRBOOSTER=helperFormsFunctions.returnCheckboxValue(checkBoxmastercylendir);
        try {
            REPAIRINGCOSTUNDERBODY=Float.valueOf(editTextreplacementcost.getText().toString());
        }catch (Exception e){}
        COMMENTUNDERBODY=editTextreplacement.getText().toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.underbody_form, container, false);
        findViews(rootView);
        returnchanges();
        return rootView;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId()==seekBarAirpressureFrontTires.getId()){
            progress1.setText(String.valueOf(progress));
            feedbackprogress1.setText(helperFormsFunctions.returnFeedbackSeekBar(progress));
        }else{
            progress2.setText(String.valueOf(progress));
            feedbackprogress2.setText(helperFormsFunctions.returnFeedbackSeekBar(progress));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    void returnchanges(){
        UnderbodyformModal underbodyformModal = cupboard().withDatabase(db).query(UnderbodyformModal.class).withSelection("id=?",id).get();
        if(underbodyformModal!=null){
            helperFormsFunctions.setValueRadiobutton(radioButtonframedamage,radioButtonframedamageyes.getId(),radioButtonframedamageno.getId(),underbodyformModal.getFRAMEDAMAGE());
            checkBoxFuelSupply.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getFUELSUPPLYSYSTEM()));
            checkBoxexhaustsystemcondition.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getEXHAUSTSYSTEMCONDITION()));
            checkBoxexhaustcontroltest.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getEXHAUSTSYSTEMCONDITION()));
            checkBoxautomatictransmission.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getAUTOMATICTRANSMISSION()));
            checkBoxmanualtransmission.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getMANUALTRANSMISSION()));
            checkBoxhuboperation.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getHUBOPERATION()));
            checkBoxuniversaljoints.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getUNIVERSALJOINTS()));
            checkBoxtransmissionmounts.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getTRANSMISSIONMOUNTS()));
            checkBoxdriveaxle.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getDIFFERNTIALDRIVEAXLE()));
            checkBoxtiresmatch.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getTIRESMATCH()));
            checkBoxwheelsmatch.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getWHEELSMATCH()));
            editTexttirethreaddepthfront.setText(underbodyformModal.getTIREDEPTHFRONT());
            editTexttirethreaddepthrear.setText(underbodyformModal.getTIREDEPTHREAR());;
            editTextnormaltierwear.setText(underbodyformModal.getNORMALTIREWEAR());;
            editTexttirePressureMonitoring.setText(underbodyformModal.getTIREPRESSUREMONITOR());;
            checkBoxWheels.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getWHEELS()));
            checkBoxwheelcovers.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getWHEELCOVERANDCENTERCAPS()));
            checkBoxrackandpinion.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getRACKPINION()));
            checkBoxcontrolarms.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getCONTROLARMS()));
            checkBoxtierods.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getTIERODS()));
            checkBoxswaybars.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getSWAYBARS()));
            checkBoxsprings.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getSPRINGS()));
            checkBoxstrutsshocks.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getSTRUTSANDSHOCKS()));
            checkBoxwheelalignment.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getWHEELALIGNMENT()));
            checkBoxpowersteeringpump.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getPOWERSTEERINGPUMP()));
            checkBoxcalipersandwheel.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getWHEELSCYLENDIRS()));
            checkBoxfrontbrakes.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getBRAKEPADFRONT()));
            checkBoxrearbrakes.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getBRAKEPADREAR()));
            checkBoxrotordrums.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getROTORSANDDRUMS()));
            checkBoxbrakelines.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getBRAKELINES()));
            checkBoxtransfercasefluid.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getTRANSMISSIONMOUNTS()));
            checkBoxmastercylendir.setChecked(helperFormsFunctions.returnCheckboxValue(underbodyformModal.getMASTERCYLENDIRBOOSTER()));
            if(underbodyformModal.getREPAIRINGCOSTUNDERBODY()!=null) {
                editTextreplacementcost.setText(String.valueOf(underbodyformModal.getREPAIRINGCOSTUNDERBODY()));
                OLDCOST=underbodyformModal.getREPAIRINGCOSTUNDERBODY();
            }else{
                OLDCOST=0f;
            }
            editTextreplacement.setText(underbodyformModal.getCOMMENTUNDERBODY());
            seekBarAirpressureFrontTires.setProgress(underbodyformModal.getTIREPRESSUREFRONT());
            seekBarAirpressureBackTires.setProgress(underbodyformModal.getTIREPRESSUREBACK());
            progress1.setText(String.valueOf(underbodyformModal.getTIREPRESSUREFRONT()));
            progress2.setText(String.valueOf(underbodyformModal.getTIREPRESSUREBACK()));
            feedbackprogress1.setText(helperFormsFunctions.returnFeedbackSeekBar(underbodyformModal.getTIREPRESSUREFRONT()));
            feedbackprogress2.setText(helperFormsFunctions.returnFeedbackSeekBar(underbodyformModal.getTIREPRESSUREBACK()));
        }
        else{
            OLDCOST=0f;
        }
    }
}
