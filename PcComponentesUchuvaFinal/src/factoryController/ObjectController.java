package factoryController;

import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;

public abstract class ObjectController implements Acciones {
	private String nombreClase;

	public ObjectController(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public ObjectController esEsteShopObject(String nombre, String[] datos) {
		if (this.nombreClase.equalsIgnoreCase(nombre)) {
			try {
				inicializarTransfer(datos);
			} catch (NumberFormatException e) {
				return null;
			}
			return this;
		} else {
			return null;
		}
	}

	public void close() {
		if (dao != null)
			dao.close();
	}
	
	protected abstract void inicializarTransfer(String[] datos) throws Exception;

}
