package factoryController;

import java.sql.SQLException;
import main.Mediator;

public abstract class ObjectController implements Acciones {
	private String nombreClase;
	protected Mediator mediator;

	public ObjectController(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public ObjectController esEsteShopObject(String nombre, String[] datos, Mediator mediator) {
		if (this.nombreClase.equalsIgnoreCase(nombre)) {
			try {
				this.mediator = mediator;
				inicializarTransfer(datos);
			} catch (Exception e) {
				mediator.avisarError(e.getMessage());
			}
			return this;
		} else {
			return null;
		}
	}
	
	protected abstract void inicializarTransfer(String[] datos) throws Exception;

}
