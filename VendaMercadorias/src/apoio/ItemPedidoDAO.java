/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import dao.ProdutoDAO;
import entidade.ItemPedido;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author artur
 */
public class ItemPedidoDAO implements IDAOT<ItemPedido> {

    @Override
    public String salvar(ItemPedido o) {
        try {
            String dml = "INSERT INTO item_pedido VALUES("
                    + o.getIdProduto() + ", "
                    + o.getIdPedido() + ", "
                    + o.getQuantidade() + ", "
                    + o.getValor()
                    + ");";

            int resultado = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            new ProdutoDAO().diminuirQuantidade(o.getIdProduto(), o.getQuantidade());

            return null;
        } catch (Exception e) {
            System.out.println("ItemPedido > salvar() ERROR: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(ItemPedido o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String excluir(int idPedido, int idProduto) {
        try {
            String dml = "DELETE FROM item_pedido WHERE "
                    + "produto_id = " + idProduto
                    + "AND pedido_id = " + idPedido + ";";

            int resultado = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("ItemPedido > excluir() ERROR: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<ItemPedido> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<ItemPedido> consultarTodos(int idPedido) {
        ArrayList<ItemPedido> itens = new ArrayList<>();

        try {
            String dml = "SELECT * FROM item_pedido WHERE pedido_id = " + idPedido + ";";

            ResultSet rs = ConexaoBD.getInstancia().getConexao().createStatement().executeQuery(dml);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int idProduto = rs.getInt("produto_id");
                    double qtde = rs.getDouble("qtde");
                    double valor = rs.getDouble("valor_item");

                    ItemPedido item = new ItemPedido(idPedido, idProduto, valor, qtde);

                    itens.add(item);
                }
            }
        } catch (Exception e) {
        }

        return itens;
    }

    @Override
    public ArrayList<ItemPedido> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemPedido consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int idPedido) {
        try {
            String dml = "DELETE FROM item_pedido WHERE "
                    + "pedido_id = " + idPedido + ";";

            ArrayList<ItemPedido> itens = new ItemPedidoDAO().consultarTodos(idPedido);
            for (ItemPedido item : itens) {
                new ProdutoDAO().somarQuantidade(item.getIdProduto(), item.getQuantidade());
            }

            int resultado = ConexaoBD.getInstancia().getConexao().createStatement().executeUpdate(dml);

            return null;
        } catch (Exception e) {
            System.out.println("ItemPedido > excluir() ERROR: " + e);
            return e.toString();
        }
    }
}
