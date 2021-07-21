package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.*;
import com.google.android.gms.tasks.*;
import com.google.firebase.firestore.*;

public class FlujoAnual extends AppCompatActivity {
    TextView ingreop, gasop, totop, ingrecap, gascap, totcap, fuentes,usos,totfin,totini,totincre,tt;
    String ingop,gasopp,incr,fue,uso,eip;
    FlujoAnuall fAnual;
    FirebaseFirestore dba = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flujo_anual);
        ingreop= findViewById(R.id.ingreop);
        gasop=findViewById(R.id.gasop);
        totop=findViewById(R.id.totop);

        ingrecap=findViewById(R.id.ingrecap);
        gascap=findViewById(R.id.gascap);
        totcap=findViewById(R.id.totcap);

        fuentes=findViewById(R.id.fuentes);
        usos=findViewById(R.id.usos);
        totfin=findViewById(R.id.totfin);
        totini=findViewById(R.id.totefeini);
        totincre=findViewById(R.id.totincre);
        tt=findViewById(R.id.totefefin);

        DocumentReference documentReference7= FirebaseFirestore.getInstance().collection("PresupuestoCaja").document("a");
        documentReference7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override

            public void onSuccess(DocumentSnapshot documentSnapshot) {
                ingop= documentSnapshot.getString("tot1");
                gasopp= documentSnapshot.getString("tot2");
                incr= documentSnapshot.getString("tot3");
                fue= documentSnapshot.getString("tot4");
                uso= documentSnapshot.getString("tot5");


                Double ingopp =Double.parseDouble(ingop);
                Double gassopp =Double.parseDouble(gasopp);
                Double incrr =Double.parseDouble(incr);
                Double fuee =Double.parseDouble(fue);
                Double usoo =Double.parseDouble(uso);


                Double ip=ingopp*4;
                Double gp=gassopp*4;
                Double ir=incrr*4;
                Double fu=fuee*4;
                Double us=usoo*4;


                Double ep=16000.0;
                Double totopp=ip-gp;
                Double tto=totopp+ep;


                totop.setText(totopp.toString());
                ingreop.setText(ip.toString());
                gasop.setText(gp.toString());
                ingrecap.setText(ir.toString());
                fuentes.setText(fu.toString());
                usos.setText(us.toString());


                totini.setText(ep.toString());
                totincre.setText(totopp.toString());
                tt.setText(tto.toString());

                fAnual=new FlujoAnuall(ip.toString(),gp.toString(),totopp.toString(),"0.0","0.0","0.0",fue,uso,"0.0",totopp.toString(),"16000.0",tto.toString());

                dba.collection("FlujoAnual").document("a")
                        .set(fAnual);



            }
        });




    }
    public void volver(View view){
        Intent menu = new Intent(this, menu_FlujoDeCaja.class);

        startActivity(menu);
    }
}