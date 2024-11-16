package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Transacao;

public class TransacaoDAO {
    private Connection connection;

    public TransacaoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Transacao> buscarTransacoesPorConta(int idConta) throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT tipo_transacao, valor, data_hora FROM transacao WHERE id_conta = ? ORDER BY data_hora DESC";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idConta);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String tipo = rs.getString("tipo_transacao");
                    double valor = rs.getDouble("valor");
                    Timestamp dataHora = rs.getTimestamp("data_hora");

                    transacoes.add(new Transacao(tipo, valor, dataHora.toLocalDateTime()));
                }
            }
        }
        return transacoes;
    }
}
