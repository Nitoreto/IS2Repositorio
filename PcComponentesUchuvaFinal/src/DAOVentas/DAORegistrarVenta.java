package DAOVentas;

import DAOAndTransfer.DAOSuper;
import factoria.Venta;

public class DAORegistrarVenta extends DAOSuper{
	private String DNI;
	private int idEmpleado = -1;
	
	public DAORegistrarVenta(Venta venta){
		super();
		DNI = venta.getDNICliente();
		idEmpleado = venta.getIdEmpleado();
		this.query = "INSERT into `ventas` (`idVentas`, `DNIcliente`, `listaProductos`, `ID_Empleado`, `precioTotal`) VALUES " + "('" + venta.getIdVentas() + "', '" + venta.getDNICliente() + "','" + venta.getListaProductos() + "' , '"+venta.getIdEmpleado()+"' , '"+venta.getPrecioTotal()+"')";

	}
	public String conectar() {
		int row = -1;
		try {

			if(DNI.equals("")) {
				throw new Exception("El campo DNI cliente está vacío. ");
			}
			if (idEmpleado == -1) {
				throw new Exception("El campo ID de Empleado está vacío.");
			}
			row = super.conectarUpdate();

		} catch (Exception e) {
			
			return e.getMessage();
		}
		if(row == 0) {
			return "Los campos estan vacios.";
		}
		return "Exito";
	}
	
}