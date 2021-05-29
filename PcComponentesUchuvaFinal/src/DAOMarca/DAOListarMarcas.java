package DAOMarca;

import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;
import dao_Transfer_Singelton.Transfer;
import factoria.Marca;

public class DAOListarMarcas extends DAOSuper {

	public DAOListarMarcas(Marca marca) {
		super();
		this.query = "SELECT * FROM marcas";
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
