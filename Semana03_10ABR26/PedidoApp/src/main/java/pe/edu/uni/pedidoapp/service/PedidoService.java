package pe.edu.uni.pedidoapp.service;

import pe.edu.uni.pedidoapp.dto.PedidoDto;
import pe.edu.uni.pedidoapp.exception.ImporteNegativoException;

public class PedidoService {

	private final double IGV = 0.18;

	
	public double calcularImpueso(double importe) {
		// Validacion
		if(importe <= 0.0){
			throw new ImporteNegativoException(importe);
			//throw new RuntimeException("[ERROR] El importe debe ser mayor que cero.");
		}
		// Proceso
		double impuesto;
		impuesto = importe * IGV;
		return dosDigitos(impuesto);
	}

	public double calcularTotal(double importe) {
		// Validacion
		if(importe <= 0.0){
			throw new ImporteNegativoException(importe);
			//throw new RuntimeException("[ERROR] El importe debe ser mayor que cero.");
		}
		// Proceso
		double total;
		total = importe + calcularImpueso(importe);
		return dosDigitos(total);
	}

	private double dosDigitos(double valor) {
		valor = valor * 100;
		valor = Math.round(valor) / 100.0;
		return valor;
	}
	
	
	// Para el uso del DTO
	
	public PedidoDto procesar(double importe){
		// Validacion
		if(importe <= 0.0){
			throw new ImporteNegativoException(importe);
			//throw new RuntimeException("[ERROR] El importe debe ser mayor que cero.");
		}
		// Proceso
		double impuesto = importe * IGV;
		double total = importe + impuesto;
		// Reporte
		impuesto = dosDigitos(impuesto);
		total = dosDigitos(total);
		PedidoDto dto = new PedidoDto(importe, impuesto, total);
		return dto;
	}

}
