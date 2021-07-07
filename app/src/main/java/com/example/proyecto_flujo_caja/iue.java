package com.example.proyecto_flujo_caja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.Iue;
import com.example.proyecto_flujo_caja.Models.Ventas;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.content.ContentValues.TAG;

public class iue extends AppCompatActivity {
    Iue iuee;
    Button cancel, sig, calular;
    EditText pagodiv,pagoprim,utiant,gastded,ingreno;
    TextView utiimp,iuexpag,utides,divppag,primppag;

    Ventas infoV;
    Company company;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iue);

        company = (Company) getIntent().getSerializableExtra("information");
        infoV = (Ventas) getIntent().getSerializableExtra("infoVenta");

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

        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("Iue").document("a");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String div= documentSnapshot.getString("pagdiv");
                pagodiv.setText(div);
                String prim= documentSnapshot.getString("pagprim");
                pagoprim.setText(prim);
                String uti= documentSnapshot.getString("utilant");
                utiant.setText(uti);
                String gasd= documentSnapshot.getString("gasded");
                gastded.setText(gasd);
                String im= documentSnapshot.getString("ingrimpo");
                ingreno.setText(im);



            }
        });

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
                iuee =new Iue(pordivi.toString(),primap.toString(),dat1.toString(),dat2.toString(),dat3.toString(),iue.toString());
                db.collection("Iue").document("a")
                        .set(iuee)
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
                //startActivity(new Intent(getApplicationContext(),comprass.class));
                Intent intent = new Intent(getApplicationContext(), comprass.class);
                intent.putExtra("infoVenta", infoV);
                intent.putExtra("information", company);
                startActivity(intent);
            }
        });

    }
}