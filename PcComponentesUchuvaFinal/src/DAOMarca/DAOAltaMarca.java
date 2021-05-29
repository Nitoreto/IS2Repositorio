package DAOMarca;

import java.sql.*;

import dao_Transfer_Singelton.DAOSuper;
import factoria.Marca;

public class DAOAltaMarca extends DAOSuper {
	private String CIFMarca;

	public DAOAltaMarca(Marca marca) {
		super();
		CIFMarca = marca.getCIFMarca();
		this.query = "INSERT into `marcas` (`CIFMarca`, `Nombre`, `Pais`) VALUES " + "('" + marca.getCIFMarca() + "','"
				+ marca.getNombre() + "', '" + marca.getPais() + "')";
	}

	public String conectar() {
		try {
			if (CIFMarca.equals("")) {
				return "Campo CIF esta vacio";
			}
			super.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}

}
