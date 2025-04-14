package datos;

import java.sql.*;

public class RolDAO {
          
    public String rolByUsuarioId(int usuarioId) {
        Connection conn = Conexion.connect();
        PreparedStatement pst = null;
        ResultSet rs = null;    
        String rol = "";

        try {
            pst = conn.prepareStatement("SELECT rol FROM roles WHERE id IN (SELECT rol_id FROM usuario_rol WHERE usuario_id = ?)");
            pst.setInt(1, usuarioId);
            rs = pst.executeQuery();
            while (rs.next()) {
                rol = rs.getString("rol");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return rol;
    }    
}
