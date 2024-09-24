import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        String dataAtual = "2024-09-23"; // Data atual fixa para fins de exemplo

        while (true) {
            System.out.println("\n1. Criar tarefa");
            System.out.println("2. Alterar tarefa");
            System.out.println("3. Concluir tarefa");
            System.out.println("4. Verificar tarefas atrasadas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    // Criar tarefa
                    System.out.print("Descrição da tarefa: ");
                    String descricao = sc.nextLine();
                    System.out.print("Prazo (YYYY-MM-DD): ");
                    String prazo = sc.nextLine();
                    
                    // Coletar dados do usuário responsável
                    System.out.print("Nome do responsável: ");
                    String nomeUsuario = sc.nextLine();
                    System.out.print("Departamento do responsável: ");
                    String departamentoUsuario = sc.nextLine();
                    
                    // Cria o objeto Usuario
                    Usuario usuario = new Usuario(nomeUsuario, departamentoUsuario);
                    
                    // Adiciona a tarefa com o objeto Usuario
                    tarefas.add(new Tarefa(descricao, prazo, usuario));
                    System.out.println("Tarefa criada com sucesso!");
                    break;

                case 2:
                    // Alterar status da tarefa
                    System.out.println("Selecione a tarefa para alterar:");
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println(i + 1 + ". " + tarefas.get(i).getDescricao());
                    }
                    int index = sc.nextInt() - 1;
                    sc.nextLine(); // Limpar buffer
                    if (index >= 0 && index < tarefas.size()) {
                        System.out.println("1. Pendente");
                        System.out.println("2. Em Andamento");
                        System.out.println("3. Concluída");
                        System.out.print("Escolha o novo status: ");
                        int statusOption = sc.nextInt();
                        sc.nextLine(); // Limpar buffer

                        switch (statusOption) {
                            case 1:
                                tarefas.get(index).setStatus("Pendente");
                                break;
                            case 2:
                                tarefas.get(index).setStatus("Em Andamento");
                                break;
                            case 3:
                                tarefas.get(index).setStatus("Concluída");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                        System.out.println("Status alterado com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case 3:
                    // Concluir tarefa
                    System.out.println("Selecione a tarefa para concluir:");
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println(i + 1 + ". " + tarefas.get(i).getDescricao());
                    }
                    int taskIndex = sc.nextInt() - 1;
                    if (taskIndex >= 0 && taskIndex < tarefas.size()) {
                        tarefas.get(taskIndex).setStatus("Concluída");
                        System.out.println("Tarefa concluída com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;

                case 4:
                    // Verificar tarefas atrasadas
                    System.out.println("Tarefas atrasadas:");
                    for (Tarefa tarefa : tarefas) {
                        if (tarefa.isAtrasada(dataAtual)) {
                            tarefa.exibirTarefa();
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    // Sair do programa
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
