package dao;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {
    public void salvarConta(Conta conta) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            if (conta instanceof ContaCorrente) {
                // Inserir Conta Corrente
                ContaCorrente cc = (ContaCorrente) conta;
                String sql = "INSERT INTO conta_corrente (numero, agencia, saldo, id_cliente, limite, data_vencimento) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, cc.getNumero());
                stmt.setString(2, cc.getAgencia());
                stmt.setDouble(3, cc.getSaldo());
                stmt.setInt(4, cc.getCliente().getId());
                stmt.setDouble(5, cc.consultarLimite());
                stmt.setDate(6, java.sql.Date.valueOf(cc.getDataVencimento()));
                stmt.executeUpdate();
            } else if (conta instanceof ContaPoupanca) {
                // Inserir Conta Poupança
                ContaPoupanca cp = (ContaPoupanca) conta;
                String sql = "INSERT INTO conta_poupanca (numero, agencia, saldo, id_cliente, taxa_rendimento) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, cp.getNumero());
                stmt.setString(2, cp.getAgencia());
                stmt.setDouble(3, cp.getSaldo());
                stmt.setInt(4, cp.getCliente().getId());
                stmt.setDouble(5, cp.getTaxaRendimento());
                stmt.executeUpdate();
            }
        }
    }
}
