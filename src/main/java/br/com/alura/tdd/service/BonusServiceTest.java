package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto() {
        BonusService service = new BonusService();

        // Esta aqui eh uma das maneiras de testar uma exceptions, porem da forma que esta em funcionamento fica melhor pra fazer o tratamento da expception
        // assertThrows(IllegalArgumentException.class,() ->  service.calcularBonus(new Funcionario("Celso", LocalDate.now(), new BigDecimal("25000"))));

        try {
            service.calcularBonus(new Funcionario("Celso", LocalDate.now(), new BigDecimal("25000")));
            fail("Nao deu a exception!"); // usado pra fazer o teste falhar intencionalmente e mostrar que o teste falhou
        } catch (Exception e) {
            assertEquals("Funcionario com salario maior que 1000 nao pode receber bonus", e.getMessage());
        }  // usado  para testar a msg da exception(assertEquals("Funcionario com salario maior que 1000 nao pode receber bonus", e.getMessage());)
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Pipoqueiro", LocalDate.now(), new BigDecimal("2500")));
        Assertions.assertEquals(new BigDecimal("250.00"), bonus);

    }

    @Test
    void bonusDeveriaSerDEzPorCentoSalarioExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Eras", LocalDate.now(), new BigDecimal("10000")));
        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);

    }

}