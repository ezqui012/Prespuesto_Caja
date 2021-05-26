package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class sueldos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sueldos);
    }

    public void anterior(View view){
        Intent anteriorPatronal = new Intent(this, aportepatronal.class);
        startActivity(anteriorPatronal);
    }
    public void registro(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}