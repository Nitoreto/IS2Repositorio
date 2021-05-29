package DAOProductos;

import java.sql.SQLException;

import dao_Transfer_Singelton.DAOSuper;
import factoria.Producto;

public class DAOAltaProducto extends DAOSuper {

	public DAOAltaProducto(Producto Producto) {
		super();
		this.query = "INSERT into `Productos` (`ID`, `Precio`, `Marca`, `Nombre`, `Descripcion`, `Activo`) VALUES " + "( "
				+ Producto.getID() + " ,'" + Producto.getPrecio() + "', '" + Producto.getNombreMarca() +  "', '" + Producto.getNombre() + "', '"
				+ Producto.getDescripcion() + "', '1' )";
	}

	public String Conectar() {
		try {
			super.conectarUpdate();
		} catch (SQLException e) {
			return e.getMessage();
		}

		return "Exito";
	}

}