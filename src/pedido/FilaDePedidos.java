package pedido;

import java.util.LinkedList;
import java.util.Queue;

public class FilaDePedidos {
    private Queue<Pedido> filaDePedidos;

    public FilaDePedidos() {
        this.filaDePedidos = new LinkedList<>();
    }

    public void getFilaDePedidos() {
        if (filaDePedidos.isEmpty()) {
            System.out.println("A fila de pedidos está vazia.");
            return;
        }

        int numeroDoPedido = 1;
        for (Pedido pedido : filaDePedidos) {
            System.out.println();
            System.out.println("Pedido #" + numeroDoPedido + ": \n" + pedido.toString());
            numeroDoPedido++;
        }
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