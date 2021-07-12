package br.com.estudos.command;

import br.com.estudos.calculadora.Calculadora;

public class CalculadoraCommand extends Commander {
    private char operador;
    private int valor;
    private Calculadora calculadora;

    public CalculadoraCommand(Calculadora calculadora, char operador, int valor) {
        this.calculadora = calculadora;
        this.operador = operador;
        this.valor = valor;
    }

    public void operator(char value) {
        this.operador = value;
    }

    public void operand(int value) {
        this.valor = value;
    }

    @Override
    public void executar() {
        calculadora.operacao(operador, valor);
    }

    @Override
    public void desfazer() {
        calculadora.operacao(Desfazer(operador), valor);
    }

    private static char Desfazer(char operador) {
        switch (operador) {
        case '+':
            return '-';
        case '-':
            return '+';
        case '*':
            return '/';
        case '/':
            return '*';
        default:
            throw new Error("Operador desconhecido");
        }
    }
}