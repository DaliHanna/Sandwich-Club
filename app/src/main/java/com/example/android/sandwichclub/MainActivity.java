package com.example.android.sandwichclub;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.sandwichclub.models.Sandwich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);

        SandwichAdapter sandwichAdapter = new SandwichAdapter(MainActivity.this, sandwiches);
        recyclerView.setAdapter(sandwichAdapter);
    }


}
