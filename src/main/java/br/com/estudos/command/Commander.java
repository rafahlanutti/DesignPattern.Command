package br.com.estudos.command;

public abstract class Commander {
    public abstract void executar();

    public abstract void desfazer();
}