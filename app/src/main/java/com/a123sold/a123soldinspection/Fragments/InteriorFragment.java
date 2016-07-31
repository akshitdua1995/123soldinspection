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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.InteriorModal;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/*
 * Created by akshit on 24/7/16.
 */
public class InteriorFragment extends android.app.Fragment implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private SeekBar seekBarAirconditioning;
    private SeekBar seekBarHeatingSystem;
    TextView progress1,progress2;
    TextView feedbackprogress1,feedbackprogress2;
    HelperFormsFunctions helperFormsFunctions;
    static SQLiteDatabase db;
    private RadioGroup radioButtonairbags;
    private RadioButton radioButtonairbagsyes;
    private RadioButton radioButtonairbagsno;
    private RadioGroup radioButtonsafteybelts;
    private RadioButton radioButtonsafteybeltsyes;
    private RadioButton radioButtonsafteybeltsno;
    private ImageView pluscarcabin;
    private ImageView carcabinImage;
    private ImageView plusstereocar;
    private ImageView carstereoImage;
    private ImageView plusacmetrecar;
    private ImageView caracmetreImage;
    private CheckBox checkBoxstereospeakers;
    private CheckBox checkBoxantenna;
    private CheckBox checkBoxalarmtheftsystem;
    private RadioGroup radioButtonnavisystem;
    private RadioButton radioButtonnavisystemyes;
    private RadioButton radioButtonnavisystemno;
    private RadioGroup radioButtondefog;
    private RadioButton radioButtondefogyes;
    private RadioButton radioButtondefogno;
    private RadioGroup radioButtonclock;
    private RadioButton radioButtonclockyes;
    private RadioButton radioButtonclockno;
    private RadioGroup radioButtontilttelescopic;
    private RadioButton radioButtontilttelescopicyes;
    private RadioButton radioButtontilttelescopicno;
    private RadioGroup radioButtonsteeringlock;
    private RadioButton radioButtonsteeringlockyes;
    private RadioButton radioButtonsteeringlockno;
    private RadioGroup radioButtonsteeringwheels;
    private RadioButton radioButtonsteeringwheelsyes;
    private RadioButton radioButtonsteeringwheelsno;
    private CheckBox checkBoxhorn;
    private CheckBox checkBoxwarningchimes;
    private CheckBox checkBoxinstrumentpanel;
    private RadioGroup radioButtonwipers;
    private RadioButton radioButtonwipersyes;
    private RadioButton radioButtonwipersno;
    private RadioGroup radioButtonrearwiper;
    private RadioButton radioButtonrearwiperyes;
    private RadioButton radioButtonrearwiperno;
    private RadioGroup radioButtonwashers;
    private RadioButton radioButtonwashersyes;
    private RadioButton radioButtonswashersno;
    private CheckBox checkBoxdomemaplights;
    private CheckBox checkBoxoutsiderearviewmirrors;
    private RadioGroup radioButtonautodimming;
    private RadioButton radioButtonautodimmingyes;
    private RadioButton radioButtonautodimmingno;
    private RadioGroup radioButtonblindspot;
    private RadioButton radioButtonblindspotyes;
    private RadioButton radioButtonblindspotno;
    private RadioGroup radioButtonrearcamera;
    private RadioButton radioButtonrearcamerayes;
    private RadioButton radioButtonrearcamerano;
    private CheckBox checkBoxactiveparkassist;
    private RadioGroup radioButtonrearentertainment;
    private RadioButton radioButtonrearentertainmentyes;
    private RadioButton radioButtonrearentertainmentsno;
    private CheckBox checkBoxpoweroutlets;
    private CheckBox checkBoxlighter;
    private CheckBox checkBoxashtrays;
    private CheckBox checkBoxGloveBox;
    private CheckBox checkBoxconsolefront;
    private CheckBox checkBoxconsolerear;
    private CheckBox checkBoxsunvisors;
    private RadioGroup radioButtonadjustablepedals;
    private RadioButton radioButtonadjustablepedalsyes;
    private RadioButton radioButtonadjustablepedalsno;
    private CheckBox checkBoxodorfree;
    private RadioGroup radioButtoncarpet;
    private RadioButton radioButtoncarpetyes;
    private RadioButton radioButtoncarpetno;
    private CheckBox checkBoxfloorMats;
    private RadioGroup radioButtondoortrim;
    private RadioButton radioButtondoortrimyes;
    private RadioButton radioButtondoortrimno;
    private CheckBox checkBoxseatupholstery;
    private CheckBox checkBoxseatandhead;
    private CheckBox checkBoxfoldingseat;
    private CheckBox checkBoxheatedseat;
    private CheckBox checkBoxcooledseat;
    private RadioGroup radioButtonmoonroof;
    private RadioButton radioButtonmoonroofyes;
    private RadioButton radioButtonmoonroofno;
    private ImageView plussunroofImage;
    private ImageView sunroofImage;
    private RadioGroup radioButtonsnroof;
    private RadioButton radioButtonsnroofyes;
    private RadioButton radioButtonsunroofno;
    private CheckBox checkBoxdoorhandles;
    private RadioGroup radioButtondoorentry;
    private RadioButton radioButtondoorentryyes;
    private RadioButton radioButtondoorentryno;
    private RadioGroup radioButtonpushbutton;
    private RadioButton radioButtonpushbuttonyes;
    private RadioButton radioButtonpushbuttonno;
    private CheckBox checkBoxdoorlocks;
    private CheckBox checkBoxchildlock;
    private CheckBox checkBoxwindowcontrols;
    private CheckBox checkBoxremotedecklid;
    private CheckBox checkBoxfuelfillerdoorrelease;
    private ImageView plussuncompartmentImage;
    private ImageView compartmentImage;
    private CheckBox checkBoxluggagecarpet;
    private RadioGroup radioluggagecompartmenttrim;
    private RadioButton radioluggagecompartmenttrimyes;
    private RadioButton radioButtonluggagecompartmenttrimno;
    private RadioGroup radioButtoncargoarea;
    private RadioButton radioButtoncargoareayes;
    private RadioButton radioButtoncargoareano;
    private RadioGroup radioButtonjacktoolkit;
    private RadioButton radioButtonjacktoolkityes;
    private RadioButton radioButtonjacktoolkitno;
    private CheckBox checkBoxsidewallinspection;
    private CheckBox checkBoxairpressureinspection;
    private CheckBox checkBoxtireinflatorkit;
    private CheckBox checkBoxtrucklidrelease;
    private ImageView plusImagestepney;
    private ImageView stepneyImage;
    private EditText editTextreplacementcost;
    private EditText editTextreplacement;
    private RadioGroup radioButtonheadliner;
    private RadioButton radioButtonheadlineryes;
    private RadioButton radioButtonheadlinerno;

    Integer CARID;
    Integer AIRBAGS;
    Integer SAFTEYBELTS ;
    Integer STEREOANDSPEAKERS ;
    Integer ANTENNA ;
    Integer ALARMSYSTEM ;
    Integer NAVIGATIONSYSTEM ;
    Integer AIRCONDITIONINGSYSTEM ;
    Integer HEATINGSYSTEM ;
    Integer DEFOG ;
    Integer CLOCK ;
    Integer TILTSTEERINGWHEEL ;
    Integer STEERINGCOLUMNLOCK ;
    Integer STEERINGWHEELCONTROLS;
    Integer HORN ;
    Integer WARNINGCHIMES ;
    Integer INSTRUMENTPANELANDWARNINGLIGHT ;
    Integer WINDSHEILDWIPERS;
    Integer REARWINDOWWIPER ;
    Integer WASHERS ;
    Integer MAPLIGHTS ;
    Integer OUTSIDEREARVIEWMIRRORS ;
    Integer AUTODIMMINGREARVIEW ;
    Integer BLINDSPOT;
    Integer REARCAMERA ;
    Integer ACTIVEPARKASSIST ;
    Integer REARENTERTAINMENTSYSTEM;
    Integer POWEROUTLETS ;
    Integer LIGHTER ;
    Integer ASHTRAYS ;
    Integer GLOVEBOX ;
    Integer CENTERCONSOLEFRONT;
    Integer CENTERCONSOLEFREAR;
    Integer SUNVISORS ;
    Integer ADJUSTABLEPEDALS ;
    Integer INTERIORODOR ;
    Integer CARPET ;
    Integer FLOODMATS;
    Integer DOORTRIM ;
    Integer HEADLINER ;
    Integer SEATUPHOLDSTERY ;
    Integer SEATANDHEAD ;
    Integer FOLDINGSEATS;
    Integer HEATEDSEATS ;
    Integer COOLEDSEATS ;
    Integer CONVERTIBLETOP;
    Integer SUNROOF ;
    Integer DOORHANDLES ;
    Integer REMOTEENTRY ;
    Integer PUSHBUTTONSTART ;
    Integer DOORLOCKS;
    Integer CHILDSAFTEYLOCKS ;
    Integer WINDOWCONTROLS ;
    Integer REMOTEDECKLID ;
    Integer FUELFILLERDOOR ;
    Integer CARPETLUGGAGE ;
    Integer CARGONET;
    Integer CARGOAREALIGHT ;
    Integer JACKTOOLKIT ;
    Integer SIDEWALLINS ;
    Integer PRESSUREINS ;
    Integer TIREKIT;
    Integer LIDRELEASE ;
    Float REPAIRINGCOSTINTERIOR ;
    String COMMENTINTERIOR ;

    private Button saveinterior;
    Float OLDCOST;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-07-30 19:59:52 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews(View rootView) {
        radioButtonheadliner = (RadioGroup)rootView.findViewById( R.id.radioButtonheadliner );
        radioButtonheadlineryes = (RadioButton)rootView.findViewById( R.id.radioButtonheadlineryes );
        radioButtonheadlinerno = (RadioButton)rootView.findViewById( R.id.radioButtonheadlinerno );
        radioButtonairbags = (RadioGroup)rootView.findViewById( R.id.radioButtonairbags );
        radioButtonairbagsyes = (RadioButton)rootView.findViewById( R.id.radioButtonairbagsyes );
        radioButtonairbagsno = (RadioButton)rootView.findViewById( R.id.radioButtonairbagsno );
        radioButtonsafteybelts = (RadioGroup)rootView.findViewById( R.id.radioButtonsafteybelts );
        radioButtonsafteybeltsyes = (RadioButton)rootView.findViewById( R.id.radioButtonsafteybeltsyes );
        radioButtonsafteybeltsno = (RadioButton)rootView.findViewById( R.id.radioButtonsafteybeltsno );
        pluscarcabin = (ImageView)rootView.findViewById( R.id.pluscarcabin );
        carcabinImage = (ImageView)rootView.findViewById( R.id.carcabinImage );
        plusstereocar = (ImageView)rootView.findViewById( R.id.plusstereocar );
        carstereoImage = (ImageView)rootView.findViewById( R.id.carstereoImage );
        plusacmetrecar = (ImageView)rootView.findViewById( R.id.plusacmetrecar );
        caracmetreImage = (ImageView)rootView.findViewById( R.id.caracmetreImage );
        checkBoxstereospeakers = (CheckBox)rootView.findViewById( R.id.checkBoxstereospeakers );
        checkBoxantenna = (CheckBox)rootView.findViewById( R.id.checkBoxantenna );
        checkBoxalarmtheftsystem = (CheckBox)rootView.findViewById( R.id.checkBoxalarmtheftsystem );
        radioButtonnavisystem = (RadioGroup)rootView.findViewById( R.id.radioButtonnavisystem );
        radioButtonnavisystemyes = (RadioButton)rootView.findViewById( R.id.radioButtonnavisystemyes );
        radioButtonnavisystemno = (RadioButton)rootView.findViewById( R.id.radioButtonnavisystemno );
        radioButtondefog = (RadioGroup)rootView.findViewById( R.id.radioButtondefog );
        radioButtondefogyes = (RadioButton)rootView.findViewById( R.id.radioButtondefogyes );
        radioButtondefogno = (RadioButton)rootView.findViewById( R.id.radioButtondefogno );
        radioButtonclock = (RadioGroup)rootView.findViewById( R.id.radioButtonclock );
        radioButtonclockyes = (RadioButton)rootView.findViewById( R.id.radioButtonclockyes );
        radioButtonclockno = (RadioButton)rootView.findViewById( R.id.radioButtonclockno );
        radioButtontilttelescopic = (RadioGroup)rootView.findViewById( R.id.radioButtontilttelescopic );
        radioButtontilttelescopicyes = (RadioButton)rootView.findViewById( R.id.radioButtontilttelescopicyes );
        radioButtontilttelescopicno = (RadioButton)rootView.findViewById( R.id.radioButtontilttelescopicno );
        radioButtonsteeringlock = (RadioGroup)rootView.findViewById( R.id.radioButtonsteeringlock );
        radioButtonsteeringlockyes = (RadioButton)rootView.findViewById( R.id.radioButtonsteeringlockyes );
        radioButtonsteeringlockno = (RadioButton)rootView.findViewById( R.id.radioButtonsteeringlockno );
        radioButtonsteeringwheels = (RadioGroup)rootView.findViewById( R.id.radioButtonsteeringwheels );
        radioButtonsteeringwheelsyes = (RadioButton)rootView.findViewById( R.id.radioButtonsteeringwheelsyes );
        radioButtonsteeringwheelsno = (RadioButton)rootView.findViewById( R.id.radioButtonsteeringwheelsno );
        checkBoxhorn = (CheckBox)rootView.findViewById( R.id.checkBoxhorn );
        checkBoxwarningchimes = (CheckBox)rootView.findViewById( R.id.checkBoxwarningchimes );
        checkBoxinstrumentpanel = (CheckBox)rootView.findViewById( R.id.checkBoxinstrumentpanel );
        radioButtonwipers = (RadioGroup)rootView.findViewById( R.id.radioButtonwipers );
        radioButtonwipersyes = (RadioButton)rootView.findViewById( R.id.radioButtonwipersyes );
        radioButtonwipersno = (RadioButton)rootView.findViewById( R.id.radioButtonwipersno );
        radioButtonrearwiper = (RadioGroup)rootView.findViewById( R.id.radioButtonrearwiper );
        radioButtonrearwiperyes = (RadioButton)rootView.findViewById( R.id.radioButtonrearwiperyes );
        radioButtonrearwiperno = (RadioButton)rootView.findViewById( R.id.radioButtonrearwiperno );
        radioButtonwashers = (RadioGroup)rootView.findViewById( R.id.radioButtonwashers );
        radioButtonwashersyes = (RadioButton)rootView.findViewById( R.id.radioButtonwashersyes );
        radioButtonswashersno = (RadioButton)rootView.findViewById( R.id.radioButtonswashersno );
        checkBoxdomemaplights = (CheckBox)rootView.findViewById( R.id.checkBoxdomemaplights );
        checkBoxoutsiderearviewmirrors = (CheckBox)rootView.findViewById( R.id.checkBoxoutsiderearviewmirrors );
        radioButtonautodimming = (RadioGroup)rootView.findViewById( R.id.radioButtonautodimming );
        radioButtonautodimmingyes = (RadioButton)rootView.findViewById( R.id.radioButtonautodimmingyes );
        radioButtonautodimmingno = (RadioButton)rootView.findViewById( R.id.radioButtonautodimmingno );
        radioButtonblindspot = (RadioGroup)rootView.findViewById( R.id.radioButtonblindspot );
        radioButtonblindspotyes = (RadioButton)rootView.findViewById( R.id.radioButtonblindspotyes );
        radioButtonblindspotno = (RadioButton)rootView.findViewById( R.id.radioButtonblindspotno );
        radioButtonrearcamera = (RadioGroup)rootView.findViewById( R.id.radioButtonrearcamera );
        radioButtonrearcamerayes = (RadioButton)rootView.findViewById( R.id.radioButtonrearcamerayes );
        radioButtonrearcamerano = (RadioButton)rootView.findViewById( R.id.radioButtonrearcamerano );
        checkBoxactiveparkassist = (CheckBox)rootView.findViewById( R.id.checkBoxactiveparkassist );
        radioButtonrearentertainment = (RadioGroup)rootView.findViewById( R.id.radioButtonrearentertainment );
        radioButtonrearentertainmentyes = (RadioButton)rootView.findViewById( R.id.radioButtonrearentertainmentyes );
        radioButtonrearentertainmentsno = (RadioButton)rootView.findViewById( R.id.radioButtonrearentertainmentsno );
        checkBoxpoweroutlets = (CheckBox)rootView.findViewById( R.id.checkBoxpoweroutlets );
        checkBoxlighter = (CheckBox)rootView.findViewById( R.id.checkBoxlighter );
        checkBoxashtrays = (CheckBox)rootView.findViewById( R.id.checkBoxashtrays );
        checkBoxGloveBox = (CheckBox)rootView.findViewById( R.id.checkBoxGloveBox );
        checkBoxconsolefront = (CheckBox)rootView.findViewById( R.id.checkBoxconsolefront );
        checkBoxconsolerear = (CheckBox)rootView.findViewById( R.id.checkBoxconsolerear );
        checkBoxsunvisors = (CheckBox)rootView.findViewById( R.id.checkBoxsunvisors );
        radioButtonadjustablepedals = (RadioGroup)rootView.findViewById( R.id.radioButtonadjustablepedals );
        radioButtonadjustablepedalsyes = (RadioButton)rootView.findViewById( R.id.radioButtonadjustablepedalsyes );
        radioButtonadjustablepedalsno = (RadioButton)rootView.findViewById( R.id.radioButtonadjustablepedalsno );
        checkBoxodorfree = (CheckBox)rootView.findViewById( R.id.checkBoxodorfree );
        radioButtoncarpet = (RadioGroup)rootView.findViewById( R.id.radioButtoncarpet );
        radioButtoncarpetyes = (RadioButton)rootView.findViewById( R.id.radioButtoncarpetyes );
        radioButtoncarpetno = (RadioButton)rootView.findViewById( R.id.radioButtoncarpetno );
        checkBoxfloorMats = (CheckBox)rootView.findViewById( R.id.checkBoxfloorMats );
        radioButtondoortrim = (RadioGroup)rootView.findViewById( R.id.radioButtondoortrim );
        radioButtondoortrimyes = (RadioButton)rootView.findViewById( R.id.radioButtondoortrimyes );
        radioButtondoortrimno = (RadioButton)rootView.findViewById( R.id.radioButtondoortrimno );
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        db = dbHelper.getWritableDatabase();
        checkBoxcooledseat = (CheckBox)rootView.findViewById( R.id.checkBoxcooledseats );
        checkBoxheatedseat = (CheckBox)rootView.findViewById( R.id.checkBoxheatedseats );
        checkBoxseatandhead = (CheckBox)rootView.findViewById( R.id.checkBoxseatandhead );
        checkBoxseatupholstery = (CheckBox)rootView.findViewById( R.id.checkBoxseatupholstery );
        checkBoxfoldingseat = (CheckBox)rootView.findViewById( R.id.checkBoxfoldingseats );
        radioButtonmoonroof = (RadioGroup)rootView.findViewById( R.id.radioButtonmoonroof );
        radioButtonmoonroofyes = (RadioButton)rootView.findViewById( R.id.radioButtonmoonroofyes );
        radioButtonmoonroofno = (RadioButton)rootView.findViewById( R.id.radioButtonmoonroofno );
        plussunroofImage = (ImageView)rootView.findViewById( R.id.plussunroofImage );
        sunroofImage = (ImageView)rootView.findViewById( R.id.sunroofImage );
        radioButtonsnroof = (RadioGroup)rootView.findViewById( R.id.radioButtonsnroof );
        radioButtonsnroofyes = (RadioButton)rootView.findViewById( R.id.radioButtonsnroofyes );
        radioButtonsunroofno = (RadioButton)rootView.findViewById( R.id.radioButtonsunroofno );
        checkBoxdoorhandles = (CheckBox)rootView.findViewById( R.id.checkBoxdoorhandles );
        radioButtondoorentry = (RadioGroup)rootView.findViewById( R.id.radioButtondoorentry );
        radioButtondoorentryyes = (RadioButton)rootView.findViewById( R.id.radioButtondoorentryyes );
        radioButtondoorentryno = (RadioButton)rootView.findViewById( R.id.radioButtondoorentryno );
        radioButtonpushbutton = (RadioGroup)rootView.findViewById( R.id.radioButtonpushbutton );
        radioButtonpushbuttonyes = (RadioButton)rootView.findViewById( R.id.radioButtonpushbuttonyes );
        radioButtonpushbuttonno = (RadioButton)rootView.findViewById( R.id.radioButtonpushbuttonno );
        checkBoxdoorlocks = (CheckBox)rootView.findViewById( R.id.checkBoxdoorlocks );
        checkBoxchildlock = (CheckBox)rootView.findViewById( R.id.checkBoxchildlock );
        checkBoxwindowcontrols = (CheckBox)rootView.findViewById( R.id.checkBoxwindowcontrols );
        checkBoxremotedecklid = (CheckBox)rootView.findViewById( R.id.checkBoxremotedecklid );
        checkBoxfuelfillerdoorrelease = (CheckBox)rootView.findViewById( R.id.checkBoxfuelfillerdoorrelease );
        plussuncompartmentImage = (ImageView)rootView.findViewById( R.id.plussuncompartmentImage );
        compartmentImage = (ImageView)rootView.findViewById( R.id.compartmentImage );
        checkBoxluggagecarpet = (CheckBox)rootView.findViewById( R.id.checkBoxluggagecarpet );
        radioluggagecompartmenttrim = (RadioGroup)rootView.findViewById( R.id.radiobuttoncargonet);
        radioluggagecompartmenttrimyes = (RadioButton)rootView.findViewById( R.id.radiobuttoncargonetyes );
        radioButtonluggagecompartmenttrimno = (RadioButton)rootView.findViewById( R.id.radioButtoncargonetno);
        radioButtoncargoarea = (RadioGroup)rootView.findViewById( R.id.radioButtoncargoarea );
        radioButtoncargoareayes = (RadioButton)rootView.findViewById( R.id.radioButtoncargoareayes );
        radioButtoncargoareano = (RadioButton)rootView.findViewById( R.id.radioButtoncargoareano );
        radioButtonjacktoolkit = (RadioGroup)rootView.findViewById( R.id.radioButtonjacktoolkit );
        radioButtonjacktoolkityes = (RadioButton)rootView.findViewById( R.id.radioButtonjacktoolkityes );
        radioButtonjacktoolkitno = (RadioButton)rootView.findViewById( R.id.radioButtonjacktoolkitno );
        checkBoxsidewallinspection = (CheckBox)rootView.findViewById( R.id.checkBoxsidewallinspection );
        checkBoxairpressureinspection = (CheckBox)rootView.findViewById( R.id.checkBoxairpressureinspection );
        checkBoxtireinflatorkit = (CheckBox)rootView.findViewById( R.id.checkBoxtireinflatorkit );
        checkBoxtrucklidrelease = (CheckBox)rootView.findViewById( R.id.checkBoxtrucklidrelease );
        plusImagestepney = (ImageView)rootView.findViewById( R.id.plusImagestepney );
        stepneyImage = (ImageView)rootView.findViewById( R.id.stepneyImage );
        editTextreplacementcost = (EditText)rootView.findViewById( R.id.editTextreplacementcost );
        editTextreplacement = (EditText)rootView.findViewById( R.id.editTextreplacement );
        saveinterior = (Button)rootView.findViewById( R.id.saveinterior );
        
        saveinterior.setOnClickListener( this );
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("CARID=1").get();
        if(carprogressModal.getINTERIORCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("INTERIORCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }

        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTINTERIOR=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTINTERIOR);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }
    }
    @Override
    public void onClick(View v) {
        if ( v == saveinterior ) {
            mapvalues(v.getRootView());
            InteriorModal interiorModal =new InteriorModal(CARID,AIRBAGS,SAFTEYBELTS,STEREOANDSPEAKERS,ANTENNA,ALARMSYSTEM
            ,NAVIGATIONSYSTEM,AIRCONDITIONINGSYSTEM,HEATINGSYSTEM,DEFOG,CLOCK,TILTSTEERINGWHEEL,STEERINGCOLUMNLOCK,STEERINGWHEELCONTROLS
            ,HORN,WARNINGCHIMES,INSTRUMENTPANELANDWARNINGLIGHT,WINDSHEILDWIPERS,REARWINDOWWIPER,WASHERS,MAPLIGHTS,OUTSIDEREARVIEWMIRRORS
            ,AUTODIMMINGREARVIEW,BLINDSPOT,REARCAMERA,ACTIVEPARKASSIST,REARENTERTAINMENTSYSTEM,POWEROUTLETS,LIGHTER,ASHTRAYS,GLOVEBOX,
                    CENTERCONSOLEFRONT,CENTERCONSOLEFREAR,SUNVISORS,ADJUSTABLEPEDALS,INTERIORODOR,CARPET,FLOODMATS,DOORTRIM,HEADLINER,
                    SEATUPHOLDSTERY,SEATANDHEAD,FOLDINGSEATS,HEATEDSEATS,COOLEDSEATS,CONVERTIBLETOP,SUNROOF,DOORHANDLES,REMOTEENTRY,PUSHBUTTONSTART
            ,DOORLOCKS,CHILDSAFTEYLOCKS,WINDOWCONTROLS,REMOTEDECKLID,FUELFILLERDOOR,CARPETLUGGAGE,CARGONET,CARGOAREALIGHT,JACKTOOLKIT,SIDEWALLINS
            ,PRESSUREINS,TIREKIT,LIDRELEASE,REPAIRINGCOSTINTERIOR,COMMENTINTERIOR);
            InteriorModal interiorModalold = cupboard().withDatabase(db).query(InteriorModal.class).withSelection( "CARID = ?", "1").get();
            if(interiorModalold==null) {
                Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(interiorModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Sucessfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(InteriorModal.class, "CARID = ?", "1");
                cupboard().withDatabase(db).put(interiorModal);
            }
            mapcarprogressvalues();
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
            db.close();
        }
    }

    private void mapvalues(View rootView) {
        CARID=1;
        AIRBAGS=helperFormsFunctions.returnRadioGroup(radioButtonairbags,rootView);
        SAFTEYBELTS=helperFormsFunctions.returnRadioGroup(radioButtonsafteybelts,rootView);
        STEREOANDSPEAKERS=helperFormsFunctions.returnCheckboxValue(checkBoxstereospeakers);
        ANTENNA=helperFormsFunctions.returnCheckboxValue(checkBoxantenna);
        ALARMSYSTEM=helperFormsFunctions.returnCheckboxValue(checkBoxalarmtheftsystem);
        NAVIGATIONSYSTEM=helperFormsFunctions.returnRadioGroup(radioButtonnavisystem,rootView);
        AIRCONDITIONINGSYSTEM=seekBarAirconditioning.getProgress();
        HEATINGSYSTEM=seekBarHeatingSystem.getProgress();
        DEFOG=helperFormsFunctions.returnRadioGroup(radioButtondefog,rootView);
        CLOCK=helperFormsFunctions.returnRadioGroup(radioButtonclock,rootView);
        TILTSTEERINGWHEEL=helperFormsFunctions.returnRadioGroup(radioButtontilttelescopic,rootView);
        STEERINGCOLUMNLOCK=helperFormsFunctions.returnRadioGroup(radioButtonsteeringlock,rootView);
        STEERINGWHEELCONTROLS=helperFormsFunctions.returnRadioGroup(radioButtonsteeringwheels,rootView);
        HORN=helperFormsFunctions.returnCheckboxValue(checkBoxhorn);;
        WARNINGCHIMES=helperFormsFunctions.returnCheckboxValue(checkBoxwarningchimes);;
        INSTRUMENTPANELANDWARNINGLIGHT=helperFormsFunctions.returnCheckboxValue(checkBoxinstrumentpanel);
        WINDSHEILDWIPERS=helperFormsFunctions.returnRadioGroup(radioButtonwipers,rootView);
        REARWINDOWWIPER=helperFormsFunctions.returnRadioGroup(radioButtonrearwiper,rootView);
        WASHERS=helperFormsFunctions.returnRadioGroup(radioButtonwashers,rootView);
        MAPLIGHTS=helperFormsFunctions.returnCheckboxValue(checkBoxdomemaplights);
        OUTSIDEREARVIEWMIRRORS=helperFormsFunctions.returnCheckboxValue(checkBoxoutsiderearviewmirrors);;
        AUTODIMMINGREARVIEW=helperFormsFunctions.returnRadioGroup(radioButtonautodimming,rootView); ;
        BLINDSPOT=helperFormsFunctions.returnRadioGroup(radioButtonblindspot,rootView);
        REARCAMERA=helperFormsFunctions.returnRadioGroup(radioButtonrearcamera,rootView);
        ACTIVEPARKASSIST=helperFormsFunctions.returnCheckboxValue(checkBoxactiveparkassist);
        REARENTERTAINMENTSYSTEM=helperFormsFunctions.returnRadioGroup(radioButtonrearentertainment,rootView);
        POWEROUTLETS=helperFormsFunctions.returnCheckboxValue(checkBoxpoweroutlets);;
        LIGHTER=helperFormsFunctions.returnCheckboxValue(checkBoxlighter);;
        ASHTRAYS=helperFormsFunctions.returnCheckboxValue(checkBoxashtrays);;
        GLOVEBOX=helperFormsFunctions.returnCheckboxValue(checkBoxGloveBox);;
        CENTERCONSOLEFRONT=helperFormsFunctions.returnCheckboxValue(checkBoxconsolefront);;
        CENTERCONSOLEFREAR=helperFormsFunctions.returnCheckboxValue(checkBoxconsolerear);
        SUNVISORS=helperFormsFunctions.returnCheckboxValue(checkBoxsunvisors);
        ADJUSTABLEPEDALS=helperFormsFunctions.returnRadioGroup(radioButtonadjustablepedals,rootView);;
        INTERIORODOR=helperFormsFunctions.returnCheckboxValue(checkBoxodorfree);
        CARPET=helperFormsFunctions.returnRadioGroup(radioButtoncarpet,rootView);
        FLOODMATS=helperFormsFunctions.returnCheckboxValue(checkBoxfloorMats);
        DOORTRIM=helperFormsFunctions.returnRadioGroup(radioButtondoortrim,rootView);;
        HEADLINER=helperFormsFunctions.returnRadioGroup(radioButtonheadliner,rootView);;
        SEATUPHOLDSTERY= helperFormsFunctions.returnCheckboxValue(checkBoxseatupholstery);
        SEATANDHEAD=helperFormsFunctions.returnCheckboxValue(checkBoxseatandhead);
        FOLDINGSEATS=helperFormsFunctions.returnCheckboxValue(checkBoxfoldingseat);
        HEATEDSEATS=helperFormsFunctions.returnCheckboxValue(checkBoxheatedseat);
        COOLEDSEATS=helperFormsFunctions.returnCheckboxValue(checkBoxcooledseat);
        CONVERTIBLETOP=helperFormsFunctions.returnRadioGroup(radioButtonmoonroof,rootView);
        SUNROOF=helperFormsFunctions.returnRadioGroup(radioButtonsnroof,rootView);
        DOORHANDLES=helperFormsFunctions.returnCheckboxValue(checkBoxdoorhandles);
        REMOTEENTRY=helperFormsFunctions.returnRadioGroup(radioButtondoorentry,rootView);
        PUSHBUTTONSTART=helperFormsFunctions.returnRadioGroup(radioButtonpushbutton,rootView);
        DOORLOCKS=helperFormsFunctions.returnCheckboxValue(checkBoxdoorlocks);
        CHILDSAFTEYLOCKS=helperFormsFunctions.returnCheckboxValue(checkBoxchildlock);
        WINDOWCONTROLS=helperFormsFunctions.returnCheckboxValue(checkBoxwindowcontrols);
        REMOTEDECKLID =helperFormsFunctions.returnCheckboxValue(checkBoxremotedecklid);
        FUELFILLERDOOR=helperFormsFunctions.returnCheckboxValue(checkBoxfuelfillerdoorrelease);
        CARPETLUGGAGE=helperFormsFunctions.returnCheckboxValue(checkBoxluggagecarpet);
        CARGONET=helperFormsFunctions.returnRadioGroup(radioluggagecompartmenttrim,rootView);
        CARGOAREALIGHT=helperFormsFunctions.returnRadioGroup(radioButtoncargoarea,rootView); ;
        JACKTOOLKIT =helperFormsFunctions.returnRadioGroup(radioButtonjacktoolkit,rootView);;
        SIDEWALLINS=helperFormsFunctions.returnCheckboxValue(checkBoxsidewallinspection); ;
        PRESSUREINS=helperFormsFunctions.returnCheckboxValue(checkBoxairpressureinspection); ;
        TIREKIT=helperFormsFunctions.returnCheckboxValue(checkBoxtireinflatorkit);;
        LIDRELEASE=helperFormsFunctions.returnCheckboxValue(checkBoxtrucklidrelease);;
        try {
            REPAIRINGCOSTINTERIOR=Float.valueOf(editTextreplacementcost.getText().toString());
        }catch (Exception e){}
        COMMENTINTERIOR=editTextreplacement.getText().toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.interior_form,container, false);
        initialize(rootView);
        findViews(rootView);
        returnchanges();
        return rootView;
    }

    private void returnchanges() {
        InteriorModal interiorModal = cupboard().withDatabase(db).query(InteriorModal.class).withSelection("CARID=1").get();
        if(interiorModal!=null){
            checkBoxactiveparkassist.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getACTIVEPARKASSIST()));
            checkBoxseatandhead.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getSEATANDHEAD()));
            checkBoxfoldingseat.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getFOLDINGSEATS()));
            checkBoxairpressureinspection.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getPRESSUREINS()));
            checkBoxashtrays.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getASHTRAYS()));
            checkBoxchildlock.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getCHILDSAFTEYLOCKS()));
            checkBoxantenna.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getANTENNA()));
            checkBoxheatedseat.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getHEATEDSEATS()));
            checkBoxGloveBox.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getGLOVEBOX()));
            checkBoxdoorhandles.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getDOORHANDLES()));
            checkBoxfloorMats.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getFLOODMATS()));
            checkBoxfuelfillerdoorrelease.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getFUELFILLERDOOR()));
            checkBoxalarmtheftsystem.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getALARMSYSTEM()));
            checkBoxhorn.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getHORN()));
            checkBoxdoorlocks.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getDOORLOCKS()));
            checkBoxdomemaplights.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getMAPLIGHTS()));
            checkBoxcooledseat.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getCOOLEDSEATS()));
            checkBoxconsolerear.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getCENTERCONSOLEFREAR()));
            checkBoxconsolefront.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getCENTERCONSOLEFRONT()));
            checkBoxseatupholstery.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getSEATUPHOLDSTERY()));
            checkBoxwarningchimes.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getWARNINGCHIMES()));
            checkBoxsidewallinspection.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getSIDEWALLINS()));
            checkBoxpoweroutlets.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getPOWEROUTLETS()));
            checkBoxinstrumentpanel.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getINSTRUMENTPANELANDWARNINGLIGHT()));
            checkBoxsunvisors.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getSUNVISORS()));
            checkBoxwindowcontrols.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getWINDOWCONTROLS()));
            checkBoxstereospeakers.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getSTEREOANDSPEAKERS()));
            checkBoxlighter.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getLIGHTER()));
            checkBoxtrucklidrelease.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getLIDRELEASE()));
            checkBoxodorfree.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getINTERIORODOR()));
            checkBoxluggagecarpet.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getCARPETLUGGAGE()));
            checkBoxoutsiderearviewmirrors .setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getOUTSIDEREARVIEWMIRRORS()));
            checkBoxtireinflatorkit.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getTIREKIT()));
            checkBoxremotedecklid.setChecked(helperFormsFunctions.returnCheckboxValue(interiorModal.getREMOTEDECKLID()));
            if(interiorModal.getREPAIRINGCOSTINTERIOR()!=null) {
                editTextreplacementcost.setText(String.valueOf(interiorModal.getREPAIRINGCOSTINTERIOR()));
                OLDCOST=interiorModal.getREPAIRINGCOSTINTERIOR();
            }else{
                OLDCOST=0f;
            }
            editTextreplacement.setText(interiorModal.getCOMMENTINTERIOR());
            seekBarAirconditioning.setProgress(interiorModal.getAIRCONDITIONINGSYSTEM());
            seekBarHeatingSystem.setProgress(interiorModal.getHEATINGSYSTEM());
            progress1.setText(String.valueOf(interiorModal.getAIRCONDITIONINGSYSTEM()));
            progress2.setText(String.valueOf(interiorModal.getHEATINGSYSTEM()));
            feedbackprogress1.setText(helperFormsFunctions.returnFeedbackSeekBar(interiorModal.getAIRCONDITIONINGSYSTEM()));
            feedbackprogress2.setText(helperFormsFunctions.returnFeedbackSeekBar(interiorModal.getHEATINGSYSTEM()));
            helperFormsFunctions.setValueRadiobutton(radioButtonadjustablepedals,radioButtonadjustablepedalsyes.getId(),radioButtonadjustablepedalsno.getId(),interiorModal.getADJUSTABLEPEDALS());
            helperFormsFunctions.setValueRadiobutton(radioButtonairbags,radioButtonairbagsyes.getId(),radioButtonairbagsno.getId(),interiorModal.getAIRBAGS());
            helperFormsFunctions.setValueRadiobutton(radioButtonautodimming,radioButtonautodimmingyes.getId(),radioButtonautodimmingno.getId(),interiorModal.getAUTODIMMINGREARVIEW());
            helperFormsFunctions.setValueRadiobutton(radioButtonblindspot,radioButtonblindspotyes.getId(),radioButtonblindspotno.getId(),interiorModal.getBLINDSPOT());
            helperFormsFunctions.setValueRadiobutton(radioButtoncarpet,radioButtoncarpetyes.getId(),radioButtoncarpetno.getId(),interiorModal.getCARPET());
            helperFormsFunctions.setValueRadiobutton(radioButtoncargoarea,radioButtoncargoareayes.getId(),radioButtoncargoareano.getId(),interiorModal.getCARGOAREALIGHT());
            helperFormsFunctions.setValueRadiobutton(radioButtonclock,radioButtonclockyes.getId(),radioButtonclockno.getId(),interiorModal.getCLOCK());
            helperFormsFunctions.setValueRadiobutton(radioButtonjacktoolkit,radioButtonjacktoolkityes.getId(),radioButtonjacktoolkitno.getId(),interiorModal.getJACKTOOLKIT());
            helperFormsFunctions.setValueRadiobutton(radioButtondoorentry,radioButtondoorentryyes.getId(),radioButtondoorentryno.getId(),interiorModal.getREMOTEENTRY());
            helperFormsFunctions.setValueRadiobutton(radioButtonwipers,radioButtonwipersyes.getId(),radioButtonwipersno.getId(),interiorModal.getWINDSHEILDWIPERS());
            helperFormsFunctions.setValueRadiobutton(radioButtonwashers,radioButtonwashersyes.getId(),radioButtonswashersno.getId(),interiorModal.getWASHERS());
            helperFormsFunctions.setValueRadiobutton(radioButtondefog,radioButtondefogyes.getId(),radioButtondefogno.getId(),interiorModal.getDEFOG());
            helperFormsFunctions.setValueRadiobutton(radioButtonheadliner,radioButtonheadlineryes.getId(),radioButtonheadlinerno.getId(),interiorModal.getHEADLINER());
            helperFormsFunctions.setValueRadiobutton(radioButtonnavisystem,radioButtonnavisystemyes.getId(),radioButtonnavisystemno.getId(),interiorModal.getNAVIGATIONSYSTEM());
            helperFormsFunctions.setValueRadiobutton(radioButtondoortrim,radioButtondoortrimyes.getId(),radioButtondoortrimno.getId(),interiorModal.getDOORTRIM());
            helperFormsFunctions.setValueRadiobutton(radioButtonmoonroof,radioButtonmoonroofyes.getId(),radioButtonmoonroofno.getId(),interiorModal.getCONVERTIBLETOP());
            helperFormsFunctions.setValueRadiobutton(radioButtonrearcamera,radioButtonrearcamerayes.getId(),radioButtonrearcamerano.getId(),interiorModal.getREARCAMERA());
            helperFormsFunctions.setValueRadiobutton(radioButtonsnroof,radioButtonsnroofyes.getId(),radioButtonsunroofno.getId(),interiorModal.getSUNROOF());

            helperFormsFunctions.setValueRadiobutton(radioButtontilttelescopic,radioButtontilttelescopicyes.getId(),radioButtontilttelescopicno.getId(),interiorModal.getTILTSTEERINGWHEEL());
            helperFormsFunctions.setValueRadiobutton(radioButtonsafteybelts,radioButtonsafteybeltsyes.getId(),radioButtonsafteybeltsno.getId(),interiorModal.getSAFTEYBELTS());
            helperFormsFunctions.setValueRadiobutton(radioButtonpushbutton,radioButtonpushbuttonyes.getId(),radioButtonpushbuttonno.getId(),interiorModal.getPUSHBUTTONSTART());
            helperFormsFunctions.setValueRadiobutton(radioButtonsteeringlock,radioButtonsteeringlockyes.getId(),radioButtonsteeringlockno.getId(),interiorModal.getSTEERINGCOLUMNLOCK());
            helperFormsFunctions.setValueRadiobutton(radioluggagecompartmenttrim,radioluggagecompartmenttrimyes.getId(),radioButtonluggagecompartmenttrimno.getId(),interiorModal.getCARGONET());
            helperFormsFunctions.setValueRadiobutton(radioButtonsteeringwheels,radioButtonsteeringwheelsyes.getId(),radioButtonsteeringwheelsno.getId(),interiorModal.getSTEERINGWHEELCONTROLS());
            helperFormsFunctions.setValueRadiobutton(radioButtonrearwiper,radioButtonrearwiperyes.getId(),radioButtonrearwiperno.getId(),interiorModal.getREARWINDOWWIPER());
            helperFormsFunctions.setValueRadiobutton(radioButtonrearentertainment,radioButtonrearentertainmentyes.getId(),radioButtonrearentertainmentsno.getId(),interiorModal.getREARENTERTAINMENTSYSTEM());
        }else{
            OLDCOST=0f;
        }
    }

    void initialize(View view){
        seekBarAirconditioning= (SeekBar) view.findViewById(R.id.seekBarairconditioning);
        seekBarHeatingSystem= (SeekBar) view.findViewById(R.id.seekBarheatingsystem);
        seekBarAirconditioning.setOnSeekBarChangeListener(this);
        seekBarHeatingSystem.setOnSeekBarChangeListener(this);
        progress1=(TextView)view.findViewById(R.id.seekbarvalue1);
        progress2=(TextView)view.findViewById(R.id.seekbarvalue2);
        feedbackprogress1=(TextView)view.findViewById(R.id.seekbarvaluefeedback1);
        feedbackprogress2=(TextView)view.findViewById(R.id.seekbarvaluefeedback2);
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId()==seekBarAirconditioning.getId()){
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
}
