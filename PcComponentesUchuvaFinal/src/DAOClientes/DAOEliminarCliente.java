package DAOClientes;

import java.sql.SQLException;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import DAOAndTransfer.DAOSuper;
import factoria.Cliente;

public class DAOEliminarCliente extends DAOSuper {

	public DAOEliminarCliente(Cliente cliente) {
		super();
		this.query = "DELETE  FROM clientes WHERE DNI = '" + cliente.getDNI() + "'";

	}

	public String conectar() {
		int row = -1;
		try {
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

}