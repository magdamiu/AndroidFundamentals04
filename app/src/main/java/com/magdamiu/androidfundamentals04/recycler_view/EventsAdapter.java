package com.magdamiu.androidfundamentals04.recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.magdamiu.androidfundamentals04.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsViewHolder> {

    private List<Event> events;

    public EventsAdapter(List<Event> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eventItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventsViewHolder(eventItem);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        Event currentEvent = events.get(position);
        holder.getTextViewName().setText(currentEvent.getName());
        holder.getTextViewAddress().setText(currentEvent.getAddress());
        Picasso.get().load(currentEvent.getUrlImage()).into(holder.getImageViewEvent());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
