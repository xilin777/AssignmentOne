package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Main screen – shows the banner, title overlay and four clickable topic buttons.
 * Each button is a LinearLayout that contains an ImageView (icon) + TextView (label).
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called from every button container (the LinearLayout that wraps icon + label).
     * Determines which topic was clicked by reading the label TextView.
     */
    public void onTopicClick(View view) {
        int topicId = -1;
        String toastMessage = "";

        // The clicked view is the LinearLayout that holds the ImageView + TextView
        if (view instanceof LinearLayout) {
            LinearLayout container = (LinearLayout) view;

            // The second child (index 1) is the TextView with the label
            View labelView = container.getChildAt(1);
            if (labelView instanceof TextView) {
                String label = ((TextView) labelView).getText().toString();

                switch (label) {
                    case "Facilities":
                        topicId = 0;
                        toastMessage = "Facilities clicked";
                        break;
                    case "Events":
                        topicId = 1;
                        toastMessage = "Events clicked";
                        break;
                    case "Clubs":
                        topicId = 2;
                        toastMessage = "Clubs clicked";
                        break;
                    case "Support":
                        topicId = 3;
                        toastMessage = "Support clicked";
                        break;
                }
            }
        }

        if (topicId == -1) {
            return; // safety – should never happen
        }

        // Part E – Toast
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("TOPIC_ID", topicId);
        startActivity(intent);
    }
}