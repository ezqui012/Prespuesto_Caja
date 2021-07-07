package com.example.proyecto_flujo_caja.Models;

import java.io.Serializable;

public class SalesProjection implements Serializable {

    private String month;
    private Double sold_units;
    private Double unit_price;
    private Double gross_income;

    public SalesProjection(String month, Double sold_units, Double unit_price) {
        this.month = month;
        this.sold_units = sold_units;
        this.unit_price = unit_price;
        calculateGrossIncome();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getSold_units() {
        return sold_units;
    }

    public void setSold_units(Double sold_units) {
        this.sold_units = sold_units;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Double getGross_income() {
        return gross_income;
    }

    public void calculateGrossIncome(){
        gross_income = sold_units * unit_price;
    }
}
