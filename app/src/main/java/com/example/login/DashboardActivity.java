package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    TextView apodo;
    String apodobundle;
    String correo;
    Bundle bundle  = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        apodo = findViewById(R.id.apodoDashBoard);
        Bundle recibo = getIntent().getExtras();
        apodobundle = recibo.getString("apodo");
        apodo.setText(apodobundle);
        correo = recibo.getString("correo");


    }

    public void Buscar (View view){
        Intent intent = new Intent(this, BuscadorActivity.class);
        startActivity(intent);
    }

    public void Actualizar (View view){
        Intent intent = new Intent(this,EditarActivity.class);
        startActivity(intent);
    }

    public void Eliminar (View view){
        Intent intent = new Intent(this,EditarActivity.class);
        startActivity(intent);
    }

    public void Tienda (View view){

        bundle.putSerializable("correo",correo);

        Intent intent = new Intent(this,TiendaActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void Historial (View view){
        Intent intent = new Intent(this, HistorialActivity.class);
        bundle.putSerializable("correo",correo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}