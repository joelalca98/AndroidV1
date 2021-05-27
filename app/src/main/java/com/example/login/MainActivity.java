package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText correo;
    EditText apodo;
    EditText name;
    EditText apellido;
    EditText password;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        correo=findViewById(R.id.correoRegistro);
        apodo=findViewById(R.id.apodoRegistro);
        name=findViewById(R.id.nombreRegistro);
        apellido=findViewById(R.id.apellidoRegistro);
        password=findViewById(R.id.passwordRegistro);
        progressbar=findViewById(R.id.progressBar);

    }

    public void registro(View view){

        progressbar.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, DashboardActivity.class);
        Usuario usuario = new Usuario(correo.getText().toString(), apodo.getText().toString(), name.getText().toString(), apellido.getText().toString(), password.getText().toString());
        Call<Usuario> call = ApiClient.getUserService().Registro(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.i("G4", "Codico del servidor \n"+ response.code());
                Usuario usuarioServidor = response.body();
                Log.i("G4","El objeto que me envia el servidor es\n" + usuarioServidor);
                if (response.code() ==201)
                {
                    startActivity(intent);
                    progressbar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });


    }
    }

