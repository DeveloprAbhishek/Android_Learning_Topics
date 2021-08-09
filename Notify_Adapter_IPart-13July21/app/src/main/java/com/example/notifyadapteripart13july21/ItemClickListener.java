package com.example.notifyadapteripart13july21;

import android.widget.TextView;

import androidx.cardview.widget.CardView;

public interface ItemClickListener {
    void onItemClicked(int position, CardView cardView, TextView textView, boolean isTrue);
}
