package gui;

import datos.*;
import domain.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EstudianteCursosP extends javax.swing.JPanel {

    private int estudianteId;

    private MateriaDAO materiaDao = new MateriaDAO();
    private CursoDAO cursoDao = new CursoDAO();

    private List<Integer> cursosId;

    public EstudianteCursosP(int estudianteId) {
        this.initComponents();
        this.estudianteId = estudianteId;
        this.listarCursos();
        this.listarCursosCb();
    }

    private void listarCursos() {
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);

        List<Materia> materias = this.materiaDao.materiasByEstudiante(this.estudianteId);
        for (Materia m : materias) {
            Curso c = this.cursoDao.obtenerCurso(m.getCursoId());
            model.addRow(new Object[]{m.getMateria(), c.getCurso()});
        }

    }

    private void listarCursosCb() {
        List<Curso> cursos = this.cursoDao.cursosByEstudianteId(this.estudianteId);

        this.cursosId = new ArrayList<>();
        this.cursosId.add(0);

        List<String> cursosNombres = new ArrayList<>();
        cursosNombres.add("");

        for (Curso c : cursos) {
            this.cursosId.add(c.getId());
            cursosNombres.add(c.getCurso());
        }

        String[] cursosLista = new String[cursosNombres.size()];
        for (int i = 0; i < cursosNombres.size(); i++) {
            cursosLista[i] = cursosNombres.get(i);
        }

        this.cursosCb.setModel(new javax.swing.DefaultComboBoxModel<>(cursosLista));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        cursosTxt = new javax.swing.JLabel();
        cursoTxt = new javax.swing.JLabel();
        cursosCb = new javax.swing.JComboBox<>();
        buscarBt = new javax.swing.JPanel();
        buscarTxt = new javax.swing.JLabel();
        infoSp = new javax.swing.JScrollPane();
        infoTb = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cursosTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        cursosTxt.setForeground(new java.awt.Color(193, 18, 31));
        cursosTxt.setText("Cursos");
        fondo.add(cursosTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        cursoTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        cursoTxt.setText("Buscar por curso:");
        fondo.add(cursoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        cursosCb.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        cursosCb.setPreferredSize(new java.awt.Dimension(350, 22));
        fondo.add(cursosCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

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

        fondo.add(buscarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, -1, -1));

        infoTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materia", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infoSp.setViewportView(infoTb);

        fondo.add(infoSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 1010, 400));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseClicked
        if (this.cursosCb.getSelectedIndex() == 0) {
            this.listarCursos();
        } else {
            DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
            model.setRowCount(0);
            
            int cursoId = this.cursosId.get(this.cursosCb.getSelectedIndex());
            List<Materia> materias = this.materiaDao.materiasByEstudiante(cursoId, this.estudianteId);
            for (Materia m : materias) {
                Curso c = this.cursoDao.obtenerCurso(m.getCursoId());
                model.addRow(new Object[]{m.getMateria(), c.getCurso()});
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
    private javax.swing.JPanel buscarBt;
    private javax.swing.JLabel buscarTxt;
    private javax.swing.JLabel cursoTxt;
    private javax.swing.JComboBox<String> cursosCb;
    private javax.swing.JLabel cursosTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JScrollPane infoSp;
    private javax.swing.JTable infoTb;
    // End of variables declaration//GEN-END:variables
}
