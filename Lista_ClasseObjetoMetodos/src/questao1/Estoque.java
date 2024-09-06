package questao1;

public class Estoque {
	    //atributos
		String nome_prod;
		double preco;
		int quant_prod;
		
		//metodos
		public void mostrarDados() {
			System.out.println("---------- ESTOQUE ----------\n");
			System.out.println("Produto: " + nome_prod);
			System.out.println("Preço: R$" + preco);
			System.out.println("Quantidade no estoque: " + quant_prod);
		}
		
		public void adicionarProduto(int qtd) {
			quant_prod += qtd;
		}
		
		public void removerProduto(int qtd) {
			if(qtd > quant_prod) {
				System.out.println("O valor informado excede a quantidade disponível no estoque!");
			}else {
				quant_prod -= qtd;
			}
		}
		
		public double valorTotalEstoque() {
			return quant_prod * preco;
		}
}