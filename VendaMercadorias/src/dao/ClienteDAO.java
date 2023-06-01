/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Cliente;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;

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
                    + o.getCidade() + ", "
                    + "'" + Formatacao.localDateToString(o.getNascimento()) + "'"
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
        String dml = "UPDATE cliente SET "
                + "nome = '" + o.getNome() + "', "
                + "email = '" + o.getEmail() + "', "
                + "telefone = '" + o.getTelefone() + "', "
                + "cpf = '" + o.getCpf() + "', "
                + "logradouro = '" + o.getLogradouro() + "', "
                + "id_cidade = " + o.getCidade() + " "
                + "WHERE id = " + o.getId() + ";";

        System.out.println("DML: " + dml);

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            int retorno = st.executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar Cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        String dml = "DELETE FROM cliente WHERE id = " + id;

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            int retorno = st.executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao excluir Cliente: " + e);
            return e.toString();
        }
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
                String dataDB = rs.getString("data_nascimento");
                LocalDate nascimento = Formatacao.stringToLocalDate(Formatacao.ajustaDataDMA(dataDB));

                Cliente cliente = new Cliente(id, nome, email, cpf, telefone, logradouro, cidade, nascimento);

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
                String dataDB = rs.getString("data_nascimento");
                LocalDate nascimento = Formatacao.stringToLocalDate(Formatacao.ajustaDataDMA(dataDB));

                Cliente cliente = new Cliente(id, nome, email, cpf, telefone, logradouro, cidade, nascimento);

                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

        return clientes;
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente cliente = null;

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            String DML = "SELECT * FROM cliente WHERE id = " + id;

            ResultSet rs = st.executeQuery(DML);

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String logradouro = rs.getString("logradouro");
                int cidade = rs.getInt("id_cidade");
                String dataDB = rs.getString("data_nascimento");
                LocalDate nascimento = Formatacao.stringToLocalDate(Formatacao.ajustaDataDMA(dataDB));

                cliente = new Cliente(id, nome, email, cpf, telefone, logradouro, cidade, nascimento);

            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

        return cliente;
    }

}
