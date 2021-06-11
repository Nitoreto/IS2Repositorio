package main;

import Model.Observer;
import factoryController.ObjectController;
import factoryController.FactoryController;

public class Mediator {
	private ObjectController controller;
	private Observer observer;

	public void asignarObserver(Observer vista) {
		this.observer = vista;
	}

	public void alta(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos, this);
		controller.alta();
	}

	public void baja(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos, this);
		controller.baja();
	}

	public void modificar(String nombre, String[] Datos, String ID) {
		controller = FactoryController.FactoriaParse(nombre, Datos, this);
		controller.modificar(ID);
	}

	public void listar(String nombre) {
		String[] Datos = {};
		controller = FactoryController.FactoriaParse(nombre, Datos, this);
		controller.listar();
	}

	public void buscar(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos, this);
		controller.buscar();
	}

	public void mostrarHistorial(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos, this);
		controller.mostrarHistorial();
	}

	public void desactivar(String nombre, String[] Datos) {
		controller = FactoryController.FactoriaParse(nombre, Datos, this);
		controller.desactivar();
	}

	public void actualizarTabla(Object[][] generarTabla, String[] generarTitulos) {
		observer.onTableChange(generarTabla, generarTitulos);

	}

	public void avisarError(String Error) {
		observer.onIncorrectMessage(Error);
		;
	}

	public void avisarCorrecto(String acierto) {
		observer.onCorrectMessage(acierto);
		;
	}
}
