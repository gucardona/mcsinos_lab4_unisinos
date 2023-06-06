package main;

import operacoes.Operacoes;
import pedido.FilaDePedidos;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        Operacoes.realizarOperacoes(new FilaDePedidos());
    }
}
