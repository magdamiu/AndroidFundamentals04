package com.magdamiu.androidfundamentals04;

import android.view.View;

public interface EventsClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
