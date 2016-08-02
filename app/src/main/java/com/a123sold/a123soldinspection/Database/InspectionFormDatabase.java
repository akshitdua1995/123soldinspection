package com.a123sold.a123soldinspection.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.a123sold.a123soldinspection.modals.CarprogressModal;
import com.a123sold.a123soldinspection.modals.ConvienceModal;
import com.a123sold.a123soldinspection.modals.ExteriorformModal;
import com.a123sold.a123soldinspection.modals.HistoryModal;
import com.a123sold.a123soldinspection.modals.HybridformModal;
import com.a123sold.a123soldinspection.modals.InteriorModal;
import com.a123sold.a123soldinspection.modals.RoadtestModal;
import com.a123sold.a123soldinspection.modals.UnderbodyformModal;
import com.a123sold.a123soldinspection.modals.UnderhoodModal;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;
/**
 * Created by akshit on 28/7/16.
 */
public class InspectionFormDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="inspectionform.db";
    static {
        // register our modals
        cupboard().register(ExteriorformModal.class);
        cupboard().register(ConvienceModal.class);
        cupboard().register(InteriorModal.class);
        cupboard().register(HistoryModal.class);
        cupboard().register(UnderhoodModal.class);
        cupboard().register(UnderbodyformModal.class);
        cupboard().register(HybridformModal.class);
        cupboard().register(RoadtestModal.class);
        cupboard().register(CarprogressModal.class);

    }






    public InspectionFormDatabase(Context context, int i) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        cupboard().withDatabase(db).createTables();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        cupboard().withDatabase(db).upgradeTables();
    }

}
