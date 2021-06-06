package DAO_Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import factoria.Producto;

public class DAOProducto {
	ResultSet resultado;
	public DAOProducto(Producto Producto) {
		super();

	}
	
	public String Alta() {
		try {
			this.query = "INSERT into `Productos` (`ID`, `Precio`, `Marca`, `Nombre`, `Descripcion`, `Activo`) VALUES " + "( "
					+ Producto.getID() + " ,'" + Producto.getPrecio() + "', '" + Producto.getNombreMarca() +  "', '" + Producto.getNombre() + "', '"
					+ Producto.getDescripcion() + "', '1' )";
			super.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}

		return "Exito";
	}
	
	public String Baja() {
		int row = -1;
		try {
			this.query = "DELETE FROM productos WHERE ID = " + Producto.getID();
			row = this.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}
		if (row == 0) {
			return "No se ha podido encontrar ese ID";
		}
		return "Exito";

	}
	
	public String Desactivar() {
		int row = -1;
		try {
			this.query = "UPDATE productos SET Activo = 0 WHERE ID = " + producto.getID();
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "ID no Encontrado";
		}
		return "Exito";
	}
	
	public String Modificar() {
		int row = -1;
		try {
			this.query = "UPDATE productos SET ID = " + Producto.getID() + " , Precio = '" + Producto.getPrecio()
			+ "', Marca = '" + Producto.getNombreMarca() + "', Nombre = '" + Producto.getNombre()
			+ "', Descripcion = '" + Producto.getDescripcion() + "', Activo = " + Producto.isActivo() + " WHERE ID = " + IDOriginal;

			row = super.conectarUpdate();

		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se encuentra esa marca";
			}

			return e.getMessage();
		}
		if (row == 0) {
			return "El ID esta vacio";
		}
		return "Exito";
	}
	
	public String MostrarHistorialProducto() {

		try {
			this.query = "SELECT * FROM Productos";
			this.transfer = new Transfer(super.conectarExecute());

		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}
	
	public String Buscar() {
		try {
			this.query = "SELECT * FROM productos WHERE ID = " + Producto.getID();
			this.transfer = new Transfer( super.conectarExecute());
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Exito";

	}

	public ResultSet getResultSet() {
		return this.resultado;
	}

	
}
