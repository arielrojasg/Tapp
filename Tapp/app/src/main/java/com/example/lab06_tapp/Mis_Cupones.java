package com.example.lab06_tapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class Mis_Cupones extends AppCompatActivity {

    CuponesAdapter adapter;
    RecyclerView recyclerView;
    private ArrayList<Integer> images;
    private RecyclerView.LayoutManager layoutManager;

    public void llenarImagenes(){
        images.add(R.drawable.comer1cupon1);
        images.add(R.drawable.comer1cupon2);
        images.add(R.drawable.comer2cupon2);
        images.add(R.drawable.comer3cupon1);
        images.add(R.drawable.comer4cupon1);
        images.add(R.drawable.comer6cupon1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis__cupones);
        layoutManager = new GridLayoutManager(this,1);
        images = new ArrayList<>();
        recyclerView = findViewById(R.id.mis_cupones_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        this.llenarImagenes();
        adapter = new CuponesAdapter(images);
        recyclerView.setAdapter(adapter);
    }
}
