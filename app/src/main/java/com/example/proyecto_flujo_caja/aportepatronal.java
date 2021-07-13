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
                Double caja1= documentSnapshot.getDouble("caja");
                caja.setText(""+caja1);
                Double provi= documentSnapshot.getDouble("provivienda");
                prov.setText(""+provi);
                Double afps= documentSnapshot.getDouble("afp");
                afp.setText(""+afps);
                Double soli= documentSnapshot.getDouble("solidario");
                solidario.setText(""+soli);
                Double ries= documentSnapshot.getDouble("riesgo");
                riesgo.setText(""+ries);
                Double resAp= documentSnapshot.getDouble("resAporte");
                resAporte.setText(""+resAp);
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
            double porcentajeCaja = Double.parseDouble(caja.getText().toString());
            double porcentajeProv = Double.parseDouble(prov.getText().toString());
            double porcentajeAfp = Double.parseDouble(afp.getText().toString());
            double porcentajeSolidario = Double.parseDouble(solidario.getText().toString());
            double porcentajeRiesgo = Double.parseDouble(riesgo.getText().toString());
            double res = porcentajeCaja+porcentajeProv+porcentajeAfp+porcentajeSolidario+porcentajeRiesgo;
            resAporte.setText(""+res);
            aporte.setAfp(porcentajeAfp);
            aporte.setCaja(porcentajeCaja);
            aporte.setProvivienda(porcentajeProv);
            aporte.setSolidario(porcentajeSolidario);
            aporte.setRiesgo(porcentajeRiesgo);
            aporte.setResAporte(res);
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