package factoryController;

public class FactoryController {
	static ObjectController[] listaObjetos = { new ControllerMarca(), new ControllerCliente(), new ControllerEmpleado(), new ControllerProducto(), new ControllerVenta() };

	static public ObjectController FactoriaParse(String nombre, String[] datos) {
		for (ObjectController object : FactoryController.listaObjetos) {
			if (object.esEsteShopObject(nombre, datos) != null) {
				return object;
			}
		}
		return null;
	}
}
