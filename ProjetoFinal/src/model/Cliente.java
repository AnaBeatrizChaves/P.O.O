package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dao.ConnectionFactory;
import dao.TransacaoDAO;

public class Cliente extends Usuario {
	//variaveis
    private String senha;
    private List<Conta> contas; //contas associadas ao cliente

    //construtor
	public Cliente(int id_usuario, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco, String senha,  List<Conta> contas) {
		super(id_usuario, nome, cpf, dataNascimento, telefone, endereco);
		this.senha= senha;
		this.contas = new ArrayList<>();
	}
  
    //getters e setters
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	//metodo herdados
	@Override
	public boolean login(String senha) {
		return this.senha.equals(senha);
	}
	    
	@Override
	public void logout() {
		System.out.println("Cliente " + getNome() + " desconectado.");
	}
	    
	@Override
	public String consultarDados() {
		return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nTelefone: " + getTelefone() + "\nEndereço: " + getEndereco();
	}
    
	//metodos
	public double consultarSaldo(int numeroConta) {
		 Conta conta = buscarConta(numeroConta);
	        return conta != null ? conta.consultarSaldo() : 0.0;
	}
	
	public void depositar (int numeroConta, double valor) {
		Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
	}
	
	public boolean sacar (int numeroConta, double valor) {
		Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
        return false;
	}
	
	 private Conta buscarConta(int numeroConta) {
	        for (Conta conta : contas) {
	            if (conta.getNumero() == numeroConta) {
	                return conta;
	            }
	        }
	        return null;
	    }
	
	public String consultarExtrato(int numeroConta) {
		 Conta conta = buscarConta(numeroConta);
		    if (conta == null) {
		        return "Conta não encontrada.";
		    }

		    List<Transacao> transacoes;
		    try (Connection connection = ConnectionFactory.conectar()) {
		        TransacaoDAO transacaoDAO = new TransacaoDAO(connection);
		        transacoes = transacaoDAO.buscarTransacoesPorConta(conta.getNumero());
		    } catch (SQLException e) {
		        return "Erro ao consultar extrato: " + e.getMessage();
		    }

		    StringBuilder extrato = new StringBuilder();
		    extrato.append("Extrato da Conta ").append(numeroConta).append(":\n");
		    for (Transacao transacao : transacoes) {
		        extrato.append(transacao.toString()).append("\n");
		    }

		    return extrato.toString();
	}
	
	public double consultarLimite(int numeroConta) {
		Conta conta = buscarConta(numeroConta);
        if (conta instanceof ContaCorrente) {
            return ((ContaCorrente) conta).getLimite();
        }
        return 0.0;
	}
}
