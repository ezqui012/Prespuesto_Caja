package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.FlujoCajaProy;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FlujoCaja extends AppCompatActivity {

    FlujoCajaProy flujo;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

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

    private Double ingreos;
    private Double gastos;
    private Double fuente;
    private Double uso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flujo_caja);

        ingreos = (Double) getIntent().getSerializableExtra("ingresoOP");
        gastos = (Double) getIntent().getSerializableExtra("gastoOP");
        fuente = (Double) getIntent().getSerializableExtra("fuentes");
        uso = (Double) getIntent().getSerializableExtra("usos");

        //flujo = (FlujoCajaProy) getIntent().getSerializableExtra("flujoCajaInfo");

        flujo = new FlujoCajaProy(ingreos, gastos, 0.0, 0.0, fuente, uso, 100.0);

        db.collection("flujoCaja").document("wwACBFEC1JO1Ls0ZUueE").update(flujo.getMapInfo());

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