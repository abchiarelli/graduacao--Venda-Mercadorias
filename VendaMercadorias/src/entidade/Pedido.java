/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author artur
 */
public class Pedido {
    private int id;
    private String data;
    private String endereco;
    private String observacao;
    private int idCliente;
    private double valorTotal;

    public Pedido(String data, String endereco, String observacao, int idCliente, double valorTotal) {
        this.data = data;
        this.endereco = endereco;
        this.observacao = observacao;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
    }

    public Pedido(int id, String data, String endereco, String observacao, int idCliente, double valorTotal) {
        this.id = id;
        this.data = data;
        this.endereco = endereco;
        this.observacao = observacao;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
