package com.example2.jazzco;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_booking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent bookingIntent = new Intent(this, HomeActivity.class);
            startActivity(bookingIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void sendNotification(View v) {
        EditText ed1 = (EditText) findViewById(R.id.editText1);
        EditText ed2 = (EditText) findViewById(R.id.editText2);
        EditText ed3 = (EditText) findViewById(R.id.editText3);
        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton rb5 = (RadioButton) findViewById(R.id.radioButton5);
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);

        String fullname = ed1.getText().toString().trim();
        String email = ed2.getText().toString().trim();
        String phone = ed3.getText().toString().trim();

        if (ed1.getText().toString().equals("")) {
            Toast.makeText(BookingActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
        } else if (ed2.getText().toString().equals("")) {
            Toast.makeText(BookingActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
        } else if (ed3.getText().toString().equals("")) {
            Toast.makeText(BookingActivity.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
        } else if (!rb1.isChecked() && !rb2.isChecked()) {
            Toast.makeText(BookingActivity.this, "Please select your class", Toast.LENGTH_SHORT).show();
        } else if (!rb3.isChecked() && !rb4.isChecked() && !rb5.isChecked()) {
            Toast.makeText(BookingActivity.this, "Please select day", Toast.LENGTH_SHORT).show();
        } else if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()) {
            Toast.makeText(BookingActivity.this, "Please select time", Toast.LENGTH_SHORT).show();
        }

        if (!ed1.getText().toString().equals("") && !ed2.getText().toString().equals("") && !ed3.getText().toString().equals("") && (rb1.isChecked() || rb2.isChecked()) && (rb3.isChecked() || rb4.isChecked() || rb5.isChecked()) && (cb1.isChecked() || cb2.isChecked() || cb3.isChecked())) {
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    CharSequence name = "chan1";
                    String description = "notification channel";
                    int importance = NotificationManager.IMPORTANCE_DEFAULT;
                    NotificationChannel channel = new NotificationChannel("channel1", name, importance);
                    channel.setDescription(description);

                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);

                    NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "channel1")
                            .setSmallIcon(R.drawable.ic_barbel)
                            .setContentTitle("Dear " + fullname + " (" + phone + ")")
                            .setContentText("Your booking is successful!")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
                    notificationManager.notify(1, notification.build());
                } else {
                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification notification = new Notification.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.ic_barbel)
                            .setContentTitle("Dear " + fullname + " (" + phone + ")")
                            .setContentText("Your booking is successful!").build();

                    manager.notify(1, notification);
                }
            }
        }
    }
}
