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
			mediator.avisarCorrecto("Se ha dado de alta el sucursal");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean baja() {
		try {
			DAOs.baja(tSucursal.getID());
			mediator.avisarCorrecto("Se ha dado de baja el sucursal");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean modificar(String ID) {
		try {
			DAOs.modificar(tSucursal, ID);
			mediator.avisarCorrecto("Se ha modificado el sucursal");
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
			mediator.avisarCorrecto("Se ha listado la sucursal");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean buscar() {
		try {
			tSucursal = DAOs.buscar(tSucursal.getID());
			mediator.actualizarTabla(tSucursal.generarTabla(), tSucursal.generarTitulos());
			mediator.avisarCorrecto("Se buscado el sucursal");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}

	}

	@Override
	public Boolean desactivar() {
		try {
			DAOs.desactivar(tSucursal.getID());
			mediator.avisarCorrecto("Se ha desactivado el sucursal");
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
