package com.a123sold.a123soldinspection;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.a123sold.a123soldinspection.Fragments.ConvienceFragment;
import com.a123sold.a123soldinspection.Fragments.DiagnosticsFragment;
import com.a123sold.a123soldinspection.Fragments.ExteriorFragment;
import com.a123sold.a123soldinspection.Fragments.HistoryFragment;
import com.a123sold.a123soldinspection.Fragments.HybridFragment;
import com.a123sold.a123soldinspection.Fragments.InteriorFragment;
import com.a123sold.a123soldinspection.Fragments.RoadtestFragment;
import com.a123sold.a123soldinspection.Fragments.UnderbodyFragment;
import com.a123sold.a123soldinspection.Fragments.UnderhoodFragment;

public class FormsScrollingActivity extends AppCompatActivity {
    private View v;
    private Toolbar toolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms_scrolling);
        initialize();
    }

    void initialize(){
        mCollapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        toolbar = (Toolbar) findViewById(R.id.toolbarform);
        setSupportActionBar(toolbar);
        String name;
        name= String.valueOf(getIntent().getStringExtra("cattitle"));
        this.setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        int i = 0;
        i=getIntent().getIntExtra("catposition",i);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        switch(i)
        {
            case 0:
                ExteriorFragment fragment=new ExteriorFragment();
                ft.replace(R.id.fragment_placeholder,fragment,"hello");
                ft.commit();
                break;
            case 1:
                HistoryFragment fragment1=new HistoryFragment();
                ft.add(R.id.fragment_placeholder,fragment1,"hello");
                ft.commit();
                break;
            case 2:
                RoadtestFragment fragment2=new RoadtestFragment();
                ft.add(R.id.fragment_placeholder,fragment2,"hello");
                ft.commit();
                break;
            case 3:
                InteriorFragment fragmen3=new InteriorFragment();
                ft.add(R.id.fragment_placeholder,fragmen3,"hello");
                ft.commit();
                break;
            case 4:
                DiagnosticsFragment fragment4=new DiagnosticsFragment();
                ft.add(R.id.fragment_placeholder,fragment4,"hello");
                ft.commit();
                break;
            case 5:
                UnderhoodFragment fragment5=new UnderhoodFragment();
                ft.add(R.id.fragment_placeholder,fragment5,"hello");
                ft.commit();
                break;
            case 6:
                HybridFragment fragment6=new HybridFragment();
                ft.add(R.id.fragment_placeholder,fragment6,"hello");
                ft.commit();
                break;
            case 7:
                UnderbodyFragment fragment7=new UnderbodyFragment();
                ft.add(R.id.fragment_placeholder,fragment7,"hello");
                ft.commit();
                break;
            case 8:
                ConvienceFragment fragment8=new ConvienceFragment();
                ft.add(R.id.fragment_placeholder,fragment8,"hello");
                ft.commit();
                break;
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_forms_scrolling,menu);
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
