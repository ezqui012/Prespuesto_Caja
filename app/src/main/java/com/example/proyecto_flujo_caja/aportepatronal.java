package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class aportepatronal extends AppCompatActivity implements View.OnClickListener{
    private EditText caja;
    private EditText prov;
    private EditText afp;
    private EditText solidario;
    private EditText riesgo;
    private TextView resAporte;
    private Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aportepatronal);
        caja = (EditText)findViewById(R.id.caja);
        prov = (EditText)findViewById(R.id.prov);
        afp = (EditText)findViewById(R.id.afp);
        solidario = (EditText)findViewById(R.id.solidario);
        riesgo = (EditText)findViewById(R.id.riesgo);
        resAporte = (TextView)findViewById(R.id.resAporte);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);
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
    }
    public void anterior (View view){
        Intent anterior = new Intent(this, MainActivity.class);
       // startActivity(anterior);
    }
    public void registrar(View view){
        Intent siguienteSueldo = new Intent(this, sueldos.class);
        startActivity(siguienteSueldo);
    }


}