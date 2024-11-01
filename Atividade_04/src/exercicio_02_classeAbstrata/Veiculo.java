package exercicio_02_classeAbstrata;

public abstract class Veiculo {
	//variáveis
    protected String placa;
    protected String marca;
    protected String modelo;
    protected int anoFabricacao;

    // Construtor
    public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    // getters e setters
    public String getPlaca() {
		return placa;
	}
    
    public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
    
    // Métodos abstratos
    public abstract double calcularIPVA();
	public abstract void exibirDetalhes();
}