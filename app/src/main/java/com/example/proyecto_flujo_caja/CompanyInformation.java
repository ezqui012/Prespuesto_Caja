package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.proyecto_flujo_caja.Models.Company;

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

    public void registerInfo(View view){
        sales = Double.parseDouble(input_sales.getText().toString());
        credit30 = Double.parseDouble(input_credit30.getText().toString());
        credit60 = Double.parseDouble(input_credit60.getText().toString());
        about = Double.parseDouble(input_about.getText().toString());
        badDebt = Double.parseDouble(input_badDebt.getText().toString());
        interest = Double.parseDouble(input_interest.getText().toString());

        company = new Company(sales, credit30, credit60, about, badDebt, interest);
    }
}