package gui;

import datos.*;
import domain.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.List;

public class Login extends javax.swing.JFrame {

    private int xMouse, yMouse;
    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private UsuarioRolDAO usuarioRolDao = new UsuarioRolDAO();

    public Login() {
        this.initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        panelDer = new javax.swing.JPanel();
        nombreU = new javax.swing.JLabel();
        logoU = new javax.swing.JLabel();
        nombreF1 = new javax.swing.JLabel();
        nombreF2 = new javax.swing.JLabel();
        logoF = new javax.swing.JLabel();
        paginaBt = new javax.swing.JPanel();
        paginaTxt = new javax.swing.JLabel();
        contactoBt = new javax.swing.JPanel();
        contactoTxt = new javax.swing.JLabel();
        panelSup = new javax.swing.JPanel();
        salirBt = new javax.swing.JPanel();
        salirTxt = new javax.swing.JLabel();
        bienvenidaTxt = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JLabel();
        usuarioFd = new javax.swing.JTextField();
        usuarioSp = new javax.swing.JSeparator();
        contrasenaTxt = new javax.swing.JLabel();
        contrasenaFd = new javax.swing.JPasswordField();
        contrasenaSp = new javax.swing.JSeparator();
        olvideBt = new javax.swing.JPanel();
        olvideTxt = new javax.swing.JLabel();
        ingresarBt = new javax.swing.JPanel();
        ingresarTxt = new javax.swing.JLabel();
        invitadoBt = new javax.swing.JPanel();
        invitadoTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDer.setBackground(new java.awt.Color(253, 240, 213));
        panelDer.setPreferredSize(new java.awt.Dimension(370, 720));
        panelDer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreU.setBackground(new java.awt.Color(120, 0, 0));
        nombreU.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        nombreU.setForeground(new java.awt.Color(193, 18, 31));
        nombreU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreU.setText("UNIVERSIDAD TÉCNICA DE AMBATO");
        nombreU.setToolTipText("");
        panelDer.add(nombreU, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 350, -1));

        logoU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoUTA.png"))); // NOI18N
        panelDer.add(logoU, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        nombreF1.setBackground(new java.awt.Color(120, 0, 0));
        nombreF1.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        nombreF1.setForeground(new java.awt.Color(193, 18, 31));
        nombreF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreF1.setText("FACULTAD DE INGENERÍA EN SOFTWARE,");
        nombreF1.setToolTipText("");
        panelDer.add(nombreF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 20));

