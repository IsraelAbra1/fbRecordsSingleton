package com.example.fbrecordssingletone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEnterName;
    Button btnAddRecord;
    private Button btnRecords;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etEnterName = findViewById(R.id.etEnterName);
        btnAddRecord = findViewById(R.id.btnAddRecord);
        btnAddRecord.setOnClickListener(this);
        btnRecords = findViewById(R.id.btnRecords);
        btnRecords.setOnClickListener(this);
        rnd = new Random();
    }

    @Override
    public void onClick(View v) {
        if (v == btnAddRecord) {
            String name = etEnterName.getText().toString();
            int score = rnd.nextInt(100);
            Toast.makeText(this, "Your score is: " + score, Toast.LENGTH_SHORT).show();
            FB.getInstance().setRecord(name, score);
        }

        if (v == btnRecords) {
            Intent intent = new Intent(this, RecordsActivity.class);
            startActivity(intent);
        }
    }

}