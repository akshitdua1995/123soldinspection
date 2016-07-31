package com.a123sold.a123soldinspection.Helpers;

/**
 * Created by akshit on 28/7/16.
 */
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a123sold.a123soldinspection.Adapters.SeekBarListAdapter;

public class ListHelper {
    public static void getListViewSize(ListView myListView, Activity activity, Fragment fragment,String[] titles) {
        SeekBarListAdapter adapter = (SeekBarListAdapter) myListView.getAdapter();
        if (adapter == null) {
            //do nothing return null
            return;
        }
        //set listAdapter in loop for getting final size
        int totalHeight = 0;
        for (int size = 0; size < adapter.getCount(); size++) {
            View listItem = adapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        //setting listview item in adapter
        ViewGroup.LayoutParams params = myListView.getLayoutParams();
        params.height = totalHeight + (myListView.getDividerHeight() * (adapter.getCount() - 1)+10);
        myListView.setLayoutParams(params);
        // print height of adapter on log
        Log.i("height of listItem:", String.valueOf(totalHeight));
    }
}
