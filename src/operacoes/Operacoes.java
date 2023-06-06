package operacoes;

import pedido.Cardapio;
import pedido.FilaDePedidos;
import pedido.Pedido;
import teclado.Teclado;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Queue;

import static java.lang.System.exit;

public class Operacoes {

    public void realizarOperacoes(FilaDePedidos filaDePedidos, int alternativa) {
        switch (alternativa) {
            case 1:
                String nome = Teclado.leString("Nome do cliente: ");
                int quant = Teclado.leInt("Quantidade de itens no pedido: ");
                ArrayList<Cardapio> itensDoPedido = new ArrayList<>();

                int i = 0;
                do {
                    System.out.println("Escolha " + quant + " itens do cardápio... ");
                    System.out.println("** Escolha pelo número do item **");
                    int itemEscolhido = Teclado.leInt("Item número #" + i+1 + ": ");

                    for (Cardapio item : Cardapio.values()) {
                        if (itemEscolhido == item.getId()) {
                            System.out.println("Item número escolhido foi: [ " + item.getNome() + " ]");
                            itensDoPedido.add(item);
                            break;
                        }
                    }
                    i++;
                } while (i < quant);

                double valorTotal = 0;
                for (Cardapio item : itensDoPedido) {
                    valorTotal += item.getPreco();
                }

                Pedido pedido = new Pedido(nome, itensDoPedido, valorTotal, LocalDateTime.now());
                filaDePedidos.adicionarPedido(pedido);
        }
    }

    public void mostrarPedido(Pedido pedido) {
        System.out.println("\tPEDIDO DE: " + pedido.getNomeDoCliente());
        System.out.println("+==============================");
        System.out.printf("|\t%50s\t|", "Nome do cliente: " + pedido.getNomeDoCliente());
        System.out.printf("|\t%50s\t|");

        System.out.printf("|\t%50s\t|", "Itens do pedido: ");
        for (Cardapio item : pedido.getItensDoPedido()) {
            System.out.printf("|\t %15s %20s %15s \t|", item.getId(), item.getNome(), item.getPreco());
        }

        System.out.printf("|\t%50s\t|");
        System.out.printf("|\t%50s\t|", "Valor total do pedido: R$ " + pedido.getValorDoPedido());
    }

    public void sair() {
        System.out.println("\nSaindo...");
        exit(0);
    }
}
