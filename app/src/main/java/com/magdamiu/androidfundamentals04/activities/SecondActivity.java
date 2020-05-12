package com.magdamiu.androidfundamentals04.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.magdamiu.androidfundamentals04.R;

public class SecondActivity extends AppCompatActivity {

    public static final String ECHO = "echo";
    public static final int ECHO_CHANNEL = 255;
    public static final String RESPONSE_ECHO = "responseEcho";

    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextMessage = findViewById(R.id.editTextMessage);

        // get all the content from bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // get the message received from LifecycleTestActivity by using the key MESSAGE
            // we know that the message is a string
            String message = bundle.getString(LifecycleTestActivity.MESSAGE);
            int count = bundle.getInt(LifecycleTestActivity.COUNT);
            Toast.makeText(SecondActivity.this, message, Toast.LENGTH_LONG).show();
        }
    }

    public void sendMessageToActivityOnClick(View view) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra(ECHO, "Are you there?");
        // ECHO_CHANNEL is the requestCode that will help us to match the request with the result
        startActivityForResult(intent, ECHO_CHANNEL);
    }

    // this method is used in order to get the result sent by ThirdActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ECHO_CHANNEL && resultCode == RESULT_OK) {
            String resultFromThirdActivity = data.getStringExtra(RESPONSE_ECHO);
            editTextMessage.setText(resultFromThirdActivity);
        }
    }
}
