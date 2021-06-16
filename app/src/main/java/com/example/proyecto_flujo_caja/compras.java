package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;


import com.example.proyecto_flujo_caja.Models.Compras;

public class compras extends AppCompatActivity {
    private Compras compra;
    EditText contado, treinta, venta;
    Button registra, cancel;

    private Double pcontado, ptreinta, pventas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);
        setContentView(R.layout.activity_compras);
        contado = findViewById(R.id.cont);
        treinta = findViewById(R.id.tren);
        venta = findViewById(R.id.vent);


        registra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cont = contado.getText().toString();
                final String thirty = treinta.getText().toString();
                final String ventaa = venta.getText().toString();

                if(TextUtils.isEmpty(cont)){
                    contado.setError("Campo Obligatorio");
                    return;
                }
                if(TextUtils.isEmpty(thirty)){
                    treinta.setError("Campo Obligatorio");
                    return;
                }
                if(TextUtils.isEmpty(ventaa)){
                    venta.setError("Campo Obligatorio");
                    return;
                }



                pcontado =Double.parseDouble(contado.getText().toString());
                ptreinta =Double.parseDouble(treinta.getText().toString());
                pventas =Double.parseDouble(venta.getText().toString());


                compra = new Compras (pcontado,ptreinta,pventas);
                startActivity(new Intent(getApplicationContext(),proyeccion_compras.class));

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