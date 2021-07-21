package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;

import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;


import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class graficoQuinquenal extends AppCompatActivity {
    private BarChart barChart;
    private Double total1,total2,total3,total4;
    public int[]totales= new int[4];
    private Button btnVolver;
    private String[]months= new String[]{"Trimestral","Semestral", "Anual"," Quinquenal"};
    private int[]sale= new int[]{25,30,32,50,25};
    private int[]colors= new int[]{Color.BLACK,Color.BLUE,Color.GREEN,Color.RED};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_quinquenal);

        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("flujoCaja").document("wwACBFEC1JO1Ls0ZUueE");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                total1=documentSnapshot.getDouble("saldoProy");
                DocumentReference documentReferenceSemestral= FirebaseFirestore.getInstance().collection("FlujoSemestral").document("a");
                documentReferenceSemestral.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        total2=Double.parseDouble(documentSnapshot.getString("saldofin"));
                        DocumentReference documentReferenceAnual= FirebaseFirestore.getInstance().collection("FlujoAnual").document("a");
                        documentReferenceAnual.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                total3=Double.parseDouble(documentSnapshot.getString("nine"));
                                DocumentReference documentReference5= FirebaseFirestore.getInstance().collection("flujoCaja5").document("Pi2OveaASqfUliSSRlDN");
                                documentReference5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        total4=documentSnapshot.getDouble("saldoProy");
                                        totales[0]=(int) Math.round(total1);;
                                        totales[1]=(int) Math.round(total2);
                                        totales[2]=(int) Math.round(total3);
                                        totales[3]=(int) Math.round(total4);
                                        barChart=(BarChart)findViewById(R.id.quienquenalBarChart);


                                        createCharts();
                                        btnVolver=(Button)findViewById(R.id.btnVolver);
                                    }
                                });
                            }
                        });
                    }
                });
            }

        });
    }
    public void obtenerDatos()
    {


    }


    private Chart getSameChart(Chart chart, String descripcion, int textColor, int background, int animateY){
        chart.getDescription().setText(descripcion);
        chart.getDescription().setTextSize(30);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
        legend(chart);
        return  chart;

    }
    private void legend(Chart chart){
        Legend legend= chart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setTextSize(20);
        legend.setFormSize(20);

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);

        ArrayList<LegendEntry>entries= new ArrayList<>();
        for (int i=0; i<months.length;i++){
            LegendEntry entry= new LegendEntry();
            entry.formColor=colors[i];
            entry.label=months[i];
            entries.add(entry);
        }
        legend.setCustom(entries);

    }
    private ArrayList<BarEntry>getBarEntries(){
        ArrayList<BarEntry>entries= new ArrayList<>();
        for (int i=0; i<totales.length;i++)
            entries.add(new BarEntry(i,totales[i]));
        return entries;
    }

    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setTextSize(15);
        axis.setValueFormatter(new IndexAxisValueFormatter(months));
    }
    private void axisLeftY(YAxis axis){
        axis.setSpaceTop(30);
        axis.setAxisMinimum(0);
        axis.setTextSize(20);

    }
    private void axisRight(YAxis axis){
        axis.setEnabled(false);


    }
    public void createCharts(){
        barChart=(BarChart)getSameChart(barChart,"Series",Color.RED,Color.CYAN,3000);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();

        axisX(barChart.getXAxis());
        axisLeftY(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());

    }

    private DataSet getData(DataSet dataSet){
        dataSet.setColors(colors);
        //Colores dentro del pastel
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(30);
        return dataSet;
    }
    private BarData getBarData(){
        BarDataSet barDataSet = (BarDataSet)getData(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }
    public void onClickF(View view){
        Intent flujo = new Intent(this, MainActivity.class);
        startActivity(flujo);
    }


}