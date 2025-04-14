package gui;

import datos.*;
import domain.*;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import utilities.Utilidad;

public class ProfesorAsignacionP extends javax.swing.JPanel {

    private int profesorId;

    private MateriaDAO materiaDao = new MateriaDAO();
    private UsuarioMateriaDAO usuarioMateriaDao = new UsuarioMateriaDAO();
    private UsuarioMateriaTareaDAO usuarioMateriaTareaDao = new UsuarioMateriaTareaDAO();
    private TareaDAO tareaDao = new TareaDAO();

    private List<Integer> materiasId;

    private String archivoRuta = null;

    public ProfesorAsignacionP(int profesorId) {
        this.initComponents();
        this.profesorId = profesorId;
        this.listarMaterias();
    }

    private void listarMaterias() {
        List<Integer> materias = this.usuarioMateriaDao.materiasByProfesor(this.profesorId);

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

        fondo = new javax.swing.JPanel();
        asignacionTxt = new javax.swing.JLabel();
        asignaturaTxt = new javax.swing.JLabel();
        asignaturasCb = new javax.swing.JComboBox<>();
        nombreTxt = new javax.swing.JLabel();
        nombreFd = new javax.swing.JTextField();
        nombreSp = new javax.swing.JSeparator();
        descripcionTxt1 = new javax.swing.JLabel();
        descripcionSp = new javax.swing.JScrollPane();
        descripcionTa = new javax.swing.JTextArea();
        archivoTxt = new javax.swing.JLabel();
        archivoSp = new javax.swing.JScrollPane();
        archivoTa = new javax.swing.JTextArea();
        cargarBt = new javax.swing.JPanel();
        cargarTxt = new javax.swing.JLabel();
        asignarBt = new javax.swing.JPanel();
        asignarTxt = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asignacionTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        asignacionTxt.setForeground(new java.awt.Color(193, 18, 31));
        asignacionTxt.setText("Asignación");
        fondo.add(asignacionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        asignaturaTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        asignaturaTxt.setText("Escoga la asignatura:");
        fondo.add(asignaturaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        asignaturasCb.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        asignaturasCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Estudiante", "Profesor" }));
        asignaturasCb.setToolTipText("");
        asignaturasCb.setPreferredSize(new java.awt.Dimension(150, 22));
        fondo.add(asignaturasCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 290, -1));

        nombreTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        nombreTxt.setText("Nombre de la asignación:");
        fondo.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        nombreFd.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        nombreFd.setBorder(null);
        nombreFd.setPreferredSize(new java.awt.Dimension(400, 22));
        fondo.add(nombreFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, -1, 20));

        nombreSp.setPreferredSize(new java.awt.Dimension(400, 10));
        fondo.add(nombreSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, -1, 10));

        descripcionTxt1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        descripcionTxt1.setText("Descripción:");
        fondo.add(descripcionTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        descripcionTa.setColumns(20);
        descripcionTa.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        descripcionTa.setLineWrap(true);
        descripcionTa.setRows(5);
        descripcionSp.setViewportView(descripcionTa);

        fondo.add(descripcionSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 510, 230));

        archivoTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        archivoTxt.setText("Archivo");
        fondo.add(archivoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, -1, -1));

        archivoTa.setEditable(false);
        archivoTa.setBackground(new java.awt.Color(255, 255, 255));
        archivoTa.setColumns(20);
        archivoTa.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        archivoTa.setLineWrap(true);
        archivoTa.setRows(5);
        archivoSp.setViewportView(archivoTa);

        fondo.add(archivoSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 510, 150));

        cargarBt.setBackground(new java.awt.Color(253, 240, 213));
        cargarBt.setPreferredSize(new java.awt.Dimension(200, 40));

        cargarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        cargarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cargarTxt.setText("Cargar");
        cargarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarTxt.setPreferredSize(new java.awt.Dimension(200, 40));
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

        fondo.add(cargarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 380, -1, -1));

        asignarBt.setBackground(new java.awt.Color(253, 240, 213));
        asignarBt.setPreferredSize(new java.awt.Dimension(200, 40));

        asignarTxt.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        asignarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignarTxt.setText("Asignar");
        asignarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        asignarTxt.setPreferredSize(new java.awt.Dimension(200, 40));
        asignarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignarTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asignarTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asignarTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout asignarBtLayout = new javax.swing.GroupLayout(asignarBt);
        asignarBt.setLayout(asignarBtLayout);
        asignarBtLayout.setHorizontalGroup(
            asignarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignarBtLayout.createSequentialGroup()
                .addComponent(asignarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        asignarBtLayout.setVerticalGroup(
            asignarBtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asignarBtLayout.createSequentialGroup()
                .addComponent(asignarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        fondo.add(asignarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 480, -1, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cargarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarTxtMouseClicked
        JFileChooser fc = new JFileChooser("C:/Users/Daniel/Desktop");
        fc.setMultiSelectionEnabled(false);
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.pdf", "pdf");
        fc.setFileFilter(filtro);
        int seleccion = fc.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            this.archivoTa.setText(archivo.getName());
            this.archivoRuta = archivo.getAbsolutePath();
        }
    }//GEN-LAST:event_cargarTxtMouseClicked

    private void cargarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarTxtMouseEntered
        this.cargarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_cargarTxtMouseEntered

    private void cargarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarTxtMouseExited
        this.cargarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_cargarTxtMouseExited

    private void asignarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarTxtMouseClicked
        int materiaId = this.materiasId.get(this.asignaturasCb.getSelectedIndex());
        String nombre = this.nombreFd.getText().trim();
        String descripcion = this.descripcionTa.getText().trim();

        if (materiaId == 0 || nombre.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            return;
        }
        if (nombre.length() > 200) {
            JOptionPane.showMessageDialog(null, "Longitud maxima de caracteres en asignacion: 200");
            this.nombreFd.requestFocus();
            return;
        }
        if (descripcion.length() > 255) {
            JOptionPane.showMessageDialog(null, "Longitud maxima de caracteres en descripcion: 255");
            this.descripcionTa.requestFocus();
            return;
        }
        if (nombre.contains("\"") || nombre.contains("\'")) {
            JOptionPane.showMessageDialog(null, "Nombre incorrecto");
            this.nombreFd.requestFocus();
            return;
        }
        if (descripcion.contains("\"") || descripcion.contains("\'")) {
            JOptionPane.showMessageDialog(null, "Descripcion incorrecto");
            this.descripcionTa.requestFocus();
            return;
        }

        nombre = Utilidad.toMayuscula(nombre).trim();

        Tarea tarea = new Tarea();
        tarea.setTarea(nombre);
        tarea.setDescripcion(descripcion);
        tarea.setUbicacion(this.archivoRuta);

        List<Tarea> tareas = this.tareaDao.seleccionar();
        for (Tarea t : tareas) {
            if (nombre.equals(t.getTarea())) {
                JOptionPane.showMessageDialog(null, "Ya existe registro de esta tarea");
                this.nombreFd.requestFocus();
                return;
            }
        }
        this.tareaDao.insertar(tarea);

        List<Integer> estudiantes = this.usuarioMateriaDao.estudiantesIdByMateria(materiaId);
        for (Integer e : estudiantes) {
            UsuarioMateriaTarea umt = new UsuarioMateriaTarea();
            umt.setTareaId(this.tareaDao.obtenerUltimo());
            umt.setUsuarioMateriaId(e);
            this.usuarioMateriaTareaDao.insertar(umt);
        }

        JOptionPane.showMessageDialog(null, "Tarea asignada correctamente");

        this.asignaturasCb.setSelectedIndex(0);
        this.nombreFd.setText("");
        this.descripcionTa.setText("");
        this.archivoTa.setText("");

    }//GEN-LAST:event_asignarTxtMouseClicked

    private void asignarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarTxtMouseEntered
        this.asignarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_asignarTxtMouseEntered

    private void asignarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignarTxtMouseExited
        this.asignarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_asignarTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane archivoSp;
    private javax.swing.JTextArea archivoTa;
    private javax.swing.JLabel archivoTxt;
    private javax.swing.JLabel asignacionTxt;
    private javax.swing.JPanel asignarBt;
    private javax.swing.JLabel asignarTxt;
    private javax.swing.JLabel asignaturaTxt;
    private javax.swing.JComboBox<String> asignaturasCb;
    private javax.swing.JPanel cargarBt;
    private javax.swing.JLabel cargarTxt;
    private javax.swing.JScrollPane descripcionSp;
    private javax.swing.JTextArea descripcionTa;
    private javax.swing.JLabel descripcionTxt1;
    private javax.swing.JPanel fondo;
    private javax.swing.JTextField nombreFd;
    private javax.swing.JSeparator nombreSp;
    private javax.swing.JLabel nombreTxt;
    // End of variables declaration//GEN-END:variables
}
