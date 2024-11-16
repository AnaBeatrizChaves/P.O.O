package model;

import java.time.LocalDate;

public class ContaCorrente extends Conta {
	//variaveis
    private double limite;
    private LocalDate dataVencimento;

    //construtor
    public ContaCorrente(int numero, String agencia, double saldo, Cliente cliente, double limite, LocalDate dataVencimento) {
        super(numero, agencia, saldo, cliente);
        this.limite = limite;
        this.dataVencimento = dataVencimento;
    }

    //getters e setters
    public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	//metodos herdados
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
      
	@Override
	public boolean sacar(double valor) {
		if (saldo + limite >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
	}
	    
	@Override
	public double consultarSaldo() {
		 return saldo;
	}
	
	//metodos
    public double consultarLimite() {
    	return limite;
    }
}
