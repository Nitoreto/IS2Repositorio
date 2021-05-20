package DAOVentas;

import DAOAndTransfer.DAOSuper;
import factoria.Venta;

public class DAOModificarVenta extends DAOSuper {
	private String DNI;
	private int idEmpleado = -1;

	public DAOModificarVenta(Venta venta, int idVenta) {
		super();
		DNI = venta.getDNICliente();
		idEmpleado = venta.getIdEmpleado();
		this.query = "UPDATE ventas SET idVentas = " + venta.getIdVentas() + " ,DNIcliente = '" + DNI + "', listaProductos = '" + venta.getListaProductos()
				+ "', ID_Empleado = " + idEmpleado + ", precioTotal = " + venta.getPrecioTotal() + ", Activo = "
				+ venta.getActivo() + " WHERE idVentas = " + idVenta;

	}

	public String conectar() {
		int row = -1;

		try {

			if (DNI.equals("")) {
				throw new Exception("El campo DNI de cliente está vacío.");
			}
			if (idEmpleado == -1) {
				throw new Exception("El campo ID de Empleado está vacío.");
			}
			row = super.conectarUpdate();

		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se encuentra ese cliente o empleado";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "No se encuentra dicho id.";
		}
		return "Exito";
	}

}
