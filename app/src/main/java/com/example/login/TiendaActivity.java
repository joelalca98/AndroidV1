package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TiendaActivity extends AppCompatActivity {


    TextView precioPistola;
    TextView precioLanzaLlamas;
    TextView precioLaser;

    TextView damagePistola;
    TextView damageLanzallamas;
    TextView damageLaser;

    List<Arma> listaArmas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);


        precioPistola = findViewById(R.id.precioPistolaid);
        precioLanzaLlamas = findViewById(R.id.precioLanzaLlamasid);
        precioLaser = findViewById(R.id.PrecioLaserid);

        damagePistola = findViewById(R.id.damagePistola);
        damageLanzallamas = findViewById(R.id.damageLanzaLlamas);
        damageLaser = findViewById(R.id.damageLaser);

        Call<List<Arma>> call = ApiClient.getUserService().getListaArmas();
        call.enqueue(new Callback<List<Arma>>() {
            @Override
            public void onResponse(Call<List<Arma>> call, Response<List<Arma>> response) {

                if(response.code() == 201){
                    listaArmas = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Arma>> call, Throwable t) {

            }
        });

    }

    public void Tienda (View view) {

    }
}