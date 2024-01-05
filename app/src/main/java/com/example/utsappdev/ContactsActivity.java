package com.example.utsappdev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ContactsActivity extends AppCompatActivity {

    private ListView contactsListView;
    private Button addContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        // Inisialisasi elemen UI
        contactsListView = findViewById(R.id.contactsListView);
        addContactButton = findViewById(R.id.addContactButton);

        // Inisialisasi DatabaseHelper
        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        // Tambahkan event listener untuk tombol "Add Contact"
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tindakan yang akan dilakukan saat tombol "Add Contact" ditekan
                Toast.makeText(ContactsActivity.this, "Tombol Add Contact ditekan", Toast.LENGTH_SHORT).show();
                // mengatur tindakan yang sesuai, seperti membuka form tambah kontak.
            }
        });

        // Lakukan tindakan lain yang diperlukan untuk menampilkan daftar kontak.
    }
}
