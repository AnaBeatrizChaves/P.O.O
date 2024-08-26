import java.util.Scanner;

public class questao_05 {

	public static void main(String[] args) {
		/*5 - Desenvolva um algoritmo que leia o valor de um produto e aplique um desconto a ser
especificado pelo usuário. Ao final do programa, apresente o nome do produto, seu
antigo valor e o valor com desconto aplicado com três casas decimais*/
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("-- Aplicação de Desconto --");
		System.out.println("Digite o nome do produto: ");
		String nome = sc.next();
		System.out.println("Digite o valor do produto: ");
		double valor = sc.nextDouble();
		System.out.println("Digite o valor do desconto a ser aplicado (%):");
		double desconto = sc.nextDouble();
		
		double valorDesconto =  valor * (desconto/100);
		double novoValor = valor - valorDesconto;
		
		System.out.println("-- RESULTADO --");
		System.out.printf("Nome do Produto: %s", nome);
		System.out.printf("\nValor SEM desconto: R$ %.2f", valor);
		System.out.printf("\nValor COM desconto: R$ %.3f", novoValor);

		sc.close();

	}

}
