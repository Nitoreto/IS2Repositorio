package factoryController;

import DAO_Conexion.DAOSucursal;
import Transfer.TransferSucursal;

public class ControllerSucursal extends ObjectController{
	private DAOSucursal DAOs;
	private TransferSucursal tSucursal;

	public ControllerSucursal() {
		super("ControllerSucursal");

	}
	
	@Override
	protected void inicializarController(String[] datos) throws Exception{
		this.DAOs = new DAOSucursal();
		this.tSucursal = new TransferSucursal(datos);		
	}

	@Override
	public Boolean alta() {
		try {
			DAOs.alta(tSucursal);
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
			DAOs.baja(tSucursal.getDNI());
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
			DAOs.modificar(tSucursal, DNI);
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
			tSucursal = DAOs.listar();
			mediator.actualizarTabla(tSucursal.generarTabla(), tSucursal.generarTitulos());
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
			tSucursal = DAOs.buscar(tSucursal.getDNI());
			mediator.actualizarTabla(tSucursal.generarTabla(), tSucursal.generarTitulos());
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
			DAOs.desactivar(tSucursal.getDNI());
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
