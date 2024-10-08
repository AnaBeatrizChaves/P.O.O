package heranca;

public class Aluno extends Pessoa{
	
	private String curso;

	public Aluno(String nome, int idade, String disciplina) {
		super(nome, idade);
		this.curso = curso;
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public void apresentar() {
		super.apresentar();
		System.out.println("Curso: " + curso);
	}
	
}