package com.example2.jazzco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.gms.maps.model.LatLng;

public class FindUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_us);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_findus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent findIntent = new Intent(this, HomeActivity.class);
            startActivity(findIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showMap(View v)
    {
        RadioGroup group = (RadioGroup) findViewById(R.id.rgroup);
        int id = group.getCheckedRadioButtonId();
        LatLng latlng;
        Bundle info = new Bundle();

        if(id == R.id.radioButton1)
        {
            latlng = new LatLng(35.18, 33.38);
            info.putString("country", "Nicosia");
            info.putParcelable("position", latlng);
        }
        else if(id == R.id.radioButton2)
        {
            latlng = new LatLng(34.70, 33.02);
            info.putString("country", "Limasol");
            info.putParcelable("position", latlng);
        }

        else if(id == R.id.radioButton3)
        {
            latlng = new LatLng(34.77, 32.42);
            info.putString("country", "Paphos");
            info.putParcelable("position", latlng);
        }

        Intent in = new Intent(this, MapsActivity.class);
        in.putExtras(info);
        startActivity(in);
    }
}
