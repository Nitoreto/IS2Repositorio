package factoryController;

import main.Mediator;

public class FactoryController {
	static ObjectController[] listaObjetos = {new ControllerSucursal(), new ControllerMarca(), new ControllerCliente(), new ControllerEmpleado(), new ControllerProducto(), new ControllerVenta() };

	static public ObjectController FactoriaParse(String nombre, String[] datos, Mediator mediator) {
		for (ObjectController object : FactoryController.listaObjetos) {
			if (object.esEsteShopObject(nombre, datos,mediator) != null) {
				return object;
			}
		}
		return null;
	}
}
