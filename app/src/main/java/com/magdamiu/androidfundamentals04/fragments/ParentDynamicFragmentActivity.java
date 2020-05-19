package com.magdamiu.androidfundamentals04.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.magdamiu.androidfundamentals04.R;

public class ParentDynamicFragmentActivity extends AppCompatActivity {

    // keys for bundle
    public static final String FIRST_NUMBER = "first";
    public static final String SECOND_NUMBER = "second";

    private EditText firstEditText;
    private EditText secondEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_dynamic_fragment);

        firstEditText = findViewById(R.id.editText2);
        secondEditText = findViewById(R.id.editText3);

        openFragment();
    }

    private void openFragment() {
        // 4 steps to add dynamically a fragment inside of an activity
        // step 1: create an instance of FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // step 2: create an instance of FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // step 3: replace container content with the fragment content
        fragmentTransaction.replace(R.id.containerDynamicFragment, new DynamicFragment());
        // step 4: commit transaction
        fragmentTransaction.commit();
    }

    // send data from activity to the fragment
    public void sendNumbersOnClick(View view) {
        // warning: make sure getText() does not return null
        // and the content of edit texts is not empty
        int firstNumber = Integer.valueOf(firstEditText.getText().toString());
        int secondNumber = Integer.valueOf(secondEditText.getText().toString());

        // use bundle to transfer info from activity to SumFragment, dynamically
        Bundle bundle = new Bundle();
        bundle.putInt(FIRST_NUMBER, firstNumber);
        bundle.putInt(SECOND_NUMBER, secondNumber);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SumFragment sumFragment = new SumFragment();
        // setArguments is used in order to pass the bundle object to the fragment
        sumFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.containerDynamicFragment, sumFragment);
        fragmentTransaction.commit();

    }

    public void sendDataFromActivitytoFragmentOnClick(View view) {
        // warning: make sure getText() does not return null
        // and the content of edit texts is not empty
        int firstNumber = Integer.valueOf(firstEditText.getText().toString());
        int secondNumber = Integer.valueOf(secondEditText.getText().toString());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // use the setData method from fragment in order to send the data
        SumFragment sumFragment = new SumFragment();
        sumFragment.setData(firstNumber, secondNumber);

        fragmentTransaction.replace(R.id.containerDynamicFragment, sumFragment);
        fragmentTransaction.commit();
    }
}
