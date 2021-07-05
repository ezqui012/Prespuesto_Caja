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

    String mes1;
    String mes2;
    String mes3;

    TextView mes1A, mes1B, mes1C;
    TextView mes2A, mes2B, mes2C, mes2D;
    TextView mes3A, mes3B, mes3C, mes3D, mes3E;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending_interest);
        interes = (InteresGasto) getIntent().getSerializableExtra("informationG");
        interesI = (InteresIngreso) getIntent().getSerializableExtra("informationI");
        mes1 = (String) getIntent().getSerializableExtra("nMes1");
        mes2 = (String) getIntent().getSerializableExtra("nMes2");
        mes3 = (String) getIntent().getSerializableExtra("nMes3");

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

        mes1A = (TextView) findViewById(R.id.title_op1);
        mes1B = (TextView) findViewById(R.id.title_op6);
        mes1C = (TextView) findViewById(R.id.title_op15);

        mes2A = (TextView) findViewById(R.id.title_op2);
        mes2B = (TextView) findViewById(R.id.title_op7);
        mes2C = (TextView) findViewById(R.id.title_op11);
        mes2D = (TextView) findViewById(R.id.title_op16);

        mes3A = (TextView) findViewById(R.id.title_op3);
        mes3B = (TextView) findViewById(R.id.title_op8);
        mes3C = (TextView) findViewById(R.id.title_op12);
        mes3D = (TextView) findViewById(R.id.title_op17);
        mes3E = (TextView) findViewById(R.id.title_op20);
    }

    private void editText(){
        mes1A.setText(mes1);
        igFebruary.setText(interes.getIgFebruary());
        mes2A.setText(mes2);
        igMarch.setText(interes.getIgMarch());
        mes3A.setText(mes3);
        igApril.setText(interes.getIgApril());

        mes1B.setText(mes1);
        ibFebruary.setText(interes.getIbFebruary());
        mes2B.setText(mes2);
        ibMarch.setText(interes.getIbMarch());
        mes3B.setText(mes3);
        ibApril.setText(interes.getIbApril());

        mes2C.setText(mes2);
        r30March.setText(interes.getR30March());
        mes3C.setText(mes3);
        r30April.setText(interes.getR30April());

        mes1C.setText(mes1);
        ib60February.setText(interes.getIb60February());
        mes2D.setText(mes2);
        ib60March.setText(interes.getIb60March());
        mes3D.setText(mes3);
        ib60April.setText(interes.getIb60April());

        mes3E.setText(mes3);
        r60April.setText(interes.getR60April());
    }

    public void viewComercialInterest(View view){
        Intent interest_comercial = new Intent(this, CommercialInterest.class);
        interest_comercial.putExtra("informationG", interes);
        interest_comercial.putExtra("informationI", interesI);
        interest_comercial.putExtra("nMes1", mes1);
        interest_comercial.putExtra("nMes2", mes2);
        interest_comercial.putExtra("nMes3", mes3);
        startActivity(interest_comercial);
    }

    public void volverinicio(View view){
        Intent change = new Intent(this, MainActivity.class);
        startActivity(change);
    }
}