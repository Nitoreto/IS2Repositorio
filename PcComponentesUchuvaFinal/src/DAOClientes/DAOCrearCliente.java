package DAOClientes;

import dao_Transfer_Singelton.DAOSuper;
import factoria.Cliente;

public class DAOCrearCliente extends DAOSuper {
	private String DNI;
	
	public DAOCrearCliente(Cliente cliente) {
		super();
		this.DNI = cliente.getDNI();
		this.query = "INSERT into clientes (`Nombre`, `DNI`, `Telefono`) VALUES " + "('" + cliente.getNombre()
				+ "', '" + cliente.getDNI() + "', '" + cliente.getTelefono() + "')";
	}

	public String conectar() {
		try {

			if (DNI.equals("")) {
				throw new Exception("Campo dni esta vacio");

			}

			super.conectarUpdate();

		} catch (Exception e) {
			return e.getMessage();
		}
		return "Exito";
	}

}
