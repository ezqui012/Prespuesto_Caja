package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import android.widget.Button;

import com.example.proyecto_flujo_caja.Models.Compras;

public class compras extends AppCompatActivity {
    private Compras compra;
    EditText contado, treinta, venta;

    private Double pcontado, ptreinta, pventas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);
        contado = findViewById(R.id.cont);
        treinta = findViewById(R.id.tren);
        venta = findViewById(R.id.vent);
        Button register = findViewById(R.id.register);
        Button cancel = findViewById(R.id.cancel);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String cont = contado.getText().toString();
                final String thirty = treinta.getText().toString();
                final String ventaa = venta.getText().toString();

                if(TextUtils.isEmpty(cont)){ contado.setError("Campo Obligatorio");return; }
                if(TextUtils.isEmpty(thirty)){ treinta.setError("Campo Obligatorio");return; }
                if(TextUtils.isEmpty(ventaa)){ venta.setError("Campo Obligatorio");return; }

                pcontado =Double.parseDouble(contado.getText().toString());
                ptreinta =Double.parseDouble(treinta.getText().toString());
                pventas =Double.parseDouble(venta.getText().toString());

                //compra = new Compras (pcontado,ptreinta,pventas);


            }
        });

      //  cancel.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View v) {
       //         startActivity(new Intent(getApplicationContext(),MainActivity.class));
        //    }
     //   });

    }
    public void anteriorMain(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

}