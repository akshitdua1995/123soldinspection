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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.ExteriorformModal;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by akshit on 24/7/16.
 */
public class ExteriorFragment extends android.app.Fragment implements View.OnClickListener {

    HelperFormsFunctions helperFormsFunctions;
    static SQLiteDatabase db;
    Float OLDCOST;
    private RadioGroup radioButtongrill;
    private RadioButton radioButtongrillyes;
    private RadioButton radioButtongrillno;
    private RadioGroup radioButtontrim;
    private RadioButton radioButtontrimyes;
    private RadioButton radioButtonkeytrimno;
    private RadioGroup radioButtonroofrack;
    private RadioButton radioButtonroofrackyes;
    private RadioButton radioButtonroofrackno;
    private RadioGroup radioButtondeployablerunning;
    private RadioButton radioButtondeployablerunningyes;
    private RadioButton radioButtondeployablerunningno;
    private RadioGroup radioButtonwindshieldglass;
    private RadioButton radioButtonwindshieldglassyes;
    private RadioButton radioButtonwindshieldglassno;
    private ImageView plusImage;
    private ImageView windshieldglassImage;
    private RadioGroup radioButtonsideglass;
    private RadioButton radioButtonsideglassyes;
    private RadioButton radioButtonsideglassno;
    private RadioGroup radioButtonrearwindowglass;
    private RadioButton radioButtonrearwindowglassyes;
    private RadioButton radioButtonrearwindowglassno;
    private ImageView plusImage2;
    private ImageView rearviewglassImage;
    private RadioGroup radioButtonoutsidemirror;
    private RadioButton radioButtonoutsidemirroryes;
    private RadioButton radioButtonoutsidemirrorno;
    private RadioGroup radioButtonwiperblade;
    private RadioButton radioButtonwiperbladeyes;
    private RadioButton radioButtonwiperbladeno;
    private CheckBox checkBoxoutsidefoldingmirror;
    private RadioGroup radioButtonfrontexteriorlight;
    private RadioButton radioButtonfrontexteriorlightyes;
    private RadioButton radioButtonfrontexteriorlightno;
    private RadioGroup radioButtonbackexteriorlight;
    private RadioButton radioButtonbackexteriorlightyes;
    private RadioButton radioButtonbackexteriorlightno;
    private RadioGroup radioButtonsideexteriorlight;
    private RadioButton radioButtonsideexteriorlightyes;
    private RadioButton radioButtonsideexteriorlightno;
    private RadioGroup radioButtonhazardlight;
    private RadioButton radioButtonhazardlightyes;
    private RadioButton radioButtonhazardlightno;
    private RadioGroup radioButtontrailerlampconnector;
    private RadioButton radioButtontrailerlampconnectoryes;
    private RadioButton radioButtontrailerlampconnectorno;
    private CheckBox checkBoxautolighting;
    private RadioGroup radioButtonflooddamage;
    private RadioButton radioButtonflooddamageyes;
    private RadioButton radioButtonflooddamageno;
    private RadioGroup radioButtontfiredamage;
    private RadioButton radioButtontfiredamageyes;
    private RadioButton radioButtonkeyfiredamageno;
    private RadioGroup radioButtonmajordamage;
    private RadioButton radioButtonmajordamageyes;
    private RadioButton radioButtonmajordamageno;
    private RadioGroup radioButtonhaildamage;
    private RadioButton radioButtonhaildamageyes;
    private RadioButton radioButtonhaildamageno;
    private RadioGroup radioButtonbodypanel;
    private RadioButton radioButtonbodypanelyes;
    private RadioButton radioButtonbodypanelno;
    private RadioGroup radioButtonbumper;
    private RadioButton radioButtonbumperyes;
    private RadioButton radioButtonbumperno;
    private ImageView plusImagebumper;
    private ImageView bumperImage;
    private ImageView plusdoorleft;
    private ImageView leftdoorImage;
    private ImageView plusdoorright;
    private ImageView rightdoorImage;
    private CheckBox checkBoxdoorsinspection;
    private CheckBox checkBoxhoodinspection;
    private RadioGroup radioButtondeclklid;
    private RadioButton radioButtondeclklidyes;
    private RadioButton radioButtondecklidno;
    private CheckBox checkBoxtailgateinspection;
    private CheckBox checkBoxroofinspection;
    private CheckBox checkBoxhoodrelease;
    private CheckBox checkBoxhoodhinges;
    private CheckBox checkBoxdoorhinges;
    private CheckBox checkBoxTrunktailgatehinges;
    private CheckBox checkBoxpowerlifegate;
    private RadioGroup radioButtonrepaint;
    private RadioButton radioButtonrepaintyes;
    private RadioButton radioButtonrepaintno;
    private EditText editTextreplacementcost;
    private EditText editTextreplacement;
    private Button saveexterior;

