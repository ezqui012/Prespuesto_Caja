package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class grafico extends AppCompatActivity {
    private PieChart pieChart;
    private BarChart barChart;
    private TextView text,text2;
    private String p1,p2,p3,p4;
    private int total1,total2,total3,total4;
    public int[]totales= new int[4];
    private String[]months= new String[]{"Enero","Febrero", "Marzo","Abril"};
    private int[]sale= new int[]{25,30,32,50};
    private int[]colors= new int[]{Color.BLACK,Color.BLUE,Color.RED,Color.GREEN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        text=(TextView)findViewById(R.id.prueba);
        text2=(TextView)findViewById(R.id.prueba2);
        obtenerDatos();

        totales[0]=30;
        totales[1]=total2;
        totales[2]=total3;
        totales[3]=total4;
        DocumentReference documentReference= FirebaseFirestore.getInstance().collection("PresupuestoCaja").document("a");
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String t1=documentSnapshot.getString("tot1");
                total1=Integer.parseInt(t1);
                text.setText(""+total1);
                int t2=Integer.parseInt(documentSnapshot.getString("tot1"));
                int t3=Integer.parseInt(documentSnapshot.getString("tot1"));
                int t4=Integer.parseInt(documentSnapshot.getString("tot1"));
            }
        });
        text2.setText("HH"+p2);

    //    barChart=(BarChart)findViewById(R.id.barChart);
  //      pieChart=(PieChart)findViewById(R.id.pieChart);
//        createCharts();









    }

    private void obtenerDatos(){
        Bundle extras = getIntent().getExtras();
        p1 = extras.getString("total");
        p2 = extras.getString("total1");
        p3 = extras.getString("tota2");
        p4 = extras.getString("tota3");
    }
    private Chart getSameChart(Chart chart, String descripcion, int textColor, int background, int animateY){
        chart.getDescription().setText(descripcion);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
        legend(chart);
        return  chart;

    }

    private void legend(Chart chart){
        Legend legend= chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
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
    private ArrayList<PieEntry>getPieEntries(){
        ArrayList<PieEntry>entries= new ArrayList<>();
        for (int i=0; i<sale.length;i++)
            entries.add(new PieEntry(sale[i]));
        return entries;
    }

    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(months));
    }
    private void axisLeftY(YAxis axis){
        axis.setSpaceTop(30);
        axis.setAxisMinimum(0);

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

     //   pieChart=(PieChart)getSameChart(pieChart, "ventas",Color.GRAY, Color.MAGENTA,3000);
       // pieChart.setHoleRadius(10);
        //pieChart.setTransparentCircleRadius(12);
       // pieChart.setData(getPieData());
     //   pieChart.invalidate();
        //pieChart.setDrawHoleEnabled(false);
    }

    private DataSet getData(DataSet dataSet){
        dataSet.setColors(colors);
        //Colores dentro del pastel
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
    }
    private BarData getBarData(){
        BarDataSet barDataSet = (BarDataSet)getData(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }

    private PieData getPieData(){
        PieDataSet pieDataSet = (PieDataSet)getData(new PieDataSet(getPieEntries(),""));
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueFormatter(new PercentFormatter());
        return new PieData(pieDataSet);
    }

}