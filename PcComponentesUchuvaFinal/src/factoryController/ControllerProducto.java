package factoryController;

import DAOProductos.DAOAltaProducto;
import DAOProductos.DAOBajaProducto;
import DAOProductos.DAODesactivarProducto;
import DAOProductos.DAOModificarProducto;
import DAOProductos.DAOMostrarHistorialProducto;
import DAOProductos.DAOMostrarProducto;
import main.Mediator;

public class ControllerProducto extends ControllerObject {

	private String  Nombre, Descripcion, NombreMarca;
	private int ID;
	private float Precio;
	private Boolean Activo;

	public ControllerProducto() {
		super("ControllerProducto");
	}

	public int getID() {
		return ID;
	}

	public String getNombreMarca() {
		return NombreMarca;
	}

	public float getPrecio() {
		return Precio;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public int isActivo() {
		int valor = this.Activo ? 1 : 0;
		return valor;
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
	public void inicializarObjeto(String[] Datos)throws NumberFormatException{
		// TODO Auto-generated method stub

		for (int i = 0; i < Datos.length; i++) {
			switch (i) {
			case 0:
				ID = Integer.parseInt(Datos[0]);
				break;
			case 1:
				Nombre = Datos[1];
				break;
			case 2:
				NombreMarca = Datos[2];
				break;
			case 3:
				Descripcion = Datos[3];
				break;
			case 4:
				Precio = Float.parseFloat(Datos[4]);
				break;
			case 5:
				if (Datos[5].equals("1")) {
					Activo = true;
				} else if(Datos[5].equals("0")){
					Activo = false;
				}else{
					throw new NumberFormatException();
				}
				break;
			}
		}
	}

	@Override
	public String mostrarHistorial(Mediator controlador) {
		// TODO Auto-generated method stub
		return null;
	}



}