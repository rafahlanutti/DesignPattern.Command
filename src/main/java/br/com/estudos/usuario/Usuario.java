package br.com.estudos.usuario;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.estudos.calculadora.Calculadora;
import br.com.estudos.command.CalculadoraCommand;
import br.com.estudos.command.Commander;

public class Usuario {

    private static final Logger logger = LoggerFactory.getLogger(Usuario.class);

    private Calculadora calculadora = new Calculadora();
    private List<Commander> commands = new ArrayList<>();
    private int total;

    public void adicionar(char operador, int valor) {
        Commander command = new CalculadoraCommand(calculadora, operador, valor);
        command.executar();

        commands.add(command);
        total++;
    }

    public void retornar(int niveis) {
        logger.info("\n---- Retornando {} níveis ", niveis);
        for (var i = 0; i < niveis; i++) {
            if (total >= commands.size() - 1)
                continue;
            var command = commands.get(total++);
            command.executar();
        }
    }

    public void desfazer(int niveis) {
        logger.info("\n---- Desfazendo {} níveis ", niveis);

        for (var i = 0; i < niveis; i++) {
            if (total <= 0)
                continue;
            var command = commands.get(--total);
            command.desfazer();
        }
    }
}
