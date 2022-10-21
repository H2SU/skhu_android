package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity  {
    EditText editID2, editPW2;
    String id,pw;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        editID2 = findViewById(R.id.editID2);
        editPW2 = findViewById(R.id.editPW2);

        Intent intent = getIntent();

        id = intent.getStringExtra("username");
        pw = intent.getStringExtra("password");
        editID2.setText(id);
        editPW2.setText(pw);
    }
}
