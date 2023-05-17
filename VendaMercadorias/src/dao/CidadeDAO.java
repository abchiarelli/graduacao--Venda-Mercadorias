/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cidade;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author artur
 */
public class CidadeDAO implements IDAOT<Cidade> {

    @Override
    public String salvar(Cidade o) {

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            String sql = "INSERT INTO cidade VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getNome()
                    + "');";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cidade o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cidade> consultarTodos() {
        ArrayList<Cidade> cidades = new ArrayList<>();

        try {

            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            String sql = "SELECT * "
                    + "FROM cidade "
                    + "ORDER BY descricao;";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("descricao");

                Cidade cidade = new Cidade(id, nome);

                cidades.add(cidade);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar CIDADES: " + e);
        }

        return cidades;
    }

    @Override
    public ArrayList<Cidade> consultar(String criterio) {
        ArrayList<Cidade> cidades = new ArrayList<>();

        try {

            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            ResultSet rs = st.executeQuery(criterio);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("descricao");

                Cidade cidade = new Cidade(id, nome);

                cidades.add(cidade);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar CIDADES: " + e);
        }

        return cidades;
    }

    @Override
    public Cidade consultarId(int id) {

        try {

            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            String sql = "SELECT * "
                    + "FROM cidade "
                    + "WHERE id = " + id + ";";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("descricao");

                Cidade cidade = new Cidade(id, nome);

                return cidade;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar CIDADES: " + e);
        }

        return null;
    }

}
