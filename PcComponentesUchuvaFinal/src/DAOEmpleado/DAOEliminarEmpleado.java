package DAOEmpleado;

import java.sql.SQLException;

import DAOAndTransfer.DAOSuper;
import factoria.Empleado;

public class DAOEliminarEmpleado extends DAOSuper {

	public DAOEliminarEmpleado(Empleado E1) {
		super();
		this.query = "DELETE FROM empleados WHERE ID_Empleado = " + E1.getId_empleado() + "";
	}

	public String conectar() {
		int row = -1;
		try {
			row = this.conectarUpdate();
		} catch (SQLException e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede borrar un empleado con ventas";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "No se ha encontrado un empleado con ese DNI";
		}
		return "Exito";

	}

}
