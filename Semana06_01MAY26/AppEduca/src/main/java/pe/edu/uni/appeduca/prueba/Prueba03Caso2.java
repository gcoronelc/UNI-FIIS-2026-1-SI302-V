package pe.edu.uni.appeduca.prueba;

import java.util.List;
import pe.edu.uni.appeduca.dto.AlumnoCursoDTO;
import pe.edu.uni.appeduca.service.ConsultaService;

public class Prueba03Caso2 {

	public static void main(String[] args) {
		try {
			// Datos
			int idCurso = 15;
			// Proceso
			ConsultaService service = new ConsultaService();
			List<AlumnoCursoDTO> lista = service.getMatriculados(idCurso);
			// Reporte
			if (lista.isEmpty()) {
				System.out.println("No hay matriculados");
				return;
			}
			for (AlumnoCursoDTO dto : lista) {
				System.out.println(dto);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
