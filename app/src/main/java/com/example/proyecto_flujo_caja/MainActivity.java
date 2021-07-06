package com.example.proyecto_flujo_caja;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.FlujoCajaProy;
import com.example.proyecto_flujo_caja.Models.SalesProjection;
import com.example.proyecto_flujo_caja.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private Company company;
    private SalesProjection february;
    private SalesProjection march;
    private SalesProjection april;

    private Double ingreosoOP;
    private Double gastosOP;
    private Double fuentes;
    private Double usos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getCompanyInfo();
        loadInfoCaja();
        loadSolds();

  //      NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    //    appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
      //  NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }
    public void Comenzar(View view)
    {
        Intent siguiente = new Intent(this, CompanyInformation.class);
        siguiente.putExtra("information", company);
        siguiente.putExtra("mes1", february);
        siguiente.putExtra("mes2", march);
        siguiente.putExtra("mes3", april);
        startActivity(siguiente);
    }

    public void Siguiente(View view){
        Intent siguiente = new Intent(this, aportepatronal.class);
        startActivity(siguiente);
    }
    public void siguienteVenta(View view){
        Intent siguiente = new Intent(this, proyeccion_ventas.class);
        startActivity(siguiente);
    }

    public void siguienteFinanciamiento(View view){
        Intent siguiente = new Intent(this, financiamiento.class);
        startActivity(siguiente);
    }
    public void siguientePresupuestoC(View view){
        Intent siguiente = new Intent(this, presupuesto_caja.class);
        startActivity(siguiente);
    }

    public void siguienteComprass(View view){
        Intent siguiente = new Intent(this, comprass.class);
        startActivity(siguiente);
    }

    public void siguienteImpuestos(View view){
        Intent siguiente = new Intent(this, menu_impuestos.class);
        startActivity(siguiente);
    }
    public void siguienteGrafico(View view){
        Intent graficos = new Intent(this, grafico.class);
        startActivity(graficos);
    }

    public void showMyAvtivity(View view){
        Intent change = new Intent(this, CompanyInformation.class);
        change.putExtra("information", company);
        change.putExtra("mes1", february);
        change.putExtra("mes2", march);
        change.putExtra("mes3", april);
        startActivity(change);
    }

    public void verFlujo(View view){
        Intent change = new Intent(this, FlujoCaja.class);
        change.putExtra("ingresoOP", ingreosoOP);
        change.putExtra("gastoOP", gastosOP);
        change.putExtra("fuentes", fuentes);
        change.putExtra("usos", usos);
        startActivity(change);
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

    private void loadInfoCaja(){
        db.collection("PresupuestoCaja").document("a").get().addOnSuccessListener(
                new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            ingreosoOP = Double.parseDouble(documentSnapshot.getString("tot1"));
                            gastosOP = Double.parseDouble(documentSnapshot.getString("tot2"));
                            fuentes = Double.parseDouble(documentSnapshot.getString("tot4"));
                            usos = Double.parseDouble(documentSnapshot.getString("tot5"));
                        }
                    }
                });
    }

    private void loadSolds(){
        db.collection("venta").document("a").get().addOnSuccessListener(
                new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                 if(documentSnapshot.exists()){
                    february = new SalesProjection(documentSnapshot.getString("mes1"), Double.parseDouble(documentSnapshot.getString("venta1")), Double.parseDouble(documentSnapshot.getString("precio1")));
                    march = new SalesProjection(documentSnapshot.getString("mes2"), Double.parseDouble(documentSnapshot.getString("venta2")), Double.parseDouble(documentSnapshot.getString("precio2")));
                    april = new SalesProjection(documentSnapshot.getString("mes3"), Double.parseDouble(documentSnapshot.getString("venta3")), Double.parseDouble(documentSnapshot.getString("precio3")));
                 }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}