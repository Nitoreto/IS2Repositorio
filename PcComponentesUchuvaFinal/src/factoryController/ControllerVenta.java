package factoryController;

import java.util.Random;
import DAO_Conexion.DAOVentas;
import Transfer.TransferVenta;

public class ControllerVenta extends ObjectController {
	private DAOVentas DAOv;
	private TransferVenta tVenta;

	public ControllerVenta() {
		super("ControllerVenta");
	}
	
	@Override
	protected void inicializarController(String[] datos) throws Exception{
		this.DAOv = new DAOVentas();
		this.tVenta = new TransferVenta(datos);		
	}

	@Override
	public Boolean alta() {
		try {
			DAOv.alta(tVenta);
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
			DAOv.baja(tVenta.getDNI());
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
			DAOv.modificar(tVenta, DNI);
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
			tVenta = DAOv.listar();
			mediator.actualizarTabla(tVenta.generarTabla(), tVenta.generarTitulos());
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
			tVenta = DAOv.buscar(tVenta.getDNI());
			mediator.actualizarTabla(tVenta.generarTabla(), tVenta.generarTitulos());
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
			DAOv.desactivar(tVenta.getDNI());
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
