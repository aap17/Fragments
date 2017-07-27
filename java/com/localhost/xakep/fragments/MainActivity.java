package com.localhost.xakep.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MyFragment.MyInterface {

    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private Bundle bundle;
    private boolean isFirstFragment=true;

    private static String FRAGMENT_A="FragmentA";
    private static String FRAGMENT_B="FragmentB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bundle==null)
                {
                    bundle= new Bundle();
                }

               fragmentA = (FragmentA) getSupportFragmentManager().findFragmentByTag(FRAGMENT_A);
                if (fragmentA !=null)
                {
                    fragmentA.sendData("Activity's message");
                    fragmentB = new FragmentB();
                    fragmentB.setArguments(bundle);

                    initFragment(null, fragmentB, FRAGMENT_B);
                } else
                {
                    initFragment(null, new FragmentA(), FRAGMENT_A );
                }


            }
        });


        initFragment(savedInstanceState, new FragmentA(), FRAGMENT_A);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initFragment(Bundle savedInstanceState, Fragment fragment, String tag)
    {
        if (savedInstanceState != null) {
            Log.e("MainActivity", "bundle not null");
            return;
        }

        if (findViewById(R.id.frame_container) != null) {


            FragmentManager manager =  getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

            transaction.replace(R.id.frame_container, fragment, tag);

            //  transaction.addToBackStack(null);
            transaction.commit();

            Log.e("MainActivity", "added new fragment");


        } else {
            Log.e("MainActivity", "container null");
        }
    }

    @Override
    public void onItemClicked() {
        FragmentLandscape fragmentLandscape = (FragmentLandscape) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        if (fragmentLandscape!=null)
        {
            fragmentLandscape.showMessage("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae");
        }

    }

}
