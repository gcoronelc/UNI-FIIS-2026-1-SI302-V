package pe.edu.uni.appeduca.prueba;

import pe.edu.uni.appeduca.service.ConsultaService;

public class Prueba02Caso1 {
    
    public static void main(String[] args) {
        try {
            // Datos
            int idCurso = 5;
            // Proceso
            ConsultaService service = new ConsultaService();
            double precio = service.getPrecioCurso(idCurso);
            // Reporte
            System.out.println("Precio: " + precio);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