    Integer CARID;
    Integer GRILLINSPECTION;
    Integer TRIMINSPECTION;
    Integer ROOFRACKINSPECTION;
    Integer DEPLOYABLERUNNINGBOARDS;
    Integer WINDSHIELDGLASSINSPECTION;
    Integer SIDEGLASSINSPECTION;
    Integer REARWINDOWGLASSINSPECTION;
    Integer WIPERBLADE;
    Integer OUTSIDEMIRRORINSPECTION;
    Integer OUTSIDEFOLDINGMIRRORINSPECTION;
    Integer FRONTEXTLIGHTS;
    Integer BACKEXTLIGHTS;
    Integer SIDEEXTLIGHTS;
    Integer HAZARDLIGHTS;
    Integer TRAILERLAMPCONNECTOR;
    Integer ONOFFLIGHTING;
    Integer FLOODDAMAGE;
    Integer FIREDAMAGE;
    Integer MAJORDAMAGE;
    Integer HAILDAMAGE;
    Integer BODYPANEL;
    Integer BUMPER;
    Integer DOORS;
    Integer HOOD;
    Integer DECKLID;
    Integer TAILGATE;
    Integer ROOF;
    Integer HOODRELEASE;
    Integer HOODHINGES;
    Integer DOORHINGES;
    Integer TRUNKSTRUTS;
    Integer POWERLIFTGATE;
    Integer PAINTGAUGE;
    Float REPAIRINGCOSTEXTERIOR;
    String COMMENTEXTERIOR;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-07-30 16:27:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews(View rootView) {
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        db = dbHelper.getWritableDatabase();
        radioButtongrill = (RadioGroup)rootView.findViewById( R.id.radioButtongrill );
        radioButtongrillyes = (RadioButton)rootView.findViewById( R.id.radioButtongrillyes );
        radioButtongrillno = (RadioButton)rootView.findViewById( R.id.radioButtongrillno );
        radioButtontrim = (RadioGroup)rootView.findViewById( R.id.radioButtontrim );
        radioButtontrimyes = (RadioButton)rootView.findViewById( R.id.radioButtontrimyes );
        radioButtonkeytrimno = (RadioButton)rootView.findViewById( R.id.radioButtonkeytrimno );
        radioButtonroofrack = (RadioGroup)rootView.findViewById( R.id.radioButtonroofrack );
        radioButtonroofrackyes = (RadioButton)rootView.findViewById( R.id.radioButtonroofrackyes );
        radioButtonroofrackno = (RadioButton)rootView.findViewById( R.id.radioButtonroofrackno );
        radioButtondeployablerunning = (RadioGroup)rootView.findViewById( R.id.radioButtondeployablerunning );
        radioButtondeployablerunningyes = (RadioButton)rootView.findViewById( R.id.radioButtondeployablerunningyes );
        radioButtondeployablerunningno = (RadioButton)rootView.findViewById( R.id.radioButtondeployablerunningno );
        radioButtonwindshieldglass = (RadioGroup)rootView.findViewById( R.id.radioButtonwindshieldglass );
        radioButtonwindshieldglassyes = (RadioButton)rootView.findViewById( R.id.radioButtonwindshieldglassyes );
        radioButtonwindshieldglassno = (RadioButton)rootView.findViewById( R.id.radioButtonwindshieldglassno );
        plusImage = (ImageView)rootView.findViewById( R.id.plusImage );
        windshieldglassImage = (ImageView)rootView.findViewById( R.id.windshieldglassImage );
        radioButtonsideglass = (RadioGroup)rootView.findViewById( R.id.radioButtonsideglass );
        radioButtonsideglassyes = (RadioButton)rootView.findViewById( R.id.radioButtonsideglassyes );
        radioButtonsideglassno = (RadioButton)rootView.findViewById( R.id.radioButtonsideglassno );
        radioButtonrearwindowglass = (RadioGroup)rootView.findViewById( R.id.radioButtonrearwindowglass );
        radioButtonrearwindowglassyes = (RadioButton)rootView.findViewById( R.id.radioButtonrearwindowglassyes );
        radioButtonrearwindowglassno = (RadioButton)rootView.findViewById( R.id.radioButtonrearwindowglassno );
        plusImage2 = (ImageView)rootView.findViewById( R.id.plusImage2 );
        rearviewglassImage = (ImageView)rootView.findViewById( R.id.rearviewglassImage );
        radioButtonoutsidemirror = (RadioGroup)rootView.findViewById( R.id.radioButtonoutsidemirror );
        radioButtonoutsidemirroryes = (RadioButton)rootView.findViewById( R.id.radioButtonoutsidemirroryes );
        radioButtonoutsidemirrorno = (RadioButton)rootView.findViewById( R.id.radioButtonoutsidemirrorno );
        radioButtonwiperblade = (RadioGroup)rootView.findViewById( R.id.radioButtonwiperblade );
        radioButtonwiperbladeyes = (RadioButton)rootView.findViewById( R.id.radioButtonwiperbladeyes );
        radioButtonwiperbladeno = (RadioButton)rootView.findViewById( R.id.radioButtonwiperbladeno );
        checkBoxoutsidefoldingmirror = (CheckBox)rootView.findViewById( R.id.checkBoxoutsidefoldingmirror );
        radioButtonfrontexteriorlight = (RadioGroup)rootView.findViewById( R.id.radioButtonfrontexteriorlight );
        radioButtonfrontexteriorlightyes = (RadioButton)rootView.findViewById( R.id.radioButtonfrontexteriorlightyes );
        radioButtonfrontexteriorlightno = (RadioButton)rootView.findViewById( R.id.radioButtonfrontexteriorlightno );
        radioButtonbackexteriorlight = (RadioGroup)rootView.findViewById( R.id.radioButtonbackexteriorlight );
        radioButtonbackexteriorlightyes = (RadioButton)rootView.findViewById( R.id.radioButtonbackexteriorlightyes );
        radioButtonbackexteriorlightno = (RadioButton)rootView.findViewById( R.id.radioButtonbackexteriorlightno );
        radioButtonsideexteriorlight = (RadioGroup)rootView.findViewById( R.id.radioButtonsideexteriorlight );
        radioButtonsideexteriorlightyes = (RadioButton)rootView.findViewById( R.id.radioButtonsideexteriorlightyes );
        radioButtonsideexteriorlightno = (RadioButton)rootView.findViewById( R.id.radioButtonsideexteriorlightno );
        radioButtonhazardlight = (RadioGroup)rootView.findViewById( R.id.radioButtonhazardlight );
        radioButtonhazardlightyes = (RadioButton)rootView.findViewById( R.id.radioButtonhazardlightyes );
        radioButtonhazardlightno = (RadioButton)rootView.findViewById( R.id.radioButtonhazardlightno );
        radioButtontrailerlampconnector = (RadioGroup)rootView.findViewById( R.id.radioButtontrailerlampconnector );
        radioButtontrailerlampconnectoryes = (RadioButton)rootView.findViewById( R.id.radioButtontrailerlampconnectoryes );
        radioButtontrailerlampconnectorno = (RadioButton)rootView.findViewById( R.id.radioButtontrailerlampconnectorno );
        checkBoxautolighting = (CheckBox)rootView.findViewById( R.id.checkBoxautolighting );
        radioButtonflooddamage = (RadioGroup)rootView.findViewById( R.id.radioButtonflooddamage );
        radioButtonflooddamageyes = (RadioButton)rootView.findViewById( R.id.radioButtonflooddamageyes );
        radioButtonflooddamageno = (RadioButton)rootView.findViewById( R.id.radioButtonflooddamageno );
        radioButtontfiredamage = (RadioGroup)rootView.findViewById( R.id.radioButtontfiredamage );
        radioButtontfiredamageyes = (RadioButton)rootView.findViewById( R.id.radioButtontfiredamageyes );
        radioButtonkeyfiredamageno = (RadioButton)rootView.findViewById( R.id.radioButtonkeyfiredamageno );
        radioButtonmajordamage = (RadioGroup)rootView.findViewById( R.id.radioButtonmajordamage );
        radioButtonmajordamageyes = (RadioButton)rootView.findViewById( R.id.radioButtonmajordamageyes );
        radioButtonmajordamageno = (RadioButton)rootView.findViewById( R.id.radioButtonmajordamageno );
        radioButtonhaildamage = (RadioGroup)rootView.findViewById( R.id.radioButtonhaildamage );
        radioButtonhaildamageyes = (RadioButton)rootView.findViewById( R.id.radioButtonhaildamageyes );
        radioButtonhaildamageno = (RadioButton)rootView.findViewById( R.id.radioButtonhaildamageno );
        radioButtonbodypanel = (RadioGroup)rootView.findViewById( R.id.radioButtonbodypanel );
        radioButtonbodypanelyes = (RadioButton)rootView.findViewById( R.id.radioButtonbodypanelyes );
        radioButtonbodypanelno = (RadioButton)rootView.findViewById( R.id.radioButtonbodypanelno );
        radioButtonbumper = (RadioGroup)rootView.findViewById( R.id.radioButtonbumper );
        radioButtonbumperyes = (RadioButton)rootView.findViewById( R.id.radioButtonbumperyes );
        radioButtonbumperno = (RadioButton)rootView.findViewById( R.id.radioButtonbumperno );
        plusImagebumper = (ImageView)rootView.findViewById( R.id.plusImagebumper );
        bumperImage = (ImageView)rootView.findViewById( R.id.bumperImage );
        plusdoorleft = (ImageView)rootView.findViewById( R.id.plusdoorleft );
        leftdoorImage = (ImageView)rootView.findViewById( R.id.leftdoorImage );
        plusdoorright = (ImageView)rootView.findViewById( R.id.plusdoorright );
        rightdoorImage = (ImageView)rootView.findViewById( R.id.rightdoorImage );
        checkBoxdoorsinspection = (CheckBox)rootView.findViewById( R.id.checkBoxdoorsinspection );
        checkBoxhoodinspection = (CheckBox)rootView.findViewById( R.id.checkBoxexhoodinspection );
        radioButtondeclklid = (RadioGroup)rootView.findViewById( R.id.radioButtondeclklid );
        radioButtondeclklidyes = (RadioButton)rootView.findViewById( R.id.radioButtondeclklidyes );
        radioButtondecklidno = (RadioButton)rootView.findViewById( R.id.radioButtondecklidno );
        checkBoxtailgateinspection = (CheckBox)rootView.findViewById( R.id.checkBoxtailgateinspection );
        checkBoxroofinspection = (CheckBox)rootView.findViewById( R.id.checkBoxroofinspection );
        checkBoxhoodrelease = (CheckBox)rootView.findViewById( R.id.checkBoxhoodrelease );
        checkBoxhoodhinges = (CheckBox)rootView.findViewById( R.id.checkBoxhoodhinges );
        checkBoxdoorhinges = (CheckBox)rootView.findViewById( R.id.checkBoxdoorhinges );
        checkBoxTrunktailgatehinges = (CheckBox)rootView.findViewById( R.id.checkBoxTrunktailgatehinges );
        checkBoxpowerlifegate = (CheckBox)rootView.findViewById( R.id.checkBoxpowerlifegate );
        radioButtonrepaint = (RadioGroup)rootView.findViewById( R.id.radioButtonrepaint );
        radioButtonrepaintyes = (RadioButton)rootView.findViewById( R.id.radioButtonrepaintyes );
        radioButtonrepaintno = (RadioButton)rootView.findViewById( R.id.radioButtonrepaintno );
        editTextreplacementcost = (EditText)rootView.findViewById( R.id.editTextreplacementcost );
        editTextreplacement = (EditText)rootView.findViewById( R.id.editTextreplacement );
        saveexterior = (Button)rootView.findViewById( R.id.saveexterior );
        
        saveexterior.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-07-30 16:27:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == saveexterior ) {
            mapcarprogressvalues();
            mapvalues(v.getRootView());
            ExteriorformModal exteriorformModal=new ExteriorformModal(CARID,GRILLINSPECTION,TRIMINSPECTION,ROOFRACKINSPECTION,DEPLOYABLERUNNINGBOARDS,WINDSHIELDGLASSINSPECTION
            ,SIDEGLASSINSPECTION,REARWINDOWGLASSINSPECTION,WIPERBLADE,OUTSIDEMIRRORINSPECTION,OUTSIDEFOLDINGMIRRORINSPECTION,FRONTEXTLIGHTS,BACKEXTLIGHTS,SIDEEXTLIGHTS
            ,HAZARDLIGHTS,TRAILERLAMPCONNECTOR,ONOFFLIGHTING,FLOODDAMAGE,FIREDAMAGE,MAJORDAMAGE,HAILDAMAGE,BODYPANEL,BUMPER,DOORS,HOOD
            ,DECKLID,TAILGATE,ROOF,HOODRELEASE,HOODHINGES,DOORHINGES,TRUNKSTRUTS,POWERLIFTGATE,PAINTGAUGE,REPAIRINGCOSTEXTERIOR,COMMENTEXTERIOR);
            ExteriorformModal exteriorformModalold = cupboard().withDatabase(db).query(ExteriorformModal.class).withSelection( "CARID = ?", "1").get();
            if(exteriorformModalold==null) {
                Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(exteriorformModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Sucessfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(ExteriorformModal.class, "CARID = ?", "1");
                cupboard().withDatabase(db).put(exteriorformModal);
            }
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
            db.close();
        }
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("CARID=1").get();
        if(carprogressModal.getEXTERIORCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("EXTERIORCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }

        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTEXTERIOR=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTEXTERIOR);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exterior_form,container, false);
        findViews(rootView);
        returnchanges();
        return rootView;
    }

