package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;

public class HistorialActivity extends AppCompatActivity {

    EditText correoHistorial;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        correoHistorial = findViewById(R.id.correoHistorial);

    }

    public void Historial (View view){
        Call<List<Compra_arma>> call = ApiClient.getUserService().ListaComprada(correo);
    }
}