/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author artur
 */
public class CombosDAO {

    ResultSet resultado = null;

    public void popularComboBox(String tabela, JComboBox comboBox) {
        comboBox.removeAllItems();

        ComboItem item = new ComboItem();
        item.setId(0);
        item.setDescricao("--- Selecione ---");
        comboBox.addItem(item);

        try {
            String dml = "SELECT * FROM "
                    + tabela + " "
                    + "ORDER BY 2;";

            resultado = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    item = new ComboItem();
                    item.setId(resultado.getInt(1));
                    item.setDescricao(resultado.getString(2));

                    comboBox.addItem(item);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular ComboBox: " + e);
        }
    }

    public void definirItemCombo(JComboBox combo, int id) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItem) combo.getItemAt(i)).getId() == id) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
}
