package DAOProductos;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAOAndTransfer.DAOSuper;
import DAOAndTransfer.Transfer;
import factoria.Producto;

public class DAOMostrarProducto extends DAOSuper {
	ResultSet resultado;

	public DAOMostrarProducto(Producto Producto) {
		super();
		this.query = "SELECT * FROM productos WHERE ID = " + Producto.getID();
	}

	public String Conectar() {
		try {
			this.transfer = new Transfer( super.conectarExecute());
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Exito";

	}

	public ResultSet getResultSet() {
		return this.resultado;
	}
}