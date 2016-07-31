package com.a123sold.a123soldinspection.Adapters;

import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import com.a123sold.a123soldinspection.Helpers.HelperFormsFunctions;
import com.a123sold.a123soldinspection.R;

import java.util.ArrayList;

/**
 * Created by akshit on 28/7/16.
 */
public class SeekBarListAdapter extends ArrayAdapter<String> {
    private final String[] titles;
    private final Activity context;
    private final HelperFormsFunctions helperFormsFunctions;
    public final ArrayList<String> values;
    public final ArrayList<String> initvalues;
    int count;

    public SeekBarListAdapter(Activity context, String[] TitleList,ArrayList<String> val, Fragment fragment) {
        super(context, R.layout.seekbar_list, TitleList);
        this.count=0;
        this.titles = TitleList;
        this.context = context;
        values=new ArrayList<String>();
        initvalues=val;
        this.helperFormsFunctions=new HelperFormsFunctions(context,fragment);
    }

    @Override
    public int getCount() {
        return titles.length;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final TextView titleText,seekBarvalue,seekBarfeedback;
        SeekBar seekBar;
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=convertView;
        if(convertView==null)
            rowView = inflater.inflate(R.layout.seekbar_list, null);
        titleText = (TextView) rowView.findViewById(R.id.frame_seekbar);
        seekBarvalue = (TextView) rowView.findViewById(R.id.seekbarvalue);
        seekBarfeedback = (TextView) rowView.findViewById(R.id.seekbarvaluefeedback);
        seekBar=(SeekBar)rowView.findViewById(R.id.seekBar);
        titleText.setText(titles[position]);
        if(initvalues!=null){
            seekBarvalue.setText(initvalues.get(position));
            seekBarfeedback.setText(helperFormsFunctions.returnFeedbackSeekBar(Integer.valueOf(initvalues.get(position))));
            seekBar.setProgress(Integer.valueOf(initvalues.get(position)));
            values.add(initvalues.get(position));
        }else {
            seekBarvalue.setText("0");
            seekBarfeedback.setText("");
            values.add("0");
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                seekBarfeedback.setText(helperFormsFunctions.returnFeedbackSeekBar(progress));
                seekBarvalue.setText(String.valueOf(progress));
                values.set(position,String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        this.count++;
        return rowView;
    }
}