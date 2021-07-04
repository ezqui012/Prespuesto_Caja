package com.example.proyecto_flujo_caja.Models;

public class Financiamiento {
    private Double cuantia, tipoInteres, interes,capitalInicial, capital, amortizacion, cuota;
    private Integer meses;
    public Financiamiento(){
    }
    public Double getCuantia() {
        return cuantia;
    }

    public void setCuantia(Double cuantia) {
        this.cuantia = cuantia;
    }

    public Double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(Double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Double getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(Double capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public Double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(Double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }


}
