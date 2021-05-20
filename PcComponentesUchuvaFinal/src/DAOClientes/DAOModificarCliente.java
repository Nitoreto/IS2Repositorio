package DAOClientes;

import DAOAndTransfer.DAOSuper;
import factoria.Cliente;

public class DAOModificarCliente extends DAOSuper {

	public DAOModificarCliente(Cliente cliente, String DNI) {
		super();
		this.query = "UPDATE clientes SET nombre = '" + cliente.getNombre() + "', DNI = '" + cliente.getDNI()
				+ "', telefono = " + cliente.getTelefono() + ", Activo = " + cliente.getActivo() + " WHERE DNI = '"
				+ DNI + "'";
	}

	public String conectar() {
		int row = -1;
		try {
			row = super.conectarUpdate();
		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede modificar el DNI de un cliente con ventas";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "Los campos estan vacios.";
		}
		return "Exito";
	}

}