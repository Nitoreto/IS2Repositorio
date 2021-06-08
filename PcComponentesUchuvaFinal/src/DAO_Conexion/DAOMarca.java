package DAO_Conexion;

import java.sql.SQLException;

import factoria.Marca;

public class DAOMarca {
	private String CIFMarca;

	public DAOMarca(Marca marca) {
		super();
		CIFMarca = marca.getCIFMarca();

	}
	
	public String Alta() {
		try {
			this.query = "INSERT into Marca (CIF, Nombre, Pais, Activo) VALUES " + "('" + marca.getCIFMarca() + "','"
					+ marca.getNombre() + "', '" + marca.getPais() + "'," + marca.getActivo() + ")";
			if (CIFMarca.equals("")) {
				return "Campo CIF esta vacio";
			}
			super.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}
	
	public String Baja() {
		int row = -1;
		try {
			this.query = "DELETE FROM Marca WHERE CIF = '" + marca.getCIFMarca() + "'";
			row = this.conectarUpdate();
		} catch (SQLException e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede eliminar una marca con productos";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return " El campos DNI esta vacio";
		}
		return "Exito";

	}
	
	public String Buscar() {
		try {
			this.query = "SELECT * FROM Marca WHERE CIF = '" + marca.getCIFMarca() + "'";

			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}

		// CREAR EL MESNAJE DE INFORMACION

		return "Exito";
	}
	
	public String Desactivar() {
		int row = -1;
		try {
			this.query = "UPDATE Marca SET Activo = 0 WHERE CIF = '" + marca.getCIFMarca() + "'";
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "CIF no Encontrado";
		}
		return "Exito";
	}
	
	public String Listar() {
		try {
			this.query = "SELECT * FROM Marca";
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}
	
	public String conectar() {
		int row = -1;
		try {
			this.query = "UPDATE Marca SET CIF = '" + marca.getCIFMarca() + "' ,Nombre = '" + marca.getNombre()
			+ "', Pais = '" + marca.getPais() + "', Activo = " + marca.getActivo() + " WHERE CIF = '" + CIFMarcaOriginal + "'";
			row = super.conectarUpdate();
		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede cambiar el nombre de una marca con productos";
			}

			return e.getMessage();
		}
		if (row == 0) {
			return "El CIF esta vacio.";
		}
		return "Exito";
	}

}
