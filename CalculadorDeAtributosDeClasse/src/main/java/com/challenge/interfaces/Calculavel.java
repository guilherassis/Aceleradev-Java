package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

    public BigDecimal somar(Object calcular) throws IllegalAccessException;
    public BigDecimal subtrair(Object calcular) throws IllegalAccessException;
    public BigDecimal totalizar(Object calcular) throws IllegalAccessException;

}
