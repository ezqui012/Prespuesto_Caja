package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.Ventas;
import com.google.firebase.firestore.FirebaseFirestore;

public class ventas extends AppCompatActivity {
    private Ventas venta;
    EditText contado, treinta, sesenta, interes, incob;
    Button registra, cancel;
    ProgressBar progressBar;
    //private Double vcontado, vtreinta, vsesenta, vinteres, vincobrabilidad;
    Company company;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        setContentView(R.layout.activity_ventas);
        company = (Company) getIntent().getSerializableExtra("information");
        contado = findViewById(R.id.contado);
        treinta = findViewById(R.id.treinta);
        sesenta = findViewById(R.id.sesenta);
        interes = findViewById(R.id.interes);
        incob = findViewById(R.id.incobra);
        registra = findViewById(R.id.registra);
        cancel = findViewById(R.id.cancel);
        progressBar = findViewById(R.id.progressBar);



        registra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cont = contado.getText().toString();
                final String inte = interes.getText().toString();
                final String inco = incob.getText().toString();

                if(TextUtils.isEmpty(cont)){
                    contado.setError("Este campo es requerido");
                    return;
                }
                if(TextUtils.isEmpty(inte)){
                    interes.setError("Este campo es requerido");
                    return;
                }
                if(TextUtils.isEmpty(inco)){
                    incob.setError("Este campo es requerido");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                /*vcontado =Double.parseDouble(contado.getText().toString());
                vtreinta =Double.parseDouble(treinta.getText().toString());
                vsesenta =Double.parseDouble(sesenta.getText().toString());
                vinteres =Double.parseDouble(interes.getText().toString());
                vincobrabilidad =Double.parseDouble(incob.getText().toString());

                //venta = new Ventas (vcontado,vtreinta,vsesenta,vinteres,vincobrabilidad);*/

                db.collection("venta").add(venta);

                Toast.makeText(ventas.this, "Guardado correctamente",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), proyeccion_ventas.class);
                intent.putExtra("information", company);
                startActivity(intent);
                //startActivity(new Intent(getApplicationContext(),proyeccion_ventas.class));

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

}