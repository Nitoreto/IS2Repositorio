package main;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import factoryController.ObjectController;
import factoryController.FactoryController;

public class Mediator {
	private ObjectController controller;

	public String alta(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos, this);
		if (controller == null) {
			return "Datos Incorrectos";
		}
		return controller.alta();
	}

	public String baja(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos);
		if (controller == null) {
			return "Datos Incorrectos";
		}
		return controller.baja();
	}

	public String modificar(String nombre, String[] Datos, String ID) {
		controller = FactoryController.FactoriaParse(nombre, Datos);
		if (controller == null) {
			return "Datos Incorrectos";
		}
		return controller.modificar(ID);
	}

	public String listar(String nombre) {
		String[] Datos = {};
		controller = FactoryController.FactoriaParse(nombre, Datos);
		if (controller == null) {
			return "Datos Incorrectos";
		}
		return controller.listar(this);
	}

	public String buscar(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos);
		if(controller == null){
			return "Datos Incorrectos";
		}
		return controller.buscar(this);
	}

	public String mostrarHistorial(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos);
		if(controller == null){
			return "Datos Incorrectos";
		}
		return controller.mostrarHistorial(this);
	}
	
	public String desactivar(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos);
		if(controller == null){
			return "Datos Incorrectos";
		}
		return controller.desactivar();

	}

	public void actualizarTabla(Object[][] generarTabla, String[] generarTitulos) {
		Esto solo pasa los datos, la vista se encarga de actualizar como crea.
		Pasar vista los datos.
	}
	
	public void avisarError(String Error) {
		Avisa a la vista del error
	}
	
	public void avisarCorrecto() {
		Avisa a la vista de que se hizo correctamente
	}

	public String cancelar() {

		modelo = new DefaultTableModel();

		if (controller != null)
			controller.close();
		return "Exito";
	}
}
