package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int topicId = getIntent().getIntExtra("TOPIC_ID", 0);

// Array of drawable resource IDs for the small topic icons
        int[] labelIds = {
                R.string.label_facilities,
                R.string.label_events,
                R.string.label_clubs,
                R.string.label_support
        };
// Array of string resource IDs for the page title below the banner
        int[] titleIds = {
                R.string.title_facilities,
                R.string.title_events,
                R.string.title_clubs,
                R.string.title_support
        };
// Array of string resource IDs for the scrollable content body
        int[] contentIds = {
                R.string.content_facilities,
                R.string.content_events,
                R.string.content_clubs,
                R.string.content_support
        };

        // Find UI elements by their IDs
        int[] iconIds = {
                R.drawable.img_btn_facilities,
                R.drawable.img_btn_events,
                R.drawable.img_btn_clubs,
                R.drawable.img_btn_support
        };

        ImageView icon = findViewById(R.id.img_detail_icon);
        TextView label = findViewById(R.id.txt_detail_label);
        TextView title = findViewById(R.id.txt_detail_title);
        TextView content = findViewById(R.id.txt_detail_content);

        // Dynamically set content based on topicId
        icon.setImageResource(iconIds[topicId]);
        label.setText(labelIds[topicId]);
        title.setText(titleIds[topicId]);
        content.setText(contentIds[topicId]);
    }
}