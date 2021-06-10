package DAO_Conexion;

import java.sql.SQLException;
import Transfer.TransferMarca;

public class DAOMarca {
	private SingletonConexion conexion;

	public DAOMarca() throws Exception {
		try {
			conexion = SingletonConexion.obtenerConexion();
		} catch (SQLException e) {
			throw new Exception("Error al conectar con la base de datos.");
		}
	}

	public Boolean alta(TransferMarca tMarca) throws Exception {
		try {
			String query = "INSERT into Marca (CIF, Nombre, Pais, Activo) VALUES " + "('" + tMarca.getCIFMarca() + "','"
					+ tMarca.getNombre() + "', '" + tMarca.getPais() + "'," + tMarca.getActivo() + ")";
			if (tMarca.getCIFMarca().equals("")) {
				throw new Exception("Campo CIF esta vacio");
			}
			conexion.conectarUpdate(query);
			return true;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean baja(String CIFMarca) throws Exception {
		try {
			int row = -1;
			String query = "DELETE FROM Marca WHERE CIF = '" + CIFMarca + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception(" El campos DNI esta vacio");
			}
			return true;
		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				throw new Exception("No se puede eliminar una marca con productos");
			}
			return false;
		}
	}

	public TransferMarca buscar(String CIFMarca) throws Exception {
		try {
			String query = "SELECT * FROM Marca WHERE CIF = '" + CIFMarca + "'";
			TransferMarca tMarca = new TransferMarca(conexion.conectarExecute(query));
			return tMarca;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean desactivar(String CIFMarca) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Marca SET Activo = 0 WHERE CIF = '" + CIFMarca + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("CIF no Encontrado");
			}
			return true;
		} catch (Exception e) {
			throw new Exception(e.getCause());
		}
	}

	public TransferMarca listar() throws Exception {
		try {
			String query = "SELECT * FROM Marca";
			TransferMarca tMarca = new TransferMarca(conexion.conectarExecute(query));
			return tMarca;
		} catch (SQLException e) {
			throw new Exception(e.getCause());
		}
	}

	public Boolean modificar(TransferMarca tMarca, String CIFMarca) throws Exception {
		try {
			int row = -1;
			String query = "UPDATE Marca SET CIF = '" + tMarca.getCIFMarca() + "' ,Nombre = '" + tMarca.getNombre()
					+ "', Pais = '" + tMarca.getPais() + "', Activo = " + tMarca.getActivo() + " WHERE CIF = '"
					+ CIFMarca + "'";
			row = conexion.conectarUpdate(query);
			if (row == 0) {
				throw new Exception("El CIF esta vacio.");
			}
			return true;
		} catch (SQLException e) {
			if (e.getClass().getName()
					.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				throw new Exception("No se puede cambiar el nombre de una marca con productos");
			}
			return null;
		}

	}
}
