/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.DAO;

import hotel.model.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aulas
 */
public class UsuariosDAO {

    private Conexao conexao;
    private Connection conn;
    PreparedStatement stmt;

    public UsuariosDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public Integer obterProximoId() {
        Integer proximoId = 1;
        String sql = "SELECT MAX(id) FROM usuarios";

        try (Connection conn = conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                proximoId = rs.getInt(1) + 1;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao obter próximo ID: " + e.getMessage());
        }

        return proximoId;
    }

    public void cadastrar(Usuarios usuario) {
        String sql = "INSERT INTO usuarios (perfilUsuarioId, nome, endereco, telefone, email, senha, preferencias, dataCadastro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getPerfilUsuarioId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEndereco());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getPreferencias());
            stmt.setDate(8, java.sql.Date.valueOf(usuario.getDataCadastro()));
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
        }
    }

    public void adminEdita(Usuarios usuario) {
        String sql = "UPDATE usuarios SET perfilUsuarioId = ?, nome = ?, endereco = ?, telefone = ?, email = ?, senha = ?, preferencias = ? WHERE id = ? ";
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getPerfilUsuarioId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEndereco());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getPreferencias());
            stmt.setInt(8, usuario.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar usuário: " + e.getMessage());
        }
    }

    public void hospedeEdita(Usuarios usuario) {
        String sql = "UPDATE usuarios SET nome = ?, endereco = ?, telefone = ?, email = ?, senha = ?, preferencias = ? WHERE id = ? ";
        try {
            stmt = this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getPreferencias());
            stmt.setInt(7, usuario.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar usuário: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir o usuário: " + e.getMessage());
        }
    }

    public List<Usuarios> getUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try {
            stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Usuarios> listaUsuarios = new ArrayList<>();
            while (rs.next()) {
                Usuarios user = new Usuarios(
                        rs.getInt("id"),
                        rs.getInt("perfilUsuarioId"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("preferencias"),
                        rs.getDate("dataCadastro") != null
                        ? rs.getDate("dataCadastro").toLocalDate() : null
                );
                listaUsuarios.add(user);
            }
            return listaUsuarios;
        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
            return null;
        }
    }
}
