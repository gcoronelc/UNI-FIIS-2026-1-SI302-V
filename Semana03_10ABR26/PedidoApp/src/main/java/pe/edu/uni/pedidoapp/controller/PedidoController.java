package pe.edu.uni.pedidoapp.controller;

import pe.edu.uni.pedidoapp.service.PedidoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class PedidoController {
	
	private PedidoService pedidoService;

	public PedidoController() {
		pedidoService = new PedidoService();
	}
	
	public double calcularImpueso(double importe) {
		return pedidoService.calcularImpueso(importe);
	}
	
	public double calcularTotal(double importe) {
		return pedidoService.calcularTotal(importe);
	}

}
