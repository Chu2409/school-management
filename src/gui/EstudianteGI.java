package gui;

import datos.UsuarioDAO;
import datos.UsuarioRolDAO;
import domain.Usuario;
import java.awt.*;
import javax.swing.*;

public class EstudianteGI extends javax.swing.JFrame {

    private int estudianteId;

    private static UsuarioRolDAO usuarioRolDao = new UsuarioRolDAO();
    private UsuarioDAO usuarioDao = new UsuarioDAO();

    private Usuario estudiante;

    private int xMouse, yMouse;

    public EstudianteGI(int estudianteId) {
        this.initComponents();
        this.mostrarPanel(new InicioP());
        this.estudianteId = estudianteId;

        this.estudiante = this.usuarioDao.usuarioByUsuarioId(this.estudianteId);
        this.estudiante.setEstado(1);
        this.usuarioDao.actualizar(this.estudiante);
    }

    private void mostrarPanel(JPanel p) {
        p.setSize(1280, 560);
        p.setLocation(0, 0);

        this.contenido.removeAll();
        this.contenido.add(p, BorderLayout.CENTER);
        this.contenido.revalidate();
        this.contenido.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        panelSup = new javax.swing.JPanel();
        inicioBt = new javax.swing.JPanel();
        inicioTxt = new javax.swing.JLabel();
        cursosBt = new javax.swing.JPanel();
        cursosTxt = new javax.swing.JLabel();
        asignacionesBt = new javax.swing.JPanel();
        asignacionesTxt = new javax.swing.JLabel();
        matriculasBt = new javax.swing.JPanel();
        matriculasTxt = new javax.swing.JLabel();
        infoBt = new javax.swing.JPanel();
        infoTxt = new javax.swing.JLabel();
        salirBt = new javax.swing.JPanel();
        salirTxt = new javax.swing.JLabel();
        panelInf = new javax.swing.JPanel();
        logoFU = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 720));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSup.setBackground(new java.awt.Color(67, 67, 67));
        panelSup.setPreferredSize(new java.awt.Dimension(1280, 40));
        panelSup.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelSupMouseDragged(evt);
            }
        });
        panelSup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelSupMousePressed(evt);
            }
        });
        panelSup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inicioBt.setBackground(new java.awt.Color(67, 67, 67));
        inicioBt.setPreferredSize(new java.awt.Dimension(100, 40));

        inicioTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        inicioTxt.setForeground(new java.awt.Color(255, 255, 255));
        inicioTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioTxt.setText("Inicio");
        inicioTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicioTxt.setPreferredSize(new java.awt.Dimension(100, 40));
        inicioTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inicioTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inicioTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout inicioBtLayout = new javax.swing.GroupLayout(inicioBt);
        inicioBt.setLayout(inicioBtLayout);
        inicioBtLayout.setHorizontalGroup(
            inicioBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioBtLayout.createSequentialGroup()
                .addComponent(inicioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        inicioBtLayout.setVerticalGroup(
            inicioBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioBtLayout.createSequentialGroup()
                .addComponent(inicioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(inicioBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        cursosBt.setBackground(new java.awt.Color(67, 67, 67));
        cursosBt.setPreferredSize(new java.awt.Dimension(100, 40));

        cursosTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        cursosTxt.setForeground(new java.awt.Color(255, 255, 255));
        cursosTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cursosTxt.setText("Cursos");
        cursosTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cursosTxt.setPreferredSize(new java.awt.Dimension(100, 40));
        cursosTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursosTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cursosTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cursosTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout cursosBtLayout = new javax.swing.GroupLayout(cursosBt);
        cursosBt.setLayout(cursosBtLayout);
        cursosBtLayout.setHorizontalGroup(
            cursosBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cursosBtLayout.createSequentialGroup()
                .addComponent(cursosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cursosBtLayout.setVerticalGroup(
            cursosBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cursosBtLayout.createSequentialGroup()
                .addComponent(cursosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(cursosBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        asignacionesBt.setBackground(new java.awt.Color(67, 67, 67));
        asignacionesBt.setPreferredSize(new java.awt.Dimension(140, 40));

        asignacionesTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        asignacionesTxt.setForeground(new java.awt.Color(255, 255, 255));
        asignacionesTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignacionesTxt.setText("Asignaciones");
        asignacionesTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignacionesTxt.setPreferredSize(new java.awt.Dimension(140, 40));
        asignacionesTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignacionesTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asignacionesTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asignacionesTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout asignacionesBtLayout = new javax.swing.GroupLayout(asignacionesBt);
        asignacionesBt.setLayout(asignacionesBtLayout);
        asignacionesBtLayout.setHorizontalGroup(
            asignacionesBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignacionesBtLayout.createSequentialGroup()
                .addComponent(asignacionesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        asignacionesBtLayout.setVerticalGroup(
            asignacionesBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignacionesBtLayout.createSequentialGroup()
                .addComponent(asignacionesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(asignacionesBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        matriculasBt.setBackground(new java.awt.Color(67, 67, 67));
        matriculasBt.setPreferredSize(new java.awt.Dimension(130, 40));

        matriculasTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        matriculasTxt.setForeground(new java.awt.Color(255, 255, 255));
        matriculasTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        matriculasTxt.setText("Matriculas");
        matriculasTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        matriculasTxt.setPreferredSize(new java.awt.Dimension(130, 40));
        matriculasTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matriculasTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                matriculasTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                matriculasTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout matriculasBtLayout = new javax.swing.GroupLayout(matriculasBt);
        matriculasBt.setLayout(matriculasBtLayout);
        matriculasBtLayout.setHorizontalGroup(
            matriculasBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matriculasBtLayout.createSequentialGroup()
                .addComponent(matriculasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        matriculasBtLayout.setVerticalGroup(
            matriculasBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matriculasBtLayout.createSequentialGroup()
                .addComponent(matriculasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(matriculasBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        infoBt.setBackground(new java.awt.Color(67, 67, 67));
        infoBt.setPreferredSize(new java.awt.Dimension(210, 40));

        infoTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        infoTxt.setForeground(new java.awt.Color(255, 255, 255));
        infoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoTxt.setText("Información Personal");
        infoTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoTxt.setPreferredSize(new java.awt.Dimension(210, 40));
        infoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout infoBtLayout = new javax.swing.GroupLayout(infoBt);
        infoBt.setLayout(infoBtLayout);
        infoBtLayout.setHorizontalGroup(
            infoBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoBtLayout.createSequentialGroup()
                .addComponent(infoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        infoBtLayout.setVerticalGroup(
            infoBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoBtLayout.createSequentialGroup()
                .addComponent(infoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(infoBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        salirBt.setBackground(new java.awt.Color(67, 67, 67));
        salirBt.setPreferredSize(new java.awt.Dimension(50, 40));

        salirTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        salirTxt.setForeground(new java.awt.Color(255, 255, 255));
        salirTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salirTxt.setText("X");
        salirTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salirTxt.setPreferredSize(new java.awt.Dimension(50, 40));
        salirTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout salirBtLayout = new javax.swing.GroupLayout(salirBt);
        salirBt.setLayout(salirBtLayout);
        salirBtLayout.setHorizontalGroup(
            salirBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salirTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        salirBtLayout.setVerticalGroup(
            salirBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salirTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelSup.add(salirBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, -1, -1));

        fondo.add(panelSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelInf.setBackground(new java.awt.Color(193, 18, 31));
        panelInf.setPreferredSize(new java.awt.Dimension(1280, 120));

        logoFU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoFU.png"))); // NOI18N
        logoFU.setPreferredSize(new java.awt.Dimension(440, 120));

        javax.swing.GroupLayout panelInfLayout = new javax.swing.GroupLayout(panelInf);
        panelInf.setLayout(panelInfLayout);
        panelInfLayout.setHorizontalGroup(
            panelInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfLayout.createSequentialGroup()
                .addComponent(logoFU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 840, Short.MAX_VALUE))
        );
        panelInfLayout.setVerticalGroup(
            panelInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfLayout.createSequentialGroup()
                .addComponent(logoFU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(panelInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, -1, -1));

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setPreferredSize(new java.awt.Dimension(1280, 560));

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        fondo.add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salirTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirTxtMouseEntered
        this.salirBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_salirTxtMouseEntered

    private void salirTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirTxtMouseExited
        this.salirBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_salirTxtMouseExited

    private void salirTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirTxtMouseClicked
        this.estudiante = this.usuarioDao.usuarioByUsuarioId(this.estudianteId);
        this.estudiante.setEstado(0);
        this.usuarioDao.actualizar(this.estudiante);
        System.exit(0);
    }//GEN-LAST:event_salirTxtMouseClicked

    private void inicioTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioTxtMouseEntered
        this.inicioBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_inicioTxtMouseEntered

    private void inicioTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioTxtMouseExited
        this.inicioBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_inicioTxtMouseExited

    private void inicioTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioTxtMouseClicked
        this.mostrarPanel(new InicioP());
    }//GEN-LAST:event_inicioTxtMouseClicked

    private void matriculasTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculasTxtMouseEntered
        this.matriculasBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_matriculasTxtMouseEntered

    private void matriculasTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculasTxtMouseExited
        this.matriculasBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_matriculasTxtMouseExited

    private void matriculasTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculasTxtMouseClicked
        this.mostrarPanel(new EstudianteMatriculasP(this.estudianteId));
    }//GEN-LAST:event_matriculasTxtMouseClicked

    private void infoTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoTxtMouseEntered
        this.infoBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_infoTxtMouseEntered

    private void infoTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoTxtMouseExited
        this.infoBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_infoTxtMouseExited

    private void infoTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoTxtMouseClicked
        this.mostrarPanel(new EstudianteInfoP(this.estudianteId));
    }//GEN-LAST:event_infoTxtMouseClicked

    private void panelSupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSupMousePressed
        this.xMouse = evt.getX();
        this.yMouse = evt.getY();
    }//GEN-LAST:event_panelSupMousePressed

    private void panelSupMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSupMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }//GEN-LAST:event_panelSupMouseDragged

    private void asignacionesTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignacionesTxtMouseClicked
        this.mostrarPanel(new EstudianteAsignacionesP(this.estudianteId));
    }//GEN-LAST:event_asignacionesTxtMouseClicked

    private void asignacionesTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignacionesTxtMouseEntered
        this.asignacionesBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_asignacionesTxtMouseEntered

    private void asignacionesTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignacionesTxtMouseExited
        this.asignacionesBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_asignacionesTxtMouseExited

    private void cursosTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosTxtMouseExited
        this.cursosBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_cursosTxtMouseExited

    private void cursosTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosTxtMouseEntered
        this.cursosBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_cursosTxtMouseEntered

    private void cursosTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosTxtMouseClicked
        this.mostrarPanel(new EstudianteCursosP(this.estudianteId));
    }//GEN-LAST:event_cursosTxtMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstudianteGI(usuarioRolDao.obtenerId(12, 1)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel asignacionesBt;
    private javax.swing.JLabel asignacionesTxt;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel cursosBt;
    private javax.swing.JLabel cursosTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel infoBt;
    private javax.swing.JLabel infoTxt;
    private javax.swing.JPanel inicioBt;
    private javax.swing.JLabel inicioTxt;
    private javax.swing.JLabel logoFU;
    private javax.swing.JPanel matriculasBt;
    private javax.swing.JLabel matriculasTxt;
    private javax.swing.JPanel panelInf;
    private javax.swing.JPanel panelSup;
    private javax.swing.JPanel salirBt;
    private javax.swing.JLabel salirTxt;
    // End of variables declaration//GEN-END:variables
}
