package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyecto_flujo_caja.Models.Company;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Inicio extends AppCompatActivity {

    private Company company;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        getCompanyInfo();
    }
    public void iniFlujo(View view){
        Intent venta = new Intent(this, proyeccion_ventas.class);
        venta.putExtra("information", company);
        startActivity(venta);
    }
    public void sinFlujo(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

    private void getCompanyInfo(){
        db.collection("interesc").document("1Rw3hWARU5tp4zLSke9n").get().addOnSuccessListener(
                new OnSuccessListener<DocumentSnapshot>() {
             @Override
             public void onSuccess(DocumentSnapshot documentSnapshot) {
                  if(documentSnapshot.exists()){
                       company = new Company(documentSnapshot.getDouble("sales"), documentSnapshot.getDouble("credit30"),
                                 documentSnapshot.getDouble("credit60"), documentSnapshot.getDouble("about"),
                                 documentSnapshot.getDouble("badDebt"), documentSnapshot.getDouble("interest"));
                  }
             }
        });
    }

}