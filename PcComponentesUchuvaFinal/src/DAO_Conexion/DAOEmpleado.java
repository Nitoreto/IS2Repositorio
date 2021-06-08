package DAO_Conexion;

import java.sql.SQLException;

import Transfer.Transfer;
import factoryController.ControllerEmpleado;

public class DAOEmpleado {
	private String DNI;

	public DAOEmpleado(ControllerEmpleado E1) {
		super();
		DNI = E1.getDni();

	}

	public String A�adir() {
		try {
			this.query = "INSERT into Personal (DNI, Nombre, Contrasena, Direccion, Telefono, Sueldo, Activo) " + "VALUES "
					+ "('" + E1.getDni() + "', '" + E1.getName() + "', " + E1.getContrasena() + ", '"	+ E1.getDir() + "', " + E1.getNumero() + ", " + E1.getSueldo() + ", "+ E1.getActivo() +")";
			if (DNI.equals("")) {
				return "Campo DNI esta vacio";
			}

			super.conectarUpdate();

		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}

	public String Busar() {
		try {
			this.query = "SELECT * FROM Personal WHERE DNI = '" + E1.getDni() + "'";

			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}

	public String Desactivar() {
		int row = -1;
		try {
			this.query = "UPDATE Personal SET Activo = 0 WHERE DNI = '" + E1.getDni() + "'";
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
			this.query = "DELETE FROM Personal WHERE DNI = '" + E1.getDni() + "'";
			row = this.conectarUpdate();
		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede borrar un empleado con ventas";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "No se ha encontrado un empleado con ese DNI";
		}
		return "Exito";

	}

	public String Lista() {
		try {
			this.query = "SELECT * FROM Personal";
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}

	public String Modificar() {

		int row = -1;
		try {
			this.query = "UPDATE Personal SET DNI = '" + E1.getDni() + "'," + " Nombre = '" + E1.getName() + "', "
					+ " Contrasena = " + E1.getContrasena() + ",  " + " Direccion = '"
					+ E1.getDir() + "', " + " Telefono = " + E1.getNumero() + " Sueldo = " + E1.getSueldo() + ", " + " Activo = " + E1.getActivo()
					+ " WHERE DNI = " + E1.getDni();
			row = super.conectarUpdate();
		} catch (Exception e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede modificar el ID de un empleado con ventas";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "No hay cambios";
		}
		return "Exito";
	}

	public String MuestraHistorialEmpleado() {
		try {
			this.query = "SELECT DNI, IDs , IDv FROM Gestiona WHERE DNI = '" + E1.getDni() + "'";
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}

}
