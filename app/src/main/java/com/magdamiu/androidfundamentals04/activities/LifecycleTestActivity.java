package com.magdamiu.androidfundamentals04.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.magdamiu.androidfundamentals04.R;

import java.lang.annotation.Target;

public class LifecycleTestActivity extends AppCompatActivity {
    public static String MESSAGE = "message";
    public static String COUNT = "count";
    private static String TAG = "LifecycleTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_test);

        // Log.e => error, red message
        // Log.w => warning
        // Log.i => info
        // Log.v => verbose
        // Log.d => debug
        // Log.wtf => what a terrible failure

        Log.e(TAG, "onCreate");
        Log.w(TAG, "onCreate");
        Log.i(TAG, "onCreate");
        Log.v(TAG, "onCreate");
        Log.d(TAG, "onCreate");
        Log.wtf(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    public void openSecondActivityOnClick(View view) {
        Intent intent = new Intent(LifecycleTestActivity.this, SecondActivity.class);
        // putExtra send info, a string, from LifecycleTestActivity to SecondActivity using the key MESSAGE
        intent.putExtra(MESSAGE, "hello second activity");
        intent.putExtra(COUNT, 23);
        startActivity(intent);
    }

    public void callOnClick(View view) {
        // implicit intent to call a phone number
        Intent callImplicitIntent = new Intent(Intent.ACTION_DIAL);
        callImplicitIntent.setData(Uri.parse("tel:0744444444"));

        // check if the implicit intent could be run on the current device
        if(callImplicitIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callImplicitIntent);
        } else {
            // display an alert...
        }
    }

    public void openLinkOnClick(View view) {
        // implicit intent to open an url inside of a browser
        Intent openUrlImplicitIntent = new Intent(Intent.ACTION_VIEW);
        openUrlImplicitIntent.setData(Uri.parse("https://developer.android.com/"));
        startActivity(openUrlImplicitIntent);
    }
}
