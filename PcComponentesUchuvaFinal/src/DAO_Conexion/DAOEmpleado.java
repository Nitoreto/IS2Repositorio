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
		String query = "INSERT into Personal (DNI, Nombre, Contrasena, Direccion, Telefono, Sueldo, Activo) VALUES ('"
				+ tEmpleado.getDNI() + "', '" + tEmpleado.getNombre() + "', '" + tEmpleado.getPassword() + "', '"
				+ tEmpleado.getDir() + "', " + tEmpleado.getNumero() + ", " + tEmpleado.getSueldo() + ", "
				+ tEmpleado.getActivo() + ")";

		String query1 = "INSERT into Contratado (DNIp, IDs) VALUES ('" + tEmpleado.getDNI() + "', "
				+ tEmpleado.getIdSucursal() + " )";
		System.out.print(query1);
		try {
			conexion.conectarUpdate(query);
			conexion.conectarUpdate(query1);
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;
	}

	public TransferEmpleado buscar(String DNI) throws Exception {
		try {
			String query = "SELECT DNI, Nombre, Contrasena, Direccion, Telefono, Sueldo, IDs, Activo FROM Personal p JOIN Contratado c ON p.DNI = c.DNIp WHERE DNI = '" + DNI + "'";
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
			String query1 = "DELETE FROM Contratado  WHERE DNIp = '" + DNI + "'";
			String query2 = "DELETE FROM Gestiona  WHERE DNI = '" + DNI + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No se ha encontrado un empleado con ese DNI");
			}
			row = conexion.conectarUpdate(query1);
			row = conexion.conectarUpdate(query2);
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
					+ ", Sueldo = " + tEmpleado.getSueldo() + ", " + " Activo = " + tEmpleado.getActivo()
					+ " WHERE DNI = '" + DNI + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("No hay un Empleado con ese DNI");
			}
			return true;
		} catch (SQLException e) {
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
