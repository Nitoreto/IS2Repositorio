package factoryController;

import DAOProductos.DAOAltaProducto;
import DAOProductos.DAOBajaProducto;
import DAOProductos.DAODesactivarProducto;
import DAOProductos.DAOModificarProducto;
import DAOProductos.DAOMostrarHistorialProducto;
import DAOProductos.DAOMostrarProducto;
import main.Mediator;

public class ControllerProducto extends ObjectController {

	
	public ControllerProducto() {
		super("ControllerProducto");
	}
	

	@Override
	public String alta() {
		// TODO Auto-generated method stub
		DAOAltaProducto dao = new DAOAltaProducto(this);
		return dao.Conectar();

	}

	@Override
	public String baja() {
		// TODO Auto-generated method stub
		DAOBajaProducto dao = new DAOBajaProducto(this);
		return dao.Conectar();
	}

	@Override
	public String modificar(String ID) {
		// TODO Auto-generated method stub
		DAOModificarProducto dao = new DAOModificarProducto(this, ID);
		return dao.Conectar();
	}

	@Override
	public String listar(Mediator controlador) {
		// TODO Auto-generated method stub
		DAOMostrarHistorialProducto dao = new DAOMostrarHistorialProducto(this);
		String string = dao.conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Abstract");
		return string;
	}

	@Override
	public String buscar(Mediator controlador) {
		// TODO Auto-generated method stub
		DAOMostrarProducto dao = new DAOMostrarProducto(this);
		String string = dao.Conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Default");
		return string;
	}
	
	@Override
	public String desactivar() {
		DAODesactivarProducto dao = new DAODesactivarProducto(this);
		return dao.conectar();
	}

	@Override
	public String mostrarHistorial(Mediator controlador) {
		// TODO Auto-generated method stub
		return null;
	}



}