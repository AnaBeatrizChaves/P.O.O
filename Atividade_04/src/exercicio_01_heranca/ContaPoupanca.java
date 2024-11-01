package exercicio_01_heranca;

public class ContaPoupanca extends ContaBancaria {
	private int diaRendimento;

	public ContaPoupanca(String cliente, int numeroConta, Double saldo, int diaRendimento) {
		super(cliente, numeroConta, saldo);
		this.diaRendimento = diaRendimento;	
	}

	public int getDiaRendimento() {
		return diaRendimento;
	}

	public void setDiaRendimento(int diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	
	public void calcularNovoSaldo(double taxaRendimento) {
        saldo += saldo * taxaRendimento;
    }
	
	@Override
	public String toString() {
		return super.toString() + "\nDia de Rendimento: " + diaRendimento;
	}
}