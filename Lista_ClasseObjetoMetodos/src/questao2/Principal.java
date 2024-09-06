package questao2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//instanciar o objeto
		Salario sal = new Salario();

		//passar os dados de leitura
		System.out.println("Digite o seu nome: ");
		sal.nome = sc.nextLine();
		
		System.out.println("Digite o valor do salário atual: R$");
		sal.salario = sc.nextDouble();
		
		//calcular aumento
		double novoSalario = sal.aplicarAumento();
		
		//mostrar informação na tela
		System.out.println("Nome: " + sal.nome);
		System.out.printf("Antigo Salário: R$ %.2f\n", sal.salario);
		System.out.printf("Salário Atual: R$ %.2f\n", novoSalario);

		sc.close();
	}
}