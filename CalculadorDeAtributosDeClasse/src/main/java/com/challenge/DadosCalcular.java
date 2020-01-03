package com.challenge;


import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class DadosCalcular {

    private BigDecimal valor;

    @Somar
    private BigDecimal somar1;

    @Subtrair
    private BigDecimal subtrair1;

    @Somar
    private BigDecimal somar2;

    @Subtrair
    private BigDecimal subtrair2;

    @Somar
    private int somar3;

    @Subtrair
    private int subtrair3;


    public DadosCalcular(BigDecimal valor,BigDecimal somar1, BigDecimal subtrair1, BigDecimal somar2, BigDecimal subtrair2, int somar3, int subtrair3) {
        this.valor = valor;
        this.somar1 = somar1;
        this.subtrair1 = subtrair1;
        this.somar2 = somar2;
        this.subtrair2 = subtrair2;
        this.somar3 = somar3;
        this.subtrair3 = subtrair3;
    }


    public int getSubtrair3() {
        return subtrair3;
    }

    public void setSubtrair3(int subtrair3) {
        this.subtrair3 = subtrair3;
    }

    public BigDecimal getSomar1() {
        return somar1;
    }

    public void setSomar1(BigDecimal somar1) {
        this.somar1 = somar1;
    }

    public BigDecimal getSubtrair1() {
        return subtrair1;
    }

    public void setSubtrair1(BigDecimal subtrair1) {
        this.subtrair1 = subtrair1;
    }

    public BigDecimal getSomar2() {
        return somar2;
    }

    public void setSomar2(BigDecimal somar2) {
        this.somar2 = somar2;
    }

    public BigDecimal getSubtrair2() {
        return subtrair2;
    }

    public void setSubtrair2(BigDecimal subtrair2) {
        this.subtrair2 = subtrair2;
    }

    public int getSomar3() {
        return somar3;
    }

    public void setSomar3(int somar3) {
        this.somar3 = somar3;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
