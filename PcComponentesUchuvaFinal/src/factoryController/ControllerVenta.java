package factoryController;

import java.util.Random;

import main.Mediator;
import DAOVentas.DAODesactivarVenta;
import DAOVentas.DAOEliminarVenta;
import DAOVentas.DAOListarVenta;
import DAOVentas.DAOModificarVenta;
import DAOVentas.DAOMostrarVenta;
import DAOVentas.DAORegistrarVenta;
import factoryController.ObjectController;

public class ControllerVenta extends ObjectController {

	private int idVentas, idEmpleado, precioTotal;
	private String DNICliente, listaProductos;
	private Boolean activo;

	public ControllerVenta() {
		super("ControllerVenta");

	}

	public int idRandom() {
		Random r = new Random();
		return r.nextInt(1000000);
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public int getIdVentas() {
		return idVentas;
	}

	public String getDNICliente() {
		return DNICliente;
	}

	public String getListaProductos() {
		return listaProductos;
	}

	public int getActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}

	@Override
	public String alta() {
		DAORegistrarVenta dao = new DAORegistrarVenta(this);
		return dao.conectar();

	}

	@Override
	public String baja() {
		DAOEliminarVenta dao = new DAOEliminarVenta(this);
		return dao.conectar();
	}

	@Override
	public String modificar(String ID) {
		DAOModificarVenta dao = new DAOModificarVenta(this, Integer.parseInt(ID));
		return dao.conectar();

	}

	@Override
	public String listar(Mediator controlador) {
		DAOListarVenta dao = new DAOListarVenta(this);
		String string = dao.conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Abstract");
		return string;

	}

	@Override
	public String buscar(Mediator controlador) {

		DAOMostrarVenta dao = new DAOMostrarVenta(this);
		String string = dao.conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Default");
		return string;

	}

	@Override
	public String desactivar() {
		DAODesactivarVenta dao = new DAODesactivarVenta(this);
		return dao.conectar();
	}
	
	@Override
	public void inicializarObjeto(String[] datos) throws NumberFormatException {

		for (int i = 0; i < datos.length; i++) {
			switch (i) {

			case 0:
				if (datos[0].equalsIgnoreCase("rand")) {
					idVentas = idRandom();
				} else {
					this.idVentas = Integer.parseInt(datos[0]);
				}
				break;
			case 1:
				this.DNICliente = datos[1];
				break;
			case 2:
				this.idEmpleado = Integer.parseInt(datos[2]);
				break;
			case 3:
				this.listaProductos = datos[3];
				break;
			case 4:
				this.precioTotal = Integer.parseInt(datos[4]);
				break;
			case 5:
				if (datos[5].equals("1")) {
					activo = true;
				} else if(datos[5].equals("0")){
					activo = false;
				}else{
					throw new NumberFormatException();
				}
				break;
			}
		}
	}

	@Override
	public String mostrarHistorial(Mediator controlador) {
		DAOListarVenta dao = new DAOListarVenta(this);
		String string = dao.conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Abstract");
		return string;

	}

}
