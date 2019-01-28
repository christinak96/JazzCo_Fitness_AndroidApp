package com.example2.jazzco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class ContactUsActivity extends AppCompatActivity {
    private String file = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);



        EditText et1 = findViewById(R.id.edit_text_name);
        EditText et2 = findViewById(R.id.edit_text_email);
        EditText et3 = findViewById(R.id.edit_text_message);

        try {
            FileInputStream fin = openFileInput(file);
            DataInputStream dis = new DataInputStream(fin);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));

            int counter1 = 0;
            int counter2 = 0;
            String line = "";

            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.indexOf("."); i++) {
                    counter1++;
                }
                for (int i = counter1 + 1; i < line.indexOf(".."); i++) {
                    counter2++;
                }

                et1.setText(line.substring(0, counter1));
                et2.setText(line.substring(counter1 + 1, counter1 + 1 + counter2));
                et3.setText(line.substring(counter1 + 1 + counter2 + 2, line.length()));
                dis.close();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Retrieving data", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contactus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent contactusIntent = new Intent(this, HomeActivity.class);
            startActivity(contactusIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Submit(View v) {
        EditText et1 = findViewById(R.id.edit_text_name);
        EditText et2 = findViewById(R.id.edit_text_email);
        EditText et3 = findViewById(R.id.edit_text_message);

        String name = et1.getText().toString() + ".";
        String email = et2.getText().toString() + "..";
        String message = et3.getText().toString();


        if (et1.getText().toString().equals("")) {
            Toast.makeText(ContactUsActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
        } else if (et2.getText().toString().equals("")) {
            Toast.makeText(ContactUsActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
        } else if (et3.getText().toString().equals("")) {
            Toast.makeText(ContactUsActivity.this, "Please enter your message", Toast.LENGTH_SHORT).show();
        }

        if (!et1.getText().toString().equals("") && !et2.getText().toString().equals("") && !et3.getText().toString().equals("")) {


            try {
                FileOutputStream fout = openFileOutput(file, 0);
                fout.write(name.getBytes());
                fout.write(email.getBytes());
                fout.write(message.getBytes());
                fout.close();
                Toast.makeText(getApplicationContext(), "Data is stored!", Toast.LENGTH_LONG).show();
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "Error in storing data", Toast.LENGTH_LONG).show();
            }

            Intent in = new Intent(this, MessageActivity.class);
            startActivity(in);
        }
    }
}