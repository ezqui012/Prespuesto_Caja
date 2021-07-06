package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import android.widget.Button;

import com.example.proyecto_flujo_caja.Models.*;
import com.google.firebase.firestore.*;


public class comprass extends AppCompatActivity {

    private Compras compra;
    EditText contado, treinta, venta, dmonth1,dmonth2,dmonth3,price1,price2,price3;
    TextView month1, month2, month3,ibru1, ibru2,ibru3,comp1,comp2,comp3, thirty1, thirty2,thirty3, compContt1,compCont2,compCont3;
    Spinner opciones;
    private Double pcontado, ptreinta, pventas;
    Ventas infoV;
    Company company;
    SalesProjection february, march, april;
    Button sigu,calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprass);
        company = (Company) getIntent().getSerializableExtra("information");
        infoV = (Ventas) getIntent().getSerializableExtra("infoVenta");
        contado = findViewById(R.id.cont);
        treinta = findViewById(R.id.tren);
        venta = findViewById(R.id.vent);
        calcular = (Button) findViewById(R.id.calc);
        Button cancel = (Button) findViewById(R.id.cancel);
        sigu= (Button) findViewById(R.id.sigu);

        month1 = findViewById(R.id.month1);
        month2 = findViewById(R.id.month2);
        month3 = findViewById(R.id.month3);
        dmonth1 = findViewById(R.id.datomonth1);
        dmonth2 = findViewById(R.id.datomonth2);
        dmonth3 = findViewById(R.id.datomonth3);
        price1 = findViewById(R.id.datoprice1);
        price2 = findViewById(R.id.price2);
        price3 = findViewById(R.id.price3);
        comp1 = findViewById(R.id.comp1);
        comp2 = findViewById(R.id.comp2);
        comp3 = findViewById(R.id.comp3);
        thirty1 = findViewById(R.id.thirty);
        thirty2 = findViewById(R.id.thirty2);
        thirty3 = findViewById(R.id.thirty3);
        ibru1 = findViewById(R.id.ibru1);
        ibru2 = findViewById(R.id.ibru2);
        ibru3 = findViewById(R.id.ibru3);
        compContt1= findViewById(R.id.compcontt1);
        compCont2= findViewById(R.id.compcontt2);
        compCont3= findViewById(R.id.compcontt3);

        opciones = findViewById(R.id.sp2);


        String[] opc = {"Trimestre I", "Trimestre II", "Trimestre III", "Trimestre IV"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        opciones.setAdapter(adapter);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

    public void Calculate(View view){
        sigu.setVisibility(View.VISIBLE);
        sigu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getApplicationContext(),CompanyInformation.class));
                Intent intent = new Intent(getApplicationContext(), CompanyInformation.class);
                february = new SalesProjection(infoV.getMes1(), Double.parseDouble(infoV.getVenta1()), Double.parseDouble(infoV.getPrecio1()));
                march = new SalesProjection(infoV.getMes2(), Double.parseDouble(infoV.getVenta2()), Double.parseDouble(infoV.getPrecio2()));
                april = new SalesProjection(infoV.getMes3(), Double.parseDouble(infoV.getVenta3()), Double.parseDouble(infoV.getPrecio3()));
                intent.putExtra("information", company);
                intent.putExtra("mes1", february);
                intent.putExtra("mes2", march);
                intent.putExtra("mes3", april);
                startActivity(intent);
            }
        });
        calcular.setVisibility(View.INVISIBLE);

        String dtsmonth1 = dmonth1.getText().toString();
        String dtsmonth2 = dmonth2.getText().toString();
        String dtsmonth3 = dmonth3.getText().toString();
        String dtsprice= price1.getText().toString();
        String dtsprice2= price2.getText().toString();
        String dtsprice3= price3.getText().toString();
        Double dtmonth1 =Double.parseDouble(dtsmonth1);
        Double dtmonth2 =Double.parseDouble(dtsmonth2);
        Double dtmonth3 =Double.parseDouble(dtsmonth3);
        Double pric =Double.parseDouble(dtsprice);
        Double pric2 =Double.parseDouble(dtsprice2);
        Double pric3 =Double.parseDouble(dtsprice3);

        String seleccion = opciones.getSelectedItem().toString();
        final String conta = contado.getText().toString();
        final String trent = treinta.getText().toString();
        final String ven = venta.getText().toString();
        if(TextUtils.isEmpty(conta)){ contado.setError("Este campo es requerido");return; }
        if(TextUtils.isEmpty(trent)){treinta.setError("Este campo es requerido");return; }
        if(TextUtils.isEmpty(ven)){venta.setError("Este campo es requerido");return; }


        pcontado = Double.parseDouble(conta);
        ptreinta = Double.parseDouble(trent);
        pventas= Double.parseDouble(ven);


        if(seleccion.equals("Trimestre I")){
            month1.setText("ENERO");
            month2.setText("FEBRERO");
            month3.setText("MARZO");

        }else if (seleccion.equals("Trimestre II")){
            month1.setText("ABRIL");
            month2.setText("MAYO");
            month3.setText("JUNIO");

        }else if (seleccion.equals("Trimestre III")){
            month1.setText("JULIO");
            month2.setText("AGOSTO");
            month3.setText("SEPTEMBRE");

        }else if (seleccion.equals("Trimestre IV")){
            month1.setText("OCTUBRE");
            month2.setText("NOVIEMBRE");
            month3.setText("DICIEMBRE");

        }
        Double ingreso1 = dtmonth1 * pric;
        Double ing2 = dtmonth2*pric2;
        Double ing3 = dtmonth3*pric3;


        ibru1.setText(ingreso1.toString()+" Bs");
        ibru2.setText(ing2.toString() +" Bs");
        ibru3.setText(ing3.toString() +" Bs");

        Double xcomp1 =  ingreso1*pventas;
        Double xcomp2 =  ing2 *pventas;
        Double xcomp3 =  ing3 *pventas;

        comp1.setText(xcomp1.toString());
        comp2.setText(xcomp2.toString());
        comp3.setText(xcomp3.toString());

        Double xcomcont1= xcomp1 * pcontado;
        Double xcomcont2= xcomp2 * pcontado;
        Double xcomcont3= xcomp3 * pcontado;

        compContt1.setText(xcomcont1.toString());
        compCont2.setText(xcomcont2.toString());
        compCont3.setText(xcomcont3.toString());


        Double xtre1 = 0.0;
        Double xtre2 = ingreso1 * ptreinta;
        Double xtre3 = ing2 * ptreinta;

        thirty1.setText(xtre1.toString());
        thirty2.setText(xtre2.toString());
        thirty3.setText(xtre3.toString());

    }
    public void anteriorMain(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

}