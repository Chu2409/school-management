package gui;

import datos.*;
import domain.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AdminAsignacionP extends javax.swing.JPanel {

    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private UsuarioRolDAO usuarioRolDao = new UsuarioRolDAO();
    private MateriaDAO materiaDao = new MateriaDAO();
    private CursoDAO cursoDao = new CursoDAO();
    private UsuarioMateriaDAO usuarioMateriaDao = new UsuarioMateriaDAO();
    
    private List<Integer> profesoresId;
    private List<Integer> profesoresRol;
    private List<Integer> materiasId;

    public AdminAsignacionP() {
        this.initComponents();
        this.listarProfesores();
        this.listarMaterias();
    }

    private void listarProfesores() {
        List<Usuario> profesores = this.usuarioDao.listarProfesores();
        
        this.profesoresId = new ArrayList<>();
        this.profesoresId.add(0);

        this.profesoresRol = new ArrayList<>();
        this.profesoresRol.add(0);

        List<String> profesoresNombres = new ArrayList<>();
        profesoresNombres.add("");

        for (Usuario p : profesores) {
            this.profesoresId.add(p.getId());
            profesoresNombres.add(p.getNombre() + " " + p.getApellido());
            this.profesoresRol.add(this.usuarioRolDao.obtenerId(p.getId(), 2));
        }
        
        String[] profesoresLista = new String[profesoresNombres.size()];
        for (int i = 0; i < profesoresNombres.size(); i++) {
            profesoresLista[i] = profesoresNombres.get(i);
        }
        this.profesorCb.setModel(new javax.swing.DefaultComboBoxModel<>(profesoresLista));
    }

    private void listarMaterias() {
        List<UsuarioMateria> usuariosMaterias = this.usuarioMateriaDao.seleccionar();
        List<Materia> materias = this.materiaDao.seleccionar("");
        
        List<String> materiasNombre = new ArrayList<>();
        materiasNombre.add("");
        
        this.materiasId = new ArrayList<>();
        this.materiasId.add(0);

        for (Materia m : materias) {
            boolean añadir = true;
            for (UsuarioMateria um : usuariosMaterias) {
                if (m.getId() == um.getMateriaId()) {
                    for (Integer profesorId : this.profesoresId) {
                        if (um.getUsuarioRolId() == profesorId) {
                            añadir = false;
                            break;
                        }
                    }
                    if (!añadir) {
                        break;
                    }
                }
            }
            if (añadir) {
                materiasNombre.add(m.getMateria() + "; " + this.cursoDao.obtenerNombreCurso(m.getCursoId()));
                this.materiasId.add(m.getId());
            }
        }

        String[] materiaLista = new String[materiasNombre.size()];
        for (int i = 0; i < materiasNombre.size(); i++) {
            materiaLista[i] = materiasNombre.get(i);
        }
        this.asignaturaCb.setModel(new javax.swing.DefaultComboBoxModel<>(materiaLista));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        asignacionTxt = new javax.swing.JLabel();
        profesorTxt = new javax.swing.JLabel();
        profesorCb = new javax.swing.JComboBox<>();
        asignaturaTxt = new javax.swing.JLabel();
        asignaturaCb = new javax.swing.JComboBox<>();
        hacerBt = new javax.swing.JPanel();
        hacerTxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asignacionTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        asignacionTxt.setForeground(new java.awt.Color(193, 18, 31));
        asignacionTxt.setText("Asignación");
        fondo.add(asignacionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        profesorTxt.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        profesorTxt.setText("Profesor:");
        fondo.add(profesorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        profesorCb.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        profesorCb.setPreferredSize(new java.awt.Dimension(350, 22));
        fondo.add(profesorCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        asignaturaTxt.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        asignaturaTxt.setText("Asignaturas:");
        fondo.add(asignaturaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        asignaturaCb.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        asignaturaCb.setPreferredSize(new java.awt.Dimension(350, 22));
        fondo.add(asignaturaCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 400, -1));

        hacerBt.setBackground(new java.awt.Color(253, 240, 213));
        hacerBt.setPreferredSize(new java.awt.Dimension(150, 40));

        hacerTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        hacerTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hacerTxt.setText("Asignar");
        hacerTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        fondo.add(hacerBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 110, -1, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void hacerTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseClicked
        if (this.profesorCb.getSelectedIndex() > 0 && this.asignaturaCb.getSelectedIndex() > 0) {
            UsuarioMateria usuarioMateria = new UsuarioMateria();
            usuarioMateria.setUsuarioRolId(this.profesoresRol.get(this.profesorCb.getSelectedIndex()));
            usuarioMateria.setMateriaId(this.materiasId.get(this.asignaturaCb.getSelectedIndex()));
            this.usuarioMateriaDao.insertar(usuarioMateria);
            JOptionPane.showMessageDialog(null, "Se ha asignado la materia");
            this.listarProfesores();
            this.listarMaterias();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione los campos");
        }
    }//GEN-LAST:event_hacerTxtMouseClicked

    private void hacerTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseEntered
        this.hacerBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_hacerTxtMouseEntered

    private void hacerTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseExited
        this.hacerBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_hacerTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asignacionTxt;
    private javax.swing.JComboBox<String> asignaturaCb;
    private javax.swing.JLabel asignaturaTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel hacerBt;
    private javax.swing.JLabel hacerTxt;
    private javax.swing.JComboBox<String> profesorCb;
    private javax.swing.JLabel profesorTxt;
    // End of variables declaration//GEN-END:variables
}
