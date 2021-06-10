package factoryController;

import DAO_Conexion.DAOMarca;
import Transfer.TransferMarca;

public class ControllerMarca extends ObjectController {
	private DAOMarca DAOm;
	private TransferMarca tMarca;

	public ControllerMarca() {
		super("ControllerMarca");
	}

	@Override
	protected void inicializarTransfer(String[] datos) throws Exception {
		this.DAOm = new DAOMarca();
		this.tMarca = new TransferMarca(datos);
	}

	@Override
	public Boolean alta() {
		try {
			DAOm.alta(tMarca);
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
			DAOm.baja(tMarca.getCIFMarca());
			mediator.avisarCorrecto();
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean modificar(String CIFMarca) {
		try {
			DAOm.modificar(tMarca, CIFMarca);
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
			tMarca = DAOm.listar();
			mediator.actualizarTabla(tMarca.generarTabla(), tMarca.generarTitulos());
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
			tMarca = DAOm.buscar(tMarca.getCIFMarca());
			mediator.actualizarTabla(tMarca.generarTabla(), tMarca.generarTitulos());
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
			DAOm.desactivar(tMarca.getCIFMarca());
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
