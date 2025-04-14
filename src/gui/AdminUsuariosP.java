package gui;

import datos.*;
import domain.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class AdminUsuariosP extends javax.swing.JPanel {

    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private UsuarioRolDAO usuarioRolDao = new UsuarioRolDAO();
    private UsuarioMateriaDAO usuarioMateriaDao = new UsuarioMateriaDAO();
    private RolDAO rolDao = new RolDAO();

    public AdminUsuariosP() {
        this.initComponents();
        this.listarUsuarios();
    }

    private void listarUsuarios() {
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);
        
        List<Usuario> usuarios = this.usuarioDao.listarEstuProf();
        for (Usuario u : usuarios) {
            model.addRow(new Object[]{u.getId(), u.getUsuario(), u.getClave(), u.getCedula(), u.getNombre(), u.getApellido(), u.getEmail(), this.rolDao.rolByUsuarioId(u.getId()), u.getEstado()});
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
    
    private boolean verificarAso(int usuarioRolId) {
        List<Integer> asociados = this.usuarioMateriaDao.verificarAluAso(usuarioRolId);
        boolean asociado = true;
        if (asociados.isEmpty()) {
            asociado = false;
        }
        return asociado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        usuariosTxt = new javax.swing.JLabel();
        buscarPorTxt = new javax.swing.JLabel();
        buscarFd = new javax.swing.JTextField();
        buscarSp = new javax.swing.JSeparator();
        rolTxt = new javax.swing.JLabel();
        rolCb = new javax.swing.JComboBox<>();
        buscarBt = new javax.swing.JPanel();
        buscarTxt = new javax.swing.JLabel();
        infoSc = new javax.swing.JScrollPane();
        infoTb = new javax.swing.JTable();
        crearBt = new javax.swing.JPanel();
        crearTxt = new javax.swing.JLabel();
        modiBt = new javax.swing.JPanel();
        modiTxt = new javax.swing.JLabel();
        eliminarBt = new javax.swing.JPanel();
        eliminarTxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuariosTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        usuariosTxt.setForeground(new java.awt.Color(193, 18, 31));
        usuariosTxt.setText("Usuarios");
        fondo.add(usuariosTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        buscarPorTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        buscarPorTxt.setText("Busca por Usuario:");
        fondo.add(buscarPorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        buscarFd.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        buscarFd.setBorder(null);
        buscarFd.setPreferredSize(new java.awt.Dimension(400, 22));
        fondo.add(buscarFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, 20));

        buscarSp.setPreferredSize(new java.awt.Dimension(400, 10));
        fondo.add(buscarSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, 10));

        rolTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        rolTxt.setText("Busca por Rol:");
        fondo.add(rolTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        rolCb.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        rolCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Estudiante", "Profesor" }));
        rolCb.setToolTipText("");
        rolCb.setPreferredSize(new java.awt.Dimension(150, 22));
        fondo.add(rolCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

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

        fondo.add(buscarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, -1, -1));

        infoTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Clave", "Cedula", "Nombre", "Apellido", "Correo", "Rol", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infoSc.setViewportView(infoTb);
        if (infoTb.getColumnModel().getColumnCount() > 0) {
            infoTb.getColumnModel().getColumn(0).setMinWidth(50);
            infoTb.getColumnModel().getColumn(0).setPreferredWidth(50);
            infoTb.getColumnModel().getColumn(0).setMaxWidth(50);
            infoTb.getColumnModel().getColumn(1).setMinWidth(170);
            infoTb.getColumnModel().getColumn(1).setPreferredWidth(170);
            infoTb.getColumnModel().getColumn(1).setMaxWidth(170);
            infoTb.getColumnModel().getColumn(2).setMinWidth(170);
            infoTb.getColumnModel().getColumn(2).setPreferredWidth(170);
            infoTb.getColumnModel().getColumn(2).setMaxWidth(170);
            infoTb.getColumnModel().getColumn(3).setMinWidth(120);
            infoTb.getColumnModel().getColumn(3).setPreferredWidth(120);
            infoTb.getColumnModel().getColumn(3).setMaxWidth(120);
            infoTb.getColumnModel().getColumn(7).setMinWidth(100);
            infoTb.getColumnModel().getColumn(7).setPreferredWidth(100);
            infoTb.getColumnModel().getColumn(7).setMaxWidth(100);
            infoTb.getColumnModel().getColumn(8).setMinWidth(50);
            infoTb.getColumnModel().getColumn(8).setPreferredWidth(50);
            infoTb.getColumnModel().getColumn(8).setMaxWidth(50);
        }

        fondo.add(infoSc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1260, 360));

        crearBt.setBackground(new java.awt.Color(253, 240, 213));
        crearBt.setPreferredSize(new java.awt.Dimension(150, 40));

        crearTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        crearTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        crearTxt.setText("Crear");
        crearTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearTxt.setPreferredSize(new java.awt.Dimension(150, 40));
        crearTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout crearBtLayout = new javax.swing.GroupLayout(crearBt);
        crearBt.setLayout(crearBtLayout);
        crearBtLayout.setHorizontalGroup(
            crearBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearBtLayout.createSequentialGroup()
                .addComponent(crearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        crearBtLayout.setVerticalGroup(
            crearBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crearBtLayout.createSequentialGroup()
                .addComponent(crearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(crearBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, -1, -1));

        modiBt.setBackground(new java.awt.Color(253, 240, 213));
        modiBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modiBt.setPreferredSize(new java.awt.Dimension(150, 40));

        modiTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        modiTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modiTxt.setText("Modificar");
        modiTxt.setPreferredSize(new java.awt.Dimension(150, 40));
        modiTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modiTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modiTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modiTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout modiBtLayout = new javax.swing.GroupLayout(modiBt);
        modiBt.setLayout(modiBtLayout);
        modiBtLayout.setHorizontalGroup(
            modiBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modiBtLayout.createSequentialGroup()
                .addComponent(modiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        modiBtLayout.setVerticalGroup(
            modiBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modiBtLayout.createSequentialGroup()
                .addComponent(modiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(modiBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, -1, -1));

        eliminarBt.setBackground(new java.awt.Color(253, 240, 213));
        eliminarBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarBt.setPreferredSize(new java.awt.Dimension(150, 40));

        eliminarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        eliminarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eliminarTxt.setText("Eliminar");
        eliminarTxt.setPreferredSize(new java.awt.Dimension(150, 40));
        eliminarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout eliminarBtLayout = new javax.swing.GroupLayout(eliminarBt);
        eliminarBt.setLayout(eliminarBtLayout);
        eliminarBtLayout.setHorizontalGroup(
            eliminarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarBtLayout.createSequentialGroup()
                .addComponent(eliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        eliminarBtLayout.setVerticalGroup(
            eliminarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarBtLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(eliminarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fondo.add(eliminarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 500, -1, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void crearTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearTxtMouseEntered
        this.crearBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_crearTxtMouseEntered

    private void crearTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearTxtMouseExited
        this.crearBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_crearTxtMouseExited

    private void crearTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearTxtMouseClicked
        AdminGI.mostrarPanel(new AdminUsuariosModP());
    }//GEN-LAST:event_crearTxtMouseClicked

    private void modiTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiTxtMouseEntered
        this.modiBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_modiTxtMouseEntered

    private void modiTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiTxtMouseExited
        this.modiBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_modiTxtMouseExited

    private void modiTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiTxtMouseClicked
        if (this.infoTb.getSelectedRow() > -1) {
            int usuarioId = (int) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 0);
            AdminGI.mostrarPanel(new AdminUsuariosModP(this.usuarioDao.obtenerPersona(usuarioId)));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione usuario a editar");
        }
    }//GEN-LAST:event_modiTxtMouseClicked

    private void eliminarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTxtMouseEntered
        this.eliminarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_eliminarTxtMouseEntered

    private void eliminarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTxtMouseExited
        this.eliminarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_eliminarTxtMouseExited

    private void eliminarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTxtMouseClicked
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        if (this.infoTb.getSelectedRow() > -1) {
            int usuarioId = (int) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 0);
            int usuarioRol = this.verificarRol(usuarioId);
            if (!this.verificarAso(this.usuarioRolDao.obtenerId(usuarioId, usuarioRol))) {
                this.usuarioRolDao.eliminar(this.usuarioRolDao.obtenerId(usuarioId, usuarioRol));
                this.usuarioDao.eliminar(usuarioId);
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
                model.removeRow(this.infoTb.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(null, "Existen registros asociados a este usuario");
            }  
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione usuario a eliminar");
        }
    }//GEN-LAST:event_eliminarTxtMouseClicked

    private void buscarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseEntered
        this.buscarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_buscarTxtMouseEntered

    private void buscarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseExited
        this.buscarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_buscarTxtMouseExited

    private void buscarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseClicked
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);
        
        String usuarioBuscar = this.buscarFd.getText().trim();    
        if (this.rolCb.getSelectedIndex() == 0) {
            List<Usuario> usuarios = this.usuarioDao.estudiantesByMateria(usuarioBuscar);
            for (Usuario u : usuarios) {
                model.addRow(new Object[]{u.getId(), u.getUsuario(), u.getClave(), u.getCedula(), u.getNombre(), u.getApellido(), u.getEmail(), rolDao.rolByUsuarioId(u.getId()), u.getEstado()});
            }
        } else {
            List<Usuario> usuarios = this.usuarioDao.seleccionarByNameRol(this.rolCb.getSelectedIndex(), usuarioBuscar);
            for (Usuario u : usuarios) {
                model.addRow(new Object[]{u.getId(), u.getUsuario(), u.getClave(), u.getCedula(), u.getNombre(), u.getApellido(), u.getEmail(), rolDao.rolByUsuarioId(u.getId()), u.getEstado()});
            }
        }
    }//GEN-LAST:event_buscarTxtMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buscarBt;
    private javax.swing.JTextField buscarFd;
    private javax.swing.JLabel buscarPorTxt;
    private javax.swing.JSeparator buscarSp;
    private javax.swing.JLabel buscarTxt;
    private javax.swing.JPanel crearBt;
    private javax.swing.JLabel crearTxt;
    private javax.swing.JPanel eliminarBt;
    private javax.swing.JLabel eliminarTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JScrollPane infoSc;
    private javax.swing.JTable infoTb;
    private javax.swing.JPanel modiBt;
    private javax.swing.JLabel modiTxt;
    private javax.swing.JComboBox<String> rolCb;
    private javax.swing.JLabel rolTxt;
    private javax.swing.JLabel usuariosTxt;
    // End of variables declaration//GEN-END:variables
}
