package model;

public class ContaPoupanca extends Conta {
	//variaveis
    private double taxaRendimento;

    //construtor
    public ContaPoupanca(int numero, String agencia, double saldo, Cliente cliente, double taxaRendimento) {
        super(numero, agencia, saldo, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    //getters e setters
    public double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	
	//metodos herdados
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
      
	@Override
	public boolean sacar(double valor) {
		 if (saldo >= valor) {
	            saldo -= valor;
	            return true;
	        }
	        return false;
	}
	    
	@Override
	public double consultarSaldo() {
		 return saldo;
	}
	
	//metodo
	public double calcularRendimento() {
		return saldo * taxaRendimento;
    }
}
