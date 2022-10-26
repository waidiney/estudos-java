package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.ReajusteService;
import org.junit.jupiter.api.*;
import org.testng.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {


    private ReajusteService service;
    private Funcionario funcionario;


    @AfterEach
    public void finalizar(){
        System.out.println("fim");
    }
    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("Antes de todos");
    }
    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois de Todos");
    }
    @BeforeEach
    public void inicializar() {
        System.out.println("inicializar");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Sam", LocalDate.now(), new BigDecimal("1000.00"));

    }
    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assert.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        Assert.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        Assert.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
