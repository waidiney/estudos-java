package br.com.alura.tdd.service;

import br.com.alura.tdd.CalculadoraAlura;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculadoraAluraTest {

    @Test
    void  deveriaSomarDoisNumerosPositivos(){
        CalculadoraAlura calc = new CalculadoraAlura();
        int soma = calc.somar(3, 7);

        Assertions.assertEquals(10, soma);
    }
}