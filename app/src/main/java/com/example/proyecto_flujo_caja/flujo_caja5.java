package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.FlujoCajaProy;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class flujo_caja5 extends AppCompatActivity {

    TextView actividadesOp;
    TextView ingresosdOp;
    TextView gastosOp;
    TextView actividadesI;
    TextView ingresosC;
    TextView gastosC;
    TextView actividadFin;
    TextView fuentes;
    TextView usos;
    TextView incremento;
    TextView efectivoIn;
    TextView saldoProy;

    Double ingreos;
    Double gastos;
    Double fuente;
    Double uso;

    FlujoCajaProy flujo;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flujo_caja5);
        actividadesOp = (TextView) findViewById(R.id.totop);
        ingresosdOp = (TextView) findViewById(R.id.ingreop);
        gastosOp = (TextView) findViewById(R.id.gasop);
        actividadesI = (TextView) findViewById(R.id.totcap);
        ingresosC = (TextView) findViewById(R.id.ingrecap);
        gastosC = (TextView) findViewById(R.id.gascap);
        actividadFin = (TextView) findViewById(R.id.totfin);
        fuentes = (TextView) findViewById(R.id.fuentes);
        usos = (TextView) findViewById(R.id.usos);
        incremento = (TextView) findViewById(R.id.totincre);
        efectivoIn = (TextView) findViewById(R.id.totefeini);
        saldoProy = (TextView) findViewById(R.id.totefefin);
        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("FlujoAnual").document("a");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                ingreos = Double.parseDouble(documentSnapshot.getString("one"));
                gastos = Double.parseDouble(documentSnapshot.getString("two"));
                ingreos = ingreos + (ingreos * 0.25);
                gastos = gastos + (gastos * 0.25);

                fuente = Double.parseDouble(documentSnapshot.getString("five"));
                uso = Double.parseDouble(documentSnapshot.getString("six"));
                fuente = fuente + (fuente * 0.25);
                uso = uso + (uso * 0.25);

                flujo = new FlujoCajaProy(ingreos, gastos, 0.0, 0.0, fuente, uso, 16000.0);
                db.collection("flujoCaja5").document("Pi2OveaASqfUliSSRlDN").update(flujo.getMapInfo());


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
        });
    }

    public void volverinicio(View view){
        Intent change = new Intent(this, menu_FlujoDeCaja.class);
        startActivity(change);
    }
}