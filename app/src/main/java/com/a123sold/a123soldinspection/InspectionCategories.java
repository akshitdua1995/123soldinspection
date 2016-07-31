package com.a123sold.a123soldinspection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.a123sold.a123soldinspection.Adapters.InspectionCategoryAdapter;
import com.a123sold.a123soldinspection.Database.InspectionFormDatabase;
import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.Helpers.InspectionCategoryData;
import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.CategoryDataModal;
import com.github.lzyzsd.circleprogress.ArcProgress;

import java.util.ArrayList;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class InspectionCategories extends AppCompatActivity {
    private static final int STATIC_INTEGER_VALUE = 1;
    Toolbar toolbar;
    private InspectionCategoryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<CategoryDataModal> data;
    private static ArrayList<Boolean> checks;
    private static Activity activity;
    public static View.OnClickListener myOnClickListener;
    private ArcProgress arcProgress;
    private CarprogressModal carprogressModal;
    static SQLiteDatabase db;
    TextView textViewtotalrepairingcost;
    HelperFormsFunctions helperFormsFunctions;
    Integer CARID;
    Float TOTAL_REPAIRING_COST;
    Integer PROGRESS;
    Boolean UNDERBODYCOMPLETED;
    Boolean UNDERHOODCOMPLETED;
    Boolean INTERIORCOMPLETED;
    Boolean EXTERIORCOMPLETED;
    Boolean HYBRIDCOMPLETED;
    Boolean CONVIENCECOMPLETED;
    Boolean ROADTESTCOMPLETED;
    Boolean HISTORYCOMPLETED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspection_categories);
        TOTAL_REPAIRING_COST = 0.0f;
        PROGRESS = 0;
        UNDERBODYCOMPLETED = false;
        UNDERHOODCOMPLETED = false;
        INTERIORCOMPLETED = false;
        EXTERIORCOMPLETED = false;
        HYBRIDCOMPLETED = false;
        CONVIENCECOMPLETED = false;
        ROADTESTCOMPLETED = false;
        HISTORYCOMPLETED = false;
        initialize();
    }

    void initialize() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Inspection Categories");
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewtotalrepairingcost = (TextView) findViewById(R.id.totalcost);
        InspectionFormDatabase dbHelper = new InspectionFormDatabase(this, 1);
        arcProgress = (ArcProgress) findViewById(R.id.arc_progress);
        float f = 240.0f;
        arcProgress.setArcAngle(f);
        db = dbHelper.getWritableDatabase();
        helperFormsFunctions = new HelperFormsFunctions(this, null);
        getValues();
        recyclerView = (RecyclerView) findViewById(R.id.inspectioncategory_recycler_view);
        recyclerView.setHasFixedSize(true);
        activity = this;
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<CategoryDataModal>();
        for (int i = 0; i < InspectionCategoryData.catimageArray.length; i++) {
            data.add(new CategoryDataModal(
                    InspectionCategoryData.cattextArray[i],
                    InspectionCategoryData.catimageArray[i]
            ));
        }
        adapter = new InspectionCategoryAdapter(data, checks, this);
        recyclerView.setAdapter(adapter);
        myOnClickListener = new MyOnClickListener(this);

    }

    private void getValues() {
        carprogressModal = cupboard().withDatabase(db).query(CarprogressModal.class).withSelection("CARID=1").get();
        checks = new ArrayList<Boolean>();
        if (carprogressModal == null) {
            checks.add(false);
            checks.add(false);
            checks.add(false);
            checks.add(false);
            checks.add(false);
            checks.add(false);
            checks.add(false);
            checks.add(false);
            checks.add(false);
            carprogressModal = new CarprogressModal(1, TOTAL_REPAIRING_COST, PROGRESS, UNDERBODYCOMPLETED, UNDERHOODCOMPLETED, INTERIORCOMPLETED
                    , EXTERIORCOMPLETED, HYBRIDCOMPLETED, CONVIENCECOMPLETED, ROADTESTCOMPLETED, HISTORYCOMPLETED);
            cupboard().withDatabase(db).put(carprogressModal);
        } else {
            arcProgress.setProgress(carprogressModal.getPROGRESS());
            Log.d("cost",String.valueOf(carprogressModal.getTOTAL_REPAIRING_COST()));
            if (carprogressModal.getTOTAL_REPAIRING_COST() > 0 && carprogressModal.getTOTAL_REPAIRING_COST()!=null) {
                textViewtotalrepairingcost.setVisibility(View.VISIBLE);
                textViewtotalrepairingcost.setText("Repairing Cost : " + carprogressModal.getTOTAL_REPAIRING_COST() + "Rs");
            }else{
                textViewtotalrepairingcost.setVisibility(View.GONE);
            }
            if (arcProgress.getProgress() == 96) {
                arcProgress.setVisibility(View.GONE);
            }
            checks.add(carprogressModal.getEXTERIORCOMPLETED());
            checks.add(carprogressModal.getHISTORYCOMPLETED());
            checks.add(carprogressModal.getROADTESTCOMPLETED());
            checks.add(carprogressModal.getINTERIORCOMPLETED());
            checks.add(false);
            checks.add(carprogressModal.getUNDERHOODCOMPLETED());
            checks.add(carprogressModal.getHYBRIDCOMPLETED());
            checks.add(carprogressModal.getUNDERBODYCOMPLETED());
            checks.add(carprogressModal.getCONVIENCECOMPLETED());
        }
    }

    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int pos = recyclerView.getChildPosition(v);
            Intent i = new Intent(InspectionCategories.this, FormsScrollingActivity.class);
            String name[] = {null};
            switch (pos) {
                case 0:
                    name[0] = "Vehicle Exterior";
                    break;
                case 1:
                    name[0] = "Vehicle History";
                    break;
                case 2:
                    name[0] = "Road Test";
                    break;
                case 3:
                    name[0] = "Vehicle Interior";
                    break;
                case 4:
                    name[0] = "Vehicle Diagnostics";
                    break;
                case 5:
                    name[0] = "Underhood";
                    break;
                case 6:
                    name[0] = "Hybrid";
                    break;
                case 7:
                    name[0] = "Underbody";
                    break;
                case 8:
                    name[0] = "Convience";
                    break;
            }
            i.putExtra("catposition", pos);
            i.putExtra("cattitle", name[0]);
            startActivityForResult(i, STATIC_INTEGER_VALUE);
            //startActivity(i);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (STATIC_INTEGER_VALUE): {
                if (resultCode == Activity.RESULT_OK) {
                    getValues();
                    adapter = new InspectionCategoryAdapter(this.data,checks,this);
                    recyclerView.setAdapter(adapter);
                }
                break;
            }
        }
    }
}