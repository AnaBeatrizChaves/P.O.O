package exercicio_02_classeAbstrata;

public class Carro extends Veiculo {
	//variaveis
    private static final double taxa_IPVA = 0.04;
    private static final double reducao_anual = 2000.0;

    public Carro(String placa, String marca, String modelo, int anoFabricacao) {
        super(placa, marca, modelo, anoFabricacao);
    }

    @Override
    public double calcularIPVA() {
        double valorEstimado = calcularValorEstimado();
        return valorEstimado * taxa_IPVA;
    }

    private double calcularValorEstimado() {
        int anos = 2024 - anoFabricacao;
        return Math.max(0, 63000 - anos * reducao_anual); //usando uma das bibliotecas matemáticas do JAVA 
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--------> CARRO 🚗 \n- Placa: " + placa + "\n- Marca: " + marca + "\n- Modelo: " + modelo +
                "\n- Ano: " + anoFabricacao + "\n- IPVA: R$" + calcularIPVA());
    }
}
