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

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by akshit on 24/7/16.
 */
public class ConvienceFragment extends android.app.Fragment implements View.OnClickListener {
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
    private Button saveconvience;
    Integer CARID;
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
    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-07-29 17:29:36 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews(View rootView) {
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
        saveconvience = (Button)rootView.findViewById( R.id.saveconvience );
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(getActivity(),1);
        db = dbHelper.getWritableDatabase();
        helperFormsFunctions=new HelperFormsFunctions(getActivity(),this);
        saveconvience.setOnClickListener( this );
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
            ConvienceModal convienceModal = new ConvienceModal(CARID, OWNERSGUIDE,
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
                    COMMENTCONVIENCE);
            ConvienceModal convienceModalold = cupboard().withDatabase(db).query(ConvienceModal.class).withSelection( "CARID = ?", "1").get();
            if(convienceModalold==null) {
                Toast.makeText(getActivity(),"Saved",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(convienceModal);
            }else{
                Toast.makeText(getActivity(),"Changes Made Sucessfully",Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(ConvienceModal.class, "CARID = ?", "1");
                cupboard().withDatabase(db).put(convienceModal);
            }
            mapcarprogressvalues();
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
            db.close();
        }
    }

    private void mapcarprogressvalues() {
        CarprogressModal carprogressModal=cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("CARID=1").get();

        if(carprogressModal.getCONVIENCECOMPLETED()==false) {
            int progress=carprogressModal.getPROGRESS()+ Config.progress_per_category;
            ContentValues values = new ContentValues(3);
            values.put("CONVIENCECOMPLETED", true);
            values.put("PROGRESS",progress);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");

        }
        try {
            ContentValues values = new ContentValues(1);
            REPAIRINGCOSTCONVIENCE=Float.valueOf(editTextreplacementcost.getText().toString());
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST+REPAIRINGCOSTCONVIENCE);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }catch (Exception e){
            ContentValues values = new ContentValues(1);
            values.put("TOTAL_REPAIRING_COST",carprogressModal.getTOTAL_REPAIRING_COST()-OLDCOST);
            cupboard().withDatabase(db).update(CarprogressModal.class, values, "CARID = ?", "1");
        }
    }

    void mapvalues(View view){
        CARID=1;
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
        try {
            REPAIRINGCOSTCONVIENCE=Float.valueOf(editTextreplacementcost.getText().toString());
        }catch (Exception e){}
        COMMENTCONVIENCE=editTextreplacement.getText().toString();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.convience_form,container, false);
        findViews(rootView);
        returnchanges();
        return rootView;
    }

    void returnchanges(){
        ConvienceModal convienceModal = cupboard().withDatabase(db).query(ConvienceModal.class).withSelection("CARID=1").get();
        if(convienceModal!=null){
            helperFormsFunctions.setValueRadiobutton(radioGroupownerguide,radioButtonownerguideyes.getId(),radioButtonownerguideno.getId(),convienceModal.getOWNERSGUIDE());
            helperFormsFunctions.setValueRadiobutton(radioGroupcompany,radioButtoncompanyyes.getId(),radioButtoncompanyno.getId(),convienceModal.getCOMPANY());
            helperFormsFunctions.setValueRadiobutton(radioGrouphplease,radioButtonhpleaseyes.getId(),radioButtonhpleaseno.getId(),convienceModal.getLEASE());
            helperFormsFunctions.setValueRadiobutton(radioGroupkeyremote,radioButtonkeyremoteyes.getId(),radioButtonkeyremoteno.getId(),convienceModal.getKEYREMOTECONTROLS());
            helperFormsFunctions.setValueRadiobutton(radioGrouplifetax,radioButtonlifetaxyes.getId(),radioButtonlifetaxno.getId(),convienceModal.getLIFETAXPAID());
            helperFormsFunctions.setValueRadiobutton(radioGrouprc,radioButtonrcyes.getId(),radioButtonrcno.getId(),convienceModal.getRC());
            helperFormsFunctions.setValueRadiobutton(radioGroupuniversaltransmittor,radioButtonuniversaltransmittoryes.getId(),radioButtonuniversaltransmittorno.getId(),convienceModal.getUNIVERSALTRANSMITTER());
            helperFormsFunctions.setValueRadiobutton(radiogrouppollutioncertificate,radioButtonpollutioncertificateyes.getId(),radioButtonpollutioncertificateno.getId(),convienceModal.getPOLLUTIONCERTI());
            editTextinssurance.setText(convienceModal.getINSAURANCEVALIDITY());
            editTextnamefinanceco.setText(convienceModal.getNAMEFINANCIALCORPORATION());
            if(convienceModal.getREPAIRINGCOSTCONVIENCE()!=null) {
                editTextreplacementcost.setText(String.valueOf(convienceModal.getREPAIRINGCOSTCONVIENCE()));
                OLDCOST=convienceModal.getREPAIRINGCOSTCONVIENCE();
            }else{
                OLDCOST=0f;
            }
            editTextreplacement.setText(convienceModal.getCOMMENTCONVIENCE());
        }else{
            OLDCOST=0f;
        }
    }
}
