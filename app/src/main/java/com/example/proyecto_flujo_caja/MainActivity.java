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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getCompanyInfo();

  //      NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    //    appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
      //  NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }
    public void Comenzar(View view)
    {
        Intent siguiente = new Intent(this, CompanyInformation.class);
        siguiente.putExtra("information", company);
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

    public void showMyAvtivity(View view){
        Intent change = new Intent(this, CompanyInformation.class);
        change.putExtra("information", company);
        startActivity(change);
    }

    public void verFlujo(View view){
        Intent change = new Intent(this, FlujoCaja.class);
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