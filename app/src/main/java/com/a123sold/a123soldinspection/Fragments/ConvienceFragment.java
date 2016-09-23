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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.ConvienceModal;

import java.io.File;
import java.io.IOException;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by akshit on 24/7/16.
 */
public class ConvienceFragment extends android.app.Fragment implements View.OnClickListener{
    static SQLiteDatabase db;
    HelperFormsFunctions helperFormsFunctions;
    private ImageView pluscar1;
    private ImageView carImage1;
    private ImageView pluscar2;
    private ImageView carImage2;
    private ImageView pluscar3;
    private ImageView carImage3;
    private ImageView pluscar4;
    private ImageView carImage4;
    private ImageView pluscar5;
    private ImageView carImage5;
    private ImageView pluscar6;
    private ImageView carImage6;
    private RadioGroup radioGroupownerguide;
    private RadioButton radioButtonownerguideyes;
    private RadioButton radioButtonownerguideno;
    private RadioGroup radioGroupkeyremote;
    private RadioButton radioButtonkeyremoteyes;
    private RadioButton radioButtonkeyremoteno;
    private RadioGroup radioGroupuniversaltransmittor;
    private RadioButton radioButtonuniversaltransmittoryes;
    private RadioButton radioButtonuniversaltransmittorno;
    private RadioGroup radioGrouprc;
    private RadioButton radioButtonrcyes;
    private RadioButton radioButtonrcno;
    private RadioGroup radiogrouppollutioncertificate;
    private RadioButton radioButtonpollutioncertificateyes;
    private RadioButton radioButtonpollutioncertificateno;
    private RadioGroup radioGroupcompany;
    private RadioButton radioButtoncompanyyes;
    private RadioButton radioButtoncompanyno;
    private EditText editTextinssurance;
    private RadioGroup radioGrouplifetax;
    private RadioButton radioButtonlifetaxyes;
    private RadioButton radioButtonlifetaxno;
    private RadioGroup radioGrouphplease;
    private RadioButton radioButtonhpleaseyes;
    private RadioButton radioButtonhpleaseno;
    private EditText editTextnamefinanceco;
    private EditText editTextreplacementcost;
    private EditText editTextreplacement;
    private EditText editTextcubiccapacity;
    private EditText editTextvehicleusedas;
    private EditText editTextfinancername;
    private EditText editTextviplicenseplate;
    private RadioGroup radiogroupduplicatekey;
    private RadioButton radioButtonduplicatekeyyes;
    private RadioButton radioButtonduplicatekeyno;
    private RadioGroup radioGroupunderhypothecation;
    private RadioButton radioButtonunderhypothecationyes;
    private RadioButton radioButtonunderhypothecationno;
    private Button saveconvience;

