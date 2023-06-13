/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author artur
 */
public class Relatorios {
    public void gerarRelatorio(String caminho) {
        try {
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream(caminho));
            Map parametros = new HashMap();
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstancia().getConexao());
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            System.out.println("Erro ao gerar relatório: " + e);
            JOptionPane.showMessageDialog(null, "Houve algum problema ao gerar relatório.");
        }
    }
}
