package pedido;

import java.util.LinkedList;
import java.util.Queue;

public class FilaDePedidos {
    private Queue<Pedido> filaDePedidos;

    public FilaDePedidos() {
        this.filaDePedidos = new LinkedList<>();
    }

    public Queue<Pedido> getFilaDePedidos() {
        return filaDePedidos;
    }

    public void mostraFilaDePedidos() {
        if (filaDePedidos.isEmpty()) {
            System.out.println("A fila de pedidos está vazia.");
            return;
        }

        int numeroDoPedido = 1;
        System.out.println("=========================================================================");
        for (Pedido pedido : filaDePedidos) {
            System.out.println();
            System.out.println("Pedido #" + numeroDoPedido + ": \n" + pedido.toString());
            numeroDoPedido++;
            System.out.println();
        }
        System.out.println("=========================================================================");
        System.out.println();
    }

    public void adicionarPedido(Pedido pedido) {
        filaDePedidos.add(pedido);
    }

    public void entregarPedido() {
        if (filaDePedidos.isEmpty()) {
            System.out.println("A fila de pedidos está vazia.");
            return;
        }
        filaDePedidos.poll();
    }
}