package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
    public void iniFlujo(View view){
        Intent venta = new Intent(this, proyeccion_ventas.class);
        startActivity(venta);
    }
    public void sinFlujo(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}