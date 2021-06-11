package main;

import java.util.ArrayList;
import java.util.List;
import Model.Observer;
import factoryController.ObjectController;
import factoryController.FactoryController;

public class Mediator {
	private ObjectController controller;
	private List<Observer> observerList = new ArrayList<>();
	
	public void asignarObserver(Observer vista) {
		this.observerList.add(vista);
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
		for(Observer o: observerList) {
			o.onTableChange(generarTabla, generarTitulos);
		}
	}
	
	public void avisarError(String Error) {
		for(Observer o: observerList) {
			o.onIncorrectMessage(Error);;
		}
	}
	
	public void avisarCorrecto(String acierto) {
		for(Observer o: observerList) {
			o.onCorrectMessage(acierto);;
		}
	}
}
