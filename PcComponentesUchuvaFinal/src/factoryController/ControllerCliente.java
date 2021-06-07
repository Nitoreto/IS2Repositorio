 package factoryController;

import DAOClientes.DAOBuscarCliente;
import DAOClientes.DAOCrearCliente;
import DAOClientes.DAODesactivarCliente;
import DAOClientes.DAOEliminarCliente;
import DAOClientes.DAOListarClientes;
import DAOClientes.DAOModificarCliente;
import main.Mediator;

public class ControllerCliente extends ControllerObject {

	private String nombre, DNI;
	private int telefono;
	private Boolean activo;

	public ControllerCliente() {
		super("ControllerCliente");
	}

	@Override
	public String alta() {
		DAOCrearCliente dao = new DAOCrearCliente(this);
		return dao.conectar();

	}

	@Override
	public String baja() {
		DAOEliminarCliente dao = new DAOEliminarCliente(this);
		return dao.conectar();
	}

	@Override
	public String modificar(String ID) {
		DAOModificarCliente dao = new DAOModificarCliente(this, ID);
		return dao.conectar();

	}

	@Override
	public String listar(Mediator controlador) {
		DAOListarClientes dao = new DAOListarClientes(this);
		String string = dao.conectar();
		if(string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Abstract");
		return string;

	}

	@Override
	public String buscar(Mediator controlador) {
		// TODO Auto-generated method stub
		DAOBuscarCliente dao = new DAOBuscarCliente(this);
		String string = dao.conectar();
		if(string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Default");
		return string;

	}

	@Override
	public String desactivar() {
		DAODesactivarCliente dao = new DAODesactivarCliente(this);
		return dao.conectar();
	}

	@Override
	public String mostrarHistorial(Mediator controlador) {
		// TODO Auto-generated method stub
		return null;
	}

}