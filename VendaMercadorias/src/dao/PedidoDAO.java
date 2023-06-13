/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
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
                    + o.getIdCliente()
                    + ") returning id;";

            System.out.println("Pedidos > salvar() DML: " + dml);

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Pedido> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido consultarId(int id) {
        Pedido pedido = null;

        try {
            String dml = "SELECT * FROM pedido WHERE id = " + id + ";";
            
            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);
            
            if(rs.isBeforeFirst()) {
                while (rs.next()) {
                    String data = rs.getString("data");
                    String endereco = rs.getString("endereco_entrega");
                    String observacao = rs.getString("observacao");
                    int idCliente = rs.getInt("cliente_id");
                    
                    pedido = new Pedido(id, data, endereco, observacao, idCliente);
                }
            }
        } catch (Exception e) {
            System.out.println("Pedido > consultarId() ERROR: " + e);
        }
        
        return pedido;
    }

}
