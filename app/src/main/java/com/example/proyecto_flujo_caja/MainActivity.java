package com.example.proyecto_flujo_caja;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyecto_flujo_caja.Models.Company;
import com.example.proyecto_flujo_caja.Models.FlujoCajaProy;
import com.example.proyecto_flujo_caja.Models.InteresGasto;
import com.example.proyecto_flujo_caja.Models.SalesProjection;
import com.example.proyecto_flujo_caja.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firestore.v1.CreateDocumentRequest;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Nullable;

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

    private String compra1, compra2, compra3;
    private String iva1, iva2, iva3;
    private String iGasto1, iGasto2, iGasto3;
    private String iComp1, iComp2, iComp3;

    private Double it1, it2, it3;
    private Double iue1, iue2, iue3;
    private Double totIt1, totIt2, totIt3;

    private String comprasB1, comprasB2, comprasB3;
    private String ib30g1, ib30g2, ib30g3;
    private String r30g2, r30g3;
    private String ib60g1, ib60g2, ib60g3;
    private String r60g3;

    private FlujoCajaProy flujo;

    private static  final int CREATEPDF = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getCompanyInfo();
        loadInfoCaja();
        loadSolds();
        cargarCompras();
        cargarIva();
        cargarIt();
        cargarInteresG();

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

    public void crearReporte(View view){
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        intent.putExtra(Intent.EXTRA_TITLE, "Reporte_Flujo_Caja_Proyectado");
        //startActivity(intent);
        startActivityForResult(intent, CREATEPDF);
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
                            newFlujoCaja();
                        }
                    }
                });
    }

    private void newFlujoCaja(){
        flujo = new FlujoCajaProy(ingreosoOP, gastosOP, 0.0, 0.0, fuentes, usos, 16000.0);
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

    private void cargarCompras(){
        db.collection("compras").document("a").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    compra1 = documentSnapshot.getString("comp1");
                    compra2 = documentSnapshot.getString("comp2");
                    compra3 = documentSnapshot.getString("comp3");
                }
            }
        });
    }

    private void cargarIva(){
        db.collection("Iva").document("a").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    iva1 = documentSnapshot.getString("iva1");
                    iva2 = documentSnapshot.getString("iva2");
                    iva3 = documentSnapshot.getString("iva3");
                    iGasto1 = documentSnapshot.getString("gastosop1");
                    iGasto2 = documentSnapshot.getString("gastosop2");
                    iGasto3 = documentSnapshot.getString("gastosop3");
                    iComp1 = documentSnapshot.getString("compras1");
                    iComp2 = documentSnapshot.getString("compras2");
                    iComp3 = documentSnapshot.getString("compras3");
                }
            }
        });
    }

    private void cargarIt(){
        db.collection("It").document("a").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    it1 = Double.parseDouble(documentSnapshot.getString("it1"));
                    it2 = Double.parseDouble(documentSnapshot.getString("it2"));
                    it3 = Double.parseDouble(documentSnapshot.getString("it3"));
                    iue1 = Double.parseDouble(documentSnapshot.getString("iue1"));
                    iue2 = Double.parseDouble(documentSnapshot.getString("iue2"));
                    iue3 = Double.parseDouble(documentSnapshot.getString("iue3"));
                    totIt1 = it1 - iue1;
                    totIt2 = it2 - iue2;
                    totIt3 = it3 - iue3;
                }
            }
        });
    }

    private void cargarInteresG(){
        db.collection("interesGasto").document("2UOhIn6STMTCQBGjA9Sk").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    comprasB1 = documentSnapshot.getString("igFebruary");
                    comprasB2 = documentSnapshot.getString("igMarch");
                    comprasB3 = documentSnapshot.getString("igApril");
                    ib30g1 = documentSnapshot.getString("ibFebruary");
                    ib30g2 = documentSnapshot.getString("ibMarch");
                    ib30g3 = documentSnapshot.getString("ibApril");
                    r30g2 = documentSnapshot.getString("r30March");
                    r30g3 = documentSnapshot.getString("r30April");
                    ib60g1 = documentSnapshot.getString("ib60February");
                    ib60g2 = documentSnapshot.getString("ib60March");
                    ib60g3 = documentSnapshot.getString("ib60April");
                    r60g3 = documentSnapshot.getString("r60April");
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CREATEPDF){
            if(data.getData() != null){
                Uri uri = data.getData();
                PdfDocument pdfDocument = new PdfDocument();
                Paint paint = new Paint();
                PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(1240, 1754, 1).create();
                PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                Canvas canvas = page.getCanvas();
                //TITULO
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(36f);
                paint.setFakeBoldText(true);
                canvas.drawText("REPORTE FLUJO DE CAJA PROYECTADO", pageInfo.getPageWidth()/2, 50, paint);
                //VENTAS
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(30f);
                paint.setFakeBoldText(true);
                canvas.drawText("Ventas", 50, 80, paint);
                canvas.drawText(" ", 50, 90, paint);
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(24f);
                paint.setFakeBoldText(false);
                canvas.drawText("Mes: "+february.getMonth(), 50, 125, paint);
                canvas.drawText("Unidades vendidas: "+february.getSold_units(), 50, 155, paint);
                canvas.drawText("Precio unitario: "+february.getUnit_price(), 50, 185, paint);
                canvas.drawText("Ingreso Bruto: "+february.getGross_income(), 50, 215, paint);
                canvas.drawText("Compras Brutas: "+compra1, 50, 245, paint);
                canvas.drawLine(48, 130, pageInfo.getPageWidth()-100, 140, paint);
                canvas.drawLine(48, 160, pageInfo.getPageWidth()-100, 170, paint);
                canvas.drawLine(48, 190, pageInfo.getPageWidth()-100, 200, paint);
                canvas.drawLine(48, 220, pageInfo.getPageWidth()-100, 230, paint);
                canvas.drawLine(48, 250, pageInfo.getPageWidth()-100, 260, paint);
                canvas.drawText(" ", 50, 275, paint);

                canvas.drawText("Mes: "+march.getMonth(), 50, 305, paint);
                canvas.drawText("Unidades vendidas: "+march.getSold_units(), 50, 335, paint);
                canvas.drawText("Precio unitario: "+march.getUnit_price(), 50, 365, paint);
                canvas.drawText("Ingreso Bruto: "+march.getGross_income(), 50, 395, paint);
                canvas.drawText("Compras Brutas: "+compra2, 50, 425, paint);
                canvas.drawLine(48, 310, pageInfo.getPageWidth()-100, 320, paint);
                canvas.drawLine(48, 340, pageInfo.getPageWidth()-100, 350, paint);
                canvas.drawLine(48, 370, pageInfo.getPageWidth()-100, 380, paint);
                canvas.drawLine(48, 400, pageInfo.getPageWidth()-100, 410, paint);
                canvas.drawLine(48, 430, pageInfo.getPageWidth()-100, 440, paint);
                canvas.drawText(" ", 50, 455, paint);

                canvas.drawText("Mes: "+april.getMonth(), 50, 485, paint);
                canvas.drawText("Unidades vendidas: "+april.getSold_units(), 50, 515, paint);
                canvas.drawText("Precio unitario: "+april.getUnit_price(), 50, 545, paint);
                canvas.drawText("Ingreso Bruto: "+april.getGross_income(), 50, 575, paint);
                canvas.drawText("Compras Brutas: "+compra3, 50, 605, paint);
                canvas.drawLine(48, 490, pageInfo.getPageWidth()-100, 500, paint);
                canvas.drawLine(48, 520, pageInfo.getPageWidth()-100, 530, paint);
                canvas.drawLine(48, 550, pageInfo.getPageWidth()-100, 560, paint);
                canvas.drawLine(48, 580, pageInfo.getPageWidth()-100, 590, paint);
                canvas.drawLine(48, 610, pageInfo.getPageWidth()-100, 620, paint);
                canvas.drawText(" ", 50, 635, paint);

                //IVA
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(30f);
                paint.setFakeBoldText(true);
                canvas.drawText("IVA", 50, 640, paint);
                canvas.drawText(" ", 50, 660, paint);
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(24f);
                paint.setFakeBoldText(false);
                canvas.drawText("Mes: "+february.getMonth(), 50, 690, paint);
                canvas.drawText("Compras materia prima: "+iComp1, 50, 720, paint);
                canvas.drawText("Gastos operativos: "+iGasto1, 50, 750, paint);
                canvas.drawText("Saldo a favor del fisco: "+iva1, 50, 780, paint);
                canvas.drawLine(48, 695, pageInfo.getPageWidth()-100, 705, paint);
                canvas.drawLine(48, 725, pageInfo.getPageWidth()-100, 735, paint);
                canvas.drawLine(48, 755, pageInfo.getPageWidth()-100, 765, paint);
                canvas.drawLine(48, 785, pageInfo.getPageWidth()-100, 795, paint);
                canvas.drawText(" ", 50, 810, paint);

                canvas.drawText("Mes: "+march.getMonth(), 50, 840, paint);
                canvas.drawText("Compras materia prima: "+iComp2, 50, 870, paint);
                canvas.drawText("Gastos operativos: "+iGasto2, 50, 900, paint);
                canvas.drawText("Saldo a favor del fisco: "+iva2, 50, 930, paint);
                canvas.drawLine(48, 845, pageInfo.getPageWidth()-100, 855, paint);
                canvas.drawLine(48, 875, pageInfo.getPageWidth()-100, 885, paint);
                canvas.drawLine(48, 905, pageInfo.getPageWidth()-100, 915, paint);
                canvas.drawLine(48, 935, pageInfo.getPageWidth()-100, 945, paint);
                canvas.drawText(" ", 50, 960, paint);

                canvas.drawText("Mes: "+april.getMonth(), 50, 990, paint);
                canvas.drawText("Compras materia prima: "+iComp3, 50, 1020, paint);
                canvas.drawText("Gastos operativos: "+iGasto3, 50, 1050, paint);
                canvas.drawText("Saldo a favor del fisco: "+iva3, 50, 1080, paint);
                canvas.drawLine(48, 995, pageInfo.getPageWidth()-100, 1005, paint);
                canvas.drawLine(48, 1025, pageInfo.getPageWidth()-100, 1035, paint);
                canvas.drawLine(48, 1055, pageInfo.getPageWidth()-100, 1065, paint);
                canvas.drawLine(48, 1085, pageInfo.getPageWidth()-100, 1095, paint);
                canvas.drawText(" ", 50, 1110, paint);

                //IT
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(30f);
                paint.setFakeBoldText(true);
                canvas.drawText("IT", 50, 1115, paint);
                canvas.drawText(" ", 50, 1135, paint);
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setTextSize(24f);
                paint.setFakeBoldText(false);
                canvas.drawText("Mes: "+february.getMonth(), 50, 1165, paint);
                canvas.drawText("IT del periodo: "+it1, 50, 1195, paint);
                canvas.drawText("IUE: "+iue1, 50, 1225, paint);
                canvas.drawText("Saldo a favor del fisco: "+totIt1, 50, 1255, paint);
                canvas.drawLine(48, 1170, pageInfo.getPageWidth()-100, 1180, paint);
                canvas.drawLine(48, 1200, pageInfo.getPageWidth()-100, 1210, paint);
                canvas.drawLine(48, 1230, pageInfo.getPageWidth()-100, 1240, paint);
                canvas.drawLine(48, 1260, pageInfo.getPageWidth()-100, 1270, paint);
                canvas.drawText(" ", 50, 1285, paint);

                canvas.drawText("Mes: "+march.getMonth(), 50, 1315, paint);
                canvas.drawText("IT del periodo: "+it2, 50, 1345, paint);
                canvas.drawText("IUE: "+iue2, 50, 1375, paint);
                canvas.drawText("Saldo a favor del fisco: "+totIt2, 50, 1405, paint);
                canvas.drawLine(48, 1320, pageInfo.getPageWidth()-100, 1330, paint);
                canvas.drawLine(48, 1350, pageInfo.getPageWidth()-100, 1360, paint);
                canvas.drawLine(48, 1380, pageInfo.getPageWidth()-100, 1390, paint);
                canvas.drawLine(48, 1410, pageInfo.getPageWidth()-100, 1420, paint);
                canvas.drawText(" ", 50, 1435, paint);

                canvas.drawText("Mes: "+april.getMonth(), 50, 1465, paint);
                canvas.drawText("IT del periodo: "+it3, 50, 1495, paint);
                canvas.drawText("IUE: "+iue3, 50, 1525, paint);
                canvas.drawText("Saldo a favor del fisco: "+totIt3, 50, 1555, paint);
                canvas.drawLine(48, 1470, pageInfo.getPageWidth()-100, 1480, paint);
                canvas.drawLine(48, 1500, pageInfo.getPageWidth()-100, 1510, paint);
                canvas.drawLine(48, 1530, pageInfo.getPageWidth()-100, 1540, paint);
                canvas.drawLine(48, 1560, pageInfo.getPageWidth()-100, 1570, paint);
                canvas.drawText(" ", 50, 1585, paint);

                pdfDocument.finishPage(page);

                //Pagina 2
                Paint paint2 = new Paint();
                PdfDocument.PageInfo pageInfo2 = new PdfDocument.PageInfo.Builder(1240, 1754, 2).create();
                PdfDocument.Page page2 = pdfDocument.startPage(pageInfo2);
                Canvas canvas2 = page2.getCanvas();

                //Interes comercial
                paint2.setTextAlign(Paint.Align.LEFT);
                paint2.setTextSize(30f);
                paint2.setFakeBoldText(true);
                canvas2.drawText("Interes Comercial", 50, 80, paint2);
                canvas2.drawText(" ", 50, 90, paint2);
                paint2.setTextAlign(Paint.Align.LEFT);
                paint2.setTextSize(24f);
                paint2.setFakeBoldText(false);
                canvas2.drawText("Mes: "+february.getMonth(), 50, 125, paint2);
                canvas2.drawText("Compras brutas: "+comprasB1, 50, 155, paint2);
                canvas2.drawText("Ingreso bruto 30 dias: "+ib30g1, 50, 185, paint2);
                canvas2.drawText("Ingreso Bruto 60 dias: "+ib60g1, 50, 215, paint2);
                canvas2.drawLine(48, 130, pageInfo.getPageWidth()-100, 140, paint2);
                canvas2.drawLine(48, 160, pageInfo.getPageWidth()-100, 170, paint2);
                canvas2.drawLine(48, 190, pageInfo.getPageWidth()-100, 200, paint2);
                canvas2.drawLine(48, 220, pageInfo.getPageWidth()-100, 230, paint2);
                canvas2.drawText(" ", 50, 275, paint2);

                canvas2.drawText("Mes: "+march.getMonth(), 50, 305, paint2);
                canvas2.drawText("Compras brutas: "+comprasB2, 50, 335, paint2);
                canvas2.drawText("Ingreso bruto 30 dias: "+ib30g2, 50, 365, paint2);
                canvas2.drawText("Recuperacion 30 dias: "+r30g2, 50, 395, paint2);
                canvas2.drawText("Ingreso Bruto 60 dias: "+ib60g2, 50, 425, paint2);
                canvas2.drawLine(48, 310, pageInfo.getPageWidth()-100, 320, paint2);
                canvas2.drawLine(48, 340, pageInfo.getPageWidth()-100, 350, paint2);
                canvas2.drawLine(48, 370, pageInfo.getPageWidth()-100, 380, paint2);
                canvas2.drawLine(48, 400, pageInfo.getPageWidth()-100, 410, paint2);
                canvas2.drawLine(48, 430, pageInfo.getPageWidth()-100, 440, paint2);
                canvas2.drawText(" ", 50, 475, paint2);

                canvas2.drawText("Mes: "+april.getMonth(), 50, 505, paint2);
                canvas2.drawText("Compras brutas: "+comprasB3, 50, 535, paint2);
                canvas2.drawText("Ingreso bruto 30 dias: "+ib30g3, 50, 565, paint2);
                canvas2.drawText("Recuperacion 30 dias: "+r30g3, 50, 595, paint2);
                canvas2.drawText("Ingreso Bruto 60 dias: "+ib60g3, 50, 625, paint2);
                canvas2.drawText("Recuperacion 60 dias: "+r60g3, 50, 655, paint2);
                canvas2.drawLine(48, 510, pageInfo.getPageWidth()-100, 520, paint2);
                canvas2.drawLine(48, 540, pageInfo.getPageWidth()-100, 550, paint2);
                canvas2.drawLine(48, 570, pageInfo.getPageWidth()-100, 580, paint2);
                canvas2.drawLine(48, 600, pageInfo.getPageWidth()-100, 610, paint2);
                canvas2.drawLine(48, 630, pageInfo.getPageWidth()-100, 640, paint2);
                canvas2.drawLine(48, 660, pageInfo.getPageWidth()-100, 670, paint2);
                canvas2.drawText(" ", 50, 705, paint2);

                //Flujo de caja
                paint2.setTextAlign(Paint.Align.LEFT);
                paint2.setTextSize(30f);
                paint2.setFakeBoldText(true);
                canvas2.drawText("Flujo de caja Proyectado", 50, 755, paint2);
                canvas2.drawText(" ", 50, 785, paint2);
                paint2.setTextAlign(Paint.Align.LEFT);
                paint2.setTextSize(24f);
                paint2.setFakeBoldText(false);
                canvas2.drawText("Flujo de efectivo proyectado por actividades de operacion:  "+flujo.getActividadesOp(), 50, 815, paint2);
                canvas2.drawText("Ingresos de operacion: "+flujo.getIngresosdOp(), 50, 845, paint2);
                canvas2.drawText("(-) Gastos de operacion: "+flujo.getGastosOp(), 50, 875, paint2);
                canvas2.drawLine(48, 850, pageInfo.getPageWidth()-100, 860, paint2);
                canvas2.drawLine(48, 880, pageInfo.getPageWidth()-100, 890, paint2);
                canvas2.drawText(" ", 50, 905, paint2);

                canvas2.drawText("Flujo de efectivo por actividades de invercion:  "+flujo.getActividadesI(), 50, 935, paint2);
                canvas2.drawText("Ingresos de capital: "+flujo.getIngresosC(), 50, 965, paint2);
                canvas2.drawText("(-) Gastos de gastos de capital: "+flujo.getGastosC(), 50, 995, paint2);
                canvas2.drawLine(48, 970, pageInfo.getPageWidth()-100, 980, paint2);
                canvas2.drawLine(48, 1000, pageInfo.getPageWidth()-100, 1010, paint2);
                canvas2.drawText(" ", 50, 1025, paint2);

                canvas2.drawText("Flujo de efectivo por actividades de financiamiento:  "+flujo.getActividadFin(), 50, 1055, paint2);
                canvas2.drawText("Fuentes: "+flujo.getFuentes(), 50, 1085, paint2);
                canvas2.drawText("(-) Usos: "+flujo.getUsos(), 50, 1115, paint2);
                canvas2.drawLine(48, 1090, pageInfo.getPageWidth()-100, 1100, paint2);
                canvas2.drawLine(48, 1120, pageInfo.getPageWidth()-100, 1130, paint2);
                canvas2.drawText(" ", 50, 1145, paint2);

                canvas2.drawText("Incremento proyectado del efectivo del periodo:  "+flujo.getIncremento(), 50, 1175, paint2);
                canvas2.drawText("Efectivo al inicio del periodo: "+flujo.getEfectivoIn(), 50, 1205, paint2);
                canvas2.drawText("Saldo efectivo final proyectado "+flujo.getSaldoProy(), 50, 1235, paint2);
                canvas2.drawLine(48, 1180, pageInfo.getPageWidth()-100, 1190, paint2);
                canvas2.drawLine(48, 1210, pageInfo.getPageWidth()-100, 1220, paint2);
                canvas2.drawLine(48, 1240, pageInfo.getPageWidth()-100, 1250, paint2);
                canvas2.drawText(" ", 50, 1265, paint2);

                pdfDocument.finishPage(page2);
                grabarPDF(uri, pdfDocument);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void grabarPDF(Uri uri, PdfDocument pdfDocument){
        try{
            BufferedOutputStream stream = new BufferedOutputStream(getContentResolver().openOutputStream(uri));
            pdfDocument.writeTo(stream);
            pdfDocument.close();
            stream.flush();
            Toast.makeText(this, "PDF creado", Toast.LENGTH_LONG);
        }catch(FileNotFoundException fe){
            Toast.makeText(this, "Error archivo no encontrado", Toast.LENGTH_LONG);
        }catch (IOException ioe){
            Toast.makeText(this, "Error de entrada o salida", Toast.LENGTH_LONG);
        }catch (Exception ex){
            Toast.makeText(this, "Ocurrio un error intente de nuevo", Toast.LENGTH_LONG);
        }
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