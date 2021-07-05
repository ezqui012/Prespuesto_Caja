package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.InteresGasto;
import com.example.proyecto_flujo_caja.Models.InteresIngreso;
import com.example.proyecto_flujo_caja.Models.SalesProjection;

public class CommercialInterest extends AppCompatActivity {

    TextView ibFebruary;
    TextView ibMarch;
    TextView ibApril;

    TextView r30March;
    TextView r30April;

    TextView ib60February;
    TextView ib60March;
    TextView ib60April;

    TextView r60April;

    private InteresGasto interes;
    private InteresIngreso interesI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercial_interest);
        interes = (InteresGasto) getIntent().getSerializableExtra("informationG");
        interesI = (InteresIngreso) getIntent().getSerializableExtra("informationI");
        idViewText();
        editText();
    }

    private void idViewText(){
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

        ibFebruary.setText(interesI.getIbFebruary());
        ibMarch.setText(interesI.getIbMarch());
        ibApril.setText(interesI.getIbApril());

        r30March.setText(interesI.getR30March());
        r30April.setText(interesI.getR30April());

        ib60February.setText(interesI.getIb60February());
        ib60March.setText(interesI.getIb60March());
        ib60April.setText(interesI.getIb60April());

        r60April.setText(interesI.getR60April());

    }

    public void viewSpendingInterest(View view){
        Intent interest_spending = new Intent(this, spending_interest.class);
        interest_spending.putExtra("informationG", interes);
        interest_spending.putExtra("informationI", interesI);
        startActivity(interest_spending);
    }

}