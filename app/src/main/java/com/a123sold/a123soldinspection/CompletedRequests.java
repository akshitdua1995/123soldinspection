package com.a123sold.a123soldinspection;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.JsonRequest;
import com.a123sold.a123soldinspection.Helpers.ViewsVisibility;

import org.json.JSONException;

public class CompletedRequests extends AppCompatActivity {
    Toolbar toolbar;
    int mainnaviposition;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static Activity activity;
    private static ImageView imageView;
    private static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_requests);
        initialize();
    }
    void initialize(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Completed requests");
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.completedrequest_recycler_view);
        imageView = (ImageView) findViewById(R.id.noCompleteview);
        textView = (TextView) findViewById(R.id.textViewcompleted);
        recyclerView.setHasFixedSize(true);
        activity=this;
        layoutManager = new LinearLayoutManager(activity);
        ViewsVisibility.conextcompletedActivity=activity;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        JsonRequest request=new JsonRequest(this.getApplicationContext(),this);
        try {
            request.LoadCompletedRequests(Config.BASE_URL+"/api/123sold/inspectionInfo/getAllCompletedAuctions",recyclerView,imageView,textView);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu,menu);
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
}
