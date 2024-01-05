package com.example.utsappdev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    // Database Helper
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi elemen UI
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Inisialisasi DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Ketika tombol login ditekan
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mengambil input pengguna
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                // memeriksa apakah pengguna cocok dengan data dalam database
                if (isValidUser(enteredUsername, enteredPassword)) {
                    // Pengguna berhasil masuk, lakukan tindakan yang sesuai di sini
                    Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();

                    // Contoh: Alihkan ke MainActivity
                    Intent intent = new Intent(LoginActivity.this, ContactsActivity.class);
                    startActivity(intent);
                } else {
                    // memberikan pesan kesalahan ke pengguna jika username atau password salah
                    Toast.makeText(LoginActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Fungsi untuk memeriksa apakah pengguna valid
    private boolean isValidUser(String username, String password) {
        // Di sini, Anda dapat memeriksa apakah username dan password cocok dengan data dalam database.
        return username.equals("user") && password.equals("user");
    }
}
