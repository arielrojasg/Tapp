package com.example.lab06_tapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tarjetas extends AppCompatActivity {

    Button agregarTarjetabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjetas);

        agregarTarjetabtn =(Button)findViewById(R.id.agregar_tarjetabtn);
        agregarTarjetabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTarjetaForm();
            }
        });

    }

    public void goToTarjetaForm(){

        Intent intent = new Intent(Tarjetas.this, Tarjeta_form.class);
        Tarjetas.this.startActivity(intent);
    }
}
