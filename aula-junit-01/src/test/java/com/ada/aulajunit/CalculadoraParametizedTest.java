package com.ada.aulajunit;

import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

public class CalculadoraParametizedTest {

    @ParameterizedTest(name="Caso {index}: Passando {0} e {1} deveria retornar {2}")
    @MethodSource("obterDados")
    //@CsvFileSource(resources="/dados.csv")
    //@JsonFileSource(resources="/dados.json")
    public void testarSoma(int primeiro, int segundo, int expected){
        Assertions.assertTrue(primeiro > segundo);

        Calculadora calc = new Calculadora();
        int resultado = calc.somar(primeiro, segundo);

        Assertions.assertEquals(expected, resultado);
    }

    public static Collection<?> obterDados(){
        return Arrays.asList(new Object[][]{
                {10, 3, 13},
                {7, 1, 8},
                {-2, -5, -7},
                }
        );
    }
}
