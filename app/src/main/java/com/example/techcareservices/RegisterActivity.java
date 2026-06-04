package com.example.techcareservices;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        EditText etName = findViewById(R.id.et_reg_name);
        EditText etEmail = findViewById(R.id.et_reg_email);
        EditText etPass = findViewById(R.id.et_reg_password);
        Button btnRegister = findViewById(R.id.btn_register_submit);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String pass = etPass.getText().toString().trim();

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            // 1. Create User in Firebase Auth
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    String userId = mAuth.getCurrentUser().getUid();

                    // 2. Save Additional Info (Name) to Firebase Realtime Database
                    HashMap<String, Object> userMap = new HashMap<>();
                    userMap.put("name", name);
                    userMap.put("email", email);
                    userMap.put("role", "customer");

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(userId)
                            .setValue(userMap)
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(RegisterActivity.this, "Registered in Firebase!", Toast.LENGTH_SHORT).show();
                                finish(); // Go back to login
                            });
                } else {
                    Toast.makeText(this, "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}