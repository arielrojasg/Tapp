package com.example.lab06_tapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginCorreo extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText usernameEditText,passwordEditText;
    ProgressBar progressBar;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_correo);

        mAuth = FirebaseAuth.getInstance();

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        loginButton = findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }

    public void Login(){
        String user = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if(user.isEmpty()){
            usernameEditText.setError("Digite un correo");
            usernameEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(user).matches()){
            usernameEditText.setError("Digite un correo válido");
            usernameEditText.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passwordEditText.setError("Digite una contraseña");
            passwordEditText.requestFocus();
            return;
        }

        if(password.length() < 5){
            passwordEditText.setError("La contraseña debe tener al menos 5 caracteres");
            passwordEditText.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(user,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.VISIBLE);
                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginCorreo.this, Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    LoginCorreo.this.startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Credenciales incorrectos",Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }
}
