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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Adapters.SeekBarListAdapter;
import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.Helpers.ListHelper;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.UnderhoodModal;

import java.io.IOException;
import java.util.ArrayList;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class UnderhoodFragment extends android.app.Fragment implements View.OnClickListener {
    static SQLiteDatabase db;
    HelperFormsFunctions helperFormsFunctions;
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
    private ImageView engine1,engine2,plusengine1,plusengine2;
    String id;
    String ENGINEOIL ;
    String CHASISTUBE ;
    String COOLANT ;
    String BRAKEFLUID ;
    String TRANSAXLEFLUID ;
    String TRANSFERCASEFUID ;
    String DRIVEAXLEFLUID ;
    String POWERSTEERINGFLUID ;
    String MANUALTRANSFLUID ;
    String WASHERFLUID ;
    String AIRCONDITIONINGSYSTEMCHARGE ;
    String FLUIDLEAKS ;
    String HOSESLINESFITTINGS ;
    String BELTS ;
    String WIRING ;
    String OILINAIRCLEANSER ;
    String WATERSLUDGEOIL ;
    String OILPRESSURE ;
    String RELATIVECYLENDIRCOMPRESSION ;
    String TIMINGBELT ;
    String ENGINEMOUNTS ;
    String TURBOCHARGERAIRCOOLER ;
    String RADIATOR ;
    String RADIATORCAP ;
    String COOLINGFANS ;
    String WATERPUMP ;
    String COOLANTRECOVERYTANK ;
    String CABINAIRFILTER ;
    String FUELPUMPNOISENORMAL ;
    String FUELPUMPPRESSURE ;
    String FUELFILTER ;
    String ENGINEAIRFILTER ;
    String STARTEROPERATION ;
    String IGNITIONSYSTEM ;
    String BATTERY ;
    String ALTERNATOROUTPUT ;
    String DIESELGLOWPLUGSYSTEM ;
    Float REPAIRINGCOSTUNDERHOOD ;
    String COMMENTUNDERHOOD ;
    Float OLDCOST;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.underhood_form,container, false);
        initialize(rootView);
        setHasOptionsMenu(true);
        returnchanges();
        return rootView;
    }

    private void returnchanges() {
        id=getActivity().getIntent().getExtras().getString("id");
        Log.d("id",id);
        UnderhoodModal underhoodModal = cupboard().withDatabase(db).query(UnderhoodModal.class).withSelection("id=?",id).get();
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
            helperFormsFunctions.loadImageFromStorage(engine1,1,id,Config.underhoodimg+"engine");
            helperFormsFunctions.loadImageFromStorage(engine2,2,id,Config.underhoodimg+"engine");
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
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("id=?",id).get();
        if(carprogressModal.getUNDERHOODCOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(2);
            values.put("UNDERHOODCOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTUNDERHOOD=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTUNDERHOOD);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
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
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
        engine1=(ImageView)rootView.findViewById(R.id.engine1Image);
        engine2=(ImageView)rootView.findViewById(R.id.engine2Image);
        plusengine1=(ImageView)rootView.findViewById(R.id.plusengine1);
        plusengine2=(ImageView)rootView.findViewById(R.id.plusengine2);
        engine1.setOnClickListener(this);
        engine2.setOnClickListener(this);
        plusengine1.setOnClickListener(this);
        plusengine2.setOnClickListener(this);
        saveunderhood.setOnClickListener(this);
        HelperFormsFunctions.setButton(saveunderhood);
    }
    @Override
    public void onClick(View v) {
        if(v==saveunderhood) {
            mapvalues();
            mapcarprogressvalues();
            UnderhoodModal underhoodModal = new UnderhoodModal(id, ENGINEOIL, CHASISTUBE, COOLANT, BRAKEFLUID, TRANSAXLEFLUID,
                    TRANSFERCASEFUID, DRIVEAXLEFLUID, POWERSTEERINGFLUID, MANUALTRANSFLUID, WASHERFLUID, AIRCONDITIONINGSYSTEMCHARGE,
                    FLUIDLEAKS, HOSESLINESFITTINGS, BELTS, WIRING, OILINAIRCLEANSER, WATERSLUDGEOIL, OILPRESSURE, RELATIVECYLENDIRCOMPRESSION, TIMINGBELT
                    , ENGINEMOUNTS, TURBOCHARGERAIRCOOLER, RADIATOR, RADIATORCAP, COOLINGFANS, WATERPUMP, COOLANTRECOVERYTANK, CABINAIRFILTER,
                    FUELPUMPNOISENORMAL, FUELPUMPPRESSURE, FUELFILTER, ENGINEAIRFILTER, STARTEROPERATION, IGNITIONSYSTEM, BATTERY,
                    ALTERNATOROUTPUT, DIESELGLOWPLUGSYSTEM, REPAIRINGCOSTUNDERHOOD, COMMENTUNDERHOOD);
            UnderhoodModal underhoodModalold = cupboard().withDatabase(db).query(UnderhoodModal.class).withSelection("id = ?", id).get();
            if (underhoodModalold == null) {
                Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(underhoodModal);
            } else {
                Toast.makeText(getActivity(), "Changes Made Sucessfully", Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(UnderhoodModal.class, "id = ?", id);
                cupboard().withDatabase(db).put(underhoodModal);
            }
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            db.close();
            getActivity().finish();
        }else if(v==engine1 || v==plusengine1) {
            captureimage(1);
        }else if(v==engine2 || v==plusengine2){
            captureimage(2);
        }
    }

    private void captureimage(int code) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,"data");
        startActivityForResult(cameraIntent, code);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {;
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            switch (requestCode){
                case 1:
                    engine1.setImageBitmap(photo);
                    try {
                        helperFormsFunctions.saveToInternalStorage(photo,1,id,Config.underhoodimg+"engine");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    engine2.setImageBitmap(photo);
                    try {
                        helperFormsFunctions.saveToInternalStorage(photo,2,id,Config.underhoodimg+"engine");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    private void mapvalues() {
        SeekBarListAdapter adapter= (SeekBarListAdapter) listViewFluids.getAdapter();
        ENGINEOIL=String.valueOf(adapter.values.get(0)) ;
        CHASISTUBE=String.valueOf(adapter.values.get(1));
        COOLANT=String.valueOf(adapter.values.get(2));
        BRAKEFLUID=String.valueOf(adapter.values.get(3)); ;
        TRANSAXLEFLUID =String.valueOf(adapter.values.get(4));;
        TRANSFERCASEFUID =String.valueOf(adapter.values.get(5));;
        DRIVEAXLEFLUID =String.valueOf(adapter.values.get(6));;
        POWERSTEERINGFLUID =String.valueOf(adapter.values.get(7));;
        MANUALTRANSFLUID =String.valueOf(adapter.values.get(8));;
        WASHERFLUID =String.valueOf(adapter.values.get(9));;
        AIRCONDITIONINGSYSTEMCHARGE =String.valueOf(adapter.values.get(10));;

        adapter= (SeekBarListAdapter) listViewEngine.getAdapter();
        FLUIDLEAKS =String.valueOf(adapter.values.get(0));
        HOSESLINESFITTINGS =String.valueOf(adapter.values.get(1));
        BELTS =String.valueOf(adapter.values.get(2));
        WIRING =String.valueOf(adapter.values.get(3));
        OILINAIRCLEANSER =String.valueOf(adapter.values.get(4));
        WATERSLUDGEOIL =String.valueOf(adapter.values.get(5));
        OILPRESSURE =String.valueOf(adapter.values.get(6));
        RELATIVECYLENDIRCOMPRESSION =String.valueOf(adapter.values.get(7));
        TIMINGBELT =String.valueOf(adapter.values.get(8));
        ENGINEMOUNTS =String.valueOf(adapter.values.get(9));
        TURBOCHARGERAIRCOOLER =String.valueOf(adapter.values.get(10));

        adapter= (SeekBarListAdapter) listViewCoolingsystem.getAdapter();
        RADIATOR =String.valueOf(adapter.values.get(0));
        RADIATORCAP =String.valueOf(adapter.values.get(1));
        COOLINGFANS =String.valueOf(adapter.values.get(2));
        WATERPUMP =String.valueOf(adapter.values.get(3));
        COOLANTRECOVERYTANK =String.valueOf(adapter.values.get(4));
        CABINAIRFILTER =String.valueOf(adapter.values.get(5));

        adapter= (SeekBarListAdapter) listViewFuelsystem.getAdapter();
        FUELPUMPNOISENORMAL =String.valueOf(adapter.values.get(1));
        FUELPUMPPRESSURE =String.valueOf(adapter.values.get(2));
        FUELFILTER =String.valueOf(adapter.values.get(3));
        ENGINEAIRFILTER =String.valueOf(adapter.values.get(4));

        adapter= (SeekBarListAdapter) listViewFuelsystem.getAdapter();
        STARTEROPERATION =String.valueOf(adapter.values.get(0));
        IGNITIONSYSTEM =String.valueOf(adapter.values.get(1));
        BATTERY =String.valueOf(adapter.values.get(2));
        ALTERNATOROUTPUT =String.valueOf(adapter.values.get(3));
        DIESELGLOWPLUGSYSTEM =String.valueOf(adapter.values.get(4));

        try {
            REPAIRINGCOSTUNDERHOOD=Float.valueOf(editTextreplacementcost.getText().toString());
        }catch (Exception e){}
        COMMENTUNDERHOOD=editTextreplacement.getText().toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miCompose:
                Log.d("here","here");
                saveunderhood.performClick();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
