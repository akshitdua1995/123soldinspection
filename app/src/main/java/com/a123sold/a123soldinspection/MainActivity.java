package com.a123sold.a123soldinspection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.a123sold.a123soldinspection.Adapters.NavigationListAdapter;
import com.a123sold.a123soldinspection.Fragments.AssignedRequests;
import com.a123sold.a123soldinspection.Fragments.NewRequests;
import com.a123sold.a123soldinspection.Fragments.PendingRequests;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, TabLayout.OnTabSelectedListener {
    private NavigationListAdapter adapter;
    private ViewPager vp;
    TabLayout tabLayout;
    int positioncurr;
    private final List mFragmentList = new ArrayList<>();
    private final List mFragmentTitleList = new ArrayList<>();
    private static Toolbar toolbar;
    private ViewPagerAdapter adapterpager;
    private DrawerLayout drawerlayout;
    private RelativeLayout rl;
    private ListView navigationList;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private android.support.v7.app.ActionBar actionBar;
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setupnavigationadapter();
    }

    void initialize(){
        activity=this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("123sold");
        setSupportActionBar(toolbar);
        navigationList = (ListView) findViewById(R.id.navigationlist);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        rl = (RelativeLayout) findViewById(R.id.menuholder);
        vp = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(vp);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(this);
    }

    void setupnavigationadapter(){
        String[] itemname = {
                "New Requests",
                "Assigned Requests",
                "Completed Requests",
                "Pending Requests",
                "Contact us",
                "Logout"
        };

        Integer[] itemimage = {
                R.drawable.requests,
                R.drawable.assigned,
                R.drawable.completed,
                R.drawable.pending,
                R.drawable.contactus,
                R.drawable.logout
        };
        adapter = new NavigationListAdapter(this, itemname, itemimage);
        navigationList.setAdapter(adapter);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, R.string.opendrawer, R.string.closedrawer);
        navigationList.setOnItemClickListener(this);
        actionBar = getSupportActionBar();
        drawerlayout.setDrawerListener(actionBarDrawerToggle);
        actionBar.setDisplayHomeAsUpEnabled(true);
        navigationList.setItemChecked(0, true);
        navigationList.setSelection(0);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    private void setupViewPager(ViewPager viewPager) {

        adapterpager = new ViewPagerAdapter(getSupportFragmentManager());
        Fragment newrequest = new NewRequests();
        adapterpager.addFragment(newrequest, "New");
        Fragment assignedrequest = new AssignedRequests();
        adapterpager.addFragment(assignedrequest,"Assigned");
        Fragment pendingrequest = new PendingRequests();
        adapterpager.addFragment(pendingrequest,"Pending");
        viewPager.setAdapter(adapterpager);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int pos=tab.getPosition();
        vp.setCurrentItem(pos);
        if(pos!=2){
            navigationList.setItemChecked(pos, true);
            navigationList.setSelection(pos);
            positioncurr=pos;
        }else{
            navigationList.setItemChecked(pos+1, true);
            navigationList.setSelection(pos+1);
            positioncurr=pos+1;
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return (Fragment) mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (CharSequence) mFragmentTitleList.get(position);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment;
        navigationList.setItemChecked(position, true);
        navigationList.setSelection(position);
        switch (position) {
            case 0:
                vp.setCurrentItem(0);
                break;
            case 1:
                vp.setCurrentItem(1);
                break;
            case 2:
                Intent intent=new Intent(MainActivity.this,CompletedRequests.class);
                startActivity(intent);
                navigationList.setItemChecked(positioncurr, true);
                navigationList.setSelection(positioncurr);
                break;
            case 3:
                vp.setCurrentItem(2);
                break;
            case 4:
                break;
            case 5:
                break;
        }

        drawerlayout.closeDrawer(rl);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            if (drawerlayout.isDrawerOpen(rl)) {
                drawerlayout.closeDrawer(rl);
            } else {
                drawerlayout.openDrawer(rl);
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
