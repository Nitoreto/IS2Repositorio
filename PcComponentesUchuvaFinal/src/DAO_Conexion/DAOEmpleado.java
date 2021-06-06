package DAO_Conexion;

import java.sql.SQLException;

import factoria.Empleado;

public class DAOEmpleado {
	private String DNI;
	
	public DAOEmpleado(Empleado E1) {
		super();
		DNI = E1.getDni();
		
	}
	
	public String Añadir() {
		try {
			this.query = "INSERT into empleados (ID_Empleado, Nombre, Apellidos, DNI, Direccion, Telefono) " + "VALUES "
					+ "(" + E1.getId_empleado() + ",'" + E1.getName() + "','" + E1.getApell() + "','" + E1.getDni() + "','"
					+ E1.getDir() + "'," + E1.getNumero() + ")";
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
			this.query = "SELECT * FROM empleados WHERE ID_Empleado = " + E1.getId_empleado();

			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}
	
	public String Desactivar() {
		int row = -1;
		try {
			this.query = "UPDATE empleados SET Activo = 0 WHERE ID_Empleado = " + empleado.getId_empleado();
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
			this.query = "DELETE FROM empleados WHERE ID_Empleado = " + E1.getId_empleado() + "";
			row = this.conectarUpdate();
		} catch (SQLException e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
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
			this.query = "SELECT * FROM empleados";
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}
	
	public String Modificar() {

		int row = -1;
		try {
			this.query = "UPDATE empleados SET ID_Empleado = " + E1.getId_empleado() + "," + "Nombre = '" + E1.getName()
			+ "', " + "Apellidos = '" + E1.getApell() + "',  " + "DNI = '" + E1.getDni() + "', " + "Direccion = '"
			+ E1.getDir() + "', " + "Telefono = " + E1.getNumero() + " , Activo = " + E1.getActivo() + " WHERE ID_Empleado = " + ID_Empleado;
			row = super.conectarUpdate();
		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
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
			this.query = "SELECT E.id_empleado, E.Nombre, V.id_ventas FROM empleado E JOIN ventas V ON E.id_empleado = V.id_empleado WHERE DNI = "
					+ E1.getDni() + "";
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}
	
}
