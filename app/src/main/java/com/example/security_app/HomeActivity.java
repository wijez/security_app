package com.example.security_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    ImageButton btnTicket, btnProfile;
    TextView txt_phone, txt_user_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        btnTicket = findViewById(R.id.btn_ticket);
        btnProfile = findViewById(R.id.imageButton8);
        txt_phone = findViewById(R.id.txt_phone);
        txt_user_phone = findViewById(R.id.txt_user_phone);
        String phoneNumber = getIntent().getStringExtra("phone_number");

        if (phoneNumber != null && phoneNumber.length() >= 3) {
            String maskedPhone = phoneNumber.substring(0, phoneNumber.length() - 3) + "xxx";

            txt_user_phone.setText(maskedPhone);
            txt_phone.setText(phoneNumber);
        }

        btnTicket.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, TicketActivity.class);
            startActivity(intent);
            finish();
        });

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}