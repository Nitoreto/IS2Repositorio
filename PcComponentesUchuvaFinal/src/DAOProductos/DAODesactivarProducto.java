package DAOProductos;

import DAOAndTransfer.DAOSuper;
import factoria.Producto;

public class DAODesactivarProducto extends DAOSuper {
	public DAODesactivarProducto(Producto producto) {
		super();
		this.query = "UPDATE productos SET Activo = 0 WHERE ID = " + producto.getID();
	}

	public String conectar() {
		int row = -1;
		try {
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "ID no Encontrado";
		}
		return "Exito";
	}
}
