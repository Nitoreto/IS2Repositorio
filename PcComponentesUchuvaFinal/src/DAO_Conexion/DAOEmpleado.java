package DAO_Conexion;

import java.sql.SQLException;
import Transfer.TransferEmpleado;

public class DAOEmpleado {
	private SingletonConexion conexion;

	public DAOEmpleado() throws Exception {
		try {
			this.conexion = SingletonConexion.obtenerConexion();
		} catch (SQLException e) {
			throw new Exception("Error al conectar con la base de datos.");
		}
	}

	public Boolean alta(TransferEmpleado tEmpleado) throws Exception {
		if (tEmpleado.getDNI().equals("")) {
			throw new Exception("Campo DNI esta vacio");
		}
		String query = "INSERT into Personal (DNI, Nombre, Contrasena, Direccion, Telefono, Sueldo, Activo) "
				+ "VALUES " + "('" + tEmpleado.getDNI() + "', '" + tEmpleado.getNombre() + "', "
				+ tEmpleado.getPassword() + ", '" + tEmpleado.getDir() + "', " + tEmpleado.getNumero() + ", "
				+ tEmpleado.getSueldo() + ", " + tEmpleado.getActivo() + ")";
		try {
			conexion.conectarUpdate(query);
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;
	}

	public TransferEmpleado buscar(String DNI) throws Exception {
		try {
			String query = "SELECT * FROM Personal WHERE DNI = '" + DNI + "'";
			TransferEmpleado tEmpleado = new TransferEmpleado(conexion.conectarExecute(query));
			return tEmpleado;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}

	}

	public Boolean desactivar(String DNI) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Personal SET Activo = 0 WHERE DNI = '" + DNI + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("DNI no Encontrado");
			}
			return true;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean baja(String DNI) throws Exception {
		try {
			int row = -1;
			String query = "DELETE FROM Personal WHERE DNI = '" + DNI + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No se ha encontrado un empleado con ese DNI");
			}
			return true;
		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				throw new Exception("No se puede borrar un empleado con ventas");
			}
			return false;
		}
	}

	public TransferEmpleado listar() throws Exception {
		try {
			String query = "SELECT * FROM Personal";
			TransferEmpleado tEmpleado = new TransferEmpleado(conexion.conectarExecute(query));
			return tEmpleado;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean modificar(TransferEmpleado tEmpleado, String DNI) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Personal SET DNI = '" + tEmpleado.getDNI() + "'," + " Nombre = '"
					+ tEmpleado.getNombre() + "', " + " Contrasena = " + tEmpleado.getPassword() + ",  "
					+ " Direccion = '" + tEmpleado.getDir() + "', " + " Telefono = " + tEmpleado.getNumero()
					+ " Sueldo = " + tEmpleado.getSueldo() + ", " + " Activo = " + tEmpleado.getActivo()
					+ " WHERE DNI = '" + DNI + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No hay un Empleado con ese DNI");
			}
			return true;
		} catch (Exception e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				throw new Exception("No se puede modificar el DNI de un empleado con ventas");
			} else {
				throw new Exception(e.getCause());
			}
		}
	}

	public TransferEmpleado MuestraHistorialVentas(String DNI) throws Exception {
		try {
			String query = "SELECT DNI, IDs , IDv FROM Gestiona WHERE DNI = '" + DNI + "'";
			TransferEmpleado tEmpleado = new TransferEmpleado(conexion.conectarExecute(query));
			return tEmpleado;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

}
