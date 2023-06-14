/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tela;

import apoio.ConexaoBD;
import apoio.Relatorios;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author artur
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();

        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        DtpPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenCadastro = new javax.swing.JMenu();
        MitCliente = new javax.swing.JMenuItem();
        MitFornecedor = new javax.swing.JMenuItem();
        MitProduto = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MitCidade = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        mitPedidoCadastrar = new javax.swing.JMenuItem();
        mitPedidoListar = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mitCompraCadastrar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        mitRelatorioListagemClientes = new javax.swing.JMenuItem();
        mitRelatorioListagemProdutos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenSair = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Venda de Mercadorias");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setState(1);

        javax.swing.GroupLayout DtpPrincipalLayout = new javax.swing.GroupLayout(DtpPrincipal);
        DtpPrincipal.setLayout(DtpPrincipalLayout);
        DtpPrincipalLayout.setHorizontalGroup(
            DtpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );
        DtpPrincipalLayout.setVerticalGroup(
            DtpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        MenCadastro.setText("Listagem");

        MitCliente.setText("Cliente");
        MitCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitClienteActionPerformed(evt);
            }
        });
        MenCadastro.add(MitCliente);

        MitFornecedor.setText("Fornecedor");
        MitFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitFornecedorActionPerformed(evt);
            }
        });
        MenCadastro.add(MitFornecedor);

        MitProduto.setText("Produto");
        MitProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitProdutoActionPerformed(evt);
            }
        });
        MenCadastro.add(MitProduto);
        MenCadastro.add(jSeparator1);

        MitCidade.setText("Cidade");
        MitCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitCidadeActionPerformed(evt);
            }
        });
        MenCadastro.add(MitCidade);

        jMenuBar1.add(MenCadastro);

        jMenu1.setText("Financeiro");

        jMenu5.setText("Pedido");

        mitPedidoCadastrar.setText("Cadastro");
        mitPedidoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPedidoCadastrarActionPerformed(evt);
            }
        });
        jMenu5.add(mitPedidoCadastrar);

        mitPedidoListar.setText("Listagem");
        jMenu5.add(mitPedidoListar);

        jMenu1.add(jMenu5);

        jMenu6.setText("Compra");

        mitCompraCadastrar.setText("Cadastrar");
        jMenu6.add(mitCompraCadastrar);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Relatórios");

        jMenu4.setText("Listagem");

        mitRelatorioListagemClientes.setText("Clientes");
        mitRelatorioListagemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRelatorioListagemClientesActionPerformed(evt);
            }
        });
        jMenu4.add(mitRelatorioListagemClientes);

        mitRelatorioListagemProdutos.setText("Produtos");
        mitRelatorioListagemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRelatorioListagemProdutosActionPerformed(evt);
            }
        });
        jMenu4.add(mitRelatorioListagemProdutos);

        jMenu3.add(jMenu4);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Ajuda");
        jMenu2.add(jSeparator2);

        MenSair.setText("Sair");
        MenSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenSairActionPerformed(evt);
            }
        });
        jMenu2.add(MenSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DtpPrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DtpPrincipal)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenSairActionPerformed

    private void MitClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitClienteActionPerformed
        IfrCliente frameCliente = new IfrCliente();

        DtpPrincipal.add(frameCliente);

        frameCliente.setVisible(true);
    }//GEN-LAST:event_MitClienteActionPerformed

    private void MitFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitFornecedorActionPerformed
        IfrFornecedor frameFornecedor = new IfrFornecedor();

        DtpPrincipal.add(frameFornecedor);

        frameFornecedor.setVisible(true);
    }//GEN-LAST:event_MitFornecedorActionPerformed

    private void MitProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitProdutoActionPerformed
        IfrProduto frameProduto = new IfrProduto();

        DtpPrincipal.add(frameProduto);

        frameProduto.setVisible(true);
    }//GEN-LAST:event_MitProdutoActionPerformed

    private void MitCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitCidadeActionPerformed
        IfrCidade frameCidade = new IfrCidade();

        DtpPrincipal.add(frameCidade);

        frameCidade.setVisible(true);
    }//GEN-LAST:event_MitCidadeActionPerformed

    private void mitPedidoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPedidoCadastrarActionPerformed
        IfrPedido frmPedido = new IfrPedido();

        DtpPrincipal.add(frmPedido);
        
        frmPedido.setFocus(1);
        frmPedido.setVisible(true);
    }//GEN-LAST:event_mitPedidoCadastrarActionPerformed

    private void mitRelatorioListagemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRelatorioListagemClientesActionPerformed
        new Relatorios().gerarRelatorio("/relatorios/venda_mercadorias_listagem_clientes.jrxml");
    }//GEN-LAST:event_mitRelatorioListagemClientesActionPerformed

    private void mitRelatorioListagemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRelatorioListagemProdutosActionPerformed
        new Relatorios().gerarRelatorio("/relatorios/venda_mercadorias_listagem_produtos.jrxml");
    }//GEN-LAST:event_mitRelatorioListagemProdutosActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DtpPrincipal;
    private javax.swing.JMenu MenCadastro;
    private javax.swing.JMenuItem MenSair;
    private javax.swing.JMenuItem MitCidade;
    private javax.swing.JMenuItem MitCliente;
    private javax.swing.JMenuItem MitFornecedor;
    private javax.swing.JMenuItem MitProduto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem mitCompraCadastrar;
    private javax.swing.JMenuItem mitPedidoCadastrar;
    private javax.swing.JMenuItem mitPedidoListar;
    private javax.swing.JMenuItem mitRelatorioListagemClientes;
    private javax.swing.JMenuItem mitRelatorioListagemProdutos;
    // End of variables declaration//GEN-END:variables
}
