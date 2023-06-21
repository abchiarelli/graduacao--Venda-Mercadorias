/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author artur
 */
public class Compra {
    private int id;
    private String data;
    private double valor;
    private int idFornecedor;

    public Compra(String data, double valor, int idFornecedor) {
        this.data = data;
        this.valor = valor;
        this.idFornecedor = idFornecedor;
    }

    public Compra(int id, String data, double valor, int idFornecedor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.idFornecedor = idFornecedor;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
