package DAO_Conexion;

import java.sql.SQLException;

import factoria.Marca;

public class  {
	private String CIFMarca;

	public DAOMarca(Marca marca) {
		super();
		CIFMarca = marca.getCIFMarca();

	}
	
	public String Alta() {
		try {
			this.query = "INSERT into `marcas` (`CIFMarca`, `Nombre`, `Pais`) VALUES " + "('" + marca.getCIFMarca() + "','"
					+ marca.getNombre() + "', '" + marca.getPais() + "')";
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
			this.query = "DELETE FROM marcas WHERE CIFMarca = '" + marca.getCIFMarca() + "'";
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
			this.query = "SELECT * FROM marcas WHERE CIFMarca = '" + marca.getCIFMarca() + "'";

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
			this.query = "UPDATE marcas SET Activo = 0 WHERE CIFMarca = '" + marca.getCIFMarca() + "'";
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
			this.query = "SELECT * FROM marcas";
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}
	
	public String conectar() {
		int row = -1;
		try {
			this.query = "UPDATE marcas SET CIFMarca = '" + marca.getCIFMarca() + "' ,Nombre = '" + marca.getNombre()
			+ "', Pais = '" + marca.getPais() + "', Activo = " + marca.getActivo() + " WHERE CIFMarca = '" + CIFMarcaOriginal + "'";
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
