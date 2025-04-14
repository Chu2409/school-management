package gui;

import com.github.sarxos.webcam.*;
import datos.*;
import domain.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import utilities.Utilidad;

public class EstudianteInfoP extends javax.swing.JPanel {

    private int estudianteId;

    private UsuarioDAO usuarioDao = new UsuarioDAO();

    private Usuario estudiante;

    private Webcam webcam = Webcam.getDefault();
    private WebcamPanel cam = new WebcamPanel(this.webcam, new Dimension(270, 270), false);
    private BufferedImage bufferedImage;

    private String rutaFoto;

    public EstudianteInfoP(int estudianteId) {
        this.initComponents();
        this.webcam.close();

        this.estudianteId = estudianteId;
        this.estudiante = usuarioDao.usuarioByUsuarioId(this.estudianteId);

        this.llenarDatos();

        this.webcam.setViewSize(WebcamResolution.VGA.getSize());
        this.cam.setFillArea(true);
        this.fotografiaP.setLayout(new FlowLayout());
        this.fotografiaP.add(cam);

        this.capturarBt.setVisible(false);
    }

    private void llenarDatos() {
        this.nombreFd.setText(this.estudiante.getNombre());
        this.apellidoFd.setText(this.estudiante.getApellido());
        this.direccionFd.setText(this.estudiante.getDireccion());
        this.emailFd.setText(this.estudiante.getEmail());

        ImageIcon foto = new ImageIcon(this.estudiante.getFotografia());
        Icon iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(270, 280, Image.SCALE_SMOOTH));
        this.fotoLb.setIcon(iconoFoto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo1 = new javax.swing.JPanel();
        infoTxt = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JLabel();
        nombreFd = new javax.swing.JTextField();
        nombreSp = new javax.swing.JSeparator();
        apellidoTxt = new javax.swing.JLabel();
        apellidoFd = new javax.swing.JTextField();
        apellidoSp = new javax.swing.JSeparator();
        direccionTxt = new javax.swing.JLabel();
        direccionFd = new javax.swing.JTextField();
        direccionSp = new javax.swing.JSeparator();
        emailTxt = new javax.swing.JLabel();
        emailFd = new javax.swing.JTextField();
        emailSp = new javax.swing.JSeparator();
        fotografiaTxt = new javax.swing.JLabel();
        fotografiaP = new javax.swing.JPanel();
        fotoLb = new javax.swing.JLabel();
        capturarBt = new javax.swing.JPanel();
        capturarTxt = new javax.swing.JLabel();
        hacerBt = new javax.swing.JPanel();
        hacerTxt = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo1.setBackground(new java.awt.Color(255, 255, 255));
        fondo1.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        infoTxt.setForeground(new java.awt.Color(193, 18, 31));
        infoTxt.setText("Información Personal");
        fondo1.add(infoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        nombreTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        nombreTxt.setText("Nombre");
        fondo1.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        nombreFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        nombreFd.setBorder(null);
        nombreFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo1.add(nombreFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        nombreSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo1.add(nombreSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        apellidoTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        apellidoTxt.setText("Apellido");
        fondo1.add(apellidoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        apellidoFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        apellidoFd.setBorder(null);
        apellidoFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo1.add(apellidoFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, 20));

        apellidoSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo1.add(apellidoSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        direccionTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        direccionTxt.setText("Dirección");
        fondo1.add(direccionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        direccionFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        direccionFd.setBorder(null);
        direccionFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo1.add(direccionFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, 20));

        direccionSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo1.add(direccionSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        emailTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        emailTxt.setText("Correo");
        fondo1.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        emailFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        emailFd.setBorder(null);
        emailFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo1.add(emailFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, 20));

        emailSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo1.add(emailSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, -1, -1));

        fotografiaTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        fotografiaTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fotografiaTxt.setText("Fotografía");
        fondo1.add(fotografiaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 100, -1));

        fotografiaP.setBackground(new java.awt.Color(255, 255, 255));
        fotografiaP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fotografiaP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fotografiaP.setPreferredSize(new java.awt.Dimension(270, 280));
        fotografiaP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fotografiaPMouseClicked(evt);
            }
        });
        fotografiaP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fotoLb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fotoLb.setPreferredSize(new java.awt.Dimension(270, 280));
        fotoLb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fotoLbMouseClicked(evt);
            }
        });
        fotografiaP.add(fotoLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 280));

        fondo1.add(fotografiaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 270, 280));

        capturarBt.setBackground(new java.awt.Color(253, 240, 213));
        capturarBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        capturarBt.setPreferredSize(new java.awt.Dimension(150, 40));

        capturarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        capturarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        capturarTxt.setText("Capturar");
        capturarTxt.setPreferredSize(new java.awt.Dimension(150, 40));
        capturarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                capturarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                capturarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                capturarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout capturarBtLayout = new javax.swing.GroupLayout(capturarBt);
        capturarBt.setLayout(capturarBtLayout);
        capturarBtLayout.setHorizontalGroup(
            capturarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capturarBtLayout.createSequentialGroup()
                .addComponent(capturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        capturarBtLayout.setVerticalGroup(
            capturarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capturarBtLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(capturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fondo1.add(capturarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, -1, -1));

        hacerBt.setBackground(new java.awt.Color(253, 240, 213));
        hacerBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hacerBt.setPreferredSize(new java.awt.Dimension(150, 40));

        hacerTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        hacerTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hacerTxt.setText("Actualizar");
        hacerTxt.setPreferredSize(new java.awt.Dimension(150, 40));
        hacerTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hacerTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hacerTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hacerTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout hacerBtLayout = new javax.swing.GroupLayout(hacerBt);
        hacerBt.setLayout(hacerBtLayout);
        hacerBtLayout.setHorizontalGroup(
            hacerBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hacerBtLayout.createSequentialGroup()
                .addComponent(hacerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        hacerBtLayout.setVerticalGroup(
            hacerBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hacerBtLayout.createSequentialGroup()
                .addComponent(hacerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo1.add(hacerBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 500, -1, -1));

        add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void hacerTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseExited
        this.hacerBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_hacerTxtMouseExited

    private void hacerTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseEntered
        this.hacerBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_hacerTxtMouseEntered

    private void hacerTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseClicked

        String nombre = this.nombreFd.getText().trim();
        String apellido = this.apellidoFd.getText().trim();
        String direccion = this.direccionFd.getText().trim();
        String email = this.emailFd.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene los campos obligatorios");
            return;
        }
        if (nombre.length() > 100) {
            JOptionPane.showMessageDialog(null, "Longitud maxima de caracteres en nombre: 100");
            this.nombreFd.requestFocus();
            return;
        }
        if (apellido.length() > 100) {
            JOptionPane.showMessageDialog(null, "Longitud maxima de caracteres en apellido: 100");
            this.apellidoFd.requestFocus();
            return;
        }
        if (direccion.length() > 255) {
            JOptionPane.showMessageDialog(null, "Longitud maxima de caracteres en direccion: 255");
            this.direccionFd.requestFocus();
            return;
        }
        if (!direccion.isEmpty()) {
            if (direccion.contains("\"") || direccion.contains("\'")) {
                JOptionPane.showMessageDialog(null, "Direccion incorrecta");
                this.direccionFd.requestFocus();
                return;
            } else {
                direccion = Utilidad.toMayuscula(direccion);
            }
        } else {
            direccion = null;
        }
        if (!Utilidad.validarNombre(nombre)) {
            JOptionPane.showMessageDialog(null, "Nombre incorrecto");
            this.nombreFd.requestFocus();
            return;
        } else {
            nombre = Utilidad.toMayuscula(nombre).trim();
        }
        if (!Utilidad.validarNombre(apellido)) {
            JOptionPane.showMessageDialog(null, "Apellido incorrecto");
            this.apellidoFd.requestFocus();
            return;
        } else {
            apellido = Utilidad.toMayuscula(apellido).trim();
        }
        if (!Utilidad.validarEmail(email)) {
            JOptionPane.showMessageDialog(null, "Correo incorrecto");
            this.emailFd.requestFocus();
            return;
        }

        this.estudiante.setNombre(nombre);
        this.estudiante.setApellido(apellido);
        this.estudiante.setDireccion(direccion);
        this.estudiante.setEmail(email);
        this.estudiante.setFotografia(this.rutaFoto);

        List<Usuario> usuarios = this.usuarioDao.seleccionar("");

        for (Usuario u : usuarios) {
            if (u.getId() == this.estudiante.getId()) {
                continue;
            }
            if (email.equals(u.getEmail())) {
                JOptionPane.showMessageDialog(null, "Ya existe registro con este correo");
                this.emailFd.requestFocus();
                return;
            }
        }

        this.usuarioDao.actualizar(this.estudiante);

        JOptionPane.showMessageDialog(null, "Informacion actualizada exitosamente");
    }//GEN-LAST:event_hacerTxtMouseClicked

    private void fotografiaPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotografiaPMouseClicked
    }//GEN-LAST:event_fotografiaPMouseClicked

    private void capturarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capturarTxtMouseClicked
        this.bufferedImage = this.webcam.getImage();

        File salidaImagen = new File("C:/Users/Daniel/Pictures/Proyecto/" + this.estudiante.getCedula() + ".jpg");
        this.rutaFoto = salidaImagen.getAbsolutePath();

        try {
            ImageIO.write(this.bufferedImage, "jpg", salidaImagen);
        } catch (IOException ex) {
        }

        ImageIcon foto = new ImageIcon(this.webcam.getImage());
        Icon iconFoto = new ImageIcon(foto.getImage().getScaledInstance(270, 280, Image.SCALE_SMOOTH));
        this.fotoLb.setIcon(iconFoto);
        this.fotoLb.setVisible(true);

        this.cam.stop();
        this.capturarBt.setVisible(false);
        JOptionPane.showMessageDialog(null, "Foto actualizada");
    }//GEN-LAST:event_capturarTxtMouseClicked

    private void capturarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capturarTxtMouseEntered
        this.capturarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_capturarTxtMouseEntered

    private void capturarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capturarTxtMouseExited
        this.capturarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_capturarTxtMouseExited

    private void fotoLbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoLbMouseClicked
        Thread hilo = new Thread() {
            @Override
            public void run() {
                cam.start();
                fotoLb.setVisible(false);
                capturarBt.setVisible(true);
            }
        };
        hilo.setDaemon(true);
        hilo.start();
    }//GEN-LAST:event_fotoLbMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoFd;
    private javax.swing.JSeparator apellidoSp;
    private javax.swing.JLabel apellidoTxt;
    private javax.swing.JPanel capturarBt;
    private javax.swing.JLabel capturarTxt;
    private javax.swing.JTextField direccionFd;
    private javax.swing.JSeparator direccionSp;
    private javax.swing.JLabel direccionTxt;
    private javax.swing.JTextField emailFd;
    private javax.swing.JSeparator emailSp;
    private javax.swing.JLabel emailTxt;
    private javax.swing.JPanel fondo1;
    private javax.swing.JLabel fotoLb;
    private javax.swing.JPanel fotografiaP;
    private javax.swing.JLabel fotografiaTxt;
    private javax.swing.JPanel hacerBt;
    private javax.swing.JLabel hacerTxt;
    private javax.swing.JLabel infoTxt;
    private javax.swing.JTextField nombreFd;
    private javax.swing.JSeparator nombreSp;
    private javax.swing.JLabel nombreTxt;
    // End of variables declaration//GEN-END:variables
}
