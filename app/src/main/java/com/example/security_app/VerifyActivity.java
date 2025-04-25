package com.example.security_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerifyActivity extends AppCompatActivity {
    ImageButton btnBack;
    Button btnNext;
    TextView phoneTextView ;
    @SuppressLint({"WrongViewCast", "MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify);

        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("phone_number");
        btnBack = findViewById(R.id.btn_back);
        btnNext = findViewById(R.id.btn_next);
        phoneTextView = findViewById(R.id.txt_phone_number);
        phoneTextView.setText("Mã xác thực được gửi đến " + phoneNumber);
        btnBack.setOnClickListener(v -> {
            Intent intent1 = new Intent(VerifyActivity.this, LoginActivity.class);
            startActivity(intent1);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerifyActivity.this, HomeActivity.class);
                intent.putExtra("phone_number", phoneNumber);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}