import java.util.Scanner;

public class questao_03 {

	public static void main(String[] args) {
		/*3 - Faça um algoritmo que leia o número de horas trabalhadas de um funcionário, o valor
que ele recebe por hora e calcule o salário desse funcionário. Apresente o salário do
funcionário com duas casas decimais.*/
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("-- Calcula salário --");
		System.out.println("Digite o número de horas trabalhadas: ");
		double horasTrab = sc.nextDouble();
		System.out.println("Digite o valor da hora trabalhada:");
		double valorHoraTrab = sc.nextDouble();
		
		double salario = horasTrab * valorHoraTrab;
		
		System.out.println("--- RESULTADO ---");
		System.out.printf("Hora trabalhada do funcionário: horas", horasTrab);
		System.out.printf("\nValor da hora: %.2f reais", valorHoraTrab);
		System.out.printf("%nSalário final: R$ %.2f", salario);

		sc.close();
	}
}
