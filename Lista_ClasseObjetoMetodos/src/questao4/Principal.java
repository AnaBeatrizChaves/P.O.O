package questao4;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Aluno aluno1 = new Aluno();
		
		//passar os dados de leitura
		System.out.println("-- CÁLCULO DA NOTA FINAL --");
		System.out.println("Preencha os campos abaixo");
		System.out.println("Nome do aluno(a): ");
		aluno1.nome = sc.nextLine();
		
		//validacao do primeiro trimestre
		System.out.print("Primeiro Trimestre (MÁXIMO 30 pontos): ");
	    aluno1.notaTrim1 = sc.nextDouble();
	    while (aluno1.notaTrim1 > 30) {
	    	System.out.println("Valor inválido! Nota do primeiro trimestre deve ser de até no MÁXIMO 30 pontos.");
	        System.out.print("Digite novamente: ");
	        aluno1.notaTrim1 = sc.nextDouble();
	     }
		
	    //validacao do segundo trimestre
	  	System.out.print("Segundo Trimestre (MÁXIMO 35 pontos): ");
	  	aluno1.notaTrim2 = sc.nextDouble();
	  	while (aluno1.notaTrim2 > 35) {
	  	    System.out.println("Valor inválido! Nota do segundo trimestre deve ser de até no MÁXIMO 35 pontos.");
	  	    System.out.print("Digite novamente: ");
	  	    aluno1.notaTrim2 = sc.nextDouble();
	  	}
	  	    
	  	//validacao do terceiro trimestre
		System.out.print("Terceiro Trimestre (MÁXIMO 35 pontos): ");
		aluno1.notaTrim3 = sc.nextDouble();
		while (aluno1.notaTrim3 > 35) {
		    System.out.println("Valor inválido! Nota do terceiro trimestre deve ser de até no MÁXIMO 35 pontos.");
		    System.out.print("Digite novamente: ");
		    aluno1.notaTrim3 = sc.nextDouble();
		}

		//calculo Final
		double notaFinal = aluno1.calcularNotaFinal();
		
		//mostrar informação na tela
		System.out.println("\n-------------------------");
		System.out.println("--- RESUMO DAS NOTAS ---");
		System.out.println("Primeiro Trimestre: " + aluno1.notaTrim1);
		System.out.println("Segundo Trimestre: " + aluno1.notaTrim2);
		System.out.println("Terceiro Trimestre: " + aluno1.notaTrim3);
		System.out.printf("NOTA FINAL: %.2f pontos", notaFinal);
		System.out.println("\nSITUAÇÃO: " + aluno1.situacaoFinal(notaFinal));
		
		sc.close();
	}

}