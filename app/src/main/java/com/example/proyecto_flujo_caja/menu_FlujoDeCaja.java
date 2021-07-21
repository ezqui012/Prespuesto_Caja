package com.example.proyecto_flujo_caja;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Nullable;

public class menu_FlujoDeCaja extends AppCompatActivity {
    Button sem, anual, bia, tria, cuatri, quin;
    Button reporte, grafico;

    private Double saldo1,saldo5,saldoSemestral,saldoAnual;
    private static  final int CREATEPDF = 1;
    private Double totalAf3, totalAi3, totalAo3, totalIncre3;
    private Double totalAf5, totalAi5, totalAo5, totalIncre5;
    private String totalAf2, totalAi2, totalAo2, totalIncre2, saldoProy2, inicio2;
    private String totalAf1, totalAi1, totalAo1, totalIncre1, saldoProy1, inicio1;
    private Double efectivoIn, fuentes3, gastosC3, gastosOP3, ingresosC3, ingresosOP3, saldoPory3, usos3;
    private Double efectivoIn5, fuentes5, gastosC5, gastosOP5, ingresosC5, ingresosOP5, saldoPory5, usos5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_flujo_de_caja);
        obtenerDatos();
        sem= findViewById(R.id.btnsem);
        anual=findViewById(R.id.btnanual);
        grafico=findViewById(R.id.btnGrafico);
        quin=findViewById(R.id.btnquin);
        reporte = findViewById(R.id.btnPdf);

        sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FlujoSemestral.class));
            }
        });





        anual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FlujoAnual.class));
            }
        });

        quin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), flujo_caja5.class));
            }
        });

        reporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("application/pdf");
                intent.putExtra(Intent.EXTRA_TITLE, "Comparación_Flujo_de_caja");
                startActivityForResult(intent, CREATEPDF);
            }
        });
    }
    public void obtenerDatos()
    {
        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("flujoCaja").document("wwACBFEC1JO1Ls0ZUueE");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                saldo1=documentSnapshot.getDouble("saldoProy");

            }
        });
        DocumentReference documentReferenceSemestral= FirebaseFirestore.getInstance().collection("FlujoSemestral").document("a");
        documentReferenceSemestral.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                saldoSemestral=Double.parseDouble(documentSnapshot.getString("saldofin"));
            }
        });
        DocumentReference documentReferenceAnual= FirebaseFirestore.getInstance().collection("FlujoAnual").document("a");
        documentReferenceAnual.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                saldoAnual=Double.parseDouble(documentSnapshot.getString("nine"));
            }
        });
        DocumentReference documentReference5= FirebaseFirestore.getInstance().collection("flujoCaja5").document("Pi2OveaASqfUliSSRlDN\n");
        documentReference5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                saldo5=documentSnapshot.getDouble("saldoProy");
            }
        });

    }

    public void siguienteGrafico(View view){
        Intent graficos = new Intent(this, graficoQuinquenal.class);
        graficos.putExtra("saldoProy",saldo1);
        graficos.putExtra("saldoFin",saldoSemestral);
        graficos.putExtra("nine",saldoAnual);
        graficos.putExtra("saldoProy5",saldo5);
        startActivity(graficos);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CREATEPDF){
            if(data.getData() != null){
                Uri uri = data.getData();
                DocumentReference documentReference= FirebaseFirestore.getInstance().collection("flujoCaja").document("wwACBFEC1JO1Ls0ZUueE");
                documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        efectivoIn = documentSnapshot.getDouble("efectivoIn");
                        fuentes3 = documentSnapshot.getDouble("fuentes");
                        gastosC3 = documentSnapshot.getDouble("gastosC");
                        gastosOP3 = documentSnapshot.getDouble("gastosOp");
                        ingresosC3 = documentSnapshot.getDouble("ingresosC");
                        ingresosOP3 = documentSnapshot.getDouble("ingresosdOp");
                        saldoPory3 = documentSnapshot.getDouble("saldoProy");
                        usos3 = documentSnapshot.getDouble("usos");
                        totalAf3 = fuentes3 - usos3;
                        totalAi3 = ingresosC3 - gastosC3;
                        totalAo3 = ingresosOP3 - gastosOP3;
                        totalIncre3 = totalAf3 + totalAo3+ totalAi3;

                        DocumentReference documentReference1 = FirebaseFirestore.getInstance().collection("FlujoSemestral").document("a");
                        documentReference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                inicio2 = documentSnapshot.getString("efeinicio");
                                saldoProy2 = documentSnapshot.getString("saldofin");
                                totalAf2 = documentSnapshot.getString("totalAF");
                                totalAi2 = documentSnapshot.getString("totalAI");
                                totalAo2 = documentSnapshot.getString("totalAO");
                                totalIncre2 = documentSnapshot.getString("totalIncre");

                                DocumentReference documentReference2 = FirebaseFirestore.getInstance().collection("FlujoAnual").document("a");
                                documentReference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        inicio1 = documentSnapshot.getString("eight");
                                        saldoProy1 = documentSnapshot.getString("nine");
                                        totalAf1 = documentSnapshot.getString("total3");
                                        totalAi1 = documentSnapshot.getString("total2");
                                        totalAo1 = documentSnapshot.getString("total1");
                                        totalIncre1 = documentSnapshot.getString("seven");

                                        DocumentReference documentReference3 = FirebaseFirestore.getInstance().collection("flujoCaja5").document("Pi2OveaASqfUliSSRlDN");
                                        documentReference3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                efectivoIn5 = documentSnapshot.getDouble("efectivoIn");
                                                fuentes5 = documentSnapshot.getDouble("fuentes");
                                                gastosC5 = documentSnapshot.getDouble("gastosC");
                                                gastosOP5 = documentSnapshot.getDouble("gastosOp");
                                                ingresosC5 = documentSnapshot.getDouble("ingresosC");
                                                ingresosOP5 = documentSnapshot.getDouble("ingresosdOp");
                                                saldoPory5 = documentSnapshot.getDouble("saldoProy");
                                                usos5 = documentSnapshot.getDouble("usos");
                                                totalAf5 = fuentes5 - usos5;
                                                totalAi5 = ingresosC5 - gastosC5;
                                                totalAo5 = ingresosOP5 - gastosOP5;
                                                totalIncre5 = totalAf5 + totalAo5+ totalAi5;
                                                generarArchivo(uri);
                                            }
                                        });
                                    }
                                });
                            }
                        });

                    }
                });
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void generarArchivo(Uri uri){
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

        //Trimestral
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(30f);
        paint.setFakeBoldText(true);
        canvas.drawText("Flujo de caja Trimestral", 50, 90, paint);
        canvas.drawText(" ", 50, 100, paint);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(24f);
        paint.setFakeBoldText(false);

        canvas.drawText("Flujo de efectivo proyectado por actividades de operacion: " + totalAo3, 50, 130, paint);
        canvas.drawText("Flujo de efectivo por actividades de invercion: " + totalAi3, 50, 160, paint);
        canvas.drawText("Flujo de efectivo por actividades de financiamiento: " + totalAf3, 50, 190, paint);
        canvas.drawText("Incremento proyectado del efectivo del periodo: " + totalIncre3, 50, 220, paint);
        canvas.drawText("Efectivo al inicio del periodo: " + efectivoIn, 50, 250, paint);
        canvas.drawText("Saldo efectivo final proyectado " + saldoPory3, 50, 280, paint);
        canvas.drawLine(48, 135, pageInfo.getPageWidth()-100, 145, paint);
        canvas.drawLine(48, 165, pageInfo.getPageWidth()-100, 175, paint);
        canvas.drawLine(48, 195, pageInfo.getPageWidth()-100, 205, paint);
        canvas.drawLine(48, 225, pageInfo.getPageWidth()-100, 235, paint);
        canvas.drawLine(48, 255, pageInfo.getPageWidth()-100, 265, paint);
        canvas.drawLine(48, 285, pageInfo.getPageWidth()-100, 295, paint);
        canvas.drawText(" ", 50, 310, paint);

        //Semestral
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(30f);
        paint.setFakeBoldText(true);
        canvas.drawText("Flujo de caja Semestral", 50, 340, paint);
        canvas.drawText(" ", 50, 370, paint);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(24f);
        paint.setFakeBoldText(false);

        canvas.drawText("Flujo de efectivo proyectado por actividades de operacion: " + totalAo2, 50, 400, paint);
        canvas.drawText("Flujo de efectivo por actividades de invercion: " + totalAi2, 50, 430, paint);
        canvas.drawText("Flujo de efectivo por actividades de financiamiento: " + totalAf2, 50, 460, paint);
        canvas.drawText("Incremento proyectado del efectivo del periodo: " + totalIncre2, 50, 490, paint);
        canvas.drawText("Efectivo al inicio del periodo: " + inicio2, 50, 520, paint);
        canvas.drawText("Saldo efectivo final proyectado " + saldoProy2, 50, 550, paint);
        canvas.drawLine(48, 405, pageInfo.getPageWidth()-100, 415, paint);
        canvas.drawLine(48, 435, pageInfo.getPageWidth()-100, 445, paint);
        canvas.drawLine(48, 465, pageInfo.getPageWidth()-100, 475, paint);
        canvas.drawLine(48, 495, pageInfo.getPageWidth()-100, 505, paint);
        canvas.drawLine(48, 525, pageInfo.getPageWidth()-100, 535, paint);
        canvas.drawLine(48, 555, pageInfo.getPageWidth()-100, 565, paint);
        canvas.drawText(" ", 50, 580, paint);

        //Anual
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(30f);
        paint.setFakeBoldText(true);
        canvas.drawText("Flujo de caja Anual", 50, 610, paint);
        canvas.drawText(" ", 50, 640, paint);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(24f);
        paint.setFakeBoldText(false);

        canvas.drawText("Flujo de efectivo proyectado por actividades de operacion: " + totalAo1, 50, 670, paint);
        canvas.drawText("Flujo de efectivo por actividades de invercion: " + totalAi1, 50, 700, paint);
        canvas.drawText("Flujo de efectivo por actividades de financiamiento: " + totalAf1, 50, 730, paint);
        canvas.drawText("Incremento proyectado del efectivo del periodo: " + totalIncre1, 50, 760, paint);
        canvas.drawText("Efectivo al inicio del periodo: " + inicio1, 50, 790, paint);
        canvas.drawText("Saldo efectivo final proyectado " + saldoProy1, 50, 820, paint);
        canvas.drawLine(48, 675, pageInfo.getPageWidth()-100, 685, paint);
        canvas.drawLine(48, 705, pageInfo.getPageWidth()-100, 715, paint);
        canvas.drawLine(48, 735, pageInfo.getPageWidth()-100, 745, paint);
        canvas.drawLine(48, 765, pageInfo.getPageWidth()-100, 775, paint);
        canvas.drawLine(48, 795, pageInfo.getPageWidth()-100, 805, paint);
        canvas.drawLine(48, 825, pageInfo.getPageWidth()-100, 835, paint);
        canvas.drawText(" ", 50, 850, paint);

        //Quincenal
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(30f);
        paint.setFakeBoldText(true);
        canvas.drawText("Flujo de caja Quinquenal", 50, 880, paint);
        canvas.drawText(" ", 50, 910, paint);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(24f);
        paint.setFakeBoldText(false);

        canvas.drawText("Flujo de efectivo proyectado por actividades de operacion: " + totalAo5, 50, 940, paint);
        canvas.drawText("Flujo de efectivo por actividades de invercion: " + totalAi5, 50, 970, paint);
        canvas.drawText("Flujo de efectivo por actividades de financiamiento: " + totalAf5, 50, 1000, paint);
        canvas.drawText("Incremento proyectado del efectivo del periodo: " + totalIncre5, 50, 1030, paint);
        canvas.drawText("Efectivo al inicio del periodo: " + efectivoIn5, 50, 1060, paint);
        canvas.drawText("Saldo efectivo final proyectado " + saldoPory5, 50, 1090, paint);
        canvas.drawLine(48, 945, pageInfo.getPageWidth()-100, 955, paint);
        canvas.drawLine(48, 975, pageInfo.getPageWidth()-100, 985, paint);
        canvas.drawLine(48, 1005, pageInfo.getPageWidth()-100, 1015, paint);
        canvas.drawLine(48, 1035, pageInfo.getPageWidth()-100, 1045, paint);
        canvas.drawLine(48, 1065, pageInfo.getPageWidth()-100, 1075, paint);
        canvas.drawLine(48, 1095, pageInfo.getPageWidth()-100, 1105, paint);
        canvas.drawText(" ", 50, 1120, paint);

        pdfDocument.finishPage(page);
        grabarPDF(uri, pdfDocument);
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
}