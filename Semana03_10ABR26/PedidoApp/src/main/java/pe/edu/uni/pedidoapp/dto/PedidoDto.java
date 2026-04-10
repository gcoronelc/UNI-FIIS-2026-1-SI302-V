package pe.edu.uni.pedidoapp.dto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class PedidoDto {

	private double importe;
	private double impuesto;
	private double total;

	public PedidoDto() {
		this.importe = 0.0;
		this.impuesto = 0.0;
		this.total = 0.0;
	}

	public PedidoDto(double importe) {
		this.importe = importe;
		this.impuesto = 0.0;
		this.total = 0.0;
	}

	public PedidoDto(double importe, double impuesto, double total) {
		this.importe = importe;
		this.impuesto = impuesto;
		this.total = total;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
