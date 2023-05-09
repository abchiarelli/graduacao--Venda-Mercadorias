/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oficinamecanica;

import javax.swing.JOptionPane;
import tela.FrmPrincipal;
import java.sql.*;

/**
 *
 * @author artur
 */
public class OficinaMecanica {
    
    static Connection conexao = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (abrirConexao()) {
            new FrmPrincipal().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com Banco de Dados.");
        }
    }

    private static boolean abrirConexao() {
        try {
            String dbDriver = "org.postgresql.Driver";
            String dbURL = "jdbc:postgresql://localhost:5432/oficina";
            String dbUser = "postgres";
            String dbPass = "postgres123";
            
            //Carrega Driver do Banco de Dados
            Class.forName(dbDriver);
            
            if (dbUser.length() != 0) //conexão COM usuário e senha;
            {
                conexao = DriverManager.getConnection(dbURL, dbUser, dbPass);
            } else { //conexão SEM usuário e senha
                conexao = DriverManager.getConnection(dbURL);
            }
            
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao tentar conectar: " + e);
            return false;
        }
    }

}
