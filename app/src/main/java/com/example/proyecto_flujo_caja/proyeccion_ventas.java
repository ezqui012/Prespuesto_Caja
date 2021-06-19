package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.proyecto_flujo_caja.Models.Ventas;

public class proyeccion_ventas extends AppCompatActivity {
    private Ventas venta;
    Spinner opciones;
    TextView mes1,mes2, mes3, ib1, ib2, ib3, pcont1,pcont2,pcont3, treint1,treint2,treint3, sesent3;
    EditText dmes1,dmes2,dmes3, precio1, precio2, precio3, vcont, v30, v60, vinco;
    Button calcu, sig, cancel;
    private Double vcontado, vtreinta, vsesenta, vincobrabilidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyeccion_ventas);

        vcont =findViewById(R.id.vcont);
        v30 =findViewById(R.id.v30);
        v60 =findViewById(R.id.v60);
        vinco= findViewById(R.id.vinco);

        mes1 = findViewById(R.id.vmes1);
        mes2 = findViewById(R.id.vmes2);
        mes3 = findViewById(R.id.vmes3);
        dmes1= findViewById(R.id.datomes1);
        dmes2 = findViewById(R.id.datomes2);
        dmes3 = findViewById(R.id.datomes3);
        precio1 = findViewById(R.id.datoprecio1);
        precio2 = findViewById(R.id.precio2);
        precio3 = findViewById(R.id.precio3);
        pcont1=findViewById(R.id.cont1);
        pcont2=findViewById(R.id.cont2);
        pcont3=findViewById(R.id.cont3);
        treint1=findViewById(R.id.treint1);
        treint2=findViewById(R.id.treint2);
        treint3=findViewById(R.id.treint3);
        sesent3=findViewById(R.id.sesent3);
        calcu = findViewById(R.id.btn_calcu);
        sig = findViewById(R.id.sig);
        cancel = findViewById(R.id.vcancel);
        ib1 =findViewById(R.id.ib1);
        ib2 = findViewById(R.id.ib2);
        ib3 = findViewById(R.id.ib3);

        opciones = findViewById(R.id.sp1);

        String[] opc ={"Trimestre I", "Trimestre II","Trimestre III","Trimestre IV"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        opciones.setAdapter(adapter);

    }
    public void Calcular (View view){
        sig.setVisibility(View.VISIBLE);

        String dtsmes1 = dmes1.getText().toString();
        String dtsmes2 = dmes2.getText().toString();
        String dtsmes3 = dmes3.getText().toString();

        String dtsprecio= precio1.getText().toString();
        String dtsprecio2= precio2.getText().toString();
        String dtsprecio3= precio3.getText().toString();


        Double dtmes1 =Double.parseDouble(dtsmes1);
        Double dtmes2 =Double.parseDouble(dtsmes2);
        Double dtmes3 =Double.parseDouble(dtsmes3);

        Double prec =Double.parseDouble(dtsprecio);
        Double prec2 =Double.parseDouble(dtsprecio2);
        Double prec3 =Double.parseDouble(dtsprecio3);



        String seleccion = opciones.getSelectedItem().toString();

        final String cont = vcont.getText().toString();
        final String trent = v30.getText().toString();
        final String sesent = v60.getText().toString();
        final String inco = vinco.getText().toString();

        if(TextUtils.isEmpty(cont)){ vcont.setError("Este campo es requerido");return; }
        if(TextUtils.isEmpty(trent)){v30.setError("Este campo es requerido");return; }
        if(TextUtils.isEmpty(sesent)){v60.setError("Este campo es requerido");return; }
        if(TextUtils.isEmpty(inco)){vinco.setError("Este campo es requerido");return; }


        vcontado = Double.parseDouble(cont);
        vtreinta = Double.parseDouble(trent);
        vsesenta = Double.parseDouble(sesent);
        vincobrabilidad= Double.parseDouble(inco);


        venta = new Ventas(vcontado,vtreinta,vsesenta,vincobrabilidad);

        if(seleccion.equals("Trimestre I")){
            mes1.setText("ENERO");
            mes2.setText("FEBRERO");
            mes3.setText("MARZO");

        }else if (seleccion.equals("Trimestre II")){
            mes1.setText("ABRIL");
            mes2.setText("MAYO");
            mes3.setText("JUNIO");

        }else if (seleccion.equals("Trimestre III")){
            mes1.setText("JULIO");
            mes2.setText("AGOSTO");
            mes3.setText("SEPTEMBRE");

        }else if (seleccion.equals("Trimestre IV")){
            mes1.setText("OCTUBRE");
            mes2.setText("NOVIEMBRE");
            mes3.setText("DICIEMBRE");

        }
        Double ingreso1 = dtmes1 * prec;
        Double ing2 = dtmes2*prec2;
        Double ing3 = dtmes3*prec3;


        ib1.setText(ingreso1.toString()+" Bs");
        ib2.setText(ing2.toString() +" Bs");
        ib3.setText(ing3.toString() +" Bs");

        Double xcont1 =  ingreso1 * vcontado;
        Double xcont2 =  ing2 * vcontado;
        Double xcont3 =  ing3 * vcontado;

        pcont1.setText(xcont1.toString());
        pcont2.setText(xcont2.toString());
        pcont3.setText(xcont3.toString());

        Double xtre1 = 0.0;
        Double xtre2 = Math.ceil((ingreso1 * vtreinta)*(1-vincobrabilidad));
        Double xtre3 = Math.ceil((ing2 * vtreinta)*(1-vincobrabilidad));

        treint1.setText(xtre1.toString());
        treint2.setText(xtre2.toString());
        treint3.setText(xtre3.toString());

        Double xsesent= Math.ceil((ingreso1*vsesenta)*(1-vincobrabilidad));

        sesent3.setText(xsesent.toString());


    }
}