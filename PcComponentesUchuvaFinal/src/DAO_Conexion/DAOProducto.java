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

		String query = "INSERT into Product (IDp, NombreMarca, Nombre, Precio, Descripcion, Activo) VALUES ( "
				+ tProducto.getId() + ", '" + tProducto.getNombreMarca() + "' ,'" + tProducto.getNombre() + "', "
				+ tProducto.getPrecio() + ", '" + tProducto.getDescripcion() + "'," + tProducto.isActivo() + ")";
		String query1 = "INSERT into Have(IDp, IDs) VALUES (" + tProducto.getId() + ", " + tProducto.getSucarusal()
				+ ")";
		try {
			conexion.conectarUpdate(query);
			conexion.conectarUpdate(query1);

		} catch (SQLException e) {
			return e.getMessage();
		}

		return "Exito";
	}

	public String Baja() {
		int row = -1;
		try {
			String query = "DELETE FROM Product WHERE IDp = " + tProducto.getId();
			String quety1 = "DELETE FORM Have WHERE IDp =" + tProducto.getId();
			row = this.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}
		if (row == 0) {
			return "Producto no encontrado";
		}
		return "Exito";

	} 
	public String BajaProductoSucursal() {
		int row = -1;
		try {
			String query = "DELETE FORM Have WHERE IDp = " + tProducto.getID() + " AND IDs = " + tProducto.getSucursal();
			row = this.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}
		if (row == 0) {
			return "Producto no encontrado";
		}
		return "Exito";

	} 
	

	public String Desactivar() {
		int row = -1;
		try {
			this.query = "UPDATE Product SET Activo = 0 WHERE IDp = " + tProducto.getID();
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "Producto no encontrado";
		}
		return "Exito";
	}

	public String Modificar() {
		int row = -1;
		try {
			this.query = "UPDATE Product SET IDp = " + tProducto.getID() + ", Marca = '" + tProducto.getMarca()
					+ "', Nombre = '" + tProducto.getNombre() + "' , Precio = " + tProducto.getPrecio()
					+ ", Descripcion = '" + tProducto.getDescripcion() + "', Activo = " + tProducto.isActivo()
					+ " WHERE IDp = " + IDOriginal;

			row = super.conectarUpdate();

		} catch (Exception e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "Producto no encontrado";
			}

			return e.getMessage();
		}
		if (row == 0) {
			return "Producto no encontrado";
		}
		return "Exito";
	}

	public String MostrarHistorialProducto() {

		try {
			this.query = "SELECT * FROM Have h JOIN Product p ON h.IDp = p.IDp WHERE IDp = " + tProducto.getId();
			this.transfer = new Transfer(super.conectarExecute());

		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}

	public String Buscar() {
		try {
			this.query = "SELECT * FROM Product WHERE IDp = " + tProducto.getID();
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
