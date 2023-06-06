package pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {
    private String nomeDoCliente;
    private ArrayList<Cardapio> itensDoPedido;
    private double valorDoPedido;
    private LocalDateTime dataHoraDoPedido;

    public Pedido() {}

    public Pedido(String nomeDoCliente, ArrayList<Cardapio> itensDoPedido, double valorDoPedido, LocalDateTime dataHoraDoPedido) {
        this.nomeDoCliente = nomeDoCliente;
        this.itensDoPedido = itensDoPedido;
        this.valorDoPedido = valorDoPedido;
        this.dataHoraDoPedido = dataHoraDoPedido;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public ArrayList<Cardapio> getItensDoPedido() {
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Nome do Cliente: " + nomeDoCliente +
                "\nItens do pedido: " + getItensDoPedido() +
                "\nValor do pedido: " + valorDoPedido +
                "\nData e hora do pedido: " + dataHoraDoPedido.format(formatter);
    }
}
