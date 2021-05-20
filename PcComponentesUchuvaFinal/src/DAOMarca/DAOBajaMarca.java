package DAOMarca;

import java.sql.SQLException;

import DAOAndTransfer.DAOSuper;
import factoria.Marca;

public class DAOBajaMarca extends DAOSuper {

	public DAOBajaMarca(Marca marca) {
		super();
		this.query = "DELETE FROM marcas WHERE CIFMarca = '" + marca.getCIFMarca() + "'";
	}

	public String conectar() {
		int row = -1;
		try {
			row = this.conectarUpdate();
		} catch (SQLException e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede eliminar una marca con productos";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return " El campos DNI esta vacio";
		}
		return "Exito";

	}
}
