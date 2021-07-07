package com.example.proyecto_flujo_caja.Models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InteresGasto implements Serializable {

    private String igFebruary;
    private String igMarch;
    private String igApril;

    private String ibFebruary;
    private String ibMarch;
    private String ibApril;

    private String r30March;
    private String r30April;

    private String ib60February;
    private String ib60March;
    private String ib60April;

    private String r60April;

    public InteresGasto(SalesProjection february, SalesProjection march, SalesProjection april, Company info){
        loadInfo(february, march, april, info);
    }

    private String grossIncome(Double grossIncomeMonth, Double credit, Company info){
        double res = grossIncomeMonth * credit * info.getInterest();
        return String.valueOf(res);
    }

    private String recovery(Double grossIncomeMonth, Company info){
        double res = grossIncomeMonth * (1 - info.getBadDebt());
        return String.valueOf(res);
    }

    private String grossPurchases(Double valueMonth, Company info){
        double res = valueMonth * info.getAbout();
        return String.valueOf(res);
    }

    private void loadInfo(SalesProjection february, SalesProjection march, SalesProjection april, Company info){
        igFebruary = grossPurchases(february.getGross_income(), info);
        igMarch = grossPurchases(march.getGross_income(), info);
        igApril = grossPurchases(april.getGross_income(), info);

        ibFebruary = grossIncome(february.getGross_income(), info.getCredit30(), info);
        ibMarch = grossIncome(march.getGross_income(), info.getCredit30(), info);
        ibApril = grossIncome(april.getGross_income(), info.getCredit30(), info);

        r30March = recovery(Double.parseDouble(ibFebruary), info);
        r30April = recovery(Double.parseDouble(ibMarch), info);

        ib60February = grossIncome(february.getGross_income(), info.getCredit60(), info);
        ib60March = grossIncome(march.getGross_income(), info.getCredit60(), info);
        ib60April = grossIncome(april.getGross_income(), info.getCredit60(), info);

        r60April = recovery(Double.parseDouble(ib60February), info);
    }

    public String getIgFebruary() {
        return igFebruary;
    }

    public String getIgMarch() {
        return igMarch;
    }

    public String getIgApril() {
        return igApril;
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

    public String getR30March() {
        return r30March;
    }

    public String getR30April() {
        return r30April;
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

    public String getR60April() {
        return r60April;
    }

    public Map<String, Object> getMapInteresG(){
        Map<String, Object> map = new HashMap<>();
        map.put("igFebruary", this.igFebruary);
        map.put("igMarch", this.igMarch);
        map.put("igApril", this.igApril);
        map.put("ibFebruary", this.ibFebruary);
        map.put("ibMarch", this.ibMarch);
        map.put("ibApril", this.ibApril);
        map.put("r30March", this.r30March);
        map.put("r30April", this.r30April);
        map.put("ib60February", this.ib60February);
        map.put("ib60March", this.ib60March);
        map.put("ib60April", this.ib60April);
        map.put("r60April", this.r60April);
        return map;
    }
}
