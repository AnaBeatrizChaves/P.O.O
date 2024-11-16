package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
	//variaveis
    protected int numero;
    protected String agencia;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes; // Lista para armazenar as transações

    //construtor
    public Conta(int numero, String agencia, double saldo, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }
    
    //getters e setters
    public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	//metodos abstratos
    public abstract void depositar(double valor);
    public abstract boolean sacar(double valor);
    public abstract double consultarSaldo();
    
    protected void registrarTransacao(String tipo, double valor) {
        transacoes.add(new Transacao(tipo, valor, java.time.LocalDateTime.now()));
    }
}
