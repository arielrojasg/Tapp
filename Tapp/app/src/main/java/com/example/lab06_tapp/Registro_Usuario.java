package com.example.lab06_tapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Registro_Usuario extends AppCompatActivity {

    Button registrarseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        registrarseBtn = (Button)findViewById(R.id.registrobtn);
        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });

    }

    public void goToMain(){
        Intent intent = new Intent(Registro_Usuario.this, MainActivity.class);
        Registro_Usuario.this.startActivity(intent);
        Toast.makeText(Registro_Usuario.this, "Se ha registrado correctamente", Toast.LENGTH_LONG).show();
    }
}
