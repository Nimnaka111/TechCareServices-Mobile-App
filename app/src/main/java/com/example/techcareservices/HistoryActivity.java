package com.example.techcareservices;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Link to the ListView in activity_history.xml
        ListView listView = findViewById(R.id.history_list_view);

        // Use the same global list that the Admin updates
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                BookingData.allBookings
        );

        listView.setAdapter(adapter);
    }
}