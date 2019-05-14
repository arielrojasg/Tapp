package com.example.lab06_tapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class CuponesFragment extends Fragment {
    View view;
    int posicion;
    CuponesAdapter adapter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Integer> images;

    @SuppressLint("ValidFragment")
    public CuponesFragment(int posicion){
        this.posicion=posicion;
    }

    public void llenarImagenes(int posicion){
        switch(posicion){
            case R.drawable.comer1:
                images.add(R.drawable.comer1cupon1);
                images.add(R.drawable.comer1cupon2);
                break;
            case R.drawable.comer2:
                images.add(R.drawable.comer2cupon1);
                images.add(R.drawable.comer2cupon2);
                break;
            case R.drawable.comer3:
                images.add(R.drawable.comer3cupon1);
                break;
            case R.drawable.comer4:
                images.add(R.drawable.comer4cupon1);
                break;
            case R.drawable.comer5:
                images.add(R.drawable.comer5cupon1);
                break;
            case R.drawable.comer6:
                images.add(R.drawable.comer6cupon1);
                break;
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cupones_fragment,container,false);
        images = new ArrayList<>();
        recyclerView = view.findViewById(R.id.cuponesView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        this.llenarImagenes(posicion);
        adapter = new CuponesAdapter(images);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
