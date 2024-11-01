package exercicio_03_interface;

import java.util.Scanner;

public class GerenciadorHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------ RESERVA DE HOTEL --------------------");
        System.out.println("\nDigite a quantidade de dias da hospedagem:");
        int dias = scanner.nextInt();

        System.out.println("\nDigite o número de pessoas para o Quarto Simples:");
        int pessoasSimples = scanner.nextInt();
        Acomodacao quartoSimples = new QuartoSimples(pessoasSimples);
        quartoSimples.exibirDetalhes(dias);

        System.out.println("\nDigite o número de pessoas para o Quarto Duplo:");
        int pessoasDuplo = scanner.nextInt();
        Acomodacao quartoDuplo = new QuartoDuplo(pessoasDuplo);
        quartoDuplo.exibirDetalhes(dias);

        System.out.println("\nDigite o número de pessoas para a Suíte:");
        int pessoasSuite = scanner.nextInt();
        Acomodacao suite = new Suite(pessoasSuite);
        suite.exibirDetalhes(dias);

        scanner.close();
    }
}
