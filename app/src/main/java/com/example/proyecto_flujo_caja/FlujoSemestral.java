package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FlujoSemestral extends AppCompatActivity {
    TextView ingreop, gasop, totop, ingrecap, gascap, totcap, fuentes,usos,totfin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flujo_semestral);
        ingreop= findViewById(R.id.ingreop);
        gasop=findViewById(R.id.gasop);
        totop=findViewById(R.id.totop);
        ingrecap=findViewById(R.id.ingrecap);
        gascap=findViewById(R.id.gascap);
        totcap=findViewById(R.id.totcap);
        fuentes=findViewById(R.id.fuentes);
        usos=findViewById(R.id.usos);
        totfin=findViewById(R.id.totfin);


    }
}