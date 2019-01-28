package com.example2.jazzco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        start= (Button) findViewById(R.id.buttonstart);
        stop= (Button) findViewById(R.id.buttonstop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_music, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent webviewIntent = new Intent(this, HomeActivity.class);
            startActivity(webviewIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view==start){
            startService(new Intent(this, MyService.class));
        }else if (view==stop) {
            stopService(new Intent(this, MyService.class));
        }
    }
}