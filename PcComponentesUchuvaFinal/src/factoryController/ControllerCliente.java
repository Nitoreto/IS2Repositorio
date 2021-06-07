 package factoryController;

import java.sql.SQLException;
import DAO_Conexion.DAOClientes;
import Transfer.TransferCliente;
import main.Mediator;

public class ControllerCliente extends ObjectController {
	private DAOClientes DAOc;
	private TransferCliente tCliente;

	public ControllerCliente() {
		super("ControllerCliente");
			
	}
	
	protected void inicializarTransfer(String[] datos) throws Exception{
		try {
			this.DAOc = new DAOClientes();
		} catch (SQLException e) {
			throw new Exception("Error al conectar con la base de datos.");
		}
		this.tCliente = new TransferCliente(datos);		
	}

	@Override
	public String alta(String[] Datos) {
		
		DAOc.alta(tCliente);

	}

	@Override
	public String baja() {
		DAOEliminarCliente dao = new DAOEliminarCliente(this);
		if (e.getClass().getName()
				.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
			return "No se puede borrar un cliente con ventas";
		}
		return dao.conectar();
	}

	@Override
	public String modificar(String ID) {
		DAOModificarCliente dao = new DAOModificarCliente(this, ID);
		 catch (Exception e) {
				if (e.getClass().getName()
						.equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
					return "No se puede modificar el DNI de un cliente con ventas";
				}
				return e.getMessage();
			}
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