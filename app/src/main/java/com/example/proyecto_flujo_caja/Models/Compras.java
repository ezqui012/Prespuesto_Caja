package com.example.proyecto_flujo_caja.Models;
public class Compras {
    String month1,month2, month3;
    Double comp1,comp2,comp3;

    public Compras(String month1, String month2, String month3, Double comp1, Double comp2, Double comp3) {
        this.month1 = month1;
        this.month2 = month2;
        this.month3 = month3;
        this.comp1 = comp1;
        this.comp2 = comp2;
        this.comp3 = comp3;
    }

    public String getMonth1() {
        return month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public String getMonth2() {
        return month2;
    }

    public void setMonth2(String month2) {
        this.month2 = month2;
    }

    public String getMonth3() {
        return month3;
    }

    public void setMonth3(String month3) {
        this.month3 = month3;
    }

    public Double getComp1() {
        return comp1;
    }

    public void setComp1(Double comp1) {
        this.comp1 = comp1;
    }

    public Double getComp2() {
        return comp2;
    }

    public void setComp2(Double comp2) {
        this.comp2 = comp2;
    }

    public Double getComp3() {
        return comp3;
    }

    public void setComp3(Double comp3) {
        this.comp3 = comp3;
    }
}
