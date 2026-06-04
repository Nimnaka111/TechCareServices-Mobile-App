package com.example.techcareservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailIn = findViewById(R.id.et_login_email);
        EditText passIn = findViewById(R.id.et_login_password);
        Button loginBtn = findViewById(R.id.btn_login);
        TextView tvRegister = findViewById(R.id.tv_go_to_register);

        // This is what opens the Register screen
        tvRegister.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        loginBtn.setOnClickListener(v -> {
            String email = emailIn.getText().toString().trim();
            String pass = passIn.getText().toString().trim();

            if (email.equals("admin@techcare.com") && pass.equals("admin123")) {
                startActivity(new Intent(this, AdminActivity.class));
            } else if (!email.isEmpty() && !pass.isEmpty()) {
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}