/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.DAO;

import hotel.model.Quartos;
import hotel.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aulas
 */
public class ReservaDAO {

    private Conexao conexao;
    private Connection conn;
    PreparedStatement stmt;

    public ReservaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public Integer obterProximoId() {
        Integer proximoId = 1;
        String sql = "SELECT MAX(id) FROM reserva";

        try (Connection conn = conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                proximoId = rs.getInt(1) + 1;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao obter próximo ID: " + e.getMessage());
        }

        return proximoId;
    }

    public void cadastrar(Reserva reserva) {
        String sql = "INSERT INTO reserva (hospedeId, quartoId, dataCheckin, dataPrevCheckout, dataCheckout, status, detalhesPagamento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, reserva.getHospedeId());
            stmt.setInt(2, reserva.getQuartoId());
            stmt.setDate(3, java.sql.Date.valueOf(reserva.getDataCheckin()));
            stmt.setDate(4, java.sql.Date.valueOf(reserva.getDataPrevCheckout()));
            if (reserva.getDataCheckout() != null) {
                stmt.setDate(5, java.sql.Date.valueOf(reserva.getDataCheckout()));
            } else {
                stmt.setNull(5, java.sql.Types.DATE);
            }
            stmt.setInt(6, reserva.getStatus());
            stmt.setString(7, reserva.getDetalhesPagamento());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir reserva: " + e.getMessage());
        }
    }

    public void editarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET hospedeId = ?, quartoId = ?, dataCheckin = ?, dataPrevCheckout = ?, dataCheckout = ?, status = ?, detalhesPagamento = ? WHERE id = ? ";

        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, reserva.getHospedeId());
            stmt.setInt(2, reserva.getQuartoId());
            stmt.setDate(3, java.sql.Date.valueOf(reserva.getDataCheckin()));
            stmt.setDate(4, java.sql.Date.valueOf(reserva.getDataPrevCheckout()));
            if (reserva.getDataCheckout() != null) {
                stmt.setDate(5, java.sql.Date.valueOf(reserva.getDataCheckout()));
            } else {
                stmt.setNull(5, java.sql.Types.DATE);
            }
            stmt.setInt(6, reserva.getStatus());
            stmt.setString(7, reserva.getDetalhesPagamento());
            stmt.setInt(8, reserva.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar reserva: " + e.getMessage());
        }
    }

    public void excluirReserva(int id) {
        String sql = "DELETE FROM reserva WHERE id = ?";
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir a reserva: " + e.getMessage());
        }
    }

    public List<Reserva> getReservas() {
        String sql = "SELECT * FROM reserva";
        try {
            stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Reserva> listaReserva = new ArrayList<>();
            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("id"),
                        rs.getInt("hospedeId"),
                        rs.getInt("quartoId"),
                        rs.getDate("dataCheckin").toLocalDate(),
                        rs.getDate("dataPrevCheckout").toLocalDate(),
                        rs.getDate("dataCheckout") != null ? rs.getDate("dataCheckout").toLocalDate() : null,
                        rs.getInt("status"),
                        rs.getString("detalhesPagamento")
                );
                listaReserva.add(reserva);
            }
            return listaReserva;
        } catch (Exception e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
            return null;
        }
    }

    public List<Reserva> getReservasUsuario(int hospedeId) {
        String sql = "SELECT * FROM reserva WHERE hospedeId = ?";
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, hospedeId);
            ResultSet rs = stmt.executeQuery();

            List<Reserva> reservasDoUsuario = new ArrayList<>();
            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("id"),
                        rs.getInt("hospedeId"),
                        rs.getInt("quartoId"),
                        rs.getDate("dataCheckin").toLocalDate(),
                        rs.getDate("dataPrevCheckout").toLocalDate(),
                        rs.getDate("dataCheckout") != null ? rs.getDate("dataCheckout").toLocalDate() : null,
                        rs.getInt("status"),
                        rs.getString("detalhesPagamento")
                );
                reservasDoUsuario.add(reserva);
            }
            return reservasDoUsuario;
        } catch (Exception e) {
            System.out.println("Erro ao listar reservas do usuário. " + e.getMessage());
            return null;
        }
    }

    public List<Quartos> getQuartosReservados(int quartoId) {
        List<Quartos> quartosReservados = new ArrayList<>();
        String sql = "SELECT q.* FROM quartos AS q INNER JOIN reserva AS r ON q.id = r.quartoId WHERE r.quartoId = ?";
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, quartoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Quartos quarto = new Quartos();
                quarto.setId(rs.getInt("id"));
                quarto.setNumero(rs.getInt("numero"));
                quarto.setTipo(rs.getString("tipo"));
                quarto.setDisponivel(rs.getBoolean("disponivel"));
                quarto.setValor_diaria(rs.getDouble("valor_diaria"));
                quarto.setComodidades(rs.getString("comodidades"));

                quartosReservados.add(quarto);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar quartos disponíveis. " + e.getMessage());
        }
        return quartosReservados;
    }

    public boolean getDisponibilidadeQuarto(int quartoId, LocalDate checkin, LocalDate prevCheckout) {
        String sql = "SELECT COUNT(*) AS total FROM reserva r "
                + "WHERE r.quartoId = ? "
                + "AND (r.dataCheckin <= ? AND r.dataPrevCheckout >= ?)";

        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, quartoId);
            stmt.setDate(2, java.sql.Date.valueOf(prevCheckout));
            stmt.setDate(3, java.sql.Date.valueOf(checkin));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int total = rs.getInt("total");
                return total == 0;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a disponibilidade do quarto: " + e.getMessage());
        }
        return false;
    }
}
