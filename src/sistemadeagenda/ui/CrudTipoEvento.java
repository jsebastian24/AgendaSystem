/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeagenda.ui;

import sistemadeagenda.controller.TipoDeEventoController;
import sistemadeagenda.objects.TipoDeEvento;

/**
 *
 * @author Seba-PC
 */
public class CrudTipoEvento extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrudTipoEvento
     */
    TipoDeEventoController tipoDeEventoController;
    
    public CrudTipoEvento() {
        initComponents();
        tipoDeEventoController = new TipoDeEventoController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbTipoEvento = new javax.swing.JComboBox<>();
        jbtnCrear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jcbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reunion", "Consulta" }));
        jcbTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoEventoActionPerformed(evt);
            }
        });

        jbtnCrear.setText("Crear");
        jbtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel3.setText("CRUD TIPO DE EVENTO");

        jLabel1.setText("Tipo:");

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jcbTipoEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jbtnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearActionPerformed

        TipoDeEvento tipoDeEvento = new TipoDeEvento(jcbTipoEvento.getSelectedItem().toString());
        this.tipoDeEventoController.insertObject(tipoDeEvento);

    }//GEN-LAST:event_jbtnCrearActionPerformed

    private void jcbTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoEventoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Principal principal = new Principal();
        principal.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnCrear;
    private javax.swing.JComboBox<String> jcbTipoEvento;
    // End of variables declaration//GEN-END:variables
}