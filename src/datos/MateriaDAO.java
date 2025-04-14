package datos;

import domain.Materia;
import java.util.*;
import java.sql.*;

public class MateriaDAO {

    public List<Materia> seleccionar(String materiaNombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Materia> materias = new ArrayList<>();
        String query = materiaNombre.isEmpty() ? "SELECT * FROM materias" : "SELECT * FROM materias WHERE materia LIKE '%" + materiaNombre + "%'";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materias;
    }

    public void insertar(Materia materia) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("INSERT INTO materias(materia, curso_id) VALUES(?, ?)");
            pst.setString(1, materia.getMateria());
            pst.setInt(2, materia.getCursoId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public void actualizar(Materia materia) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("UPDATE materias SET materia = ?, curso_id = ? WHERE id = ?");
            pst.setString(1, materia.getMateria());
            pst.setInt(2, materia.getCursoId());
            pst.setInt(3, materia.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public void eliminar(int id) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement("DELETE FROM materias WHERE id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(conn);
        }
    }

    public Materia obtenerMateria(int id) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Materia materia = new Materia();

        try {
            pst = conn.prepareStatement("SELECT * FROM materias WHERE id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materia;
    }
    
    public List<Materia> listarMatByName(String nombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Materia> materias = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM materias WHERE materia LIKE '%" + nombre + "%'");
            rs = pst.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materias;
    }
    
    
    public List<Materia> seleccionarByNameCurso(int cursoId, String nombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Materia> materias = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM materias WHERE curso_id = ? AND materia LIKE '%" + nombre + "%'");
            pst.setInt(1, cursoId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materias;
    }
    
    public List<Integer> verificarCurso(int cursoId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;       
        List<Integer> materias = new ArrayList<>();

        try {
            pst = conn.prepareStatement("SELECT id FROM materias WHERE curso_id = ?");
            pst.setInt(1, cursoId);
            rs = pst.executeQuery();
            while (rs.next()) {            
                materias.add(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materias;
    }
    
    
    public Materia materiaByMateriaId(int materiaId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;       
        Materia materia = new Materia();

        try {
            pst = conn.prepareStatement("SELECT * FROM materias WHERE id = ?");
            pst.setInt(1, materiaId);
            rs = pst.executeQuery();
            while (rs.next()) {            
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materia;
    }
    
    public Materia materiaByName(String nombre) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Materia materia = new Materia();
        try {
            pst = conn.prepareStatement("SELECT * FROM materias WHERE materia = ?");
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            while (rs.next()) {
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materia;
    }
    
    public List<Materia> materiasByEstudiante(int estudianteId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Materia> materias = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM materias WHERE id IN (SELECT materia_id FROM usuario_materia WHERE usuario_rol_id = ?)");
            pst.setInt(1, estudianteId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materias;
    }
    
    public List<Materia> materiasByEstudiante(int cursoId, int estudianteId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Materia> materias = new ArrayList<>();
        try {
            pst = conn.prepareStatement("SELECT * FROM materias WHERE curso_id = ? AND id IN (SELECT materia_id FROM usuario_materia WHERE usuario_rol_id = ?)");
            pst.setInt(1, cursoId);
            pst.setInt(2, estudianteId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materias;
    }
    
    public Materia materiaByEstudianteId(int estudianteId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;       
        Materia materia = new Materia();

        try {
            pst = conn.prepareStatement("SELECT * FROM materias WHERE id IN (SELECT materia_id FROM usuario_materia WHERE id IN (SELECT usuario_materia_id FROM usuario_materia_tarea WHERE usuario_materia_id = ?))");
            pst.setInt(1, estudianteId);
            rs = pst.executeQuery();
            while (rs.next()) {            
                materia.setId(rs.getInt("id"));
                materia.setMateria(rs.getString("materia"));
                materia.setCursoId(rs.getInt("curso_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return materia;
    }
}
