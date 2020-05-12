package com.magdamiu.androidfundamentals04.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.magdamiu.androidfundamentals04.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    public static final String EVENT_ID = "eventId";

    private List<Event> events;
    private RecyclerView recyclerViewEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getEvents();
        recyclerViewEvents = this.findViewById(R.id.recyclerViewEvents);
        setLayoutManager(recyclerViewEvents);
        setAdapter(recyclerViewEvents);
        setRecyclerViewListener(recyclerViewEvents);
        setItemDecoration(recyclerViewEvents);
    }

    private void getEvents() {
        events = new ArrayList<>();
        Event event = null;
        for (int i = 0; i < 30; i++) {
            event = new Event();
            event.setName("Untold " + i);
            event.setAddress("Cluj " + i);
            event.setStartDate(new Date());
            event.setDescription("Un event cool " + i);
            event.setUrlImage("https://www.romania-insider.com/sites/default/files/styles/article_large_image/public/featured_images/untold-2017.jpg");
            events.add(event);
        }
    }

    private void setLayoutManager(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setAdapter(RecyclerView recyclerView) {
        EventsAdapter eventsAdapter = new EventsAdapter(events);
        recyclerView.setAdapter(eventsAdapter);
    }

    private void setRecyclerViewListener(RecyclerView recyclerView) {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new EventsClickListener() {
            @Override
            public void onClick(View view, final int position) {
                Toast.makeText(EventsActivity.this, getString(R.string.single_click) + position,
                        Toast.LENGTH_SHORT).show();

                Event event = events.get(position);
                Intent intent = new Intent(EventsActivity.this, EventDetailsActivity.class);
                intent.putExtra(EVENT_ID, event.getId());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(EventsActivity.this, getString(R.string.long_click) + position,
                        Toast.LENGTH_LONG).show();
            }
        }));
    }

    private void setItemDecoration(RecyclerView recyclerView) {
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }
}
