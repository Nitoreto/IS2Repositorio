package DAOProductos;

import DAOAndTransfer.DAOSuper;
import factoria.Producto;

public class DAOModificarProducto extends DAOSuper {

	public DAOModificarProducto(Producto Producto, String IDOriginal) {
		super();
		this.query = "UPDATE productos SET ID = " + Producto.getID() + " , Precio = '" + Producto.getPrecio()
				+ "', Marca = '" + Producto.getNombreMarca() + "', Nombre = '" + Producto.getNombre()
				+ "', Descripcion = '" + Producto.getDescripcion() + "', Activo = " + Producto.isActivo() + " WHERE ID = " + IDOriginal;
	}

	public String Conectar() {
		int row = -1;
		try {

			row = super.conectarUpdate();

		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se encuentra esa marca";
			}

			return e.getMessage();
		}
		if (row == 0) {
			return "El ID esta vacio";
		}
		return "Exito";
	}

}