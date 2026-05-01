package pe.edu.uni.appeduca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.appeduca.db.AccesoDB;
import pe.edu.uni.appeduca.dto.AlumnoCursoDTO;

public class ConsultaService {

	public double getPrecioCurso(int idCurso) {
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
			if (!rs.next()) {
				rs.close();
				pstm.close();
				throw new SQLException("[ERROR] Curso no existe.");
			}
			precio = rs.getDouble("precio");
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			String msg = "[ERROR] Intentelo mas tarde.";
			throw new RuntimeException(msg);
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		// Reporte
		return precio;
	}

	public List<AlumnoCursoDTO> getMatriculados(int idCurso) {
		// Variables
		List<AlumnoCursoDTO> lista = new ArrayList<>();
		PreparedStatement pstm;
		ResultSet rs;
		String sql = """
							select m.cur_id curso, a.alu_id id, alu_nombre alumno, m.mat_nota nota
							from ALUMNO a
							join MATRICULA m on a.alu_id = m.alu_id
							where m.cur_id = ?
                       """;
		// Proceso
		try (Connection cn = AccesoDB.getConnection();){
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, idCurso);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int curso = rs.getInt("curso");
				int id = rs.getInt("id");
				String alumno = rs.getString("alumno");
				int nota = rs.getInt("nota");
				AlumnoCursoDTO dto = new AlumnoCursoDTO(curso,id,alumno,nota);
				lista.add(dto);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			String msg = "[ERROR] Intentelo mas tarde.";
			throw new RuntimeException(msg);
		} 
		// Reporte
		return lista;
	}

}
