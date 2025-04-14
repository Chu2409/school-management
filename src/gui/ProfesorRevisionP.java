package gui;

import datos.*;
import domain.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.Utilidad;

public class ProfesorRevisionP extends javax.swing.JPanel {

    private int profesorId;

    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private UsuarioMateriaDAO usuarioMateriaDao = new UsuarioMateriaDAO();
    private UsuarioMateriaTareaDAO usuarioMateriaTareaDao = new UsuarioMateriaTareaDAO();
    private MateriaDAO materiaDao = new MateriaDAO();
    private TareaDAO tareaDao = new TareaDAO();
    private CursoDAO cursoDao = new CursoDAO();

    private List<Integer> materiasId;

    public ProfesorRevisionP(int profesorId) {
        this.initComponents();
        this.profesorId = profesorId;
        this.listarEstudiantesTareas();
        this.listarMaterias();
    }

    private void listarEstudiantesTareas() {
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);

        List<Integer> materias = this.usuarioMateriaDao.materiasByProfesor(this.profesorId);
        for (Integer m : materias) {
            Materia materia = this.materiaDao.materiaByMateriaId(m);
            Curso curso = this.cursoDao.obtenerCurso(materia.getCursoId());
            List<Usuario> estudiantes = this.usuarioDao.estudiantesEnMateria(m);
            for (Usuario e : estudiantes) {
                List<UsuarioMateriaTarea> usuariosMateriasTareas = this.usuarioMateriaTareaDao.tareasByMatUsuId(materia.getId(), e.getId());
                for (UsuarioMateriaTarea umt : usuariosMateriasTareas) {
                    Tarea t = this.tareaDao.tareaBytareaId(umt.getTareaId());
                    model.addRow(new Object[]{e.getNombre() + " " + e.getApellido(), e.getEmail(), materia.getMateria(), curso.getCurso(), umt.getEnvio(), t.getTarea(), umt.getNota()});
                }
            }
        }
    }

    private void listarMaterias() {
        List<Integer> materias = this.usuarioMateriaDao.materiasByProfesor(profesorId);

        this.materiasId = new ArrayList<>();
        this.materiasId.add(0);

        List<String> materiasNombres = new ArrayList<>();
        materiasNombres.add("");

        for (Integer m : materias) {
            Materia materia = this.materiaDao.materiaByMateriaId(m);
            this.materiasId.add(materia.getId());
            materiasNombres.add(materia.getMateria());
        }

        String[] materiasLista = new String[materiasNombres.size()];
        for (int i = 0; i < materiasNombres.size(); i++) {
            materiasLista[i] = materiasNombres.get(i);
        }
        this.asignaturasCb.setModel(new javax.swing.DefaultComboBoxModel<>(materiasLista));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        fondo = new javax.swing.JPanel();
        revisionTxt = new javax.swing.JLabel();
        infoSc = new javax.swing.JScrollPane();
        infoTb = new javax.swing.JTable();
        buscarPorTxt = new javax.swing.JLabel();
        buscarFd = new javax.swing.JTextField();
        buscarSp = new javax.swing.JSeparator();
        asignaturaTxt = new javax.swing.JLabel();
        asignaturasCb = new javax.swing.JComboBox<>();
        buscarBt = new javax.swing.JPanel();
        buscarTxt = new javax.swing.JLabel();
        revisarBt = new javax.swing.JPanel();
        revisarTxt = new javax.swing.JLabel();
        cambiarBt = new javax.swing.JPanel();
        cambiarTxt = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        revisionTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        revisionTxt.setForeground(new java.awt.Color(193, 18, 31));
        revisionTxt.setText("Revisión");
        fondo.add(revisionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        infoTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estudiante", "Correo", "Asignatura", "Curso", "Archivo", "Tarea", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            infoTb.getColumnModel().getColumn(1).setMinWidth(200);
            infoTb.getColumnModel().getColumn(1).setPreferredWidth(200);
            infoTb.getColumnModel().getColumn(1).setMaxWidth(200);
            infoTb.getColumnModel().getColumn(6).setMinWidth(60);
            infoTb.getColumnModel().getColumn(6).setPreferredWidth(60);
            infoTb.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        fondo.add(infoSc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1240, 390));

        buscarPorTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        buscarPorTxt.setText("Busca por estudiante:");
        fondo.add(buscarPorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        buscarFd.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        buscarFd.setBorder(null);
        buscarFd.setPreferredSize(new java.awt.Dimension(400, 22));
        fondo.add(buscarFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, 20));

        buscarSp.setPreferredSize(new java.awt.Dimension(400, 10));
        fondo.add(buscarSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 10));

        asignaturaTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        asignaturaTxt.setText("Busca por Asignatura:");
        fondo.add(asignaturaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));

        asignaturasCb.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        asignaturasCb.setToolTipText("");
        asignaturasCb.setPreferredSize(new java.awt.Dimension(150, 22));
        fondo.add(asignaturasCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 230, -1));

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

        fondo.add(buscarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, -1, -1));

        revisarBt.setBackground(new java.awt.Color(253, 240, 213));
        revisarBt.setPreferredSize(new java.awt.Dimension(150, 40));

        revisarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        revisarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        revisarTxt.setText("Revisar");
        revisarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        revisarTxt.setPreferredSize(new java.awt.Dimension(150, 40));
        revisarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                revisarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                revisarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                revisarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout revisarBtLayout = new javax.swing.GroupLayout(revisarBt);
        revisarBt.setLayout(revisarBtLayout);
        revisarBtLayout.setHorizontalGroup(
            revisarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(revisarBtLayout.createSequentialGroup()
                .addComponent(revisarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        revisarBtLayout.setVerticalGroup(
            revisarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(revisarBtLayout.createSequentialGroup()
                .addComponent(revisarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(revisarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 510, -1, -1));

        cambiarBt.setBackground(new java.awt.Color(253, 240, 213));
        cambiarBt.setPreferredSize(new java.awt.Dimension(150, 40));

        cambiarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        cambiarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cambiarTxt.setText("Calificar");
        cambiarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cambiarTxt.setPreferredSize(new java.awt.Dimension(150, 40));
        cambiarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cambiarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cambiarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout cambiarBtLayout = new javax.swing.GroupLayout(cambiarBt);
        cambiarBt.setLayout(cambiarBtLayout);
        cambiarBtLayout.setHorizontalGroup(
            cambiarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cambiarBtLayout.createSequentialGroup()
                .addComponent(cambiarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cambiarBtLayout.setVerticalGroup(
            cambiarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cambiarBtLayout.createSequentialGroup()
                .addComponent(cambiarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(cambiarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 510, -1, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseClicked
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);

        String estudianteBuscar = this.buscarFd.getText().trim();
        if (this.asignaturasCb.getSelectedIndex() == 0) {
            List<Integer> materias = this.usuarioMateriaDao.materiasByProfesor(this.profesorId);
            for (Integer m : materias) {
                Materia materia = this.materiaDao.materiaByMateriaId(m);
                Curso curso = this.cursoDao.obtenerCurso(materia.getCursoId());
                List<Usuario> estudiantes = this.usuarioDao.estudiantesEnMateriaByName(m, estudianteBuscar);
                for (Usuario e : estudiantes) {
                    List<UsuarioMateriaTarea> usuariosMateriasTareas = this.usuarioMateriaTareaDao.tareasByMatUsuId(materia.getId(), e.getId());
                    for (UsuarioMateriaTarea umt : usuariosMateriasTareas) {
                        Tarea t = this.tareaDao.tareaBytareaId(umt.getTareaId());
                        model.addRow(new Object[]{e.getNombre() + " " + e.getApellido(), e.getEmail(), materia.getMateria(), curso.getCurso(), umt.getEnvio(), t.getTarea(), umt.getNota()});
                    }
                }
            }
        } else {
            int materiaId = this.materiasId.get(this.asignaturasCb.getSelectedIndex());
            Materia materia = this.materiaDao.materiaByMateriaId(materiaId);
            Curso curso = this.cursoDao.obtenerCurso(materia.getCursoId());

            List<Usuario> estudiantes = this.usuarioDao.estudiantesEnMateriaByName(materiaId, estudianteBuscar);
            for (Usuario e : estudiantes) {
                List<UsuarioMateriaTarea> usuariosMateriasTareas = this.usuarioMateriaTareaDao.tareasByMatUsuId(materia.getId(), e.getId());
                for (UsuarioMateriaTarea umt : usuariosMateriasTareas) {
                    Tarea t = this.tareaDao.tareaBytareaId(umt.getTareaId());
                    model.addRow(new Object[]{e.getNombre() + " " + e.getApellido(), e.getEmail(), materia.getMateria(), curso.getCurso(), umt.getEnvio(), t.getTarea(), umt.getNota()});
                }
            }
        }

    }//GEN-LAST:event_buscarTxtMouseClicked

    private void buscarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseEntered
        this.buscarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_buscarTxtMouseEntered

    private void buscarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseExited
        this.buscarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_buscarTxtMouseExited

    private void cambiarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarTxtMouseClicked
        if (this.infoTb.getSelectedRow() > -1) {
            String nota = JOptionPane.showInputDialog("Ingrese la calificacion");
            if (Utilidad.validarNota(nota)) {
                Double notaD = Double.valueOf(nota);
                String correo = (String) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 1);
                String materiaNombre = (String) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 2);
                String tareaNombre = (String) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 5);

                Materia materia = this.materiaDao.materiaByName(materiaNombre);
                UsuarioMateria um = this.usuarioMateriaDao.estudianteEnMateria(materia.getId(), correo);
                Tarea tarea = this.tareaDao.tareaByName(tareaNombre);

                UsuarioMateriaTarea umt = this.usuarioMateriaTareaDao.tareaByTareaUsuario(tarea.getId(), um.getId());
                umt.setNota(notaD);
                this.usuarioMateriaTareaDao.actualizar(umt);
                this.listarEstudiantesTareas();
            } else {
                JOptionPane.showMessageDialog(null, "Nota incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione estudiante a calificar");
        }
    }//GEN-LAST:event_cambiarTxtMouseClicked

    private void cambiarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarTxtMouseEntered
        this.cambiarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_cambiarTxtMouseEntered

    private void cambiarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarTxtMouseExited
        this.cambiarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_cambiarTxtMouseExited

    private void revisarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revisarTxtMouseClicked
        if (this.infoTb.getSelectedRow() > -1) {
            String ruta = (String) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 4);
            if (ruta == null) {
                return;
            }
            File pdf = new File(ruta);
            try {
                Desktop.getDesktop().open(pdf);
            } catch (IOException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione tarea del estudiante a revisar");
        }
    }//GEN-LAST:event_revisarTxtMouseClicked

    private void revisarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revisarTxtMouseEntered
        this.revisarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_revisarTxtMouseEntered

    private void revisarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revisarTxtMouseExited
        this.revisarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_revisarTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asignaturaTxt;
    private javax.swing.JComboBox<String> asignaturasCb;
    private javax.swing.JPanel buscarBt;
    private javax.swing.JTextField buscarFd;
    private javax.swing.JLabel buscarPorTxt;
    private javax.swing.JSeparator buscarSp;
    private javax.swing.JLabel buscarTxt;
    private javax.swing.JPanel cambiarBt;
    private javax.swing.JLabel cambiarTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JScrollPane infoSc;
    private javax.swing.JTable infoTb;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel revisarBt;
    private javax.swing.JLabel revisarTxt;
    private javax.swing.JLabel revisionTxt;
    // End of variables declaration//GEN-END:variables
}
