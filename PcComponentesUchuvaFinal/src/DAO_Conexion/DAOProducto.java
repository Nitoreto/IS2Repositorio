package DAO_Conexion;

import java.sql.SQLException;
import Transfer.TransferProducto;

public class DAOProducto {
	private SingletonConexion conexion;

	public DAOProducto() throws Exception {
		try {
			this.conexion = SingletonConexion.obtenerConexion();
		} catch (SQLException e) {
			throw new Exception("Error al conectar con la base de datos.");
		}
	}

	public Boolean alta(TransferProducto tProducto) throws Exception {
		String query = "INSERT into Producto (IDp, NombreMarca, Nombre, Precio, Descripcion, Activo) VALUES ( "
				+ tProducto.getID() + ", '" + tProducto.getNombreMarca() + "' ,'" + tProducto.getNombre() + "', "
				+ tProducto.getPrecio() + ", '" + tProducto.getDescripcion() + "'," + tProducto.isActivo() + ")";
		String query1 = "INSERT into Tiene (IDp, IDs) VALUES (" + tProducto.getID() + ", " + tProducto.getIdSucursal()
				+ ")";
		try {
			conexion.conectarUpdate(query);
			conexion.conectarUpdate(query1);
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;
	}

	public Boolean baja(int ID) throws Exception {
		try {
			int row = -1;
			String query = "DELETE FROM Producto WHERE IDp = " + ID;
			String query1 = "DELETE FORM Tiene WHERE IDp =" + ID;
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("Producto no encontrado");
			}
			row = conexion.conectarUpdate(query1);
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;
	}

	public Boolean bajaProductoSucursal(TransferProducto tProducto) throws Exception {
		try {
			int row = -1;
			String query = "DELETE FORM Tiene WHERE IDp = " + tProducto.getID() + " AND IDs = "
					+ tProducto.getIdSucursal();
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("Producto no encontrado");
			}
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;

	}

	public Boolean desactivar(int ID) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Producto SET Activo = 0 WHERE IDp = " + ID;
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("Producto no encontrado");
			}
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
		return true;
	}

	public Boolean modificar(TransferProducto tProducto, int ID) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Producto SET IDp = " + tProducto.getID() + ", Marca = '" + tProducto.getNombreMarca()
					+ "', Nombre = '" + tProducto.getNombre() + "' , Precio = " + tProducto.getPrecio()
					+ ", Descripcion = '" + tProducto.getDescripcion() + "', Activo = " + tProducto.isActivo()
					+ " WHERE IDp = " + ID;
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("Producto no encontrado");
			}
		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				throw new Exception("Producto no encontrado");
			}
		}
		return true;
	}

	public TransferProducto listar() throws Exception {

		try {
			String query = "SELECT * FROM Producto";
			TransferProducto tProducto = new TransferProducto(conexion.conectarExecute(query));
			return tProducto;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	public TransferProducto mostrarHistorialProducto(int ID) throws Exception {

		try {
			String query = "SELECT IDp, Nombre, NombreMarca, IDs, Precio, Descripcion, Activo FROM (Tiene h JOIN Producto p ON h.IDp = p.IDp) JOIN Marca m ON p.CIFm = m.CIF WHERE IDp = "
					+ ID;
			TransferProducto tProducto = new TransferProducto(conexion.conectarExecute(query));
			return tProducto;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	public TransferProducto buscar(int ID) throws Exception {
		try {
			String query = "SELECT * FROM Producto WHERE IDp = " + ID;
			TransferProducto tProducto = new TransferProducto(conexion.conectarExecute(query));
			return tProducto;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}
}
