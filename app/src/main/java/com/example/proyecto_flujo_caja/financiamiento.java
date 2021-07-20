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
import java.text.DecimalFormatSymbols;

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
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                String amort= documentSnapshot.getString("amortizacion");
                amortizacion.setText(amort);
                String amort1= documentSnapshot.getString("amortizacion1");
                amortizacionPe1.setText(amort1);
                String amort2= documentSnapshot.getString("amortizacion2");
                amortizacionPe2.setText(amort2);
                String cap= documentSnapshot.getString("capital");
                capital.setText(cap);
                String cap1= documentSnapshot.getString("capital1");
                capPeriodo1.setText(cap1);
                String cap2= documentSnapshot.getString("capital2");
                capPeriodo2.setText(cap2);

                String capIni= documentSnapshot.getString("capitalInicial");
                capitalInicial.setText(capIni);
                String cuanti= documentSnapshot.getString("cuantia");
                cuantia.setText(cuanti);

                String cuot= documentSnapshot.getString("cuota");
                cuota.setText(cuot);
                String cuot1= documentSnapshot.getString("cuota1");
                cuota1.setText(cuot1);
                String cuot2= documentSnapshot.getString("cuota2");
                cuota2.setText(cuot2);
                String inte= documentSnapshot.getString("interes");
                interes.setText(inte);
                String inte1= documentSnapshot.getString("interes1");
                interes1.setText(inte1);
                String inte2= documentSnapshot.getString("interes2");
                interes2.setText(inte2);
                String mes= documentSnapshot.getString("meses");
                meses.setText(mes);
                String tipoInte= documentSnapshot.getString("tipoInteres");
                tipoInteres.setText(tipoInte);
            }
        });

    }
    public void onClick(View view){
        validacion();

    }
    public void calculoFinanciamiento(){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);




        double cantCuantia = Double.parseDouble(cuantia.getText().toString());
        Double cantMeses = Double.parseDouble(meses.getText().toString());
        double cantTipoInteres = Double.parseDouble(tipoInteres.getText().toString());
        double cantCapInicial = Double.parseDouble(capitalInicial.getText().toString());
        double i = Math.pow((1-cantTipoInteres),-cantMeses);
        double resCuota = cantCuantia*(cantTipoInteres/(1-i));
        double resInteres = cantCapInicial*cantTipoInteres;
        double resAmortizacion = resCuota-resInteres;

        //periodo
        DecimalFormatSymbols separador = new DecimalFormatSymbols();
        separador.setDecimalSeparator('.');
        DecimalFormat for2 = new DecimalFormat("0.00000", separador);
        DecimalFormat for1 = new DecimalFormat("0.00", separador);
        Double resCapital = cantCapInicial-resAmortizacion;
        capital.setText(""+for1.format(resCapital));
        amortizacion.setText(""+for1.format(resAmortizacion));
        interes.setText(""+for1.format(resInteres));
        cuota.setText(""+for1.format(resCuota));
        //periodo1
        double resInteres1=resCapital*cantTipoInteres;
        double resAmorti1=resCuota-resInteres1;
        double resCapital1=resCapital-resAmorti1;
        capPeriodo1.setText(""+for1.format(resCapital1));
        amortizacionPe1.setText(""+for1.format(resAmorti1));
        interes1.setText(""+for1.format(resInteres1));
        //periodo2
        double resInteres2=resCapital1*cantTipoInteres;
        double resAmorti2=resCuota-resInteres2;
        double resCapital2=resCapital1-resAmorti2;
        capPeriodo2.setText(""+for1.format(resCapital2));
        amortizacionPe2.setText(""+for1.format(resAmorti2));
        interes2.setText(""+for1.format(resInteres2));
        cuota1.setText(""+for1.format(resCuota));
        cuota2.setText(""+for1.format(resCuota));

        financiamiento.setCapital(for1.format(resCapital));
        financiamiento.setAmortizacion(for1.format(resAmortizacion));
        financiamiento.setInteres(for1.format(resInteres));
        financiamiento.setCuota(for1.format(resCuota));
        financiamiento.setCuantia(for1.format(cantCuantia));
        financiamiento.setMeses(for1.format(cantMeses));
        financiamiento.setCapitalInicial(for1.format(cantCapInicial));
        financiamiento.setCapital1(for1.format(resCapital1));
        financiamiento.setAmortizacion1(for1.format(resAmorti1));
        financiamiento.setCuota1(for1.format(resCuota));
        financiamiento.setInteres1(for1.format(resInteres1));
        financiamiento.setCapital2(for1.format(resCapital2));
        financiamiento.setAmortizacion2(for1.format(resAmorti2));
        financiamiento.setCuota2(for1.format(resCuota));
        financiamiento.setInteres2(for1.format(resInteres2));
        financiamiento.setTipoInteres(for2.format(cantTipoInteres));


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
    public void validacion(){
        String cuanti = cuantia.getText().toString();
        String tipoInt = tipoInteres.getText().toString();
        String capiIni = capitalInicial.getText().toString();
        String mes = meses.getText().toString();
        if(cuanti.equals("")){
            cuantia.setError("Campo Requerido");
        }
        else if(tipoInt.equals("")){
            tipoInteres.setError("Campo Requerido");
        }
        else if(capiIni.equals("")){
            capitalInicial.setError("Campo Requerido");
        }
        else if(mes.equals("")){
            meses.setError("Campo Requerido");
        }else{
            this.calculoFinanciamiento();
        }
    }
    public void anterior(View view){
        Intent main = new Intent(this, presupuesto_caja.class);

        startActivity(main);
    }

}