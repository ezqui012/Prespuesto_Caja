package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.SalesProjection;

public class CommercialInterest extends AppCompatActivity {

    private SalesProjection february;
    private SalesProjection march;
    private SalesProjection april;
    private SalesProjection may;
    private SalesProjection june;

    private Company info;

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
        setContentView(R.layout.activity_commercial_interest);

        info = (Company) getIntent().getSerializableExtra("information");
        idViewText();
        projectionSold();
        editText();

    }

    private void projectionSold(){
        february = new SalesProjection("Febrero", 0,0.0);
        march = new SalesProjection("Marzo", 0,0.0);
        april = new SalesProjection("Abril", 400000,0.2);
        may = new SalesProjection("Mayo", 400000,0.2);
        june = new SalesProjection("Junio", 250000,0.2);
    }

    private String grossIncome(Double grossIncomeMonth, Double credit){
        double res = grossIncomeMonth * credit * info.getInterest();
        return String.valueOf(res);
    }

    private String recovery(Double grossIncomeMonth){
        double res = grossIncomeMonth * (1 - info.getBadDebt());
        return String.valueOf(res);
    }

    private void idViewText(){
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

        ibFebruary.setText(grossIncome(february.getGross_income(), info.getCredit30()));
        ibMarch.setText(grossIncome(march.getGross_income(), info.getCredit30()));
        ibApril.setText(grossIncome(april.getGross_income(), info.getCredit30()));
        ibMay.setText(grossIncome(may.getGross_income(), info.getCredit30()));
        ibJune.setText(grossIncome(june.getGross_income(), info.getCredit30()));

        r30March.setText(recovery(Double.parseDouble(ibFebruary.getText().toString())));
        r30April.setText(recovery(Double.parseDouble(ibMarch.getText().toString())));
        r30May.setText(recovery(Double.parseDouble(ibApril.getText().toString())));
        r30June.setText(recovery(Double.parseDouble(ibMay.getText().toString())));

        ib60February.setText(grossIncome(february.getGross_income(), info.getCredit60()));
        ib60March.setText(grossIncome(march.getGross_income(), info.getCredit60()));
        ib60April.setText(grossIncome(april.getGross_income(), info.getCredit60()));
        ib60May.setText(grossIncome(may.getGross_income(), info.getCredit60()));
        ib60June.setText(grossIncome(june.getGross_income(), info.getCredit60()));

        r60April.setText(recovery(Double.parseDouble(ib60February.getText().toString())));
        r60May.setText(recovery(Double.parseDouble(ib60March.getText().toString())));
        r60June.setText(recovery(Double.parseDouble(ib60April.getText().toString())));

    }
}