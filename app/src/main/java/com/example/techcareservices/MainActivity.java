package com.example.techcareservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. SERVICE BUTTONS
        findViewById(R.id.btn_ac_service).setOnClickListener(v -> openBooking("AC Repair"));
        findViewById(R.id.btn_laptop_service).setOnClickListener(v -> openBooking("Laptop Repair"));
        findViewById(R.id.btn_tv_service).setOnClickListener(v -> openBooking("TV Repair"));
        findViewById(R.id.btn_phone_service).setOnClickListener(v -> openBooking("Phone Repair"));

        // 2. TRACKING BUTTON
        findViewById(R.id.btn_go_to_track).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, HistoryActivity.class));
        });

        // 3. SUPPORT & FAQ BUTTON (New)
        findViewById(R.id.btn_go_to_support).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SupportActivity.class));
        });

        // 4. LOGOUT BUTTON
        findViewById(R.id.btn_back_to_login).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }

    // This helper method must be OUTSIDE onCreate but INSIDE the class
    private void openBooking(String serviceName) {
        Intent intent = new Intent(MainActivity.this, BookingActivity.class);
        intent.putExtra("SERVICE_NAME", serviceName);
        startActivity(intent);
    }
}