import javax.swing.JOptionPane;

public class questao_06 {

	public static void main(String[] args) {
		/*6 - Faça um algoritmo que leia o salário de um funcionário e aplique um aumento de 15%
sobre o salário. Ao final do algoritmo apresente o antigo salário e o salário reajustado
com duas casas decimais. Você deverá utilizar o JOPtionPane.*/
		 
        String salario = JOptionPane.showInputDialog("Digite o salário do funcionário: ");
        
        double valorSalario = Double.parseDouble(salario);
        
        double aumento = valorSalario * 0.15;
        double salarioReajustado = valorSalario + aumento;
        
        JOptionPane.showMessageDialog(null, String.format("Antigo salário: R$ %.2f\nSalário reajustado: R$ %.2f", valorSalario, salarioReajustado));
	}

}
