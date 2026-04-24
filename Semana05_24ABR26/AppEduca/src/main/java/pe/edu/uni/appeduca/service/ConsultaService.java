package pe.edu.uni.appeduca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.appeduca.db.AccesoDB;

public class ConsultaService {
    
    public double getPrecioCurso(int idCurso){
        // Variables
        double precio = 0.0;
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        String sql = """
                       select cur_precio precio from CURSO
                       where cur_id=?
                       """;
        // Proceso
        try {
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idCurso);
            rs = pstm.executeQuery();
            if(!rs.next()){
                rs.close();
                pstm.close();
                throw new SQLException("[ERROR] Curso no existe.");
            }
            precio = rs.getDouble("precio");
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch(Exception e){
            String msg = "[ERROR] Intentelo mas tarde.";
            throw new RuntimeException(msg);
        } finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        // Reporte
        return precio;
    }
    
}
