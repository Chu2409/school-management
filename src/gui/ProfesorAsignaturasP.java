package gui;

import datos.*;
import domain.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProfesorAsignaturasP extends javax.swing.JPanel {

    private int profesorId;
    
    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private UsuarioMateriaDAO usuarioMateriaDao = new UsuarioMateriaDAO();
    private MateriaDAO materiaDao = new MateriaDAO();
    private CursoDAO cursoDao = new CursoDAO();
    
    private List<Integer> materiasId;

    public ProfesorAsignaturasP(int profesorId) {
        this.initComponents();
        this.profesorId = profesorId;
        this.listarEstudiantes();
        this.listarMaterias();

    }

    private void listarEstudiantes() {
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);
        
        List<Integer> materias = this.usuarioMateriaDao.materiasByProfesor(this.profesorId);
        for (Integer m : materias) {
            Materia materia = this.materiaDao.materiaByMateriaId(m);
            Curso curso = this.cursoDao.obtenerCurso(materia.getCursoId());
            List<Usuario> estudiantes = this.usuarioDao.estudiantesEnMateria(m);
            for (Usuario e : estudiantes) {
                model.addRow(new Object[]{e.getNombre() + " " + e.getApellido(), e.getCedula(), e.getEmail(), materia.getMateria(), curso.getCurso()});
            }
        }
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
        asignaturasTxt = new javax.swing.JLabel();
        buscarPorTxt = new javax.swing.JLabel();
        buscarFd = new javax.swing.JTextField();
        buscarSp = new javax.swing.JSeparator();
        asignaturaTxt = new javax.swing.JLabel();
        asignaturasCb = new javax.swing.JComboBox<>();
        buscarBt = new javax.swing.JPanel();
        buscarTxt = new javax.swing.JLabel();
        infoSc = new javax.swing.JScrollPane();
        infoTb = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asignaturasTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        asignaturasTxt.setForeground(new java.awt.Color(193, 18, 31));
        asignaturasTxt.setText("Asignaturas");
        fondo.add(asignaturasTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

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

        infoTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estudiante", "Cedula", "Correo", "Asignatura", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            infoTb.getColumnModel().getColumn(1).setMinWidth(150);
            infoTb.getColumnModel().getColumn(1).setPreferredWidth(150);
            infoTb.getColumnModel().getColumn(1).setMaxWidth(150);
            infoTb.getColumnModel().getColumn(2).setMinWidth(250);
            infoTb.getColumnModel().getColumn(2).setPreferredWidth(250);
            infoTb.getColumnModel().getColumn(2).setMaxWidth(250);
            infoTb.getColumnModel().getColumn(3).setMinWidth(250);
            infoTb.getColumnModel().getColumn(3).setPreferredWidth(250);
            infoTb.getColumnModel().getColumn(3).setMaxWidth(250);
            infoTb.getColumnModel().getColumn(4).setMinWidth(250);
            infoTb.getColumnModel().getColumn(4).setPreferredWidth(250);
            infoTb.getColumnModel().getColumn(4).setMaxWidth(250);
        }

        fondo.add(infoSc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1240, -1));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 560));
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
                    model.addRow(new Object[]{e.getNombre() + " " + e.getApellido(), e.getCedula(), e.getEmail(), materia.getMateria(), curso.getCurso()});
                }
            }
        } else {
            int materiaId = this.materiasId.get(this.asignaturasCb.getSelectedIndex());
            Materia materia = this.materiaDao.materiaByMateriaId(materiaId);
            Curso curso = this.cursoDao.obtenerCurso(materia.getCursoId());
            List<Usuario> estudiantes = this.usuarioDao.estudiantesEnMateriaByName(materiaId, estudianteBuscar);
            for (Usuario e : estudiantes) {
                model.addRow(new Object[]{e.getNombre() + " " + e.getApellido(), e.getCedula(), e.getEmail(), materia.getMateria(), curso.getCurso()});
            }
        }
    }//GEN-LAST:event_buscarTxtMouseClicked

    private void buscarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseEntered
        this.buscarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_buscarTxtMouseEntered

    private void buscarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseExited
        this.buscarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_buscarTxtMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asignaturaTxt;
    private javax.swing.JComboBox<String> asignaturasCb;
    private javax.swing.JLabel asignaturasTxt;
    private javax.swing.JPanel buscarBt;
    private javax.swing.JTextField buscarFd;
    private javax.swing.JLabel buscarPorTxt;
    private javax.swing.JSeparator buscarSp;
    private javax.swing.JLabel buscarTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JScrollPane infoSc;
    private javax.swing.JTable infoTb;
    // End of variables declaration//GEN-END:variables
}
