package gui;

import datos.*;
import domain.Usuario;
import java.awt.*;
import javax.swing.*;

public class AdminGI extends javax.swing.JFrame {

    private int adminId;

    private static UsuarioRolDAO usuarioRolDao = new UsuarioRolDAO();
    private UsuarioDAO usuarioDao = new UsuarioDAO();

    private Usuario admin;

    private int xMouse, yMouse;

    public AdminGI(int adminId) {
        this.initComponents();
        AdminGI.mostrarPanel(new InicioP());
        this.adminId = adminId;

        this.admin = this.usuarioDao.usuarioByUsuarioId(adminId);
        this.admin.setEstado(1);
        this.usuarioDao.actualizar(this.admin);
    }

    public static void mostrarPanel(JPanel p) {
        p.setSize(1280, 560);
        p.setLocation(0, 0);

        AdminGI.contenido.removeAll();
        AdminGI.contenido.add(p, BorderLayout.CENTER);
        AdminGI.contenido.revalidate();
        AdminGI.contenido.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        panelSup = new javax.swing.JPanel();
        inicioBt = new javax.swing.JPanel();
        inicioTxt = new javax.swing.JLabel();
        usuariosBt = new javax.swing.JPanel();
        usuariosTxt = new javax.swing.JLabel();
        asignaturasBt = new javax.swing.JPanel();
        asignaturasTxt = new javax.swing.JLabel();
        cursosBt = new javax.swing.JPanel();
        cursosTxt = new javax.swing.JLabel();
        asignacionBt = new javax.swing.JPanel();
        asignacionTxt = new javax.swing.JLabel();
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
        inicioBt.setPreferredSize(new java.awt.Dimension(110, 40));

        inicioTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        inicioTxt.setForeground(new java.awt.Color(255, 255, 255));
        inicioTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioTxt.setText("Inicio");
        inicioTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicioTxt.setPreferredSize(new java.awt.Dimension(110, 40));
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

        usuariosBt.setBackground(new java.awt.Color(67, 67, 67));
        usuariosBt.setPreferredSize(new java.awt.Dimension(130, 40));

        usuariosTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        usuariosTxt.setForeground(new java.awt.Color(255, 255, 255));
        usuariosTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuariosTxt.setText("Usuarios");
        usuariosTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuariosTxt.setPreferredSize(new java.awt.Dimension(130, 40));
        usuariosTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuariosTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usuariosTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usuariosTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout usuariosBtLayout = new javax.swing.GroupLayout(usuariosBt);
        usuariosBt.setLayout(usuariosBtLayout);
        usuariosBtLayout.setHorizontalGroup(
            usuariosBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuariosBtLayout.createSequentialGroup()
                .addComponent(usuariosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        usuariosBtLayout.setVerticalGroup(
            usuariosBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuariosBtLayout.createSequentialGroup()
                .addComponent(usuariosTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(usuariosBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        asignaturasBt.setBackground(new java.awt.Color(67, 67, 67));
        asignaturasBt.setPreferredSize(new java.awt.Dimension(130, 40));

        asignaturasTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        asignaturasTxt.setForeground(new java.awt.Color(255, 255, 255));
        asignaturasTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignaturasTxt.setText("Asignaturas");
        asignaturasTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignaturasTxt.setPreferredSize(new java.awt.Dimension(130, 40));
        asignaturasTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignaturasTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asignaturasTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asignaturasTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout asignaturasBtLayout = new javax.swing.GroupLayout(asignaturasBt);
        asignaturasBt.setLayout(asignaturasBtLayout);
        asignaturasBtLayout.setHorizontalGroup(
            asignaturasBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignaturasBtLayout.createSequentialGroup()
                .addComponent(asignaturasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        asignaturasBtLayout.setVerticalGroup(
            asignaturasBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignaturasBtLayout.createSequentialGroup()
                .addComponent(asignaturasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(asignaturasBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        cursosBt.setBackground(new java.awt.Color(67, 67, 67));
        cursosBt.setPreferredSize(new java.awt.Dimension(110, 40));

        cursosTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        cursosTxt.setForeground(new java.awt.Color(255, 255, 255));
        cursosTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cursosTxt.setText("Cursos");
        cursosTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cursosTxt.setPreferredSize(new java.awt.Dimension(110, 40));
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

        panelSup.add(cursosBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        asignacionBt.setBackground(new java.awt.Color(67, 67, 67));
        asignacionBt.setPreferredSize(new java.awt.Dimension(130, 40));

        asignacionTxt.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        asignacionTxt.setForeground(new java.awt.Color(255, 255, 255));
        asignacionTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignacionTxt.setText("Asignación");
        asignacionTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignacionTxt.setPreferredSize(new java.awt.Dimension(130, 40));
        asignacionTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignacionTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asignacionTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asignacionTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout asignacionBtLayout = new javax.swing.GroupLayout(asignacionBt);
        asignacionBt.setLayout(asignacionBtLayout);
        asignacionBtLayout.setHorizontalGroup(
            asignacionBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignacionBtLayout.createSequentialGroup()
                .addComponent(asignacionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        asignacionBtLayout.setVerticalGroup(
            asignacionBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignacionBtLayout.createSequentialGroup()
                .addComponent(asignacionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(asignacionBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

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
        this.admin.setEstado(0);
        this.usuarioDao.actualizar(this.admin);
        System.exit(0);
    }//GEN-LAST:event_salirTxtMouseClicked

    private void inicioTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioTxtMouseEntered
        this.inicioBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_inicioTxtMouseEntered

    private void inicioTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioTxtMouseExited
        this.inicioBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_inicioTxtMouseExited

    private void inicioTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioTxtMouseClicked
        AdminGI.mostrarPanel(new InicioP());
    }//GEN-LAST:event_inicioTxtMouseClicked

    private void asignaturasTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignaturasTxtMouseEntered
        this.asignaturasBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_asignaturasTxtMouseEntered

    private void asignaturasTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignaturasTxtMouseExited
        this.asignaturasBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_asignaturasTxtMouseExited

    private void asignaturasTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignaturasTxtMouseClicked
        AdminGI.mostrarPanel(new AdminAsignaturasP());
    }//GEN-LAST:event_asignaturasTxtMouseClicked

    private void usuariosTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosTxtMouseEntered
        this.usuariosBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_usuariosTxtMouseEntered

    private void usuariosTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosTxtMouseExited
        this.usuariosBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_usuariosTxtMouseExited

    private void usuariosTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariosTxtMouseClicked
        AdminGI.mostrarPanel(new AdminUsuariosP());
    }//GEN-LAST:event_usuariosTxtMouseClicked

    private void cursosTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosTxtMouseEntered
        this.cursosBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_cursosTxtMouseEntered

    private void cursosTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosTxtMouseExited
        this.cursosBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_cursosTxtMouseExited

    private void cursosTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosTxtMouseClicked
        AdminGI.mostrarPanel(new AdminCursosP());
    }//GEN-LAST:event_cursosTxtMouseClicked

    private void asignacionTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignacionTxtMouseEntered
        this.asignacionBt.setBackground(new Color(193, 18, 31));
    }//GEN-LAST:event_asignacionTxtMouseEntered

    private void asignacionTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignacionTxtMouseExited
        this.asignacionBt.setBackground(new Color(67, 67, 67));
    }//GEN-LAST:event_asignacionTxtMouseExited

    private void asignacionTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignacionTxtMouseClicked
        AdminGI.mostrarPanel(new AdminAsignacionP());
    }//GEN-LAST:event_asignacionTxtMouseClicked

    private void panelSupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSupMousePressed
        this.xMouse = evt.getX();
        this.yMouse = evt.getY();
    }//GEN-LAST:event_panelSupMousePressed

    private void panelSupMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSupMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }//GEN-LAST:event_panelSupMouseDragged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGI(AdminGI.usuarioRolDao.obtenerId(1, 3)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel asignacionBt;
    private javax.swing.JLabel asignacionTxt;
    private javax.swing.JPanel asignaturasBt;
    private javax.swing.JLabel asignaturasTxt;
    private static javax.swing.JPanel contenido;
    private javax.swing.JPanel cursosBt;
    private javax.swing.JLabel cursosTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel inicioBt;
    private javax.swing.JLabel inicioTxt;
    private javax.swing.JLabel logoFU;
    private javax.swing.JPanel panelInf;
    private javax.swing.JPanel panelSup;
    private javax.swing.JPanel salirBt;
    private javax.swing.JLabel salirTxt;
    private javax.swing.JPanel usuariosBt;
    private javax.swing.JLabel usuariosTxt;
    // End of variables declaration//GEN-END:variables
}
