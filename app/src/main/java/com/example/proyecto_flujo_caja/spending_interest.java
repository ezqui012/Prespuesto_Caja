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

    TextView ibFebruary;
    TextView ibMarch;
    TextView ibApril;

    TextView r30March;
    TextView r30April;

    TextView ib60February;
    TextView ib60March;
    TextView ib60April;

    TextView r60April;

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

        ibFebruary = (TextView) findViewById(R.id.IBmonth1);
        ibMarch = (TextView) findViewById(R.id.IBmonth2);
        ibApril = (TextView) findViewById(R.id.IBmonth3);

        r30March = (TextView) findViewById(R.id.R30month2);
        r30April = (TextView) findViewById(R.id.R30month3);

        ib60February = (TextView) findViewById(R.id.IB60month1);
        ib60March = (TextView) findViewById(R.id.IB60month2);
        ib60April = (TextView) findViewById(R.id.IB60month3);

        r60April = (TextView) findViewById(R.id.R60month3);

    }

    private void editText(){

        igFebruary.setText(interes.getIgFebruary());
        igMarch.setText(interes.getIgMarch());
        igApril.setText(interes.getIgApril());

        ibFebruary.setText(interes.getIbFebruary());
        ibMarch.setText(interes.getIbMarch());
        ibApril.setText(interes.getIbApril());

        r30March.setText(interes.getR30March());
        r30April.setText(interes.getR30April());

        ib60February.setText(interes.getIb60February());
        ib60March.setText(interes.getIb60March());
        ib60April.setText(interes.getIb60April());

        r60April.setText(interes.getR60April());
    }

    public void viewComercialInterest(View view){
        Intent interest_comercial = new Intent(this, CommercialInterest.class);
        interest_comercial.putExtra("informationG", interes);
        interest_comercial.putExtra("informationI", interesI);
        startActivity(interest_comercial);
    }
}