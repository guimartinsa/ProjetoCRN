// src/log/DBLog.java
package log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBLog implements ILog {

    private static final String URL = "jdbc:sqlite:log.db";  // Caminho para o banco de dados SQLite

    static {
        try {
            // Criação da tabela caso não exista
            Connection connection = DriverManager.getConnection(URL);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS log (" +
                    "nome_usuario TEXT, " +
                    "data TEXT, " +
                    "hora TEXT, " +
                    "codigo_pedido INTEGER, " +
                    "nome_operacao TEXT, " +
                    "nome_cliente TEXT)";
            connection.createStatement().execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registrarLog(String nomeUsuario, String data, String hora, int codigoPedido, String nomeOperacao, String nomeCliente) {
        String sql = "INSERT INTO log (nome_usuario, data, hora, codigo_pedido, nome_operacao, nome_cliente) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nomeUsuario);
            pstmt.setString(2, data);
            pstmt.setString(3, hora);
            pstmt.setInt(4, codigoPedido);
            pstmt.setString(5, nomeOperacao);
            pstmt.setString(6, nomeCliente);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
