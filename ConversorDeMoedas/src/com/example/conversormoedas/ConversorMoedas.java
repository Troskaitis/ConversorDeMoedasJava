package com.example.conversormoedas;

import java.util.Scanner;

public class ConversorMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Selecione a moeda de destino para conversão:");
            System.out.println("1. Dólar Americano (USD)");
            System.out.println("2. Euro (EUR)");
            System.out.println("3. Libra Esterlina (GBP)");
            System.out.println("4. Dólar Canadense (CAD)");
            System.out.println("5. Iene Japonês (JPY)");
            System.out.println("6. Franco Suíço (CHF)");
            System.out.println("7. Dólar Australiano (AUD)");
            System.out.println("8. Peso Argentino (ARS)");
            System.out.println("9. Yuan Chinês (CNY)");
            System.out.println("10. Rublo Russo (RUB)");
            System.out.println("0. Fechar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Conversor.converter("USD");
                    break;
                case 2:
                    Conversor.converter("EUR");
                    break;
                case 3:
                    Conversor.converter("GBP");
                    break;
                case 4:
                    Conversor.converter("CAD");
                    break;
                case 5:
                    Conversor.converter("JPY");
                    break;
                case 6:
                    Conversor.converter("CHF");
                    break;
                case 7:
                    Conversor.converter("AUD");
                    break;
                case 8:
                    Conversor.converter("ARS");
                    break;
                case 9:
                    Conversor.converter("CNY");
                    break;
                case 10:
                    Conversor.converter("RUB");
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
