package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses  implements Calculavel {

    @Override
    public BigDecimal somar(Object calcular) throws IllegalAccessException {
        return valores(calcular, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object calcular) throws IllegalAccessException {
    return valores(calcular, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object calcular) throws IllegalAccessException {
        return somar(calcular).subtract(subtrair(calcular));

    }

    private BigDecimal valores (Object calcular,Class anotacaoClasse) throws IllegalAccessException {

        Class obterClasse = calcular.getClass();
        Field[] declaredFields = obterClasse.getDeclaredFields();
        BigDecimal valor = BigDecimal.ZERO;

        for(Field fields : declaredFields) {
            fields.setAccessible(true);

            if (fields.getAnnotation(anotacaoClasse) != null && fields.getType().equals(BigDecimal.class)) {


                valor = valor.add((BigDecimal) fields.get(calcular));


            }

        }
            return valor;

    }
}
