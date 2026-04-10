package pe.edu.uni.pedidoapp.prueba;

import pe.edu.uni.pedidoapp.dto.PedidoDto;
import pe.edu.uni.pedidoapp.exception.ImporteNegativoException;
import pe.edu.uni.pedidoapp.service.PedidoService;

public class Prueba03 {
    
    public static void main(String[] args) {
		 
		 try {
			 
			 double importe, impuesto, total;
			 // Datos
			 importe = 500;
			 // Proceso
			 PedidoService service = new PedidoService();
			 PedidoDto dto = service.procesar(importe);
			 // Reporte
			 System.out.println("Importe: " + dto.getImporte());
			 System.out.println("Impuesto: " + dto.getImpuesto());
			 System.out.println("Total: " + dto.getTotal());
			 
		 } catch (ImporteNegativoException ex) {
			 System.err.println(ex.getMessage());
		 }
        
    }
}
