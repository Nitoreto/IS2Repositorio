package DAOVentas;


import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;
import dao_Transfer_Singelton.Transfer;
import factoria.Venta;

public class DAOListarVenta extends DAOSuper {

	public DAOListarVenta(Venta venta) {
		super();
		this.query = "SELECT * FROM ventas WHERE DNIcliente = '" + venta.getDNICliente() + "' ";
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
