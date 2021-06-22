package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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


    String correo;

    List<Arma> listaArmas = new ArrayList<>();
    Compra_arma compra_arma = new Compra_arma();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);


        precioPistola = findViewById(R.id.precioPistolaid);
        precioLanzaLlamas = findViewById(R.id.precioLanzaLlamasid);


        damagePistola = findViewById(R.id.damagePistola);
        damageLanzallamas = findViewById(R.id.damageLanzaLlamas);


        /*Bundle recibo = getIntent().getExtras();
        correo = recibo.getString("correo");
        precioLaser.setText(correo);

        /* Call<List<Arma>> call = ApiClient.getUserService().getListaArmas();
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
        }); */



    }

    public void ComprarPistola (View view) {

        Compra_arma compra_arma = new Compra_arma(correo,"pistol", "Débito");
        Call<Compra_arma> call = ApiClient.getUserService().Comprar(compra_arma);
        call.enqueue(new Callback<Compra_arma>() {
            @Override
            public void onResponse(Call<Compra_arma> call, Response<Compra_arma> response) {
                Log.i("respuesta",response.toString());
            }

            @Override
            public void onFailure(Call<Compra_arma> call, Throwable t) {

            }
        });


    }

    public void ComprarLanzabombas (View view) {
        Compra_arma compra_arma = new Compra_arma(correo,"lanzabombas","Débito");
        Call<Compra_arma> call = ApiClient.getUserService().Comprar(compra_arma);
        call.enqueue(new Callback<Compra_arma>() {
            @Override
            public void onResponse(Call<Compra_arma> call, Response<Compra_arma> response) {
                Log.i("respuesta", response.toString());
            }

            @Override
            public void onFailure(Call<Compra_arma> call, Throwable t) {

            }
        });
    }
}