package dao;

import model.Funcionario;
import java.sql.*;

public class FuncionarioDAO {
    public void cadastrarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (codigo, cargo, nome, cpf, data_nascimento, telefone) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, funcionario.getCodigoFuncionario());
            ps.setString(2, funcionario.getCargo());
            ps.setString(3, funcionario.getNome());
            ps.setString(4, funcionario.getCpf());
            ps.setDate(5, Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(6, funcionario.getTelefone());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
