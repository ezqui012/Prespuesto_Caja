package com.example.proyecto_flujo_caja.Models;

public class Ventas {
   String mes1,mes2, mes3;
   Double cont1,cont2,cont3;

    public Ventas(String mes1, String mes2, String mes3, Double cont1, Double cont2, Double cont3) {
        this.mes1 = mes1;
        this.mes2 = mes2;
        this.mes3 = mes3;
        this.cont1 = cont1;
        this.cont2 = cont2;
        this.cont3 = cont3;
    }

    public String getMes1() {
        return mes1;
    }

    public void setMes1(String mes1) {
        this.mes1 = mes1;
    }

    public String getMes2() {
        return mes2;
    }

    public void setMes2(String mes2) {
        this.mes2 = mes2;
    }

    public String getMes3() {
        return mes3;
    }

    public void setMes3(String mes3) {
        this.mes3 = mes3;
    }

    public Double getCont1() {
        return cont1;
    }

    public void setCont1(Double cont1) {
        this.cont1 = cont1;
    }

    public Double getCont2() {
        return cont2;
    }

    public void setCont2(Double cont2) {
        this.cont2 = cont2;
    }

    public Double getCont3() {
        return cont3;
    }

    public void setCont3(Double cont3) {
        this.cont3 = cont3;
    }
}
