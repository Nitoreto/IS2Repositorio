package DAO_Conexion;

import java.sql.SQLException;
import Transfer.TransferSucursal;

public class DAOSucursal {
	private SingletonConexion conexion;

	public DAOSucursal() throws Exception {
		try {
			this.conexion = SingletonConexion.obtenerConexion();
		} catch (SQLException e) {
			throw new Exception("Error al conectar con la base de datos.");
		}
	}

	public TransferSucursal buscar(int id) throws Exception {
		try {
			String query = "SELECT * FROM Cliente WHERE DNI = '" + id + "'";
			TransferSucursal tSucursal = new TransferSucursal(conexion.conectarExecute(query));
			return tSucursal;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean alta(TransferSucursal tSucursal) throws Exception {
		String query = "INSERT into Sucursal (IDs, Direccion, Telefono, Activo) VALUES (" + tSucursal.getID() + ", '"
				+ tSucursal.getDireccion() + "', " + tSucursal.getTelefono() + ", " + tSucursal.isActivo() + ")";
		try {
			conexion.conectarUpdate(query);
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;
	}

	public Boolean baja(int id) throws Exception {
		try {
			int row = -1;
			String query = "DELETE  FROM Sucursal WHERE IDs = " + id;
			String query1 = "DELETE  FROM Gestiona WHERE IDs = " + id;
			String query2 = "DELETE  FROM Have WHERE IDs = " + id;
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No se ha encontrado una sucursal con ese id");
			}
			return true;
		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				throw new Exception("No se puede borrar un cliente con ventas");
			}
			return false;
		}
	}

	public Boolean desactivar(int id) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Sucursal SET Activo = 0 WHERE IDs = '" + id + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("Sucursal no encontrada");
			}
			return true;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public TransferSucursal listar() throws Exception {
		try {
			String query = "SELECT * FROM Sucursal";
			TransferSucursal tSucursal = new TransferSucursal(conexion.conectarExecute(query));
			return tSucursal;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean modificar(TransferSucursal tSucursal, String ID) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Sucursal SET Ids = " + tSucursal.getID() + ", Direccion = '"
					+ tSucursal.getDireccion() + "', Telefono = " + tSucursal.getTelefono() + ", Activo = "
					+ tSucursal.isActivo() + " WHERE DNI = '" + ID + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("Sucursal no encontrada");
			}
			return true;
		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				throw new Exception("No se puede modificar el DNI de un cliente con ventas");
			} else {
				throw new Exception(e.getCause());
			}
		}
	}
}
