package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarActivity extends AppCompatActivity {

    EditText idActualizar;
    EditText nombre;
    EditText username;
    EditText password;

    TextView idEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        idActualizar=findViewById(R.id.idActualizar);
        nombre=findViewById(R.id.nombreActualizar);
        username=findViewById(R.id.usernameActualizar);
        password=findViewById(R.id.passwordActualizar);

        idEliminar=findViewById(R.id.idEliminar);

    }

    public void Actualizar (View view) {
        usuario usuario = new usuario(idActualizar.getText().toString(), nombre.getText().toString(), username.getText().toString(), password.getText().toString());
        Call <Void> call = ApiClient.getUserService().Actualizar(usuario);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if(response.code()==201){
                    Log.i("G4", "El código es:"+response.code());
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    public void Eliminar (View view){
        Intent intent = new Intent (this, EditarActivity.class);
        Call<Void> call = ApiClient.getUserService().Eliminar(idEliminar.getText().toString());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code()==201){
                    Log.i("G4","El código es"+response.code());
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}