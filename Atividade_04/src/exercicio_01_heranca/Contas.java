package exercicio_01_heranca;

import java.util.*;
import java.util.Scanner;

public class Contas {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ContaBancaria> contas = new ArrayList<>();

        // Exemplo
        ContaPoupanca contaPoupanca = new ContaPoupanca("João", 123, 1000.0, 5);
        ContaEspecial contaEspecial = new ContaEspecial("Maria", 456, 500, 300);
        contas.add(contaPoupanca);
        contas.add(contaEspecial);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Incluir dados de uma nova conta");
            System.out.println("2. Sacar de uma conta");
            System.out.println("3. Depositar em uma conta");
            System.out.println("4. Calcular novo saldo (Conta Poupança)");
            System.out.println("5. Mostrar dados das contas");
            System.out.println("6. Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Tipo de conta (1 - Poupança, 2 - Especial):");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome do cliente:");
                    String cliente = sc.nextLine();
                    System.out.println("Número da conta:");
                    int numeroConta = sc.nextInt();
                    System.out.println("Saldo inicial:");
                    double saldo = sc.nextDouble();

                    if (tipo == 1) {
                        System.out.println("Dia de rendimento:");
                        int diaRendimento = sc.nextInt();
                        contas.add(new ContaPoupanca(cliente, numeroConta, saldo, diaRendimento));
                    } else if (tipo == 2) {
                        System.out.println("Limite:");
                        double limite = sc.nextDouble();
                        contas.add(new ContaEspecial(cliente, numeroConta, saldo, limite));
                    }
                    break;

                case 2:
                    System.out.println("Informe o número da conta para saque:");
                    int numeroContaSaque = sc.nextInt();
                    System.out.println("Valor do saque:");
                    double valorSaque = sc.nextDouble();
                    ContaBancaria contaSaque = buscarConta(contas, numeroContaSaque);

                    if (contaSaque != null) {
                        if (contaSaque.sacar(valorSaque)) {
                            System.out.println("Saque realizado com sucesso.");
                        } else {
                            System.out.println("Saque não permitido.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Informe o número da conta para depósito:");
                    int numeroContaDeposito = sc.nextInt();
                    System.out.println("Valor do depósito:");
                    double valorDeposito = sc.nextDouble();
                    ContaBancaria contaDeposito = buscarConta(contas, numeroContaDeposito);

                    if (contaDeposito != null) {
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Informe o número da conta poupança para calcular novo saldo:");
                    int numeroContaPoupanca = sc.nextInt();
                    System.out.println("Taxa de rendimento:");
                    double taxaRendimento = sc.nextDouble();
                    ContaBancaria conta = buscarConta(contas, numeroContaPoupanca);

                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).calcularNovoSaldo(taxaRendimento);
                        System.out.println("Novo saldo calculado.");
                    } else {
                        System.out.println("Conta não é do tipo poupança.");
                    }
                    break;

                case 5:
                    for (ContaBancaria c : contas) {
                        System.out.println(c);
                        System.out.println();
                    }
                    break;

                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }

	public static ContaBancaria buscarConta(ArrayList<ContaBancaria> contas, int numeroConta) {
	    for (ContaBancaria conta : contas) {
	        if (conta.getNumeroConta() == numeroConta) { // Use == para comparação entre inteiros
	            return conta;
	        }
	    }
	    return null;
	}
}