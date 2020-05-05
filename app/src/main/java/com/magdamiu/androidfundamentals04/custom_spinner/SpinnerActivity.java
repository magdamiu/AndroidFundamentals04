package com.magdamiu.androidfundamentals04.custom_spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Spinner;

import com.magdamiu.androidfundamentals04.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinnerColors;
    private List<String> colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        getColors();
        spinnerColors = findViewById(R.id.spinnerColors);
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(
                this,
                R.layout.color_item,
                colors);
        spinnerColors.setAdapter(adapter);
    }

    private void getColors(){
        colors = new ArrayList<>();
        colors.add("red");
        colors.add("purple");
        colors.add("green");
        colors.add("orange");
        colors.add("pink");
        colors.add("blue");
        colors.add("yellow");
        colors.add("magenta");
    }
}
