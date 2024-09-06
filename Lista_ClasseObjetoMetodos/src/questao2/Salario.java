package questao2;

public class Salario {
	    //atributos
		String nome;
		double salario;
		
		//metodos
		//intepretar dados
		public double aplicarAumento() {
			if (salario >= 1 && salario <= 1000) {
				System.out.println("-- Aplicado aumento de 15%! --");
				double valorAumento =  salario * 0.15;
				double novoSalario = salario + valorAumento;
				return novoSalario;
			}else if (salario >= 1001 && salario <= 1500) {
				System.out.println("-- Aplicado aumento de 10%! --");
				double valorAumento =  salario * 0.10;
				double novoSalario = salario + valorAumento;
				return novoSalario;
			}else if (salario >= 1501 && salario <= 2000) {
				System.out.println("-- Aplicado aumento de 5%! --");
				double valorAumento =  salario * 0.05;
				double novoSalario = salario + valorAumento;
				return novoSalario;
			}else {
				System.out.println("-- Não há nenhum aumento a ser aplicado! --");
			}
			return salario;
		}
}