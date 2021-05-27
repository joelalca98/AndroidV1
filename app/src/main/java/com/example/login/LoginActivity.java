package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText apodo;
    EditText pass;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apodo=findViewById(R.id.apodoLogin);
        pass =findViewById(R.id.passwordLogin);

        progressBar=findViewById(R.id.progressBar2);
    }
    public void registrarse (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void login (View view){
        progressBar.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, DashboardActivity.class);
        Usuario usuario = new Usuario(apodo.getText().toString(), pass.getText().toString());
        Call<Usuario> call = ApiClient.getUserService().Login(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.code()==201){
                    startActivity(intent);
                    progressBar.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }
}