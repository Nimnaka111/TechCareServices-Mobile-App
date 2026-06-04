package com.example.techcareservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    private ListView listView;
    private EditText etReply;
    private ArrayAdapter<String> adapter;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        listView = findViewById(R.id.admin_booking_list);
        etReply = findViewById(R.id.et_admin_reply);
        Button btnAccept = findViewById(R.id.btn_accept);
        Button btnReject = findViewById(R.id.btn_reject);
        Button btnDone = findViewById(R.id.btn_done);
        Button btnLogout = findViewById(R.id.btn_admin_logout); // New Button

        // Load List
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BookingData.allBookings);
        listView.setAdapter(adapter);

        // Select item
        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position;
            Toast.makeText(this, "Selected booking #" + (position + 1), Toast.LENGTH_SHORT).show();
        });

        // LOGOUT LOGIC
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // Handle Buttons
        btnAccept.setOnClickListener(v -> handleStatus("ACCEPTED"));
        btnReject.setOnClickListener(v -> handleStatus("REJECTED"));
        btnDone.setOnClickListener(v -> handleStatus("DONE"));
    }

    private void handleStatus(String status) {
        if (selectedPosition == -1) {
            Toast.makeText(this, "Please click a booking first", Toast.LENGTH_SHORT).show();
            return;
        }
        String current = BookingData.allBookings.get(selectedPosition);
        BookingData.allBookings.set(selectedPosition, current + " - [" + status + "]");
        adapter.notifyDataSetChanged();
        selectedPosition = -1;
        etReply.setText("");
    }
}