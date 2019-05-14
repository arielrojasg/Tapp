package com.example.lab06_tapp;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class CuponesComerc extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private ImageView imageView;
    private ArrayList<Integer> images = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupones_comerc);

        images.add(R.drawable.comer1);
        images.add(R.drawable.comer2);
        images.add(R.drawable.comer3);
        images.add(R.drawable.comer4);
        images.add(R.drawable.comer5);
        images.add(R.drawable.comer6);

        int posicion;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                posicion= 0;
            } else {
                posicion= extras.getInt("posicion");
            }
        } else {
            posicion= (int) savedInstanceState.getSerializable("posicion");
        }

        imageView = findViewById(R.id.cuponimagen);
        imageView.setImageResource(posicion);
        tabLayout= findViewById(R.id.tablayout);
        appBarLayout = findViewById(R.id.appbarcupon);
        viewPager = findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new DineroFragment(),"DINERO CANJEABLE");
        adapter.AddFragment(new CuponesFragment(posicion),"CUPONES");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
