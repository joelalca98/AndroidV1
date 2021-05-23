package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
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
}