package com.example.lab06_tapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class Mis_Cupones extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis__cupones);

        recyclerView = (RecyclerView) findViewById(R.id.historial_view);
        emptyView = (TextView)findViewById(R.id.empty_view);
    }
}
