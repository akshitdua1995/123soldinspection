package com.a123sold.a123soldinspection.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static com.a123sold.a123soldinspection.Database.InspectionFormContract.FormFeedEntry.ALL_COLUMN_EXTERIOR;
import static com.a123sold.a123soldinspection.Database.InspectionFormContract.FormFeedEntry.COLUMN_NAME_CARID;
import static com.a123sold.a123soldinspection.Database.InspectionFormContract.FormFeedEntry.TABLE_NAME_EXTERIOR;

/**
 * Created by akshit on 29/7/16.
 */
public class ReadWriteFormDatabase {
    private static InspectionFormDatabase dbhelper;
    private static SQLiteDatabase database;
    private static String cid;
    public ReadWriteFormDatabase(Context context,String carid){
        dbhelper = new InspectionFormDatabase(context, 1);
        cid=carid;
    }
    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
    }

    public void close() {
        dbhelper.close();
    }

    public void SaveExterior(String title,String link,String duration) {
        ContentValues values = new ContentValues();
        values.put(ALL_COLUMN_EXTERIOR[0],title);
        values.put(ALL_COLUMN_EXTERIOR[1],link);
        values.put(ALL_COLUMN_EXTERIOR[2],duration);

        long updateId = database.update(TABLE_NAME_EXTERIOR,values,COLUMN_NAME_CARID+"="+cid,null);
    }



}
