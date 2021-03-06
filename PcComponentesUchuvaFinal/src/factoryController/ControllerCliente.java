package factoryController;

import DAO_Conexion.DAOClientes;
import Transfer.TransferCliente;

public class ControllerCliente extends ObjectController {
	private DAOClientes DAOc;
	private TransferCliente tCliente;

	public ControllerCliente() {
		super("ControllerCliente");

	}
	
	@Override
	protected void inicializarController(String[] datos) throws Exception{
		this.DAOc = new DAOClientes();
		this.tCliente = new TransferCliente(datos);		
	}

	@Override
	public Boolean alta() {
		try {
			DAOc.alta(tCliente);
			mediator.avisarCorrecto("Se ha dado de alta el cliente");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean baja() {
		try {
			DAOc.baja(tCliente.getDNI());
			mediator.avisarCorrecto("Se ha dado de baja el cliente");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean modificar(String DNI) {
		try {
			DAOc.modificar(tCliente, DNI);
			mediator.avisarCorrecto("Se ha modificiado el cliente");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean listar() {
		try {
			tCliente = DAOc.listar();
			mediator.actualizarTabla(tCliente.generarTabla(), tCliente.generarTitulos());
			mediator.avisarCorrecto("Se ha listado el cliente");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean buscar() {
		try {
			tCliente = DAOc.buscar(tCliente.getDNI());
			mediator.actualizarTabla(tCliente.generarTabla(), tCliente.generarTitulos());
			mediator.avisarCorrecto("Se ha buscado el cliente");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}

	}

	@Override
	public Boolean desactivar() {
		try {
			DAOc.desactivar(tCliente.getDNI());
			mediator.avisarCorrecto("Se ha desactivado el cliente");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean mostrarHistorial() {
		return null;
	}
}