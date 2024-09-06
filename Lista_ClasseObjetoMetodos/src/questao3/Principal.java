package questao3;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Triangulo triang = new Triangulo();
		
		//passar os dados de leitura
		//TRIANGULO X
		System.out.println("-- Medidas triangulo X --");
		System.out.println("Lado a: ");
		triang.aX = sc.nextDouble();
		
		System.out.println("Lado b: ");
		triang.bX = sc.nextDouble();
		
		System.out.println("Lado c: ");
		triang.cX = sc.nextDouble();
		
		//TRIANGULO Y
		System.out.println("-- Medidas triangulo Y --");
		System.out.println("Lado a: ");
		triang.aY = sc.nextDouble();
		
		System.out.println("Lado b: ");
		triang.bY = sc.nextDouble();
		
		System.out.println("Lado c: ");
		triang.cY = sc.nextDouble();
				
		//calcular area
		double areaX = triang.calcularAreaTrianguloX();
		double areaY = triang.calcularAreaTrianguloY();
		
		//mostrar informação na tela
		System.out.println("------------------------\n");
		System.out.println("-- TRIÂNGULO X --");
		System.out.println("a: " + triang.aX);
		System.out.println("b: " + triang.bX);
		System.out.println("c: " + triang.cX);
		System.out.printf("Área: %.2f cm2\n", areaX);
		
		System.out.println("\n-- TRIÂNGULO Y --");
		System.out.println("a: " + triang.aY);
		System.out.println("b: " + triang.bY);
		System.out.println("c: " + triang.cY);
		System.out.printf("Área: %.2f cm2\n", areaY);
		
		System.out.println("------------------------\n");
		String interpretacao = triang.maiorArea(areaX, areaY);
		System.out.println("MAIOR ÁREA => " + interpretacao);
		
		sc.close();

	}

}