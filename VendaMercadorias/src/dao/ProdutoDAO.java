/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Produto;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author artur
 */
public class ProdutoDAO implements IDAOT<Produto> {

    @Override
    public String salvar(Produto o) {

        try {
            String dml = "INSERT INTO produto VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getDescricao() + "', "
                    + o.getValor() + ", "
                    + o.getQuantidade()
                    + ");";

            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            int retorno = st.executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Produto o) {
        String dml = "UPDATE produto SET "
                + "descricao = '" + o.getDescricao() + "', "
                + "valor = " + o.getValor() + ", "
                + "quantidade = " + o.getQuantidade() + " "
                + "WHERE id = " + o.getId();
        try {
            int resultado = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar PRODUTO: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        String dml = "DELETE FROM produto WHERE id = " + id;
        
        try {
            int resultado = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao deletar PRODUTO: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Produto> consultarTodos() {
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            String dml = "SELECT * FROM produto ORDER BY descricao";

            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            ResultSet rs = st.executeQuery(dml);

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                float valor = rs.getFloat("valor");
                float quantidade = rs.getFloat("quantidade");

                Produto produto = new Produto(id, descricao, valor, quantidade);

                produtos.add(produto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar PRODUTOS: " + e);
        }

        return produtos;
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        ArrayList<Produto> produtos = new ArrayList<>();

        try {

            Statement st = ConexaoBD.getInstancia().getConexao().createStatement();

            ResultSet rs = st.executeQuery(criterio);

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                float valor = rs.getFloat("valor");
                float quantidade = rs.getFloat("quantidade");

                Produto produto = new Produto(id, descricao, valor, quantidade);

                produtos.add(produto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar PRODUTOS: " + e);
        }

        return produtos;
    }

    @Override
    public Produto consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
