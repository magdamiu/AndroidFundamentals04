package com.magdamiu.androidfundamentals04.recycler_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.magdamiu.androidfundamentals04.R;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String eventId = bundle.getString(EventsActivity.EVENT_ID);
            // get the current data for this event id
        }
    }
}
