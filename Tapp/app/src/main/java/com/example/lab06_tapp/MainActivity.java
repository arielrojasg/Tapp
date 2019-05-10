package com.example.lab06_tapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button tenCuentabtn;
    Button nueCuentabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tenCuentabtn = (Button)findViewById(R.id.tenCuentabtn);
        nueCuentabtn =(Button)findViewById(R.id.nuevaCuentabtn);
        tenCuentabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginOpciones();
            }
        });
        nueCuentabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegistro();
            }
        });

    }

    public void goToLoginOpciones(){

        Intent intent = new Intent(MainActivity.this, Login_opciones.class);
        MainActivity.this.startActivity(intent);
    }

    public void goToRegistro(){

        Intent intent = new Intent(MainActivity.this, Registro_Usuario.class);
        MainActivity.this.startActivity(intent);
    }
}
