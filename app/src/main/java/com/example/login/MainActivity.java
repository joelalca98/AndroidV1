package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText name;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);

    }

    public void Registro(View view){

        Intent intent = new Intent(this, DashboardActivity.class);


        usuario usuario = new usuario(id.getText().toString(), name.getText().toString(), username.getText().toString(), password.getText().toString());
        Call<com.example.login.usuario> call = ApiClient.getUserService().Registro(usuario);

        call.enqueue(new Callback<com.example.login.usuario>() {
            @Override
            public void onResponse(Call<com.example.login.usuario> call, Response<com.example.login.usuario> response) {
                Log.i("G4", "Codico del servidor \n"+ response.code());
                com.example.login.usuario usuarioServidor = response.body();
                Log.i("G4","El objeto que me envia el servidor es\n" + usuarioServidor);
                if (response.code() ==201)
                {
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<com.example.login.usuario> call, Throwable t) {

            }
        });


    }
    }

