package com.magdamiu.androidfundamentals04.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.magdamiu.androidfundamentals04.R;

public class ListenerFragmentActivity extends AppCompatActivity implements AndroidListener{

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener_fragment);

        textViewResult = findViewById(R.id.textViewResult);

        openFragment(new InputNumbersFragment());
    }

    private void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void sumOfTwoNumbers(int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        textViewResult.setText(sum + "");
    }
}
