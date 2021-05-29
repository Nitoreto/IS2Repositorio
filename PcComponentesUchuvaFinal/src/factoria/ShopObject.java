package factoria;

import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;

public abstract class ShopObject implements Acciones {
	private String nombreClase;
	private DAOSuper dao;

	public ShopObject(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public ShopObject esEsteShopObject(String nombre, String[] datos) {
		if (this.nombreClase.equalsIgnoreCase(nombre)) {
			try {
				inicializarObjeto(datos);
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

	public abstract void inicializarObjeto(String[] datos) throws NumberFormatException;

}
