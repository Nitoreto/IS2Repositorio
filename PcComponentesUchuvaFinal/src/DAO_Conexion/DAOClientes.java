package DAO_Conexion;

import java.sql.SQLException;

import Transfer.Transfer;
import Transfer.TransferCliente;
import factoryController.ControllerCliente;

public class DAOClientes {
	private SingletonConexion conexion;

	public DAOClientes() throws SQLException {
		this.conexion=SingletonConexion.obtenerConexion();
	}

	public TransferCliente buscar(String DNI) throws SQLException {
		String query = "SELECT * FROM Cliente WHERE DNI = '" + DNI + "'";
		TransferCliente tCliente = new TransferCliente(conexion.conectarExecute(query));
		return tCliente;
	}

	public Boolean alta(TransferCliente tCliente) throws Exception, SQLException {
		if (tCliente.equals("")) {
			throw new Exception("Campo dni esta vacio");
		}
		String query = "INSERT into Cliente (DNI, Nombre, Telefono, Activo) VALUES " + "('" + tCliente.getDNI() + "', '"
				+ tCliente.getNombre() + "', '" + tCliente.getTelefono() + "', '" + tCliente.getActivo() +"')";
		conexion.conectarUpdate(query);
		return true;
	}

	public Boolean eliminar(String DNI)throws Exception,SQLException {
		int row = -1;
		String query = "DELETE  FROM Cliente WHERE DNI = '" + DNI + "'";
		row = conexion.conectarUpdate(query);
		if (row == 0) {
			throw new Exception("No se ha encontrado un cliente con ese DNI");
		}
		return true;

	}

	public Boolean desactivar(String DNI) throws Exception, SQLException {
		int row = -1;
		String query = "UPDATE Cliente SET Activo = 0 WHERE DNI = '" + DNI + "'";
		row = conexion.conectarUpdate(query);
		if (row == 0) {
			throw new Exception("DNI no Encontrado");
		}
		return true;
	}


	public TransferCliente listar() throws SQLException {
		String query = "SELECT * FROM Cliente";
		TransferCliente tCliente = new TransferCliente(conexion.conectarExecute(query));
		return tCliente;
	}

	public Boolean modificar(TransferCliente tCliente, String DNI) throws Exception, SQLException {
		int row = -1;
		String query = "UPDATE Cliente SET DNI = '" + tCliente.getDNI() + "', Nombre = '" + tCliente.getNombre()
		+ "', Telefono = " + tCliente.getTelefono() + ", Activo = " + tCliente.getActivo() + " WHERE DNI = '"
		+ DNI + "'";
		row = conexion.conectarUpdate(query);
		if (row == 0) {
			throw new Exception("Los campos estan vacios.");
		}
		return true;
	}

}
