package com.example2.jazzco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, ContactUsActivity.class);
        startActivity(intent);
    }
}
