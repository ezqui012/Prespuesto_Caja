package com.example.proyecto_flujo_caja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.Sueldos;
import com.google.firebase.firestore.DocumentReference;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class sueldos extends AppCompatActivity implements View.OnClickListener {
    private EditText incremento;
    private TextView aporteRecibido;
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
    private TextView aporte;
    private Button btnRegistrar;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    Sueldos sueldo = new Sueldos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sueldos);
        incremento = (EditText)findViewById(R.id.incremento);
        aporteRecibido = (TextView)findViewById(R.id.textViAporteRecibido);
        String dato = getIntent().getStringExtra("dato");
        aporteRecibido.setText(dato);
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
        aporte = (TextView)findViewById(R.id.textViAporteRecibido);
        btnRegistrar = findViewById(R.id.btnRegistrarSueldo);
        btnRegistrar.setOnClickListener(this);


        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("Sueldo").document("H74DMS6OaNqVufi9SjNP");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Double inc= documentSnapshot.getDouble("incremento");
                incremento.setText(""+inc);
                Double gainAn= documentSnapshot.getDouble("gainAntes");
                totalGanadoAntes.setText(""+gainAn);
                Double mes1= documentSnapshot.getDouble("mes1");
                numMeses1.setText(""+mes1);
                Double mes2= documentSnapshot.getDouble("mes2");
                numMeses2.setText(""+mes2);
                Double resAp1= documentSnapshot.getDouble("resAporte1");
                resAporte1.setText(""+resAp1);
                Double resAp2= documentSnapshot.getDouble("resAporte2");
                resAporte2.setText(""+resAp2);

                Double resActi1= documentSnapshot.getDouble("resRetroactivo1");
                resRetroActivo1.setText(""+resActi1);
                Double resAct2= documentSnapshot.getDouble("resRetroactivo2");
                resRetroActivo2.setText(""+resAct2);

                Double retro1= documentSnapshot.getDouble("retroactivo1");
                resRetroActivo1.setText(""+retro1);
                Double retro2= documentSnapshot.getDouble("retroactivo2");
                resRetroActivo2.setText(""+retro2);

            }
        });



    }
    public void onClick(View view){
        this.validacion();
        this.calculoTotalAntes();
        this.calculoTotalDespues();
        this.calculoRetroActivoUno();
        this.calculoRetroActivoDos();
    }

    private void calculoTotalAntes(){
        double totalAntes = Double.parseDouble(totalGanadoAntes.getText().toString());
        double aportePat = Double.parseDouble(aporte.getText().toString());
        double res = totalAntes*aportePat;
        resAporte1.setText(""+res);
        sueldo.setTotalGainAntes(totalAntes);
        sueldo.setResAporte1(res);
        Intent siguienteSueldo = new Intent(this, presupuesto_caja.class);
        siguienteSueldo.putExtra("resAp1", resAporte1.getText().toString());
        siguienteSueldo.putExtra("suelAntes", totalGanadoAntes.getText().toString());
    }
    private void calculoTotalDespues(){
        double aportePat = Double.parseDouble(aporte.getText().toString());
        double totalAntes = Double.parseDouble(totalGanadoAntes.getText().toString());
        double porcentajeIncremento = Double.parseDouble(incremento.getText().toString());
        double totalDespues = (totalAntes*porcentajeIncremento)+totalAntes;
        totalGanadoDespues.setText(""+totalDespues);
        resAporte2.setText(""+aportePat*totalDespues);
        sueldo.setIncremento(porcentajeIncremento);
        sueldo.setTotalGainDespues(totalDespues);
        sueldo.setResAporte2(aportePat*totalDespues);
        Intent siguienteSueldo = new Intent(this, presupuesto_caja.class);
        siguienteSueldo.putExtra("resApo2", resAporte2.getText().toString());
        siguienteSueldo.putExtra("suelDespues", totalGanadoDespues.getText().toString());
    }
    private void calculoRetroActivoUno(){
        double totalAntes= Double.parseDouble(totalGanadoAntes.getText().toString());
        double porcentajeIncremento = Double.parseDouble(incremento.getText().toString());
        double res = totalAntes * porcentajeIncremento;
        retroactivo1.setText("" + res);
        Double numMesUno = Double.parseDouble(numMeses1.getText().toString());
        double resRetroactivo = numMesUno* res;
        resRetroActivo1.setText(""+resRetroactivo);
        sueldo.setMes1(numMesUno);
        sueldo.setRetroactivo1(res);
        sueldo.setResRetroactivo1(resRetroactivo);
        Intent siguienteSueldo = new Intent(this, presupuesto_caja.class);
        siguienteSueldo.putExtra("retro1", retroactivo1.getText().toString());


    }
    private void calculoRetroActivoDos(){

        double aportePat = Double.parseDouble(aporte.getText().toString());
        double totalAntes= Double.parseDouble(totalGanadoAntes.getText().toString());
        double porcentajeIncremento = Double.parseDouble(incremento.getText().toString());
        double resAporteAntes = totalAntes * porcentajeIncremento;
        double res = aportePat * resAporteAntes;
        retroactivo2.setText(""+ res);
        Double numMesDos = Double.parseDouble(numMeses2.getText().toString());
        double resRetroactivo = numMesDos* res;
        resRetroActivo2.setText(""+resRetroactivo);
        sueldo.setMes2(numMesDos);
        sueldo.setRetroactivo2(res);
        sueldo.setResRetroactivo2(resRetroactivo);
        firebaseFirestore.collection("Sueldo").document("H74DMS6OaNqVufi9SjNP").set(sueldo);
        Intent siguienteSueldo = new Intent(this, presupuesto_caja.class);
        siguienteSueldo.putExtra("ret2", retroactivo2.getText().toString());
    }
    public void validacion(){
        String increment = incremento.getText().toString();
        String totalGanadoAnt = totalGanadoAntes.getText().toString();
        String meses1 = numMeses1.getText().toString();
        String meses2 = numMeses2.getText().toString();
        if(increment.equals("")){
            incremento.setError("requerido");
        }
        else if(totalGanadoAnt.equals("")){
            totalGanadoAntes.setError("Requerido");
        }
        else if(meses1.equals("")){
            numMeses1.setError("Requerido");
        }
        else if(meses2.equals("")){
            numMeses2.setError("Requerido");
        }
    }


    public void anterior(View view){
        Intent anteriorPatronal = new Intent(this, financiamiento.class);
        startActivity(anteriorPatronal);
    }
    public void registro(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}