package pedido;

public enum Cardapio {
    CAFE_ESPRESSO("Café Espresso", 3.50),
    CARIOQUINHA("Carioquinha", 4.50),
    CAPUCCINO("Cappuccino", 4.00),
    SUCO_DE_LARANJA("Suco de Laranja", 5.00),
    AGUA("Água", 2.00),

    CROISSANT_DE_PRESUNTO_E_QUEIJO("Croissant de Presunto e Queijo", 6.00),
    PAO_DE_QUEIJO("Pão de Queijo", 3.50),
    CROISSANT_DE_CHOCOLATE("Croissant de Chocolate", 5.50),
    BROWNIE("Brownie", 4.50),
    TORTA_DE_LIMAO("Torta de Limão", 6.50);

    private final String nome;
    private final double preco;

    Cardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}