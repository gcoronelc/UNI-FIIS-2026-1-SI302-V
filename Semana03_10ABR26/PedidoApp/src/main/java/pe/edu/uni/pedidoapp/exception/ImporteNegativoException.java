package pe.edu.uni.pedidoapp.exception;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog https://gcoronelc.blogspot.com/
 * @email gcoronelc@gmail.com
 * @youtube https://www.youtube.com/DesarrollaSoftware
 * @facebook https://www.facebook.com/groups/desarrollasoftware/
 * @cursos https://gcoronelc.github.io/
 */
public class ImporteNegativoException extends RuntimeException{

	public ImporteNegativoException() {
		super("[ERROR] El importe debe ser un valor positivo, mayor  que cero.");
	}
	
	public ImporteNegativoException(double importe) {
		super("[ERROR] El valor " + importe + " es incorrecto, debe ser un valor positivo.");
	}
	
	public ImporteNegativoException(String mensaje) {
		super( mensaje );
	}

}
