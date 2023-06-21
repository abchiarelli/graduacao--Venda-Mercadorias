/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Compra;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author artur
 */
public class CompraDAO implements IDAOT<Compra> {

    @Override
    public String salvar(Compra o) {
        String retorno = "";
        try {
            String dml = "INSERT INTO compra VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getData() + "', "
                    + o.getValor() + ", "
                    + o.getIdFornecedor()
                    + ") returning id;";

            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    retorno = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            retorno = "ERROR: " + e;
            System.out.println("Compra > salvar() ERROR: " + e);
        }

        return retorno;
    }

    @Override
    public String atualizar(Compra o) {
        try {
            String dml = "UPDATE compra SET "
                    + "data_compra = '" + o.getData() + "', "
                    + "valor = " + o.getValor() + ", "
                    + "fornecedor_id = " + o.getIdFornecedor() + " "
                    + "WHERE id = " + o.getId();

            int result = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            return null;
        } catch (SQLException e) {
            System.out.println("Compra > atualizar() ERROR: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            String dml = "DELETE FROM compra WHERE id = " + id;

            int result = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            return null;
        } catch (SQLException e) {
            System.out.println("Compra > excluir() ERROR: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Compra> consultarTodos() {
        ArrayList<Compra> compras = new ArrayList<>();

        try {
            String dml = "SELECT * FROM compra ORDER BY data_compra;";

            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String data = rs.getString("data_compra");
                    double valor = rs.getDouble("valor");
                    int idFornecedor = rs.getInt("fornecedor_id");

                    Compra tempCompra = new Compra(id, data, valor, idFornecedor);

                    compras.add(tempCompra);
                }
            }
        } catch (SQLException e) {
            System.out.println("Compra > consultarTodos() ERROR: " + e);
        }

        return compras;
    }

    @Override
    public ArrayList<Compra> consultar(String criterio) {
        ArrayList<Compra> compras = new ArrayList<>();

        try {
            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(criterio);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String data = Formatacao.ajustaDataDMA(rs.getString("data_compra"));
                    double valor = rs.getDouble("valor");
                    int idFornecedor = rs.getInt("fornecedor_id");

                    Compra tempCompra = new Compra(id, data, valor, idFornecedor);

                    compras.add(tempCompra);
                }
            }
        } catch (SQLException e) {
            System.out.println("Compra > consultarTodos() ERROR: " + e);
        }

        return compras;
    }

    @Override
    public Compra consultarId(int id) {
        Compra tempCompra = null;
        try {
            String dml = "SELECT * FROM compra WHERE id = " + id + ";";

            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String data = rs.getString("data_compra");
                    double valor = rs.getDouble("valor");
                    int idFornecedor = rs.getInt("fornecedor_id");

                    tempCompra = new Compra(id, data, valor, idFornecedor);
                }
            }
        } catch (SQLException e) {
            System.out.println("Compra > consultarTodos() ERROR: " + e);
        }
        return tempCompra;
    }

}
