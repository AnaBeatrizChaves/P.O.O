import javax.swing.JOptionPane;

public class questao_04 {

	public static void main(String[] args) {
		/*4 - Elabore um programa que apresente o nome e a idade de uma pessoa, considerando
que ela informe apenas o ano de nascimento e o seu nome. O seu programa deverá
apresentar a seguinte mensagem: “Você se chama <nome_digitado> e possui
<idade_calculada> anos de idade!”. Você deverá utilizar o JOptionPane.*/
		
		String nome = JOptionPane.showInputDialog("Digite o seu nome: ");
		String ano = JOptionPane.showInputDialog("Digite o seu ano de nascimento: ");
		
		int valor = Integer.parseInt(ano); 
		
		int idade = 2024 - valor;
		
		JOptionPane.showMessageDialog(null,"Você se chama " + nome + " e possui " + idade + " anos de idade!");
		
	}

}
