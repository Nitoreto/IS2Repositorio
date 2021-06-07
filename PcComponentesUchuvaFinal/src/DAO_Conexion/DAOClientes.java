package DAO_Conexion;

import java.sql.SQLException;

import factoria.ControladorCliente;
import factoria.Transfer;

public class DAOClientes {
	private Conexion conexion;

	public DAOClientes(Conexion conexion) {
		super();
		this.conexion=conexion;
	}

	public String Buscar() {
		try {
<<<<<<< HEAD
			String query = "SELECT *FROM clientes WHERE DNI = '" + cliente.getDNI() + "'";
			this.transfer = new Transfer( conexion.conectarExecute(query));
=======
			this.query = "SELECT * FROM Cliente WHERE DNI = '" + cliente.getDNI() + "'";
			this.transfer = new Transfer(super.conectarExecute());
>>>>>>> branch 'main' of https://github.com/Nitoreto/IS2Repositorio.git
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}

	public String Crear() {
		try {
			this.DNI = cliente.getDNI();
			this.query = "INSERT into Cliente (DNI, Nombre, Telefono) VALUES " + "('" + cliente.getDNI() + "', '"
					+ cliente.getNombre() + "', '" + cliente.getTelefono() + "')";
			if (DNI.equals("")) {
				throw new Exception("Campo dni esta vacio");
			}
			super.conectarUpdate();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Exito";
	}

	public String Eliminar() {
		int row = -1;
		try {
			this.query = "DELETE  FROM Cliente WHERE DNI = '" + cliente.getDNI() + "'";
			row = this.conectarUpdate();
		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede borrar un cliente con ventas";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "No se ha encontrado un cliente con ese DNI";
		}
		return "Exito";

	}

	public String Desactivar() {
		int row = -1;
		try {
			this.query = "UPDATE Cliente SET Activo = 0 WHERE DNI = '" + cliente.getDNI() + "'";
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "DNI no Encontrado";
		}
		return "Exito";
	}
<<<<<<< HEAD
	
    public String Listar() {
=======

	public String Listar() {

>>>>>>> branch 'main' of https://github.com/Nitoreto/IS2Repositorio.git
		try {
<<<<<<< HEAD
			this.query = "SELECT * FROM clientes";
			this.transfer = new Transfer(super.conectarExecute());	
=======
			this.query = "SELECT * FROM Cliente";
			this.transfer = new Transfer(super.conectarExecute());

>>>>>>> branch 'main' of https://github.com/Nitoreto/IS2Repositorio.git
		} catch (SQLException e) {
			return e.getMessage();
<<<<<<< HEAD
		}		
=======
		}

>>>>>>> branch 'main' of https://github.com/Nitoreto/IS2Repositorio.git
		return "Exito";
	}

	public String Modificar() {
		int row = -1;
		try {
			this.query = "UPDATE Cliente SET DNI = '" + cliente.getDNI() + "', Nombre = '" + cliente.getNombre()
					+ "', telefono = " + cliente.getTelefono() + ", Activo = " + cliente.getActivo() + " WHERE DNI = '"
					+ DNI + "'";
			row = super.conectarUpdate();
		} catch (Exception e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede modificar el DNI de un cliente con ventas";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "Los campos estan vacios.";
		}
		return "Exito";
	}
<<<<<<< HEAD
=======

>>>>>>> branch 'main' of https://github.com/Nitoreto/IS2Repositorio.git
}
