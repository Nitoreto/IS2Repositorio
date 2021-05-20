package DAOVentas;

import java.sql.SQLException;

import DAOAndTransfer.DAOSuper;
import DAOAndTransfer.Transfer;
import factoria.Venta;

public class DAOMostrarVenta extends DAOSuper{
	
	
	public DAOMostrarVenta(Venta venta) {
		super();
		this.query = "SELECT * FROM ventas WHERE idVentas = " + venta.getIdVentas();
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
