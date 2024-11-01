package exercicio_02_classeAbstrata;

public class GerenciadorFrota {
    public static void main(String[] args) {
        Veiculo carro = new Carro("BIA-3698", "Volkswagen", "Nivus", 2024);
        Veiculo caminhao = new Caminhao("IKJ-4125", "Scania", "R450", 2017);
        Veiculo onibus = new Onibus("PYH-0123", "Mercedes", "Sprinter", 2022);

        carro.exibirDetalhes();
        caminhao.exibirDetalhes();
        onibus.exibirDetalhes();
    }
}