package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.Financiamiento;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DecimalFormat;

public class financiamiento extends AppCompatActivity implements View.OnClickListener {
    private EditText cuantia;
    private EditText meses;
    private EditText tipoInteres;
    private EditText capitalInicial;
    private TextView capital,capPeriodo1, capPeriodo2;
    private TextView amortizacion, amortizacionPe1,amortizacionPe2;
    private TextView interes, interes1, interes2;
    private TextView cuota, cuota1,cuota2;

    private Button btnRegistrar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Financiamiento financiamiento = new Financiamiento();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financiamiento);
        cuantia = findViewById(R.id.editTextCuantia);
        meses = findViewById(R.id.editTextMeses);
        tipoInteres = findViewById(R.id.editTextTipoInteres);
        capitalInicial = findViewById(R.id.editTextCapitalInicial);
        capital = findViewById(R.id.textViewCapital);
        amortizacion = findViewById(R.id.textViewAmort);
        interes =  findViewById(R.id.textViewInteres);
        cuota = findViewById(R.id.textViewCuota);
        capPeriodo1= findViewById(R.id.capPeriodo1);
        capPeriodo2= findViewById(R.id.capPeriodo2);
        amortizacionPe1=findViewById(R.id.amoPeriodo1);
        amortizacionPe2=findViewById(R.id.amoPeriodo2);
        interes1=findViewById(R.id.intPeriodo1);
        interes2=findViewById(R.id.intPeriodo2);
        cuota1=findViewById(R.id.cuota1);
        cuota2=findViewById(R.id.cuota2);
        btnRegistrar = findViewById(R.id.btnRegistrarFinanciamiento);
        btnRegistrar.setOnClickListener(this);


        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("Financiamiento").document("finan");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Double amort= documentSnapshot.getDouble("amortizacion");
                amortizacion.setText(""+amort);
                Double amort1= documentSnapshot.getDouble("amortizacion1");
                amortizacionPe1.setText(""+amort1);
                Double amort2= documentSnapshot.getDouble("amortizacion2");
                amortizacionPe2.setText(""+amort2);
                Double cap= documentSnapshot.getDouble("capital");
                capital.setText(""+cap);
                Double cap1= documentSnapshot.getDouble("capital1");
                capPeriodo1.setText(""+cap1);
                Double cap2= documentSnapshot.getDouble("capital2");
                capPeriodo2.setText(""+cap2);

                Double capIni= documentSnapshot.getDouble("capitalInicial");
                capitalInicial.setText(""+capIni);
                Double cuanti= documentSnapshot.getDouble("cuantia");
                cuantia.setText(""+cuanti);

                Double cuot= documentSnapshot.getDouble("cuota");
                cuota.setText(""+cuot);
                Double cuot1= documentSnapshot.getDouble("cuota1");
                cuota1.setText(""+cuot1);
                Double cuot2= documentSnapshot.getDouble("cuota2");
                cuota2.setText(""+cuot2);
                Double inte= documentSnapshot.getDouble("interes");
                interes.setText(""+inte);
                Double inte1= documentSnapshot.getDouble("interes1");
                interes1.setText(""+inte1);
                Double inte2= documentSnapshot.getDouble("interes2");
                interes2.setText(""+inte2);
                Double mes= documentSnapshot.getDouble("meses");
                meses.setText(""+mes);
                Double tipoInte= documentSnapshot.getDouble("tipoInteres");
                tipoInteres.setText(""+tipoInte);

            }
        });

    }
    public void onClick(View view){
        this.calculoFinanciamiento();
    }
    public void calculoFinanciamiento(){
        DecimalFormat df = new DecimalFormat("#.00");
        double cantCuantia = Double.parseDouble(cuantia.getText().toString());
        Integer cantMeses = Integer.parseInt(meses.getText().toString());
        double cantTipoInteres = Double.parseDouble(tipoInteres.getText().toString());
        double cantCapInicial = Double.parseDouble(capitalInicial.getText().toString());
        double i = Math.pow((1-cantTipoInteres),-cantMeses);
        double resCuota = cantCuantia*(cantTipoInteres/(1-i));
        double resInteres = cantCapInicial*cantTipoInteres;
        double resAmortizacion = resCuota-resInteres;
        double resCapital = cantCapInicial-resAmortizacion;

        capital.setText(""+resCapital);
        amortizacion.setText(""+resAmortizacion);
        interes.setText(""+resInteres);
        cuota.setText(""+resCuota);
        //periodo1
        double resInteres1=resCapital*cantTipoInteres;
        double resAmorti1=resCuota-resInteres1;
        double resCapital1=resCapital-resAmorti1;
        capPeriodo1.setText(""+resCapital1);
        amortizacionPe1.setText(""+resAmorti1);
        interes1.setText(""+resInteres1);
        //periodo2
        double resInteres2=resCapital1*cantTipoInteres;
        double resAmorti2=resCuota-resInteres2;
        double resCapital2=resCapital1-resAmorti2;
        capPeriodo2.setText(""+resCapital2);
        amortizacionPe2.setText(""+resAmorti2);
        interes2.setText(""+resInteres2);
        cuota1.setText(""+resCuota);
        cuota2.setText(""+resCuota);
        financiamiento.setCapital(resCapital);
        financiamiento.setAmortizacion(resAmortizacion);
        financiamiento.setInteres(resInteres);
        financiamiento.setCuota(resCuota);
        financiamiento.setCuantia(cantCuantia);
        financiamiento.setMeses(cantMeses);
        financiamiento.setCapitalInicial(cantCapInicial);
        financiamiento.setCapital1(resCapital1);
        financiamiento.setAmortizacion1(resAmorti1);
        financiamiento.setCuota1(resCuota);
        financiamiento.setInteres1(resInteres1);
        financiamiento.setCapital2(resCapital2);
        financiamiento.setAmortizacion2(resAmorti2);
        financiamiento.setCuota2(resCuota);
        financiamiento.setInteres2(resInteres2);
        financiamiento.setTipoInteres(cantTipoInteres);
        db.collection("Financiamiento").document("finan").set(financiamiento);
        Intent pre = new Intent(this, presupuesto_caja.class);
        pre.putExtra("cap", capital.getText().toString());
        pre.putExtra("cap1", capPeriodo1.getText().toString());
        pre.putExtra("cap2", capPeriodo2.getText().toString());
        pre.putExtra("amortizacion", amortizacion.getText().toString());
        pre.putExtra("amortizacion1", amortizacionPe1.getText().toString());
        pre.putExtra("amortizacion2", amortizacionPe2.getText().toString());
        pre.putExtra("cuota", cuota.getText().toString());
        pre.putExtra("cuota1", cuota1.getText().toString());
        pre.putExtra("cuota2", cuota2.getText().toString());
    }
    public void anterior(View view){
        Intent main = new Intent(this, MainActivity.class);

        startActivity(main);
    }

}