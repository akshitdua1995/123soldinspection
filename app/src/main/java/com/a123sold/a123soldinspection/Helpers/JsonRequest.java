package com.a123sold.a123soldinspection.Helpers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.a123sold.a123soldinspection.Adapters.AssignedRequestAdapter;
import com.a123sold.a123soldinspection.Adapters.NewRequestAdapter;
import com.a123sold.a123soldinspection.LoginActivity;
import com.a123sold.a123soldinspection.MainActivity;
import com.a123sold.a123soldinspection.R;
import com.a123sold.a123soldinspection.ServerSingleton;
import com.a123sold.a123soldinspection.modals.AcceptedRequestList;
import com.a123sold.a123soldinspection.modals.NewRequestDataModal;
import com.a123sold.a123soldinspection.modals.RequestList;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonRequest {
    private Context context;
    private ProgressBar progressBar;
    private Activity activity;
    JSONObject jsonresponse;
    JSONObject jsonresponseaccepted;
    JSONObject jsonresponsecompleted;
    private static ArrayList<NewRequestDataModal> data;
    private static ArrayList<NewRequestAdapter> acceptedData;
    public JsonRequest(Context context,Activity activity){
        this.context=context;
        progressBar=(ProgressBar) activity.findViewById(R.id.progressBar1);
        this.activity=activity;
    }
    //For Login
    public void LoginResponse(String URL, final String email, final String password) throws JSONException {
        progressBar.setVisibility(View.VISIBLE);
        JSONObject params = new JSONObject();
        params.put("password", password);
        params.put("email", email);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,URL,params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            jsonresponse=new JSONObject(response.toString());
                            String status = (String) jsonresponse.get("status");
                            if(status.equalsIgnoreCase("success")){
                                SharedPreferences sharedpreferences;
;                               sharedpreferences = activity.getSharedPreferences(Config.localUserDB, Context.MODE_PRIVATE);
                                String userId=(String) jsonresponse.get("userId");
                                String authToken=(String) jsonresponse.get("authToken");
                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putString("userId", userId);
                                editor.putString("authToken", authToken);
                                editor.commit();
                                progressBar.setVisibility(View.GONE);
                                Intent i=new Intent(activity,MainActivity.class);
                                activity.startActivity(i);
                                activity.finish();
                            }else{
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(activity.getApplicationContext(),"Invalid Username/Password",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(activity.getApplicationContext(),"Invalid Username/Password",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(activity.getApplicationContext(),"No Internet Connectivity",Toast.LENGTH_SHORT).show();
            }
        });
        ServerSingleton.getInstance(context).addToRequestQueue(req);
    }

    //For Logout
    public void LogoutResponse(String URL) throws JSONException {
        progressBar.setVisibility(View.VISIBLE);
        JSONObject params = new JSONObject();
        SharedPreferences sharedpreferences = activity.getSharedPreferences(Config.localUserDB, activity.MODE_PRIVATE);
        String userId = sharedpreferences.getString("userId", null);
        String authToken = sharedpreferences.getString("authToken",null);
        params.put("userId", userId);
        params.put("authToken", authToken);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,URL,params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            jsonresponse=new JSONObject(response.toString());
                            String status = (String) jsonresponse.get("status");
                            if(status.equalsIgnoreCase("success")){
                                SharedPreferences sharedpreferences;
                                sharedpreferences = activity.getSharedPreferences(Config.localUserDB, Context.MODE_PRIVATE);
                                sharedpreferences.edit().clear().commit();
                                progressBar.setVisibility(View.GONE);
                                Intent i=new Intent(activity,LoginActivity.class);
                                activity.startActivity(i);
                                activity.finish();
                            }else{
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(activity.getApplicationContext(),"Problem Signing out",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(activity.getApplicationContext(),"Invalid Response",Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(activity.getApplicationContext(),"No Internet Connectivity",Toast.LENGTH_SHORT).show();
            }
        });
        ServerSingleton.getInstance(context).addToRequestQueue(req);
    }
    //For loading new requests to user
    public void LoadNewRequests(String URL, final RecyclerView recyclerView,final RelativeLayout relativeLayout) throws JSONException {
        progressBar.setVisibility(View.VISIBLE);
        SharedPreferences sharedpreferences = activity.getSharedPreferences(Config.localUserDB, activity.MODE_PRIVATE);
        String userId = sharedpreferences.getString("userId", null);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,URL,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            parseNewRequests(response,recyclerView,relativeLayout);
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(activity.getApplicationContext(),"Invalid Response",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(activity.getApplicationContext(),"Invalid Response",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                SharedPreferences sharedpreferences = activity.getSharedPreferences(Config.localUserDB, activity.MODE_PRIVATE);
                String userId = sharedpreferences.getString("userId", null);
                String authToken = sharedpreferences.getString("authToken",null);
                params.put("userId", userId);
                params.put("authToken", authToken);
                return params;
            }
        };
        ServerSingleton.getInstance(context).addToRequestQueue(req);
    }
    //For loading all accepted requests
    public void LoadAcceptedRequests(String URL, final RecyclerView recyclerView,final RelativeLayout relativeLayout) throws JSONException {
        progressBar.setVisibility(View.VISIBLE);
        JSONObject params = new JSONObject();
        SharedPreferences sharedpreferences = activity.getSharedPreferences(Config.localUserDB, activity.MODE_PRIVATE);
        String userId = sharedpreferences.getString("userId", null);
        params.put("userId", userId);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            parseAcceptedRequests(response, recyclerView,relativeLayout);
                            progressBar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(activity.getApplicationContext(), "Invalid Response", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activity.getApplicationContext(), "Invalid Response", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                SharedPreferences sharedpreferences = activity.getSharedPreferences(Config.localUserDB, activity.MODE_PRIVATE);
                String authToken = sharedpreferences.getString("authToken", null);
                params.put("authToken", authToken);
                return params;
            }
        };
        ServerSingleton.getInstance(context).addToRequestQueue(req);
    }

    public void AcceptRequest(String URL, String auctionId) throws JSONException {
        progressBar.setVisibility(View.VISIBLE);
        JSONObject params = new JSONObject();
        SharedPreferences sharedpreferences = activity.getSharedPreferences(Config.localUserDB, activity.MODE_PRIVATE);
        String userId = sharedpreferences.getString("userId", null);
        params.put("userId", userId);
        params.put("auctionId",auctionId);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, URL, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("acceptresponse",response.toString());
                            progressBar.setVisibility(View.GONE);
                        } catch (Exception e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(activity.getApplicationContext(), "Invalid Response", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activity.getApplicationContext(), "Invalid Response", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                SharedPreferences sharedpreferences = activity.getSharedPreferences(Config.localUserDB, activity.MODE_PRIVATE);
                String authToken = sharedpreferences.getString("authToken", null);
                params.put("authToken", authToken);
                return params;
            }
        };
        ServerSingleton.getInstance(context).addToRequestQueue(req);
    }



    //Parsing the json response for new requests and setting them to recycler view.
    void parseNewRequests(JSONObject response, RecyclerView recyclerView, RelativeLayout relativeLayout) throws JSONException {
        String status;
        jsonresponse=new JSONObject(response.toString());
        Gson gson=new Gson();
        RequestList list= gson.fromJson(jsonresponse.toString(), RequestList.class);
        status=list.getStatus();
        ArrayList<NewRequestDataModal> auctionDetails = list.getAuctionsData();
        if(status.equals("success")){
            fillCardView(auctionDetails);
            NewRequestAdapter adapter = new NewRequestAdapter(data);
            recyclerView.setAdapter(adapter);
            if(data.size()!=0)
                relativeLayout.setVisibility(View.GONE);
        }else{
            Toast.makeText(activity.getApplicationContext(),"Error in Response",Toast.LENGTH_SHORT).show();
        }
    }

    void parseAcceptedRequests(JSONObject response,RecyclerView recyclerView, RelativeLayout relativeLayout) throws JSONException{
        Log.d("auctionsaccepted",response.toString());
        if(response.has("auctions")){
            jsonresponseaccepted =new JSONObject(response.toString());
            Gson gson=new Gson();
            AcceptedRequestList list= gson.fromJson(jsonresponseaccepted.toString(), AcceptedRequestList.class);
            ArrayList<NewRequestDataModal> auctionDetails = list.getAuctionsData();
            fillCardView(auctionDetails);
            AssignedRequestAdapter adapter = new AssignedRequestAdapter(data);
            recyclerView.setAdapter(adapter);
            ViewsVisibility.assignedRequestAdapter=adapter;
            if(data.size()!=0)
                relativeLayout.setVisibility(View.GONE);
        }else{
            Toast.makeText(activity.getApplicationContext(),"Error in Response",Toast.LENGTH_SHORT).show();
        }
    }

    //Fill the card views data.
    void fillCardView(ArrayList<NewRequestDataModal> auctionDetails){
        data=new ArrayList<NewRequestDataModal>();
        for (int i = 0; i < auctionDetails.size(); i++) {
            data.add(new NewRequestDataModal(
                    auctionDetails.get(i).getMake(),
                    auctionDetails.get(i).getModel(),
                    auctionDetails.get(i).getVersion(),
                    auctionDetails.get(i).getKmDriven(),
                    auctionDetails.get(i).getFuelType(),
                    auctionDetails.get(i).getTransmission(),
                    auctionDetails.get(i).getAddress(),
                    auctionDetails.get(i).getOwnerName(),
                    auctionDetails.get(i).getYear(),
                    auctionDetails.get(i).getNumberOfOwners(),
                    0,
                    0,
                    0,
                    auctionDetails.get(i).getId()
            ));
        }
    }
}
