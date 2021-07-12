package br.com.estudos.calculadora;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculadora {
    private int valorAtual;

    private static final Logger logger = LoggerFactory.getLogger(Calculadora.class);

    public void operacao(char operador, int valor) {
        switch (operador) {
        case '+':
            valorAtual += valor;
            break;
        case '-':
            valorAtual -= valor;
            break;
        case '*':
            valorAtual *= valor;
            break;
        case '/':
            valorAtual /= valor;
            break;
        }
        logger.info("(operação:{} valor:{}) - Valor atual = {}", operador, valor, valorAtual);
    }
}