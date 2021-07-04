package com.example.proyecto_flujo_caja.Models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InteresIngreso implements Serializable {

    private String ibFebruary;
    private String ibMarch;
    private String ibApril;
    private String ibMay;
    private String ibJune;
    private String r30March;
    private String r30April;
    private String r30May;
    private String r30June;
    private String ib60February;
    private String ib60March;
    private String ib60April;
    private String ib60May;
    private String ib60June;
    private String r60April;
    private String r60May;
    private String r60June;

    public InteresIngreso(SalesProjection february, SalesProjection march, SalesProjection april, SalesProjection may, SalesProjection june, Company info){
        loadInfo(february, march, april, may, june, info);
    }

    private String grossIncome(Double grossIncomeMonth, Double credit, Company info){
        double res = grossIncomeMonth * credit * info.getInterest();
        return String.valueOf(res);
    }

    private String recovery(Double grossIncomeMonth, Company info){
        double res = grossIncomeMonth * (1 - info.getBadDebt());
        return String.valueOf(res);
    }

    private void loadInfo(SalesProjection february, SalesProjection march, SalesProjection april, SalesProjection may, SalesProjection june, Company info){
        this.ibFebruary = grossIncome(february.getGross_income(), info.getCredit30(), info);
        this.ibMarch = grossIncome(march.getGross_income(), info.getCredit30(), info);
        this.ibApril = grossIncome(april.getGross_income(), info.getCredit30(), info);
        this.ibMay = grossIncome(may.getGross_income(), info.getCredit30(), info);
        this.ibJune = grossIncome(june.getGross_income(), info.getCredit30(), info);

        this.r30March = recovery(Double.parseDouble(ibFebruary), info);
        this.r30April = recovery(Double.parseDouble(ibMarch), info);
        this.r30May = recovery(Double.parseDouble(ibApril), info);
        this.r30June = recovery(Double.parseDouble(ibMay), info);

        this.ib60February = grossIncome(february.getGross_income(), info.getCredit60(), info);
        this.ib60March = grossIncome(march.getGross_income(), info.getCredit60(), info);
        this.ib60April = grossIncome(april.getGross_income(), info.getCredit60(), info);
        this.ib60May = grossIncome(may.getGross_income(), info.getCredit60(), info);
        this.ib60June = grossIncome(june.getGross_income(), info.getCredit60(), info);

        this.r60April = recovery(Double.parseDouble(ib60February), info);
        this.r60May = recovery(Double.parseDouble(ib60March), info);
        this.r60June = recovery(Double.parseDouble(ib60April), info);
    }

    public String getIbFebruary() {
        return ibFebruary;
    }

    public String getIbMarch() {
        return ibMarch;
    }

    public String getIbApril() {
        return ibApril;
    }

    public String getIbMay() {
        return ibMay;
    }

    public String getIbJune() {
        return ibJune;
    }

    public String getR30March() {
        return r30March;
    }

    public String getR30April() {
        return r30April;
    }

    public String getR30May() {
        return r30May;
    }

    public String getR30June() {
        return r30June;
    }

    public String getIb60February() {
        return ib60February;
    }

    public String getIb60March() {
        return ib60March;
    }

    public String getIb60April() {
        return ib60April;
    }

    public String getIb60May() {
        return ib60May;
    }

    public String getIb60June() {
        return ib60June;
    }

    public String getR60April() {
        return r60April;
    }

    public String getR60May() {
        return r60May;
    }

    public String getR60June() {
        return r60June;
    }

    public Map<String, Object> getMapinteresI(){
        Map<String, Object> map = new HashMap<>();
        map.put("ibFebruary", this.ibFebruary);
        map.put("ibMarch", this.ibMarch);
        map.put("ibApril", this.ibApril);
        map.put("ibMay", this.ibMay);
        map.put("ibJune", this.ibJune);
        map.put("r30March", this.r30March);
        map.put("r30April", this.r30April);
        map.put("r30May", this.r30May);
        map.put("r30June", this.r30June);
        map.put("ib60February", this.ib60February);
        map.put("ib60March", this.ib60March);
        map.put("ib60April", this.ib60April);
        map.put("ib60May", this.ib60May);
        map.put("ib60June", this.ib60June);
        map.put("r60April", this.r60April);
        map.put("r60May", this.r60May);
        map.put("r60June", this.r60June);
        return map;
    }
}
