package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.InteresGasto;
import com.example.proyecto_flujo_caja.Models.InteresIngreso;

public class spending_interest extends AppCompatActivity {

    private InteresGasto interes;
    private InteresIngreso interesI;

    TextView igFebruary;
    TextView igMarch;
    TextView igApril;
    TextView igMay;
    TextView igJune;

    TextView ibFebruary;
    TextView ibMarch;
    TextView ibApril;
    TextView ibMay;
    TextView ibJune;

    TextView r30March;
    TextView r30April;
    TextView r30May;
    TextView r30June;

    TextView ib60February;
    TextView ib60March;
    TextView ib60April;
    TextView ib60May;
    TextView ib60June;

    TextView r60April;
    TextView r60May;
    TextView r60June;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_interest);
        interes = (InteresGasto) getIntent().getSerializableExtra("informationG");
        interesI = (InteresIngreso) getIntent().getSerializableExtra("informationI");

        idViewText();
        editText();
    }

    private void idViewText(){
        igFebruary = (TextView) findViewById(R.id.IGmonth1);
        igMarch = (TextView) findViewById(R.id.IGmonth2);
        igApril = (TextView) findViewById(R.id.IGmonth3);
        igMay = (TextView) findViewById(R.id.IGmonth4);
        igJune = (TextView) findViewById(R.id.IGmonth5);

        ibFebruary = (TextView) findViewById(R.id.IBmonth1);
        ibMarch = (TextView) findViewById(R.id.IBmonth2);
        ibApril = (TextView) findViewById(R.id.IBmonth3);
        ibMay = (TextView) findViewById(R.id.IBmonth4);
        ibJune = (TextView) findViewById(R.id.IBmonth5);

        r30March = (TextView) findViewById(R.id.R30month2);
        r30April = (TextView) findViewById(R.id.R30month3);
        r30May = (TextView) findViewById(R.id.R30month4);
        r30June = (TextView) findViewById(R.id.R30month5);

        ib60February = (TextView) findViewById(R.id.IB60month1);
        ib60March = (TextView) findViewById(R.id.IB60month2);
        ib60April = (TextView) findViewById(R.id.IB60month3);
        ib60May = (TextView) findViewById(R.id.IB60month4);
        ib60June = (TextView) findViewById(R.id.IB60month5);

        r60April = (TextView) findViewById(R.id.R60month3);
        r60May = (TextView) findViewById(R.id.R60month4);
        r60June = (TextView) findViewById(R.id.R60month5);

    }

    private void editText(){

        igFebruary.setText(interes.getIgFebruary());
        igMarch.setText(interes.getIgMarch());
        igApril.setText(interes.getIgApril());
        igMay.setText(interes.getIgMay());
        igJune.setText(interes.getIgJune());

        ibFebruary.setText(interes.getIbFebruary());
        ibMarch.setText(interes.getIbMarch());
        ibApril.setText(interes.getIbApril());
        ibMay.setText(interes.getIbMay());
        ibJune.setText(interes.getIbJune());

        r30March.setText(interes.getR30March());
        r30April.setText(interes.getR30April());
        r30May.setText(interes.getR30May());
        r30June.setText(interes.getR30June());

        ib60February.setText(interes.getIb60February());
        ib60March.setText(interes.getIb60March());
        ib60April.setText(interes.getIb60April());
        ib60May.setText(interes.getIb60May());
        ib60June.setText(interes.getIb60June());

        r60April.setText(interes.getR60April());
        r60May.setText(interes.getR60May());
        r60June.setText(interes.getR60June());

    }

    public void viewComercialInterest(View view){
        Intent interest_comercial = new Intent(this, CommercialInterest.class);
        interest_comercial.putExtra("informationG", interes);
        interest_comercial.putExtra("informationI", interesI);
        startActivity(interest_comercial);
    }
    public void Siguiente (View view){
        Intent sig = new Intent(this, aportepatronal.class);
        startActivity(sig);
    }
}