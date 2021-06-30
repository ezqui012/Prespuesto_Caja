package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class iue extends AppCompatActivity {
    Button cancel, sig, calular;
    EditText pagodiv,pagoprim,utiant,gastded,ingreno;
    TextView utiimp,iuexpag,utides,divppag,primppag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iue);

        cancel=findViewById(R.id.cancel_iue);
        calular=findViewById(R.id.calcu_iue);
        sig=findViewById(R.id.sig_iue);
        pagodiv=findViewById(R.id.div_iue);
        pagoprim=findViewById(R.id.primas_iue);
        utiant=findViewById(R.id.utili_iue);
        gastded=findViewById(R.id.gast_iue);
        ingreno=findViewById(R.id.ingre_iue);
        utiimp=findViewById(R.id.utiimpo_iue);
        iuexpag=findViewById(R.id.iuexpag);
        utides=findViewById(R.id.utidesp_iue);
        divppag=findViewById(R.id.divxpag_iue);
        primppag=findViewById(R.id.primxpag_iue);



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),menu_impuestos.class));
            }
        });
    }
    public void calcularIue(View view){
        calular.setVisibility(View.INVISIBLE);
        sig.setVisibility(View.VISIBLE);
        //utilidad impositiva
        Double dat1= Double.parseDouble(utiant.getText().toString());
        Double dat2= Double.parseDouble(gastded.getText().toString());
        Double dat3= Double.parseDouble(ingreno.getText().toString());
        Double suma = dat1+dat2+dat3;

        utiimp.setText(suma.toString());

        //iue x pagar
        Double iue= suma * 0.25;
        iuexpag.setText(iue.toString());

        // utilidad despues de impuestos
        Double uti =suma-iue;
        utides.setText(uti.toString());

        //dividendos por pagar
        Double pordivi= Double.parseDouble(pagodiv.getText().toString());
        Double divi = uti*pordivi;
        divppag.setText(divi.toString());

        //primas x pagar
        Double primap= Double.parseDouble(pagoprim.getText().toString());
        Double prim= uti * primap;
        primppag.setText(prim.toString());

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),sueldos.class));
            }
        });

    }
}