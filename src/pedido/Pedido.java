package pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Pedido {
    private String nomeDoCliente;
    private Cardapio[] itensDoPedido;
    private double valorDoPedido;
    private LocalDateTime dataHoraDoPedido;

    public Pedido() {}

    public Pedido(String nomeDoCliente, Cardapio[] itensDoPedido, double valorDoPedido, LocalDateTime dataHoraDoPedido) {
        this.nomeDoCliente = nomeDoCliente;
        this.itensDoPedido = itensDoPedido;
        this.valorDoPedido = valorDoPedido;
        this.dataHoraDoPedido = dataHoraDoPedido;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public Cardapio[] getItensDoPedido() {
        return itensDoPedido;
    }

    public double getValorDoPedido() {
        return valorDoPedido;
    }

    public LocalDateTime getDataHoraDoPedido() {
        return dataHoraDoPedido;
    }

    @Override
    public String toString() {
        return "Nome do Cliente: " + nomeDoCliente +
                "\nItens do pedido: " + Arrays.toString(itensDoPedido) +
                "\nValor do pedido: " + valorDoPedido +
                "\nData e hora do pedido: " + dataHoraDoPedido;
    }
}
