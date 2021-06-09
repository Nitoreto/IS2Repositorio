package factoryController;

import DAO_Conexion.DAOClientes;
import Transfer.TransferCliente;
import main.Mediator;

public class ControllerCliente extends ObjectController {
	private DAOClientes DAOc;
	private TransferCliente tCliente;
	private Mediator mediator;

	public ControllerCliente() {
		super("ControllerCliente");

	}
	
	@Override
	protected void inicializarTransfer(String[] datos, Mediator mediator) throws Exception{
		this.DAOc = new DAOClientes();
		this.tCliente = new TransferCliente(datos);		
		this.mediator = mediator;
	}

	@Override
	public Boolean alta() {
		try {
			DAOc.alta(tCliente);
			mediator.avisarCorrecto();
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
			mediator.avisarCorrecto();
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
			mediator.avisarCorrecto();
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
			mediator.avisarCorrecto();
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
			mediator.avisarCorrecto();
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
			mediator.avisarCorrecto();
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