package com.example.proyecto_flujo_caja.Models;

import com.example.proyecto_flujo_caja.*;

public class PresupuestoCaja {


        String tot1, tot2, tot3,tot4,tot5,sum1, sum2,sum3;

        public PresupuestoCaja(String tot1,String tot2, String tot3, String tot4, String tot5,String sum1,String sum2, String sum3) {
            this.tot1= tot1;
            this.tot2=tot2;
            this.tot3=tot3;
            this.tot4=tot4;
            this.tot5=tot5;
            this.sum1=sum1;
            this.sum2=sum2;
            this.sum3=sum3;
        }

        public String getTot1() {
            return tot1;
        }

        public void setTot1(String tot1) {
            this.tot1 = tot1;
        }
    public String getTot2() {
        return tot2;
    }

    public void setTot2(String tot2) {
        this.tot2 = tot2;
    }
    public String getTot3() {
        return tot3;
    }

    public void setTot3(String tot3) {
        this.tot3 = tot3;
    }
    public String getTot4() {
        return tot4;
    }

    public void setTot4(String tot4) {
        this.tot4 = tot4;
    }
    public String getTot5() {
        return tot5;
    }

    public void setTot5(String tot5) {
        this.tot5 = tot5;
    }

    public String getSum1() {
        return sum1;
    }

    public void setSum1(String sum1) {
        this.sum1 = sum1;
    }
    public String getSum2() {
        return sum2;
    }

    public void setSum2(String sum2) {
        this.sum2 = sum2;
    }
    public String getSum3() {
        return sum3;
    }

    public void setSum3(String sum3) {
        this.sum3 = sum3;
    }








}
