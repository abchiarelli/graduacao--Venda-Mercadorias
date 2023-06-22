/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Pedido;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author artur
 */
public class PedidoDAO implements IDAOT<Pedido> {

    @Override
    public String salvar(Pedido o) {
        String retorno = "";

        try {
            String dml = "INSERT INTO pedido VALUES ("
                    + "DEFAULT, "
                    + "'" + o.getData() + "', "
                    + "'" + o.getEndereco() + "', "
                    + "'" + o.getObservacao() + "', "
                    + o.getIdCliente() + ", "
                    + o.getValorTotal() + ", "
                    + o.getIdCidade()
                    + ") returning id;";

            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (rs.next()) {
                retorno = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("Pedidos > conult ERROR: " + e);
            retorno = "ERROR: " + e;
        }

        return retorno;
    }

    @Override
    public String atualizar(Pedido o) {
        try {
            String dml = "UPDATE pedido SET "
                    + "data = '" + o.getData() + "', "
                    + "endereco_entrega = '" + o.getEndereco() + "', "
                    + "observacao = '" + o.getObservacao() + "', "
                    + "cliente_id = " + o.getIdCliente() + ", "
                    + "valor_total = " + o.getValorTotal() + ", "
                    + "cidade_id = " + o.getIdCidade() + " "
                    + "WHERE id = " + o.getId();

            int resp = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("Pedido > atualiza() ERROR: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            String dml = "DELETE FROM pedido WHERE id = " + id + ";";

            int retorno = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("Pedido > delete() ERROR: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Pedido> consultarTodos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            String dml = "SELECT * FROM pedido ORDER BY data";

            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String data = Formatacao.ajustaDataDMA(rs.getString("data"));
                    String endereco = rs.getString("endereco_entrega");
                    String observacao = rs.getString("observacao");
                    int idCliente = rs.getInt("cliente_id");
                    Double valor = rs.getDouble("valor_total");
                    int idCidade = rs.getInt("cidade_id");

                    Pedido pedido = new Pedido(id, data, endereco, observacao, idCliente, valor, idCidade);

                    pedidos.add(pedido);
                }
            }
        } catch (Exception e) {
            System.out.println("Pedido > consultarTodos() ERROR: " + e);
            return null;
        }
        return pedidos;
    }

    @Override
    public ArrayList<Pedido> consultar(String criterio) {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(criterio);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String data = Formatacao.ajustaDataDMA(rs.getString("data"));
                    String endereco = rs.getString("endereco_entrega");
                    String observacao = rs.getString("observacao");
                    int idCliente = rs.getInt("cliente_id");
                    Double valor = rs.getDouble("valor_total");
                    int idCidade = rs.getInt("cidade_id");

                    Pedido pedido = new Pedido(id, data, endereco, observacao, idCliente, valor, idCidade);

                    pedidos.add(pedido);
                }
            }
        } catch (Exception e) {
            System.out.println("Pedido > consultarTodos() ERROR: " + e);
            return null;
        }
        return pedidos;
    }

    @Override
    public Pedido consultarId(int id) {
        Pedido pedido = null;

        try {
            String dml = "SELECT * FROM pedido WHERE id = " + id + ";";

            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String data = rs.getString("data");
                    String endereco = rs.getString("endereco_entrega");
                    String observacao = rs.getString("observacao");
                    int idCliente = rs.getInt("cliente_id");
                    Double valorTotal = rs.getDouble("valor_total");
                    int idCidade = rs.getInt("cidade_id");

                    pedido = new Pedido(id, data, endereco, observacao, idCliente, valorTotal, idCidade);
                }
            }
        } catch (Exception e) {
            System.out.println("Pedido > consultarId() ERROR: " + e);
        }

        return pedido;
    }

}
