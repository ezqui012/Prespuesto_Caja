package com.example.proyecto_flujo_caja.Models;
public class Compras {
    String month1,month2, month3,precio1,precio2, precio3,comp1,comp2,comp3,alcont,cont30,vent;;

    public Compras(String alcont, String comp1, String comp2, String comp3,String cont30,String month1, String month2, String month3,String precio1,String precio2,String precio3,String vent) {
        this.month1 = month1;
        this.month2 = month2;
        this.month3 = month3;
        this.comp1 = comp1;
        this.comp2 = comp2;
        this.comp3 = comp3;
        this.vent=vent;
        this.alcont=alcont;
        this.cont30=cont30;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
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

    public String  getAlcont() {
        return alcont;
    }

    public void setAlcont(String alcont) {
        this.alcont = alcont;
    }

    public String getCont30() {
        return cont30;
    }

    public void setCont30(String cont30) {
        this.cont30 = cont30;
    }

    public String getVent() {
        return vent;
    }

    public void setVent(String vent) {
        this.vent = vent;
    }

    public String getComp1() {
        return comp1;
    }

    public void setComp1(String comp1) {
        this.comp1 = comp1;
    }

    public String getComp2() {
        return comp2;
    }

    public void setComp2(String comp2) {
        this.comp2 = comp2;
    }

    public String getComp3() {
        return comp3;
    }

    public void setComp3(String comp3) {
        this.comp3 = comp3;
    }
}
