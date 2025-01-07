/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel.telas;

import hotel.DAO.UsuariosDAO;
import hotel.model.Usuarios;
import hotel.telas.TelaCadastro;
import hotel.telas.TelaInicial;
import hotel.telas.TelaPrincipalAdmin;
import hotel.telas.TelaPrincipalHospedes;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aulas
 */
public class TelaLogin extends javax.swing.JFrame {

    UsuariosDAO usuariosDao = new UsuariosDAO();
    private List<Usuarios> listaUsuarios = usuariosDao.getUsuarios();
    private static Usuarios usuarioLogado = null;

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static Usuarios getUsuarioLogado() {
        return usuarioLogado;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTela1 = new javax.swing.JPanel();
        pnlTela2 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTela1.setBackground(new java.awt.Color(194, 208, 255));
        pnlTela1.setForeground(new java.awt.Color(204, 204, 204));

        pnlTela2.setBackground(new java.awt.Color(255, 255, 255));

        txtEmail.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtSenha.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblSenha.setText("SENHA:");

        lblLogin.setFont(new java.awt.Font("Perpetua", 0, 36)); // NOI18N
        lblLogin.setText("LOGIN");

        lblEmail.setFont(new java.awt.Font("Perpetua", 0, 24)); // NOI18N
        lblEmail.setText("E-MAIL:");

        btnCadastrar.setBackground(new java.awt.Color(22, 60, 251));
        btnCadastrar.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEntrar.setBackground(new java.awt.Color(22, 60, 251));
        btnEntrar.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ENTRAR");
        btnEntrar.setBorderPainted(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTela2Layout = new javax.swing.GroupLayout(pnlTela2);
        pnlTela2.setLayout(pnlTela2Layout);
        pnlTela2Layout.setHorizontalGroup(
            pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela2Layout.createSequentialGroup()
                .addGroup(pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTela2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEmail)
                            .addComponent(lblSenha)
                            .addComponent(txtEmail)
                            .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
                    .addGroup(pnlTela2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(141, 141, 141)))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTela2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTela2Layout.setVerticalGroup(
            pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblLogin)
                .addGap(30, 30, 30)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(pnlTela2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        txtEmail.getAccessibleContext().setAccessibleName("Inserir e-mail");
        txtEmail.getAccessibleContext().setAccessibleDescription("Campo para inserir e-mail");
        txtSenha.getAccessibleContext().setAccessibleName("Inserir a senha");
        txtSenha.getAccessibleContext().setAccessibleDescription("Campo para inserir a senha");
        btnCadastrar.getAccessibleContext().setAccessibleDescription("Botão para fazer login na conta");

        javax.swing.GroupLayout pnlTela1Layout = new javax.swing.GroupLayout(pnlTela1);
        pnlTela1.setLayout(pnlTela1Layout);
        pnlTela1Layout.setHorizontalGroup(
            pnlTela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(pnlTela2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        pnlTela1Layout.setVerticalGroup(
            pnlTela1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTela1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(pnlTela2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTela1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastro cadastro = new TelaCadastro();
        cadastro.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        boolean loginSucesso = false;
        boolean existe = false;
        int perfil = 0;

        for (Usuarios user : listaUsuarios) {
            if (user.getEmail().trim().equalsIgnoreCase(email.trim()) && user.getSenha().trim().equals(senha.trim())) {
                existe = true;
                loginSucesso = true;
                usuarioLogado = user;
                perfil = user.getPerfilUsuarioId();
                break;
            }
        }

        if (existe) {
            TelaPrincipalAdmin admin = new TelaPrincipalAdmin(usuarioLogado);
            TelaPrincipalHospedes hosp = new TelaPrincipalHospedes(usuarioLogado);
            switch (perfil) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    //administrador
                    admin.setVisible(true);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    //operador
                    admin.setVisible(true);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    //hospede
                    hosp.setVisible(true);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
        }

    }//GEN-LAST:event_btnEntrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnlTela1;
    private javax.swing.JPanel pnlTela2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
