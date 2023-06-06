package operacoes;

import pedido.Cardapio;
import pedido.FilaDePedidos;
import pedido.Pedido;
import teclado.Teclado;
import ui.Menu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Operacoes {

    public static void realizarOperacoes(FilaDePedidos filaDePedidos) {
        Menu.menuInicial();
        System.out.println();

        int alternativa = Teclado.leInt("\nEscolha uma opção para realizar alguma operação: ");

        switch (alternativa) {
            case 1:
                espacos();
                Menu.imprimirCardapio();
                System.out.println();

                String nome = Teclado.leString("Nome do cliente: ");
                int quant = Teclado.leInt("Quantidade de itens no pedido: ");
                ArrayList<Cardapio> itensDoPedido = new ArrayList<>();

                int i = 0;
                int numPedido = 1;
                System.out.println("Escolha " + quant + " itens do cardápio... ");
                System.out.println("** Escolha pelo número do item **");
                System.out.println();
                do {
                    int itemEscolhido = Teclado.leInt("Item número #" + numPedido + ": ");
                    System.out.println();
                    for (Cardapio item : Cardapio.values()) {
                        if (itemEscolhido == item.getId()) {
                            System.out.println("Item número escolhido foi: [ " + item.getNome() + " ]");
                            itensDoPedido.add(item);
                            break;
                        }
                    }
                    i++;
                    numPedido++;
                } while (i < quant);

                double valorTotal = 0;
                for (Cardapio item : itensDoPedido) {
                    valorTotal += item.getPreco();
                }

                Pedido pedido = new Pedido(nome, itensDoPedido, valorTotal, LocalDateTime.now());

                mostrarPedido(pedido);

                filaDePedidos.adicionarPedido(pedido);
                voltarAoMenu(filaDePedidos);
                break;

            case 2:
                espacos();
                if (filaDePedidos.getFilaDePedidos().isEmpty()) {
                    System.out.println("A fila de pedidos está vazia.");
                    voltarAoMenu(filaDePedidos);
                    break;
                }

                System.out.println("Fila antes da entrega: ");
                filaDePedidos.mostraFilaDePedidos();
                System.out.println();
                filaDePedidos.entregarPedido();
                System.out.println("Pedido entregue!");
                System.out.println();
                System.out.println("Fila após entrega: ");
                filaDePedidos.mostraFilaDePedidos();
                voltarAoMenu(filaDePedidos);
                break;

            case 3:
                espacos();

                if (filaDePedidos.getFilaDePedidos().isEmpty()) {
                    System.out.println("A fila de pedidos está vazia.");
                    voltarAoMenu(filaDePedidos);
                    break;
                }

                filaDePedidos.mostraFilaDePedidos();
                voltarAoMenu(filaDePedidos);
                break;

            case 0:
                espacos();
                sair();
                break;

            default:
                throw new IllegalArgumentException("Opção não válida...");
        }
    }

    public static void mostrarPedido(Pedido pedido) {
        espacos();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("+===============================================================+");
        System.out.printf("|\tPEDIDO DE: %-49s|\n", pedido.getNomeDoCliente().toUpperCase());
        System.out.printf("|\tHORÁRIO DO PEDIDO: %-41s|\n", pedido.getDataHoraDoPedido().format(formatter));
        System.out.println("+---------------------------------------------------------------+");
        System.out.printf("|\t%-57s\t|\n", "");

        System.out.printf("|\t%-57s\t|\n", "Itens do pedido: ");
        for (Cardapio item : pedido.getItensDoPedido()) {
            System.out.printf("|\t• %-40s R$ %-10s \t|\n", item.getNome(), item.getPreco());
        }
        System.out.printf("|\t%-57s\t|\n", "");
        System.out.println("+---------------------------------------------------------------+");
        System.out.printf("|\t%-57s\t|\n", "");
        System.out.printf("|\t%-42s %-15s\t|\n", "Valor total do pedido:", "R$ " + pedido.getValorDoPedido());
        System.out.printf("|\t%-57s\t|\n", "");
        System.out.println("+===============================================================+");
    }

    public static void espacos() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void voltarAoMenu(FilaDePedidos filaDePedidos) {
        System.out.println();

        char escolha = Teclado.leChar("Deseja voltar ao menu? (S/N)");
        escolha = Character.toUpperCase(escolha);

        switch (escolha) {
            case 'S':
                espacos();
                realizarOperacoes(filaDePedidos);
                break;

            case 'N':
                System.out.println("Ok! Saindo...");
                break;

            default:
                throw new IllegalArgumentException("Opção não válida...");
        }
    }

    public static void sair() {
        System.out.println("\nSaindo...");
        exit(0);
    }
}
