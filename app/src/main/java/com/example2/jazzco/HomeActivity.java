package com.example2.jazzco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Created by Christina Kouti", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
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

        if (id == R.id.nav_booking) {
            Intent bookingIntent = new Intent(HomeActivity.this, BookingActivity.class);
            startActivity(bookingIntent);

        }else if(id == R.id.nav_classes) {
            Intent classesIntent = new Intent(HomeActivity.this, ClassesActivity.class);
            startActivity(classesIntent);

        }else if(id == R.id.nav_about) {
            Intent aboutIntent = new Intent(HomeActivity.this, ScrollingActivity.class);
            startActivity(aboutIntent);

        } else if (id == R.id.nav_contact) {
            Intent contactIntent = new Intent(HomeActivity.this, ContactUsActivity.class);
            startActivity(contactIntent);

        } else if (id == R.id.nav_find) {
            Intent findIntent = new Intent(HomeActivity.this,FindUsActivity.class);
            startActivity(findIntent);

        } else if (id == R.id.nav_music) {
            Intent musicIntent = new Intent(HomeActivity.this,MusicActivity.class);
            startActivity(musicIntent);
        }
        else if (id == R.id.nav_rateus) {
            Intent rateusIntent = new Intent(HomeActivity.this,RateUsActivity.class);
            startActivity(rateusIntent);
        }
        else if (id == R.id.nav_logout) {
            Intent logoutIntent = new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(logoutIntent);
        }

        else if (id == R.id.nav_share) {
            String message = "testing, testing";
            Intent shareText = new Intent(Intent.ACTION_SEND);
            shareText.setType("text/plain");
            shareText.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(shareText, "SHARING OPTIONS"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

