package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonsend;
        EditText TextPhoneNo,TextSMS;

        buttonsend = (Button) findViewById(R.id.button);
        TextPhoneNo = (EditText) findViewById(R.id.editTextPhone);
        TextSMS = (EditText) findViewById(R.id.editTextSmS);

        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Phoneno = TextPhoneNo.getText().toString();
                String Sms = TextSMS.getText().toString();

                try {
                    SmsManager smsmanager = SmsManager.getDefault();
                    smsmanager.sendTextMessage(Phoneno, null, Sms, null, null);
                    Toast.makeText(getApplicationContext(), "전송완료!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "전송실패! 다시 시도해주세요", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        
    }
}