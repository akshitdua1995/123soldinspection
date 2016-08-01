package com.a123sold.a123soldinspection.Helpers;

import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by akshit on 26/7/16.
 */
public class HelperFormsFunctions {
    Context context;
    Fragment fragment;
    ImageView imageView;
    int resultcode;
    private final int SELECT_PHOTO = 1;
    public HelperFormsFunctions(Context context, Fragment fragment){
        this.context=context;
        this.fragment=fragment;
    }

    public void loadImageFromStorage(ImageView img, int num, int CARID)
    {

        try {
            ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
            File directory = cw.getDir("images", Context.MODE_PRIVATE);
            File f=new File(directory, "Conviencepic"+String.valueOf(num)+String.valueOf(CARID)+".jpg");
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
}
