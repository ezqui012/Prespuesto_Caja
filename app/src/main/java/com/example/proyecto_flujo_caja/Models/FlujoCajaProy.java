package com.example.proyecto_flujo_caja.Models;

public class FlujoCajaProy {

    private Double actividadesOp;
    private Double ingresosdOp;
    private Double gastosOp;
    private Double actividadesI;
    private Double ingresosC;
    private Double gastosC;
    private Double actividadFin;
    private Double fuentes;
    private Double usos;
    private Double incremento;
    private Double efectivoIn;
    private Double saldoProy;

    public FlujoCajaProy(Double ingresosdOp, Double gastosOp, Double ingresosC, Double gastosC, Double fuentes, Double usos, Double efectivoIn) {
        this.ingresosdOp = ingresosdOp;
        this.gastosOp = gastosOp;
        this.ingresosC = ingresosC;
        this.gastosC = gastosC;
        this.fuentes = fuentes;
        this.usos = usos;
        this.efectivoIn = efectivoIn;
        calcularActividaOP();
        calcularActividadI();
        calcularActividadFin();
        calcularincremento();
        calcularProyeccion();
    }

    private void calcularActividaOP(){
        this.actividadesOp = this.ingresosdOp - this.gastosOp;
    }

    private void calcularActividadI(){
        this.actividadesI = this.ingresosC - this.gastosC;
    }

    private void calcularActividadFin(){
        this.actividadFin = this.fuentes - this.usos;
    }

    private void calcularincremento(){
        this.incremento = this.actividadesOp + this.actividadesI + this.actividadFin;
    }

    private void calcularProyeccion(){
        this.saldoProy = this.incremento + this.efectivoIn;
    }

    public Double getActividadesOp() {
        return actividadesOp;
    }

    public Double getActividadesI() {
        return actividadesI;
    }

    public Double getActividadFin() {
        return actividadFin;
    }

    public Double getIncremento() {
        return incremento;
    }

    public Double getSaldoProy() {
        return saldoProy;
    }

    public Double getIngresosdOp() {
        return ingresosdOp;
    }

    public Double getGastosOp() {
        return gastosOp;
    }

    public Double getIngresosC() {
        return ingresosC;
    }

    public Double getGastosC() {
        return gastosC;
    }

    public Double getFuentes() {
        return fuentes;
    }

    public Double getUsos() {
        return usos;
    }

    public Double getEfectivoIn() {
        return efectivoIn;
    }
}
