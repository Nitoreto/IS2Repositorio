package factoryController;

import DAOEmpleado.DAOAñadirEmpleado;
import DAOEmpleado.DAOBuscarEmpleado;
import DAOEmpleado.DAODesactivarEmpleado;
import DAOEmpleado.DAOEliminarEmpleado;
import DAOEmpleado.DAOListaEmpleados;
import DAOEmpleado.DAOModificarEmpleado;
import DAOEmpleado.DAOMuestraHistorialEmpleado;
import main.Mediator;

public class ControllerEmpleado extends ObjectController {
	private String name, apellido, dni, direccion;
	private int telefono, id_empledo;
	private Boolean activo;

	public ControllerEmpleado() {
		super("ControllerEmpleado");
	}

	public String getName() {
		return this.name;
	}

	public String getApell() {
		return this.apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public String getDir() {
		return this.direccion;
	}

	public int getNumero() {
		return this.telefono;
	}

	public int getId_empleado() {
		return this.id_empledo;
	}

	public int getActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}

	@Override
	public String alta() {
		DAOAñadirEmpleado dao = new DAOAñadirEmpleado(this);
		return dao.conectar();
	}

	@Override
	public String baja() {
		DAOEliminarEmpleado dao = new DAOEliminarEmpleado(this);
		return dao.conectar();

	}

	@Override
	public String modificar(String ID) {
		DAOModificarEmpleado dao = new DAOModificarEmpleado(this, ID);
		return dao.conectar();

	}

	@Override
	public String listar(Mediator controlador) {
		DAOListaEmpleados dao = new DAOListaEmpleados(this);
		String string = dao.conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Abstract");
		return string;
	}

	@Override
	public String buscar(Mediator controlador) {
		DAOBuscarEmpleado dao = new DAOBuscarEmpleado(this);
		String string = dao.conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Default");
		return string;
	}

	@Override
	public String mostrarHistorial(Mediator controlador) {
		DAOMuestraHistorialEmpleado dao = new DAOMuestraHistorialEmpleado(this);
		String string = dao.conectar();
		controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Default");
		return string;
	}
	
	@Override
	public String desactivar() {
		DAODesactivarEmpleado dao = new DAODesactivarEmpleado(this);
		return dao.conectar();
	}

	@Override
	public void inicializarObjeto(String[] datos)throws NumberFormatException {
		for (int i = 0; i < datos.length; i++) {
			switch (i) {
			case 0:
				id_empledo = Integer.parseInt(datos[0]);
				break;
			case 1:
				name = datos[1];
				break;
			case 2:
				apellido = datos[2];
				break;
			case 3:
				dni = datos[3];
				break;
			case 4:
				direccion = datos[4];
				break;
			case 5:
				telefono = Integer.parseInt(datos[5]);
				break;
			case 6:
				if (datos[6].equals("1")) {
					activo = true;
				} else if(datos[6].equals("0")){
					activo = false;
				}else{
					throw new NumberFormatException();
				}
				break;
			}
		}

	}

}
