package com.example.emailsender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtMessage;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        sendBtn = findViewById(R.id.sendEmail);
        txtphoneNo = findViewById(R.id.editText);
        txtMessage = findViewById(R.id.editText2);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNo = txtphoneNo.getText().toString();
                message = txtMessage.getText().toString();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

                //Get the SmsManager instance and call the sendTextMessage method to send message
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(phoneNo, null, message, pi,null);

                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }



}