package com.example.techcareservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    private EditText etAddress, etIssue;
    private RadioGroup rgDelivery;
    private DatePicker datePicker;
    private Button btnSubmit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        etAddress = findViewById(R.id.et_address);
        etIssue = findViewById(R.id.et_issue_desc);
        rgDelivery = findViewById(R.id.rg_delivery_type);
        datePicker = findViewById(R.id.booking_date_picker);
        btnSubmit = findViewById(R.id.btn_submit_booking);
        btnBack = findViewById(R.id.btn_back_to_services); // New Button

        // Logic to hide address for Drop Off
        rgDelivery.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_drop_off) {
                etAddress.setVisibility(View.GONE);
            } else {
                etAddress.setVisibility(View.VISIBLE);
            }
        });

        // BACK BUTTON LOGIC
        btnBack.setOnClickListener(v -> {
            finish(); // Simply goes back to MainActivity
        });

        // SUBMIT LOGIC
        btnSubmit.setOnClickListener(v -> {
            String service = getIntent().getStringExtra("SERVICE_NAME");
            if (service == null) service = "Repair Request";

            String issue = etIssue.getText().toString().trim();
            String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1);

            if (!issue.isEmpty()) {
                String fullBooking = service + " | " + issue + " (" + date + ")";
                BookingData.allBookings.add(fullBooking);
                Toast.makeText(this, "Booking Sent!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Please describe the issue", Toast.LENGTH_SHORT).show();
            }
        });
    }
}