import java.util.Scanner;

public class questao_01 {

	public static void main(String[] args) {
		/*1 – Elabore um programa que leia 5 valores e calcule a média aritmética deles. Ao final
do programa, apresente os valores digitados e a média aritmética.*/
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Digite 5 valores");
		System.out.println("Valor 01:");
		double valor01 = sc.nextDouble();
		System.out.println("Valor 02:");
		double valor02 = sc.nextDouble();
		System.out.println("Valor 03:");
		double valor03 = sc.nextDouble();
		System.out.println("Valor 04:");
		double valor04 = sc.nextDouble();
		System.out.println("Valor 05:");
		double valor05 = sc.nextDouble();
		
		double media = (valor01 + valor02 + valor03 + valor04 + valor05) / 5;
		
		System.out.println("--- RESULTADO ---");
		System.out.printf("Números: \n%.2f \n%.2f \n%.2f \n%.2f \n%.2f", valor01, valor02, valor03, valor04, valor05);
		System.out.printf("%nMédia Aritmética: %.2f", media);

		sc.close();
	}

}
