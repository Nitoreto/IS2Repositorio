package factoria;

public class Factoria {
	static ShopObject[] listaObjetos = { new Marca(), new Cliente(), new Empleado(), new Producto(), new Venta() };

	static public ShopObject FactoriaParse(String nombre, String[] datos) {
		for (ShopObject object : Factoria.listaObjetos) {
			if (object.esEsteShopObject(nombre, datos) != null) {
				return object;
			}
		}
		return null;
	}

}
