package controller;

import dao.ClienteDAO;
import dao.ContaDAO;
import dao.FuncionarioDAO;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Funcionario;

import java.sql.SQLException;
import java.time.LocalDate;

public class FuncionarioController {
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ContaDAO contaDAO = new ContaDAO();
    
    public void cadastrarFuncionario(Funcionario funcionario) {
    	funcionarioDAO.cadastrarFuncionario(funcionario);
    }

    public void abrirContaCorrente(String cpfCliente, String agencia, int numero, double saldo, double limite, LocalDate dataVencimento) throws SQLException {
        Cliente cliente = clienteDAO.findClienteByCPF(cpfCliente);
        if (cliente != null) {
            ContaCorrente conta = new ContaCorrente(numero, agencia, saldo, cliente, limite, dataVencimento);
            contaDAO.salvarConta(conta);
        }
    }

    public void abrirContaPoupanca(String cpfCliente, String agencia, int numero, double saldo, double taxaRendimento) throws SQLException {
        Cliente cliente = clienteDAO.findClienteByCPF(cpfCliente);
        if (cliente != null) {
            ContaPoupanca conta = new ContaPoupanca(numero, agencia, saldo, cliente, taxaRendimento);
            contaDAO.salvarConta(conta);
        }
    }

    public String consultarExtrato(int numeroConta) {
        // Supondo que a lógica para buscar a conta já foi implementada
        Conta conta = contaDAO.findByNumero(numeroConta);
        return conta != null ? conta.consultarExtrato() : "Conta não encontrada.";
    }
}
