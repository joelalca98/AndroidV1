package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscadorActivity extends AppCompatActivity {

TextView id;
TextView nombre;
TextView username;
TextView password;


EditText identificador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        id=findViewById(R.id.idBuscador);
        nombre=findViewById(R.id.nombre);
        username=findViewById(R.id.apellido);
        password=findViewById(R.id.passwordBuscador);

        identificador=findViewById(R.id.identificador);

    }

    public void Buscador (View view){
        Call<usuario> call = ApiClient.getUserService().getUsuario(identificador.getText().toString());

        call.enqueue(new Callback<usuario>() {
            @Override
            public void onResponse(Call<usuario> call, Response<usuario> response) {
                if(response.code()==201){

                    id.setText(response.body().getIdUser());
                    nombre.setText(response.body().getNombre());
                    username.setText(response.body().getApellido());
                    password.setText(response.body().getPassword());
                }
            }

            @Override
            public void onFailure(Call<usuario> call, Throwable t) {

            }
        });
    }
}