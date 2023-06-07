package tests;

import operacoes.Operacoes;
import org.junit.Before;
import org.junit.Test;
import pedido.Cardapio;
import pedido.FilaDePedidos;
import pedido.Pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OperacoesTest {
    FilaDePedidos filaDePedidos = new FilaDePedidos();
    ArrayList<Cardapio> itens = new ArrayList<>();
    Pedido pedido = new Pedido("Carlos", itens, (Cardapio.BROWNIE.getPreco() + Cardapio.CAPUCCINO.getPreco()), LocalDateTime.now());

    @Before
    public void adicionaItens() {
        itens.add(Cardapio.BROWNIE);
        itens.add(Cardapio.CAPUCCINO);
        filaDePedidos.adicionarPedido(pedido);
    }

    @Test
    public void testa_adicao() {
        assertEquals(filaDePedidos.getFilaDePedidos().peek(), pedido);
    }

    @Test
    public void testa_entrega() {
        filaDePedidos.entregarPedido();
        assertEquals(filaDePedidos.getFilaDePedidos().peek(), null);
    }
}
