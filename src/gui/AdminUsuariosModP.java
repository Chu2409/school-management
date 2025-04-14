package gui;

import datos.*;
import domain.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import utilities.Utilidad;

public class AdminUsuariosModP extends javax.swing.JPanel {

    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private UsuarioRolDAO usuarioRolDao = new UsuarioRolDAO();
    private Usuario usuario = new Usuario();
    private RolDAO rolDao = new RolDAO();
    
    private boolean edicion = false;
    private int usuarioId;

    public AdminUsuariosModP() {
        this.initComponents();
    }

    public AdminUsuariosModP(Usuario usuario) {
        this.initComponents();
        this.usuario = usuario;
        this.usuarioId = usuario.getId();
        this.edicion = true;
        this.editar(verificarRol(this.usuarioId));
    }

    private void editar(int usuarioRol) {
        if (this.edicion) {
            this.panelTxt.setText("Modificar Usuario");
            this.hacerTxt.setText("Guardar");
            this.usuarioFd.setText(this.usuario.getUsuario());
            this.claveFd.setText(this.usuario.getClave());
            this.cedulaFd.setText(this.usuario.getCedula());
            this.nombreFd.setText(this.usuario.getNombre());
            this.apellidoFd.setText(this.usuario.getApellido());
            this.emailFd.setText(this.usuario.getEmail());
            this.rolCb.setSelectedIndex(usuarioRol - 1);
            this.rolTxt.setVisible(false);
            this.rolCb.setVisible(false);
        }
    }

     private int verificarRol(int usuarioId) {
        String rol = this.rolDao.rolByUsuarioId(usuarioId);
        int usuarioRol = 0;
        if (rol.equals("Estudiante")) {
            usuarioRol = 1;
        } else if (rol.equals("Profesor")) {
            usuarioRol = 2;
        }
        return usuarioRol;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        panelTxt = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JLabel();
        usuarioFd = new javax.swing.JTextField();
        usuarioSp = new javax.swing.JSeparator();
        claveTxt = new javax.swing.JLabel();
        claveFd = new javax.swing.JTextField();
        claveSp = new javax.swing.JSeparator();
        cedulaTxt = new javax.swing.JLabel();
        cedulaFd = new javax.swing.JTextField();
        cedulaSp = new javax.swing.JSeparator();
        nombreTxt = new javax.swing.JLabel();
        nombreFd = new javax.swing.JTextField();
        nombreSp = new javax.swing.JSeparator();
        apellidoTxt = new javax.swing.JLabel();
        apellidoFd = new javax.swing.JTextField();
        apellidoSp = new javax.swing.JSeparator();
        emailTxt = new javax.swing.JLabel();
        emailFd = new javax.swing.JTextField();
        emailSp = new javax.swing.JSeparator();
        rolTxt = new javax.swing.JLabel();
        rolCb = new javax.swing.JComboBox<>();
        hacerBt = new javax.swing.JPanel();
        hacerTxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        panelTxt.setForeground(new java.awt.Color(193, 18, 31));
        panelTxt.setText("Creación de Usuario");
        fondo.add(panelTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        usuarioTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        usuarioTxt.setText("Usuario");
        fondo.add(usuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        usuarioFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        usuarioFd.setBorder(null);
        usuarioFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo.add(usuarioFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 20));

        usuarioSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo.add(usuarioSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        claveTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        claveTxt.setText("Contraseña");
        fondo.add(claveTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        claveFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        claveFd.setBorder(null);
        claveFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo.add(claveFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, 20));

        claveSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo.add(claveSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        cedulaTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        cedulaTxt.setText("Cedula");
        fondo.add(cedulaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        cedulaFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        cedulaFd.setBorder(null);
        cedulaFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo.add(cedulaFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        cedulaSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo.add(cedulaSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        nombreTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        nombreTxt.setText("Nombre");
        fondo.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        nombreFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        nombreFd.setBorder(null);
        nombreFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo.add(nombreFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        nombreSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo.add(nombreSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, -1));

        apellidoTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        apellidoTxt.setText("Apellido");
        fondo.add(apellidoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, -1));

        apellidoFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        apellidoFd.setBorder(null);
        apellidoFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo.add(apellidoFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, -1, 20));

        apellidoSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo.add(apellidoSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, -1, -1));

        emailTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        emailTxt.setText("Correo");
        fondo.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, -1, -1));

        emailFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        emailFd.setBorder(null);
        emailFd.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo.add(emailFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, -1, 20));

        emailSp.setPreferredSize(new java.awt.Dimension(350, 10));
        fondo.add(emailSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, -1, -1));

        rolTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        rolTxt.setText("Rol");
        fondo.add(rolTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, -1));

        rolCb.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        rolCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Profesor" }));
        rolCb.setPreferredSize(new java.awt.Dimension(350, 20));
        fondo.add(rolCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, -1, -1));

        hacerBt.setBackground(new java.awt.Color(253, 240, 213));
        hacerBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hacerBt.setPreferredSize(new java.awt.Dimension(150, 40));

        hacerTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        hacerTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hacerTxt.setText("Registrar");
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

        fondo.add(hacerBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, -1, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void hacerTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseEntered
        this.hacerBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_hacerTxtMouseEntered

    private void hacerTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseExited
        this.hacerBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_hacerTxtMouseExited

    private void hacerTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseClicked
        String usuarioNombre = this.usuarioFd.getText().trim();
        String clave = this.claveFd.getText();
        String cedula = this.cedulaFd.getText().trim();
        String nombre = this.nombreFd.getText().trim();
        String apellido = this.apellidoFd.getText().trim();
        String email = this.emailFd.getText().trim();
        String rol = this.rolCb.getSelectedItem().toString();
        
        int rolId = 0;

        if (usuarioNombre.isEmpty() || clave.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            return;
        }
        if (usuarioNombre.length() > 60) {
            JOptionPane.showMessageDialog(null, "Longitud maxima de caracteres en usuario: 60");
            this.usuarioFd.requestFocus();
            return;
        }
        if (clave.length() > 60) {
            JOptionPane.showMessageDialog(null, "Longitud maxima de caracteres en clave: 60");
            this.claveFd.requestFocus();
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
        if (usuarioNombre.contains("\"") || usuarioNombre.contains("\'")) {
            JOptionPane.showMessageDialog(null, "Usuario incorrecto");
            this.usuarioFd.requestFocus();
            return;
        }
        if (!Utilidad.validarCedula(cedula)) {
            JOptionPane.showMessageDialog(null, "Cedula incorrecta");
            this.cedulaFd.requestFocus();
            return;
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
        
        if (rol.equals("Estudiante")) {
            rolId = 1;
        } else if (rol.equals("Profesor")) {
            rolId = 2;
        }

        Usuario usuarioAux = this.edicion ? this.usuario : new Usuario();
        usuarioAux.setUsuario(usuarioNombre);
        usuarioAux.setClave(clave);
        usuarioAux.setCedula(cedula);
        usuarioAux.setNombre(nombre);
        usuarioAux.setApellido(apellido);
        usuarioAux.setEmail(email);

        UsuarioRol usuarioRol = new UsuarioRol();
 
        List<Usuario> usuarios = this.usuarioDao.seleccionar("");
        if (!this.edicion) {   
            for (Usuario u : usuarios) {
                if (usuarioNombre.equals(u.getUsuario())) {
                    JOptionPane.showMessageDialog(null, "Ya existe registro con este usuario");
                    this.usuarioFd.requestFocus();
                    return;
                }
                if (cedula.equals(u.getCedula())) {
                    JOptionPane.showMessageDialog(null, "Ya existe registro con esta cedula");
                    this.cedulaFd.requestFocus();
                    return;
                }
                if (email.equals(u.getEmail())) {
                    JOptionPane.showMessageDialog(null, "Ya existe registro con este correo");
                    this.emailFd.requestFocus();
                    return;
                }
            }
            this.usuarioDao.insertar(usuarioAux);    
            
            usuarioRol.setUsuarioId(this.usuarioDao.obtenerUltimo());
            usuarioRol.setRolId(rolId);
            this.usuarioRolDao.insertar(usuarioRol);
        } else {
            for (Usuario u : usuarios) {
                if (u.getId() == usuarioAux.getId()) {
                    continue;
                }
                if (usuarioNombre.equals(u.getUsuario())) {
                    JOptionPane.showMessageDialog(null, "Ya existe registro con este usuario");
                    this.usuarioFd.requestFocus();
                    return;
                }
                if (cedula.equals(u.getCedula())) {
                    JOptionPane.showMessageDialog(null, "Ya existe registro con esta cedula");
                    this.cedulaFd.requestFocus();
                    return;
                }
                if (email.equals(u.getEmail())) {
                    JOptionPane.showMessageDialog(null, "Ya existe registro con este correo");
                    this.emailFd.requestFocus();
                    return;
                }
            }
            this.usuarioDao.actualizar(usuarioAux);
            
            usuarioRol.setUsuarioId(this.usuarioId);
            usuarioRol.setRolId(rolId);
            usuarioRol.setId(this.usuarioRolDao.obtenerId(usuarioRol.getUsuarioId(), this.verificarRol(this.usuarioId)));
            this.usuarioRolDao.actualizar(usuarioRol);
        }

        String mensaje = this.edicion ? "modificado" : "registrado";
        JOptionPane.showMessageDialog(null, "Usuario " + mensaje + " exitosamente");

        if (!this.edicion) {
            this.usuarioFd.setText("");
            this.claveFd.setText("");
            this.cedulaFd.setText("");
            this.nombreFd.setText("");
            this.apellidoFd.setText("");
            this.emailFd.setText("");
            this.usuarioFd.requestFocus();
        }
    }//GEN-LAST:event_hacerTxtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoFd;
    private javax.swing.JSeparator apellidoSp;
    private javax.swing.JLabel apellidoTxt;
    private javax.swing.JTextField cedulaFd;
    private javax.swing.JSeparator cedulaSp;
    private javax.swing.JLabel cedulaTxt;
    private javax.swing.JTextField claveFd;
    private javax.swing.JSeparator claveSp;
    private javax.swing.JLabel claveTxt;
    private javax.swing.JTextField emailFd;
    private javax.swing.JSeparator emailSp;
    private javax.swing.JLabel emailTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel hacerBt;
    private javax.swing.JLabel hacerTxt;
    private javax.swing.JTextField nombreFd;
    private javax.swing.JSeparator nombreSp;
    private javax.swing.JLabel nombreTxt;
    private javax.swing.JLabel panelTxt;
    private javax.swing.JComboBox<String> rolCb;
    private javax.swing.JLabel rolTxt;
    private javax.swing.JTextField usuarioFd;
    private javax.swing.JSeparator usuarioSp;
    private javax.swing.JLabel usuarioTxt;
    // End of variables declaration//GEN-END:variables
}
