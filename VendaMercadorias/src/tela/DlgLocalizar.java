/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package tela;

import apoio.IItemPesquisa;
import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import entidade.Cliente;
import entidade.Produto;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author artur
 */
public class DlgLocalizar extends javax.swing.JDialog {

    private String tipo;
    private IItemPesquisa origem;
    private Object[] data = new Object[1];
    
    private int idRetorno; 

    /**
     * Creates new form DlgLocalizar
     */
    public DlgLocalizar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DlgLocalizar(java.awt.Frame parent, boolean modal, IItemPesquisa origem, String tipo) {
        super(parent, modal);
        initComponents();

        this.origem = origem;
        this.tipo = tipo;

        setTitle();
    }

    private void setTitle() {
        switch (tipo) {
            case "cliente":
                this.setTitle("Selecionar: Cliente");
                lblTitulo.setText("Cliente");
                popularTabelaCliente();
                break;
            case "produto":
                this.setTitle("Selecionar: Produto");
                lblTitulo.setText("Produto");
                popularTabelaProduto();
                break;
            case "fornecedor":
                this.setTitle("Selecionar: Fornecedor");
                lblTitulo.setText("Fornecedor");
                break;
            default:
                this.dispose();
                break;
        }
    }

    private void popularTabelaCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        if (tfdFiltro.getText().trim().length() > 0) {
            String DML = "SELECT * FROM cliente "
                    + "WHERE nome ILIKE '%" + tfdFiltro.getText() + "%'"
                    + "ORDER BY nome;";

            clientes = new ClienteDAO().consultar(DML);
        } else {
            clientes = new ClienteDAO().consultarTodos();
        }

        data[0] = clientes;

        Object[] cabecalho = {"Nome", "Cidade"};
        DefaultTableModel model = new DefaultTableModel(cabecalho, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (int i = 0; i < clientes.size(); i++) {
            Object[] row = {
                clientes.get(i).getNome(),
                new CidadeDAO().consultarId(clientes.get(i).getCidade()).getNome()
            };

            model.addRow(row);
        }

        tblListagem.setModel(model);

        tblListagem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void popularTabelaProduto() {
        ArrayList<Produto> produtos = new ArrayList<>();

        if (tfdFiltro.getText().trim().length() > 0) {
            String dml = "SELECT * FROM produto "
                    + "WHERE descricao ILIKE '%" + tfdFiltro.getText() + "%' "
                    + "ORDER BY descricao;";

            produtos = new ProdutoDAO().consultar(dml);
        } else {
            produtos = new ProdutoDAO().consultarTodos();
        }

        data[0] = produtos;

        Object[] cabecalho = {
            "Descricao",
            "Valor",
            "Quantidade"
        };

        DefaultTableModel model = new DefaultTableModel(cabecalho, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (int i = 0; i < produtos.size(); i++) {
            Object[] row = {
                produtos.get(i).getDescricao(),
                produtos.get(i).getValor(),
                produtos.get(i).getQuantidade()
            };
            
            model.addRow(row);
        }
        
        tblListagem.setModel(model);
        tblListagem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfdFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2147483647, 300));
        setPreferredSize(new java.awt.Dimension(632, 300));
        setResizable(false);

        jLabel1.setText("Filtro (descrição):");

        btnBuscar.setText("Buscar");

        btnLimpar.setText("Limpar");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Selecionar:");
        jLabel2.setToolTipText("");

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblListagem);

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        lblTitulo.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelecionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnCancelar))
                .addGap(182, 182, 182))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        switch (tipo) {
            case "cliente":
                ArrayList<Cliente> clientes = (ArrayList<Cliente>) data[0];
                Cliente cliente = clientes.get(tblListagem.getSelectedRow());
                idRetorno = cliente.getId();
                break;
            case "produto":
                ArrayList<Produto> produtos = (ArrayList<Produto>) data[0];
                Produto produto = produtos.get(tblListagem.getSelectedRow());
                idRetorno = produto.getId();
                break;
            case "fornecedor":
                this.setTitle("Selecionar: Fornecedor");
                lblTitulo.setText("Fornecedor");
                break;
            default:
                this.dispose();
                break;
        }
        
        origem.definirValor(idRetorno, tipo);
        
        this.dispose();
        
    }//GEN-LAST:event_btnSelecionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgLocalizar dialog = new DlgLocalizar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField tfdFiltro;
    // End of variables declaration//GEN-END:variables
}