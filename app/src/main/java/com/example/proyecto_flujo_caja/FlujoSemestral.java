package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FlujoSemestral extends AppCompatActivity {
    TextView ingreop, gasop, totop, ingrecap, gascap, totcap, fuentes,usos,totfin ,totincre, totefeini, totefefin;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flujo_semestral);
        ingreop= findViewById(R.id.ingreop);
        gasop=findViewById(R.id.gasop);
        totop=findViewById(R.id.totop);
        ingrecap=findViewById(R.id.ingrecap);
        gascap=findViewById(R.id.gascap);
        totcap=findViewById(R.id.totcap);
        fuentes=findViewById(R.id.fuentes);
        usos=findViewById(R.id.usos);
        totfin=findViewById(R.id.totfin);
        totincre=findViewById(R.id.totincre);
        totefeini=findViewById(R.id.totefeini);
        totefefin=findViewById(R.id.totefefin);

        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("PresupuestoCaja").document("a");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String tot1= documentSnapshot.getString("tot1");
                Double dat1= Double.parseDouble(tot1);
                Double inop= dat1*2;
                ingreop.setText(inop.toString());

                String tot2= documentSnapshot.getString("tot2");
                Double dat2= Double.parseDouble(tot2);
                Double gsop= dat2*2;
                gasop.setText(gsop.toString());

                String tot4= documentSnapshot.getString("tot4");
                Double dat4= Double.parseDouble(tot4);
                Double fue= dat4*2;
                fuentes.setText(fue.toString());

                String tot5= documentSnapshot.getString("tot5");
                Double dat5= Double.parseDouble(tot5);
                Double uso= dat5*2;
                usos.setText(uso.toString());


                Double toefe= 16000.0;
                totefeini.setText(toefe.toString());

                //calculos de totales operativos
                Double totao = inop-gsop;
                totop.setText(totao.toString());

                //tot inversion
                ingrecap.setText("0.0");
                gascap.setText("0.0");
                totcap.setText("0.0");

                //tot financiamiento
                Double totfina = fue-uso;
                totfin.setText(totfina.toString());

                //incremento
                Double toti= totfina+totao;
                totincre.setText(toti.toString());

                //saldo efectivo final
                Double totsal= toti + toefe;
                totefefin.setText(totsal.toString());


            }
        });


    }
}