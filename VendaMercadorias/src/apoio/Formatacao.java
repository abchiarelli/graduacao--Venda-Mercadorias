/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author artur
 */
public class Formatacao {
    
    private String colorError = "#FF9191";

    public String getColorError() {
        return colorError;
    }

    public static void formatarData(JFormattedTextField campo) {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter(' ');
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(mascara));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void formatarCpf(JFormattedTextField campo) {
        try {
            MaskFormatter mascara = new MaskFormatter("###.###.###-##");
            mascara.setPlaceholderCharacter(' ');
            
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(mascara));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void formatarCnpj(JFormattedTextField campo) {
        try {
            MaskFormatter mascara = new MaskFormatter("##.###.###/####-##");
            mascara.setPlaceholderCharacter(' ');
            
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(mascara));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static void formatarTelefone(JFormattedTextField campo) {
        try {
            MaskFormatter mascara1 = new MaskFormatter("(##) ####-####");
            mascara1.setPlaceholderCharacter(' ');
            
            MaskFormatter mascara2 = new MaskFormatter("(##) # ####-####");
            mascara2.setPlaceholderCharacter(' ');
            
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(mascara2));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public static String removerFormatacao(String dadoFormatado) {
        String retorno = "";
        
        for (int i = 0; i < dadoFormatado.length(); i++) {
            if(dadoFormatado.charAt(i) != '.' && dadoFormatado.charAt(i) != '/' && dadoFormatado.charAt(i) != '-') {
                retorno = retorno + dadoFormatado.charAt(i);
            }
        }
        
        return retorno;
    }
}
