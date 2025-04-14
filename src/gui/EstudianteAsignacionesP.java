package gui;

import datos.*;
import domain.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class EstudianteAsignacionesP extends javax.swing.JPanel {

    private int estudianteId;

    private UsuarioMateriaTareaDAO usuarioMateriaTareaDao = new UsuarioMateriaTareaDAO();
    private TareaDAO tareaDao = new TareaDAO();
    private MateriaDAO materiaDao = new MateriaDAO();
    private CursoDAO cursoDao = new CursoDAO();
    private UsuarioMateriaDAO usuarioMateriaDao = new UsuarioMateriaDAO();

    private List<Integer> materiasId;

    public EstudianteAsignacionesP(int estudianteId) {
        this.initComponents();
        this.estudianteId = estudianteId;
        this.listarAsignaciones();
        this.listarAsignaturas();
    }

    private void listarAsignaciones() {
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);

        List<UsuarioMateriaTarea> tareas = this.usuarioMateriaTareaDao.tareasByEstudianteId(this.estudianteId);
        for (UsuarioMateriaTarea umt : tareas) {
            Tarea t = this.tareaDao.tareaBytareaId(umt.getTareaId());
            Materia m = this.materiaDao.materiaByEstudianteId(umt.getUsuarioMateriaId());
            Curso c = this.cursoDao.obtenerCurso(m.getCursoId());
            model.addRow(new Object[]{m.getMateria(), t.getTarea(), t.getUbicacion(), t.getDescripcion(), umt.getEnvio(), umt.getNota()});
        }
    }

    private void listarAsignaturas() {
        List<Materia> materias = this.materiaDao.materiasByEstudiante(this.estudianteId);

        this.materiasId = new ArrayList<>();
        this.materiasId.add(0);

        List<String> materiasNombres = new ArrayList<>();
        materiasNombres.add("");

        for (Materia m : materias) {
            this.materiasId.add(m.getId());
            materiasNombres.add(m.getMateria());
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

        fondo = new javax.swing.JPanel();
        asignacionesTxt = new javax.swing.JLabel();
        infoSp = new javax.swing.JScrollPane();
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
        cargarBt = new javax.swing.JPanel();
        cargarTxt = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asignacionesTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        asignacionesTxt.setForeground(new java.awt.Color(193, 18, 31));
        asignacionesTxt.setText("Asignaciones");
        fondo.add(asignacionesTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        infoTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asignatura", "Tarea", "Archivo", "Descripcion", "Envío", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infoSp.setViewportView(infoTb);
        if (infoTb.getColumnModel().getColumnCount() > 0) {
            infoTb.getColumnModel().getColumn(5).setMinWidth(60);
            infoTb.getColumnModel().getColumn(5).setPreferredWidth(60);
            infoTb.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        fondo.add(infoSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1240, 400));

        buscarPorTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        buscarPorTxt.setText("Busca por tarea:");
        fondo.add(buscarPorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        buscarFd.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        buscarFd.setBorder(null);
        buscarFd.setPreferredSize(new java.awt.Dimension(400, 22));
        fondo.add(buscarFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, 20));

        buscarSp.setPreferredSize(new java.awt.Dimension(400, 10));
        fondo.add(buscarSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, 10));

        asignaturaTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        asignaturaTxt.setText("Busca por Asignatura:");
        fondo.add(asignaturaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));

        asignaturasCb.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        asignaturasCb.setToolTipText("");
        asignaturasCb.setPreferredSize(new java.awt.Dimension(150, 22));
        fondo.add(asignaturasCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 230, -1));

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

        fondo.add(buscarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, -1, -1));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, revisarBtLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(revisarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fondo.add(revisarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 510, -1, -1));

        cargarBt.setBackground(new java.awt.Color(253, 240, 213));
        cargarBt.setPreferredSize(new java.awt.Dimension(150, 40));

        cargarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        cargarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cargarTxt.setText("Cargar");
        cargarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarTxt.setPreferredSize(new java.awt.Dimension(150, 40));
        cargarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cargarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cargarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout cargarBtLayout = new javax.swing.GroupLayout(cargarBt);
        cargarBt.setLayout(cargarBtLayout);
        cargarBtLayout.setHorizontalGroup(
            cargarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargarBtLayout.createSequentialGroup()
                .addComponent(cargarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cargarBtLayout.setVerticalGroup(
            cargarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargarBtLayout.createSequentialGroup()
                .addComponent(cargarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(cargarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 510, -1, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseClicked
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);

        String tareaBuscar = this.buscarFd.getText().trim();
        if (this.asignaturasCb.getSelectedIndex() == 0) {
            List<UsuarioMateriaTarea> tareas = this.usuarioMateriaTareaDao.tareasByEstudianteIdNombre(tareaBuscar, this.estudianteId);
            for (UsuarioMateriaTarea umt : tareas) {
                Tarea t = this.tareaDao.tareaBytareaId(umt.getTareaId());
                Materia m = this.materiaDao.materiaByEstudianteId(umt.getUsuarioMateriaId());
                Curso c = this.cursoDao.obtenerCurso(m.getCursoId());
                model.addRow(new Object[]{m.getMateria(), t.getTarea(), t.getUbicacion(), t.getDescripcion(), umt.getEnvio(), umt.getNota()});
            }
        } else {
            int materiaId = this.materiasId.get(this.asignaturasCb.getSelectedIndex());
            List<UsuarioMateriaTarea> tareas = this.usuarioMateriaTareaDao.tareasByEstudianteIdNombre(tareaBuscar, this.estudianteId);
            for (UsuarioMateriaTarea umt : tareas) {
                Tarea t = this.tareaDao.tareaBytareaId(umt.getTareaId());
                Materia m = this.materiaDao.materiaByEstudianteId(umt.getUsuarioMateriaId());
                if (m.getId() == materiaId) {
                    Curso c = this.cursoDao.obtenerCurso(m.getCursoId());
                    model.addRow(new Object[]{m.getMateria(), t.getTarea(), t.getUbicacion(), t.getDescripcion(), umt.getEnvio(), umt.getNota()});
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

    private void cargarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarTxtMouseClicked
        if (this.infoTb.getSelectedRow() > -1) {
            JFileChooser fc = new JFileChooser("C:/Users/Daniel/Desktop");
            fc.setMultiSelectionEnabled(false);
            
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.pdf", "pdf");
            fc.setFileFilter(filtro);
            int seleccion = fc.showOpenDialog(null);

            String ruta = (String) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 4);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fc.getSelectedFile();
                ruta = archivo.getAbsolutePath();
            }
            
            String materiaNombre = (String) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 0);
            Materia m = this.materiaDao.materiaByName(materiaNombre);
            
            String tareaNombre = (String) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 1);
            Tarea t = this.tareaDao.tareaByName(tareaNombre);
            
            UsuarioMateria um = this.usuarioMateriaDao.estudianteByMateriaEstudiante(m.getId(), this.estudianteId);
            
            UsuarioMateriaTarea umt = this.usuarioMateriaTareaDao.tareaByTareaUsuario(t.getId(), um.getId());
            
            umt.setEnvio(ruta);
            this.usuarioMateriaTareaDao.actualizar(umt);
            this.listarAsignaciones();       
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione tarea a subir");
        }
    }//GEN-LAST:event_cargarTxtMouseClicked

    private void cargarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarTxtMouseEntered
        this.cargarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_cargarTxtMouseEntered

    private void cargarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarTxtMouseExited
        this.cargarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_cargarTxtMouseExited

    private void revisarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revisarTxtMouseClicked
        if (this.infoTb.getSelectedRow() > -1) {
            String ruta = (String) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 2);
            if (ruta == null) {
                return;
            }
            File pdf = new File(ruta);
            try {
                Desktop.getDesktop().open(pdf);
            } catch (IOException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione tarea a revisar");
        }
    }//GEN-LAST:event_revisarTxtMouseClicked

    private void revisarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revisarTxtMouseEntered
        this.revisarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_revisarTxtMouseEntered

    private void revisarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revisarTxtMouseExited
        this.revisarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_revisarTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asignacionesTxt;
    private javax.swing.JLabel asignaturaTxt;
    private javax.swing.JComboBox<String> asignaturasCb;
    private javax.swing.JPanel buscarBt;
    private javax.swing.JTextField buscarFd;
    private javax.swing.JLabel buscarPorTxt;
    private javax.swing.JSeparator buscarSp;
    private javax.swing.JLabel buscarTxt;
    private javax.swing.JPanel cargarBt;
    private javax.swing.JLabel cargarTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JScrollPane infoSp;
    private javax.swing.JTable infoTb;
    private javax.swing.JPanel revisarBt;
    private javax.swing.JLabel revisarTxt;
    // End of variables declaration//GEN-END:variables
}
