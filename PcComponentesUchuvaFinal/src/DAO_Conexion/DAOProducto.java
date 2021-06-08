package DAO_Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import Transfer.Transfer;
import factoryController.ControllerProducto;

public class DAOProducto {
	ResultSet resultado;

	public DAOProducto(ControllerProducto Producto) {
		super();

	}

	public String Alta() {
		try {
			this.query = "INSERT into Product (IDp, Nombre, Precio, Descripcion, Activo) VALUES " + "( "
					+ ControllerProducto.getID() + " ,'" + ControllerProducto.getNombre() + "', '"
					+ ControllerProducto.getPrecio() + "', '" + ControllerProducto.getNombre() + "', '"
					+ ControllerProducto.getDescripcion() + "'," + ControllerProducto.isActivo() + " )";
			super.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}

		return "Exito";
	}

	public String Baja() {
		int row = -1;
		try {
			this.query = "DELETE FROM Product WHERE IDp = " + ControllerProducto.getID();
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
			this.query = "UPDATE Product SET Activo = 0 WHERE IDp = " + producto.getID();
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
			this.query = "UPDATE Product SET IDp = " + ControllerProducto.getID() + ", Nombre = '"
					+ ControllerProducto.getNombre() + "' , Precio = " + ControllerProducto.getPrecio()
					+ ", Descripcion = '" + ControllerProducto.getDescripcion() + "', Activo = "
					+ ControllerProducto.isActivo() + " WHERE IDp = " + IDOriginal;

			row = super.conectarUpdate();

		} catch (Exception e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
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
			this.query = "SELECT * FROM Have";
			this.transfer = new Transfer(super.conectarExecute());

		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}

	public String Buscar() {
		try {
			this.query = "SELECT * FROM Product WHERE IDp = " + ControllerProducto.getID();
			this.transfer = new Transfer(super.conectarExecute());
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Exito";

	}

	public ResultSet getResultSet() {
		return this.resultado;
	}

}
