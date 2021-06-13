package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class ventas extends AppCompatActivity {
    EditText contado, treinta, sesenta, interes, incob;
    Button registra, cancel;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        setContentView(R.layout.activity_ventas);
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

                if(contado.getText().equals(0.1)){
                    treinta.setText(0);
                    sesenta.setText(0);
                    return;
                }
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

            }
        });
    }
}