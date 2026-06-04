package com.example.techcareservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button btnBook, btnTrack, btnSupport, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Link to the IDs we fixed in step 1
        btnBook = findViewById(R.id.btnBookRepair);
        btnTrack = findViewById(R.id.btnTrackRepair);
        btnSupport = findViewById(R.id.btnSupportFAQ);
        btnLogout = findViewById(R.id.btnLogout);

        btnBook.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, BookingActivity.class)));

        btnTrack.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, HistoryActivity.class)));

        btnSupport.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, SupportActivity.class)));

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}