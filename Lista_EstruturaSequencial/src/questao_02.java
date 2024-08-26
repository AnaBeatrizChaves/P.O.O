import javax.swing.JOptionPane;

public class questao_02 {

	public static void main(String[] args) {
		/*2 - Faça um programa para ler o valor de um círculo, e depois mostre o valor da área
deste círculo com quatro casas decimais. Você deverá utilizar o JOptionPane*/
		
		String raio = JOptionPane.showInputDialog("Digite o valor do raio em cm: ");
	
		double valor = Double.parseDouble(raio); 
		
		double area = 3.14 * (valor * valor);
		
		JOptionPane.showMessageDialog(null, String.format ("Área do círculo = %.4f", area, "cm2")); //formatar as casas decimais da saída
	}
}
