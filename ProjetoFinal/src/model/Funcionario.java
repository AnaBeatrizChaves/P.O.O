package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import dao.ConnectionFactory;

public class Funcionario extends Usuario {
	//variaveis
    private String codigoFuncionario;
    private String cargo;
    private String senha;

    //construtor
    public Funcionario(int id_usuario, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco, String codigoFuncionario, String cargo, String senha) {
        super(id_usuario, nome, cpf, dataNascimento, telefone, endereco);
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo;
        this.senha = senha;
    }

    //getter e setters
    public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    //metodos herdados
    @Override
    public boolean login(String senha) {
    	 return this.senha.equals(senha);
    }
    
    @Override
    public void logout() {
    	 System.out.println("Funcionário desconectado.");
    }
    
    @Override
    public String consultarDados() {
    	return "Código: " + codigoFuncionario + ", Nome: " + getNome() + ", Cargo: " + cargo + ", CPF: " + getCpf();

    }
    
    //metodos
    public void abrirConta (Conta conta) {
    	System.out.println("Conta " + conta.getNumero() + " aberta com sucesso.");
    }
    
    public void encerrarConta (Conta conta) {
    	 System.out.println("Conta " + conta.getNumero() + " encerrada com sucesso.");
    }
    
    public Conta consultarDadosConta (int numero_conta) {
    	Conta conta = null;
        try (Connection conn = ConnectionFactory.conectar()) {
            String sql = "SELECT * FROM conta WHERE numero_conta = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, numero_conta);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String tipoConta = rs.getString("tipo_conta");
                if ("POUPANCA".equals(tipoConta)) {
                    conta = new ContaPoupanca(
                        rs.getInt("id_conta"),
                        rs.getString("numero_conta"),
                        rs.getDouble("saldo"),
                        null, // Substituir por lógica para buscar o cliente
                        rs.getDouble("taxa_rendimento")
                    );
                } else if ("CORRENTE".equals(tipoConta)) {
                    conta = new ContaCorrente(
                        rs.getInt("id_conta"),
                        rs.getString("numero_conta"),
                        rs.getDouble("saldo"),
                        null, // Substituir por lógica para buscar o cliente
                        rs.getDouble("limite"),
                        rs.getDate("data_vencimento").toLocalDate()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conta;
    }
    
    public Conta consultarDadosCliente (int id_cliente) {
		return null;
    }
    
    public void alterarDadosConta (Conta conta) {
    	System.out.println("Dados da conta " + conta.getNumero() + " alterados.");
    }
    
    public void alterarDadosCliente (Cliente cliente) {
    	 System.out.println("Dados do cliente " + cliente.getNome() + " alterados.");
    }
    
    public void cadastrarFuncionario (Funcionario funcionario) {
    	System.out.println("Funcionário " + funcionario.getNome() + " cadastrado com sucesso.");
    }
    
    public void gerarRelatorioMovimentacao() {
    	System.out.println("Relatório de movimentação gerado com sucesso.");
    	
    }
    
}
