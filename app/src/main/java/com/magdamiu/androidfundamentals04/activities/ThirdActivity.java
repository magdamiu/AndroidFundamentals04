package com.magdamiu.androidfundamentals04.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.magdamiu.androidfundamentals04.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String messageFromActivity = bundle.getString(SecondActivity.ECHO);
            if (messageFromActivity != null && messageFromActivity.length() >= 3) {
                String response = "Yes, I'm here";

                // create a default Intent instance
                Intent intent = new Intent();

                // set the result we want to send to the SecondActivity
                intent.putExtra(SecondActivity.RESPONSE_ECHO, response);

                //RESULT_OK it means that we are OK
                setResult(RESULT_OK, intent);

                // close current activity
                // we are interested only in validating the data and sending back a result
                finish();
            }
        }
    }
}
