package DAOEmpleado;

import java.sql.SQLException;

import DAOAndTransfer.DAOSuper;
import factoria.Empleado;
import DAOAndTransfer.Transfer;

public class DAOListaEmpleados extends DAOSuper {

	public DAOListaEmpleados(Empleado E1) {
		super();
		this.query = "SELECT * FROM empleados";
	}

	public String conectar() {
		try {
			this.transfer = new Transfer(super.conectarExecute());
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}
}