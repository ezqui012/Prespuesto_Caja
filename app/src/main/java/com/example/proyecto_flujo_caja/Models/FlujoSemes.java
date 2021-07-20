package com.example.proyecto_flujo_caja.Models;

public class FlujoSemes {
    String totalAO, totalAI, totalAF, totalIncre, efeinicio, saldofin;

    public FlujoSemes(String totalAO, String totalAI, String totalAF, String totalIncre, String efeinicio, String saldofin) {
        this.totalAO = totalAO;
        this.totalAI = totalAI;
        this.totalAF = totalAF;
        this.totalIncre = totalIncre;
        this.efeinicio = efeinicio;
        this.saldofin = saldofin;
    }

    public String getTotalAO() {
        return totalAO;
    }

    public void setTotalAO(String totalAO) {
        this.totalAO = totalAO;
    }

    public String getTotalAI() {
        return totalAI;
    }

    public void setTotalAI(String totalAI) {
        this.totalAI = totalAI;
    }

    public String getTotalAF() {
        return totalAF;
    }

    public void setTotalAF(String totalAF) {
        this.totalAF = totalAF;
    }

    public String getTotalIncre() {
        return totalIncre;
    }

    public void setTotalIncre(String totalIncre) {
        this.totalIncre = totalIncre;
    }

    public String getEfeinicio() {
        return efeinicio;
    }

    public void setEfeinicio(String efeinicio) {
        this.efeinicio = efeinicio;
    }

    public String getSaldofin() {
        return saldofin;
    }

    public void setSaldofin(String saldofin) {
        this.saldofin = saldofin;
    }
}
