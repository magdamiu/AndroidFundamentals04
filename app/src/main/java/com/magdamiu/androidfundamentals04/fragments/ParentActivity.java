package com.magdamiu.androidfundamentals04.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.magdamiu.androidfundamentals04.R;

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
    }
}
