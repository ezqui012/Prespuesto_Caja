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

    TextView Totts,Tottee,Totitt,Totses,Totiva,Tottre,Totcom,Totcgo,Totvcon,month1,month2,month3,vcont1,vcont2,vcont3,recses1, recses2, recses3,rectre1,rectre2, rectre3,tee1,tee2,tee3,sef1,sef2,sef3,compp1,compp2,compp3,ss1,ss2,ss3,ap1,ap2,ap3,rss1,rss2,rss3,rap1,rap2,rap3,cgo1,cgo2,cgo3,ampr1,ampr2,ampr3,ip1,ip2,ip3,iv1,iv2,iv3,itt1,itt2,itt3,iu1,iu2,iu3,oi1,oi2,oi3,ts1,ts2,ts3,fnp1,fnp2,fnp3,sfma1,sfma2,sfma3,sfep1,sfep2,sfep3,fcp1,fcp2,fcp3,afin1,afin2,afin3,ifin1,ifin2,ifin3,sf1,sf2,sf3;

String iue,it1,it2,it3,iva1,iva2,iva3,sess1,sess2,sess3,tree1,tree2,tree3,cgoo1,cgoo2,cgoo3,vcontt1,vcontt2,vcontt3, comp1,comp2,comp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presupuesto_caja);

        Totts=findViewById(R.id.Totts);
        Tottee=findViewById(R.id.Tottee);
        Totses=findViewById(R.id.Totses);
        Totitt=findViewById(R.id.Totitt);
        Totiva=findViewById(R.id.Totiva);
        Tottre=findViewById(R.id.Tottre);
        Totcom=findViewById(R.id.Totcom);
        Totcgo=findViewById(R.id.Totcgo);
        Totvcon=findViewById(R.id.Totvcon);
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
        iu3=findViewById(R.id.iue3);
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

        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("venta").document("a");
               documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                   @Override
                   public void onSuccess(DocumentSnapshot documentSnapshot) {
                       String monthh1= documentSnapshot.getString("mes1");
                       month1.setText(monthh1);
                       String monthh2= documentSnapshot.getString("mes2");
                       month2.setText(monthh2);
                       String monthh3= documentSnapshot.getString("mes3");
                       month3.setText(monthh3);

                       vcontt1= documentSnapshot.getString("cont1");
                       vcont1.setText(vcontt1);
                       vcontt2= documentSnapshot.getString("cont2");
                       vcont2.setText(vcontt2);
                       vcontt3= documentSnapshot.getString("cont3");
                       vcont3.setText(vcontt3);

                       sess1= documentSnapshot.getString("sesenta1");
                       recses1.setText(sess1);
                       sess2= documentSnapshot.getString("sesenta2");
                       recses2.setText(sess2);
                       sess3= documentSnapshot.getString("sesenta3");
                       recses3.setText(sess3);

                       tree1= documentSnapshot.getString("treinta1");
                       rectre1.setText(tree1);
                       tree2= documentSnapshot.getString("treinta2");
                       rectre2.setText(tree2);
                       tree3= documentSnapshot.getString("trinta3");
                       rectre3.setText(tree3);

                   }
               });


               DocumentReference documentReference1=FirebaseFirestore.getInstance().collection("Iva").document("a");
        documentReference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                cgoo1= documentSnapshot.getString("gastosop1");
                cgo1.setText(cgoo1);
                cgoo2= documentSnapshot.getString("gastosop2");
                cgo2.setText(cgoo2);
                cgoo3= documentSnapshot.getString("gastosop3");
                cgo3.setText(cgoo3);

                comp1= documentSnapshot.getString("compras1");
                compp1.setText(comp1);
                comp2= documentSnapshot.getString("compras2");
                compp2.setText(comp2);
                comp3= documentSnapshot.getString("compras3");
                compp3.setText(comp3);

                iva1= documentSnapshot.getString("iva1");
                iva2= documentSnapshot.getString("iva2");
                iva3= documentSnapshot.getString("iva3");
                iv2.setText(iva1);
                iv3.setText(iva2);

            }
        });
        DocumentReference documentReference2= FirebaseFirestore.getInstance().collection("It").document("a");
        documentReference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                it1= documentSnapshot.getString("it1");
                it2= documentSnapshot.getString("it2");
                it3= documentSnapshot.getString("it3");
                itt2.setText(it1);
                itt3.setText(it2);


            }
        });
        DocumentReference documentReference3= FirebaseFirestore.getInstance().collection("Iue").document("a");
        documentReference3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                iue= documentSnapshot.getString("iue");
                iu1.setText(iue);

            }
        });
           }
           public void totalpc(View v){

               Double totalpc1 =Double.parseDouble(vcont1.getText().toString());
               Double totalpc2 =Double.parseDouble(vcont2.getText().toString());
               Double totalpc3 =Double.parseDouble(vcont3.getText().toString());
               Double totPC= totalpc1+totalpc2+totalpc3;
               Totvcon.setText(totPC.toString());
               Double cgopc1 =Double.parseDouble(cgo1.getText().toString());
               Double cgopc2 =Double.parseDouble(cgo2.getText().toString());
               Double cgopc3 =Double.parseDouble(cgo3.getText().toString());
               Double cgoPC= cgopc1+cgopc2+cgopc3;
               Totcgo.setText(cgoPC.toString());

               Double compc1 =Double.parseDouble(compp1.getText().toString());
               Double compc2 =Double.parseDouble(compp2.getText().toString());
               Double compc3 =Double.parseDouble(compp3.getText().toString());
               Double comPC= compc1+compc2+compc3;
               Totcom.setText(comPC.toString());


               Double ivpc1 =Double.parseDouble(iv1.getText().toString());
               Double ivpc2 =Double.parseDouble(iv2.getText().toString());
               Double ivpc3 =Double.parseDouble(iv3.getText().toString());
               Double ivPC= ivpc1+ivpc2+ivpc3;
               Totiva.setText(ivPC.toString());

               Double trepc1 =Double.parseDouble(rectre1.getText().toString());
               Double trepc2 =Double.parseDouble(rectre2.getText().toString());
               Double trepc3 =Double.parseDouble(rectre3.getText().toString());
               Double trPC= trepc1+trepc2+trepc3;
               Tottre.setText(trPC.toString());

               Double sepc1 =Double.parseDouble(recses1.getText().toString());
               Double sepc2 =Double.parseDouble(recses2.getText().toString());
               Double sepc3 =Double.parseDouble(recses3.getText().toString());
               Double sePC= sepc1+sepc2+sepc3;
               Totses.setText(sePC.toString());

               Double tee11=totalpc1+trepc1+sepc1;
               Double tee22=totalpc2+trepc2+sepc2;
               Double tee33=totalpc3+trepc3+sepc3;
               tee1.setText(tee11.toString());
               tee2.setText(tee22.toString());
               tee3.setText(tee33.toString());

               Double totaltee=totPC+trPC+sePC;
               Tottee.setText(totaltee.toString());

               Double itpc1 =Double.parseDouble(itt1.getText().toString());
               Double itpc2 =Double.parseDouble(itt2.getText().toString());
               Double itpc3 =Double.parseDouble(itt3.getText().toString());
               Double itPC= itpc1+itpc2+itpc3;
               Totitt.setText(itPC.toString());

               Double iuepc1=Double.parseDouble(iu1.getText().toString());
               Double iuepc2=Double.parseDouble(iu2.getText().toString());
               Double iuepc3=Double.parseDouble(iu3.getText().toString());


               Double TotsalPC1=compc1+cgopc1+ivpc1+itpc1+iuepc1;
               ts1.setText(TotsalPC1.toString());
               Double TotsalPC2=compc2+cgopc2+ivpc2+itpc2+iuepc2;
               ts2.setText(TotsalPC2.toString());
               Double TotsalPC3=compc3+cgopc3+ivpc3+itpc3+iuepc3;
               ts3.setText(TotsalPC3.toString());

               Double Totsal=TotsalPC1+TotsalPC2+TotsalPC3;
               Totts.setText(Totsal.toString());


               Double fnpsin1=tee11-TotsalPC1;
               Double fnpsin2=tee22-TotsalPC2;
               Double fnpsin3=tee33-TotsalPC3;
               fnp1.setText(fnpsin1.toString());
               fnp2.setText(fnpsin2.toString());
               fnp3.setText(fnpsin3.toString());




               Double sfmapc1 =Double.parseDouble(sfma1.getText().toString());
               Double fnppc1 =Double.parseDouble(fnp1.getText().toString());
               Double sfepPC1= sfmapc1+fnppc1;
               sfep1.setText(sfepPC1.toString());

               Double sfmapc2 =Double.parseDouble(sfma2.getText().toString());
               Double fnppc2 =Double.parseDouble(fnp2.getText().toString());
               Double sfepPC2= sfmapc2+fnppc2;
               sfep2.setText(sfepPC2.toString());

               Double sfmapc3 =Double.parseDouble(sfma3.getText().toString());
               Double fnppc3 =Double.parseDouble(fnp3.getText().toString());
               Double sfepPC3= sfmapc3+fnppc3;
               sfep3.setText(sfepPC3.toString());

               Double fcpc1 =Double.parseDouble(fcp1.getText().toString());
               Double afpc1 =Double.parseDouble(afin1.getText().toString());
               Double ifpc1 =Double.parseDouble(ifin1.getText().toString());
               Double sfepc1 =Double.parseDouble(sfep1.getText().toString());
               Double sfPC1= fcpc1+afpc1+ifpc1+sfepc1;
               sf1.setText(sfPC1.toString());

               Double fcpc2 =Double.parseDouble(fcp2.getText().toString());
               Double afpc2 =Double.parseDouble(afin2.getText().toString());
               Double ifpc2 =Double.parseDouble(ifin2.getText().toString());
               Double sfepc2 =Double.parseDouble(sfep2.getText().toString());
               Double sfPC2= fcpc2+afpc2+ifpc2+sfepc2;
               sf2.setText(sfPC2.toString());

               Double fcpc3 =Double.parseDouble(fcp3.getText().toString());
               Double afpc3 =Double.parseDouble(afin3.getText().toString());
               Double ifpc3 =Double.parseDouble(ifin3.getText().toString());
               Double sfepc3 =Double.parseDouble(sfep3.getText().toString());
               Double sfPC3= fcpc3+afpc3+ifpc3+sfepc3;
               sf3.setText(sfPC3.toString());


               sfma2.setText(sfPC1.toString());
               sfma3.setText(sfepc2.toString());





    }
       }





