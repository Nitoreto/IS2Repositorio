package DAOMarca;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAOAndTransfer.DAOSuper;
import DAOAndTransfer.Transfer;
import factoria.Marca;

public class DAOBuscarMarca extends DAOSuper {

	public DAOBuscarMarca(Marca marca) {
		super();
		this.query = "SELECT * FROM marcas WHERE CIFMarca = '" + marca.getCIFMarca() + "'";
	}

	public String conectar() {
		try {
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}

		// CREAR EL MESNAJE DE INFORMACION

		return "Exito";
	}
}
