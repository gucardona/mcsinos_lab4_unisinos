package ui;

import pedido.Cardapio;
import teclado.Teclado;

import java.util.Locale;

public class Menu {
    public static void imprimirCardapio() {
        Locale.setDefault(Locale.US);
        int numeroPrimeiraComida = 6;
        int i = 1;
        System.out.println("+===================== CARDÁPIO DE BEBIDAS =====================+");
        System.out.println("|                                                               |");
        for (Cardapio item : Cardapio.values()) {
            if (i == numeroPrimeiraComida) {
                System.out.println("|                                                               |");
                System.out.println("+===============================================================+");
                System.out.println();
                System.out.println("+===================== CARDÁPIO DE COMIDAS =====================+");
                System.out.println("|                                                               |");
            }
            if (i < 10)
                System.out.printf("|\t0" + i + ".\t%-50s %.2f\t|\n", item.getNome(), item.getPreco());
            else
                System.out.printf("|\t" + i + ".\t%-50s %.2f\t|\n", item.getNome(), item.getPreco());
            i++;
        }
        System.out.println("|                                                               |");
        System.out.println("+===============================================================+");
    }

    public static void menuInicial() {
        int alternativa;

        do {
            System.out.println("+==================== Menu ====================+");
            System.out.printf("|\t%5s %30s\t|", "1.", "Realizar pedido");
            System.out.printf("|\t%5s %20s\t|", "2.", "Entregar pedido");
            System.out.printf("|\t%5s %30s\t|", "3.", "Mostrar próximo pedido");
            System.out.println("|                                                  |");
            System.out.printf("|\t%5s %30s\t|", "0.", "Sair");
            System.out.println("+==============================================+");

            alternativa = Teclado.leInt("\nEscolha uma opção para realizar alguma operação: ");

        } while (alternativa != 0);
    }
}