    private void returnchanges() {
        ExteriorformModal exteriorformModal = cupboard().withDatabase(db).query(ExteriorformModal.class).withSelection("CARID=1").get();
        if(exteriorformModal!=null) {
            helperFormsFunctions.setValueRadiobutton(radioButtonbackexteriorlight,radioButtonbackexteriorlightyes.getId(),radioButtonbackexteriorlightno.getId(),exteriorformModal.getBACKEXTLIGHTS());
            helperFormsFunctions.setValueRadiobutton(radioButtonbodypanel,radioButtonbodypanelyes.getId(),radioButtonbodypanelno.getId(),exteriorformModal.getBODYPANEL());
            helperFormsFunctions.setValueRadiobutton(radioButtonbumper,radioButtonbumperyes.getId(),radioButtonbumperno.getId(),exteriorformModal.getBUMPER());
            helperFormsFunctions.setValueRadiobutton(radioButtondeclklid,radioButtondeclklidyes.getId(),radioButtondecklidno.getId(),exteriorformModal.getDECKLID());
            helperFormsFunctions.setValueRadiobutton(radioButtonflooddamage,radioButtonflooddamageyes.getId(),radioButtonflooddamageno.getId(),exteriorformModal.getFLOODDAMAGE());
            helperFormsFunctions.setValueRadiobutton(radioButtongrill,radioButtongrillyes.getId(),radioButtongrillno.getId(),exteriorformModal.getGRILLINSPECTION());
            helperFormsFunctions.setValueRadiobutton(radioButtondeployablerunning,radioButtondeployablerunningyes.getId(),radioButtondeployablerunningno.getId(),exteriorformModal.getDEPLOYABLERUNNINGBOARDS());
            helperFormsFunctions.setValueRadiobutton(radioButtonhaildamage,radioButtonhaildamageyes.getId(),radioButtonhaildamageno.getId(),exteriorformModal.getHAILDAMAGE());
            helperFormsFunctions.setValueRadiobutton(radioButtonmajordamage,radioButtonmajordamageyes.getId(),radioButtonmajordamageno.getId(),exteriorformModal.getMAJORDAMAGE());
            helperFormsFunctions.setValueRadiobutton(radioButtonrepaint,radioButtonrepaintyes.getId(),radioButtonrepaintno.getId(),exteriorformModal.getPAINTGAUGE());
            helperFormsFunctions.setValueRadiobutton(radioButtontfiredamage,radioButtontfiredamageyes.getId(),radioButtonkeyfiredamageno.getId(),exteriorformModal.getFIREDAMAGE());
            helperFormsFunctions.setValueRadiobutton(radioButtontrim,radioButtontrimyes.getId(),radioButtonkeytrimno.getId(),exteriorformModal.getTRIMINSPECTION());
            helperFormsFunctions.setValueRadiobutton(radioButtonroofrack,radioButtonroofrackyes.getId(),radioButtonroofrackno.getId(),exteriorformModal.getROOFRACKINSPECTION());
            helperFormsFunctions.setValueRadiobutton(radioButtonfrontexteriorlight,radioButtonfrontexteriorlightyes.getId(),radioButtonfrontexteriorlightno.getId(),exteriorformModal.getFRONTEXTLIGHTS());
            helperFormsFunctions.setValueRadiobutton(radioButtonhazardlight,radioButtonhazardlightyes.getId(),radioButtonhazardlightno.getId(),exteriorformModal.getHAZARDLIGHTS());
            helperFormsFunctions.setValueRadiobutton(radioButtontrailerlampconnector,radioButtontrailerlampconnectoryes.getId(),radioButtontrailerlampconnectorno.getId(),exteriorformModal.getTRAILERLAMPCONNECTOR());
            helperFormsFunctions.setValueRadiobutton(radioButtonsideexteriorlight,radioButtonsideexteriorlightyes.getId(),radioButtonsideexteriorlightno.getId(),exteriorformModal.getSIDEEXTLIGHTS());
            helperFormsFunctions.setValueRadiobutton(radioButtonsideglass,radioButtonsideglassyes.getId(),radioButtonsideglassno.getId(),exteriorformModal.getSIDEGLASSINSPECTION());
            helperFormsFunctions.setValueRadiobutton(radioButtonwiperblade,radioButtonwiperbladeyes.getId(),radioButtonwiperbladeno.getId(),exteriorformModal.getWIPERBLADE());
            helperFormsFunctions.setValueRadiobutton(radioButtonwindshieldglass,radioButtonwindshieldglassyes.getId(),radioButtonwindshieldglassno.getId(),exteriorformModal.getWINDSHIELDGLASSINSPECTION());
            helperFormsFunctions.setValueRadiobutton(radioButtonrearwindowglass,radioButtonrearwindowglassyes.getId(),radioButtonrearwindowglassno.getId(),exteriorformModal.getREARWINDOWGLASSINSPECTION());
            helperFormsFunctions.setValueRadiobutton(radioButtonoutsidemirror,radioButtonoutsidemirroryes.getId(),radioButtonoutsidemirrorno.getId(),exteriorformModal.getOUTSIDEMIRRORINSPECTION());
            checkBoxautolighting.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getONOFFLIGHTING()));
            checkBoxtailgateinspection.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getTAILGATE()));
            checkBoxroofinspection.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getROOF()));
            checkBoxhoodrelease.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getHOODRELEASE()));
            checkBoxhoodhinges.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getHOODHINGES()));
            checkBoxdoorhinges.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getDOORHINGES()));
            checkBoxTrunktailgatehinges.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getTRUNKSTRUTS()));
            checkBoxpowerlifegate.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getPOWERLIFTGATE()));
            checkBoxdoorsinspection.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getDOORS()));
            checkBoxhoodinspection.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getHOOD()));
            checkBoxoutsidefoldingmirror.setChecked(helperFormsFunctions.returnCheckboxValue(exteriorformModal.getOUTSIDEFOLDINGMIRRORINSPECTION()));
            if(exteriorformModal.getREPAIRINGCOSTEXTERIOR()!=null) {
                editTextreplacementcost.setText(String.valueOf(exteriorformModal.getREPAIRINGCOSTEXTERIOR()));
                OLDCOST=exteriorformModal.getREPAIRINGCOSTEXTERIOR();
            }else{
                OLDCOST=0f;
            }
            editTextreplacement.setText(exteriorformModal.getCOMMENTEXTERIOR());
        }else{
            OLDCOST=0f;
        }
    }

    private void mapvalues(View view) {
        CARID=1;
        GRILLINSPECTION=helperFormsFunctions.returnRadioGroup(radioButtongrill,view);
        TRIMINSPECTION=helperFormsFunctions.returnRadioGroup(radioButtontrim,view);
        ROOFRACKINSPECTION=helperFormsFunctions.returnRadioGroup(radioButtonroofrack,view);
        DEPLOYABLERUNNINGBOARDS=helperFormsFunctions.returnRadioGroup(radioButtondeployablerunning,view);
        WINDSHIELDGLASSINSPECTION=helperFormsFunctions.returnRadioGroup(radioButtonwindshieldglass,view);
        SIDEGLASSINSPECTION=helperFormsFunctions.returnRadioGroup(radioButtonsideglass,view);
        REARWINDOWGLASSINSPECTION=helperFormsFunctions.returnRadioGroup(radioButtonrearwindowglass,view);
        WIPERBLADE=helperFormsFunctions.returnRadioGroup(radioButtonwiperblade,view);
        OUTSIDEMIRRORINSPECTION=helperFormsFunctions.returnRadioGroup(radioButtonoutsidemirror,view);
        OUTSIDEFOLDINGMIRRORINSPECTION=helperFormsFunctions.returnCheckboxValue(checkBoxoutsidefoldingmirror);
        FRONTEXTLIGHTS=helperFormsFunctions.returnRadioGroup(radioButtonfrontexteriorlight,view);;
        BACKEXTLIGHTS=helperFormsFunctions.returnRadioGroup(radioButtonbackexteriorlight,view);;
        SIDEEXTLIGHTS=helperFormsFunctions.returnRadioGroup(radioButtonsideexteriorlight,view);;
        HAZARDLIGHTS=helperFormsFunctions.returnRadioGroup(radioButtonhazardlight,view);;
        TRAILERLAMPCONNECTOR=helperFormsFunctions.returnRadioGroup(radioButtontrailerlampconnector,view);;
        ONOFFLIGHTING=helperFormsFunctions.returnCheckboxValue(checkBoxautolighting);;
        FLOODDAMAGE=helperFormsFunctions.returnRadioGroup(radioButtonflooddamage,view);
        FIREDAMAGE=helperFormsFunctions.returnRadioGroup(radioButtontfiredamage,view);
        MAJORDAMAGE=helperFormsFunctions.returnRadioGroup(radioButtonmajordamage,view);
        HAILDAMAGE=helperFormsFunctions.returnRadioGroup(radioButtonhaildamage,view);
        BODYPANEL=helperFormsFunctions.returnRadioGroup(radioButtonbodypanel,view);
        BUMPER=helperFormsFunctions.returnRadioGroup(radioButtonbumper,view);
        DOORS=helperFormsFunctions.returnCheckboxValue(checkBoxdoorsinspection);;
        HOOD=helperFormsFunctions.returnCheckboxValue(checkBoxhoodinspection);
        DECKLID=helperFormsFunctions.returnRadioGroup(radioButtondeclklid,view);
        TAILGATE=helperFormsFunctions.returnCheckboxValue(checkBoxtailgateinspection);
        ROOF=helperFormsFunctions.returnCheckboxValue(checkBoxroofinspection);
        HOODRELEASE=helperFormsFunctions.returnCheckboxValue(checkBoxhoodrelease);
        HOODHINGES=helperFormsFunctions.returnCheckboxValue(checkBoxhoodhinges);
        DOORHINGES=helperFormsFunctions.returnCheckboxValue(checkBoxdoorhinges);
        TRUNKSTRUTS=helperFormsFunctions.returnCheckboxValue(checkBoxTrunktailgatehinges);;
        POWERLIFTGATE=helperFormsFunctions.returnCheckboxValue(checkBoxpowerlifegate);;
        PAINTGAUGE=helperFormsFunctions.returnRadioGroup(radioButtonrepaint,view);;
        try {
            REPAIRINGCOSTEXTERIOR=Float.valueOf(editTextreplacementcost.getText().toString());
        }catch (Exception e){}
        COMMENTEXTERIOR=editTextreplacement.getText().toString();
    }
}
