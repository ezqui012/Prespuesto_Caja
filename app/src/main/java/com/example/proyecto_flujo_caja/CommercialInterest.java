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

    String mes1;
    String mes2;
    String mes3;

    TextView mes1A, mes1B;
    TextView mes2A, mes2B, mes2C;
    TextView mes3A, mes3B, mes3C, mes3D;

    private InteresGasto interes;
    private InteresIngreso interesI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commercial_interest);
        interes = (InteresGasto) getIntent().getSerializableExtra("informationG");
        interesI = (InteresIngreso) getIntent().getSerializableExtra("informationI");
        mes1 = (String) getIntent().getSerializableExtra("nMes1");
        mes2 = (String) getIntent().getSerializableExtra("nMes2");
        mes3 = (String) getIntent().getSerializableExtra("nMes3");
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

        mes1A = (TextView) findViewById(R.id.title_op1);
        mes1B = (TextView) findViewById(R.id.title_op10);

        mes2A = (TextView) findViewById(R.id.title_op2);
        mes2B = (TextView) findViewById(R.id.title_op6);
        mes2C = (TextView) findViewById(R.id.title_op11);

        mes3A = (TextView) findViewById(R.id.title_op3);
        mes3B = (TextView) findViewById(R.id.title_op7);
        mes3C = (TextView) findViewById(R.id.title_op12);
        mes3D = (TextView) findViewById(R.id.title_op15);
    }

    private void editText(){
        mes1A.setText(mes1);
        ibFebruary.setText(interesI.getIbFebruary());
        mes2A.setText(mes2);
        ibMarch.setText(interesI.getIbMarch());
        mes3A.setText(mes3);
        ibApril.setText(interesI.getIbApril());

        mes2B.setText(mes2);
        r30March.setText(interesI.getR30March());
        mes3B.setText(mes3);
        r30April.setText(interesI.getR30April());

        mes1B.setText(mes1);
        ib60February.setText(interesI.getIb60February());
        mes2C.setText(mes2);
        ib60March.setText(interesI.getIb60March());
        mes3C.setText(mes3);
        ib60April.setText(interesI.getIb60April());

        mes3D.setText(mes3);
        r60April.setText(interesI.getR60April());

    }

    public void viewSpendingInterest(View view){
        Intent interest_spending = new Intent(this, spending_interest.class);
        interest_spending.putExtra("informationG", interes);
        interest_spending.putExtra("informationI", interesI);
        interest_spending.putExtra("nMes1", mes1);
        interest_spending.putExtra("nMes2", mes2);
        interest_spending.putExtra("nMes3", mes3);
        startActivity(interest_spending);
    }

}