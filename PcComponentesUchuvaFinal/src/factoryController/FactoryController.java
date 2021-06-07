package factoryController;

public class FactoryController {
	static ControllerObject[] listaObjetos = { new ControllerMarca(), new ControllerCliente(), new ControllerEmpleado(), new ControllerProducto(), new ControllerVenta() };

	static public ControllerObject FactoriaParse(String nombre, String[] datos) {
		for (ControllerObject object : FactoryController.listaObjetos) {
			if (object.esEsteShopObject(nombre, datos) != null) {
				return object;
			}
		}
		return null;
	}

}
