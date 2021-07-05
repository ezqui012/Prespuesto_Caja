package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.InteresGasto;
import com.example.proyecto_flujo_caja.Models.InteresIngreso;
import com.example.proyecto_flujo_caja.Models.SalesProjection;
import com.google.firebase.firestore.FirebaseFirestore;


public class CompanyInformation extends AppCompatActivity {

    private Company company;

    private EditText input_sales;
    private EditText input_credit30;
    private EditText input_credit60;
    private EditText input_about;
    private EditText input_badDebt;
    private EditText input_interest;

    private Double sales;
    private Double credit30;
    private Double credit60;
    private Double about;
    private Double badDebt;
    private Double interest;

    private InteresGasto interes;
    private InteresIngreso interesI;

    private SalesProjection february;
    private SalesProjection march;
    private SalesProjection april;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_information);

        company = (Company) getIntent().getSerializableExtra("information");
        february = (SalesProjection) getIntent().getSerializableExtra("mes1");
        march = (SalesProjection) getIntent().getSerializableExtra("mes2");
        april = (SalesProjection) getIntent().getSerializableExtra("mes3");

        input_sales = (EditText) findViewById(R.id.input_sales);
        input_credit30 = (EditText) findViewById(R.id.input_credit30);
        input_credit60 = (EditText) findViewById(R.id.input_credit60);
        input_about = (EditText) findViewById(R.id.input_about);
        input_badDebt = (EditText) findViewById(R.id.input_bad_debt);
        input_interest = (EditText) findViewById(R.id.input_interest);

        showInfo();
    }

    public void anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

    private void showInfo(){
        input_sales.setText(String.valueOf(company.getSales()));
        input_credit30.setText(String.valueOf(company.getCredit30()));
        input_credit60.setText(String.valueOf(company.getCredit60()));
        input_about.setText(String.valueOf(company.getAbout()));
        input_badDebt.setText(String.valueOf(company.getBadDebt()));
        input_interest.setText(String.valueOf(company.getInterest()));
    }

    public void registerInfo(View view){
        if(TextUtils.isEmpty(input_sales.getText().toString())){
            input_sales.setError("Este campo es requerido");
            return;
        }
        if(TextUtils.isEmpty(input_credit30.getText().toString())){
            input_credit30.setError("Este campo es requerido");
            return;
        }
        if(TextUtils.isEmpty(input_credit60.getText().toString())){
            input_credit60.setError("Este campo es requerido");
            return;
        }
        if(TextUtils.isEmpty(input_about.getText().toString())){
            input_about.setError("Este campo es requerido");
            return;
        }
        if(TextUtils.isEmpty(input_badDebt.getText().toString())){
            input_badDebt.setError("Este campo es requerido");
            return;
        }
        if(TextUtils.isEmpty(input_interest.getText().toString())){
            input_interest.setError("Este campo es requerido");
            return;
        }

        sales = Double.parseDouble(input_sales.getText().toString());
        credit30 = Double.parseDouble(input_credit30.getText().toString());
        credit60 = Double.parseDouble(input_credit60.getText().toString());
        about = Double.parseDouble(input_about.getText().toString());
        badDebt = Double.parseDouble(input_badDebt.getText().toString());
        interest = Double.parseDouble(input_interest.getText().toString());

        company = null;
        company = new Company(sales, credit30, credit60, about, badDebt, interest);
        interes = new InteresGasto(february, march, april, company);
        interesI = new InteresIngreso(february, march, april, company);

        db.collection("interesc").document("1Rw3hWARU5tp4zLSke9n").update(company.getMapInfo());
        db.collection("interesIngreso").document("TtnQFYTiuoOc3OqXitgn").update(interesI.getMapinteresI());
        db.collection("interesGasto").document("2UOhIn6STMTCQBGjA9Sk").update(interes.getMapInteresG());

        Intent interest_comercial = new Intent(this, CommercialInterest.class);
        interest_comercial.putExtra("informationG", interes);
        interest_comercial.putExtra("informationI", interesI);
        interest_comercial.putExtra("nMes1", february.getMonth());
        interest_comercial.putExtra("nMes2", march.getMonth());
        interest_comercial.putExtra("nMes3", april.getMonth());
        startActivity(interest_comercial);
    }
}