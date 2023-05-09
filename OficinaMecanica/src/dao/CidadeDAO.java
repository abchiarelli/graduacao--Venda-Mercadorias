/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cidade;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author artur
 */
public class CidadeDAO implements IDAOT<Cidade> {

    @Override
    public String salvar(Cidade o) {
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into cidade "
                    + "values"
                    + "(default, "
                    + "'" + o.getDescricao() + "')";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);
            
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao inserir Cidade: " + e);
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
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            String sql = "SELECT * "
                    + "FROM cidade "
                    + "ORDER BY descricao";
            
            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Cidade cidade = new Cidade();
                
                cidade.setId(retorno.getInt("id"));
                cidade.setDescricao(retorno.getString("descricao"));
                
                cidades.add(cidade);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar CIDADES: " + e);
        }
        
        return cidades;
    }

    @Override
    public ArrayList<Cidade> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cidade consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
