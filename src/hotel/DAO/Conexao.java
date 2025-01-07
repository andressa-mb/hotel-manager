/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author aulas
 */
public class Conexao {

    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelbd", "root", "root123");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco. " + e.getMessage(), "Erro", 0, null);
            System.out.println("Erro ao conectar no banco. " + e.getMessage());
            return null;
        }
    }

}
