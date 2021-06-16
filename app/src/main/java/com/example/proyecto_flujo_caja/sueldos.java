package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sueldos extends AppCompatActivity implements View.OnClickListener {
    private EditText incremento;
    private EditText totalGanadoAntes;
    private TextView totalGanadoDespues;
    private EditText numMeses1;
    private EditText numMeses2;
    private TextView retroactivo1;
    private TextView retroactivo2;
    private TextView resRetroActivo1;
    private TextView resRetroActivo2;
    private TextView resAporte1;
    private TextView resAporte2;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sueldos);
        incremento = (EditText)findViewById(R.id.incremento);
        totalGanadoAntes = (EditText)findViewById(R.id.totalGanadoAntes);
        totalGanadoDespues = (TextView)findViewById(R.id.totalGanadoDespues);
        numMeses1 = (EditText)findViewById(R.id.numMeses1);
        numMeses2 = (EditText)findViewById(R.id.numMeses2);
        resAporte1 = (TextView) findViewById(R.id.resAporte1);
        resAporte2 = (TextView)findViewById(R.id.resAporteDespues);
        retroactivo1 = (TextView)findViewById(R.id.retroactivo1);
        retroactivo2 = (TextView)findViewById(R.id.retroActivo2);
        resRetroActivo1 = (TextView)findViewById(R.id.resRetroActivo1);
        resRetroActivo2 = (TextView)findViewById(R.id.resRetroActivo2);
        btnRegistrar = findViewById(R.id.btnRegistrarSueldo);
        btnRegistrar.setOnClickListener(this);
    }
    public void onClick(View view){
        this.calculoTotalAntes();
        this.calculoTotalDespues();
        this.calculoRetroActivoUno();
        this.calculoRetroActivoDos();

    }
    private void calculoTotalAntes(){
        double totalAntes = Double.parseDouble(totalGanadoAntes.getText().toString());
        double aporte = 0.1671;
        double res = totalAntes*aporte;
        resAporte1.setText(""+res);
    }

    private void calculoTotalDespues(){
        double aporte = 0.1671;
        double totalAntes = Double.parseDouble(totalGanadoAntes.getText().toString());
        double porcentajeIncremento = Double.parseDouble(incremento.getText().toString());
        double totalDespues = (totalAntes*porcentajeIncremento)+totalAntes;
        totalGanadoDespues.setText(""+totalDespues);
        resAporte2.setText(""+aporte*totalDespues);

    }
    private void calculoRetroActivoUno(){
        double totalAntes= Double.parseDouble(totalGanadoAntes.getText().toString());
        double porcentajeIncremento = Double.parseDouble(incremento.getText().toString());
        double res = totalAntes * porcentajeIncremento;
        retroactivo1.setText("" + res);
        int numMesUno = Integer.parseInt(numMeses1.getText().toString());
        double resRetroactivo = numMesUno* res;
        resRetroActivo1.setText(""+resRetroactivo);

    }
    private void calculoRetroActivoDos(){
        double aporte = 0.1671;
        double totalAntes= Double.parseDouble(totalGanadoAntes.getText().toString());
        double porcentajeIncremento = Double.parseDouble(incremento.getText().toString());
        double resAporteAntes = totalAntes * porcentajeIncremento;
        double res = aporte * resAporteAntes;
        retroactivo2.setText(""+ res);
        int numMesDos = Integer.parseInt(numMeses2.getText().toString());
        double resRetroactivo = numMesDos* res;
        resRetroActivo2.setText(""+res);
    }

    public void anterior(View view){
        Intent anteriorPatronal = new Intent(this, aportepatronal.class);
        startActivity(anteriorPatronal);
    }
    public void registro(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}