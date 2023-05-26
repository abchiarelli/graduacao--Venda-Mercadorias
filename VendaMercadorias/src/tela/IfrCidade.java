/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tela;

import dao.CidadeDAO;
import entidade.Cidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author artur
 */
public class IfrCidade extends javax.swing.JInternalFrame {

    ArrayList<Cidade> cidades = null;
    Cidade cidadeSelecionada = null;

    /**
     * Creates new form IfrCidade
     */
    public IfrCidade() {
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

        TbpPrincipal = new javax.swing.JTabbedPane();
        PnlListagem = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtFiltroNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblListagem = new javax.swing.JTable();
        BtnLimparFiltro = new javax.swing.JButton();
        PnlManutencao = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        BtnSalvar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        BtnAtualizar = new javax.swing.JButton();

        setTitle("Cadastro: Cidades");

        TbpPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbpPrincipalMouseClicked(evt);
            }
        });

        jLabel1.setText("Filtro por nome:");

        TblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ));
        TblListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblListagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblListagem);
        if (TblListagem.getColumnModel().getColumnCount() > 0) {
            TblListagem.getColumnModel().getColumn(0).setMinWidth(1);
            TblListagem.getColumnModel().getColumn(0).setPreferredWidth(1);
            TblListagem.getColumnModel().getColumn(1).setMinWidth(150);
            TblListagem.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        BtnLimparFiltro.setText("Limpar");
        BtnLimparFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlListagemLayout = new javax.swing.GroupLayout(PnlListagem);
        PnlListagem.setLayout(PnlListagemLayout);
        PnlListagemLayout.setHorizontalGroup(
            PnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(PnlListagemLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnLimparFiltro)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlListagemLayout.setVerticalGroup(
            PnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlListagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimparFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TbpPrincipal.addTab("Listagem", PnlListagem);

        jLabel2.setText("Nome:");

        javax.swing.GroupLayout PnlManutencaoLayout = new javax.swing.GroupLayout(PnlManutencao);
        PnlManutencao.setLayout(PnlManutencaoLayout);
        PnlManutencaoLayout.setHorizontalGroup(
            PnlManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        PnlManutencaoLayout.setVerticalGroup(
            PnlManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        TbpPrincipal.addTab("Manutenção", PnlManutencao);

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
        BtnExcluir.setEnabled(false);
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        BtnAtualizar.setText("Atualizar");
        BtnAtualizar.setEnabled(false);
        BtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TbpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(TbpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        String nome = TxtNome.getText();
        CidadeDAO cidadeDAO = new CidadeDAO();

        if (cidadeSelecionada == null) {
            Cidade cidade = new Cidade(nome);
            if (cidadeDAO.salvar(cidade) == null) {
                JOptionPane.showMessageDialog(this, "Cidade salva com sucesso!");
                limpaRegistro();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar Cidade.");
            }
        } else {
            cidadeSelecionada.setNome(nome);
            if (cidadeDAO.atualizar(cidadeSelecionada) == null) {
                JOptionPane.showMessageDialog(this, "Alteração em Cidade salva com sucesso!");
                limpaRegistro();
                cidadeSelecionada = null;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao alterar Cidade.");
            }
        }

        popularTabela();
    }//GEN-LAST:event_BtnSalvarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        popularTabela();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void TbpPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbpPrincipalMouseClicked
        alterarBotoes();
    }//GEN-LAST:event_TbpPrincipalMouseClicked

    private void BtnLimparFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparFiltroActionPerformed
        TxtFiltroNome.setText("");

        popularTabela();
    }//GEN-LAST:event_BtnLimparFiltroActionPerformed

    private void TblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblListagemMouseClicked
        if (TblListagem.getSelectedRow() > -1) {
            alteraBotoesUpdate(true);
        }
    }//GEN-LAST:event_TblListagemMouseClicked

    private void BtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtualizarActionPerformed
        int id = cidades.get(TblListagem.getSelectedRow()).getId();
        
        cidadeSelecionada = new CidadeDAO().consultarId(id);

        TbpPrincipal.setSelectedIndex(1);

        TxtNome.setText(cidadeSelecionada.getNome());
        TxtNome.requestFocus();
        
        alterarBotoes();
        alteraBotoesUpdate(false);
    }//GEN-LAST:event_BtnAtualizarActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        int id = cidades.get(TblListagem.getSelectedRow()).getId();
        
        if(new CidadeDAO().excluir(id) == null ) {
            JOptionPane.showMessageDialog(this, "Cidade excluída com sucesso!");
            
            popularTabela();
        }
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void limpaRegistro() {
        TxtNome.setText("");
        TxtNome.requestFocus();
    }

    private void popularTabela() {
        alteraBotoesUpdate(false);
        popularArrayCidades();

        String[] columnNames = {"ID", "Descrição"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Cidade cidade : cidades) {
            Object[] row = {cidade.getId(), cidade.getNome()};
            model.addRow(row);
        }

        TblListagem.setModel(model);

        TableColumn coluna = null;

        for (int i = 0; i < TblListagem.getColumnCount(); i++) {
            coluna = TblListagem.getColumnModel().getColumn(i);
            coluna.setResizable(false);

            switch (i) {
                case 0:
                    coluna.setMaxWidth(40);
                    break;
                case 1:
                    coluna.setPreferredWidth(200);
                    break;
            }
        }

        TblListagem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void popularArrayCidades() {
        CidadeDAO cidadeDAO = new CidadeDAO();

        if (TxtFiltroNome.getText().length() > 0) {

            String DML = "SELECT * "
                    + "FROM cidade "
                    + "WHERE descricao ILIKE '%" + TxtFiltroNome.getText() + "%' "
                    + "ORDER BY descricao;";

            cidades = cidadeDAO.consultar(DML);
        } else {

            cidades = cidadeDAO.consultarTodos();
        }
    }

    private void alterarBotoes() {
        BtnBuscar.setEnabled(TbpPrincipal.getSelectedIndex() == 0);
        BtnSalvar.setEnabled(TbpPrincipal.getSelectedIndex() == 1);
    }

    private void alteraBotoesUpdate(boolean setTo) {
        BtnAtualizar.setEnabled(setTo);
        BtnExcluir.setEnabled(setTo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtualizar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnLimparFiltro;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JPanel PnlListagem;
    private javax.swing.JPanel PnlManutencao;
    private javax.swing.JTable TblListagem;
    private javax.swing.JTabbedPane TbpPrincipal;
    private javax.swing.JTextField TxtFiltroNome;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
