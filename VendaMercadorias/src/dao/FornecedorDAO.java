/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Fornecedor;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author artur
 */
public class FornecedorDAO implements IDAOT<Fornecedor> {

    @Override
    public String salvar(Fornecedor o) {

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            String DML = "INSERT INTO fornecedor VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getTelefone() + "', "
                    + "'" + o.getCnpj() + "'"
                    + ");";

            System.out.println("DML: " + DML);
            
            int retorno = st.executeUpdate(DML);

            return null;
        } catch (Exception e) {
            return e.toString();
        }

    }

    @Override
    public String atualizar(Fornecedor o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {

        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            String DML = "SELECT * FROM fornecedor ORDER BY nome;";

            ResultSet rs = st.executeQuery(DML);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String cnpj = rs.getString("cnpj");
                
                Fornecedor fornecedor = new Fornecedor(id, nome, email, telefone, cnpj);
                
                fornecedores.add(fornecedor);
            }
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }

        return fornecedores;
    }

    @Override
    public ArrayList<Fornecedor> consultar(String criterio) {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            ResultSet rs = st.executeQuery(criterio);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String cnpj = rs.getString("cnpj");
                
                Fornecedor fornecedor = new Fornecedor(id, nome, email, telefone, cnpj);
                
                fornecedores.add(fornecedor);
            }
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }

        return fornecedores;
    }

    @Override
    public Fornecedor consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
