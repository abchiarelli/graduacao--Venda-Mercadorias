/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
            campo.setFormatterFactory(new DefaultFormatterFactory(mascara2));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static String removerFormatacao(String dadoFormatado) {
        String retorno = "";

        for (int i = 0; i < dadoFormatado.length(); i++) {
            if (dadoFormatado.charAt(i) != '.' && dadoFormatado.charAt(i) != '/' && dadoFormatado.charAt(i) != '-') {
                retorno = retorno + dadoFormatado.charAt(i);
            }
        }

        return retorno;
    }

    public static String ajustaDataDMA(String data) {
        String dataFormatada = null;
        try {
            Date dataAMD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAMD);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String ajustaDataAMD(String data) {
        String dataFormatada = null;
        try {
            Date dataDMA = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(dataDMA);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String getDataAtual() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = df.format(now);

        return dataHoje;
    }

    public static LocalDate stringToLocalDate(String dataDMA) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataDMA, format);
        return data;
    }

    public static String localDateToString(LocalDate data) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(format);
    }

    public static Color colorPassed() {
        return Color.decode("#91FF91");
    }

    public static Color colorError() {
        return Color.decode("#FF9191");
    }

    public static Color colorNeutral() {
        return Color.WHITE;
    }

    public static String mensagemErroPreenchimento() {
        return "Há campo(s) com erro de preenchimento.";
    }
}
