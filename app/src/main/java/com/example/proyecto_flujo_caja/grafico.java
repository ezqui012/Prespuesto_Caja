package com.example.proyecto_flujo_caja;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;


import java.util.ArrayList;


public class grafico extends AppCompatActivity {
    private PieChart pieChart;
    private BarChart barChart;
    private TextView text,text2;
    private String p1,p2,p3,p4;
    private Double total1,total2,total3;
    public int[]totales= new int[3];
    private Button btnVolver;
    private String[]months= new String[]{"Enero","Febrero", "Marzo"};
    private int[]sale= new int[]{25,30,32,50};
    private int[]colors= new int[]{Color.BLACK,Color.BLUE,Color.GREEN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        total1=(Double) getIntent().getSerializableExtra("sum1");
        total2=(Double) getIntent().getSerializableExtra("sum2");
        total3=(Double) getIntent().getSerializableExtra("sum3");
        totales[0]=(int) Math.round(total1);
        totales[1]=(int) Math.round(total2);;
        totales[2]=(int) Math.round(total3);

       barChart=(BarChart)findViewById(R.id.barChart);

       createCharts();
       btnVolver=(Button)findViewById(R.id.btnVolver);
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
    public void onClickF(View view){
        Intent flujo = new Intent(this, MainActivity.class);
        startActivity(flujo);
    }





}