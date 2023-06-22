/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.ResultSet;

/**
 *
 * @author artur
 */
public class Relatorios {

    public void gerarListagem(String caminho) {
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

    public void gerarRelatorioData(String caminho, String dataDe, String dataAte) {
        try {
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream(caminho));

            Map parametros = new HashMap();
            parametros.put("dataDe", dataDe);
            parametros.put("dataAte", dataAte);

            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstancia().getConexao());
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            System.out.println("Erro ao gerar relatório: " + e);
            JOptionPane.showMessageDialog(null, "Houve algum problema ao gerar relatório.");
        }
    }

    public static void gerarCSV(ResultSet rs, String localArquivo) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(localArquivo), ';', '\0', '\0', "\n");
            writer.writeAll(rs, true);
            writer.close();
            JOptionPane.showMessageDialog(null, "Arquivo CSV (.csv) criado com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo CSV (.csv).");
        }
    }
}
