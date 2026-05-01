package pe.edu.uni.appeduca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.appeduca.db.AccesoDB;
import pe.edu.uni.appeduca.dto.MatriculaDto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class NegocioService {

	public void registrarMatricula(MatriculaDto bean) {
		PreparedStatement pstm;
		ResultSet rs;
		String sql;
		int cont, filas;
		try (Connection cn = AccesoDB.getConnection()) {
			// INICIO
			cn.setAutoCommit(false); // Inicio de Tx
			try {
				// VALIDACIONES
				// Validar tipo de matricula
				bean.setTipo(bean.getTipo().toUpperCase());
				String tipos = "REGULAR,BECA,MEDIABECA";
				if (tipos.indexOf(bean.getTipo(), 0) == -1) {
					throw new SQLException("[ERROR] Tipo de matricula incorrecto.");
				}
				// Validar cantidad de cuotas
				if (bean.getCuotas() < 1 || bean.getCuotas() > 3) {
					throw new SQLException("[ERROR] Cantidad de cuotas incorrecta.");
				}
				if ("BECA,MEDIABECA".contains(bean.getTipo()) && bean.getCuotas() != 1) {
					throw new SQLException("[ERROR] Cantidad de cuotas incorrecta.");
				}
				// Validar si ya esta matriculado
				sql = "select count(1) cont from MATRICULA where cur_id=? and alu_id=?";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(1, bean.getIdCurso());
				pstm.setInt(2, bean.getIdAlumno());
				rs = pstm.executeQuery();
				rs.next();
				cont = rs.getInt("cont");
				rs.close();
				pstm.close();
				if (cont == 1) {
					throw new SQLException("[ERROR] Alumno ya se encuentra matriculado en el curso.");
				}
				// Validar curso
				sql = """
					select count(1) cont from CURSO
					where cur_id=? and (cur_vacantes - cur_matriculados) > 0
				""";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(1, bean.getIdCurso());
				rs = pstm.executeQuery();
				rs.next();
				cont = rs.getInt("cont");
				rs.close();
				pstm.close();
				if (cont == 0) {
					throw new SQLException("[ERROR] No hay vacantes o curso no existe.");
				}
				// Validar alumno
				sql = "select count(1) cont from ALUMNO where alu_id=?";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(1, bean.getIdAlumno());
				rs = pstm.executeQuery();
				rs.next();
				cont = rs.getInt("cont");
				rs.close();
				pstm.close();
				if (cont == 0) {
					throw new SQLException("[ERROR] Alumno no existe.");
				}
				// Validar empleado
				sql = "select count(1) cont from EMPLEADO 	where emp_id=?";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(1, bean.getIdEmpleado());
				rs = pstm.executeQuery();
				rs.next();
				cont = rs.getInt("cont");
				rs.close();
				pstm.close();
				if (cont == 0) {
					throw new SQLException("[ERROR] Empleado no existe.");
				}
				// OPERACIONES
				// Actualizar curso
				sql = """
					Update CURSO
					set cur_matriculados = cur_matriculados + 1
					where cur_id=?
				""";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(1, bean.getIdCurso());
				filas = pstm.executeUpdate();
				pstm.close();
				if (filas == 0) {
					throw new SQLException("[ERROR] Curso no existe.");
				}
				// Obtener precio del curso
				sql = "select cur_precio precio from CURSO where cur_id = ?";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(1, bean.getIdCurso());
				rs = pstm.executeQuery();
				rs.next();
				double precio = rs.getDouble("precio");
				rs.close();
				pstm.close();
				if (bean.getTipo().equals("BECA")) {
					precio = precio * 0.10;
				}
				if (bean.getTipo().equals("MEDIABECA")) {
					precio = precio * 0.50;
				}
				// Registrar la matricula
				sql = """
				insert into MATRICULA(cur_id,alu_id,emp_id,mat_tipo,
				mat_fecha,mat_precio,mat_cuotas)
				values(?,?,?,?,GETDATE(),?,?)
				""";
				pstm = cn.prepareStatement(sql);
				pstm.setInt(1, bean.getIdCurso());
				pstm.setInt(2, bean.getIdAlumno());
				pstm.setInt(3, bean.getIdEmpleado());
				pstm.setString(4, bean.getTipo());
				pstm.setDouble(5, precio);
				pstm.setDouble(6, bean.getCuotas());
				pstm.executeUpdate();
				pstm.close();
				// CONFIRMAR PROCESO O TRANSACCION
				cn.commit();
			} catch (SQLException e) {
				try {
					cn.rollback(); // Cancela la Tx
				} catch (Exception e1) {
				}
				throw new RuntimeException(e.getMessage());
			} catch (Exception e) {
				try {
					cn.rollback(); // Cancela la Tx
				} catch (Exception e1) {
				}
				throw new RuntimeException("Error en el proceso, intentalo nuevamente.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
