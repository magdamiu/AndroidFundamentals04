package com.magdamiu.androidfundamentals04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.magdamiu.androidfundamentals04.activities.LifecycleTestActivity;
import com.magdamiu.androidfundamentals04.activities.OnSaveInstanceActivity;
import com.magdamiu.androidfundamentals04.custom_spinner.SpinnerActivity;
import com.magdamiu.androidfundamentals04.fragments.ListenerFragmentActivity;
import com.magdamiu.androidfundamentals04.fragments.NavigationDrawerActivity;
import com.magdamiu.androidfundamentals04.fragments.ParentActivity;
import com.magdamiu.androidfundamentals04.fragments.ParentDynamicFragmentActivity;
import com.magdamiu.androidfundamentals04.fragments.tabs.TabsActivity;
import com.magdamiu.androidfundamentals04.recycler_view.EventsActivity;
import com.magdamiu.androidfundamentals04.styles.StylesActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void loginOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, LoginActivity.class));
    }

    public void eventsOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, EventsActivity.class));
    }

    public void spinnerOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, SpinnerActivity.class));
    }

    public void mainOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, MainActivity.class));
    }

    public void lifecycleOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, LifecycleTestActivity.class));

//        Intent intent = new Intent(FirstActivity.this, LifecycleTestActivity.class);
//        startActivity(intent);
    }

    public void onSaveInstanceStateOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, OnSaveInstanceActivity.class));
    }

    public void openFragmentInActivityOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, ParentActivity.class));
    }

    public void openDynamicFragmentInActivityOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, ParentDynamicFragmentActivity.class));
    }

    public void openDynamicFragmentWithListenerOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, ListenerFragmentActivity.class));
    }

    public void openNavigationDrawerOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, NavigationDrawerActivity.class));
    }

    public void tabsOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, TabsActivity.class));
    }

    public void stylesOnClick(View view) {
        startActivity(new Intent(FirstActivity.this, StylesActivity.class));
    }
}
