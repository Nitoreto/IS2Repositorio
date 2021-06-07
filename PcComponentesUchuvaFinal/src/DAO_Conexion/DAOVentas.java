package DAO_Conexion;

import java.sql.SQLException;

import Transfer.Transfer;
import factoryController.ControllerVenta;

public class DAOVentas {
	private String DNI;
	private int idEmpleado = -1;
	
	public DAOVentas(ControllerVenta venta) {
		super();
		
	}

	public String Desactivar() {
		int row = -1;
		try {
			this.query = "UPDATE ventas SET Activo = 0 WHERE idVentas = " + venta.getIdVentas();
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "ID no Encontrado";
		}
		return "Exito";
	}
	
	public String Eliminar() {int row = -1;
	try {
		this.query = "DELETE FROM ventas WHERE idVentas = '" + venta.getIdVentas() + "'";
		row = super.conectarUpdate();

	} catch (Exception e) {
		
		return e.getMessage();
	}
	if(row == 0) {
		return "No se encuentra la venta con dicho ID";
	}
	return "Exito";
	}
	
	public String Listar() {
		try {
			this.query = "SELECT * FROM ventas WHERE DNIcliente = '" + venta.getDNICliente() + "' ";
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}
	
	public String Modificar() {
		int row = -1;

		try {
			DNI = venta.getDNICliente();
			idEmpleado = venta.getIdEmpleado();
			this.query = "UPDATE ventas SET idVentas = " + venta.getIdVentas() + " ,DNIcliente = '" + DNI + "', listaProductos = '" + venta.getListaProductos()
					+ "', ID_Empleado = " + idEmpleado + ", precioTotal = " + venta.getPrecioTotal() + ", Activo = "
					+ venta.getActivo() + " WHERE idVentas = " + idVenta;


			if (DNI.equals("")) {
				throw new Exception("El campo DNI de cliente está vacío.");
			}
			if (idEmpleado == -1) {
				throw new Exception("El campo ID de ControllerEmpleado está vacío.");
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
	
	public String Mostrar() {		
		try {
			this.query = "SELECT * FROM ventas WHERE idVentas = " + venta.getIdVentas();
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}
	
	public String RegistrarVenta() {
		int row = -1;
		try {
			DNI = venta.getDNICliente();
			idEmpleado = venta.getIdEmpleado();
			this.query = "INSERT into `ventas` (`idVentas`, `DNIcliente`, `listaProductos`, `ID_Empleado`, `precioTotal`) VALUES " + "('" + venta.getIdVentas() + "', '" + venta.getDNICliente() + "','" + venta.getListaProductos() + "' , '"+venta.getIdEmpleado()+"' , '"+venta.getPrecioTotal()+"')";


			if(DNI.equals("")) {
				throw new Exception("El campo DNI cliente está vacío. ");
			}
			if (idEmpleado == -1) {
				throw new Exception("El campo ID de ControllerEmpleado está vacío.");
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
