package com.example.facebookloginui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // đảm bảo đúng tên layout

        etName = findViewById(R.id.etName);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            if (!name.isEmpty()) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("user_name", name);
                startActivity(intent);
                finish(); // đóng LoginActivity
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        etName.setText(""); // xóa tên khi mở lại app
    }
}
