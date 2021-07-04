package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.proyecto_flujo_caja.Models.Aporte;
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
    }

    public void onClick(View view)
    {
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
        db.collection("Aporte").add(aporte);
        Intent siguienteSueldo = new Intent(this, sueldos.class);
        siguienteSueldo.putExtra("dato", resAporte.getText().toString());
        startActivity(siguienteSueldo);
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