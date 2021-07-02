package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_flujo_caja.Models.Iva;
import com.example.proyecto_flujo_caja.Models.Ventas;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class iva extends AppCompatActivity {
    Iva iva;
    Button sig, cancel, calcu;
    TextView m1,m2,m3,cont1,cont2,cont3,totv1,totv2,totv3,debi1,debi2,debi3, totc1,totc2,totc3, credi1,credi2,credi3,fis1,fis2,fis3;
    EditText merch1,merch2,merch3,op1,op2,op3;
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
    public void CalcularIva(View view){
        calcu.setVisibility(View.INVISIBLE);
        sig.setVisibility(View.VISIBLE);

        //calcula ventas
        totv1.setText(cont1.getText());
        totv2.setText(cont2.getText());
        totv3.setText(cont3.getText());
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
        Double totalc1=merca1+gasop1;
        Double totalc2=merca2+gasop2;
        Double totalc3=merca3+gasop3;
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
                iva = new Iva(merca1,merca2,merca3,gasop1,gasop2,gasop3,fisco1,fisco2,fisco3);


                Intent intent = new Intent(iva.this, it.class);
                intent.putExtra("mes1", m1.getText());
                intent.putExtra("mes2", m2.getText());
                intent.putExtra("mes3", m3.getText());
                intent.putExtra("contado1", cont1.getText().toString());
                intent.putExtra("contado2", cont2.getText().toString());
                intent.putExtra("contado3", cont3.getText().toString());

                Intent intent1 = new Intent(iva.this, presupuesto_caja.class);

                intent1.putExtra("oper1", gasop1.toString());
                intent1.putExtra("oper2", gasop2.toString());
                intent1.putExtra("oper3", gasop3.toString());



                /*db.collection("Iva").add(iva);
                Toast.makeText(iva.this, "Guardado correctamente",Toast.LENGTH_SHORT).show();*/
                startActivity(intent);
                startActivity(intent1);
            }
        });
    }

}