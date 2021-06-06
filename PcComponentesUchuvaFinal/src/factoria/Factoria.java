package factoria;

public class Factoria {
	static ShopObject[] listaObjetos = { new ControladorMarca(), new ControladorCliente(), new ControladorEmpleado(), new ControladorProducto(), new ControladorVenta() };

	static public ShopObject FactoriaParse(String nombre, String[] datos) {
		for (ShopObject object : Factoria.listaObjetos) {
			if (object.esEsteShopObject(nombre, datos) != null) {
				return object;
			}
		}
		return null;
	}

}
