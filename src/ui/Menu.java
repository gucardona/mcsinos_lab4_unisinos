package ui;

import pedido.Cardapio;

import java.util.Locale;

public class Menu {
    public static void imprimirCardapio() {
        Locale.setDefault(Locale.US);
        int numeroPrimeiraComida = 6;
        int i = 1;
        System.out.println("+===============================================================+");
        System.out.println("|\tCARDÁPIO DE BEBIDAS                                         |");
        System.out.println("+---------------------------------------------------------------+");
        for(Cardapio item : Cardapio.values()) {
            if (i == numeroPrimeiraComida) {
                System.out.println("+===============================================================+");
                System.out.println();
                System.out.println("+===============================================================+");
                System.out.println("|\tCARDÁPIO DE COMIDAS                                         |");
                System.out.println("+---------------------------------------------------------------+");
            }
            if (i < 10)
                System.out.printf("|\t0" + i + ".\t%-50s %.2f\t|\n", item.getNome(), item.getPreco());
            else
                System.out.printf("|\t" + i + ".\t%-50s %.2f\t|\n", item.getNome(), item.getPreco());
            i++;
        }
        System.out.println("+===============================================================+");
    }

    public static void menuInicial() {
        
    }
}
