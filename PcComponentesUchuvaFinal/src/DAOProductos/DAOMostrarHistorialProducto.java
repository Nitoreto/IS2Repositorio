package DAOProductos;

import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;
import dao_Transfer_Singelton.Transfer;
import factoria.Producto;

public class DAOMostrarHistorialProducto extends DAOSuper {

	public DAOMostrarHistorialProducto(Producto Producto) {
		super();
		this.query = "SELECT * FROM Productos";
	}

	public String conectar() {

		try {

			this.transfer = new Transfer(super.conectarExecute());

		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}
}