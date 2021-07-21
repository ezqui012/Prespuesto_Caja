package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.proyecto_flujo_caja.Models.Aporte;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class aportepatronal extends AppCompatActivity implements View.OnClickListener{
    private EditText caja;
    private EditText prov;
    private EditText afp;
    private EditText solidario;
    private EditText riesgo;
    private TextView resAporte;
    private Button btnRegistrar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Aporte aporte = new Aporte();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aportepatronal);
        caja = findViewById(R.id.caja);
        prov = findViewById(R.id.prov);
        afp = findViewById(R.id.afp);
        solidario = findViewById(R.id.solidario);
        riesgo = findViewById(R.id.riesgo);
        resAporte = findViewById(R.id.resAporte);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(this);


        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("Aporte").document("7TqA8LJfyRuwHQPWKLKX");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String caja1= documentSnapshot.getString("caja");
                caja.setText(caja1);
                String provi= documentSnapshot.getString("provivienda");
                prov.setText(provi);
                String afps= documentSnapshot.getString("afp");
                afp.setText(afps);
                String soli= documentSnapshot.getString("solidario");
                solidario.setText(soli);
                String ries= documentSnapshot.getString("riesgo");
                riesgo.setText(ries);
                String resAp= documentSnapshot.getString("resAporte");
                resAporte.setText(resAp);
            }
        });
    }


    public void onClick(View view)
    {
        validacion();

    }

    public void validacion(){
       String caj = caja.getText().toString();
        String provi = prov.getText().toString();
        String af = afp.getText().toString();
        String soli = solidario.getText().toString();
        String ri = riesgo.getText().toString();

        if(caj.equals("")){
            caja.setError("Campo requerido");
        }
        else if(provi.equals("")){
            prov.setError("Campo Requerido");
        }
        else if(af.equals("")){
            afp.setError("Campo Requerido");
        }
        else if(soli.equals("")){
            solidario.setError("Campo Requerido");
        }
        else if(ri.equals("")){
            riesgo.setError("Campo Requerido");
        }else{
            DecimalFormatSymbols separador = new DecimalFormatSymbols();
            separador.setDecimalSeparator('.');
            DecimalFormat for2 = new DecimalFormat("0.0000", separador);
            DecimalFormat for1 = new DecimalFormat("0.00", separador);
            double porcentajeCaja = Double.parseDouble(caja.getText().toString());
            double porcentajeProv = Double.parseDouble(prov.getText().toString());
            double porcentajeAfp = Double.parseDouble(afp.getText().toString());
            double porcentajeSolidario = Double.parseDouble(solidario.getText().toString());
            double porcentajeRiesgo = Double.parseDouble(riesgo.getText().toString());
            double res = porcentajeCaja+porcentajeProv+porcentajeAfp+porcentajeSolidario+porcentajeRiesgo;
            resAporte.setText(for2.format(res));
            aporte.setAfp(for1.format(porcentajeAfp));
            aporte.setCaja(for1.format(porcentajeCaja));
            aporte.setProvivienda(for1.format(porcentajeProv));
            aporte.setSolidario(for1.format(porcentajeSolidario));
            aporte.setRiesgo(for1.format(porcentajeRiesgo));
            aporte.setResAporte(for1.format(res));
            db.collection("Aporte").document("7TqA8LJfyRuwHQPWKLKX").set(aporte);
            Intent siguienteSueldo = new Intent(this, sueldos.class);
            siguienteSueldo.putExtra("dato", resAporte.getText().toString());
            startActivity(siguienteSueldo);
        }

    }

    public void anterior (View view){
        Intent anterior = new Intent(this, sueldos.class);
        startActivity(anterior);
    }
    public void registrar(View view){
        Intent siguienteSueldo = new Intent(this, sueldos.class);
        siguienteSueldo.putExtra("dato", resAporte.getText().toString());
        startActivity(siguienteSueldo);

    }


}