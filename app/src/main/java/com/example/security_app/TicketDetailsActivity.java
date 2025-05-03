package com.example.security_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TicketDetailsActivity extends AppCompatActivity {
    private Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ticket_details);

        String menuTitle = getIntent().getStringExtra("MENU_TITLE");

        TextView titleText = findViewById(R.id.menu_title);
        titleText.setText(menuTitle);

        ImageButton backButton = findViewById(R.id.backButton);
        registerButton = findViewById(R.id.registerButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(TicketDetailsActivity.this, TicketActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        });

        registerButton.setOnClickListener(v -> showRegisterDialog());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
        private void showRegisterDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.custom_logout_dialog, null);

            TextView txtTitle = view.findViewById(R.id.txtTitle);
            TextView txtMessage = view.findViewById(R.id.txtMessage);
            Button btnCancel = view.findViewById(R.id.btnCancel);
            Button btnLogout = view.findViewById(R.id.btnLogout);

            // Set nội dung phù hợp đăng ký
            txtTitle.setText("Xác nhận đăng ký");
            txtMessage.setText("Bạn có muốn đăng ký không?");
            btnCancel.setText("Hủy bỏ");
            btnLogout.setText("Đồng ý");

            builder.setView(view);
            AlertDialog dialog = builder.create();

            btnCancel.setOnClickListener(v -> dialog.dismiss());

            btnLogout.setOnClickListener(v -> {
                dialog.dismiss();
                Toast.makeText(this, "Đã đăng ký thành công!", Toast.LENGTH_SHORT).show();
                registerButton.setText("Đã đăng ký");
                registerButton.setEnabled(false);
            });

            dialog.show();
        }
}