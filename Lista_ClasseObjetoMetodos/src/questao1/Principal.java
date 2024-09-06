package questao1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//instanciar o objeto
		Estoque prod1 = new Estoque();
		
		//entrada dos dados
		System.out.println("Digite o nome do Produto: ");
		prod1.nome_prod = sc.nextLine();
		
		System.out.println("Digite o preço: R$ ");
		prod1.preco = sc.nextDouble();
		
		System.out.println("Digite a quantidade: R$ ");
		prod1.quant_prod = sc.nextInt();
		
		prod1.mostrarDados();
		
		//adicionar prod
		System.out.println("\nDigite a quantidade de produtos que deseja adicionar. Caso não deseje, digite 0.");
		int qtd_add;
		qtd_add = sc.nextInt();
		prod1.adicionarProduto(qtd_add);
		
		prod1.mostrarDados();
		
		//remover prod
		System.out.println("\nDigite a quantidade de produtos que deseja remover. Caso não deseje, digite 0.");
		int qtd_rem;
		qtd_rem = sc.nextInt();
		prod1.removerProduto(qtd_rem);
		
		prod1.mostrarDados();
		
		System.out.println("Valor total do estoque: R$ " + prod1.valorTotalEstoque());
		
		sc.close();
	}

}