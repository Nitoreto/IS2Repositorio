package DAO_Conexion;

import java.sql.SQLException;

import factoria.Cliente;

public class DAOClientes {
	private String DNI;
	public DAOClientes(Cliente cliente) {
		super();
		
	}

	public String Buscar() {
		try {
			this.query = "SELECT *FROM clientes WHERE DNI = '" + cliente.getDNI() + "'";
			this.transfer = new Transfer( super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}
	
	public String Crear() {
		try {
			this.DNI = cliente.getDNI();
			this.query = "INSERT into clientes (`Nombre`, `DNI`, `Telefono`) VALUES " + "('" + cliente.getNombre()
					+ "', '" + cliente.getDNI() + "', '" + cliente.getTelefono() + "')";
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
			this.query = "DELETE  FROM clientes WHERE DNI = '" + cliente.getDNI() + "'";
			row = this.conectarUpdate();
		} catch (SQLException e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
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
			this.query = "UPDATE clientes SET Activo = 0 WHERE DNI = '" + cliente.getDNI() + "'";
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "DNI no Encontrado";
		}
		return "Exito";
	}
	
    public String Listar() {


		try {
			this.query = "SELECT * FROM clientes";
			this.transfer = new Transfer(super.conectarExecute());
			
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		return "Exito";
	}   
    
	public String Modificar() {
		int row = -1;
		try {
			this.query = "UPDATE clientes SET nombre = '" + cliente.getNombre() + "', DNI = '" + cliente.getDNI()
			+ "', telefono = " + cliente.getTelefono() + ", Activo = " + cliente.getActivo() + " WHERE DNI = '"
			+ DNI + "'";
			row = super.conectarUpdate();
		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede modificar el DNI de un cliente con ventas";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "Los campos estan vacios.";
		}
		return "Exito";
	}
	

}
