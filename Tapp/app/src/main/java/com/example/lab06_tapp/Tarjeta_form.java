package com.example.lab06_tapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class Tarjeta_form extends AppCompatActivity {

    CardForm cardForm;
    Button guardarbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta_form);
        cardForm = findViewById(R.id.card_form);
        guardarbtn = findViewById(R.id.guardarTarbtn);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .setup(Tarjeta_form.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        guardarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });
    }

    public void guardar(){

        if (cardForm.isValid()) {
            Toast.makeText(Tarjeta_form.this, "Se agregó la tarjeta", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Tarjeta_form.this, Home.class);
            Tarjeta_form.this.startActivity(intent);
        }else {
            Toast.makeText(Tarjeta_form.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
        }

    }
}
