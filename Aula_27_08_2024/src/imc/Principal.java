package imc;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		// instanciar os objetos
		CalculadoraIMC calcIMC = new CalculadoraIMC();
		
		System.out.println("Peso em Kg: ");
		calcIMC.peso = sc.nextDouble();
		
		System.out.println("Altura em metros: ");
		calcIMC.altura = sc.nextDouble();
		
		//calcularIMC
		double imc = calcIMC.calcularIMC();
		
		String interpretacao = calcIMC.interpretarIMC(imc);
		
		System.out.printf("IMC: %.2f\n", imc);
		System.out.println("Classificação: " + interpretacao);
		
		sc.close();
	}
}