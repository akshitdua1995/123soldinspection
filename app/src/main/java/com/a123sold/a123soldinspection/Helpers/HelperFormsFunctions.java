package com.a123sold.a123soldinspection.Helpers;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by akshit on 26/7/16.
 */
public class HelperFormsFunctions {
    Context context;
    Fragment fragment;
    private static Button controlbutton;
    ImageView imageView;
    int resultcode;
    private final int SELECT_PHOTO = 1;
    public HelperFormsFunctions(Context context, Fragment fragment){
        this.context=context;
        this.fragment=fragment;
    }

    public void loadImageFromStorage(ImageView img, int num, int CARID,String name)
    {

        try {
            ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
            File directory = cw.getDir("images", Context.MODE_PRIVATE);
            File f=new File(directory, name+String.valueOf(num)+String.valueOf(CARID)+".jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    public int returnCheckboxValue(CheckBox checkBox){
        int val;
        boolean value=checkBox.isChecked();
        if(value) val=1;
        else    val=0;
        return val;
    }

    public boolean returnCheckboxValue(Integer val){
        boolean value;
        if(val==1)
            value=true;
        else
            value=false;
        return value;
    }
    public String returnFeedbackSeekBar(int progress){
        String feedback=null;
        switch(progress){
            case 1:
                feedback="Very Poor";
                break;
            case 2:
                feedback="Poor";
                break;
            case 3:
                feedback="Average";
                break;
            case 4:
                feedback="Good";
                break;
            case 5:
                feedback="Excellent";
                break;
            case 0:
                feedback="";
                break;
        }
        return feedback;
    }

    public int returnRadioGroup(RadioGroup group,View view){

        try {
            String radioValue = ((RadioButton) view.findViewById(group.getCheckedRadioButtonId())).getText().toString();
            if(radioValue.toUpperCase().equals("YES"))
                return 1;
            else if(radioValue.toUpperCase().equals("NO"))
                return 0;
        }catch (Exception e){
            return -1;
        }
        return -1;
    }

    public void setValueRadiobutton(RadioGroup radioGroup,int yesid,int noid,int value){
        if(value==1)
            radioGroup.check(yesid);
        else if(value==0)
            radioGroup.check(noid);
    }

    public String saveToInternalStorage(Bitmap bitmapImage,int imgno,int CARID,String name) throws IOException {
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("images", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,name+String.valueOf(imgno)+String.valueOf(CARID)+".jpg");
        FileOutputStream fos = null;
        Log.d("path",mypath.toString());
        try {
            fos = new FileOutputStream(mypath);
            Log.d("path",fos.toString());
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }
        return directory.getAbsolutePath();
    }
    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("permission","Permission is granted");
                return true;
            } else {

                Log.v("permission","Permission is revoked");
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else {
            Log.v("permsiion","Permission is granted");
            return true;
        }
    }
    public  boolean isReadStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("permission","Permission is granted");
                return true;
            } else {

                Log.v("permission","Permission is revoked");
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else {
            Log.v("permsiion","Permission is granted");
            return true;
        }
    }
    public static void setButton(Button button){
        controlbutton=button;
    }

    public static Button getButton(){
        return controlbutton;
    }
    public String ModalToJSON(Object modal)
    {
        Gson gson=new Gson();
        String objTosend=null;
        objTosend = gson.toJson(modal);
        return  objTosend;
    }
}
