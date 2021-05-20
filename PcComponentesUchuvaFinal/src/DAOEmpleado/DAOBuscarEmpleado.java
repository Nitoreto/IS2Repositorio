package DAOEmpleado;

import java.sql.SQLException;
import DAOAndTransfer.DAOSuper;
import DAOAndTransfer.Transfer;
import factoria.Empleado;

public class DAOBuscarEmpleado extends DAOSuper {

	public DAOBuscarEmpleado(Empleado E1) {
		super();
		this.query = "SELECT * FROM empleados WHERE ID_Empleado = " + E1.getId_empleado();
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
