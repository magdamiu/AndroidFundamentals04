package com.magdamiu.androidfundamentals04.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magdamiu.androidfundamentals04.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SumFragment extends Fragment {

    private TextView textViewSum;

    public SumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sum, container, false);
        textViewSum = view.findViewById(R.id.textViewSum);

        getDataFromActivity();

        return view;
    }

    private void getDataFromActivity() {
        // get the data from bundle
        Bundle bundle = getArguments();
        int firstNumber = bundle.getInt(ParentDynamicFragmentActivity.FIRST_NUMBER, 0);
        int secondNumber = bundle.getInt(ParentDynamicFragmentActivity.SECOND_NUMBER, 0);
        int sum = firstNumber + secondNumber;
        textViewSum.setText(sum + "");
    }
}
