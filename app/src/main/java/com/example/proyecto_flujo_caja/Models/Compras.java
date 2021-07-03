package com.example.proyecto_flujo_caja.Models;

public class Compras {
    private Double pcontado, ptreinta, pventas;

    public Compras(Double pcontado, Double ptreinta, Double pventas) {
        this.pcontado = pcontado;
        this.ptreinta = ptreinta;
        this.pventas = pventas;

    }

    public Double getPcontado() {
        return pcontado;
    }

    public void setPcontado(Double pcontado) {
        this.pcontado = pcontado;
    }

    public Double getPtreinta() {
        return ptreinta;
    }

    public void setPtreinta(Double ptreinta) {
        this.ptreinta = ptreinta;
    }

    public Double getPventas() {
        return pventas;
    }

    public void setPventas(Double pventas) {
        this.pventas = pventas;
    }

}
