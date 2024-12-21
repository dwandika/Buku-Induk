/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Angkatan;

import Class.*;
import javax.swing.table.DefaultTableModel;
import static Main.menuBukuinduk.ContenPanel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author USER
 */
public class popAngkatan extends javax.swing.JPanel {

    /**
     * Creates new form popAngkatan
     */
    public popAngkatan() {
        initComponents();
        loadTabel();
    }

    void loadTabel() {

        try {
            Angkatan mhs = new Angkatan();
            JSONObject obj = mhs.tampilAngkatan();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Nim");
            model.addColumn("Nama");
            model.addColumn("Jenis Kelamin");
            model.addColumn("Angkatan");
            model.addColumn("Prodi");

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    model.addRow(new Object[]{
                        (i + 1),
                        item.getString("mhs_nim"),
                        item.getString("mhs_nama"),
                        item.getString("mhs_jk"),
                        item.getInt("angkatan"),
                        item.getString("prodi")

                    });
                    tbAnkatan.setModel(model);
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAnkatan = new javax.swing.JTable();
        jAngkatan = new javax.swing.JLabel();
        bClose = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbAnkatan.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        tbAnkatan.setForeground(new java.awt.Color(2, 154, 170));
        tbAnkatan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbAnkatan);

        jAngkatan.setFont(new java.awt.Font("DM Sans SemiBold", 1, 14)); // NOI18N
        jAngkatan.setForeground(new java.awt.Color(2, 154, 170));
        jAngkatan.setText("Buku Induk > Angkatan");

        bClose.setBackground(new java.awt.Color(2, 154, 170));
        bClose.setFont(new java.awt.Font("DM Sans SemiBold", 1, 12)); // NOI18N
        bClose.setForeground(new java.awt.Color(255, 255, 255));
        bClose.setText("Close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bClose))
                            .addComponent(jScrollPane1))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(840, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jAngkatan)
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(bClose)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        ContenPanel.removeAll();
        ContenPanel.add(new pnAgkatan());
        ContenPanel.repaint();
        ContenPanel.revalidate();
    }//GEN-LAST:event_bCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    public static javax.swing.JLabel jAngkatan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAnkatan;
    // End of variables declaration//GEN-END:variables
}