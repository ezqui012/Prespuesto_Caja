package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class it extends AppCompatActivity {
    Button cancel, calcu, sig;
    String mes1,mes2,mes3,ct1,ct2,ct3;
    TextView m1,m2,m3, cont1,cont2,cont3, totv1,totv2,totv3,it1,it2,it3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);

        cancel= findViewById(R.id.cancel_it);
        calcu= findViewById(R.id.calcular_it);
        sig= findViewById(R.id.sigit);
        m1=findViewById(R.id.mesit1);
        m2=findViewById(R.id.mesit2);
        m3=findViewById(R.id.mesit3);
        cont1=findViewById(R.id.contit1);
        cont2=findViewById(R.id.contit2);
        cont3=findViewById(R.id.contit3);
        totv1=findViewById(R.id.totvit1);
        totv2=findViewById(R.id.totvit2);
        totv3=findViewById(R.id.totvit3);
        it1=findViewById(R.id.it1);
        it2=findViewById(R.id.it2);
        it3=findViewById(R.id.it3);


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

    public void calcularIt(View view){
        calcu.setVisibility(View.INVISIBLE);
        sig.setVisibility(View.VISIBLE);

        //total ventas
        totv1.setText(cont1.getText());
        totv2.setText(cont2.getText());
        totv3.setText(cont3.getText());

        //it del periodo
        Double tot1 =Double.parseDouble(totv1.getText().toString());
        Double tot2 =Double.parseDouble(totv1.getText().toString());
        Double tot3 =Double.parseDouble(totv1.getText().toString());

        Double itp1= tot1*0.03;
        Double itp2= tot2*0.03;
        Double itp3= tot3*0.03;

        it1.setText(itp1.toString());
        it2.setText(itp2.toString());
        it3.setText(itp3.toString());



    }
}