        nombreF2.setBackground(new java.awt.Color(255, 255, 255));
        nombreF2.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        nombreF2.setForeground(new java.awt.Color(193, 18, 31));
        nombreF2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreF2.setText("ELECTRÓNICA E INDUSTRIAL");
        nombreF2.setToolTipText("");
        panelDer.add(nombreF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        logoF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sistemas.png"))); // NOI18N
        panelDer.add(logoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        paginaBt.setBackground(new java.awt.Color(252, 230, 182));
        paginaBt.setPreferredSize(new java.awt.Dimension(370, 80));

        paginaTxt.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        paginaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paginaTxt.setText("PÁGINA OFICIAL UTA");
        paginaTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paginaTxt.setPreferredSize(new java.awt.Dimension(370, 80));
        paginaTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paginaTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paginaTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paginaTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout paginaBtLayout = new javax.swing.GroupLayout(paginaBt);
        paginaBt.setLayout(paginaBtLayout);
        paginaBtLayout.setHorizontalGroup(
            paginaBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paginaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paginaBtLayout.setVerticalGroup(
            paginaBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paginaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelDer.add(paginaBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, -1, -1));

        contactoBt.setBackground(new java.awt.Color(252, 230, 182));
        contactoBt.setPreferredSize(new java.awt.Dimension(370, 80));

        contactoTxt.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        contactoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contactoTxt.setText("CONTACTOS");
        contactoTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contactoTxt.setPreferredSize(new java.awt.Dimension(370, 80));
        contactoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactoTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                contactoTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                contactoTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout contactoBtLayout = new javax.swing.GroupLayout(contactoBt);
        contactoBt.setLayout(contactoBtLayout);
        contactoBtLayout.setHorizontalGroup(
            contactoBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contactoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contactoBtLayout.setVerticalGroup(
            contactoBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contactoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelDer.add(contactoBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, -1, -1));

        fondo.add(panelDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, -1));

        panelSup.setBackground(new java.awt.Color(255, 255, 255));
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

        salirBt.setBackground(new java.awt.Color(255, 255, 255));
        salirBt.setPreferredSize(new java.awt.Dimension(50, 40));

        salirTxt.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
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
            .addGroup(salirBtLayout.createSequentialGroup()
                .addComponent(salirTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        salirBtLayout.setVerticalGroup(
            salirBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salirBtLayout.createSequentialGroup()
                .addComponent(salirTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSup.add(salirBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        fondo.add(panelSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bienvenidaTxt.setBackground(new java.awt.Color(241, 250, 238));
        bienvenidaTxt.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        bienvenidaTxt.setForeground(new java.awt.Color(193, 18, 31));
        bienvenidaTxt.setText("Bienvenido a la plataforma");
        fondo.add(bienvenidaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        usuarioTxt.setBackground(new java.awt.Color(241, 250, 238));
        usuarioTxt.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        usuarioTxt.setForeground(new java.awt.Color(193, 18, 31));
        usuarioTxt.setText("USUARIO");
        fondo.add(usuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        usuarioFd.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        usuarioFd.setForeground(new java.awt.Color(204, 204, 204));
        usuarioFd.setText("Ingrese su usuario");
        usuarioFd.setBorder(null);
        usuarioFd.setPreferredSize(new java.awt.Dimension(450, 30));
        usuarioFd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioFdMousePressed(evt);
            }
        });
        fondo.add(usuarioFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        usuarioSp.setBackground(new java.awt.Color(204, 204, 204));
        usuarioSp.setForeground(new java.awt.Color(204, 204, 204));
        usuarioSp.setPreferredSize(new java.awt.Dimension(450, 10));
        fondo.add(usuarioSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        contrasenaTxt.setBackground(new java.awt.Color(69, 123, 157));
        contrasenaTxt.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        contrasenaTxt.setForeground(new java.awt.Color(193, 18, 31));
        contrasenaTxt.setText("CONTRASEÑA");
        fondo.add(contrasenaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        contrasenaFd.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        contrasenaFd.setForeground(new java.awt.Color(204, 204, 204));
        contrasenaFd.setText("************");
        contrasenaFd.setBorder(null);
        contrasenaFd.setPreferredSize(new java.awt.Dimension(450, 30));
        contrasenaFd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contrasenaFdMousePressed(evt);
            }
        });
        fondo.add(contrasenaFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        contrasenaSp.setBackground(new java.awt.Color(204, 204, 204));
        contrasenaSp.setForeground(new java.awt.Color(204, 204, 204));
        contrasenaSp.setPreferredSize(new java.awt.Dimension(450, 10));
        fondo.add(contrasenaSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        olvideBt.setBackground(new java.awt.Color(255, 255, 255));
        olvideBt.setPreferredSize(new java.awt.Dimension(150, 20));

        olvideTxt.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        olvideTxt.setText("Olvidé mi contraseña");
        olvideTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        olvideTxt.setPreferredSize(new java.awt.Dimension(150, 20));
        olvideTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                olvideTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                olvideTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                olvideTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout olvideBtLayout = new javax.swing.GroupLayout(olvideBt);
        olvideBt.setLayout(olvideBtLayout);
        olvideBtLayout.setHorizontalGroup(
            olvideBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(olvideBtLayout.createSequentialGroup()
                .addComponent(olvideTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        olvideBtLayout.setVerticalGroup(
            olvideBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(olvideBtLayout.createSequentialGroup()
                .addComponent(olvideTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(olvideBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        ingresarBt.setBackground(new java.awt.Color(252, 230, 182));
        ingresarBt.setPreferredSize(new java.awt.Dimension(210, 50));

        ingresarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        ingresarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresarTxt.setText("Ingresar");
        ingresarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingresarTxt.setPreferredSize(new java.awt.Dimension(210, 50));
        ingresarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ingresarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ingresarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ingresarBtLayout = new javax.swing.GroupLayout(ingresarBt);
        ingresarBt.setLayout(ingresarBtLayout);
        ingresarBtLayout.setHorizontalGroup(
            ingresarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresarBtLayout.createSequentialGroup()
                .addComponent(ingresarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ingresarBtLayout.setVerticalGroup(
            ingresarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresarBtLayout.createSequentialGroup()
                .addComponent(ingresarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(ingresarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        invitadoBt.setBackground(new java.awt.Color(255, 255, 255));
        invitadoBt.setPreferredSize(new java.awt.Dimension(210, 20));

        invitadoTxt.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        invitadoTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invitadoTxt.setText("Ingresar como invitado");
        invitadoTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invitadoTxt.setPreferredSize(new java.awt.Dimension(210, 20));
        invitadoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invitadoTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invitadoTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invitadoTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout invitadoBtLayout = new javax.swing.GroupLayout(invitadoBt);
        invitadoBt.setLayout(invitadoBtLayout);
        invitadoBtLayout.setHorizontalGroup(
            invitadoBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invitadoBtLayout.createSequentialGroup()
                .addComponent(invitadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        invitadoBtLayout.setVerticalGroup(
            invitadoBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invitadoBtLayout.createSequentialGroup()
                .addComponent(invitadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(invitadoBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelSupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSupMousePressed
        this.xMouse = evt.getX();
        this.yMouse = evt.getY();
    }//GEN-LAST:event_panelSupMousePressed

    private void panelSupMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSupMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - this.xMouse, y - this.yMouse);
    }//GEN-LAST:event_panelSupMouseDragged

    private void salirTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirTxtMouseEntered
        this.salirBt.setBackground(new Color(196, 43, 28));
        this.salirTxt.setForeground(Color.white);
    }//GEN-LAST:event_salirTxtMouseEntered

    private void salirTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirTxtMouseExited
        this.salirBt.setBackground(Color.white);
        this.salirTxt.setForeground(Color.black);
    }//GEN-LAST:event_salirTxtMouseExited

    private void salirTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_salirTxtMouseClicked

    private void paginaTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paginaTxtMouseEntered
        this.paginaBt.setBackground(new Color(248, 200, 99));
    }//GEN-LAST:event_paginaTxtMouseEntered

    private void paginaTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paginaTxtMouseExited
        this.paginaBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_paginaTxtMouseExited

    private void paginaTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paginaTxtMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://www.uta.edu.ec/v4.0/"));
        } catch (URISyntaxException | IOException ex) {
        }
    }//GEN-LAST:event_paginaTxtMouseClicked

    private void contactoTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactoTxtMouseEntered
        this.contactoBt.setBackground(new Color(248, 200, 99));
    }//GEN-LAST:event_contactoTxtMouseEntered

    private void contactoTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactoTxtMouseExited
        this.contactoBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_contactoTxtMouseExited

    private void contactoTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactoTxtMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://wa.me/593967229875"));
        } catch (URISyntaxException | IOException ex) {
        }
    }//GEN-LAST:event_contactoTxtMouseClicked

    private void usuarioFdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioFdMousePressed
        if (this.usuarioFd.getText().equals("Ingrese su usuario")) {
            this.usuarioFd.setText("");
            this.usuarioFd.setForeground(Color.black);
        }
        if (String.valueOf(this.contrasenaFd.getPassword()).isEmpty()) {
            this.contrasenaFd.setText("************");
            this.contrasenaFd.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_usuarioFdMousePressed

    private void contrasenaFdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contrasenaFdMousePressed
        if (String.valueOf(this.contrasenaFd.getPassword()).equals("************")) {
            this.contrasenaFd.setText("");
            this.contrasenaFd.setForeground(Color.black);
        }
        if (this.usuarioFd.getText().isEmpty()) {
            this.usuarioFd.setText("Ingrese su usuario");
            this.usuarioFd.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_contrasenaFdMousePressed

    private void olvideTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_olvideTxtMouseEntered
        this.olvideTxt.setForeground(new Color(120, 0, 0));
    }//GEN-LAST:event_olvideTxtMouseEntered

    private void olvideTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_olvideTxtMouseExited
        this.olvideTxt.setForeground(Color.black);
    }//GEN-LAST:event_olvideTxtMouseExited

    private void olvideTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_olvideTxtMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=hPr-Yc92qaY"));
        } catch (URISyntaxException | IOException ex) {
        }
    }//GEN-LAST:event_olvideTxtMouseClicked

    private void ingresarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarTxtMouseEntered
        this.ingresarBt.setBackground(new Color(248, 200, 99));
    }//GEN-LAST:event_ingresarTxtMouseEntered

    private void ingresarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarTxtMouseExited
        this.ingresarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_ingresarTxtMouseExited

    private void ingresarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarTxtMouseClicked
        if (!this.usuarioFd.getText().equals("Ingrese su usuario") && !String.valueOf(this.contrasenaFd.getPassword()).equals("************")) {
            String usuario = this.usuarioFd.getText();
            String clave = String.valueOf(this.contrasenaFd.getPassword());
            int usuarioId = 0;
            boolean usuarioExist = false;
            boolean claveCorrecta = false;
            int rolId = 0;
            List<Usuario> usuarios = this.usuarioDao.seleccionar("");
            for (Usuario u : usuarios) {
                if (usuario.equals(u.getUsuario())) {
                    usuarioExist = true;
                    if (clave.equals(u.getClave())) {
                        if (u.getEstado() == 1) {
                            JOptionPane.showMessageDialog(null, "Su cuenta ya ha sido iniciada");
                            return;
                        }
                        List<UsuarioRol> usuariosRoles = this.usuarioRolDao.seleccionar();
                        usuarioId = u.getId();
                        claveCorrecta = true;
                        JOptionPane.showMessageDialog(null, "Bienvenido: " + u.getNombre());
                        for (UsuarioRol ur : usuariosRoles) {
                            if (usuarioId == ur.getUsuarioId()) {
                                rolId = ur.getRolId();
                                break;
                            }
                        }
                        break;
                    }
                }
            }            
            
            if (!usuarioExist) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                this.usuarioFd.requestFocus();
                return;
            } else {
                if (!claveCorrecta) {
                    JOptionPane.showMessageDialog(null, "Clave incorrecta");
                    this.contrasenaFd.requestFocus();
                    return;
                }
            }

            switch (rolId) {
                case 0:
                    break;
                case 1:
                    this.setVisible(false);
                    EstudianteGI estudiante = new EstudianteGI(this.usuarioRolDao.obtenerId(usuarioId, rolId));
                    estudiante.setVisible(true);
                    break;
                case 2:
                    this.setVisible(false);
                    ProfesorGI profesor = new ProfesorGI(this.usuarioRolDao.obtenerId(usuarioId, rolId));
                    profesor.setVisible(true);
                    break;
                case 3:
                    this.setVisible(false);
                    AdminGI administrador = new AdminGI(this.usuarioRolDao.obtenerId(usuarioId, rolId));
                    administrador.setVisible(true);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese los datos");
        }
    }//GEN-LAST:event_ingresarTxtMouseClicked

    private void invitadoTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invitadoTxtMouseEntered
        this.invitadoTxt.setForeground(new Color(120, 0, 0));
    }//GEN-LAST:event_invitadoTxtMouseEntered

    private void invitadoTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invitadoTxtMouseExited
        this.invitadoTxt.setForeground(Color.black);
    }//GEN-LAST:event_invitadoTxtMouseExited

    private void invitadoTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invitadoTxtMouseClicked
        this.setVisible(false);
        InvitadoGI invitado = new InvitadoGI();
        invitado.setVisible(true);
    }//GEN-LAST:event_invitadoTxtMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenidaTxt;
    private javax.swing.JPanel contactoBt;
    private javax.swing.JLabel contactoTxt;
    private javax.swing.JPasswordField contrasenaFd;
    private javax.swing.JSeparator contrasenaSp;
    private javax.swing.JLabel contrasenaTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel ingresarBt;
    private javax.swing.JLabel ingresarTxt;
    private javax.swing.JPanel invitadoBt;
    private javax.swing.JLabel invitadoTxt;
    private javax.swing.JLabel logoF;
    private javax.swing.JLabel logoU;
    private javax.swing.JLabel nombreF1;
    private javax.swing.JLabel nombreF2;
    private javax.swing.JLabel nombreU;
    private javax.swing.JPanel olvideBt;
    private javax.swing.JLabel olvideTxt;
    private javax.swing.JPanel paginaBt;
    private javax.swing.JLabel paginaTxt;
    private javax.swing.JPanel panelDer;
    private javax.swing.JPanel panelSup;
    private javax.swing.JPanel salirBt;
    private javax.swing.JLabel salirTxt;
    private javax.swing.JTextField usuarioFd;
    private javax.swing.JSeparator usuarioSp;
    private javax.swing.JLabel usuarioTxt;
    // End of variables declaration//GEN-END:variables
}
