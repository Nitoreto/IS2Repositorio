package DAOClientes;


import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;
import dao_Transfer_Singelton.Transfer;
import factoria.Cliente;

public class DAOBuscarCliente extends DAOSuper {

	public DAOBuscarCliente(Cliente cliente) {
		super();
		this.query = "SELECT *FROM clientes WHERE DNI = '" + cliente.getDNI() + "'";
	}

	public String conectar() {
		try {
			this.transfer = new Transfer( super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";

	}
}

	
