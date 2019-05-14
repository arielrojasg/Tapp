package com.example.lab06_tapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,HomeAdapter.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<Integer> images = new ArrayList<Integer>();
    private RecyclerView.LayoutManager layoutManager;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        images.add(R.drawable.comer1);
        images.add(R.drawable.comer2);
        images.add(R.drawable.comer3);
        images.add(R.drawable.comer4);
        images.add(R.drawable.comer5);
        images.add(R.drawable.comer6);

        recyclerView = findViewById(R.id.comerciosView);
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HomeAdapter(images, this);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_miscupones) {
            Intent intent = new Intent(Home.this, Mis_Cupones.class);
            Home.this.startActivity(intent);
        } else if (id == R.id.nav_historial) {
            Intent intent = new Intent(Home.this, Historial.class);
            Home.this.startActivity(intent);
        } else if (id == R.id.nav_factura) {
            Intent intent = new Intent(Home.this, Factura.class);
            Home.this.startActivity(intent);
        } else if (id == R.id.nav_metodospago) {
            Intent intent = new Intent(Home.this, Tarjetas.class);
            Home.this.startActivity(intent);
        } else if (id == R.id.nav_config) {
            Intent intent = new Intent(Home.this, Configuracion.class);
            Home.this.startActivity(intent);
        } else if (id == R.id.nav_cerrarsesion) {
            Intent intent = new Intent(Home.this, MainActivity.class);
            Home.this.startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this, CuponesComerc.class);
        intent.putExtra("posicion",images.get(position));
        Home.this.startActivity(intent);

    }
}
