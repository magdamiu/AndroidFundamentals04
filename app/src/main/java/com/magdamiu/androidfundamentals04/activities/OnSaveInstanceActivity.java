package com.magdamiu.androidfundamentals04.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import com.magdamiu.androidfundamentals04.R;

public class OnSaveInstanceActivity extends AppCompatActivity {
    private static final String INPUT_VALUE = "input";
    private static final String CHECKBOX_VALUE = "check";

    private EditText editText;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_save_instance);

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the values filled by user
        // warning: make sure the ui elements are not null
        outState.putString(INPUT_VALUE, editText.getText().toString());
        outState.putBoolean(CHECKBOX_VALUE, checkBox.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the saved data for this activity (the data filled by user)
        // warning: make sure that getString and getBoolean are not null
        if(savedInstanceState != null) {
            String inputValue = savedInstanceState.getString(INPUT_VALUE);
            Boolean checkValue = savedInstanceState.getBoolean(CHECKBOX_VALUE);

            editText.setText(inputValue);
            checkBox.setSelected(checkValue);
        }
    }
}
