package DAOVentas;

import dao_Transfer_Singelton.DAOSuper;
import factoria.Venta;

public class DAODesactivarVenta extends DAOSuper {
	public DAODesactivarVenta(Venta venta) {
		super();
		this.query = "UPDATE ventas SET Activo = 0 WHERE idVentas = " + venta.getIdVentas();
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
