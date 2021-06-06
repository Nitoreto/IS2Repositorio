 package factoria;

import DAOClientes.DAOBuscarCliente;
import DAOClientes.DAOCrearCliente;
import DAOClientes.DAODesactivarCliente;
import DAOClientes.DAOEliminarCliente;
import DAOClientes.DAOListarClientes;
import DAOClientes.DAOModificarCliente;
import main.Controlador;

public class ControladorCliente extends ShopObject {

	private String nombre, DNI;
	private int telefono;
	private Boolean activo;

	public ControladorCliente() {
		super("ControladorCliente");
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public int getActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}

	@Override
	public String alta() {
		DAOCrearCliente dao = new DAOCrearCliente(this);
		return dao.conectar();

	}

	@Override
	public String baja() {
		DAOEliminarCliente dao = new DAOEliminarCliente(this);
		return dao.conectar();
	}

	@Override
	public String modificar(String ID) {
		DAOModificarCliente dao = new DAOModificarCliente(this, ID);
		return dao.conectar();

	}

	@Override
	public String listar(Controlador controlador) {
		DAOListarClientes dao = new DAOListarClientes(this);
		String string = dao.conectar();
		if(string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Abstract");
		return string;

	}

	@Override
	public String buscar(Controlador controlador) {
		// TODO Auto-generated method stub
		DAOBuscarCliente dao = new DAOBuscarCliente(this);
		String string = dao.conectar();
		if(string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Default");
		return string;

	}

	@Override
	public String desactivar() {
		DAODesactivarCliente dao = new DAODesactivarCliente(this);
		return dao.conectar();
	}


	@Override
	public void inicializarObjeto(String[] datos) throws NumberFormatException{
		for (int i = 0; i < datos.length; i++) {
			switch (i) {
			case 0:
				DNI = datos[0];
				break;
			case 1:
				nombre = datos[1];
				break;
			case 2:
				telefono = Integer.parseInt(datos[2]);
				break;
			case 3:
				if (datos[3].equals("1")) {
					activo = true;
				} else if(datos[3].equals("0")){
					activo = false;
				}else{
					throw new NumberFormatException();
				}
			}
		}
	}

	@Override
	public String mostrarHistorial(Controlador controlador) {
		// TODO Auto-generated method stub
		return null;
	}

}