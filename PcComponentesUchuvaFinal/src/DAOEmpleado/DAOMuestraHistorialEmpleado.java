package DAOEmpleado;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;
import dao_Transfer_Singelton.Transfer;
import factoria.Empleado;

public class DAOMuestraHistorialEmpleado extends DAOSuper {

	public DAOMuestraHistorialEmpleado(Empleado E1) {
		super();
		this.query = "SELECT E.id_empleado, E.Nombre, V.id_ventas FROM empleado E JOIN ventas V ON E.id_empleado = V.id_empleado WHERE DNI = "
				+ E1.getDni() + "";
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