package DAOProductos;

import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;
import factoria.Producto;

public class DAOBajaProducto extends DAOSuper {

	public DAOBajaProducto(Producto Producto) {
		super();
		this.query = "DELETE FROM productos WHERE ID = " + Producto.getID();
	}

	public String Conectar() {
		int row = -1;
		try {
			row = this.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}
		if (row == 0) {
			return "No se ha podido encontrar ese ID";
		}
		return "Exito";

	}
}