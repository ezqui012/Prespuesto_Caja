package com.example.proyecto_flujo_caja.Models;

import java.io.Serializable;

public class Company implements Serializable {

    private Double sales;
    private Double credit30;
    private Double credit60;
    private Double about;
    private Double badDebt;
    private Double interest;

    public Company(Double sales, Double credit30, Double credit60, Double about, Double badDebt, Double interest) {
        this.sales = sales;
        this.credit30 = credit30;
        this.credit60 = credit60;
        this.about = about;
        this.badDebt = badDebt;
        this.interest = interest;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getCredit30() {
        return credit30;
    }

    public void setCredit30(Double credit30) {
        this.credit30 = credit30;
    }

    public Double getCredit60() {
        return credit60;
    }

    public void setCredit60(Double credit60) {
        this.credit60 = credit60;
    }

    public Double getAbout() {
        return about;
    }

    public void setAbout(Double about) {
        this.about = about;
    }

    public Double getBadDebt() {
        return badDebt;
    }

    public void setBadDebt(Double badDebt) {
        this.badDebt = badDebt;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }
}
