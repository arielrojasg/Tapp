package com.example.lab06_tapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Configuracion extends AppCompatActivity {
    Button editarbtn,paisbtn,terminosbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        editarbtn = findViewById(R.id.editarBtn);
        paisbtn = findViewById(R.id.paisBtn);
        terminosbtn = findViewById(R.id.terminosBtn);

        editarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEditar();
            }
        });

        paisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPais();
            }
        });


        terminosbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String url = "http://api.tapp.cr/terms";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    public void goToEditar(){
        Intent intent = new Intent(Configuracion.this, EditarCuenta.class);
        Configuracion.this.startActivity(intent);
    }

    public void goToPais(){
        Intent intent = new Intent(Configuracion.this, Pais.class);
        Configuracion.this.startActivity(intent);
    }
}
