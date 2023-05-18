/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author artur
 */
public class ClienteDAO implements IDAOT<Cliente> {

    @Override
    public String salvar(Cliente o) {

        try {
            String DML = "INSERT INTO cliente VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getTelefone() + "', "
                    + "'" + o.getCpf() + "', "
                    + "'" + o.getLogradouro() + "', "
                    + o.getCidade()
                    + ");";

            System.out.println("DML: " + DML);

            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            int retorno = st.executeUpdate(DML);

            return null;

        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            String DML = "SELECT * FROM cliente ORDER BY nome";

            ResultSet rs = st.executeQuery(DML);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String logradouro = rs.getString("logradouro");
                int cidade = rs.getInt("id_cidade");

                Cliente cliente = new Cliente(id, nome, email, cpf, telefone, logradouro, cidade);

                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

        return clientes;
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            ResultSet rs = st.executeQuery(criterio);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String logradouro = rs.getString("logradouro");
                int cidade = rs.getInt("id_cidade");

                Cliente cliente = new Cliente(id, nome, email, cpf, telefone, logradouro, cidade);

                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

        return clientes;
    }

    @Override
    public Cliente consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
