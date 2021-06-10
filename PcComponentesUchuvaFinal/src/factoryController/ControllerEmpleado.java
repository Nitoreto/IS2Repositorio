package factoryController;

import DAO_Conexion.DAOEmpleado;
import Transfer.TransferEmpleado;
import main.Mediator;

public class ControllerEmpleado extends ObjectController {
	private DAOEmpleado DAOe;
	private TransferEmpleado tEmpleado;
	
	public ControllerEmpleado() {
		super("ControllerEmpleado");
	}
	
	@Override
	protected void inicializarController(String[] datos) throws Exception{
		this.DAOe = new DAOEmpleado();
		this.tEmpleado = new TransferEmpleado(datos);		
	}

	@Override
	public Boolean alta() {
		try {
			DAOe.alta(tEmpleado);
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
			DAOe.baja(tEmpleado.getDNI());
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
			DAOe.modificar(tEmpleado, DNI);
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
			tEmpleado = DAOe.listar();
			mediator.actualizarTabla(tEmpleado.generarTabla(), tEmpleado.generarTitulos());
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
			tEmpleado = DAOe.buscar(tEmpleado.getDNI());
			mediator.actualizarTabla(tEmpleado.generarTabla(), tEmpleado.generarTitulos());
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
			DAOe.desactivar(tEmpleado.getDNI());
			mediator.avisarCorrecto();
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}


	@Override
	public Boolean mostrarHistorial() {
		try {
			tEmpleado = DAOe.MuestraHistorialVentas(tEmpleado.getDNI());
			mediator.actualizarTabla(tEmpleado.generarTabla(), tEmpleado.generarTitulos());
			mediator.avisarCorrecto();
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}
}
