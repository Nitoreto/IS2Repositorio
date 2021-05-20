package DAOEmpleado;

import java.sql.SQLException;

import DAOAndTransfer.DAOSuper;
import factoria.Empleado;

public class DAOAñadirEmpleado extends DAOSuper {
	private String DNI;

	public DAOAñadirEmpleado(Empleado E1) {
		super();
		DNI = E1.getDni();
		this.query = "INSERT into empleados (ID_Empleado, Nombre, Apellidos, DNI, Direccion, Telefono) " + "VALUES "
				+ "(" + E1.getId_empleado() + ",'" + E1.getName() + "','" + E1.getApell() + "','" + E1.getDni() + "','"
				+ E1.getDir() + "'," + E1.getNumero() + ")";
	}

	public String conectar() {
		try {
			if (DNI.equals("")) {
				return "Campo DNI esta vacio";
			}

			super.conectarUpdate();

		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Exito";
	}
}