public class Usuario {
    private String nome;
    private String departamento;

    // Construtor padrão
    public Usuario() {
        this.nome = "";
        this.departamento = "";
    }

    // Construtor com parâmetros
    public Usuario(String nome, String departamento) {
        this.nome = nome;
        this.departamento = departamento;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Método para exibir informações do usuário
    public void exibirUsuario() {
        System.out.println("Nome: " + nome);
        System.out.println("Departamento: " + departamento);
    }
}
