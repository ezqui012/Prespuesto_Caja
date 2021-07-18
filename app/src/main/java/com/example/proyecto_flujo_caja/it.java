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

import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.It;
import com.example.proyecto_flujo_caja.Models.Ventas;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.content.ContentValues.TAG;

public class it extends AppCompatActivity {
    It it;
    Button cancel, calcu, sig;
    String mes1,mes2,mes3,ct1,ct2,ct3;
    TextView m1,m2,m3, cont1,cont2,cont3, totv1,totv2,totv3,it1,it2,it3, fis1,fis2,fis3;
    EditText intc1, intc2, intc3, act1,act2,act3, alq1,alq2,alq3,ot1,ot2,ot3,iue1,iue2,iue3;

    Ventas infoV;
    Company company;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);

        company = (Company) getIntent().getSerializableExtra("information");
        infoV = (Ventas) getIntent().getSerializableExtra("infoVenta");

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
        intc1=findViewById(R.id.intc_it);
        intc2=findViewById(R.id.intc_it2);
        intc3=findViewById(R.id.intc_it3);
        act1=findViewById(R.id.act_it);
        act2=findViewById(R.id.act_it2);
        act3=findViewById(R.id.act_it3);
        alq1=findViewById(R.id.alq_it);
        alq2=findViewById(R.id.alq_it2);
        alq3=findViewById(R.id.alq_it3);
        ot1=findViewById(R.id.ot_it);
        ot2=findViewById(R.id.ot_it2);
        ot3=findViewById(R.id.ot_it3);
        iue1=findViewById(R.id.iue_it);
        iue2=findViewById(R.id.iue_it2);
        iue3=findViewById(R.id.iue_it3);
        fis1=findViewById(R.id.fisit1);
        fis2=findViewById(R.id.fisit2);
        fis3=findViewById(R.id.fisit3);

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
        DocumentReference documentReference1= FirebaseFirestore.getInstance().collection("It").document("a");
        documentReference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String i1= documentSnapshot.getString("int1");
                intc1.setText(i1);
                String i2= documentSnapshot.getString("int2");
                intc2.setText(i2);
                String i3= documentSnapshot.getString("int3");
                intc3.setText(i3);
                String a1= documentSnapshot.getString("act1");
                act1.setText(a1);
                String a2= documentSnapshot.getString("act2");
                act2.setText(a2);
                String a3= documentSnapshot.getString("act3");
                act3.setText(a3);
                String al1= documentSnapshot.getString("alq1");
                alq1.setText(al1);
                String al2= documentSnapshot.getString("alq2");
                alq2.setText(al2);
                String al3= documentSnapshot.getString("alq3");
                alq3.setText(al3);
                String o1= documentSnapshot.getString("ot1");
                ot1.setText(o1);
                String o2= documentSnapshot.getString("ot2");
                ot2.setText(o2);
                String o3= documentSnapshot.getString("ot3");
                ot3.setText(o3);
                String u1= documentSnapshot.getString("iue1");
                iue1.setText(u1);
                String u2= documentSnapshot.getString("iue2");
                iue2.setText(u2);
                String u3= documentSnapshot.getString("iue3");
                iue3.setText(u3);

            }
        });


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
        Double con1 =Double.parseDouble(cont1.getText().toString());
        Double con2 =Double.parseDouble(cont2.getText().toString());
        Double con3 =Double.parseDouble(cont3.getText().toString());
        Double intco1 =Double.parseDouble(intc1.getText().toString());
        Double intco2 =Double.parseDouble(intc2.getText().toString());
        Double intco3 =Double.parseDouble(intc3.getText().toString());
        Double acti1 =Double.parseDouble(act1.getText().toString());
        Double acti2 =Double.parseDouble(act2.getText().toString());
        Double acti3 =Double.parseDouble(act3.getText().toString());
        Double alqu1 =Double.parseDouble(alq1.getText().toString());
        Double alqu2 =Double.parseDouble(alq2.getText().toString());
        Double alqu3 =Double.parseDouble(alq3.getText().toString());
        Double otr1 =Double.parseDouble(ot1.getText().toString());
        Double otr2 =Double.parseDouble(ot2.getText().toString());
        Double otr3 =Double.parseDouble(ot3.getText().toString());

        Double calc1= con1+intco1+acti1+alqu1+otr1;
        Double calc2= con2+intco2+acti2+alqu2+otr2;
        Double calc3= con3+intco3+acti3+alqu3+otr3;

        totv1.setText(calc1.toString());
        totv2.setText(calc2.toString());
        totv3.setText(calc3.toString());

        //it del periodo
        Double tot1 =Double.parseDouble(totv1.getText().toString());
        Double tot2 =Double.parseDouble(totv2.getText().toString());
        Double tot3 =Double.parseDouble(totv3.getText().toString());

        Double itp1= tot1*0.03;
        Double itp2= tot2*0.03;
        Double itp3= tot3*0.03;

        it1.setText(itp1.toString());
        it2.setText(itp2.toString());
        it3.setText(itp3.toString());

        //fisco
        Double iuee1 =Double.parseDouble(iue1.getText().toString());
        Double iuee2 =Double.parseDouble(iue2.getText().toString());
        Double iuee3 =Double.parseDouble(iue3.getText().toString());

        Double sum1= itp1-iuee1;
        Double sum2= itp2-iuee2;
        Double sum3= itp3-iuee3;

        fis1.setText(sum1.toString());
        fis2.setText(sum2.toString());
        fis3.setText(sum3.toString());

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it = new It(intco1.toString(),intco2.toString(),intco3.toString(),acti1.toString(),acti2.toString(),acti3.toString(),alqu1.toString(),alqu2.toString(),alqu3.toString(),otr1.toString(),otr2.toString(),otr3.toString(),sum1.toString(),sum2.toString(),sum3.toString(),iuee1.toString(),iuee2.toString(),iuee3.toString());
                db.collection("It").document("a")
                        .set(it)
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
                //startActivity(new Intent(getApplicationContext(), iue.class));
                Intent intent = new Intent(getApplicationContext(), iue.class);
                intent.putExtra("infoVenta", infoV);
                intent.putExtra("information", company);
                startActivity(intent);
            }
        });


    }
}