package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu_FlujoDeCaja extends AppCompatActivity {
    Button sem, anual, bia, tria, cuatri, quin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_flujo_de_caja);

        sem= findViewById(R.id.btnsem);
        anual=findViewById(R.id.btnanual);

        quin=findViewById(R.id.btnquin);

        sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FlujoSemestral.class));
            }
        });

        anual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FlujoAnual.class));
            }
        });

        quin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), flujo_caja5.class));
            }
        });
    }
}