package gui;

import datos.*;
import domain.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EstudianteMatriculasP extends javax.swing.JPanel {

    private int estudianteId;

    private UsuarioMateriaDAO usuarioMateriaDao = new UsuarioMateriaDAO();
    private MateriaDAO materiaDao = new MateriaDAO();
    private CursoDAO cursoDao = new CursoDAO();
    private TareaDAO tareaDao = new TareaDAO();
    private UsuarioMateriaTareaDAO usuarioMateriaTareaDao = new UsuarioMateriaTareaDAO();

    private List<Integer> materiasId;

    public EstudianteMatriculasP(int estudianteId) {
        this.initComponents();
        this.estudianteId = estudianteId;
        this.listarMaterias();
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
                    if (um.getUsuarioRolId() == this.estudianteId) {
                        añadir = false;
                        break;
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
        matriculacionTxt = new javax.swing.JLabel();
        asignaturaTxt = new javax.swing.JLabel();
        asignaturaCb = new javax.swing.JComboBox<>();
        hacerBt = new javax.swing.JPanel();
        hacerTxt = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        matriculacionTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        matriculacionTxt.setForeground(new java.awt.Color(193, 18, 31));
        matriculacionTxt.setText("Matriculación");
        fondo.add(matriculacionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        asignaturaTxt.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        asignaturaTxt.setText("Asignaturas:");
        fondo.add(asignaturaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        asignaturaCb.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        asignaturaCb.setPreferredSize(new java.awt.Dimension(350, 22));
        fondo.add(asignaturaCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 450, -1));

        hacerBt.setBackground(new java.awt.Color(253, 240, 213));
        hacerBt.setPreferredSize(new java.awt.Dimension(150, 40));

        hacerTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        hacerTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hacerTxt.setText("Matricular");
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

        fondo.add(hacerBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void hacerTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseClicked
        if (this.asignaturaCb.getSelectedIndex() > 0) {
            UsuarioMateria usuarioMateria = new UsuarioMateria();
            usuarioMateria.setUsuarioRolId(this.estudianteId);
            usuarioMateria.setMateriaId(this.materiasId.get(this.asignaturaCb.getSelectedIndex()));
            this.usuarioMateriaDao.insertar(usuarioMateria);
            
            int usuarioMateriaId = this.usuarioMateriaDao.obtenerUltimo();
            
            UsuarioMateria profesor = this.usuarioMateriaDao.profesorByMateria(this.materiasId.get(this.asignaturaCb.getSelectedIndex()));
            List<Tarea> tareas = this.tareaDao.tareasByProfesor(profesor.getId());
            for (Tarea t : tareas) {
                UsuarioMateriaTarea umt = new UsuarioMateriaTarea();
                umt.setTareaId(t.getId());
                umt.setUsuarioMateriaId(usuarioMateriaId);
                this.usuarioMateriaTareaDao.insertar(umt);
            }
            
            JOptionPane.showMessageDialog(null, "Se ha matriculado en la materia");
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
    private javax.swing.JComboBox<String> asignaturaCb;
    private javax.swing.JLabel asignaturaTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel hacerBt;
    private javax.swing.JLabel hacerTxt;
    private javax.swing.JLabel matriculacionTxt;
    // End of variables declaration//GEN-END:variables
}
