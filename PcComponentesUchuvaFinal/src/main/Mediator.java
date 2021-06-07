package main;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import factoryController.ControllerObject;
import factoryController.FactoryController;

public class Mediator {
	private TableModel modelo;
	private ControllerObject objeto;

	public String alta(String nombre, String[] Datos) {
		objeto = FactoryController.FactoriaParse(nombre, Datos);
		if (objeto == null) {
			return "Datos Incorrectos";
		}
		return objeto.alta();
	}

	public String baja(String nombre, String[] Datos) {
		objeto = FactoryController.FactoriaParse(nombre, Datos);
		if (objeto == null) {
			return "Datos Incorrectos";
		}
		return objeto.baja();
	}

	public String modificar(String nombre, String[] Datos, String ID) {
		objeto = FactoryController.FactoriaParse(nombre, Datos);
		if (objeto == null) {
			return "Datos Incorrectos";
		}
		return objeto.modificar(ID);
	}

	public String listar(String nombre) {
		String[] Datos = {};
		objeto = FactoryController.FactoriaParse(nombre, Datos);
		if (objeto == null) {
			return "Datos Incorrectos";
		}
		return objeto.listar(this);
	}

	public String buscar(String nombre, String[] Datos) {
		objeto = FactoryController.FactoriaParse(nombre, Datos);
		if(objeto == null){
			return "Datos Incorrectos";
		}
		return objeto.buscar(this);
	}

	public String mostrarHistorial(String nombre, String[] Datos) {
		objeto = FactoryController.FactoriaParse(nombre, Datos);
		if(objeto == null){
			return "Datos Incorrectos";
		}
		return objeto.mostrarHistorial(this);
	}
	
	public String desactivar(String nombre, String[] Datos) {
		objeto = FactoryController.FactoriaParse(nombre, Datos);
		if(objeto == null){
			return "Datos Incorrectos";
		}
		return objeto.desactivar();

	}

	public String generarTabla(Object[][] generarTabla, String[] generarTitulos, String Modelo) {

		if (Modelo.equalsIgnoreCase("Default")) {
			modelo = new ModeloTablaEditable(generarTabla, generarTitulos);
		} else {
			modelo = new ModeloTabla(generarTabla, generarTitulos);
		}
		return "Exito";
	}

	public TableModel actualizarTabla() {
		return modelo;
	}

	public String cancelar() {

		modelo = new DefaultTableModel();

		if (objeto != null)
			objeto.close();
		return "Exito";
	}
}
