/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author artur
 */
public class ConexaoBD {

    private static ConexaoBD instancia = null;

    private Connection conexao = null;

    public ConexaoBD() {
        try {
            //leitor de .properties
            Properties prop = new Properties();
            prop.load(new FileInputStream("dbcon.properties"));

            //dados de conexao
            String driver = prop.getProperty("db.driver");
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String pass = prop.getProperty("db.pass");

            //carregamento do driver do BD
            Class.forName(driver);

            if (user.length() != 0) {
                conexao = DriverManager.getConnection(url, user, pass);
            } else {
                conexao = DriverManager.getConnection(url);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    //retorna (cria) instância
    public static ConexaoBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }
    
    //retorna conexão
    public Connection getConexao() {
        return conexao;
    }
    
    //encerra conexão
    public void shutSown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    
    
}
