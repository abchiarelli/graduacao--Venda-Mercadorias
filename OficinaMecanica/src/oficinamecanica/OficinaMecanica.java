/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oficinamecanica;

import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import tela.FrmPrincipal;

/**
 *
 * @author artur
 */
public class OficinaMecanica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (ConexaoBD.getInstance().getConnection() != null) {
            new FrmPrincipal().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com Banco de Dados.");
        }
    }

}