    private File output=null;
    String id;
    Integer OWNERSGUIDE ;
    Integer KEYREMOTECONTROLS ;
    Integer UNIVERSALTRANSMITTER ;
    Integer RC ;
    Integer POLLUTIONCERTI ;
    Integer COMPANY ;
    String INSAURANCEVALIDITY ;
    Integer LIFETAXPAID ;
    Integer LEASE ;
    String NAMEFINANCIALCORPORATION ;
    Float REPAIRINGCOSTCONVIENCE ;
    String COMMENTCONVIENCE ;
    Float OLDCOST;
    String CUBICCAPACITY;
    String VEHICLEUSEDAS;
    String FINANCERNAME;
    String VIPLICENSEPLATE;
    Integer DUPLICATEKEY;
    Integer UNDERHYPOTHECATION;
    static int CAMERA_REQUEST;
    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-07-29 17:29:36 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews(View rootView) {
        id=getActivity().getIntent().getExtras().getString("id");
        Log.d("id",id);
        pluscar1 = (ImageView)rootView.findViewById( R.id.pluscar1 );
        carImage1 = (ImageView)rootView.findViewById( R.id.carImage1 );
        pluscar2 = (ImageView)rootView.findViewById( R.id.pluscar2 );
        carImage2 = (ImageView)rootView.findViewById( R.id.carImage2 );
        pluscar3 = (ImageView)rootView.findViewById( R.id.pluscar3 );
        carImage3 = (ImageView)rootView.findViewById( R.id.carImage3 );
        pluscar4 = (ImageView)rootView.findViewById( R.id.pluscar4 );
        carImage4 = (ImageView)rootView.findViewById( R.id.carImage4 );
        pluscar5 = (ImageView)rootView.findViewById( R.id.pluscar5 );
        carImage5 = (ImageView)rootView.findViewById( R.id.carImage5 );
        pluscar6 = (ImageView)rootView.findViewById( R.id.pluscar6 );
        carImage6 = (ImageView)rootView.findViewById( R.id.carImage6 );
        radioGroupownerguide = (RadioGroup)rootView.findViewById( R.id.radioGroupownerguide );
        radioButtonownerguideyes = (RadioButton)rootView.findViewById( R.id.radioButtonownerguideyes );
        radioButtonownerguideno = (RadioButton)rootView.findViewById( R.id.radioButtonownerguideno );
        radioGroupkeyremote = (RadioGroup)rootView.findViewById( R.id.radioGroupkeyremote );
        radioButtonkeyremoteyes = (RadioButton)rootView.findViewById( R.id.radioButtonkeyremoteyes );
        radioButtonkeyremoteno = (RadioButton)rootView.findViewById( R.id.radioButtonkeyremoteno );
        radioGroupuniversaltransmittor = (RadioGroup)rootView.findViewById( R.id.radioGroupuniversaltransmittor );
        radioButtonuniversaltransmittoryes = (RadioButton)rootView.findViewById( R.id.radioButtonuniversaltransmittoryes );
        radioButtonuniversaltransmittorno = (RadioButton)rootView.findViewById( R.id.radioButtonuniversaltransmittorno );
        radioGrouprc = (RadioGroup)rootView.findViewById( R.id.radioGrouprc );
        radioButtonrcyes = (RadioButton)rootView.findViewById( R.id.radioButtonrcyes );
        radioButtonrcno = (RadioButton)rootView.findViewById( R.id.radioButtonrcno );
        radiogrouppollutioncertificate = (RadioGroup)rootView.findViewById( R.id.radiogrouppollutioncertificate );
        radioButtonpollutioncertificateyes = (RadioButton)rootView.findViewById( R.id.radioButtonpollutioncertificateyes );
        radioButtonpollutioncertificateno = (RadioButton)rootView.findViewById( R.id.radioButtonpollutioncertificateno );
        radioGroupcompany = (RadioGroup)rootView.findViewById( R.id.radioGroupcompany );
        radioButtoncompanyyes = (RadioButton)rootView.findViewById( R.id.radioButtoncompanyyes );
        radioButtoncompanyno = (RadioButton)rootView.findViewById( R.id.radioButtoncompanyno );
        editTextinssurance = (EditText)rootView.findViewById( R.id.editTextinssurance );
        radioGrouplifetax = (RadioGroup)rootView.findViewById( R.id.radioGrouplifetax );
        radioButtonlifetaxyes = (RadioButton)rootView.findViewById( R.id.radioButtonlifetaxyes );
        radioButtonlifetaxno = (RadioButton)rootView.findViewById( R.id.radioButtonlifetaxno );
        radioGrouphplease = (RadioGroup)rootView.findViewById( R.id.radioGrouphplease );
        radioButtonhpleaseyes = (RadioButton)rootView.findViewById( R.id.radioButtonhpleaseyes );
        radioButtonhpleaseno = (RadioButton)rootView.findViewById( R.id.radioButtonhpleaseno );
        editTextnamefinanceco = (EditText)rootView.findViewById( R.id.editTextnamefinanceco );
        editTextreplacementcost = (EditText)rootView.findViewById( R.id.editTextreplacementcost );
        editTextreplacement = (EditText)rootView.findViewById( R.id.editTextreplacement );
        editTextcubiccapacity =(EditText)rootView.findViewById( R.id.editTextcubiccapacity );
        editTextvehicleusedas = (EditText)rootView.findViewById( R.id.editTextvehicleusedas );
        editTextviplicenseplate = (EditText)rootView.findViewById( R.id.editTextviplicenseplate );
        editTextfinancername = (EditText)rootView.findViewById( R.id.editTextfinancername );
        radiogroupduplicatekey = (RadioGroup)rootView.findViewById( R.id.radioGroupdubkey );
        radioButtonduplicatekeyyes = (RadioButton)rootView.findViewById( R.id.radioButtondubkeyyes );
        radioButtonduplicatekeyno = (RadioButton)rootView.findViewById( R.id.radioButtondubkeyno );
        radioGroupunderhypothecation = (RadioGroup)rootView.findViewById( R.id.radioGroupunderhypo );
        radioButtonunderhypothecationyes = (RadioButton)rootView.findViewById( R.id.radioButtonunderhypoyes );
        radioButtonunderhypothecationno = (RadioButton)rootView.findViewById( R.id.radioButtonunderhypono );
        saveconvience = (Button)rootView.findViewById( R.id.saveconvience );
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        db = dbHelper.getWritableDatabase();
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
        saveconvience.setOnClickListener( this );
        pluscar1.setOnClickListener(this);
        carImage1.setOnClickListener(this);
        pluscar2.setOnClickListener(this);
        carImage2.setOnClickListener(this);
        pluscar3.setOnClickListener(this);
        carImage3.setOnClickListener(this);
        pluscar4.setOnClickListener(this);
        carImage4.setOnClickListener(this);
        pluscar5.setOnClickListener(this);
        carImage5.setOnClickListener(this);
        pluscar6.setOnClickListener(this);
        carImage6.setOnClickListener(this);
        CAMERA_REQUEST=1;
        HelperFormsFunctions.setButton(saveconvience);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-07-29 17:17:12 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if( v == saveconvience ) {
            mapvalues(v.getRootView());
            ConvienceModal convienceModal = new ConvienceModal(id, OWNERSGUIDE,
                    KEYREMOTECONTROLS,
                    UNIVERSALTRANSMITTER,
                    RC,
                    POLLUTIONCERTI,
                    COMPANY,
                    INSAURANCEVALIDITY,
                    LIFETAXPAID,
                    LEASE,
                    NAMEFINANCIALCORPORATION,
                    REPAIRINGCOSTCONVIENCE,
                    COMMENTCONVIENCE,CUBICCAPACITY,VEHICLEUSEDAS,FINANCERNAME,VIPLICENSEPLATE,DUPLICATEKEY,UNDERHYPOTHECATION);
            ConvienceModal convienceModalold = cupboard().withDatabase(db).query(ConvienceModal.class).withSelection( "id = ?", id).get();
            if(convienceModalold==null) {
                Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(convienceModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Sucessfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(ConvienceModal.class, "id = ?", id);
                cupboard().withDatabase(db).put(convienceModal);
            }
            mapcarprogressvalues();
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
            db.close();
        }else if(v == pluscar1 || v == carImage1){
             captureimage(1);
        }else if(v == pluscar2 || v == carImage2){
            captureimage(2);
        }else if(v == pluscar3 || v == carImage3){
            captureimage(3);
        }else if(v == pluscar4 || v == carImage4){
            captureimage(4);
        }else if(v == pluscar5 || v == carImage5){
            captureimage(5);
        }else if(v == pluscar6 || v == carImage6){
            captureimage(6);
        }
    }

    private void captureimage(int code) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,"data");
        startActivityForResult(cameraIntent, code);
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("id = ?",id).get();
        if(carprogressModal.getCONVIENCECOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(3);
            values.put("CONVIENCECOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);

        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTCONVIENCE=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTCONVIENCE);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "id = ?", id);
        }
    }

    void mapvalues(View view){
        OWNERSGUIDE=helperFormsFunctions.returnRadioGroup(radioGroupownerguide,view);
        KEYREMOTECONTROLS=helperFormsFunctions.returnRadioGroup(radioGroupkeyremote,view);
        UNIVERSALTRANSMITTER=helperFormsFunctions.returnRadioGroup(radioGroupuniversaltransmittor,view);
        RC=helperFormsFunctions.returnRadioGroup(radioGrouprc,view);
        POLLUTIONCERTI=helperFormsFunctions.returnRadioGroup(radiogrouppollutioncertificate,view);
        COMPANY=helperFormsFunctions.returnRadioGroup(radioGroupcompany,view);
        INSAURANCEVALIDITY=editTextinssurance.getText().toString();
        LIFETAXPAID=helperFormsFunctions.returnRadioGroup(radioGrouplifetax,view);
        LEASE=helperFormsFunctions.returnRadioGroup(radioGrouphplease,view);
        NAMEFINANCIALCORPORATION=editTextnamefinanceco.getText().toString();
        CUBICCAPACITY=editTextcubiccapacity.getText().toString();
        VEHICLEUSEDAS=editTextvehicleusedas.getText().toString();
        FINANCERNAME=editTextfinancername.getText().toString();
        VIPLICENSEPLATE=editTextviplicenseplate.getText().toString();
        DUPLICATEKEY=helperFormsFunctions.returnRadioGroup(radiogroupduplicatekey,view);
        UNDERHYPOTHECATION=helperFormsFunctions.returnRadioGroup(radioGroupunderhypothecation,view);
        try {
            REPAIRINGCOSTCONVIENCE=Float.valueOf(editTextreplacementcost.getText().toString());
        }catch (Exception e){}
        COMMENTCONVIENCE=editTextreplacement.getText().toString();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.convience_form,container, false);
        findViews(rootView);
        setHasOptionsMenu(true);
        returnchanges();
        return rootView;
    }

    void returnchanges(){
        ConvienceModal convienceModal = cupboard().withDatabase(db).query(ConvienceModal.class).withSelection("id = ?",id).get();
        if(convienceModal!=null){
            id=convienceModal.getid();
            helperFormsFunctions.setValueRadiobutton(radioGroupownerguide,radioButtonownerguideyes.getId(),radioButtonownerguideno.getId(),convienceModal.getOWNERSGUIDE());
            helperFormsFunctions.setValueRadiobutton(radioGroupcompany,radioButtoncompanyyes.getId(),radioButtoncompanyno.getId(),convienceModal.getCOMPANY());
            helperFormsFunctions.setValueRadiobutton(radioGrouphplease,radioButtonhpleaseyes.getId(),radioButtonhpleaseno.getId(),convienceModal.getLEASE());
            helperFormsFunctions.setValueRadiobutton(radioGroupkeyremote,radioButtonkeyremoteyes.getId(),radioButtonkeyremoteno.getId(),convienceModal.getKEYREMOTECONTROLS());
            helperFormsFunctions.setValueRadiobutton(radioGrouplifetax,radioButtonlifetaxyes.getId(),radioButtonlifetaxno.getId(),convienceModal.getLIFETAXPAID());
            helperFormsFunctions.setValueRadiobutton(radioGrouprc,radioButtonrcyes.getId(),radioButtonrcno.getId(),convienceModal.getRC());
            helperFormsFunctions.setValueRadiobutton(radioGroupuniversaltransmittor,radioButtonuniversaltransmittoryes.getId(),radioButtonuniversaltransmittorno.getId(),convienceModal.getUNIVERSALTRANSMITTER());
            helperFormsFunctions.setValueRadiobutton(radiogrouppollutioncertificate,radioButtonpollutioncertificateyes.getId(),radioButtonpollutioncertificateno.getId(),convienceModal.getPOLLUTIONCERTI());
            helperFormsFunctions.setValueRadiobutton(radiogroupduplicatekey,radioButtonduplicatekeyyes.getId(),radioButtonduplicatekeyno.getId(),convienceModal.getDUPLICATEKEY());
            helperFormsFunctions.setValueRadiobutton(radioGroupunderhypothecation,radioButtonunderhypothecationyes.getId(),radioButtonunderhypothecationno.getId(),convienceModal.getUNDERHYPOTHECATION());

            editTextinssurance.setText(convienceModal.getINSAURANCEVALIDITY());
            editTextnamefinanceco.setText(convienceModal.getNAMEFINANCIALCORPORATION());
            if(convienceModal.getREPAIRINGCOSTCONVIENCE()!=null) {
                editTextreplacementcost.setText(String.valueOf(convienceModal.getREPAIRINGCOSTCONVIENCE()));
                OLDCOST=convienceModal.getREPAIRINGCOSTCONVIENCE();
            }else{
                OLDCOST=0f;
            }
            editTextreplacement.setText(convienceModal.getCOMMENTCONVIENCE());
            editTextcubiccapacity.setText(convienceModal.getCUBICCAPACITY());
            editTextfinancername.setText(convienceModal.getFINANCERNAME());
            editTextviplicenseplate.setText(convienceModal.getVIPLICENSEPLATE());
            editTextvehicleusedas.setText(convienceModal.getVEHICLEUSEDAS());
            helperFormsFunctions.loadImageFromStorage(carImage1,1,id,Config.configimg);
            helperFormsFunctions.loadImageFromStorage(carImage2,2,id,Config.configimg);
            helperFormsFunctions.loadImageFromStorage(carImage3,3,id,Config.configimg);
            helperFormsFunctions.loadImageFromStorage(carImage4,4,id,Config.configimg);
            helperFormsFunctions.loadImageFromStorage(carImage5,5,id,Config.configimg);
            helperFormsFunctions.loadImageFromStorage(carImage6,6,id,Config.configimg);
        }else{
            OLDCOST=0f;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {;
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            switch (requestCode){
            case 1:
                carImage1.setImageBitmap(photo);
                try {
                    helperFormsFunctions.saveToInternalStorage(photo,1,id,Config.configimg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                carImage2.setImageBitmap(photo);
                try {
                    helperFormsFunctions.saveToInternalStorage(photo,2,id,Config.configimg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                carImage3.setImageBitmap(photo);
                try {
                    helperFormsFunctions.saveToInternalStorage(photo,3,id,Config.configimg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                carImage4.setImageBitmap(photo);
                try {
                    helperFormsFunctions.saveToInternalStorage(photo,4,id,Config.configimg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                carImage5.setImageBitmap(photo);
                try {
                    helperFormsFunctions.saveToInternalStorage(photo,5,id,Config.configimg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                carImage6.setImageBitmap(photo);
                try {
                    helperFormsFunctions.saveToInternalStorage(photo,6,id,Config.configimg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miCompose:
                saveconvience.performClick();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
