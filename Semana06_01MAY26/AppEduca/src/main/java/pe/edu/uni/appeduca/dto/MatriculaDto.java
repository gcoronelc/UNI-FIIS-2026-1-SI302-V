package pe.edu.uni.appeduca.dto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class MatriculaDto {

	private int idCurso;
	private int idAlumno;
	private String tipo;
	private int cuotas;
	private int idEmpleado;

	public MatriculaDto() {
	}

	public MatriculaDto(int idCurso, int idAlumno, String tipo, int cuotas, int idEmpleado) {
		this.idCurso = idCurso;
		this.idAlumno = idAlumno;
		this.tipo = tipo;
		this.cuotas = cuotas;
		this.idEmpleado = idEmpleado;
	}

	

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	

}
