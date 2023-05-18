/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tela;

import dao.ProdutoDAO;
import entidade.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author artur
 */
public class IfrProduto extends javax.swing.JInternalFrame {

    ArrayList<Produto> produtos;
    
    /**
     * Creates new form IfrProduto
     */
    public IfrProduto() {
        initComponents();
        
        alterarBotoes();
        
        popularTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        TbpPrincipal = new javax.swing.JTabbedPane();
        PnlListagem = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TxtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblListagem = new javax.swing.JTable();
        PnlCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtDescricao = new javax.swing.JTextField();
        TxtValor = new javax.swing.JTextField();
        TxtQuantidade = new javax.swing.JTextField();
        BtnSalvar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        BtnAtualizar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setTitle("Cadastro: Produtos");
        setToolTipText("");

        TbpPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbpPrincipalMouseClicked(evt);
            }
        });

        jLabel7.setText("Filtro por descricao:");

        TblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descricao", "Valor", "Estoque (qtde.)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblListagem);
        if (TblListagem.getColumnModel().getColumnCount() > 0) {
            TblListagem.getColumnModel().getColumn(0).setMinWidth(150);
            TblListagem.getColumnModel().getColumn(0).setPreferredWidth(250);
        }

        javax.swing.GroupLayout PnlListagemLayout = new javax.swing.GroupLayout(PnlListagem);
        PnlListagem.setLayout(PnlListagemLayout);
        PnlListagemLayout.setHorizontalGroup(
            PnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(PnlListagemLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlListagemLayout.setVerticalGroup(
            PnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        TbpPrincipal.addTab("Listagem", PnlListagem);

        jLabel1.setText("Descrição:");

        jLabel2.setText("Valor (unitário):");

        jLabel3.setText("Estoque (qtde):");

        javax.swing.GroupLayout PnlCadastroLayout = new javax.swing.GroupLayout(PnlCadastro);
        PnlCadastro.setLayout(PnlCadastroLayout);
        PnlCadastroLayout.setHorizontalGroup(
            PnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCadastroLayout.createSequentialGroup()
                .addGroup(PnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlCadastroLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlCadastroLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtQuantidade)))
                .addGap(42, 42, 42))
        );
        PnlCadastroLayout.setVerticalGroup(
            PnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(TxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        TbpPrincipal.addTab("Cadastro", PnlCadastro);

        BtnSalvar.setText("Salvar");
        BtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarActionPerformed(evt);
            }
        });

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnExcluir.setText("Excluir");

        BtnAtualizar.setText("Atualizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TbpPrincipal)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TbpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSalvar)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnBuscar)
                    .addComponent(BtnExcluir)
                    .addComponent(BtnAtualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_BtnSalvarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        popularTabela();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void TbpPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbpPrincipalMouseClicked
        alterarBotoes();
    }//GEN-LAST:event_TbpPrincipalMouseClicked

    private void salvar() {
        Produto produto = criarProduto();

        ProdutoDAO produtoDao = new ProdutoDAO();
        if (produtoDao.salvar(produto) == null) {
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            limparRegistro();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar Produto.");
        }
    }
    
    private Produto criarProduto() {
        String descricao = TxtDescricao.getText();
        float valor = Float.parseFloat(TxtValor.getText());
        float quantidade = Float.parseFloat(TxtQuantidade.getText());

        return new Produto(descricao, valor, quantidade);
    }
    
    public void limparRegistro() {
        TxtDescricao.setText("");
        TxtQuantidade.setText("");
        TxtValor.setText("");
        TxtDescricao.requestFocus();
    }
    
    public void popularTabela() {
        popularArray();
        
        limparTabela();
        
        DefaultTableModel model = (DefaultTableModel) TblListagem.getModel();
        
        for (Produto produto : produtos) {
            String descricao = produto.getDescricao();
            String valor = String.valueOf(produto.getValor());
            String quantidade = String.valueOf(produto.getQuantidade());
            
            String[] row = {descricao, valor, quantidade};
            
            model.addRow(row);
        }
        
        TblListagem.setModel(model);
    }
    
    private void popularArray() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        produtos = produtoDAO.consultarTodos();
    }
    
    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) TblListagem.getModel();
        model.setRowCount(0);
    }
    
    private void alterarBotoes() {
        BtnBuscar.setEnabled(TbpPrincipal.getSelectedIndex() == 0);
        BtnSalvar.setEnabled(TbpPrincipal.getSelectedIndex() == 1);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtualizar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JPanel PnlCadastro;
    private javax.swing.JPanel PnlListagem;
    private javax.swing.JTable TblListagem;
    private javax.swing.JTabbedPane TbpPrincipal;
    private javax.swing.JTextField TxtDescricao;
    private javax.swing.JTextField TxtFiltro;
    private javax.swing.JTextField TxtQuantidade;
    private javax.swing.JTextField TxtValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
