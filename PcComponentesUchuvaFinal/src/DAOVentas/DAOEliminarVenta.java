package DAOVentas;


import DAOAndTransfer.DAOSuper;
import factoria.Venta;

public class DAOEliminarVenta extends DAOSuper{

	public DAOEliminarVenta(Venta venta) {
		super();
		this.query = "DELETE FROM ventas WHERE idVentas = '" + venta.getIdVentas() + "'";
	}

	public String conectar() {int row = -1;
	try {

		row = super.conectarUpdate();

	} catch (Exception e) {
		
		return e.getMessage();
	}
	if(row == 0) {
		return "No se encuentra la venta con dicho ID";
	}
	return "Exito";
	}

}