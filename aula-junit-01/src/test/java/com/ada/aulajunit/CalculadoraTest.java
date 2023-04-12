package com.ada.aulajunit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Casos de teste
    // 2 numeros positivos, sendo o primeiro maior que o segundo
    // 2 numeros positivos, sendo o primeiro menor que o segundo
    // 2 numeros positivos, sendo o primeiro igual ao segundo
    // 2 numeros negativos, sendo o primeiro maior que o segundo
    // 2 numeros negativos, sendo o primeiro menor que o segundo
    // 2 numeros negativos, sendo o primeiro igual ao segundo
    // 1 numero positivo e 1 numero negativo, sendo o primeiro maior que o segundo
    // 1 numero positivo e 1 numero negativo, sendo o primeiro menor que o segundo
    // 1 numero positivo e 1 numero negativo, sendo o primeiro igual ao segundo
    // 1 numero positivo e 1 numero zero
    // 1 numero negativo e 1 numero zero
    // 2 numeros zero

    private Calculadora calc;

    @BeforeAll
    public static void before() {
        System.out.println("Iniciando os testes..");
    }

    @BeforeEach
    public void init() {
        System.out.println("Instanciando a calculadora");
        calc = new Calculadora();
    }

    @AfterEach
    public void after() {
        System.out.println("Teste finalizado");
    }

    @Test
    public void somar2NumerosPositivos_quandoOPrimeiroForMaiorQueOSegundo_resultadoPositivo() {
        //Cenário
        int primeiro = 10;
        int segundo = 3;

        //Execução
        int resultado = calc.somar(primeiro, segundo);
        assertTrue(primeiro > segundo);

        //Verificação
        //assertTrue(resultado > 0);
        assertEquals(13, resultado);
    }

    @Test
    public void somar2NumerosPositivos_quandoOSegundoForMaiorQueOPrimeiro_resultadoPositivo() {
        int primeiro = 3;
        int segundo = 10;

        int resultado = calc.somar(primeiro, segundo);
        assertTrue(segundo > primeiro);

        //assertTrue(resultado > 0);
        assertEquals(13, resultado);
    }

    @Test
    public void somar2NumerosZeroEPositivo_ResultadoPositivo() {
        int primeiro = 0;
        int segundo = 8;
        assertTrue(primeiro == 0 || segundo == 0);

        int resultado = calc.somar(primeiro, segundo);

        assertEquals(8, resultado);
    }
    @Test
    public void somar2NumerosNegativos_quandoOPrimeiroForMaiorQueOSegundo_resultadoNegativo() {
        int primeiro = -3;
        int segundo = -7;
        assertTrue(primeiro < 0 && segundo < 0);

        int resultado = calc.somar(primeiro, segundo);

        assertEquals(-10, resultado);
    }

    @Test
    public void divisaoPorZero() {
        int a = 10;
        int b = 0;

        Exception e = assertThrows(ArithmeticException.class, () -> {
            calc.dividir(a, b);
        }); //compara a exception lançada de divisão por 0

        String mensagemEsperada = "/ by zero";
        assertEquals(mensagemEsperada, e.getMessage());
    }
}