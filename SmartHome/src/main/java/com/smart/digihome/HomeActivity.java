package com.smart.digihome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import adapter.MyGridAdapter;
import customviews.GridRecyclerView;

public class HomeActivity extends AppCompatActivity {

    GridRecyclerView gridRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gridRecyclerView = findViewById(R.id.recyclerView);
        gridRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        gridRecyclerView.setAdapter(new MyGridAdapter(this));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add Room", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
