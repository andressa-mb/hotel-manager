package hotel.telas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import hotel.model.Quartos;
import hotel.model.Reserva;
import hotel.model.Usuarios;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaInicial extends javax.swing.JFrame {

    private static List<Quartos> listaQuartos = new ArrayList<>();
    private static List<Reserva> listaReservas = new ArrayList<>();
    private static List<Usuarios> listaUsuarios = new ArrayList<>();

    public TelaInicial() {

        initComponents();
        cadastrarQuartos();
        cadastrarReservas();
        usuariosCadastrados();
        preencherTabela();
    }

    public static List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void adicionarUsuario(Usuarios usuario) {
        listaUsuarios.add(usuario);
    }

    public void usuariosCadastrados() {
        if (listaUsuarios.isEmpty()) {
            //Administrador
            listaUsuarios.add(new Usuarios(1, "Carlos Silva", "Rua das Flores, 123, Rio de Janeiro", "(21)91234-5678", "carlos.silva@hotel.com", "senhaSegura123", "Prefere turnos diurnos"));
            listaUsuarios.add(new Usuarios(1, "Ana Costa", "Av. João da Silva, 456, Rio de Janeiro", "(11)97654-3210", "ana.costa@hotel.com", "senhaForte456", "Turno da noite"));
            //Operador
            listaUsuarios.add(new Usuarios(2, "Lucas Oliveira", "Rua dos Campos, 789, Rio de Janeiro", "(21) 99876-5432", "lucas.oliveira@hotel.com", "senhaComplexa789", "Prefere trabalho remoto"));
            listaUsuarios.add(new Usuarios(2, "Maria Souza", "Rua do Porto, 321, Rio de Janeiro", "(13)91234-8765", "maria.souza@hotel.com", "senhaSimples123", "Turno da tarde"));
            //Hospedes
            listaUsuarios.add(new Usuarios(3, "Tomas Silveira", "Rua do Melancia, 521, Fortaleza", "(88)91564-5205", "tomas23@email.com", "senhaS3", "Quarto com varanda"));
            listaUsuarios.add(new Usuarios(3, "Milena Kayla", "Rua do Padre, 699, Porto Alegre", "(51)91966-3641", "milena33k@email.com", "senhaPadrao", ""));
            listaUsuarios.add(new Usuarios(3, "Lucas Martins", "Rua da Costa Verde, 864, São Paulo", "(11)92582-3555", "lucas5ma@email.com", "senha!@#", ""));
        }
    }

    public void cadastrarQuartos() {
        listaQuartos.add(new Quartos(101, "Simples", true, 180.0, "Ar condicionado, Wi-Fi"));
        listaQuartos.add(new Quartos(102, "Simples", true, 180.0, "Ar condicionado, Wi-Fi"));
        listaQuartos.add(new Quartos(103, "Duplo", true, 220.0, "Ar condicionado, TV a cabo"));
        listaQuartos.add(new Quartos(104, "Duplo", true, 220.0, "Ar condicionado, TV a cabo"));
        listaQuartos.add(new Quartos(201, "Suíte", true, 300.0, "Banheira, Wi-Fi, TV a cabo"));
        listaQuartos.add(new Quartos(202, "Suíte", true, 300.0, "Banheira, Wi-Fi, TV a cabo"));
        listaQuartos.add(new Quartos(203, "Suíte com varanda", true, 350.00, "Banheira, Wi-fi, TV a cabo, Vista para o mar"));
        listaQuartos.add(new Quartos(204, "Suíte com varanda", true, 350.00, "Banheira, Wi-fi, TV a cabo, Vista para o mar"));
    }

    public void cadastrarReservas() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        listaReservas.add(new Reserva(6, 8,
                LocalDate.parse("01/10/2024", formatter),
                LocalDate.parse("05/10/2024", formatter),
                null, 3, "Pagamento pendente"));

        listaReservas.add(new Reserva(5, 5,
                LocalDate.parse("03/10/2024", formatter),
                LocalDate.parse("08/10/2024", formatter),
                LocalDate.parse("08/10/2024", formatter), 1, "Pago com cartão"));

        listaReservas.add(new Reserva(7, 1,
                LocalDate.parse("10/10/2024", formatter),
                LocalDate.parse("12/10/2024", formatter),
                LocalDate.parse("12/10/2024", formatter), 1, "Pago em dinheiro"));

        listaReservas.add(new Reserva(7, 3,
                LocalDate.parse("12/10/2024", formatter),
                LocalDate.parse("15/10/2024", formatter),
                null, 3, "Pagamento pendente"));

        listaReservas.add(new Reserva(6, 6,
                LocalDate.parse("15/10/2024", formatter),
                LocalDate.parse("20/10/2024", formatter),
                LocalDate.parse("20/10/2024", formatter), 1, "Pago com transferência bancária"));

        listaReservas.add(new Reserva(5, 4,
                LocalDate.parse("18/10/2024", formatter),
                LocalDate.parse("22/10/2024", formatter),
                null, 1, "Pagamento na chegada"));
    }

    public static List<Reserva> getListaReservasCadastradas() {
        if (listaReservas == null) {
            listaReservas = new ArrayList<>();
        }
        return listaReservas;
    }

    public static List<Quartos> getQuartosCadastrados() {
        if (listaQuartos == null) {
            listaQuartos = new ArrayList<>();
        }
        return listaQuartos;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTela = new javax.swing.JPanel();
        lblBemVindo = new javax.swing.JLabel();
        lblLogoh = new javax.swing.JLabel();
        pnlTelaLateral = new javax.swing.JPanel();
        pnlBusca = new javax.swing.JPanel();
        lblCheckin = new javax.swing.JLabel();
        lblCheckout = new javax.swing.JLabel();
        txtCheckin = new javax.swing.JTextField();
        txtCheckout = new javax.swing.JTextField();
        lblCriancas = new javax.swing.JLabel();
        txtAdultos = new javax.swing.JTextField();
        lblAdultos = new javax.swing.JLabel();
        txtComodidades = new javax.swing.JTextField();
        lblDiaria = new javax.swing.JLabel();
        txtCriancas = new javax.swing.JTextField();
        sldDiaria = new javax.swing.JSlider();
        lblComodidades = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        pnlTelaMain = new javax.swing.JPanel();
        pnScroll = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        lblAviso = new javax.swing.JLabel();
        lblLogof = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTela.setBackground(new java.awt.Color(194, 208, 255));

        lblBemVindo.setFont(new java.awt.Font("Perpetua", 2, 24)); // NOI18N
        lblBemVindo.setText("Bem vindo");

        lblLogoh.setText("LOGO");

        pnlTelaLateral.setBackground(new java.awt.Color(115, 129, 255));

        pnlBusca.setBackground(new java.awt.Color(255, 255, 255));

        lblCheckin.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        lblCheckin.setText("Data do check-in:");

        lblCheckout.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        lblCheckout.setText("Data do check-out:");

        txtCheckin.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N

        txtCheckout.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N

        lblCriancas.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        lblCriancas.setText("Crianças:");

        txtAdultos.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N

        lblAdultos.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        lblAdultos.setText("Adultos:");

        txtComodidades.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N

        lblDiaria.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        lblDiaria.setText("Valor diária:");

        txtCriancas.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N

        sldDiaria.setMajorTickSpacing(50);
        sldDiaria.setMaximum(400);
        sldDiaria.setMinimum(80);
        sldDiaria.setMinorTickSpacing(20);
        sldDiaria.setPaintLabels(true);
        sldDiaria.setPaintTicks(true);

        lblComodidades.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        lblComodidades.setText("Comodidades:");

        btnBuscar.setBackground(new java.awt.Color(22, 60, 251));
        btnBuscar.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorderPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscaLayout = new javax.swing.GroupLayout(pnlBusca);
        pnlBusca.setLayout(pnlBuscaLayout);
        pnlBuscaLayout.setHorizontalGroup(
            pnlBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaLayout.createSequentialGroup()
                .addGroup(pnlBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCriancas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlBuscaLayout.createSequentialGroup()
                                .addGroup(pnlBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCheckin)
                                    .addComponent(lblCheckout))
                                .addGap(0, 27, Short.MAX_VALUE))
                            .addComponent(txtCheckin)
                            .addComponent(txtCheckout)
                            .addComponent(txtAdultos)
                            .addComponent(txtComodidades)
                            .addComponent(lblAdultos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDiaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCriancas)
                            .addComponent(lblComodidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(sldDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlBuscaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBuscaLayout.setVerticalGroup(
            pnlBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCheckin)
                .addGap(1, 1, 1)
                .addComponent(txtCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCheckout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdultos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCriancas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCriancas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblComodidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtComodidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblDiaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTelaLateralLayout = new javax.swing.GroupLayout(pnlTelaLateral);
        pnlTelaLateral.setLayout(pnlTelaLateralLayout);
        pnlTelaLateralLayout.setHorizontalGroup(
            pnlTelaLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTelaLateralLayout.setVerticalGroup(
            pnlTelaLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaLateralLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        pnlTelaMain.setBackground(new java.awt.Color(115, 129, 255));

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número", "Tipo", "Valor diária", "Comodidades"
            }
        ));
        pnScroll.setViewportView(tblLista);

        lblAviso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(255, 0, 51));
        lblAviso.setText("* Para reservar você deve estar logado no sistema.");

        javax.swing.GroupLayout pnlTelaMainLayout = new javax.swing.GroupLayout(pnlTelaMain);
        pnlTelaMain.setLayout(pnlTelaMainLayout);
        pnlTelaMainLayout.setHorizontalGroup(
            pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnScroll)
                    .addGroup(pnlTelaMainLayout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addGap(0, 189, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlTelaMainLayout.setVerticalGroup(
            pnlTelaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblAviso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblLogof.setText("LOGO");

        lblEndereco.setFont(new java.awt.Font("Perpetua", 2, 24)); // NOI18N
        lblEndereco.setText("ENDEREÇO");

        btnLogin.setBackground(new java.awt.Color(204, 204, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 204));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(204, 204, 255));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(0, 0, 204));
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTelaLayout = new javax.swing.GroupLayout(pnlTela);
        pnlTela.setLayout(pnlTelaLayout);
        pnlTelaLayout.setHorizontalGroup(
            pnlTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblLogof)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEndereco)
                .addGap(59, 59, 59))
            .addGroup(pnlTelaLayout.createSequentialGroup()
                .addGroup(pnlTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTelaLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTelaLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblLogoh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelaLayout.createSequentialGroup()
                        .addComponent(lblBemVindo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin)
                        .addGap(54, 54, 54)
                        .addComponent(btnCadastrar)
                        .addGap(74, 74, 74))
                    .addComponent(pnlTelaMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlTelaLayout.setVerticalGroup(
            pnlTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogoh)
                    .addComponent(btnLogin)
                    .addComponent(lblBemVindo)
                    .addComponent(btnCadastrar))
                .addGap(33, 33, 33)
                .addGroup(pnlTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTelaLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTelaMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogof)
                    .addComponent(lblEndereco))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDateIn = LocalDate.parse(txtCheckin.getText(), formatter);
            LocalDate localDateOut = LocalDate.parse(txtCheckout.getText(), formatter);

            System.out.println("Data In (LocalDate): " + localDateIn);
            System.out.println("Data Out (LocalDate): " + localDateOut);
            int adultos = Integer.parseInt(txtAdultos.getText());
            int criancas = Integer.parseInt(txtCriancas.getText());
            String comodidades = txtComodidades.getText();
            int valorMaximo = sldDiaria.getValue();
            System.out.println(valorMaximo);
            boolean qDisponivel = true;

            List<Quartos> quartosFiltrados = new ArrayList<>();
            for (Quartos q : listaQuartos) {
                if (q.getValor_diaria() <= valorMaximo && q.getDisponivel()) {
                    quartosFiltrados.add(q);
                }
            }

            if (quartosFiltrados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum quarto disponível para os filtros informados.");

            } else {
                preencherTabelaDisponivel(quartosFiltrados);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao processar a busca: " + e.getMessage(), "Erro ", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void preencherTabela() {
        DefaultTableModel tabela = (DefaultTableModel) tblLista.getModel();
        tabela.setNumRows(0);

        for (Quartos qt : listaQuartos) {
            if (qt.getDisponivel()) {
                tabela.addRow(new Object[]{
                    qt.getNumero(),
                    qt.getTipo(),
                    qt.getValor_diaria(),
                    qt.getComodidades()
                });
            }
        }
    }

    public void preencherTabelaDisponivel(List<Quartos> quartosFiltrados) {
        DefaultTableModel tabela = (DefaultTableModel) tblLista.getModel();
        tabela.setNumRows(0);

        for (Quartos qt : quartosFiltrados) {
            tabela.addRow(new Object[]{
                qt.getNumero(),
                qt.getTipo(),
                qt.getValor_diaria(),
                qt.getComodidades()
            });
        }
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        TelaLogin tllogin = new TelaLogin();
        this.dispose();
        tllogin.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastro cadastro = new TelaCadastro();
        this.dispose();
        cadastro.setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblAdultos;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblCheckin;
    private javax.swing.JLabel lblCheckout;
    private javax.swing.JLabel lblComodidades;
    private javax.swing.JLabel lblCriancas;
    private javax.swing.JLabel lblDiaria;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblLogof;
    private javax.swing.JLabel lblLogoh;
    private javax.swing.JScrollPane pnScroll;
    private javax.swing.JPanel pnlBusca;
    private javax.swing.JPanel pnlTela;
    private javax.swing.JPanel pnlTelaLateral;
    private javax.swing.JPanel pnlTelaMain;
    private javax.swing.JSlider sldDiaria;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtAdultos;
    private javax.swing.JTextField txtCheckin;
    private javax.swing.JTextField txtCheckout;
    private javax.swing.JTextField txtComodidades;
    private javax.swing.JTextField txtCriancas;
    // End of variables declaration//GEN-END:variables
}