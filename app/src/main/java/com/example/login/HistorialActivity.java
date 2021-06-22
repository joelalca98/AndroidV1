package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistorialActivity extends AppCompatActivity {

    TextView apodoText;
    String correo;
    HistorialAdapter myAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        apodoText = findViewById(R.id.apodoText);
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        Bundle recibo = getIntent().getExtras();
        correo = recibo.getString("correo");
        //Intent intent = getIntent();
        //correo = intent.getStringExtra("correo");
        historial();



    }

    public void historial(){
        Call<List<Compra_arma>> call = ApiClient.getUserService().ListaComprada(correo);
        call.enqueue(new Callback<List<Compra_arma>>() {
            @Override
            public void onResponse(Call<List<Compra_arma>> call, Response<List<Compra_arma>> response) {
                List<Compra_arma> compra_armas = response.body();
               myAdapter = new HistorialAdapter();
                myAdapter.setData(compra_armas);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<Compra_arma>> call, Throwable t) {

            }
        });
    }
}