package DAOEmpleado;

import DAOAndTransfer.DAOSuper;
import factoria.Empleado;

public class DAODesactivarEmpleado extends DAOSuper {
	public DAODesactivarEmpleado(Empleado empleado) {
		super();
		this.query = "UPDATE empleados SET Activo = 0 WHERE ID_Empleado = " + empleado.getId_empleado();
	}

	public String conectar() {
		int row = -1;
		try {
			row = super.conectarUpdate();
		} catch (Exception e) {
			return e.getMessage();
		}
		if (row == 0) {
			return "ID no Encontrado";
		}
		return "Exito";
	}
}
