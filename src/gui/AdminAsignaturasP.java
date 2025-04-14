package gui;

import datos.*;
import domain.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import utilities.Utilidad;

public class AdminAsignaturasP extends javax.swing.JPanel {

    private MateriaDAO materiaDao = new MateriaDAO();
    private CursoDAO cursoDao = new CursoDAO();
    private UsuarioMateriaDAO usuarioMateriaDao = new UsuarioMateriaDAO();

    private List<Integer> cursosId;
    private boolean edicion = false;

    public AdminAsignaturasP() {
        this.initComponents();
        this.listarMaterias();
        this.listarCursos(this.cursoCb1);
        this.dinamic.setVisible(false);
    }

    private void listarMaterias() {
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);
        
        List<Materia> materias = this.materiaDao.seleccionar("");       
        for (Materia m : materias) {
            String curso = this.cursoDao.obtenerNombreCurso(m.getCursoId());
            model.addRow(new Object[]{m.getId(), m.getMateria(), curso});
        }
    }

    private void listarCursos(JComboBox cb) {
        List<Curso> cursos = this.cursoDao.seleccionar("");
        
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
        
        cb.setModel(new javax.swing.DefaultComboBoxModel<>(cursosLista));
    }
    
    private boolean verificarAso(int materiaId) {
        List<Integer> asociados = this.usuarioMateriaDao.usuariosAsociados(materiaId);
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
        asignaturasTxt = new javax.swing.JLabel();
        buscarPorATxt = new javax.swing.JLabel();
        buscarAFd = new javax.swing.JTextField();
        buscarASp = new javax.swing.JSeparator();
        buscarPorCTxt = new javax.swing.JLabel();
        cursoCb1 = new javax.swing.JComboBox<>();
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
        dinamic = new javax.swing.JPanel();
        nombreTxt = new javax.swing.JLabel();
        nombreFd = new javax.swing.JTextField();
        nombreSp = new javax.swing.JSeparator();
        cursoTxt = new javax.swing.JLabel();
        cursoCb2 = new javax.swing.JComboBox<>();
        hacerBt = new javax.swing.JPanel();
        hacerTxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setPreferredSize(new java.awt.Dimension(1280, 560));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        asignaturasTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        asignaturasTxt.setForeground(new java.awt.Color(193, 18, 31));
        asignaturasTxt.setText("Asignaturas");
        fondo.add(asignaturasTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        buscarPorATxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        buscarPorATxt.setText("Busca por Asignatura:");
        fondo.add(buscarPorATxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        buscarAFd.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        buscarAFd.setBorder(null);
        buscarAFd.setPreferredSize(new java.awt.Dimension(400, 22));
        fondo.add(buscarAFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, 20));

        buscarASp.setPreferredSize(new java.awt.Dimension(400, 10));
        fondo.add(buscarASp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, 10));

        buscarPorCTxt.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        buscarPorCTxt.setText("Busca por Curso:");
        fondo.add(buscarPorCTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        cursoCb1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        cursoCb1.setPreferredSize(new java.awt.Dimension(150, 22));
        fondo.add(cursoCb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 320, -1));

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

        fondo.add(buscarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        infoTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            infoTb.getColumnModel().getColumn(0).setMinWidth(80);
            infoTb.getColumnModel().getColumn(0).setPreferredWidth(80);
            infoTb.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        fondo.add(infoSc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 510, 290));

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

        fondo.add(crearBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

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

        fondo.add(modiBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, -1, -1));

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

        fondo.add(eliminarBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, -1, -1));

        dinamic.setBackground(new java.awt.Color(255, 255, 255));
        dinamic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        nombreTxt.setText("Nombre");
        dinamic.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        nombreFd.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        nombreFd.setBorder(null);
        nombreFd.setPreferredSize(new java.awt.Dimension(350, 20));
        dinamic.add(nombreFd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 20));

        nombreSp.setPreferredSize(new java.awt.Dimension(350, 10));
        dinamic.add(nombreSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        cursoTxt.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        cursoTxt.setText("Curso");
        dinamic.add(cursoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        cursoCb2.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        cursoCb2.setPreferredSize(new java.awt.Dimension(350, 22));
        dinamic.add(cursoCb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        hacerBt.setBackground(new java.awt.Color(253, 240, 213));
        hacerBt.setPreferredSize(new java.awt.Dimension(150, 40));

        hacerTxt.setFont(new java.awt.Font("Lucida Bright", 0, 16)); // NOI18N
        hacerTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hacerTxt.setText("Registrar");
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

        dinamic.add(hacerBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        fondo.add(dinamic, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 590, 560));

        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void crearTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearTxtMouseClicked
        this.edicion = false;
        this.nombreFd.setText("");
        this.hacerTxt.setText("Registrar");
        this.listarCursos(this.cursoCb2);
        this.cursoCb2.removeItemAt(0);
        this.dinamic.setVisible(true);
    }//GEN-LAST:event_crearTxtMouseClicked

    private void crearTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearTxtMouseEntered
        this.crearBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_crearTxtMouseEntered

    private void crearTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearTxtMouseExited
        this.crearBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_crearTxtMouseExited

    private void modiTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiTxtMouseClicked
        if (this.infoTb.getSelectedRow() > -1) {
            this.dinamic.setVisible(true);
            this.edicion = true;
            this.hacerTxt.setText("Guardar");
            int materiaId = (int) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 0);
            Materia m = this.materiaDao.obtenerMateria(materiaId);
            this.nombreFd.setText(m.getMateria());
            this.listarCursos(this.cursoCb2);
            this.cursoCb2.removeItemAt(0);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione asignatura a editar");
        }
    }//GEN-LAST:event_modiTxtMouseClicked

    private void modiTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiTxtMouseEntered
        this.modiBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_modiTxtMouseEntered

    private void modiTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modiTxtMouseExited
        this.modiBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_modiTxtMouseExited

    private void eliminarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTxtMouseClicked
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        
        if (this.infoTb.getSelectedRow() > -1) {
            int materiaId = (int) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 0);   
            if (!this.verificarAso(materiaId)) {
                this.materiaDao.eliminar(materiaId);
                JOptionPane.showMessageDialog(null, "Materia eliminada");
                model.removeRow(this.infoTb.getSelectedRow());
                this.dinamic.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Existen registros asociados en esta asignatura");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione asignatura a eliminar");
        }
    }//GEN-LAST:event_eliminarTxtMouseClicked

    private void eliminarTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTxtMouseEntered
        this.eliminarBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_eliminarTxtMouseEntered

    private void eliminarTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarTxtMouseExited
        this.eliminarBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_eliminarTxtMouseExited

    private void hacerTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseClicked
        String materiaNombre = this.nombreFd.getText().trim();
        int cursoId = this.cursosId.get(this.cursoCb2.getSelectedIndex() + 1);
        
        if (materiaNombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo");
            this.nombreFd.requestFocus();
            return;
        }
        if (materiaNombre.length() > 200) {
            JOptionPane.showMessageDialog(null, "Longitud maxima de caracteres en materia: 200");
            this.nombreFd.requestFocus();
            return;
        }
        if (!Utilidad.validarMateriaCurso(materiaNombre)) {
            JOptionPane.showMessageDialog(null, "Materia incorrecto");
            this.nombreFd.requestFocus();
            return;
        } else {
            materiaNombre = Utilidad.toMayuscula(materiaNombre).trim();
        }
        
        Materia materia = this.edicion ? this.materiaDao.obtenerMateria((int) this.infoTb.getValueAt(this.infoTb.getSelectedRow(), 0)) : new Materia();    
        materia.setMateria(materiaNombre);
        materia.setCursoId(cursoId);
        
        List<Materia> materias = this.materiaDao.seleccionar("");
        if (!this.edicion) { 
            for (Materia m : materias) {
                if (materiaNombre.equals(m.getMateria()) && cursoId == m.getCursoId()) {
                    JOptionPane.showMessageDialog(null, "La materia ya esta asignada a ese curso");
                    this.nombreFd.requestFocus();
                    return;
                }
            }        
            this.materiaDao.insertar(materia);
        } else {
            for (Materia m : materias) {
                if (materia.getId() == m.getId()) {
                    continue;
                }
                if (materiaNombre.equals(m.getMateria()) && cursoId == m.getCursoId()) {
                    JOptionPane.showMessageDialog(null, "La materia ya esta asignada a ese curso");
                    this.nombreFd.requestFocus();
                    return;
                }
            }           
            this.materiaDao.actualizar(materia);          
        }
        
        String mensaje = this.edicion ? "modificado" : "registrado";
        JOptionPane.showMessageDialog(null, "Materia " + mensaje + " exitosamente");
        
        this.listarMaterias();
        this.dinamic.setVisible(false);        
    }//GEN-LAST:event_hacerTxtMouseClicked

    private void hacerTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseEntered
        this.hacerBt.setBackground(new Color(252, 230, 182));
    }//GEN-LAST:event_hacerTxtMouseEntered

    private void hacerTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerTxtMouseExited
        this.hacerBt.setBackground(new Color(253, 240, 213));
    }//GEN-LAST:event_hacerTxtMouseExited

    private void buscarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarTxtMouseClicked
        DefaultTableModel model = (DefaultTableModel) this.infoTb.getModel();
        model.setRowCount(0);
        
        String materiaBuscar = this.buscarAFd.getText().trim();     
        if (this.cursoCb1.getSelectedIndex() == 0) {
            List<Materia> materias = this.materiaDao.listarMatByName(materiaBuscar);
            for (Materia m : materias) {
                model.addRow(new Object[]{m.getId(), m.getMateria(), this.cursoDao.obtenerNombreCurso(m.getCursoId())});
            }
        } else {
            int cursoId = this.cursosId.get(this.cursoCb1.getSelectedIndex());
            List<Materia> materias = this.materiaDao.seleccionarByNameCurso(cursoId, materiaBuscar);
            for (Materia m : materias) {
                model.addRow(new Object[]{m.getId(), m.getMateria(), this.cursoDao.obtenerNombreCurso(m.getCursoId())});
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
    private javax.swing.JLabel asignaturasTxt;
    private javax.swing.JTextField buscarAFd;
    private javax.swing.JSeparator buscarASp;
    private javax.swing.JPanel buscarBt;
    private javax.swing.JLabel buscarPorATxt;
    private javax.swing.JLabel buscarPorCTxt;
    private javax.swing.JLabel buscarTxt;
    private javax.swing.JPanel crearBt;
    private javax.swing.JLabel crearTxt;
    private javax.swing.JComboBox<String> cursoCb1;
    private javax.swing.JComboBox<String> cursoCb2;
    private javax.swing.JLabel cursoTxt;
    private javax.swing.JPanel dinamic;
    private javax.swing.JPanel eliminarBt;
    private javax.swing.JLabel eliminarTxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel hacerBt;
    private javax.swing.JLabel hacerTxt;
    private javax.swing.JScrollPane infoSc;
    private javax.swing.JTable infoTb;
    private javax.swing.JPanel modiBt;
    private javax.swing.JLabel modiTxt;
    private javax.swing.JTextField nombreFd;
    private javax.swing.JSeparator nombreSp;
    private javax.swing.JLabel nombreTxt;
    // End of variables declaration//GEN-END:variables
}
