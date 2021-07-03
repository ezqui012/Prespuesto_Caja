package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.Financiamiento;
import com.google.firebase.firestore.FirebaseFirestore;

public class financiamiento extends AppCompatActivity implements View.OnClickListener {
    private EditText cuantia;
    private EditText meses;
    private EditText tipoInteres;
    private EditText capitalInicial;
    private TextView capital;
    private TextView amortizacion;
    private TextView interes;
    private TextView cuota;
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
        btnRegistrar = findViewById(R.id.btnRegistrarFinanciamiento);
        btnRegistrar.setOnClickListener(this);
    }
    public void onClick(View view){
        this.calculoFinanciamiento();
    }
    public void calculoFinanciamiento(){
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
        financiamiento.setCapital(resCapital);
        financiamiento.setAmortizacion(resAmortizacion);
        financiamiento.setInteres(resInteres);
        financiamiento.setCuota(resCuota);
        financiamiento.setCuantia(cantCuantia);
        financiamiento.setMeses(cantMeses);
        financiamiento.setCapitalInicial(cantCapInicial);
        db.collection("Financiamiento").add(financiamiento);


    }
    public void anterior(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}