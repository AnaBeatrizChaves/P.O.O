public class Tarefa {
    private String descricao;
    private String status;  // Pendente, Em Andamento, Concluída
    private String prazo;   // Formato: YYYY-MM-DD
    private Usuario usuarioResponsavel;  // Associar o usuário responsável

    // Construtor padrão
    public Tarefa() {
        this.descricao = "";
        this.status = "Pendente";
        this.prazo = "0000-00-00";
        this.usuarioResponsavel = new Usuario();  // Inicializa com um objeto vazio
    }

    // Construtor com parâmetros (3 parâmetros)
    public Tarefa(String descricao, String prazo, Usuario usuarioResponsavel) {
        this.descricao = descricao;
        this.status = "Pendente";
        this.prazo = prazo;
        this.usuarioResponsavel = usuarioResponsavel;
    }

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    // Método para verificar se a tarefa está atrasada
    public boolean isAtrasada(String dataAtual) {
        return dataAtual.compareTo(prazo) > 0 && !status.equals("Concluída");
    }

    // Método para exibir a tarefa
    public void exibirTarefa() {
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
        System.out.println("Prazo: " + prazo);
        System.out.println("Responsável: " + usuarioResponsavel.getNome() + " (" + usuarioResponsavel.getDepartamento() + ")");
    }
}
