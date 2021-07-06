package com.example.proyecto_flujo_caja.Models;

public class Sueldos {
    Double incremento, totalGainAntes,totalGainDespues,retroactivo1,
            retroactivo2, resRetroactivo1, resRetroactivo2, resAporte1, resAporte2;
    Integer meses1,meses2;



    public Sueldos(
            Integer meses1,
            Integer meses2,
            Double Incremento,
            Double totalGainAntes,
            Double totalGainDespues, Double resAporte1,
            Double resAporte2, Double resRetroactivo1,
            Double resRetroactivo2, Double retroactivo1,
            Double retroactivo2 ){

        this.incremento=Incremento;
        this.meses1= meses1;
        this.meses2=meses2;
        this.totalGainAntes = totalGainAntes;
        this.totalGainDespues = totalGainDespues;
        this.resAporte1= resAporte1;
        this.resAporte2 = resAporte2;
        this.resRetroactivo1= resRetroactivo1;
        this.resRetroactivo2= resRetroactivo2;
        this.retroactivo1=retroactivo1;
        this.retroactivo2=retroactivo2;
    }
    public Sueldos(){}

    public Integer getMes1(){ return meses1;}
    public void setMes1(Integer mes1){this.meses1=mes1;}
    public Integer getMes2(){ return meses2;}
    public void setMes2(Integer mes2){this.meses2=mes2;}
    public Double getGainAntes(){ return totalGainAntes;}
    public void setTotalGainAntes(Double gainAntes){this.totalGainAntes=gainAntes;}
    public Double getTotalGainDespues(){ return totalGainDespues;}
    public void setTotalGainDespues(Double gainDespues){this.totalGainDespues=gainDespues;}
    public Double getResAporte1(){ return resAporte1;}
    public void setResAporte1(Double resAp1){this.resAporte1=resAp1;}
    public Double getResAporte2(){ return resAporte2;}
    public void setResAporte2(Double resAp2){this.resAporte2=resAp2;}
    public Double getResRetroactivo1(){ return resRetroactivo1;}
    public void setResRetroactivo1(Double reRetro1){this.resRetroactivo1=reRetro1;}
    public Double getResRetroactivo2(){ return resRetroactivo2;}
    public void setResRetroactivo2(Double resRetroactivo2){this.resRetroactivo2=resRetroactivo2;}
    public Double getRetroactivo1(){ return retroactivo1;}
    public void setRetroactivo1(Double re1){this.retroactivo1=re1;}
    public Double getRetroactivo2(){ return retroactivo1;}
    public void setRetroactivo2(Double re1){this.retroactivo2=re1;}
    public Double getIncremento() {
        return incremento;
    }

    public void setIncremento(Double incremento) {
        this.incremento = incremento;
    }

}
