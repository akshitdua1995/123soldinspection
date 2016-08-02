package com.a123sold.a123soldinspection;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by akshit on 2/8/16.
 */

public class ServerSingleton {

    private static ServerSingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context context;

    private ServerSingleton(Context cxt) {
        context = cxt;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized ServerSingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ServerSingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}