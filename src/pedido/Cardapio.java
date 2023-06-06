package pedido;

public enum Cardapio {
    CAFE_ESPRESSO(1, "Café Espresso", 3.50),
    CARIOQUINHA(2, "Carioquinha", 4.50),
    CAPUCCINO(3, "Cappuccino", 4.00),
    SUCO_DE_LARANJA(4, "Suco de Laranja", 5.00),
    AGUA(5, "Água", 2.00),

    CROISSANT_DE_PRESUNTO_E_QUEIJO(6, "Croissant de Presunto e Queijo", 6.00),
    PAO_DE_QUEIJO(7, "Pão de Queijo", 3.50),
    CROISSANT_DE_CHOCOLATE(8, "Croissant de Chocolate", 5.50),
    BROWNIE(9, "Brownie", 4.50),
    TORTA_DE_LIMAO(10, "Torta de Limão", 6.50);

    private final int id;
    private final String nome;
    private final double preco;

    Cardapio(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}