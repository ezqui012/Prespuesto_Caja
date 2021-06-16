package com.example.proyecto_flujo_caja.Models;

public class Ventas {
    private Double vcontado, vtreinta, vsesenta, vinteres, vincobrabilidad;

    public Ventas(Double vcontado, Double vtreinta, Double vsesenta, Double vinteres, Double vincobrabilidad) {
        this.vcontado = vcontado;
        this.vtreinta = vtreinta;
        this.vsesenta = vsesenta;
        this.vinteres = vinteres;
        this.vincobrabilidad = vincobrabilidad;
    }

    public Double getVcontado() {
        return vcontado;
    }

    public void setVcontado(Double vcontado) {
        this.vcontado = vcontado;
    }

    public Double getVtreinta() {
        return vtreinta;
    }

    public void setVtreinta(Double vtreinta) {
        this.vtreinta = vtreinta;
    }

    public Double getVsesenta() {
        return vsesenta;
    }

    public void setVsesenta(Double vsesenta) {
        this.vsesenta = vsesenta;
    }

    public Double getVinteres() {
        return vinteres;
    }

    public void setVinteres(Double vinteres) {
        this.vinteres = vinteres;
    }

    public Double getVincobrabilidad() {
        return vincobrabilidad;
    }

    public void setVincobrabilidad(Double vincobrabilidad) {
        this.vincobrabilidad = vincobrabilidad;
    }
}
