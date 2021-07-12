package br.com.estudos;

import java.io.IOException;

import br.com.estudos.usuario.Usuario;

public class Main {

    public static void main(String[] args) throws IOException {

        var user = new Usuario();

        user.adicionar('+', 100);
        System.in.read();
        user.adicionar('-', 50);
        System.in.read();
        user.adicionar('*', 10);
        System.in.read();
        user.adicionar('/', 2);
        System.in.read();

        user.desfazer(4);
        System.in.read();

        user.retornar(3);
    }

}
