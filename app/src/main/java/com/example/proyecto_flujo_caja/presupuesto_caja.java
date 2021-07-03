package com.example.proyecto_flujo_caja;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import android.widget.Button;




import android.os.*;

import androidx.appcompat.app.*;

import com.google.android.gms.tasks.*;
import com.google.firebase.database.*;
import com.google.firebase.database.annotations.*;
import com.google.firebase.firestore.*;

public class presupuesto_caja extends AppCompatActivity {

    TextView month1,month2,month3,vcont1,vcont2,vcont3,recses1, recses2, recses3,rectre1,rectre2, rectre3,tee1,tee2,tee3,sef1,sef2,sef3,compp1,compp2,compp3,ss1,ss2,ss3,ap1,ap2,ap3,rss1,rss2,rss3,rap1,rap2,rap3,cgo1,cgo2,cgo3,ampr1,ampr2,ampr3,ip1,ip2,ip3,iv1,iv2,iv3,itt1,itt2,itt3,iu1,iu2,iu3,oi1,oi2,oi3,ts1,ts2,ts3,fnp1,fnp2,fnp3,sfma1,sfma2,sfma3,sfep1,sfep2,sfep3,fcp1,fcp2,fcp3,afin1,afin2,afin3,ifin1,ifin2,ifin3,sf1,sf2,sf3;
    //String contt1,contt2,contt3,gasop1,gasop2,gasop3,reses1,reses2,reses3,retre1,retre2,retre3,mess1,mess2,mess3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presupuesto_caja);


        vcont1= findViewById(R.id.vcon1);
        vcont2= findViewById(R.id.vcon2);
        vcont3= findViewById(R.id.vcon3);
        recses1= findViewById(R.id.recses1);
        recses2= findViewById(R.id.recses2);
        recses3= findViewById(R.id.recses3);
        rectre1= findViewById(R.id.rectre1);
        rectre2= findViewById(R.id.rectre2);
        rectre3= findViewById(R.id.rectre3);
        tee1= findViewById(R.id.toten1);
        tee2= findViewById(R.id.toten2);
        tee3= findViewById(R.id.toten3);
        sef1= findViewById(R.id.salef1);
        sef2= findViewById(R.id.salef2);
        sef3= findViewById(R.id.salef3);
        compp1=findViewById(R.id.compp1);
        compp2=findViewById(R.id.compp2);
        compp3=findViewById(R.id.compp3);
        ss1=findViewById(R.id.ss1);
        ss2=findViewById(R.id.ss2);
        ss3=findViewById(R.id.ss3);
        ap1=findViewById(R.id.ap1);
        ap2=findViewById(R.id.ap2);
        ap3=findViewById(R.id.ap3);
        rss1=findViewById(R.id.rss1);
        rss2=findViewById(R.id.rss2);
        rss3=findViewById(R.id.rss3);
        rap1=findViewById(R.id.rap1);
        rap2=findViewById(R.id.rap2);
        rap3=findViewById(R.id.rap3);
        cgo1=findViewById(R.id.cgo1);
        cgo2=findViewById(R.id.cgo2);
        cgo3=findViewById(R.id.cgo3);
        ampr1=findViewById(R.id.ampr1);
        ampr2=findViewById(R.id.ampr2);
        ampr3=findViewById(R.id.ampr3);
        ip1=findViewById(R.id.inpr1);
        ip2=findViewById(R.id.inpr2);
        ip3=findViewById(R.id.inpr3);
        iv1=findViewById(R.id.iv1);
        iv2=findViewById(R.id.iv2);
        iv3=findViewById(R.id.iv3);
        itt1=findViewById(R.id.itt1);
        itt2=findViewById(R.id.itt2);
        itt3=findViewById(R.id.itt3);
        iu1=findViewById(R.id.iue1);
        iu2=findViewById(R.id.iue2);
        iv3=findViewById(R.id.iue3);
        oi1=findViewById(R.id.ot1);
        oi2=findViewById(R.id.ot2);
        oi3=findViewById(R.id.ot3);
        ts1=findViewById(R.id.ts1);
        ts2=findViewById(R.id.ts2);
        ts3=findViewById(R.id.ts3);
        fnp1=findViewById(R.id.fnp1);
        fnp2=findViewById(R.id.fnp2);
        fnp3=findViewById(R.id.fnp3);
        sfma1=findViewById(R.id.sfma1);
        sfma2=findViewById(R.id.sfma2);
        sfma3=findViewById(R.id.sfma3);
        sfep1=findViewById(R.id.sfep1);
        sfep2=findViewById(R.id.sfep2);
        sfep3=findViewById(R.id.sfep3);
        fcp1=findViewById(R.id.fcp1);
        fcp2=findViewById(R.id.fcp2);
        fcp3=findViewById(R.id.fcp3);
        afin1=findViewById(R.id.afin1);
        afin2=findViewById(R.id.afin2);
        afin3=findViewById(R.id.afin3);
        ifin1=findViewById(R.id.ifin1);
        ifin2=findViewById(R.id.ifin2);
        ifin3=findViewById(R.id.ifin3);
        sf1=findViewById(R.id.sf1);
        sf2=findViewById(R.id.sf2);
        sf3=findViewById(R.id.sf3);
        month1=findViewById(R.id.month11);
        month2=findViewById(R.id.month22);
        month3=findViewById(R.id.month33);

        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("ventass").document("a");
               documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                   @Override
                   public void onSuccess(DocumentSnapshot documentSnapshot) {
                       String monthh1= documentSnapshot.getString("Month1");
                       month1.setText(monthh1);
                       String monthh2= documentSnapshot.getString("Month2");
                       month2.setText(monthh2);
                       String monthh3= documentSnapshot.getString("Month3");
                       month3.setText(monthh3);
                       String vcontt1= documentSnapshot.getLong("cont1").toString();
                       vcont1.setText(vcontt1);
                       String vcontt2= documentSnapshot.getLong("cont2").toString();
                       vcont2.setText(vcontt2);
                       String vcontt3= documentSnapshot.getLong("cont3").toString();
                       vcont3.setText(vcontt3);
                   }
               });

               DocumentReference documentReference1=FirebaseFirestore.getInstance().collection("Iva").document("a");
        documentReference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String cgoo1= documentSnapshot.getLong("gasop1").toString();
                cgo1.setText(cgoo1);
                String cgoo2= documentSnapshot.getLong("gasop2").toString();
                cgo2.setText(cgoo2);
                String cgoo3= documentSnapshot.getLong("gasop3").toString();
                cgo3.setText(cgoo3);
            }
        });
           }
       }





