package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyecto_flujo_caja.Models.Company;
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

    }

    public void anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
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

        db.collection("interesc").document().delete();

        db.collection("interesc").add(company);

        Intent interest_comercial = new Intent(this, CommercialInterest.class);
        interest_comercial.putExtra("information", company);
        startActivity(interest_comercial);

    }
}