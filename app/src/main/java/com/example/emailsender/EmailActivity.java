package com.example.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {
    Button sendBtn;
    EditText txtTo;
    EditText txtSubject,txtMassage;
    String to;
    String subject,massageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        sendBtn = findViewById(R.id.sendEmail);
        txtTo = findViewById(R.id.editText);
        txtSubject = findViewById(R.id.editText2);
        txtMassage = findViewById(R.id.editText3);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to = txtTo.getText().toString();
                subject = txtSubject.getText().toString();
                massageText = txtMassage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, to);
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, massageText);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));


            }
        });
    }
}