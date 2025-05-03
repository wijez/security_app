package com.example.security_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TicketActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ticket);

        // Set up back button
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        CardView menuItem1 = findViewById(R.id.menuItem1);
        CardView menuItem5 = findViewById(R.id.menuItem5);
        menuItem1.setOnClickListener(v -> {
            Intent intent = new Intent(TicketActivity.this, TicketDetailsActivity.class);
            intent.putExtra("MENU_TITLE", "Nhặt rác bãi biển A");
            startActivity(intent);
            finish();
        });
        menuItem5.setOnClickListener(v -> {
            Intent intent = new Intent(TicketActivity.this, TicketDetailsContestActivity.class);
            intent.putExtra("MENU_TITLE", "Nhặt rác bãi biển A");
            startActivity(intent);
            finish();
        });
    }
}