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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Adapters.SeekBarListAdapter;
import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.ListHelper;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.UnderhoodModal;

import java.util.ArrayList;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class UnderhoodFragment extends android.app.Fragment implements View.OnClickListener {
    static SQLiteDatabase db;
    private ListView listViewFluids,listViewEngine,listViewCoolingsystem,listViewFuelsystem,listViewElectricalsystem;
    private String[] fluidstitles={"Engine Oil/Filter Change","Chassis Lube","Coolant","Brake Fluid","Automatic Trans axle/Transmission Fluid",
    "Transfer Case Fluid","Drive Axle Fluid","Power Steering Fluid","Manual Trans axle/Transmission Hydraulic Clutch Fluid","Washer Fluid","Air Conditioning System Charge"};
    private String[] enginetitles={"Fluid Leaks","Hoses, Lines and Fittings","Belts","Wiring","Oil in Air Cleaner Housing","Water, Sludge or Engine Coolant in Oil",
    "Oil Pressure","Relative Cylinder Compression Test/Power Balance Readings (check if necessary)","Timing Belt","Engine Mounts","Inspect Turbo charger Air Cooler"};
    private String[] coolingsystemtitles={"Radiator","Pressure-Test Radiator Cap and Radiator","Cooling Fans, Clutches and Motors","Water Pump","Coolant Recovery Tank",
    "Cabin Air Filter"};
    private String[] fueltitles={"Fuel Pump Noise Normal","Fuel Pump Pressure","Fuel Filter","Engine Air Filter"};
    private String[] electricaltitles={"Starter Operation","Ignition System","Battery","Alternator Output","Diesel Glow Plug System"};
    private EditText editTextreplacementcost;
    private EditText editTextreplacement;
    private Button saveunderhood;

    Integer CARID;
    Integer ENGINEOIL ;
    Integer CHASISTUBE ;
    Integer COOLANT ;
    Integer BRAKEFLUID ;
    Integer TRANSAXLEFLUID ;
    Integer TRANSFERCASEFUID ;
    Integer DRIVEAXLEFLUID ;
    Integer POWERSTEERINGFLUID ;
    Integer MANUALTRANSFLUID ;
    Integer WASHERFLUID ;
    Integer AIRCONDITIONINGSYSTEMCHARGE ;
    Integer FLUIDLEAKS ;
    Integer HOSESLINESFITTINGS ;
    Integer BELTS ;
    Integer WIRING ;
    Integer OILINAIRCLEANSER ;
    Integer WATERSLUDGEOIL ;
    Integer OILPRESSURE ;
    Integer RELATIVECYLENDIRCOMPRESSION ;
    Integer TIMINGBELT ;
    Integer ENGINEMOUNTS ;
    Integer TURBOCHARGERAIRCOOLER ;
    Integer RADIATOR ;
    Integer RADIATORCAP ;
    Integer COOLINGFANS ;
    Integer WATERPUMP ;
    Integer COOLANTRECOVERYTANK ;
    Integer CABINAIRFILTER ;
    Integer FUELPUMPNOISENORMAL ;
    Integer FUELPUMPPRESSURE ;
    Integer FUELFILTER ;
    Integer ENGINEAIRFILTER ;
    Integer STARTEROPERATION ;
    Integer IGNITIONSYSTEM ;
    Integer BATTERY ;
    Integer ALTERNATOROUTPUT ;
    Integer DIESELGLOWPLUGSYSTEM ;
    Float REPAIRINGCOSTUNDERHOOD ;
    String COMMENTUNDERHOOD ;
    Float OLDCOST;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.underhood_form,container, false);
        initialize(rootView);
        returnchanges();
        return rootView;
    }

    private void returnchanges() {
        UnderhoodModal underhoodModal = cupboard().withDatabase(db).query(UnderhoodModal.class).withSelection("CARID=1").get();
        ArrayList<String> values0;
        ArrayList<String> values1;
        ArrayList<String> values2;
        ArrayList<String> values3;
        ArrayList<String> values4;
        if(underhoodModal!=null){
            values0=new ArrayList<String>();
            values0.add(String.valueOf(underhoodModal.getENGINEOIL()));
            values0.add(String.valueOf(underhoodModal.getCHASISTUBE()));
            values0.add(String.valueOf(underhoodModal.getCOOLANT()));
            values0.add(String.valueOf(underhoodModal.getBRAKEFLUID()));
            values0.add(String.valueOf(underhoodModal.getTRANSAXLEFLUID()));
            values0.add(String.valueOf(underhoodModal.getTRANSFERCASEFUID()));
            values0.add(String.valueOf(underhoodModal.getDRIVEAXLEFLUID()));
            values0.add(String.valueOf(underhoodModal.getPOWERSTEERINGFLUID()));
            values0.add(String.valueOf(underhoodModal.getMANUALTRANSFLUID()));
            values0.add(String.valueOf(underhoodModal.getWASHERFLUID()));
            values0.add(String.valueOf(underhoodModal.getAIRCONDITIONINGSYSTEMCHARGE()));

            values1=new ArrayList<String>();
            values1.add(String.valueOf(underhoodModal.getENGINEOIL()));
            values1.add(String.valueOf(underhoodModal.getFLUIDLEAKS()));
            values1.add(String.valueOf(underhoodModal.getHOSESLINESFITTINGS()));
            values1.add(String.valueOf(underhoodModal.getBELTS()));
            values1.add(String.valueOf(underhoodModal.getWIRING()));
            values1.add(String.valueOf(underhoodModal.getOILINAIRCLEANSER()));
            values1.add(String.valueOf(underhoodModal.getWATERSLUDGEOIL()));
            values1.add(String.valueOf(underhoodModal.getOILPRESSURE()));
            values1.add(String.valueOf(underhoodModal.getRELATIVECYLENDIRCOMPRESSION()));
            values1.add(String.valueOf(underhoodModal.getTIMINGBELT()));
            values1.add(String.valueOf(underhoodModal.getENGINEMOUNTS()));
            values1.add(String.valueOf(underhoodModal.getTURBOCHARGERAIRCOOLER()));

            values2=new ArrayList<String>();
            values2.add(String.valueOf(underhoodModal.getRADIATOR()));
            values2.add(String.valueOf(underhoodModal.getRADIATORCAP()));
            values2.add(String.valueOf(underhoodModal.getCOOLINGFANS()));
            values2.add(String.valueOf(underhoodModal.getWATERPUMP()));
            values2.add(String.valueOf(underhoodModal.getCOOLANTRECOVERYTANK()));
            values2.add(String.valueOf(underhoodModal.getCABINAIRFILTER()));

            values3=new ArrayList<String>();
            values3.add(String.valueOf(underhoodModal.getFUELPUMPNOISENORMAL()));
            values3.add(String.valueOf(underhoodModal.getFUELPUMPPRESSURE()));
            values3.add(String.valueOf(underhoodModal.getFUELFILTER()));
            values3.add(String.valueOf(underhoodModal.getENGINEAIRFILTER()));

            values4=new ArrayList<String>();
            values4.add(String.valueOf(underhoodModal.getSTARTEROPERATION()));
            values4.add(String.valueOf(underhoodModal.getIGNITIONSYSTEM()));
            values4.add(String.valueOf(underhoodModal.getBATTERY()));
            values4.add(String.valueOf(underhoodModal.getALTERNATOROUTPUT()));
            values4.add(String.valueOf(underhoodModal.getDIESELGLOWPLUGSYSTEM()));

            listViewFluids.setAdapter(new SeekBarListAdapter(getActivity(), fluidstitles,values0,this));
            listViewEngine.setAdapter(new SeekBarListAdapter(getActivity(), enginetitles,values1,this));
            listViewCoolingsystem.setAdapter(new SeekBarListAdapter(getActivity(),coolingsystemtitles,values2,this));
            listViewFuelsystem.setAdapter(new SeekBarListAdapter(getActivity(), fueltitles,values3,this));
            listViewElectricalsystem.setAdapter(new SeekBarListAdapter(getActivity(), electricaltitles,values4,this));
            ListHelper.getListViewSize(listViewFluids,getActivity(),this,fluidstitles);
            ListHelper.getListViewSize(listViewCoolingsystem,getActivity(),this,coolingsystemtitles);
            ListHelper.getListViewSize(listViewElectricalsystem,getActivity(),this,electricaltitles);
            ListHelper.getListViewSize(listViewEngine,getActivity(),this,enginetitles);
            ListHelper.getListViewSize(listViewFuelsystem,getActivity(),this,fueltitles);

            if(underhoodModal.getREPAIRINGCOSTUNDERHOOD()!=null) {
                editTextreplacementcost.setText(String.valueOf(underhoodModal.getREPAIRINGCOSTUNDERHOOD()));
                OLDCOST=underhoodModal.getREPAIRINGCOSTUNDERHOOD();
            }else{
                OLDCOST=0f;
            }
            editTextreplacement.setText(underhoodModal.getCOMMENTUNDERHOOD());

        }else{
            OLDCOST=0f;
            values0=null;
            values1=null;
            values2=null;
            values3=null;
            values4=null;
            listViewFluids.setAdapter(new SeekBarListAdapter(getActivity(), fluidstitles,values0,this));
            listViewEngine.setAdapter(new SeekBarListAdapter(getActivity(), enginetitles,values1,this));
            listViewCoolingsystem.setAdapter(new SeekBarListAdapter(getActivity(),coolingsystemtitles,values2,this));
            listViewFuelsystem.setAdapter(new SeekBarListAdapter(getActivity(), fueltitles,values3,this));
            listViewElectricalsystem.setAdapter(new SeekBarListAdapter(getActivity(), electricaltitles,values4,this));
            ListHelper.getListViewSize(listViewFluids,getActivity(),this,fluidstitles);
            ListHelper.getListViewSize(listViewCoolingsystem,getActivity(),this,coolingsystemtitles);
            ListHelper.getListViewSize(listViewElectricalsystem,getActivity(),this,electricaltitles);
            ListHelper.getListViewSize(listViewEngine,getActivity(),this,enginetitles);
            ListHelper.getListViewSize(listViewFuelsystem,getActivity(),this,fueltitles);
        }
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("CARID=1").get();
        if(carprogressModal.getUNDERHOODCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("UNDERHOODCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTUNDERHOOD=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTUNDERHOOD);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }
    }
    void initialize(View rootView){
        listViewFluids=(ListView)rootView.findViewById(R.id.listfluids);
        listViewEngine=(ListView)rootView.findViewById(R.id.listengine);
        listViewCoolingsystem=(ListView)rootView.findViewById(R.id.listcoolingsystem);
        listViewFuelsystem=(ListView)rootView.findViewById(R.id.listfuelsystem);
        listViewElectricalsystem=(ListView)rootView.findViewById(R.id.listelectricalsystem);
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        editTextreplacementcost = (EditText)rootView.findViewById( R.id.editTextreplacementcost );
        editTextreplacement = (EditText)rootView.findViewById( R.id.editTextreplacement );
        saveunderhood = (Button)rootView.findViewById( R.id.saveunderhood );
        db = dbHelper.getWritableDatabase();
        saveunderhood.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        mapvalues();
        mapcarprogressvalues();
        UnderhoodModal underhoodModal=new UnderhoodModal(CARID,ENGINEOIL,CHASISTUBE,COOLANT,BRAKEFLUID,TRANSAXLEFLUID,
                TRANSFERCASEFUID,DRIVEAXLEFLUID,POWERSTEERINGFLUID,MANUALTRANSFLUID,WASHERFLUID,AIRCONDITIONINGSYSTEMCHARGE,
                FLUIDLEAKS,HOSESLINESFITTINGS,BELTS,WIRING,OILINAIRCLEANSER,WATERSLUDGEOIL,OILPRESSURE,RELATIVECYLENDIRCOMPRESSION,TIMINGBELT
                ,ENGINEMOUNTS,TURBOCHARGERAIRCOOLER,RADIATOR,RADIATORCAP,COOLINGFANS,WATERPUMP,COOLANTRECOVERYTANK,CABINAIRFILTER,
                FUELPUMPNOISENORMAL,FUELPUMPPRESSURE,FUELFILTER,ENGINEAIRFILTER,STARTEROPERATION,IGNITIONSYSTEM,BATTERY,
                ALTERNATOROUTPUT,DIESELGLOWPLUGSYSTEM,REPAIRINGCOSTUNDERHOOD,COMMENTUNDERHOOD);
        UnderhoodModal underhoodModalold = cupboard().withDatabase(db).query(UnderhoodModal.class).withSelection( "CARID = ?", "1").get();
        if(underhoodModalold==null) {
            Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();
            cupboard().withDatabase(db).put(underhoodModal);
        }else{
            Toast.makeText(getActivity(),"Changes Made Sucessfully",Toast.LENGTH_SHORT).show();
            cupboard().withDatabase(db).delete(UnderhoodModal.class, "CARID = ?", "1");
            cupboard().withDatabase(db).put(underhoodModal);
        }
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        db.close();
        getActivity().finish();
    }

    private void mapvalues() {
        SeekBarListAdapter adapter= (SeekBarListAdapter) listViewFluids.getAdapter();
        CARID=1;
        ENGINEOIL=Integer.valueOf(adapter.values.get(0)) ;
        CHASISTUBE=Integer.valueOf(adapter.values.get(1));
        COOLANT=Integer.valueOf(adapter.values.get(2));
        BRAKEFLUID=Integer.valueOf(adapter.values.get(3)); ;
        TRANSAXLEFLUID =Integer.valueOf(adapter.values.get(4));;
        TRANSFERCASEFUID =Integer.valueOf(adapter.values.get(5));;
        DRIVEAXLEFLUID =Integer.valueOf(adapter.values.get(6));;
        POWERSTEERINGFLUID =Integer.valueOf(adapter.values.get(7));;
        MANUALTRANSFLUID =Integer.valueOf(adapter.values.get(8));;
        WASHERFLUID =Integer.valueOf(adapter.values.get(9));;
        AIRCONDITIONINGSYSTEMCHARGE =Integer.valueOf(adapter.values.get(10));;

        adapter= (SeekBarListAdapter) listViewEngine.getAdapter();
        FLUIDLEAKS =Integer.valueOf(adapter.values.get(0));
        HOSESLINESFITTINGS =Integer.valueOf(adapter.values.get(1));
        BELTS =Integer.valueOf(adapter.values.get(2));
        WIRING =Integer.valueOf(adapter.values.get(3));
        OILINAIRCLEANSER =Integer.valueOf(adapter.values.get(4));
        WATERSLUDGEOIL =Integer.valueOf(adapter.values.get(5));
        OILPRESSURE =Integer.valueOf(adapter.values.get(6));
        RELATIVECYLENDIRCOMPRESSION =Integer.valueOf(adapter.values.get(7));
        TIMINGBELT =Integer.valueOf(adapter.values.get(8));
        ENGINEMOUNTS =Integer.valueOf(adapter.values.get(9));
        TURBOCHARGERAIRCOOLER =Integer.valueOf(adapter.values.get(10));

        adapter= (SeekBarListAdapter) listViewCoolingsystem.getAdapter();
        RADIATOR =Integer.valueOf(adapter.values.get(0));
        RADIATORCAP =Integer.valueOf(adapter.values.get(1));
        COOLINGFANS =Integer.valueOf(adapter.values.get(2));
        WATERPUMP =Integer.valueOf(adapter.values.get(3));
        COOLANTRECOVERYTANK =Integer.valueOf(adapter.values.get(4));
        CABINAIRFILTER =Integer.valueOf(adapter.values.get(5));

        adapter= (SeekBarListAdapter) listViewFuelsystem.getAdapter();
        FUELPUMPNOISENORMAL =Integer.valueOf(adapter.values.get(1));
        FUELPUMPPRESSURE =Integer.valueOf(adapter.values.get(2));
        FUELFILTER =Integer.valueOf(adapter.values.get(3));
        ENGINEAIRFILTER =Integer.valueOf(adapter.values.get(4));

        adapter= (SeekBarListAdapter) listViewFuelsystem.getAdapter();
        STARTEROPERATION =Integer.valueOf(adapter.values.get(0));
        IGNITIONSYSTEM =Integer.valueOf(adapter.values.get(1));
        BATTERY =Integer.valueOf(adapter.values.get(2));
        ALTERNATOROUTPUT =Integer.valueOf(adapter.values.get(3));
        DIESELGLOWPLUGSYSTEM =Integer.valueOf(adapter.values.get(4));

        try {
            REPAIRINGCOSTUNDERHOOD=Float.valueOf(editTextreplacementcost.getText().toString());
        }catch (Exception e){}
        COMMENTUNDERHOOD=editTextreplacement.getText().toString();
    }
}
