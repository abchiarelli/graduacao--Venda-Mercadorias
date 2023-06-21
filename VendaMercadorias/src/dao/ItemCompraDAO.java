/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.ItemCompra;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author artur
 */
public class ItemCompraDAO implements IDAOT<ItemCompra> {

    @Override
    public String salvar(ItemCompra o) {
        try {
            String dml = "INSERT INTO item_compra VALUES ("
                    + o.getIdProduto() + ", "
                    + o.getIdCompra() + ", "
                    + o.getQuantidade() + ", "
                    + o.getValor()
                    + ");";

            int result = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            new ProdutoDAO().somarQuantidade(o.getIdProduto(), o.getQuantidade());

            return null;
        } catch (Exception e) {
            System.out.println("ItemCompra > salvar() ERROR: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(ItemCompra o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int idCompra) {
        try {
            String dml = "DELETE FROM item_compra WHERE compra_id = " + idCompra;

            ArrayList<ItemCompra> tempLista = consultarTodos(idCompra);
            for (ItemCompra tempItem : tempLista) {
                new ProdutoDAO().diminuirQuantidade(tempItem.getIdProduto(), tempItem.getQuantidade());
            }
            
            int result = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);
            
            return null;
        } catch (Exception e) {
            System.out.println("ItemCompra > excluir(int) ERROR: " + e);
            return e.toString();
        }
    }

    public String excluir(ItemCompra o) {
        try {
            String dml = "DELETE FROM item_compra WHERE "
                    + "produto_id = " + o.getIdProduto() + " "
                    + "AND compra_id = " + o.getIdCompra() + ";";

            new ProdutoDAO().diminuirQuantidade(o.getIdProduto(), o.getQuantidade());

            int result = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("ItemCompra > excluir() ERRO: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<ItemCompra> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<ItemCompra> consultarTodos(int idCompra) {
        ArrayList<ItemCompra> listaItens = new ArrayList<>();

        try {
            String dml = "SELECT * FROM item_compra WHERE compra_id = " + idCompra;

            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int idProduto = rs.getInt("produto_id");
                    double qtde = rs.getDouble("qtde");
                    double valor = rs.getDouble("valor_item");

                    ItemCompra tempItem = new ItemCompra(idProduto, idCompra, qtde, valor);

                    listaItens.add(tempItem);
                }
            }
        } catch (Exception e) {
            System.out.println("ItemCompra > consultarTodos() ERROR: " + e);
            return null;
        }

        return listaItens;
    }

    @Override
    public ArrayList<ItemCompra> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemCompra consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
