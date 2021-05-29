package DAOClientes;

import dao_Transfer_Singelton.DAOSuper;
import factoria.Cliente;

public class DAODesactivarCliente extends DAOSuper {
	public DAODesactivarCliente(Cliente cliente) {
		super();
		this.query = "UPDATE clientes SET Activo = 0 WHERE DNI = '" + cliente.getDNI() + "'";
	}

	public String conectar() {
		int row = -1;
		try {
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "DNI no Encontrado";
		}
		return "Exito";
	}

}
