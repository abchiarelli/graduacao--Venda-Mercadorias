/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author artur
 */
public class Automatizar {

    public static boolean data(JFormattedTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().equals("/  /")) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            if (Validacao.validarDataFormatada(campo.getText())) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        }
    }

    public static boolean cpf(JFormattedTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().equals(".   .   -")) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            if (Validacao.validarCPF(Formatacao.removerFormatacao(campo.getText()))) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        }
    }

    public static boolean cnpj(JFormattedTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().equals(".   .   /    -")) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            if (Validacao.validarCNPJ(Formatacao.removerFormatacao(campo.getText()))) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        }
    }

    public static boolean email(JTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().length() == 0) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            if (Validacao.validarEmail(campo.getText().trim())) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        }
    }

    public static boolean nome(JTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().length() == 0) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            campo.setBackground(Formatacao.colorPassed());
            return false;
        }
    }

    public static boolean logradouro(JTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().length() == 0) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            campo.setBackground(Formatacao.colorPassed());
            return false;
        }
    }

    public static boolean telefone(JFormattedTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().equals("(  )       -")) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            campo.setBackground(Formatacao.colorPassed());
            return false;
        }
    }

    public static boolean comboBox(JComboBox campo, boolean podeSerVazio) {
        if (campo.getSelectedIndex() == 0) {
            if (podeSerVazio) {
                campo.setBorder(BorderFactory.createLineBorder(Formatacao.colorNeutral(), 0));
                return false;
            } else {
                campo.setBorder(BorderFactory.createLineBorder(Formatacao.colorError()));
                return true;
            }
        } else {
            campo.setBorder(BorderFactory.createLineBorder(Formatacao.colorNeutral(), 0));
            return false;
        }
    }

    public static boolean valorDecimal(JTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().length() == 0) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            if (Validacao.validaValorDecimal(campo.getText())) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        }
    }
    
    public static boolean valorQuantidade(JTextField campo, boolean podeSerVazio) {
        if (campo.getText().trim().length() == 0) {
            if (podeSerVazio) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        } else {
            if (Validacao.validaValorQuantidade(campo.getText())) {
                campo.setBackground(Formatacao.colorPassed());
                return false;
            } else {
                campo.setBackground(Formatacao.colorError());
                return true;
            }
        }
    }
}
