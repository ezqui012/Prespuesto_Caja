package com.example.proyecto_flujo_caja.Models;

public class Iue {
    String pagdiv, pagprim, utilant,gasded,ingrimpo,iue;

    public Iue(String pagdiv, String pagprim, String utilant, String gasded, String ingrimpo, String iue) {
        this.pagdiv = pagdiv;
        this.pagprim = pagprim;
        this.utilant = utilant;
        this.gasded = gasded;
        this.ingrimpo = ingrimpo;
        this.iue = iue;
    }

    public String getPagdiv() {
        return pagdiv;
    }

    public void setPagdiv(String pagdiv) {
        this.pagdiv = pagdiv;
    }

    public String getPagprim() {
        return pagprim;
    }

    public void setPagprim(String pagprim) {
        this.pagprim = pagprim;
    }

    public String getUtilant() {
        return utilant;
    }

    public void setUtilant(String utilant) {
        this.utilant = utilant;
    }

    public String getGasded() {
        return gasded;
    }

    public void setGasded(String gasded) {
        this.gasded = gasded;
    }

    public String getIngrimpo() {
        return ingrimpo;
    }

    public void setIngrimpo(String ingrimpo) {
        this.ingrimpo = ingrimpo;
    }

    public String getIue() {
        return iue;
    }

    public void setIue(String iue) {
        this.iue = iue;
    }
}
