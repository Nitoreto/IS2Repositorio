package DAOEmpleado;

import dao_Transfer_Singelton.DAOSuper;
import factoria.Empleado;

public class DAOModificarEmpleado extends DAOSuper {

	public DAOModificarEmpleado(Empleado E1, String ID_Empleado) {
		super();
		this.query = "UPDATE empleados SET ID_Empleado = " + E1.getId_empleado() + "," + "Nombre = '" + E1.getName()
				+ "', " + "Apellidos = '" + E1.getApell() + "',  " + "DNI = '" + E1.getDni() + "', " + "Direccion = '"
				+ E1.getDir() + "', " + "Telefono = " + E1.getNumero() + " , Activo = " + E1.getActivo() + " WHERE ID_Empleado = " + ID_Empleado;
	}

	public String conectar() {

		int row = -1;
		try {
			row = super.conectarUpdate();
		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede modificar el ID de un empleado con ventas";
			}
			return e.getMessage();
		}
		if (row == 0) {
			return "No hay cambios";
		}
		return "Exito";
	}
}