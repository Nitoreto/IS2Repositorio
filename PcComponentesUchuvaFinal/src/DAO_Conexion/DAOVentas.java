package DAO_Conexion;

import java.sql.SQLException;
import Transfer.TransferVenta;

public class DAOVentas {
	private SingletonConexion conexion;

	public DAOVentas() throws Exception {
		try {
			this.conexion = SingletonConexion.obtenerConexion();
		} catch (SQLException e) {
			throw new Exception("Error al conectar con la base de datos.");
		}
	}

	public Boolean desactivar(int ID) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Venta SET Activo = 0 WHERE IDv = " + ID;
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("ID no Encontrado");
			}
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;
	}

	public Boolean baja(int ID) throws Exception {
		try {
			int row = -1;
			String query = "DELETE FROM Venta WHERE IDv = " + ID;
			String query1 = "DELETE FROM Realiza WHERE IDv = " + ID;
			String query2 = "DELETE FROM Gestiona WHERE IDv = " + ID;
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No se encuentra la venta con dicho ID");
			}
			row = conexion.conectarUpdate(query1);
			row = conexion.conectarUpdate(query2);
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;
	}

	public TransferVenta listar() throws Exception {
		try {
			String query = "SELECT * FROM Venta";
			TransferVenta tVenta = new TransferVenta(conexion.conectarExecute(query));
			return tVenta;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean modificar(TransferVenta tVenta, int ID) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Venta SET IDv = " + tVenta.getIdVenta() + ", Importe = " + tVenta.getPrecioTotal()
					+ ", Fecha = '" + tVenta.getFecha() + "', Activo = " + tVenta.isActivo() + " WHERE IDv = " + ID;

			if (tVenta.getDNICliente().equals("")) {
				throw new Exception("El campo DNI de cliente esta vacio.");
			}
			if (tVenta.getIdEmpleado() == -1) {
				throw new Exception("El campo ID de Empleado esta vacio.");
			}
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No se encuntre la venta.");
			}

		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				throw new Exception("No se encuentra ese cliente o empleado");
			}
		}

		return true;
	}

	public TransferVenta buscar(int ID) throws Exception{
		try {
			String query = "SELECT * FROM Venta WHERE IDv = " + ID;
			TransferVenta tVenta = new TransferVenta(conexion.conectarExecute(query));
			return tVenta;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean alta(TransferVenta tVenta) throws Exception{
		
		try {
			int row = -1;
			String query = "INSERT into Venta (IDv, Importe, Fecha, Activo) VALUES (" + tVenta.getIdVenta() + ", "
					+ tVenta.getPrecioTotal() + ",'" + tVenta.getFecha() + ", " + tVenta.isActivo() + " )";
			String query1 = "INSERT into Gestiona(DNI, IDs, IDv) VALUES ('" + tVenta.getIdEmpleado() + "', "
					+ tVenta.getIdSucursal() + ", " + tVenta.getIdVenta() + ")";
			String query2 = "INSERT into Realiza (IDv, DNI) VALUES (" + tVenta.getIdVenta() + ", '" + tVenta.getDNICliente() + "')";
			String query3 = "INSERT into Contiene (IDv, IDp) VALUES (" + tVenta.getIdVenta() + ", "
					+ tVenta.getListaProductos() + ")";
			if (tVenta.getDNICliente().equals("")) {
				throw new Exception("El campo DNI cliente est� vac�o. ");
			}
			if (tVenta.getIdEmpleado() == -1) {
				throw new Exception("El campo ID de ControllerEmpleado est� vac�o.");
			}
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("Los campos estan vacios.");
			}
			conexion.conectarUpdate(query1);
			conexion.conectarUpdate(query2);
			conexion.conectarUpdate(query3);
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}

		return true;
	}
}
