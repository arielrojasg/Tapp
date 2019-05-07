package com.example.lab06_tapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_opciones extends AppCompatActivity {

    Button correobtn;
    Button facebookbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_opciones);

        facebookbtn = (Button) findViewById(R.id.facebookbtn);
        correobtn = (Button) findViewById(R.id.correobtn);

        facebookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
        correobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
    }

    public void goToHome(){

        Intent intent = new Intent(Login_opciones.this, Home.class);
        Login_opciones.this.startActivity(intent);
    }
}
