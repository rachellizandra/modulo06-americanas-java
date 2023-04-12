package com.ada.aulajunit;

import org.springframework.stereotype.Component;

public class Calculadora {
    static int x, y, resultado;

    static int somar(int a, int b) { return a + b; }

    static int subtrair(int a, int b) { return a - b; }

    static int multiplicar(int a, int b) { return a * b; }

    static float dividir(int a, int b) { return a / b; }
}
