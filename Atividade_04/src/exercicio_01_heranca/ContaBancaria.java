package exercicio_01_heranca;

public class ContaBancaria {
	//atributos
	protected String cliente;
	protected int numeroConta;
	protected double saldo;
	
	//construtor
	public ContaBancaria(String cliente, int numeroConta, double saldo) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	//getters e setters
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//metodos
	public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }
    }
	
	public void depositar(double valor) {
        saldo += valor;
    }
	
	@Override
	public String toString() {
		return super.toString() + "\nCliente: " + cliente + 
				"\nNúmero da conta: " + numeroConta + "\nSaldo: " + saldo;
	}
}