package com.example.techcareservices;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        // 1. CALL BUTTON LOGIC
        findViewById(R.id.btn_call_support).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0812345678"));
            startActivity(intent);
        });

        // 2. EMAIL BUTTON LOGIC
        findViewById(R.id.btn_email_support).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:support@techcare.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Repair Inquiry");
            startActivity(intent);
        });

        // 3. BACK BUTTON
        findViewById(R.id.btn_support_back).setOnClickListener(v -> finish());
    }
}