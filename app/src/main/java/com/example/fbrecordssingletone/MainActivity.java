package com.example.fbrecordssingletone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private Button btnGame;

    public static ArrayList<Record> records;

    FB fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

    }

    private void initialization() {
        // initialize

        btnGame = findViewById(R.id.btnGame);
        btnGame.setOnClickListener(this);

        records = new ArrayList<>();
        fb = FB.getInstance();
    }

    public void dataChange() {
        // update the RecyclerView after change in the arraylist
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

        if(v == btnGame)
        {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }


    }


}