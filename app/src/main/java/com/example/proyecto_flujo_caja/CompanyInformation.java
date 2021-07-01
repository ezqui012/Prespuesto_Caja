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
    private SalesProjection may;
    private SalesProjection june;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_information);

        input_sales = (EditText) findViewById(R.id.input_sales);
        input_credit30 = (EditText) findViewById(R.id.input_credit30);
        input_credit60 = (EditText) findViewById(R.id.input_credit60);
        input_about = (EditText) findViewById(R.id.input_about);
        input_badDebt = (EditText) findViewById(R.id.input_bad_debt);
        input_interest = (EditText) findViewById(R.id.input_interest);

        projectionSold();
    }

    public void anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

    private void projectionSold(){
        february = new SalesProjection("Febrero", 0,0.0);
        march = new SalesProjection("Marzo", 0,0.0);
        april = new SalesProjection("Abril", 400000,0.2);
        may = new SalesProjection("Mayo", 400000,0.2);
        june = new SalesProjection("Junio", 250000,0.2);
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

        company = new Company(sales, credit30, credit60, about, badDebt, interest);
        interes = new InteresGasto(february, march, april, may, june, company);
        interesI = new InteresIngreso(february, march, april, may, june, company);

        db.collection("interesc").add(company);
        db.collection("interesIngreso").add(interesI);
        db.collection("interesGasto").add(interes);

        Intent interest_comercial = new Intent(this, CommercialInterest.class);
        interest_comercial.putExtra("information", company);
        interest_comercial.putExtra("informationG", interes);
        interest_comercial.putExtra("informationI", interesI);
        startActivity(interest_comercial);

    }
}