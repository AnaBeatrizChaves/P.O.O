package exercicio_01_heranca;

public class ContaEspecial extends ContaBancaria {
	private double limite;

	public ContaEspecial(String cliente, int numeroConta, double saldo, double limite) {
		super(cliente, numeroConta, saldo);
		this.limite = limite;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
    public boolean sacar(double valor) {
        if (saldo + limite >= valor) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saque excede o limite permitido.");
            return false;
        }
    }
	
	@Override
	public String toString() {
		return super.toString() + "\nLimite: " + limite;
	}
}