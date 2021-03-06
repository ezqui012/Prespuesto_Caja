package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.FlujoCajaProy;

public class FlujoCaja extends AppCompatActivity {

    FlujoCajaProy flujo;

    private TextView actividadesOp;
    private TextView ingresosdOp;
    private TextView gastosOp;
    private TextView actividadesI;
    private TextView ingresosC;
    private TextView gastosC;
    private TextView actividadFin;
    private TextView fuentes;
    private TextView usos;
    private TextView incremento;
    private TextView efectivoIn;
    private TextView saldoProy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flujo_caja);

        flujo = new FlujoCajaProy(210000.00, 212131.00, 0.00, 0.00, 0.00, 0.00, 16000.00);

        actividadesOp = (TextView) findViewById(R.id.Input_total1);
        ingresosdOp = (TextView) findViewById(R.id.Input_ingresoOP);
        gastosOp = (TextView) findViewById(R.id.Input_ingresoGP);
        actividadesI = (TextView) findViewById(R.id.Input_total2);
        ingresosC = (TextView) findViewById(R.id.Input_ingresoIC);
        gastosC = (TextView) findViewById(R.id.Input_ingresoGC);
        actividadFin = (TextView) findViewById(R.id.Input_total3);
        fuentes = (TextView) findViewById(R.id.Input_fuentes);
        usos = (TextView) findViewById(R.id.Input_usos);
        incremento = (TextView) findViewById(R.id.Input_total4);
        efectivoIn = (TextView) findViewById(R.id.Input_total5);
        saldoProy = (TextView) findViewById(R.id.Input_total6);

        setTextView();
    }

    private void setTextView(){
        ingresosdOp.setText(String.valueOf(flujo.getIngresosdOp()));
        gastosOp.setText(String.valueOf(flujo.getGastosOp()));
        actividadesOp.setText(String.valueOf(flujo.getActividadesOp()));
        ingresosC.setText(String.valueOf(flujo.getIngresosC()));
        gastosC.setText(String.valueOf(flujo.getGastosC()));
        actividadesI.setText(String.valueOf(flujo.getActividadesI()));
        fuentes.setText(String.valueOf(flujo.getFuentes()));
        usos.setText(String.valueOf(flujo.getUsos()));
        actividadFin.setText(String.valueOf(flujo.getActividadFin()));
        incremento.setText(String.valueOf(flujo.getIncremento()));
        efectivoIn.setText(String.valueOf(flujo.getEfectivoIn()));
        saldoProy.setText(String.valueOf(flujo.getSaldoProy()));
    }

    public void volverinicio(View view){
        Intent change = new Intent(this, MainActivity.class);
        startActivity(change);
    }
}