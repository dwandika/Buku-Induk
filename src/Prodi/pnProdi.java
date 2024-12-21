/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Prodi;

import Class.*;
import static Main.menuBukuinduk.ContenPanel;
import javax.swing.table.DefaultTableModel;
import org.json.*;

/**
 *
 * @author USER
 */
public class pnProdi extends javax.swing.JPanel {

    /**
     * Creates new form pnProdi
     */
    public pnProdi() {
        initComponents();
        tampilProdi();
    }

    void tampilProdi() {

        try {
            Prodi pd = new Prodi();
            JSONObject obj = pd.getJurusan();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Program Studi");

            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
//            mahasiswa.setDataMhs(results);
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                    model.addRow(new Object[]{
                        (i + 1),
                        item.getString("prodi")

                    });
                    tbProdi.setModel(model);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollpane = new javax.swing.JScrollPane();
        tbProdi = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("DM Sans SemiBold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 154, 170));
        jLabel1.setText("Buku Induk > Prodi");
        jLabel1.setToolTipText("");

        tbProdi.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tbProdi.setForeground(new java.awt.Color(2, 154, 170));
        tbProdi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProdi.setToolTipText("");
        tbProdi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdiMouseClicked(evt);
            }
        });
        jScrollpane.setViewportView(tbProdi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jScrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbProdiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdiMouseClicked
        int baris = tbProdi.rowAtPoint(evt.getPoint());
        String proodi = tbProdi.getValueAt(baris, 1).toString();
        Prodi.setProdi(proodi);
        ContenPanel.removeAll();
        ContenPanel.add(new popProdi());
        ContenPanel.repaint();
        ContenPanel.revalidate();
    }//GEN-LAST:event_tbProdiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollpane;
    private javax.swing.JTable tbProdi;
    // End of variables declaration//GEN-END:variables
}
