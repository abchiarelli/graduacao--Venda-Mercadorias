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

            String dml = "INSERT INTO cidade VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getNome()
                    + "');";

            System.out.println("dml: " + dml);

            int retorno = st.executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cidade o) {
        String dml = "UPDATE cidade SET "
                + "descricao = '" + o.getNome() + "' "
                + "WHERE id = " + o.getId() + ";";

        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            System.out.println(dml);

            int resultado = st.executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao ALTERAR Cidade: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        String dml = "DELETE FROM cidade "
                + "WHERE id = " + id + ";";
        
        try {
            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();
            int result = st.executeUpdate(dml);
            
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao excluir Cidade: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Cidade> consultarTodos() {
        ArrayList<Cidade> cidades = new ArrayList<>();

        try {

            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            String dml = "SELECT * "
                    + "FROM cidade "
                    + "ORDER BY descricao;";

            ResultSet rs = st.executeQuery(dml);

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

            String dml = "SELECT * "
                    + "FROM cidade "
                    + "WHERE id = " + id + ";";

            ResultSet rs = st.executeQuery(dml);

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
