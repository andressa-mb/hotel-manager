/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.DAO;

import hotel.model.Quartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aulas
 */
public class QuartosDAO {

    private Conexao conexao;
    private Connection conn;
    PreparedStatement stmt;

    public QuartosDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public Integer obterProximoId() {
        Integer proximoId = 1;
        String sql = "SELECT MAX(id) FROM quartos";

        try (Connection conn = conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                proximoId = rs.getInt(1) + 1;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao obter próximo ID: " + e.getMessage());
        }

        return proximoId;
    }

    public void cadastrar(Quartos quarto) {
        String sql = "INSERT INTO quartos(numero, tipo, disponivel, valor_diaria, comodidades) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, quarto.getNumero());
            stmt.setString(2, quarto.getTipo());
            stmt.setBoolean(3, quarto.getDisponivel());
            stmt.setDouble(4, quarto.getValor_diaria());
            stmt.setString(5, quarto.getComodidades());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir o quarto. " + e.getMessage());
        }
    }

    public List<Quartos> getQuartos() {
        String sql = "SELECT * FROM quartos";

        try {
            stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Quartos> listaQuartos = new ArrayList<>();
            while (rs.next()) {
                Quartos quarto = new Quartos(
                        rs.getInt("id"),
                        rs.getInt("numero"),
                        rs.getString("tipo"),
                        rs.getBoolean("disponivel"),
                        rs.getDouble("valor_diaria"),
                        rs.getString("comodidades")
                );
                listaQuartos.add(quarto);
            }
            return listaQuartos;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Quartos> filtrarQuartos(int adultos, int criancas, int valorMaximo, LocalDate dataCheckin, LocalDate dataPrevCheckout) {
        List<Quartos> quartosFiltrados = new ArrayList<>();
        String sql = "SELECT q.* FROM quartos q "
                + "WHERE q.valor_diaria <= ? AND q.capacidade_adultos >= ? AND q.capacidade_criancas >= ? "
                + "AND q.id NOT IN ("
                + "   SELECT r.quartoId FROM reserva r "
                + "   WHERE r.dataCheckin <= ? AND r.dataPrevCheckout >= ?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valorMaximo);
            stmt.setInt(2, adultos);
            stmt.setInt(3, criancas);
            stmt.setDate(4, java.sql.Date.valueOf(dataPrevCheckout));
            stmt.setDate(5, java.sql.Date.valueOf(dataCheckin));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Quartos quarto = new Quartos();
                quarto.setId(rs.getInt("id"));
                quarto.setNumero(rs.getInt("numero"));
                quarto.setTipo(rs.getString("tipo"));
                quarto.setValor_diaria(rs.getDouble("valor_diaria"));
                quarto.setDisponivel(rs.getBoolean("disponivel"));
                quarto.setCapacidadeAdultos(rs.getInt("capacidade_adultos"));
                quarto.setCapacidadeCriancas(rs.getInt("capacidade_criancas"));
                quartosFiltrados.add(quarto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao filtrar quartos: " + e.getMessage());
        }

        return quartosFiltrados;
    }

    public void editar(Quartos quarto) {
        String sql = "UPDATE quartos SET numero = ?, tipo = ?, disponivel = ?, valor_diaria = ?, comodidades = ? WHERE id = ?";
        try {
            stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, quarto.getNumero());
            stmt.setString(2, quarto.getTipo());
            stmt.setBoolean(3, quarto.getDisponivel());
            stmt.setDouble(4, quarto.getValor_diaria());
            stmt.setString(5, quarto.getComodidades());
            stmt.setInt(6, quarto.getId());

            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar o quarto. " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM quartos WHERE id = ?";
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir o quarto. " + e.getMessage());
        }
    }
}
