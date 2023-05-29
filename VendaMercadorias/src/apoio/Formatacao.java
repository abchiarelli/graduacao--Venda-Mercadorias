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
            campo.setFormatterFactory(new DefaultFormatterFactory(mascara1, mascara2));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
