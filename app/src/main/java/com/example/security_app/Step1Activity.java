package com.example.security_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Step1Activity extends AppCompatActivity {
    Button btnContinue;
    View dot1, dot2, dot3;
    int imageIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_step1);
        btnContinue = findViewById(R.id.btnContinue);
        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);
        findViewById(R.id.image_placeholder).setBackgroundResource(R.drawable.water);
        dot1.setBackgroundResource(R.drawable.dot_active);
        dot2.setBackgroundResource(R.drawable.dot_inactive);
        dot3.setBackgroundResource(R.drawable.dot_inactive);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageIndex == 3) {
                    Intent intent = new Intent(Step1Activity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }

                switch (imageIndex) {
                    case 1:
                        findViewById(R.id.image_placeholder).setBackgroundResource(R.drawable.trash);
                        dot1.setBackgroundResource(R.drawable.dot_inactive);
                        dot2.setBackgroundResource(R.drawable.dot_active);
                        dot3.setBackgroundResource(R.drawable.dot_inactive);
                        break;
                    case 2:
                        findViewById(R.id.image_placeholder).setBackgroundResource(R.drawable.earth);
                        dot1.setBackgroundResource(R.drawable.dot_inactive);
                        dot2.setBackgroundResource(R.drawable.dot_inactive);
                        dot3.setBackgroundResource(R.drawable.dot_active);
                        break;
                }

                imageIndex++;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}