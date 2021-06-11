package factoryController;



import DAO_Conexion.DAOProducto;
import Transfer.TransferProducto;

public class ControllerProducto extends ObjectController {
	private DAOProducto DAOp;
	private TransferProducto tProducto;
	
	public ControllerProducto() {
		super("ControllerProducto");
	}
	
	@Override
	protected void inicializarController(String[] datos) throws Exception{
		this.DAOp = new DAOProducto();
		this.tProducto = new TransferProducto(datos);		
	}
	
	@Override
	public Boolean alta() {
		try {
			DAOp.alta(tProducto);
			mediator.avisarCorrecto("Se ha dado de alta producto");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean baja() {
		try {
			DAOp.baja(tProducto.getID());
			mediator.avisarCorrecto("Se ha dado de baja el producto");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean modificar(String ID) {
		try {
			DAOp.modificar(tProducto, Integer.parseInt(ID));
			mediator.avisarCorrecto("Se ha modificado el producto");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean listar() {
		try {
			tProducto = DAOp.listar();
			mediator.actualizarTabla(tProducto.generarTabla(), tProducto.generarTitulos());
			mediator.avisarCorrecto("Se ha lsitado el producto");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean buscar() {
		try {
			tProducto = DAOp.buscar(tProducto.getID());
			mediator.actualizarTabla(tProducto.generarTabla(), tProducto.generarTitulos());
			mediator.avisarCorrecto("Se ha buscado el producto");
			return true;
		} catch (Exception e) {
			mediator.avisarError(e.getMessage());
			return false;
		}

	}

	@Override
	public Boolean desactivar() {
		try {
			DAOp.desactivar(tProducto.getID());
			mediator.avisarCorrecto("Se ha desactivado el producto");
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