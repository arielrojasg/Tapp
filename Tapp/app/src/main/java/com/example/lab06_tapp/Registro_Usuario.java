package com.example.lab06_tapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Registro_Usuario extends AppCompatActivity {

    EditText correo, password;
    Button registrarseBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        registrarseBtn = (Button)findViewById(R.id.registrobtn);
        correo = (EditText) findViewById(R.id.correotxt);
        password = (EditText) findViewById(R.id.passwordtxt);
        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    public void goToMain(){
        String mail = correo.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(mail.isEmpty()){
            correo.setError("Digite un correo");
            correo.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            correo.setError("Digite un correo válido");
            correo.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            password.setError("Digite una contraseña");
            password.requestFocus();
            return;
        }

        if(pass.length() < 5){
            password.setError("La contraseña debe tener al menos 5 caracteres");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Se ha registrado correctamente",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registro_Usuario.this, MainActivity.class);
                    Registro_Usuario.this.startActivity(intent);
                }else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "Ya hay un usuario registrado con ese correo",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Datos incompletos", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
