/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tela;

import dao.FornecedorDAO;
import entidade.Fornecedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author artur
 */
public class IfrFornecedor extends javax.swing.JInternalFrame {

    ArrayList<Fornecedor> fornecedores;
    
    /**
     * Creates new form IfrFornecedor
     */
    public IfrFornecedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PnlFornecedorLista = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TxtFiltroNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblListagem = new javax.swing.JTable();
        PnlFornecedorManutencao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        TxtTelefone = new javax.swing.JFormattedTextField();
        TxtCnpj = new javax.swing.JFormattedTextField();
        BtnBuscar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        BtnAtualizar = new javax.swing.JButton();
        BtnSalvar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setTitle("Cadastro: Fornecedores");
        setPreferredSize(new java.awt.Dimension(500, 408));

        jLabel5.setText("Filtro por nome:");

        TblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblListagem);
        if (TblListagem.getColumnModel().getColumnCount() > 0) {
            TblListagem.getColumnModel().getColumn(0).setMinWidth(150);
            TblListagem.getColumnModel().getColumn(0).setPreferredWidth(250);
        }

        javax.swing.GroupLayout PnlFornecedorListaLayout = new javax.swing.GroupLayout(PnlFornecedorLista);
        PnlFornecedorLista.setLayout(PnlFornecedorListaLayout);
        PnlFornecedorListaLayout.setHorizontalGroup(
            PnlFornecedorListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFornecedorListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlFornecedorListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PnlFornecedorListaLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlFornecedorListaLayout.setVerticalGroup(
            PnlFornecedorListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFornecedorListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlFornecedorListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", PnlFornecedorLista);

        jLabel1.setText("Nome:");

        jLabel2.setText("e-mail:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("CNPJ:");

        try {
            TxtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            TxtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout PnlFornecedorManutencaoLayout = new javax.swing.GroupLayout(PnlFornecedorManutencao);
        PnlFornecedorManutencao.setLayout(PnlFornecedorManutencaoLayout);
        PnlFornecedorManutencaoLayout.setHorizontalGroup(
            PnlFornecedorManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFornecedorManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlFornecedorManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlFornecedorManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlFornecedorManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TxtNome)
                        .addComponent(TxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                    .addGroup(PnlFornecedorManutencaoLayout.createSequentialGroup()
                        .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        PnlFornecedorManutencaoLayout.setVerticalGroup(
            PnlFornecedorManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFornecedorManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlFornecedorManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlFornecedorManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlFornecedorManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TxtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", PnlFornecedorManutencao);

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnExcluir.setText("Excluir");

        BtnAtualizar.setText("Atualizar");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscar)
                    .addComponent(BtnExcluir)
                    .addComponent(BtnAtualizar)
                    .addComponent(BtnSalvar)
                    .addComponent(BtnCancelar))
                .addContainerGap(31, Short.MAX_VALUE))
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

    private Fornecedor criarFornecedor() {
        
        String nome = TxtNome.getText();
        String email = TxtEmail.getText();
        String telefone = TxtTelefone.getText();
        String cnpj = TxtCnpj.getText();
        
        return new Fornecedor(nome, email, telefone, cnpj);
    }
    
    private void limparRegistro() {
        TxtNome.setText("");
        TxtEmail.setText("");
        TxtTelefone.setText("");
        TxtCnpj.setText("");
        
        TxtNome.requestFocus();
    }
    
    private void salvar() {
        Fornecedor fornecedor = criarFornecedor();
        
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        if(fornecedorDAO.salvar(fornecedor) == null) {
            JOptionPane.showMessageDialog(this, "Fornecedor salvo com Sucesso");
            limparRegistro();
        } else {
            JOptionPane.showMessageDialog(this, "Erro so salvar Fornecedor.");
        }
    }
    
    private void popularTabela() {
        limparTabela();
        
        popularArray();
        
        DefaultTableModel model = (DefaultTableModel) TblListagem.getModel();
        
        for (Fornecedor fornecedor : fornecedores) {
            String nome = fornecedor.getNome();
            String telefone = fornecedor.getTelefone();
            
            String[] row = {nome, telefone};
            model.addRow(row);
        }
        
        
    }
    
    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) TblListagem.getModel();
        model.setRowCount(0);
        TblListagem.setModel(model);
    }
    
    private void popularArray() {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedores = fornecedorDAO.consultarTodos();
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtualizar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JPanel PnlFornecedorLista;
    private javax.swing.JPanel PnlFornecedorManutencao;
    private javax.swing.JTable TblListagem;
    private javax.swing.JFormattedTextField TxtCnpj;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtFiltroNome;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JFormattedTextField TxtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
