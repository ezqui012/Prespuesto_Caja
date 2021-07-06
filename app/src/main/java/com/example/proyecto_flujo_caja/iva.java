package com.example.proyecto_flujo_caja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_flujo_caja.Models.Iva;
import com.example.proyecto_flujo_caja.Models.Ventas;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.content.ContentValues.TAG;

public class iva extends AppCompatActivity {
    Iva iva;
    Button sig, cancel, calcu;
    TextView m1,m2,m3,cont1,cont2,cont3,totv1,totv2,totv3,debi1,debi2,debi3, totc1,totc2,totc3, credi1,credi2,credi3,fis1,fis2,fis3;
    EditText merch1,merch2,merch3,op1,op2,op3,inte1,inte2,inte3,vent1,vent2,vent3,alq1,alq2,alq3,otro1,otro2,otro3, in1,in2,in3, com1,com2,com3,sub1,sub2,sub3,ot1,ot2,ot3;
    String mes1,mes2,mes3,ct1,ct2,ct3;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iva);

        cancel=findViewById(R.id.cancelar_iva);
        sig= findViewById(R.id.siguiente_iva);
        calcu= findViewById(R.id.calcular_iva);
        m1= findViewById(R.id.m1);
        m2= findViewById(R.id.m2);
        m3= findViewById(R.id.m3);
        cont1= findViewById(R.id.dbcont1);
        cont2= findViewById(R.id.dbcont2);
        cont3= findViewById(R.id.dbcont3);
        totv1= findViewById(R.id.totv1);
        totv2= findViewById(R.id.totv2);
        totv3= findViewById(R.id.totv3);
        debi1=findViewById(R.id.debi1);
        debi2= findViewById(R.id.debi2);
        debi3= findViewById(R.id.debi3);
        merch1= findViewById(R.id.merch1);
        merch2= findViewById(R.id.merch2);
        merch3= findViewById(R.id.merch3);
        op1=findViewById(R.id.op1);
        op2= findViewById(R.id.op2);
        op3= findViewById(R.id.op3);
        totc1=findViewById(R.id.totc1);
        totc2=findViewById(R.id.totc2);
        totc3=findViewById(R.id.totc3);
        credi1=findViewById(R.id.credi1);
        credi2=findViewById(R.id.credi2);
        credi3=findViewById(R.id.credi3);
        fis1=findViewById(R.id.fis1);
        fis2=findViewById(R.id.fis2);
        fis3=findViewById(R.id.fis3);
        inte1=findViewById(R.id.intcom_v);
        inte2=findViewById(R.id.intcom_v2);
        inte3=findViewById(R.id.intcom_v3);
        vent1=findViewById(R.id.act_v);
        vent2=findViewById(R.id.act_v2);
        vent3=findViewById(R.id.act_v3);
        alq1=findViewById(R.id.alq_v);
        alq2=findViewById(R.id.alq_v2);
        alq3=findViewById(R.id.alq_v3);
        otro1=findViewById(R.id.otro_v);
        otro2=findViewById(R.id.otro_v2);
        otro3=findViewById(R.id.otro_v3);
        in1=findViewById(R.id.intedeb_v);
        in2=findViewById(R.id.intedeb_v2);
        in3=findViewById(R.id.intedeb_v3);
        com1=findViewById(R.id.compra_v);
        com2=findViewById(R.id.compra_v2);
        com3=findViewById(R.id.compra_v3);
        sub1=findViewById(R.id.sub_v);
        sub2=findViewById(R.id.sub_v2);
        sub3=findViewById(R.id.sub_v3);
        ot1=findViewById(R.id.ot_v);
        ot2=findViewById(R.id.ot_v2);
        ot3=findViewById(R.id.ot_v3);

        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("venta").document("a");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String monthh1= documentSnapshot.getString("mes1");
                m1.setText(monthh1);
                String monthh2= documentSnapshot.getString("mes2");
                m2.setText(monthh2);
                String monthh3= documentSnapshot.getString("mes3");
                m3.setText(monthh3);
                String vconta1= documentSnapshot.getString("cont1");
                cont1.setText(vconta1);
                String vconta2= documentSnapshot.getString("cont2");
                cont2.setText(vconta2);
                String vconta3= documentSnapshot.getString("cont3");
                cont3.setText(vconta3);


            }
        });
        DocumentReference documentReference1= FirebaseFirestore.getInstance().collection("Iva").document("a");
        documentReference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String i1= documentSnapshot.getString("intc1");
                inte1.setText(i1);
                String i2= documentSnapshot.getString("intc2");
                inte2.setText(i2);
                String i3= documentSnapshot.getString("intc3");
                inte3.setText(i3);
                String a1= documentSnapshot.getString("act1");
                vent1.setText(a1);
                String a2= documentSnapshot.getString("act2");
                vent2.setText(a2);
                String a3= documentSnapshot.getString("act3");
                vent3.setText(a3);
                String al1= documentSnapshot.getString("alq1");
                alq1.setText(al1);
                String al2= documentSnapshot.getString("alq2");
                alq2.setText(al2);
                String al3= documentSnapshot.getString("alq3");
                alq3.setText(al3);
                String o1= documentSnapshot.getString("ot1");
                otro1.setText(o1);
                String o2= documentSnapshot.getString("ot2");
                otro2.setText(o2);
                String o3= documentSnapshot.getString("ot3");
                otro3.setText(o3);
                String me1= documentSnapshot.getString("compras1");
                merch1.setText(me1);
                String me2= documentSnapshot.getString("compras2");
                merch2.setText(me2);
                String me3= documentSnapshot.getString("compras3");
                merch3.setText(me3);
                String inn1= documentSnapshot.getString("intco1");
                in1.setText(inn1);
                String inn2= documentSnapshot.getString("intco2");
                in2.setText(inn2);
                String inn3= documentSnapshot.getString("intco3");
                in3.setText(inn3);
                String c1= documentSnapshot.getString("com1");
                com1.setText(c1);
                String c2= documentSnapshot.getString("com2");
                com2.setText(c2);
                String c3= documentSnapshot.getString("com3");
                com3.setText(c3);
                String s1= documentSnapshot.getString("subs1");
                sub1.setText(s1);
                String s2= documentSnapshot.getString("subs2");
                sub2.setText(s2);
                String s3= documentSnapshot.getString("subs3");
                sub3.setText(s3);
                String g1= documentSnapshot.getString("gastosop1");
                op1.setText(g1);
                String g2= documentSnapshot.getString("gastosop2");
                op2.setText(g2);
                String g3= documentSnapshot.getString("gastosop3");
                op3.setText(g3);
                String otr1= documentSnapshot.getString("otr1");
                ot1.setText(otr1);
                String otr2= documentSnapshot.getString("otr2");
                ot2.setText(otr2);
                String otr3= documentSnapshot.getString("otr3");
                ot3.setText(otr3);

            }
        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),menu_impuestos.class));
            }
        });

    }
    public void CalcularIva(View view){
        calcu.setVisibility(View.INVISIBLE);
        sig.setVisibility(View.VISIBLE);

        //calcula ventas
        Double con1 = Double.parseDouble(cont1.getText().toString());
        Double con2 = Double.parseDouble(cont2.getText().toString());
        Double con3 = Double.parseDouble(cont3.getText().toString());
        Double inter1 = Double.parseDouble(inte1.getText().toString());
        Double inter2 = Double.parseDouble(inte2.getText().toString());
        Double inter3 = Double.parseDouble(inte3.getText().toString());
        Double activo1 = Double.parseDouble(vent1.getText().toString());
        Double activo2 = Double.parseDouble(vent2.getText().toString());
        Double activo3 = Double.parseDouble(vent3.getText().toString());
        Double alqui1 = Double.parseDouble(alq1.getText().toString());
        Double alqui2 = Double.parseDouble(alq2.getText().toString());
        Double alqui3 = Double.parseDouble(alq3.getText().toString());
        Double otros1 = Double.parseDouble(otro1.getText().toString());
        Double otros2 = Double.parseDouble(otro2.getText().toString());
        Double otros3 = Double.parseDouble(otro3.getText().toString());

        Double totalvmes1 = con1+inter1+activo1+alqui1+otros1;
        Double totalvmes2 = con2+inter2+activo2+alqui2+otros2;
        Double totalvmes3 = con3+inter3+activo3+alqui3+otros3;

        totv1.setText(totalvmes1.toString());
        totv2.setText(totalvmes2.toString());
        totv3.setText(totalvmes3.toString());
        //debito del periodo

        Double total1 =Double.parseDouble(totv1.getText().toString());
        Double total2 =Double.parseDouble(totv2.getText().toString());
        Double total3 =Double.parseDouble(totv3.getText().toString());
        Double debito1= total1*0.13;
        Double debito2= total2*0.13;
        Double debito3= total3*0.13;
        debi1.setText(debito1.toString());
        debi2.setText(debito2.toString());
        debi3.setText(debito3.toString());

        //total compras
        Double merca1=Double.parseDouble(merch1.getText().toString());
        Double merca2=Double.parseDouble(merch2.getText().toString());
        Double merca3=Double.parseDouble(merch3.getText().toString());
        Double gasop1=Double.parseDouble(op1.getText().toString());
        Double gasop2=Double.parseDouble(op2.getText().toString());
        Double gasop3=Double.parseDouble(op3.getText().toString());
        Double interc1=Double.parseDouble(in1.getText().toString());
        Double interc2=Double.parseDouble(in2.getText().toString());
        Double interc3=Double.parseDouble(in3.getText().toString());
        Double compra1=Double.parseDouble(com1.getText().toString());
        Double compra2=Double.parseDouble(com2.getText().toString());
        Double compra3 =Double.parseDouble(com3.getText().toString());
        Double subs1=Double.parseDouble(sub1.getText().toString());
        Double subs2=Double.parseDouble(sub2.getText().toString());
        Double subs3=Double.parseDouble(sub3.getText().toString());
        Double otr1=Double.parseDouble(ot1.getText().toString());
        Double otr2=Double.parseDouble(ot2.getText().toString());
        Double otr3=Double.parseDouble(ot3.getText().toString());

        Double totalc1=merca1+gasop1+interc1+compra1+subs1+otr1;
        Double totalc2=merca2+gasop2+interc2+compra2+subs2+otr2;
        Double totalc3=merca3+gasop3+interc3+compra3+subs3+otr3;
        totc1.setText(totalc1.toString());
        totc2.setText(totalc2.toString());
        totc3.setText(totalc3.toString());

        //credito fiscal
        Double credito1 = totalc1*0.13;
        Double credito2 = totalc2*0.13;
        Double credito3 = totalc3*0.13;
        credi1.setText(credito1.toString());
        credi2.setText(credito2.toString());
        credi3.setText(credito3.toString());

        //favor fisco
        Double fisco1= debito1-credito1;
        Double fisco2= debito2-credito2;
        Double fisco3= debito3-credito3;

        fis1.setText(fisco1.toString());
        fis2.setText(fisco2.toString());
        fis3.setText(fisco3.toString());

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iva = new Iva(merca1.toString(),merca2.toString(),merca3.toString(),gasop1.toString(),gasop2.toString(),gasop3.toString(),fisco1.toString(),fisco2.toString(),fisco3.toString(),inter1.toString(),inter2.toString(),inter3.toString(),activo1.toString(),activo2.toString(),activo3.toString(),alqui1.toString(),alqui2.toString(),alqui3.toString(),otros1.toString(),otros2.toString(),otros3.toString(),interc1.toString(),interc2.toString(),interc3.toString(),compra1.toString(),compra2.toString(),compra3.toString(),subs1.toString(),subs2.toString(),subs3.toString(),otr1.toString(),otr2.toString(),otr3.toString());


                Intent intent = new Intent(iva.this, it.class);
                intent.putExtra("mes1", m1.getText());
                intent.putExtra("mes2", m2.getText());
                intent.putExtra("mes3", m3.getText());
                intent.putExtra("contado1", cont1.getText().toString());
                intent.putExtra("contado2", cont2.getText().toString());
                intent.putExtra("contado3", cont3.getText().toString());


                db.collection("Iva").document("a")
                        .set(iva)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });



                /*db.collection("Iva").add(iva);
                Toast.makeText(iva.this, "Guardado correctamente",Toast.LENGTH_SHORT).show();*/

                startActivity(intent);

            }
        });
    }

}