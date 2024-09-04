package calculadora;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//instanciar o objeto
		Calculadora calc = new Calculadora();

		//passar os dados de leitura
		System.out.println("Número 01: ");
		calc.num1 = sc.nextDouble();
		
		System.out.println("Número 02: ");
		calc.num2 = sc.nextDouble();
		
		System.out.println("Soma: " + calc.somar());
		System.out.println("Subtração: " + calc.subtrair());

		sc.close();
	}

}