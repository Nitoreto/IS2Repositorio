package DAO_Conexion;

import java.sql.SQLException;

import Transfer.Transfer;
import factoryController.ControllerVenta;

public class DAOVentas {
	private String DNI, DNIEmpleado;

	public DAOVentas(ControllerVenta venta) {
		super();

	}

	public String Desactivar() {
		int row = -1;
		try {
			String query = "UPDATE Venta SET Activo = 0 WHERE IDv = " + tVenta.getIdVentas();
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "ID no Encontrado";
		}
		return "Exito";
	}

	public String Eliminar() {
		int row = -1;
		try {
			String query = "DELETE FROM Venta WHERE IDv = " + tVenta.getIdVentas();
			String query1 = "DELETE FROM Realiza WHERE IDv = " + tVenta.getIdVentas();
			String query2 = "DELETE FROM Gestiona WHERE IDv = " + tVenta.getIdVentas();
			row = super.conectarUpdate();

		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "No se encuentra la venta con dicho ID";
		}
		return "Exito";
	}

	public String Listar() {
		try {
			String query = "SELECT * FROM Realiza WHERE DNI = '" + tVenta.getDNICliente() + "' ";
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}

	public String Modificar() {
		int row = -1;

		try {
			DNI = tVenta.getDNICliente();
			idEmpleado = tVenta.getIdEmpleado();
			String query = "UPDATE Venta SET IDv = " + tVenta.getIdVentas() + ", Importe = " + tVenta.getPrecioTotal()
					+ ", Fecha = '" + tVenta.getFecha() + "', Activo = " + tVenta.isActivo() + " WHERE IDv = "
					+ idVenta;

			if (DNI.equals("")) {
				throw new Exception("El campo DNI de cliente est� vac�o.");
			}
			if (idEmpleado == -1) {
				throw new Exception("El campo ID de ControllerEmpleado est� vac�o.");
			}
			row = super.conectarUpdate();

		} catch (Exception e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
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
			String query = "SELECT * FROM Venta WHERE IDv = " + tVenta.getIdVentas();
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}

	public String RegistrarVenta() {
		int row = -1;
		try {
			DNI = tVenta.getDNICliente();
			DNIEmpleado = tVenta.getDni();
			String query = "INSERT into Venta (IDv, Importe, Fecha, Activo) VALUES (" + tVenta.getIdVentas() + ", "
					+ tVenta.getPrecioTotal + ",'" + tVenta.getFecha() + ", " + tVenta.isActivo() + " )";
			String query1 = "INSERT into Gestiona(DNI, IDs, IDv) VALUES ('" + DNIEmpleado + "', "
					+ tVenta.getIdSucursal() + ", " + tVenta.getIdVentas() + ")";
			String query2 = " INSERT into Realiza (IDv, DNI) VALUES (" + tVenta.getIdVenta() + ", '" + DNI + "')";
			if (DNI.equals("")) {
				throw new Exception("El campo DNI cliente est� vac�o. ");
			}
			if (idEmpleado == -1) {
				throw new Exception("El campo ID de ControllerEmpleado est� vac�o.");
			}
			row = super.conectarUpdate();

		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "Los campos estan vacios.";
		}
		return "Exito";
	}
}
