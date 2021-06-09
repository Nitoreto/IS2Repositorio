package DAO_Conexion;

import java.sql.SQLException;
import Transfer.TransferCliente;

public class DAOClientes {
	private SingletonConexion conexion;

	public DAOClientes() throws Exception {
		try {
			this.conexion = SingletonConexion.obtenerConexion();
		} catch (SQLException e) {
			throw new Exception("Error al conectar con la base de datos.");
		}

	}

	public TransferCliente buscar(String DNI) throws Exception {
		try {
			String query = "SELECT * FROM Cliente WHERE DNI = '" + DNI + "'";
			TransferCliente tCliente = new TransferCliente(conexion.conectarExecute(query));
			return tCliente;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean alta(TransferCliente tCliente) throws Exception {
		if (tCliente.equals("")) {
			throw new Exception("Campo dni esta vacio");
		}
		String query = "INSERT into Cliente (DNI, Nombre, Telefono, Activo) VALUES " + "('" + tCliente.getDNI() + "', '"
				+ tCliente.getNombre() + "', " + tCliente.getTelefono() + ", " + tCliente.getActivo() + ")";
		try {
			conexion.conectarUpdate(query);
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}

		return true;
	}

	public Boolean baja(String DNI) throws Exception {
		try {
			int row = -1;
			String query = "DELETE  FROM Cliente WHERE DNI = '" + DNI + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No se ha encontrado un cliente con ese DNI");
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

	public Boolean desactivar(String DNI) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Cliente SET Activo = 0 WHERE DNI = '" + DNI + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("DNI no Encontrado");
			}
			return true;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public TransferCliente listar() throws Exception {
		try {
			String query = "SELECT * FROM Cliente";
			TransferCliente tCliente = new TransferCliente(conexion.conectarExecute(query));
			return tCliente;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean modificar(TransferCliente tCliente, String DNI) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Cliente SET DNI = '" + tCliente.getDNI() + "', Nombre = '" + tCliente.getNombre()
					+ "', Telefono = " + tCliente.getTelefono() + ", Activo = " + tCliente.getActivo()
					+ " WHERE DNI = '" + DNI + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No hay un cliente con ese DNI");
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
