package hotel.model;

import hotel.telas.TelaInicial;
import javax.swing.SwingUtilities;

public class SenacUC15Etapa {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaInicial tela = new TelaInicial();
            tela.setVisible(true);
        });

    }

}
