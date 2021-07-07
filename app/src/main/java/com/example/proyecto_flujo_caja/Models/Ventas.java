package com.example.proyecto_flujo_caja.Models;

import java.io.Serializable;

public class Ventas implements Serializable {
    String mes1, mes2, mes3, cont1, cont2, cont3, ventcont, vent30, vent60, inco, venta1, venta2, venta3, precio1, precio2, precio3,treinta1,treinta2,trinta3,sesenta1,sesenta2,sesenta3;

    public Ventas(String mes1, String mes2, String mes3, String cont1, String cont2, String cont3, String ventcont, String vent30, String vent60, String inco, String venta1, String venta2, String venta3, String precio1, String precio2, String precio3, String treinta1, String treinta2, String trinta3, String sesenta1, String sesenta2, String sesenta3) {
        this.mes1 = mes1;
        this.mes2 = mes2;
        this.mes3 = mes3;
        this.cont1 = cont1;
        this.cont2 = cont2;
        this.cont3 = cont3;
        this.ventcont = ventcont;
        this.vent30 = vent30;
        this.vent60 = vent60;
        this.inco = inco;
        this.venta1 = venta1;
        this.venta2 = venta2;
        this.venta3 = venta3;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
        this.treinta1 = treinta1;
        this.treinta2 = treinta2;
        this.trinta3 = trinta3;
        this.sesenta1 = sesenta1;
        this.sesenta2 = sesenta2;
        this.sesenta3 = sesenta3;
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

    public String getCont1() {
        return cont1;
    }

    public void setCont1(String cont1) {
        this.cont1 = cont1;
    }

    public String getCont2() {
        return cont2;
    }

    public void setCont2(String cont2) {
        this.cont2 = cont2;
    }

    public String getCont3() {
        return cont3;
    }

    public void setCont3(String cont3) {
        this.cont3 = cont3;
    }

    public String getVentcont() {
        return ventcont;
    }

    public void setVentcont(String ventcont) {
        this.ventcont = ventcont;
    }

    public String getVent30() {
        return vent30;
    }

    public void setVent30(String vent30) {
        this.vent30 = vent30;
    }

    public String getVent60() {
        return vent60;
    }

    public void setVent60(String vent60) {
        this.vent60 = vent60;
    }

    public String getInco() {
        return inco;
    }

    public void setInco(String inco) {
        this.inco = inco;
    }

    public String getVenta1() {
        return venta1;
    }

    public void setVenta1(String venta1) {
        this.venta1 = venta1;
    }

    public String getVenta2() {
        return venta2;
    }

    public void setVenta2(String venta2) {
        this.venta2 = venta2;
    }

    public String getVenta3() {
        return venta3;
    }

    public void setVenta3(String venta3) {
        this.venta3 = venta3;
    }

    public String getPrecio1() {
        return precio1;
    }

    public void setPrecio1(String precio1) {
        this.precio1 = precio1;
    }

    public String getPrecio2() {
        return precio2;
    }

    public void setPrecio2(String precio2) {
        this.precio2 = precio2;
    }

    public String getPrecio3() {
        return precio3;
    }

    public void setPrecio3(String precio3) {
        this.precio3 = precio3;
    }

    public String getTreinta1() {
        return treinta1;
    }

    public void setTreinta1(String treinta1) {
        this.treinta1 = treinta1;
    }

    public String getTreinta2() {
        return treinta2;
    }

    public void setTreinta2(String treinta2) {
        this.treinta2 = treinta2;
    }

    public String getTrinta3() {
        return trinta3;
    }

    public void setTrinta3(String trinta3) {
        this.trinta3 = trinta3;
    }

    public String getSesenta1() {
        return sesenta1;
    }

    public void setSesenta1(String sesenta1) {
        this.sesenta1 = sesenta1;
    }

    public String getSesenta2() {
        return sesenta2;
    }

    public void setSesenta2(String sesenta2) {
        this.sesenta2 = sesenta2;
    }

    public String getSesenta3() {
        return sesenta3;
    }

    public void setSesenta3(String sesenta3) {
        this.sesenta3 = sesenta3;
    }
}