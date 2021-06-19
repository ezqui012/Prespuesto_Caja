package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.Ventas;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class iva extends AppCompatActivity {
    Button sig, cancel;
    TextView m1,m2,m3,cont1,cont2,cont3;
    String mes1,mes2,mes3,ct1,ct2,ct3;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iva);

        cancel=findViewById(R.id.cancelar_iva);
        m1= findViewById(R.id.m1);
        m2= findViewById(R.id.m2);
        m3= findViewById(R.id.m3);
        cont1= findViewById(R.id.dbcont1);
        cont2= findViewById(R.id.dbcont2);
        cont3= findViewById(R.id.dbcont3);

        Bundle bundle = this.getIntent().getExtras();
        mes1= bundle.getString("mes1");
        mes2= bundle.getString("mes2");
        mes3= bundle.getString("mes3");
        ct1= bundle.getString("contado1");
        ct2= bundle.getString("contado2");
        ct3= bundle.getString("contado3");

        m1.setText(mes1);
        m2.setText(mes2);
        m3.setText(mes3);
        cont1.setText(ct1);
        cont2.setText(ct2);
        cont3.setText(ct3);



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),menu_impuestos.class));
            }
        });
    }

}