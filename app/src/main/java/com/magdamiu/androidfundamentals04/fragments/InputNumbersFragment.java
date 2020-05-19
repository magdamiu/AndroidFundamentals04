package com.magdamiu.androidfundamentals04.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.magdamiu.androidfundamentals04.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputNumbersFragment extends Fragment {

    private EditText editTextFirstNumber;
    private EditText editTextSecondNumber;
    private Button buttonSendNumbers;

    public InputNumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_numbers, container, false);

        editTextFirstNumber = view.findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = view.findViewById(R.id.editTextSecondNumber);
        buttonSendNumbers = view.findViewById(R.id.buttonSendNumbers);

        buttonSendNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.valueOf(editTextFirstNumber.getText().toString());
                int secondNumber = Integer.valueOf(editTextSecondNumber.getText().toString());

                // getActivity helps us to have access to the parent activity
                AndroidListener androidListener = (AndroidListener) getActivity();

                // this method call helps to send data from fragment to the parent activity
                androidListener.sumOfTwoNumbers(firstNumber, secondNumber);
            }
        });
        return view;
    }
}
