package com.example.proyecto_flujo_caja.Models;

public class Aporte {
    private Double caja;
    private Double provivienda;
    private Double afp;
    private Double solidario;
    private Double riesgo;
    private Double resAporte;

    public Aporte(){}

    public Double getCaja() {
        return caja;
    }

    public void setCaja(Double caja) {
        this.caja = caja;
    }

    public Double getProvivienda() {
        return provivienda;
    }

    public void setProvivienda(Double provivienda) {
        this.provivienda = provivienda;
    }

    public Double getAfp() {
        return afp;
    }

    public void setAfp(Double afp) {
        this.afp = afp;
    }

    public Double getSolidario() {
        return solidario;
    }

    public void setSolidario(Double solidario) {
        this.solidario = solidario;
    }

    public Double getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(Double riesgo) {
        this.riesgo = riesgo;
    }

    public Double getResAporte() {
        return resAporte;
    }

    public void setResAporte(Double resAporte) {
        this.resAporte = resAporte;
    }
}
