package pe.edu.uni.appeduca.prueba;

import pe.edu.uni.appeduca.dto.MatriculaDto;
import pe.edu.uni.appeduca.service.NegocioService;

public class Prueba04Caso3 {

	public static void main(String[] args) {
		try {
			// Datos
			MatriculaDto bean = new MatriculaDto();
			bean.setTipo("REGULAR");
			bean.setCuotas(4);
			// Proceso
			NegocioService service = new NegocioService();
			service.registrarMatricula(bean);
			// Reporte
			System.out.println("Matricula Ok. ");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
