package questao4;

public class Aluno {
	//atributos
	String nome;
	double notaTrim1, notaTrim2, notaTrim3;
	
			
	//metodos
	//intepretar dados
	public double calcularNotaFinal() {
		double notaFinal = notaTrim1 + notaTrim2 + notaTrim3;
		return notaFinal;
	}
	
	public String situacaoFinal(double notaFinal) {
		if(notaFinal >= 70) {
			return "Aprovado(a).";
		}else {
			double pontosFaltaram = 70 - notaFinal;
			System.out.println("\nFaltaram " + pontosFaltaram + " pontos para ser aprovado!");
			return "Reprovado(a).";
		}
	}
}