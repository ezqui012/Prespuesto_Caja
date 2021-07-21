package com.example.proyecto_flujo_caja.Models;

public class Sueldos {
    String incremento, totalGainAntes,totalGainDespues,retroactivo1,
            retroactivo2, resRetroactivo1, resRetroactivo2, resAporte1, resAporte2,meses1,meses2;




    public Sueldos(
            String meses1,
            String meses2,
            String Incremento,
            String totalGainAntes,
            String totalGainDespues, String resAporte1,
            String resAporte2, String resRetroactivo1,
            String resRetroactivo2, String retroactivo1,
            String retroactivo2 ){

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

    public String getIncremento() {
        return incremento;
    }

    public void setIncremento(String incremento) {
        this.incremento = incremento;
    }

    public String getTotalGainAntes() {
        return totalGainAntes;
    }

    public void setTotalGainAntes(String totalGainAntes) {
        this.totalGainAntes = totalGainAntes;
    }

    public String getTotalGainDespues() {
        return totalGainDespues;
    }

    public void setTotalGainDespues(String totalGainDespues) {
        this.totalGainDespues = totalGainDespues;
    }

    public String getRetroactivo1() {
        return retroactivo1;
    }

    public void setRetroactivo1(String retroactivo1) {
        this.retroactivo1 = retroactivo1;
    }

    public String getRetroactivo2() {
        return retroactivo2;
    }

    public void setRetroactivo2(String retroactivo2) {
        this.retroactivo2 = retroactivo2;
    }

    public String getResRetroactivo1() {
        return resRetroactivo1;
    }

    public void setResRetroactivo1(String resRetroactivo1) {
        this.resRetroactivo1 = resRetroactivo1;
    }

    public String getResRetroactivo2() {
        return resRetroactivo2;
    }

    public void setResRetroactivo2(String resRetroactivo2) {
        this.resRetroactivo2 = resRetroactivo2;
    }

    public String getResAporte1() {
        return resAporte1;
    }

    public void setResAporte1(String resAporte1) {
        this.resAporte1 = resAporte1;
    }

    public String getResAporte2() {
        return resAporte2;
    }

    public void setResAporte2(String resAporte2) {
        this.resAporte2 = resAporte2;
    }

    public String getMeses1() {
        return meses1;
    }

    public void setMeses1(String meses1) {
        this.meses1 = meses1;
    }

    public String getMeses2() {
        return meses2;
    }

    public void setMeses2(String meses2) {
        this.meses2 = meses2;
    }
}
