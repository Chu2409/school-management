package gui;

import datos.*;
import domain.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.*;

public class InvitadoCursoP extends javax.swing.JPanel {

    
    private CursoDAO cursoDao = new CursoDAO();

    public InvitadoCursoP() {
        this.initComponents();
        this.listarTabla();
    }

    private void listarTabla() {
        DefaultTableModel model = (DefaultTableModel) this.cursosTb.getModel();
        model.setRowCount(0);
        
        List<Curso> cursos = this.cursoDao.seleccionar("");        
        for (Curso c : cursos) {
            model.addRow(new Object[]{c.getId(), c.getCurso()});
        }     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        cursosTxt = new javax.swing.JLabel();
        buscarPorTxt = new javax.swing.JLabel();
        buscarFd = new javax.swing.JTextField();
        buscarSp = new javax.swing.JSeparator();
        cursoSp = new javax.swing.JScrollPane();
        cursosTb = new javax.swing.JTable();
        buscarBt = new javax.swing.JPanel();
        buscarTxt = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cursosTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        cursosTxt.setForeground(new java.awt.Color(193, 18, 31));
        cursosTxt.setText("Cursos");
        fondo.add(cursosTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        buscarPorTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        buscarPorTxt.setText("Busca por Curso:");
        fondo.add(buscarPorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        buscarFd.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        buscarFd.setBorder(null);
        buscarFd.setPreferredSize(new java.awt.Dimension(400, 22));
        fondo.add(buscarFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, 20));

        buscarSp.setPreferredSize(new java.awt.Dimension(400, 10));
        fondo.add(buscarSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, 10));

        cursosTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cursoSp.setViewportView(cursosTb);
        if (cursosTb.getColumnModel().getColumnCount() > 0) {
            cursosTb.getColumnModel().getColumn(0).setMinWidth(50);
            cursosTb.getColumnModel().getColumn(0).setPreferredWidth(50);
            cursosTb.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        fondo.add(cursoSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 1080, 400));

        buscarBt.setBackground(new java.awt.Color(253, 240, 213));
        buscarBt.setPreferredSize(new java.awt.Dimension(100, 40));

        buscarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        buscarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buscarTxt.setText("Buscar");
        buscarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarTxt.setPreferredSize(new java.awt.Dimension(100, 40));
        buscarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buscarBtLayout = new javax.swing.GroupLayout(buscarBt);
        buscarBt.setLayout(buscarBtLayout);
        buscarBtLayout.setHorizontalGroup(
            buscarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarBtLayout.createSequentialGroup()
                .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        buscarBtLayout.setVerticalGroup(
            buscarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarBtLayout.createSequentialGroup()
                .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(buscarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseClicked
        DefaultTableModel model = (DefaultTableModel) this.cursosTb.getModel();
        String cursoBuscar = this.buscarFd.getText();
        List<Curso> cursos = this.cursoDao.seleccionar(cursoBuscar);
        model.setRowCount(0);
        for (Curso c : cursos) {
            model.addRow(new Object[]{c.getId(), c.getCurso()});
        }
    }//GEN-LAST:event_buscarTxtMouseClicked

    private void buscarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseEntered
        this.buscarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_buscarTxtMouseEntered

    private void buscarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseExited
        this.buscarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_buscarTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buscarBt;
    private javax.swing.JTextField buscarFd;
    private javax.swing.JLabel buscarPorTxt;
    private javax.swing.JSeparator buscarSp;
    private javax.swing.JLabel buscarTxt;
    private javax.swing.JScrollPane cursoSp;
    private javax.swing.JTable cursosTb;
    private javax.swing.JLabel cursosTxt;
    private javax.swing.JPanel fondo;
    // End of variables declaration//GEN-END:variables
}
